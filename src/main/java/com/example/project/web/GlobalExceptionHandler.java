package com.example.project.web;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public String handleDbExceptions(ObjectNotFoundException e, Model model) {
        model.addAttribute("objectid", e.getObjectId());
        model.addAttribute("type", e.getType());
        return "object-not-found";
    }
}