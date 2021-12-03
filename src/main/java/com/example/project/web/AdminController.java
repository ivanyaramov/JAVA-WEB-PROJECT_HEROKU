package com.example.project.web;

import com.example.project.model.binding.RatingBindingModel;
import com.example.project.model.binding.RoleBindingModel;
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
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public String manageAllUsers(Model model){
        model.addAttribute("users",userService.getAllUsersView());

        return "admin-users";
    }

    @ModelAttribute
    RoleBindingModel roleBindingModel(){
        return new RoleBindingModel();
    }

    @PostMapping("/admin/users/addrole/{userid}")
    public String addRole(@Valid RoleBindingModel roleBindingModel,
                         BindingResult bindingResult,
                         @PathVariable Long userid,
                         RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("roleBindingModel", roleBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.roleBindingModel", bindingResult);
            return "redirect:/admin/users";
        }
        userService.addRole(userid, roleBindingModel);
        return "redirect:/admin/users";

    }

    @PostMapping("/admin/users/removerole/{userid}")
    public String removeRole(@Valid RoleBindingModel roleBindingModel,
                          BindingResult bindingResult,
                          @PathVariable Long userid,
                          RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("roleBindingModel", roleBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.roleBindingModel", bindingResult);
            return "redirect:/admin/users";
        }
        userService.removeRole(userid, roleBindingModel);
        return "redirect:/admin/users";

    }

}
