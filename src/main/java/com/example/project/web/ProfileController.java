package com.example.project.web;

import com.example.project.model.binding.RatingBindingModel;
import com.example.project.model.binding.UserProfileBindingModel;
import com.example.project.model.service.UserProfileServiceModel;
import com.example.project.service.HotelService;
import com.example.project.service.RatingService;
import com.example.project.service.UserService;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    public ProfileController(UserService userService, RatingService ratingService, HotelService hotelService, ModelMapper modelMapper) {
        this.userService = userService;
        this.ratingService = ratingService;
        this.hotelService = hotelService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/users/excursions/{username}")
    public String getExcursionsForUser(Model model, @PathVariable String username){
        model.addAttribute("bookings",userService.getAllExcursionBookings(username));
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


    @GetMapping("/users/destinations/{username}")
    public String getDestinationsForUser(Model model, @PathVariable String username){
        model.addAttribute("destinations",userService.getAllHotelBookings(username));
        model.addAttribute("username",username);

        return "user-destinations";
    }

    @GetMapping("/users/profile/{username}")
    public String viewProfile(Model model, @PathVariable String username){
        model.addAttribute("user", userService.mapUserToBindingModel(username));
        model.addAttribute("username", username);
        return "user-profile";
    }



    @GetMapping("/users/profile/{username}/edit")
    public String editProfile(Model model, @PathVariable String username){
        if(!model.containsAttribute("userProfileBindingModel")) {
            model.addAttribute("userProfileBindingModel", userService.mapUserToBindingModel(username));
        }
        model.addAttribute("username", username);

        return "profile-edit";
    }

    @PostMapping("/users/profile/{username}/edit")
    public String editProfile(@Valid UserProfileBindingModel userProfileBindingModel,
                         BindingResult bindingResult,
                         @PathVariable String username,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userProfileBindingModel", userProfileBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userProfileBindingModel", bindingResult);
            return String.format("redirect:/users/profile/%s/edit",username);
        }
        userService.editUser(username, modelMapper.map(userProfileBindingModel, UserProfileServiceModel.class));
        return "redirect:/users/profile/{username}";

    }
}
