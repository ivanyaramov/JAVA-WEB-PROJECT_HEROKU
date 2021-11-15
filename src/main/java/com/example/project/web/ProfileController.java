package com.example.project.web;

import com.example.project.model.entity.UserEntity;
import com.example.project.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        return "user-excursions";
    }
}
