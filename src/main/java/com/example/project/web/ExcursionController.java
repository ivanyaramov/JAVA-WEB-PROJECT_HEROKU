package com.example.project.web;

import com.example.project.model.entity.Excursion;
import com.example.project.model.view.DayViewModel;
import com.example.project.model.view.ExcursionViewModel;
import com.example.project.service.DayService;
import com.example.project.service.ExcursionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/excursions")
public class ExcursionController {
    private final ExcursionService excursionService;
    private final DayService dayService;

    public ExcursionController(ExcursionService excursionService, DayService dayService) {
        this.excursionService = excursionService;
        this.dayService = dayService;
    }

    @GetMapping("/all")
    public String viewAllTowns(Model model){
        model.addAttribute("excursions",excursionService.getAll());
        return "excursion";
    }

    @GetMapping("/info/{id}")
    public String excursionInfo(@PathVariable Long id, Model model){
        ExcursionViewModel excursion = excursionService.getExcursionById(id);
        model.addAttribute("excursion", excursion);
        List<DayViewModel> listOfDays = dayService.orderDays(excursion.getDays());
        model.addAttribute("days", listOfDays);
    return "excursion-info";
    }
}
