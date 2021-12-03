package com.example.project.web;

import com.example.project.model.binding.UserRegisterBindingModel;
import com.example.project.model.service.UserRegisterServiceModel;
import com.example.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserRegisterController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @ModelAttribute("userModel")
    public UserRegisterBindingModel userModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/users/register")
    public String registerUser(Model model) {
        if(!model.containsAttribute("passwordsnotmatching")){
            model.addAttribute("passwordsnotmatching", false);
        }
        if(!model.containsAttribute("usernameExists")){
            model.addAttribute("usernameExists", false);
        }
        if(!model.containsAttribute("emailExists")){
            model.addAttribute("emailExists", false);
        }
        return "register";
    }

    @PostMapping("/users/register")
    public String register(
            @Valid UserRegisterBindingModel userModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userModel.getPassword().equals(userModel.getConfirmPassword()) || !userService.isUserNameFree(userModel.getUsername()) || !userService.isEmailFree(userModel.getEmail())) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            if(!userModel.getPassword().equals(userModel.getConfirmPassword())){
                redirectAttributes.addFlashAttribute("passwordsnotmatching",true);
            }
            if(!userService.isUserNameFree(userModel.getUsername())){
                redirectAttributes.addFlashAttribute("usernameExists", true);
            }
            if(!userService.isEmailFree(userModel.getEmail())){
                redirectAttributes.addFlashAttribute("emailExists", true);
            }
            return "redirect:/users/register";
        }

        UserRegisterServiceModel serviceModel =
                modelMapper.map(userModel, UserRegisterServiceModel.class);

        userService.registerAndLoginUser(serviceModel);

        return "redirect:/";
    }

}