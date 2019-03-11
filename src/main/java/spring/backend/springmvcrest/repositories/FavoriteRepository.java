package spring.backend.springmvcrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.backend.springmvcrest.model.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    Integer deleteByUserIdAndSpotId(Long user_id, Long spot_id);


}
