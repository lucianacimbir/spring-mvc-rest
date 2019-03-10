package spring.backend.springmvcrest.services;

import spring.backend.springmvcrest.model.ApplicationUser;
import spring.backend.springmvcrest.model.Spot;

public interface FavoriteService {

    ApplicationUser create(Long user_id, Long spot_id);

    void delete(Long user_id, Long spot_id);
}
