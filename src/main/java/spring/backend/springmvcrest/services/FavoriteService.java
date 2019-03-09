package spring.backend.springmvcrest.services;

import spring.backend.springmvcrest.model.User;

public interface FavoriteService {

    User create(Long user_id, Long spot_id);

    void delete(Long user_id, Long spot_id);
}
