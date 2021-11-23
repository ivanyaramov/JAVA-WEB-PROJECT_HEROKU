package com.example.project.web;

import com.example.project.model.binding.RatingBindingModel;
import com.example.project.model.entity.UserEntity;
import com.example.project.service.HotelService;
import com.example.project.service.RatingService;
import com.example.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProfileController {
    private final UserService userService;
    private final RatingService ratingService;
    private final HotelService hotelService;

    public ProfileController(UserService userService, RatingService ratingService, HotelService hotelService) {
        this.userService = userService;
        this.ratingService = ratingService;
        this.hotelService = hotelService;
    }

    @GetMapping("/users/excursions/{username}")
    public String getExcursionsForUser(Model model, @PathVariable String username){
        UserEntity user = userService.findByUsername(username);
        model.addAttribute("bookings",userService.getAllExcursionBookings(user));
        model.addAttribute("username",username);

        return "user-excursions";
    }

    @ModelAttribute
    public RatingBindingModel ratingBindingModel(){
        return new RatingBindingModel();
    }

    @PostMapping("/users/excursions/{username}/{bookingid}")
    public String rating(@Valid RatingBindingModel ratingBindingModel,
                         BindingResult bindingResult,
                         @PathVariable String username,
                         @PathVariable Long bookingid,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("ratingBindingModel", ratingBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.ratingBindingModel", bindingResult);
            return String.format("redirect:/users/excursions/%s",username);
        }
ratingService.createRating(username, bookingid, ratingBindingModel);
        return String.format("redirect:/users/excursions/%s",username);

    }


    @GetMapping("/users/destinations/{id}")
    public String getDestinationsForUser(Model model, @PathVariable Long id){
        UserEntity user = userService.findById(id);
        model.addAttribute("destinations",userService.getAllHotelBookings(user));
        model.addAttribute("userid",id);

        return "user-destinations";
    }
}
