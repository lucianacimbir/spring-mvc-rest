package spring.backend.springmvcrest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.backend.springmvcrest.model.Country;
import spring.backend.springmvcrest.model.Spot;
import spring.backend.springmvcrest.model.ApplicationUser;
import spring.backend.springmvcrest.repositories.CountryRepository;
import spring.backend.springmvcrest.repositories.SpotRepository;
import spring.backend.springmvcrest.repositories.UserRepository;

import java.util.ArrayList;

@Component
public class BootStrapData implements CommandLineRunner {

    private final SpotRepository spotRepository;
    private final UserRepository userRepository;
    private final CountryRepository countryRepository;

    public BootStrapData(SpotRepository spotRepository, UserRepository userRepository, CountryRepository countryRepository) {
        this.spotRepository = spotRepository;
        this.userRepository = userRepository;
        this.countryRepository = countryRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Country country = new Country();
        country.setName("Spain");
        countryRepository.save(country);

        Spot spot = new Spot();
        spot.setName("abracadabra");
        spot.setCountry(country);
        //spotRepository.save(spot);

        Spot spot2 = new Spot();
        spot2.setName("mac");
        spot2.setCountry(country);
        //spotRepository.save(spot2);


        ApplicationUser applicationUser = new ApplicationUser("andrei", "12345");
        applicationUser.setName("Andrei");

        applicationUser.getSpots().add(spot);
        spot.getApplicationUsers().add(applicationUser);

        applicationUser.getSpots().add(spot2);
        spot2.getApplicationUsers().add(applicationUser);

        userRepository.save(applicationUser);

        spotRepository.save(spot);
        spotRepository.save(spot2);



    }
}
