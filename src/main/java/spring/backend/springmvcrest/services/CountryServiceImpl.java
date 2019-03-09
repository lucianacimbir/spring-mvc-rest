package spring.backend.springmvcrest.services;

import org.springframework.stereotype.Service;
import spring.backend.springmvcrest.model.Country;
import spring.backend.springmvcrest.repositories.CountryRepository;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }
}
