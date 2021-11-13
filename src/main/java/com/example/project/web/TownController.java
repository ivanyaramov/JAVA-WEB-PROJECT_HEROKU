package com.example.project.web;

import com.example.project.model.binding.BookingHotelBindingModel;
import com.example.project.model.entity.Town;
import com.example.project.model.service.BookingExcursionServiceModel;
import com.example.project.model.service.BookingHotelServiceModel;
import com.example.project.model.view.TownViewModel;
import com.example.project.service.BookingHotelService;
import com.example.project.service.CountryService;
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
@RequestMapping("/towns")
public class TownController {
    private final CountryService countryService;
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final BookingHotelService bookingHotelService;

    public TownController(CountryService countryService, TownService townService, ModelMapper modelMapper, BookingHotelService bookingHotelService) {
        this.countryService = countryService;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.bookingHotelService = bookingHotelService;
    }

    @GetMapping("/all")
    public String viewAllTowns(Model model){
//        List<CountryViewModel> list = countryService.getAllCountries();
        model.addAttribute("countries",countryService.getAllCountries());
        return "town";
    }

    @GetMapping("/landmarks/{id}")
    public String landmarksOfTown(@PathVariable Long id, Model model){
    model.addAttribute("town", townService.findById(id));
    return "town-landmarks";
    }

    @GetMapping("/hotels/{id}")
    public String hotelsOfTown(@PathVariable Long id, Model model){
        TownViewModel town = townService.findById(id);
        model.addAttribute("town", town);
        return "town-hotels";
    }

    @GetMapping("/landmarks/forhelp/{name}")
    public String helpMethodToRedirect(@PathVariable String name){
//        System.out.println(name);
        String townAsString = name.split(" \\(")[0];
        Town town = townService.findByName(townAsString);
//        System.out.println(town.getName());
        Long id = town.getId();
        return "redirect:/towns/landmarks/" + id;

    }

    @GetMapping("/hotels/booking/{id}")
    public String bookHotel(@PathVariable Long id, Model model){

model.addAttribute("id", id);


        return "hotel-booking";
    }

    @ModelAttribute
    public BookingHotelBindingModel bookingHotelBindingModel(){
        return new BookingHotelBindingModel();
    }

    @PostMapping("/hotels/booking/{id}")
    public String bookHotel(@Valid BookingHotelBindingModel bookingHotelBindingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            @PathVariable Long id,
                            Principal principal){
        Integer sum = bookingHotelBindingModel.getCountOfAdults()+bookingHotelBindingModel.getCountOfChildren();
        if (bindingResult.hasErrors() || sum == 0) {

            return "redirect:/towns/hotels/booking/" + id;

        }

        BookingHotelServiceModel bookingHotelServiceModel = modelMapper.map(bookingHotelBindingModel, BookingHotelServiceModel.class);
        bookingHotelServiceModel.setHotelId(id);
        bookingHotelServiceModel.setUsername(principal.getName());
        bookingHotelService.createBooking(bookingHotelServiceModel);
        return "redirect:/";

    }


}
