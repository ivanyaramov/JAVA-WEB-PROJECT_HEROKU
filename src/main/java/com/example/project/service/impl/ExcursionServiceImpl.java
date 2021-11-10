package com.example.project.service.impl;

import com.example.project.model.entity.BookingExcursion;
import com.example.project.model.entity.Day;
import com.example.project.model.entity.Excursion;
import com.example.project.model.view.ExcursionViewModel;
import com.example.project.repository.ExcursionRepository;
import com.example.project.service.ExcursionService;
import com.example.project.service.GuideService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
            list.add(excursion);
        }
     return list;
    }

    @Override
    public ExcursionViewModel getExcursionById(Long id) {
        Excursion excursion= excursionRepository.findById(id).orElse(null);
       ExcursionViewModel excursionViewModel = modelMapper.map(excursion, ExcursionViewModel.class);
       excursionViewModel.setPlacesLeft(determinePlacesLeft(excursion));
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


}
