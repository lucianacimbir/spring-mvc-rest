package spring.backend.springmvcrest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.backend.springmvcrest.model.Country;
import spring.backend.springmvcrest.services.CountryService;

import java.util.List;

@RestController
@RequestMapping(CountryController.BASE_URL)
public class CountryController {

    public static final String BASE_URL = "/api/spots/countries";

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getAllSpots(){
        return countryService.findAllCountries();
    }

}
