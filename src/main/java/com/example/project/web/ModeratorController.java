package com.example.project.web;

import com.example.project.model.binding.*;
import com.example.project.model.service.HotelServiceModel;
import com.example.project.model.service.LandmarkServiceModel;
import com.example.project.model.service.TownServiceModel;
import com.example.project.service.CountryService;
import com.example.project.service.HotelService;
import com.example.project.service.LandmarkService;
import com.example.project.service.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class ModeratorController {
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final HotelService hotelService;
    private final LandmarkService landmarkService;
    private final CountryService countryService;

    public ModeratorController(TownService townService, ModelMapper modelMapper, HotelService hotelService, LandmarkService landmarkService, CountryService countryService) {
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.hotelService = hotelService;
        this.landmarkService = landmarkService;
        this.countryService = countryService;
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

    @GetMapping("/edit/hotel/{id}")
    public String editHotel(Model model, @PathVariable Long id){
        HotelBindingModel hotelBindingModel = modelMapper.map(hotelService.findById(id),HotelBindingModel.class);
        model.addAttribute("town", hotelService.findById(id).getTown().getName());
        model.addAttribute("id",id);
        model.addAttribute("hotelBindingModel", hotelBindingModel);
        return "hotel-edit";
    }

    @PostMapping("/edit/hotel/{id}")
    public String editHotel(@Valid HotelBindingModelEdit hotelBindingModel,
                            BindingResult bindingResult,
                            @PathVariable Long id,
                            RedirectAttributes redirectAttributes
                            ){

    if(bindingResult.hasErrors()){
        redirectAttributes.addFlashAttribute("hotelBindingModel", hotelBindingModel);
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.hotelBindingModel", bindingResult);
        return "redirect:/edit/hotel/"+id;
    }
    HotelServiceModel hotelServiceModel = modelMapper.map(hotelBindingModel, HotelServiceModel.class);
    hotelService.editHotel(id, hotelServiceModel);
        return "redirect:/";
    }

    @GetMapping("/edit/landmark/{id}")
    public String editLandmark(Model model, @PathVariable Long id){
        LandmarkBindingModel landmarkBindingModel = modelMapper.map(landmarkService.findById(id),LandmarkBindingModel.class);
        model.addAttribute("town", landmarkService.findById(id).getTown().getName());
        model.addAttribute("id",id);
        model.addAttribute("landmarkBindingModel", landmarkBindingModel);
        return "landmark-edit";
    }

    @PostMapping("/edit/landmark/{id}")
    public String editLandmark(@Valid LandmarkBindingModelEdit landmarkBindingModel,
                            BindingResult bindingResult,
                            @PathVariable Long id,
                            RedirectAttributes redirectAttributes
    ){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("landmarkBindingModel", landmarkBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.landmarkBindingModel", bindingResult);
            return "redirect:/edit/landmark/"+id;
        }
        LandmarkServiceModel landmarkServiceModel = modelMapper.map(landmarkBindingModel, LandmarkServiceModel.class);
        landmarkService.editLandmark(id, landmarkServiceModel);
return "redirect:/";
    }


    @GetMapping("/edit/town/{id}")
    public String editTown(Model model, @PathVariable Long id){
       TownBindingModel townBindingModel = modelMapper.map(townService.findById(id),TownBindingModel.class);
        model.addAttribute("country", townService.findByName(townBindingModel.getName()).getCountry().getName());
        model.addAttribute("id",id);
        model.addAttribute("townBindingModel", townBindingModel);
        return "town-edit";
    }

    @PostMapping("/edit/town/{id}")
    public String editTown(@Valid TownBindingModelEdit townBindingModel,
                               BindingResult bindingResult,
                               @PathVariable Long id,
                               RedirectAttributes redirectAttributes
    ){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("townBindingModel", townBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.townBindingModel", bindingResult);
            return "redirect:/edit/town/"+id;
        }
       TownServiceModel townServiceModel = modelMapper.map(townBindingModel, TownServiceModel.class);
        townService.editTown(id, townServiceModel);
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

    @GetMapping("/add/town")
    public String addTown(Model model){
model.addAttribute("countries", countryService.getALlCountriesAsStrings());
        return "town-add";
    }

    @ModelAttribute
    public TownBindingModel townBindingModel(){
        return new TownBindingModel();
    }

    @PostMapping("/add/town")
    public String addTown(@Valid TownBindingModel townBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("townBindingModel",townBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.townBindingModel", bindingResult);
            return "redirect:/add/town";
        }
        TownServiceModel townServiceModel = modelMapper.map(townBindingModel, TownServiceModel.class);
        townServiceModel.setCountry(countryService.findByName(townBindingModel.getCountry()));
        townService.createTown(townServiceModel);
return "redirect:/";
    }


}
