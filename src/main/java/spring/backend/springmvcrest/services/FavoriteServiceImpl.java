package spring.backend.springmvcrest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.backend.springmvcrest.model.Spot;
import spring.backend.springmvcrest.model.User;
import spring.backend.springmvcrest.repositories.SpotRepository;
import spring.backend.springmvcrest.repositories.UserRepository;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final UserRepository userRepository;
    private final SpotRepository spotRepository;


    @Autowired
    public FavoriteServiceImpl(UserRepository userRepository, SpotRepository spotRepository) {
        this.userRepository = userRepository;
        this.spotRepository = spotRepository;
        System.out.println("dwadwadwadwa");
        System.out.println(this.userRepository);
    }


    @Override
    public User create(Long user_id, Long spot_id) {
        System.out.println("balalalalala");
        System.out.println(user_id);
        System.out.println(spot_id);
        System.out.println(this.userRepository);
        System.out.println(spotRepository.findAll().toString());
        System.out.println(userRepository.findAll().toString());
        System.out.println("balalalalala");
        User user = userRepository.findById(user_id).get();

        System.out.println(user);
        Spot spot = spotRepository.findById(spot_id).get();

        //System.out.println(spot);

        System.out.println(user.getSpots());
        user.getSpots().add(spot);
        //spot.getUsers().add(user);
        userRepository.save(user);
        //spotRepository.save(spot);

        return user;
    }

    @Override
    public void delete(Long user_id, Long spot_id) {

    }
}
