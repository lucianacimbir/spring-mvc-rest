package spring.backend.springmvcrest.services;

import org.springframework.stereotype.Service;
import spring.backend.springmvcrest.model.ApplicationUser;
import spring.backend.springmvcrest.model.Favorite;
import spring.backend.springmvcrest.model.Spot;
import spring.backend.springmvcrest.repositories.FavoriteRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final EntityManager em;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, EntityManager em) {
        this.favoriteRepository = favoriteRepository;
        this.em = em;
    }

    @Override
    public Favorite create(Long user_id, Long spot_id) {

        ApplicationUser applicationUser = em.getReference(ApplicationUser.class, user_id);
        Spot spot = em.getReference(Spot.class, spot_id);
        Favorite favorite = new Favorite();
        favorite.setUser(applicationUser);
        favorite.setSpot(spot);
        favoriteRepository.save(favorite);

        return favorite;
    }

    @Override
    @Transactional
    public void delete(Long user_id, Long spot_id) {

        Integer ok = favoriteRepository.deleteByUserIdAndSpotId(user_id, spot_id);

    }
}
