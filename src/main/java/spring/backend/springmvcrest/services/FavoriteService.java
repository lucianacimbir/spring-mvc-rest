package spring.backend.springmvcrest.services;

import spring.backend.springmvcrest.model.Favorite;

public interface FavoriteService {

    Favorite create(Long user_id, Long spot_id);

    void delete(Long user_id, Long spot_id);
}
