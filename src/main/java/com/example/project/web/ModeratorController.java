package com.example.project.web;

import com.example.project.model.binding.HotelBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ModeratorController {

    @GetMapping("/add/hotel")
    public String addHotel(){
        return "hotel-add";
    }
    @ModelAttribute
    public HotelBindingModel hotelBindingModel(){
        return new HotelBindingModel();
    }

    @PostMapping("/add/hotel")
    public String addHotel(@Valid HotelBindingModel hotelBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hotelBindingModel", hotelBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.hotelBindingModel", bindingResult);
            return "redirect:/add/hotel";
        }

        return "hotel-add";
    }


}
