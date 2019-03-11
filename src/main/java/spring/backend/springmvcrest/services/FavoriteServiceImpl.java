package spring.backend.springmvcrest.services;

import org.springframework.stereotype.Service;
import spring.backend.springmvcrest.exceptions.NotFoundException;
import spring.backend.springmvcrest.model.ApplicationUser;
import spring.backend.springmvcrest.model.Favorite;
import spring.backend.springmvcrest.model.Spot;
import spring.backend.springmvcrest.repositories.FavoriteRepository;
import spring.backend.springmvcrest.repositories.SpotRepository;
import spring.backend.springmvcrest.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final SpotRepository spotRepository;
    private final EntityManager em;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, UserRepository userRepository, SpotRepository spotRepository, EntityManager em) {
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
        this.spotRepository = spotRepository;
        this.em = em;
    }

    @Override
    public Favorite create(Long user_id, Long spot_id) {
        if(userRepository.countById(user_id) == 0)
            throw new NotFoundException("User not found");
        if(spotRepository.countById(spot_id) == 0)
            throw new NotFoundException("Spot not found");

        ApplicationUser applicationUser = em.getReference(ApplicationUser.class, user_id);
        Spot spot = em.getReference(Spot.class, spot_id);

        Favorite favorite = new Favorite();
        favorite.setUser(applicationUser);
        favorite.setSpot(spot);
        favoriteRepository.saveAndFlush(favorite);

        return favorite;
    }

    @Override
    @Transactional
    public void delete(Long user_id, Long spot_id) {
        Integer ok = favoriteRepository.deleteByUserIdAndSpotId(user_id, spot_id);
    }
}
