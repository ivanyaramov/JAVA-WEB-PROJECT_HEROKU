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
       Hotel balkan = new Hotel("Hotel Balkan", 5, BigDecimal.valueOf(150), BigDecimal.valueOf(100), townService.findByName("Sofia"),"https://res.cloudinary.com/ivoto22/image/upload/v1635951571/luxury-hotel-infinity-pool-palms-600w-648165631_yiwwea.webp");
            Hotel metropolitan = new Hotel("Metropolitan hotel", 5, BigDecimal.valueOf(170), BigDecimal.valueOf(120), townService.findByName("Sofia"), "https://res.cloudinary.com/ivoto22/image/upload/v1635951650/view-eastern-facade-old-hotel-600w-150926291_s8ilov.webp");
            Hotel botique = new Hotel("Botique hotel", 4, BigDecimal.valueOf(110), BigDecimal.valueOf(75), townService.findByName("Sofia"),"https://res.cloudinary.com/ivoto22/image/upload/v1635951898/modern-hotel-building-exterior-image-600w-189782669_pvkynr.webp");
            Hotel easyhotel = new Hotel("Easyhotel", 3, BigDecimal.valueOf(75), BigDecimal.valueOf(45), townService.findByName("Sofia"),"https://res.cloudinary.com/ivoto22/image/upload/v1635951938/luxury-hotel-600w-143577517_h4qm1x.webp");
            Hotel eden = new Hotel("Edenhotel", 5, BigDecimal.valueOf(210), BigDecimal.valueOf(185), townService.findByName("Belgrade"),"https://res.cloudinary.com/ivoto22/image/upload/v1635951971/aerial-view-hotel-building-beach-600w-142797529_lw3flj.webp");
            Hotel holidayInBelgrade = new Hotel("Holiday Inn Belgrade", 4, BigDecimal.valueOf(165), BigDecimal.valueOf(133), townService.findByName("Belgrade"),"https://res.cloudinary.com/ivoto22/image/upload/v1635952026/venetian-macao-resort-hotel-600w-182910095_e1oync.webp");
            Hotel belgradeCity = new Hotel("Belgrade City Hotel", 4, BigDecimal.valueOf(125), BigDecimal.valueOf(100), townService.findByName("Belgrade"),"https://res.cloudinary.com/ivoto22/image/upload/v1635952060/miami-south-beach-street-view-600w-104637488_qnvh8f.webp");
            Hotel hiltondubrovnik = new Hotel("Hilton Dubrovnik", 5, BigDecimal.valueOf(230), BigDecimal.valueOf(180), townService.findByName("Dubrovnik"),"https://res.cloudinary.com/ivoto22/image/upload/v1635952122/liverpool-dec-18-hilton-hotel-600w-154666181_splrxg.webp");
            Hotel esplanade = new Hotel("Esplanade Zagreb Hotel", 5, BigDecimal.valueOf(193), BigDecimal.valueOf(163), townService.findByName("Zagreb"),"https://res.cloudinary.com/ivoto22/image/upload/v1635952188/lounge-area-luxury-hotel-fountain-600w-79988047_irr0cw.webp");
            Hotel bandbhotel = new Hotel("B&B Hotel Park", 3, BigDecimal.valueOf(92), BigDecimal.valueOf(67), townService.findByName("Ljubljana"),"https://res.cloudinary.com/ivoto22/image/upload/v1635952294/szczecin-polandseptember-2017-building-glass-600w-721811038_inmi98.webp");
            Hotel intercontinental = new Hotel("InterContinental", 5, BigDecimal.valueOf(252), BigDecimal.valueOf(232), townService.findByName("Ljubljana"),"https://res.cloudinary.com/ivoto22/image/upload/v1635952342/bellagio-hotel-las-vegas-nv-600w-1702898239_czmdes.webp");
            Hotel napoleon = new Hotel("Napoleon Hotel", 3, BigDecimal.valueOf(125), BigDecimal.valueOf(99), townService.findByName("Rome"),"https://res.cloudinary.com/ivoto22/image/upload/v1635952388/taipei-taiwan-aug-8-2018-600w-1152479015_o6rzpq.webp");
            Hotel treviPalace = new Hotel("TreviPalace", 5, BigDecimal.valueOf(287), BigDecimal.valueOf(251), townService.findByName("Rome"),"https://res.cloudinary.com/ivoto22/image/upload/v1635952428/hotel-street-intersection-600w-57591733_z7qfxn.webp");
            Hotel palladium = new Hotel("Hotel Palladium", 4, BigDecimal.valueOf(172), BigDecimal.valueOf(150), townService.findByName("Rome"),"https://res.cloudinary.com/ivoto22/image/upload/v1635952488/coral-gables-fl-usa-may-600w-195055283_asober.webp");
            Hotel  ginorialduomo = new Hotel("Ginori al Duomo", 4, BigDecimal.valueOf(152), BigDecimal.valueOf(130), townService.findByName("Florentia"),"https://res.cloudinary.com/ivoto22/image/upload/v1635952723/modern-luxury-apartment-block-against-600w-50767555_alspjb.webp");
            Hotel  j24 = new Hotel("J24", 4, BigDecimal.valueOf(187), BigDecimal.valueOf(159), townService.findByName("Milano"),"https://res.cloudinary.com/ivoto22/image/upload/v1635952785/set-3-apartment-buildings-calgary-600w-7799632_bvvt2d.webp");
            Hotel  sanpi = new Hotel("Sanpi", 4, BigDecimal.valueOf(182), BigDecimal.valueOf(148), townService.findByName("Milano"),"https://res.cloudinary.com/ivoto22/image/upload/v1635953029/chaum-phetchaburi-thailand-may-15-600w-641856772_swn0gt.webp");
            Hotel  grandhotelsanmarino = new Hotel("Grand Hotel San Marino", 4, BigDecimal.valueOf(136), BigDecimal.valueOf(122), townService.findByName("San Marino"),"https://res.cloudinary.com/ivoto22/image/upload/v1635953466/miami-beach-coastline-hotel-buildings-600w-470421887_yxtqrf.webp");
            Hotel  rosa = new Hotel("Rosa San Marino", 5, BigDecimal.valueOf(155), BigDecimal.valueOf(133), townService.findByName("San Marino"),"https://res.cloudinary.com/ivoto22/image/upload/v1635953518/osaka-japan-october-18-2018-600w-1305324604_ksv8jg.webp");
            Hotel  ibisstyle = new Hotel("Ibis Styles Budapest", 5, BigDecimal.valueOf(190), BigDecimal.valueOf(171), townService.findByName("Budapest"),"https://res.cloudinary.com/ivoto22/image/upload/v1635953553/apartments-600w-250264204_poczto.webp");
            Hotel  ferihegy = new Hotel("Ferihegy", 3, BigDecimal.valueOf(78), BigDecimal.valueOf(62), townService.findByName("Budapest"),"https://res.cloudinary.com/ivoto22/image/upload/v1635953600/mecca-saudi-arabia-may-05-600w-1118038955_wnmifk.webp");
            Hotel  hhplus = new Hotel("H+ Hotel", 5, BigDecimal.valueOf(200), BigDecimal.valueOf(178), townService.findByName("Vienna"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954326/las-vegas-january-7-aria-600w-124523590_pn5fur.webp");
            Hotel  meinnger = new Hotel("Meinnger", 4, BigDecimal.valueOf(173), BigDecimal.valueOf(152), townService.findByName("Vienna"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954403/las-vegas-may-07-view-600w-144830434_ujxbmb.webp");
            Hotel  amedia = new Hotel("Amedia", 4, BigDecimal.valueOf(168), BigDecimal.valueOf(147), townService.findByName("Vienna"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954479/las-vegas-united-states-jun-600w-1747424951_nsgvst.webp");
            Hotel  alphotel = new Hotel("Alp Hotel", 4, BigDecimal.valueOf(152), BigDecimal.valueOf(137), townService.findByName("Innsbruck"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954511/side-turkey-april-16-2014-600w-559958929_b3hq6c.webp");
            Hotel  munchencitysud = new Hotel("Munchen City Sud", 3, BigDecimal.valueOf(58), BigDecimal.valueOf(40), townService.findByName("Munich"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954702/several-hotel-buildings-on-blue-600w-30855688_s5cdhv.webp");
            Hotel  arabellapark = new Hotel("Arabellapark Munchen", 5, BigDecimal.valueOf(198), BigDecimal.valueOf(190), townService.findByName("Munich"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954737/pattayathailand01022020-bird-eye-view-swimming-600w-1693172521_xrxopc.webp");
            Hotel  laimer = new Hotel("Laimer hotel", 4, BigDecimal.valueOf(128), BigDecimal.valueOf(117), townService.findByName("Munich"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954792/monte-carlo-casino-gambling-entertainment-600w-113483572_pprn35.webp");
            Hotel leonardo = new Hotel("Leonardo Royal hotel", 4, BigDecimal.valueOf(135), BigDecimal.valueOf(127), townService.findByName("Frankfurt"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954838/house-building-city-construction-concept-600w-213775522_cyjcn8.webp");
            Hotel hansa = new Hotel("Hansa hotel", 3, BigDecimal.valueOf(78), BigDecimal.valueOf(69), townService.findByName("Stuttgart"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954865/modern-office-building-sunset-light-600w-648712171_i6aeib.webp");
            Hotel feuerbackhotel = new Hotel("Feuerbach hotel", 5, BigDecimal.valueOf(145), BigDecimal.valueOf(132), townService.findByName("Stuttgart"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954894/luxury-summer-vacation-hotel-blue-600w-30589237_si6uyf.webp");
            Hotel dionis = new Hotel("Dionis", 4, BigDecimal.valueOf(131), BigDecimal.valueOf(120), townService.findByName("Rust"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954931/empty-six-story-florida-condominiums-600w-47472379_z4rs8o.webp");
            Hotel pullman = new Hotel("Pullman", 4, BigDecimal.valueOf(250), BigDecimal.valueOf(238), townService.findByName("Paris"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954960/3d-rendering-hotel-design-hd-600w-1825035605_ql6qtb.webp");
            Hotel raphael = new Hotel("Raphael", 5, BigDecimal.valueOf(312), BigDecimal.valueOf(300), townService.findByName("Paris"),"https://res.cloudinary.com/ivoto22/image/upload/v1635954984/nessebar-bulgaria-aug-28-view-600w-569299726_eupf1i.webp");
            Hotel generator = new Hotel("Generator", 4, BigDecimal.valueOf(230), BigDecimal.valueOf(221), townService.findByName("Paris"),"https://res.cloudinary.com/ivoto22/image/upload/v1635955014/miami-south-beach-night-hotel-600w-104637482_qhhlmy.webp");
            Hotel ibis = new Hotel("Ibis Strasbourg", 3, BigDecimal.valueOf(112), BigDecimal.valueOf(99), townService.findByName("Strasbourg"),"https://res.cloudinary.com/ivoto22/image/upload/v1635955059/luxury-hotel-swimming-pool-600w-946046_1_lp7h5b.webp");
            Hotel carlton = new Hotel("Carlton Lyon", 5, BigDecimal.valueOf(365), BigDecimal.valueOf(320), townService.findByName("Lyon"),"https://res.cloudinary.com/ivoto22/image/upload/v1635955160/3d-render-building-landscape-600w-92140456_vpbmbr.webp");
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
