package com.example.project.web;

import com.example.project.model.binding.RatingBindingModel;
import com.example.project.model.entity.UserEntity;
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

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/excursions/{id}")
    public String getExcursionsForUser(Model model, @PathVariable Long id){
        UserEntity user = userService.findById(id);
        model.addAttribute("bookings",userService.getAllExcursionBookings(user));
        model.addAttribute("userid",id);
        return "user-excursions";
    }

    @ModelAttribute
    public RatingBindingModel ratingBindingModel(){
        return new RatingBindingModel();
    }

    @PostMapping("/users/excursions/{userid}/{excursionid}")
    public String rating(@Valid RatingBindingModel ratingBindingModel,
                         BindingResult bindingResult,
                         @PathVariable Long userid,
                         @PathVariable Long excursionid,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("ratingBindingModel", ratingBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.ratingBindingModel", bindingResult);
            return String.format("redirect:/users/excursions/%d/%d",userid, excursionid);
        }

        return "redirect:/";

    }
}
