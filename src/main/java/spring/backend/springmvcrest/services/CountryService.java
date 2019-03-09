package spring.backend.springmvcrest.services;

import spring.backend.springmvcrest.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAllCountries();
}
