package spring.backend.springmvcrest.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.backend.springmvcrest.model.Country;
import spring.backend.springmvcrest.model.Favorite;
import spring.backend.springmvcrest.model.Spot;
import spring.backend.springmvcrest.model.ApplicationUser;
import spring.backend.springmvcrest.repositories.CountryRepository;
import spring.backend.springmvcrest.repositories.FavoriteRepository;
import spring.backend.springmvcrest.repositories.SpotRepository;
import spring.backend.springmvcrest.repositories.UserRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final SpotRepository spotRepository;
    private final UserRepository userRepository;
    private final CountryRepository countryRepository;
    private final FavoriteRepository favoriteRepository;

    public BootStrapData(SpotRepository spotRepository, UserRepository userRepository, CountryRepository countryRepository, FavoriteRepository favoriteRepository) {
        this.spotRepository = spotRepository;
        this.userRepository = userRepository;
        this.countryRepository = countryRepository;
        this.favoriteRepository = favoriteRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Country country = new Country();
        country.setName("Spain");
        countryRepository.saveAndFlush(country);

        Spot spot = new Spot();
        spot.setName("abracadabra");
        spot.setWhenToGo("SEPTEMBER");
        spot.setWindProbability(30);
        spot.setCountry(country);

        Spot spot2 = new Spot();
        spot2.setName("macmac");
        spot2.setWhenToGo("MAY");
        spot2.setCountry(country);

        Spot spot3 = new Spot();
        spot3.setName("balala");
        spot3.setWhenToGo("APRIL");
        spot3.setCountry(country);


        ApplicationUser applicationUser = new ApplicationUser("Andrei", "andrei", "123456");

        ApplicationUser applicationUser1 = new ApplicationUser("Maria", "merry", "christmas");

        userRepository.saveAndFlush(applicationUser);
        userRepository.saveAndFlush(applicationUser1);

        spotRepository.saveAndFlush(spot);
        spotRepository.saveAndFlush(spot2);
        spotRepository.saveAndFlush(spot3);


        Favorite favorite2 = new Favorite();
        favorite2.setUser(applicationUser);
        favorite2.setSpot(spot2);

        Favorite favorite3 = new Favorite();
        favorite3.setUser(applicationUser);
        favorite3.setSpot(spot3);

        Favorite favorite4 = new Favorite();
        favorite4.setUser(applicationUser1);
        favorite4.setSpot(spot);

        favoriteRepository.saveAndFlush(favorite2);
        favoriteRepository.saveAndFlush(favorite3);
        favoriteRepository.saveAndFlush(favorite4);



    }
}
