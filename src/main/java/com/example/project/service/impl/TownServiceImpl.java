package com.example.project.service.impl;

import com.example.project.model.entity.Town;
import com.example.project.repository.TownRepository;
import com.example.project.service.CountryService;
import com.example.project.service.TownService;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final CountryService countryService;

    public TownServiceImpl(TownRepository townRepository, CountryService countryService) {
        this.townRepository = townRepository;
        this.countryService = countryService;
    }

    @Override
    public void initialiseTowns() {
        if (townRepository.count()==0){
            Town sofia = new Town("Sofia");
            sofia.setCountry(countryService.findByName("Bulgaria"));
            townRepository.save(sofia);
            Town belgrade = new Town("Belgrade");
            belgrade.setCountry(countryService.findByName("Serbia"));
            townRepository.save(belgrade);
            Town dubrovnik = new Town("Dubrovnik");
            dubrovnik.setCountry(countryService.findByName("Croatia"));
            townRepository.save(dubrovnik);
            Town zagreb = new Town("Zagreb");
            zagreb.setCountry(countryService.findByName("Croatia"));
            townRepository.save(zagreb);
            Town ljubljana = new Town("Ljubljana");
            ljubljana.setCountry(countryService.findByName("Slovenia"));
            townRepository.save(ljubljana);
            Town rome = new Town("Rome");
            rome.setCountry(countryService.findByName("Italy"));
            townRepository.save(rome);
            Town florentia = new Town("Florentia");
            florentia.setCountry(countryService.findByName("Italy"));
            townRepository.save(florentia);
            Town milano = new Town("Milano");
            milano.setCountry(countryService.findByName("Italy"));
            townRepository.save(milano);
            Town sanmarino = new Town("San Marino");
            sanmarino.setCountry(countryService.findByName("San Marino"));
            townRepository.save(sanmarino);
            Town vatican = new Town("Vatican");
            vatican.setCountry(countryService.findByName("Vatican"));
            townRepository.save(vatican);
            Town budapest = new Town("Budapest");
            budapest.setCountry(countryService.findByName("Hungary"));
            townRepository.save(budapest);
            Town vienna = new Town("Vienna");
            vienna.setCountry(countryService.findByName("Austria"));
            townRepository.save(vienna);
            Town innsbruck = new Town("Innsbruck");
            innsbruck.setCountry(countryService.findByName("Austria"));
            townRepository.save(innsbruck);
            Town munich = new Town("Munich");
            munich.setCountry(countryService.findByName("Germany"));
            townRepository.save(munich);
            Town frankfurt = new Town("Frankfurt");
            frankfurt.setCountry(countryService.findByName("Germany"));
            townRepository.save(frankfurt);
            Town stuttgart = new Town("Stuttgart");
            stuttgart.setCountry(countryService.findByName("Germany"));
            townRepository.save(stuttgart);
            Town rust = new Town("Rust");
            rust.setCountry(countryService.findByName("Germany"));
            townRepository.save(rust);
            Town paris = new Town("Paris");
            paris.setCountry(countryService.findByName("France"));
            townRepository.save(paris);
            Town strasbourg = new Town("Strasbourg");
            strasbourg.setCountry(countryService.findByName("France"));
            townRepository.save(strasbourg);
            Town lyon = new Town("Lyon");
            lyon.setCountry(countryService.findByName("France"));
            townRepository.save(lyon);
            Town andorra = new Town("Andorra");
            andorra.setCountry(countryService.findByName("Andorra"));
            townRepository.save(andorra);
            Town madrid = new Town("Madrid");
            madrid.setCountry(countryService.findByName("Spain"));
            townRepository.save(madrid);
            Town barcelona = new Town("Barcelona");
            barcelona.setCountry(countryService.findByName("Spain"));
            townRepository.save(barcelona);
            Town seville = new Town("Seville");
            seville.setCountry(countryService.findByName("Spain"));
            townRepository.save(seville);
            Town lisbon = new Town("Lisbon");
            lisbon.setCountry(countryService.findByName("Portugal"));
            townRepository.save(lisbon);
            Town porto = new Town("Porto");
            porto.setCountry(countryService.findByName("Portugal"));
            townRepository.save(porto);
            Town male = new Town("Male");
            male.setCountry(countryService.findByName("Maldives"));
            townRepository.save(male);
            Town istanbul = new Town("Istanbul");
            istanbul.setCountry(countryService.findByName("Turkey"));
            townRepository.save(istanbul);
            Town london = new Town("London");
            london.setCountry(countryService.findByName("England"));
            townRepository.save(london);


        }
    }

    @Override
    public Town findByName(String name) {
        return townRepository.findByName(name).orElse(null);
    }
}
