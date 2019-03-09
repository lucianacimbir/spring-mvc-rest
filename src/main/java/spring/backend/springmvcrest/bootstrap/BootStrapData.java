package spring.backend.springmvcrest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.backend.springmvcrest.model.Country;
import spring.backend.springmvcrest.model.Spot;
import spring.backend.springmvcrest.model.User;
import spring.backend.springmvcrest.repositories.CountryRepository;
import spring.backend.springmvcrest.repositories.SpotRepository;
import spring.backend.springmvcrest.repositories.UserRepository;

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


        User user = new User();
        user.setName("Andrei");

        user.getSpots().add(spot);
        spot.getUsers().add(user);

        user.getSpots().add(spot2);
        spot2.getUsers().add(user);

        userRepository.save(user);

        spotRepository.save(spot);
        spotRepository.save(spot2);



    }
}
