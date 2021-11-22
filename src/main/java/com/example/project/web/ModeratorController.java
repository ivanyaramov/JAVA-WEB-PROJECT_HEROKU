package com.example.project.web;

import com.example.project.model.binding.*;
import com.example.project.model.service.*;
import com.example.project.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ModeratorController {
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final HotelService hotelService;
    private final LandmarkService landmarkService;
    private final CountryService countryService;
    private final GuideService guideService;
    private final ExcursionService excursionService;
    private final DayService dayService;

    public ModeratorController(TownService townService, ModelMapper modelMapper, HotelService hotelService, LandmarkService landmarkService, CountryService countryService, GuideService guideService, ExcursionService excursionService, DayService dayService) {
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.hotelService = hotelService;
        this.landmarkService = landmarkService;
        this.countryService = countryService;
        this.guideService = guideService;
        this.excursionService = excursionService;
        this.dayService = dayService;
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
    Long townId = hotelService.findTownId(id);
        return "redirect:/towns/hotels/" +townId;
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
        Long townId = landmarkService.getTownId(id);
return "redirect:/towns/landmarks/" + townId;
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
        return "redirect:/towns/all";
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

    @ModelAttribute
    public GuideBindingModel guideBindingModel(){
        return new GuideBindingModel();
    }

    @GetMapping("/add/guide")
    public String addGuide(){
        return "guide-add";
    }

    @PostMapping("/add/guide")
    public String addGuide(@Valid GuideBindingModel guideBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("guideBindingModel",guideBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.guideBindingModel", bindingResult);
            return "redirect:/add/guide";
        }
        GuideServiceModel guideServiceModel = modelMapper.map(guideBindingModel, GuideServiceModel.class);
        guideService.createGuide(guideServiceModel);
        return "redirect:/";
    }

    @GetMapping("/edit/guide/{id}")
    public String editGuide(Model model, @PathVariable Long id){
        GuideBindingModel guideBindingModel = modelMapper.map(guideService.findById(id), GuideBindingModel.class);
        model.addAttribute("id",id);
        model.addAttribute("guideBindingModel", guideBindingModel);
        return "guide-edit";
    }

    @PostMapping("/edit/guide/{id}")
    public String editGuide(@Valid GuideBindingModel guideBindingModel,
                           BindingResult bindingResult,
                           @PathVariable Long id,
                           RedirectAttributes redirectAttributes
    ){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("guideBindingModel", guideBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.guideBindingModel", bindingResult);
            return "redirect:/edit/guide/"+id;
        }
        GuideServiceModel guideServiceModel = modelMapper.map(guideBindingModel, GuideServiceModel.class);
        guideService.editGuide(id, guideServiceModel);
        return "redirect:/";
    }

    @ModelAttribute
    public CountryBindingModel countryBindingModel(){
        return new CountryBindingModel();
    }

    @GetMapping("/add/country")
    public String addCountry(Model model){
        if(!model.containsAttribute("exists")){
        model.addAttribute("exists",false);}
        return "country-add";
    }

    @PostMapping("/add/country")
    public String addCountry(@Valid CountryBindingModel countryBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("countryBindingModel",countryBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.countryBindingModel", bindingResult);
            return "redirect:/add/country";
        }
        if(countryService.existsByName(countryBindingModel.getName())){
            redirectAttributes.addFlashAttribute("exists",true);
            return "redirect:/add/country";
        }
        CountryServiceModel countryServiceModel = modelMapper.map(countryBindingModel,CountryServiceModel.class);
        countryService.createCountry(countryServiceModel);
        return "redirect:/";
    }

    @DeleteMapping("/delete/landmark/{id}")
    public String deleteLandmark(@PathVariable Long id) {
        Long townId = landmarkService.getTownId(id);
        landmarkService.deleteLandmark(id);

        return "redirect:/towns/landmarks/" + townId;
    }


    @DeleteMapping("/delete/hotel/{id}")
    public String deleteHotel(@PathVariable Long id) {
        Long townId = hotelService.findTownId(id);
        try {
            hotelService.deleteHotel(id);
        }
        catch (Exception e){
            return "hotel-into-usage";
        }

        return "redirect:/towns/hotels/" + townId;
    }


    @ModelAttribute
    public  ExcursionBindingModel excursionBindingModel(){
        return new ExcursionBindingModel();
}

@GetMapping("/add/excursion")
    public String addExcursion(Model model){
model.addAttribute("guides",guideService.getAllGuides());
        return "excursion-add";
}


    @PostMapping("/add/excursion")
    public String addExcursion(@Valid ExcursionBindingModel excursionBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("excursionBindingModel", excursionBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.excursionBindingModel", bindingResult);
            return "redirect:/add/excursion";
        }
        ExcursionServiceModel excursionServiceModel = modelMapper.map(excursionBindingModel, ExcursionServiceModel.class);
        excursionService.createExcursion(excursionServiceModel);

        return "redirect:/excursions/all";
    }



    @PostMapping("/edit/excursion/{id}")
    public String editExcursion(@Valid ExcursionBindingModel excursionBindingModel,
                            BindingResult bindingResult,
                            @PathVariable Long id,
                            RedirectAttributes redirectAttributes
    ){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("excursionBindingModel", excursionBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.excursionBindingModel", bindingResult);
            return "redirect:/edit/excursion/"+id;
        }
        ExcursionServiceModel excursionServiceModel = modelMapper.map(excursionBindingModel, ExcursionServiceModel.class);
        excursionService.editExcursion(id, excursionServiceModel);
        return "redirect:/excursions/all";
    }


    @GetMapping("/edit/excursion/{id}")
    public String editExcursion(Model model, @PathVariable Long id){
        ExcursionBindingModel excursionBindingModel = modelMapper.map(excursionService.findById(id), ExcursionBindingModel.class);
        excursionBindingModel.setGuide(excursionService.findById(id).getGuide().getFullName());
        model.addAttribute("guides",guideService.getAllGuides());
        model.addAttribute("id",id);
        model.addAttribute("excursionBindingModel", excursionBindingModel);
        return "excursion-edit";
    }

    @ModelAttribute
    public DayBindingModel dayBindingModel(){

        return new DayBindingModel();
    }

    @GetMapping("/add/day/excursion/{id}/{excursionid}")
    public String addDay(Model model, @PathVariable Long id, @PathVariable Long excursionid){
        model.addAttribute("id", id);
        model.addAttribute("excursionid", excursionid);
        model.addAttribute("towns", townService.getOnlyTownsAsStrings());
        return "day-add";
    }

    @PostMapping("/add/day/excursion/{id}/{excursionid}")
    public String addDay(@Valid DayBindingModel dayBindingModel,
                               BindingResult bindingResult,
                               @PathVariable Long id,
                         @PathVariable Long excursionid,
                               RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("dayBindingModel", dayBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.dayBindingModel", bindingResult);
            return "redirect:/add/day/excursion/" + id+ "/" + excursionid;
        }
        DayServiceModel dayServiceModel = modelMapper.map(dayBindingModel, DayServiceModel.class);
        dayService.createDay(id, dayServiceModel);

        return "redirect:/excursions/info/" + excursionid;
    }
    @GetMapping("/edit/day/{id}/{excursionid}")
    public String editDay(Model model, @PathVariable Long id, @PathVariable Long excursionid){
        DayBindingModel dayBindingModel = dayService.mapDayToBinding(id);
        model.addAttribute("towns", townService.getOnlyTownsAsStrings());
        model.addAttribute("id",id);
        model.addAttribute("excursionid",excursionid);
        model.addAttribute("dayBindingModel", dayBindingModel);
        return "day-edit";
    }

    @PostMapping("/edit/day/{id}/{excursionid}")
    public String editDay(@Valid DayBindingModel dayBindingModel,
                                BindingResult bindingResult,
                                @PathVariable Long id,
                          @PathVariable Long excursionid,
                                RedirectAttributes redirectAttributes
    ){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("dayBindingModel", dayBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.dayBindingModel", bindingResult);
            return "redirect:/edit/day/"+id + "/" + excursionid;
        }
        DayServiceModel dayServiceModel = modelMapper.map(dayBindingModel, DayServiceModel.class);
        dayService.editDay(id, excursionid, dayServiceModel);
        return "redirect:/excursions/info/" + excursionid;
    }

}
