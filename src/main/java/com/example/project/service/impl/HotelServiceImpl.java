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
            Hotel  ibisstyle = new Hotel("Ibis Styles Budapest", 5, BigDecimal.valueOf(190), BigDecimal.valueOf(171), townService.findByName("Budapest"));
            Hotel  ferihegy = new Hotel("Ferihegy", 3, BigDecimal.valueOf(78), BigDecimal.valueOf(62), townService.findByName("Budapest"));
            Hotel  hhplus = new Hotel("H+ Hotel", 5, BigDecimal.valueOf(200), BigDecimal.valueOf(178), townService.findByName("Vienna"));
            Hotel  meinnger = new Hotel("Meinnger", 4, BigDecimal.valueOf(173), BigDecimal.valueOf(152), townService.findByName("Vienna"));
            Hotel  amedia = new Hotel("Amedia", 4, BigDecimal.valueOf(168), BigDecimal.valueOf(147), townService.findByName("Vienna"));
            Hotel  alphotel = new Hotel("Alp Hotel", 4, BigDecimal.valueOf(152), BigDecimal.valueOf(137), townService.findByName("Innsbruck"));
            Hotel  munchencitysud = new Hotel("Munchen City Sud", 3, BigDecimal.valueOf(58), BigDecimal.valueOf(40), townService.findByName("Munich"));
            Hotel  arabellapark = new Hotel("Arabellapark Munchen", 5, BigDecimal.valueOf(198), BigDecimal.valueOf(190), townService.findByName("Munich"));
            Hotel  laimer = new Hotel("Laimer hotel", 4, BigDecimal.valueOf(128), BigDecimal.valueOf(117), townService.findByName("Munich"));
            Hotel leonardo = new Hotel("Leonardo Royal hotel", 4, BigDecimal.valueOf(135), BigDecimal.valueOf(127), townService.findByName("Frankfurt"));
            Hotel hansa = new Hotel("Hansa hotel", 3, BigDecimal.valueOf(78), BigDecimal.valueOf(69), townService.findByName("Stuttgart"));
            Hotel feuerbackhotel = new Hotel("Feuerbach hotel", 5, BigDecimal.valueOf(145), BigDecimal.valueOf(132), townService.findByName("Stuttgart"));
            Hotel dionis = new Hotel("Dionis", 4, BigDecimal.valueOf(131), BigDecimal.valueOf(120), townService.findByName("Rust"));
            Hotel pullman = new Hotel("Pullman", 4, BigDecimal.valueOf(250), BigDecimal.valueOf(238), townService.findByName("Paris"));
            Hotel raphael = new Hotel("Raphael", 5, BigDecimal.valueOf(312), BigDecimal.valueOf(300), townService.findByName("Paris"));
            Hotel generator = new Hotel("Generator", 4, BigDecimal.valueOf(230), BigDecimal.valueOf(221), townService.findByName("Paris"));
            Hotel ibis = new Hotel("Ibis Strasbourg", 3, BigDecimal.valueOf(112), BigDecimal.valueOf(99), townService.findByName("Strasbourg"));
            Hotel carlton = new Hotel("Carlton Lyon", 5, BigDecimal.valueOf(365), BigDecimal.valueOf(320), townService.findByName("Lyon"));
            Hotel radisson = new Hotel("Radisson", 4, BigDecimal.valueOf(270), BigDecimal.valueOf(248), townService.findByName("Lyon"));
            Hotel princessa = new Hotel("Hotel Spa Princessa", 4, BigDecimal.valueOf(270), BigDecimal.valueOf(248), townService.findByName("Andorra la Vella"));
            Hotel vitium = new Hotel("Vitium", 4, BigDecimal.valueOf(220), BigDecimal.valueOf(210), townService.findByName("Madrid"));
            Hotel artisticbed = new Hotel("Artistic Bed", 4, BigDecimal.valueOf(221), BigDecimal.valueOf(208), townService.findByName("Madrid"));
            Hotel stcrhistopher = new Hotel("St Crhistopher", 4, BigDecimal.valueOf(245), BigDecimal.valueOf(213), townService.findByName("Barcelona"));
            Hotel colonial = new Hotel("Colonial", 3, BigDecimal.valueOf(150), BigDecimal.valueOf(124), townService.findByName("Barcelona"));
            Hotel ramblas = new Hotel("Ramblas", 5, BigDecimal.valueOf(350), BigDecimal.valueOf(342), townService.findByName("Barcelona"));
            Hotel hiltonseville = new Hotel("Hilton Seville", 4, BigDecimal.valueOf(298), BigDecimal.valueOf(275), townService.findByName("Seville"));
            Hotel zurincharm = new Hotel("Zurin Charm", 4, BigDecimal.valueOf(180), BigDecimal.valueOf(174), townService.findByName("Lisbon"));
            Hotel exeessenzia = new Hotel("Exe Essenzia", 4, BigDecimal.valueOf(197), BigDecimal.valueOf(182), townService.findByName("Porto"));
            Hotel dreamgrand = new Hotel("Dream Grand", 3, BigDecimal.valueOf(89), BigDecimal.valueOf(74), townService.findByName("Male"));
            Hotel samangrand = new Hotel("Seaman grand", 4, BigDecimal.valueOf(120), BigDecimal.valueOf(111), townService.findByName("Male"));
            Hotel goldentulip = new Hotel("Golden Tulip", 4, BigDecimal.valueOf(88), BigDecimal.valueOf(68), townService.findByName("Istanbul"));
            Hotel radissonistanbul = new Hotel("Radisson Istanbul", 5, BigDecimal.valueOf(141), BigDecimal.valueOf(128), townService.findByName("Istanbul"));
            Hotel hiltonistanbul = new Hotel("Hilton Istanbul", 5, BigDecimal.valueOf(155), BigDecimal.valueOf(132), townService.findByName("Istanbul"));
            Hotel towerhotel = new Hotel("The tower hotel", 5, BigDecimal.valueOf(250), BigDecimal.valueOf(231), townService.findByName("London"));
            Hotel centralparkhotel = new Hotel("Central Park hotel", 3, BigDecimal.valueOf(120), BigDecimal.valueOf(100), townService.findByName("London"));
            hotelRepository.save(grandhotelsanmarino);
            hotelRepository.save(rosa);
            hotelRepository.save(ibisstyle);
            hotelRepository.save(ferihegy);
            hotelRepository.save(hhplus);
            hotelRepository.save(meinnger);
            hotelRepository.save(amedia);
            hotelRepository.save(alphotel);
            hotelRepository.save(munchencitysud);
            hotelRepository.save(laimer);
            hotelRepository.save(leonardo);
            hotelRepository.save(hansa);
            hotelRepository.save(feuerbackhotel);
            hotelRepository.save(dionis);
            hotelRepository.save(raphael);
            hotelRepository.save(pullman);
            hotelRepository.save(generator);
            hotelRepository.save(ibis);
            hotelRepository.save(carlton);
            hotelRepository.save(radisson);
            hotelRepository.save(princessa);
            hotelRepository.save(vitium);
            hotelRepository.save(artisticbed);
            hotelRepository.save(stcrhistopher);
            hotelRepository.save(colonial);
            hotelRepository.save(ramblas);
            hotelRepository.save(hiltonseville);
            hotelRepository.save(zurincharm);
            hotelRepository.save(exeessenzia);
            hotelRepository.save(dreamgrand);
            hotelRepository.save(samangrand);
            hotelRepository.save(goldentulip);
            hotelRepository.save(radissonistanbul);
            hotelRepository.save(hiltonistanbul);
            hotelRepository.save(towerhotel);
            hotelRepository.save(centralparkhotel);
            hotelRepository.save(balkan);
            hotelRepository.save(metropolitan);
            hotelRepository.save(botique);
            hotelRepository.save(easyhotel);
            hotelRepository.save(eden);
            hotelRepository.save(holidayInBelgrade);
            hotelRepository.save(hiltondubrovnik);
            hotelRepository.save(belgradeCity);
            hotelRepository.save(neptun);
            hotelRepository.save(esplanade);
            hotelRepository.save(bandbhotel);
            hotelRepository.save(intercontinental);
            hotelRepository.save(napoleon);
            hotelRepository.save(treviPalace);
            hotelRepository.save(palladium);
            hotelRepository.save(ginorialduomo);
            hotelRepository.save(j24);
            hotelRepository.save(sanpi);
            hotelRepository.save(arabellapark);




        }
    }
}
