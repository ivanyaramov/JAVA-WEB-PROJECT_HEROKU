package com.example.project.service.impl;

import com.example.project.model.entity.Country;
import com.example.project.model.service.CountryServiceModel;
import com.example.project.model.view.CountryViewModel;
import com.example.project.repository.CountryRepository;
import com.example.project.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
private final CountryRepository countryRepository;
private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initaliseCountries() {
        if(countryRepository.count()==0){
            Country serbia = new Country("Serbia");
            Country bulgaria = new Country("Bulgaria");
            Country croatia = new Country("Croatia");
            Country slovenia = new Country("Slovenia");
            Country hungary = new Country("Hungary");
            Country austria = new Country("Austria");
            Country germany = new Country("Germany");
            Country france = new Country("France");
            Country italy = new Country("Italy");
            Country sanmarino = new Country("San Marino");
            Country vatican = new Country("Vatican");
            Country turkey = new Country("Turkey");
            Country england = new Country("England");
            Country spain = new Country("Spain");
            Country maldives = new Country("Maldives");
            Country portugal = new Country("Portugal");
            Country andorra = new Country("Andorra");
            countryRepository.save(serbia);
            countryRepository.save(bulgaria);
            countryRepository.save(croatia);
            countryRepository.save(slovenia);
            countryRepository.save(hungary);
            countryRepository.save(austria);
            countryRepository.save(germany);
            countryRepository.save(france);
            countryRepository.save(vatican);
            countryRepository.save(italy);
            countryRepository.save(sanmarino);
            countryRepository.save(turkey);
            countryRepository.save(england);
            countryRepository.save(england);
            countryRepository.save(spain);
            countryRepository.save(maldives);
            countryRepository.save(portugal);
            countryRepository.save(andorra);

        }
    }

    @Override
    public Country findByName(String name) {
        return countryRepository.findByName(name).orElse(null);
    }

    @Override
    public boolean existsByName(String name) {
        if(findByName(name)!=null){
            return true;
        }
        return false;
    }

    @Override
    public List<CountryViewModel> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(c->modelMapper.map(c,CountryViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getALlCountriesAsStrings() {
        return getAllCountries().stream()
                .map(c->c.getName()).collect(Collectors.toList());

    }

    @Override
    public void createCountry(CountryServiceModel countryServiceModel) {
        Country country = modelMapper.map(countryServiceModel, Country.class);
        countryRepository.save(country);
    }
}
