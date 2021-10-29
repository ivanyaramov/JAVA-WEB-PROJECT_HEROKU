package com.example.project.service.impl;

import com.example.project.model.entity.Hotel;
import com.example.project.repository.HotelRepository;
import com.example.project.service.HotelService;
import com.example.project.service.TownService;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class HotelServiceImpl implements HotelService {
    private final TownService townService;
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(TownService townService, HotelRepository hotelRepository) {
        this.townService = townService;
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void initialiseHotels() {
        if (hotelRepository.count()==0){
            Hotel balkan = new Hotel("Hotel Balkan", 5, BigDecimal.valueOf(150), BigDecimal.valueOf(100), townService.findByName("Sofia"));
            Hotel metropolitan = new Hotel("Metropolitan hotel", 5, BigDecimal.valueOf(170), BigDecimal.valueOf(120), townService.findByName("Sofia"));
            Hotel botique = new Hotel("Botique hotel", 4, BigDecimal.valueOf(110), BigDecimal.valueOf(75), townService.findByName("Sofia"));
            Hotel easyhotel = new Hotel("Easyhotel", 3, BigDecimal.valueOf(75), BigDecimal.valueOf(45), townService.findByName("Sofia"));
            Hotel eden = new Hotel("Edenhotel", 5, BigDecimal.valueOf(210), BigDecimal.valueOf(185), townService.findByName("Belgrade"));
            Hotel holidayInBelgrade = new Hotel("Holiday Inn Belgrade", 4, BigDecimal.valueOf(165), BigDecimal.valueOf(133), townService.findByName("Belgrade"));
            Hotel belgradeCity = new Hotel("Belgrade City Hotel", 4, BigDecimal.valueOf(125), BigDecimal.valueOf(100), townService.findByName("Belgrade"));
            Hotel hiltondubrovnik = new Hotel("Hilton Dubrovnik", 5, BigDecimal.valueOf(230), BigDecimal.valueOf(180), townService.findByName("Dubrovnik"));
            Hotel neptun = new Hotel("Hotel Neptun", 4, BigDecimal.valueOf(116), BigDecimal.valueOf(97), townService.findByName("Dubrovnik"));
            Hotel esplanade = new Hotel("Esplanade Zagreb Hotel", 5, BigDecimal.valueOf(193), BigDecimal.valueOf(163), townService.findByName("Zagreb"));
            Hotel bandbhotel = new Hotel("B&B Hotel Park", 3, BigDecimal.valueOf(92), BigDecimal.valueOf(67), townService.findByName("Ljubljana"));
            Hotel intercontinental = new Hotel("InterContinental", 5, BigDecimal.valueOf(252), BigDecimal.valueOf(232), townService.findByName("Ljubljana"));
            Hotel napoleon = new Hotel("Napoleon Hotel", 3, BigDecimal.valueOf(125), BigDecimal.valueOf(99), townService.findByName("Rome"));
            Hotel treviPalace = new Hotel("TreviPalace", 5, BigDecimal.valueOf(287), BigDecimal.valueOf(251), townService.findByName("Rome"));
            Hotel palladium = new Hotel("Hotel Palladium", 4, BigDecimal.valueOf(172), BigDecimal.valueOf(150), townService.findByName("Rome"));
            Hotel  ginorialduomo = new Hotel("Ginori al Duomo", 4, BigDecimal.valueOf(152), BigDecimal.valueOf(130), townService.findByName("Florentia"));
            Hotel  j24 = new Hotel("J24", 4, BigDecimal.valueOf(187), BigDecimal.valueOf(159), townService.findByName("Milano"));
            Hotel  sanpi = new Hotel("Sanpi", 4, BigDecimal.valueOf(182), BigDecimal.valueOf(148), townService.findByName("Milano"));
            Hotel  grandhotelsanmarino = new Hotel("Grand Hotel San Marino", 4, BigDecimal.valueOf(136), BigDecimal.valueOf(122), townService.findByName("San Marino"));
            Hotel  rosa = new Hotel("Rosa San Marino", 5, BigDecimal.valueOf(155), BigDecimal.valueOf(133), townService.findByName("San Marino"));
            Hotel  ibisstyle = new Hotel("Ibis Styles Budapest", 5, BigDecimal.valueOf(155), BigDecimal.valueOf(133), townService.findByName("San Marino"));

        }
    }
}
