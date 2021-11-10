package com.example.project.web;

import com.example.project.model.binding.BookingExcursionBindingModel;
import com.example.project.model.service.BookingExcursionServiceModel;
import com.example.project.model.view.DayViewModel;
import com.example.project.model.view.ExcursionViewModel;
import com.example.project.service.BookingExcursionService;
import com.example.project.service.DayService;
import com.example.project.service.ExcursionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/excursions")
public class ExcursionController {
    private final ExcursionService excursionService;
    private final DayService dayService;
    private final ModelMapper modelMapper;
    private final BookingExcursionService bookingExcursionService;

    public ExcursionController(ExcursionService excursionService, DayService dayService, ModelMapper modelMapper, BookingExcursionService bookingExcursionService) {
        this.excursionService = excursionService;
        this.dayService = dayService;
        this.modelMapper = modelMapper;
        this.bookingExcursionService = bookingExcursionService;
    }

    @GetMapping("/all")
    public String viewAllTowns(Model model) {
        model.addAttribute("excursions", excursionService.getAll());


        return "excursion";
    }

    @GetMapping("/info/{id}")
    public String excursionInfo(@PathVariable Long id, Model model) {
        ExcursionViewModel excursion = excursionService.getExcursionById(id);
        model.addAttribute("excursion", excursion);
        List<DayViewModel> listOfDays = dayService.orderDays(excursion.getDays());
        model.addAttribute("days", listOfDays);
        return "excursion-info";
    }

    @GetMapping("/guide/{id}")
    public String guide(@PathVariable Long id, Model model) {
        ExcursionViewModel excursion = excursionService.getExcursionById(id);
        model.addAttribute("excursion", excursion);
        return "excursion-guide";
    }

    @ModelAttribute
    public BookingExcursionBindingModel bookingExcursionBindingModel() {
        return new BookingExcursionBindingModel();
    }

    @GetMapping("/booking/{id}")
    public String bookExcursion(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "excursion-booking";
    }

    @PostMapping("/booking/{id}")
    public String bookExcursion(@Valid BookingExcursionBindingModel bookingExcursionBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                @PathVariable Long id,
                                Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("bookingExcursionBindingModel", bookingExcursionBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.bookingExcursionBindingModel", bindingResult);
        return "excursion-booking";
        }
        BookingExcursionServiceModel bookingExcursionServiceModel = modelMapper.map(bookingExcursionBindingModel, BookingExcursionServiceModel.class);
        bookingExcursionServiceModel.setExcursionId(id);
        bookingExcursionServiceModel.setUsername(principal.getName());
        bookingExcursionService.createBooking(bookingExcursionServiceModel);
        return "redirect:/";
    }
}
