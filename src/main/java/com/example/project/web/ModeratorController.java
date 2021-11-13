package com.example.project.web;

import com.example.project.model.binding.HotelBindingModel;
import com.example.project.model.binding.LandmarkBindingModel;
import com.example.project.model.service.HotelServiceModel;
import com.example.project.model.service.LandmarkServiceModel;
import com.example.project.service.HotelService;
import com.example.project.service.LandmarkService;
import com.example.project.service.TownService;
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
public class ModeratorController {
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final HotelService hotelService;
    private final LandmarkService landmarkService;

    public ModeratorController(TownService townService, ModelMapper modelMapper, HotelService hotelService, LandmarkService landmarkService) {
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.hotelService = hotelService;
        this.landmarkService = landmarkService;
    }

    @GetMapping("/add/hotel")
    public String addHotel(Model model){
        model.addAttribute("towns", townService.getOnlyTownsAsStrings());
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
        HotelServiceModel hotelServiceModel = modelMapper.map(hotelBindingModel, HotelServiceModel.class);
        hotelServiceModel.setTown(townService.findByName(hotelBindingModel.getTown()));
        hotelService.createHotel(hotelServiceModel);

        return "redirect:/";
    }

    @GetMapping("/add/landmark")
    public String addLandmark(Model model){
        model.addAttribute("towns", townService.getOnlyTownsAsStrings());
        return "landmark-add";
    }
    @ModelAttribute
    public LandmarkBindingModel landmarkBindingModel(){
        return new LandmarkBindingModel();
    }

    @PostMapping("/add/landmark")
    public String addLandmark(@Valid LandmarkBindingModel landmarkBindingModel,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("landmarkBindingModel", landmarkBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.landmarkBindingModel", bindingResult);
            return "redirect:/add/landmark";
        }
        LandmarkServiceModel landmarkServiceModel = modelMapper.map(landmarkBindingModel, LandmarkServiceModel.class);
        landmarkServiceModel.setTown(townService.findByName(landmarkBindingModel.getTown()));
        landmarkService.createLandmark(landmarkServiceModel);

        return "redirect:/";
    }


}
