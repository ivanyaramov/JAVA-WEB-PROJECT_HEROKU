package com.example.project.service.impl;

import com.example.project.model.entity.BookingExcursion;
import com.example.project.model.entity.Day;
import com.example.project.model.entity.Excursion;
import com.example.project.model.entity.Rating;
import com.example.project.model.service.ExcursionServiceModel;
import com.example.project.model.view.ExcursionViewModel;
import com.example.project.repository.ExcursionRepository;
import com.example.project.service.ExcursionService;
import com.example.project.service.GuideService;
import com.example.project.web.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ExcursionServiceImpl implements ExcursionService {
    private final ExcursionRepository excursionRepository;
    private final ModelMapper modelMapper;
    private final GuideService guideService;

    public ExcursionServiceImpl(ExcursionRepository excursionRepository, ModelMapper modelMapper, GuideService guideService) {
        this.excursionRepository = excursionRepository;
        this.modelMapper = modelMapper;
        this.guideService = guideService;
    }

    @Override
    public void initaliseExcursions() {
        if(excursionRepository.count() ==0) {
            Excursion inItaly = new Excursion("Excursion in Italy", LocalDate.of(2022, 6, 15), LocalDate.of(2022, 6, 24), 85);
            inItaly.setPictureUrl("https://res.cloudinary.com/ivoto22/image/upload/v1636110825/Capture_dyetjj.jpg");
            Excursion inGermany = new Excursion("Excursion in Germany", LocalDate.of(2022, 8, 15), LocalDate.of(2022, 8, 24), 85);
            inGermany.setPictureUrl("https://res.cloudinary.com/ivoto22/image/upload/v1636562498/Capture2_h8fxej.jpg");
            Excursion inSpain = new Excursion("Excursion in Spain", LocalDate.of(2022, 3, 15), LocalDate.of(2022, 3, 24), 85);
           inSpain.setPictureUrl("https://res.cloudinary.com/ivoto22/image/upload/v1636110825/Capture_dyetjj.jpg");
           inItaly.setGuide(guideService.findByFullName("Anton Biserov"));
           inGermany.setGuide(guideService.findByFullName("Teodor Vladimirov"));
           inSpain.setGuide(guideService.findByFullName("Alexa Dimitrova"));
            excursionRepository.save(inItaly);
            excursionRepository.save(inGermany);
            excursionRepository.save(inSpain);
        }


    }

    @Override
    public Excursion findByName(String name) {
        return excursionRepository.getExcursionByName(name).orElse(null);
    }

    @Override
    public List<ExcursionViewModel> getAll() {
        List<ExcursionViewModel> list = new ArrayList<>();
        for(Excursion e: excursionRepository.findAll()){
            ExcursionViewModel excursion = modelMapper.map(e, ExcursionViewModel.class);
            excursion.setPlacesLeft(determinePlacesLeft(e));
            Double rating = getAverageRating(e.getId());
            if(rating == -1){
                rating = 5.0;
            }
            excursion.setRating(rating);
            list.add(excursion);
        }
     return list;
    }

    @Override
    public List<ExcursionViewModel> getFirst3() {
       List<ExcursionViewModel> list = new ArrayList<>();
       int br=0;
       for(ExcursionViewModel e: getAll()){
           if(br>=3){
               break;
           }
           if(LocalDate.now().compareTo(e.getStartDate())<0){
               br++;
               list.add(e);
           }
       }
        return list;
    }

    @Override
    public ExcursionViewModel getExcursionById(Long id) {
        Excursion excursion= excursionRepository.findById(id).orElseThrow(()->new ObjectNotFoundException(id, "excursions"));
       ExcursionViewModel excursionViewModel = modelMapper.map(excursion, ExcursionViewModel.class);
       excursionViewModel.setPlacesLeft(determinePlacesLeft(excursion));
       Double rating = getAverageRating(id);
       if(rating == -1){
           rating = 5.0;
       }
       excursionViewModel.setRating(rating);
       return excursionViewModel;
    }

    @Override
    public Excursion findById(Long id) {
        return  excursionRepository.findById(id).orElse(null);
    }

    @Override
    public Integer determinePlacesLeft(Excursion excursion) {
        Integer sum = 0;
        for(BookingExcursion booking: excursion.getBookingExcursions()){
            sum += booking.getCountOfAdults();
            sum += booking.getCountOfChildren();
        }
        return excursion.getCapacity() - sum;
    }

    @Override
    public boolean hasEnoughPlaces(Long excursionId, Integer bookingSum) {
        Integer avaliable = determinePlacesLeft(findById(excursionId));
        return avaliable >= bookingSum;

    }

    @Override
    public BigDecimal priceOfExcursion(BigDecimal children, BigDecimal adults, Long id) {
       Excursion excursion = findById(id);
       BigDecimal priceForOneChild = new BigDecimal(0);
       BigDecimal priceForOneAdult = new BigDecimal(0);
       for(Day day : excursion.getDays()){
           if(day.getHotel()!=null){
               priceForOneChild = priceForOneChild.add(day.getHotel().getPricePerNightChild());
               priceForOneAdult = priceForOneAdult.add(day.getHotel().getPricePerNightAdult());
           }
       }
       BigDecimal priceForAllChildren = priceForOneChild.multiply(children);
       BigDecimal priceForAllAdults = priceForOneAdult.multiply(adults);
       BigDecimal totalPrice = BigDecimal.valueOf(100);
       totalPrice = totalPrice.add(priceForAllAdults).add(priceForAllChildren);
       return totalPrice;
    }

    @Override
    public Double getAverageRating(Long id) {
        Excursion excursion = findById(id);
       Set<BookingExcursion> set = excursion.getBookingExcursions();
       double brratings = 0;
       int sum = 0;
       for(BookingExcursion bookingExcursion : set){
           Rating rating = bookingExcursion.getRating();
           if(rating!=null){
               brratings++;
               sum+=rating.getRating();
           }
       }
       if(brratings==0){
           return -1.0;
       }
      double average = sum/brratings;
       return average;
    }

    @Override
    public boolean hasExcursionStarted(Long id) {
        return LocalDate.now().compareTo(findById(id).getStartDate())>=0;

    }

    @Override
    public void createExcursion(ExcursionServiceModel excursionServiceModel) {
        Excursion excursion = modelMapper.map(excursionServiceModel, Excursion.class);
        excursion.setGuide(guideService.findByFullName(excursionServiceModel.getGuide()));
        excursionRepository.save(excursion);
    }

    @Override
    public void editExcursion(Long id, ExcursionServiceModel excursionServiceModel) {
        Excursion excursion = findById(id);
        excursion.setName(excursionServiceModel.getName());
        excursion.setPictureUrl(excursionServiceModel.getPictureUrl());
        excursion.setGuide(guideService.findByFullName(excursionServiceModel.getGuide()));
        excursion.setCapacity(excursionServiceModel.getCapacity());
        excursion.setStartDate(excursionServiceModel.getStartDate());
        excursion.setEndDate(excursionServiceModel.getEndDate());
        excursionRepository.save(excursion);
    }

    @Override
    public void addDay(Long id, Day day) {
        Excursion excursion = findById(id);
        excursion.getDays().add(day);
        excursionRepository.save(excursion);
    }


}
