package spring.backend.springmvcrest.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import spring.backend.springmvcrest.model.ApplicationUser;
import spring.backend.springmvcrest.services.FavoriteService;

import java.util.Map;

@RestController
@RequestMapping(FavoriteController.BASE_URL)
public class FavoriteController {

    public static final String BASE_URL = "/api/favorites/spots";

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApplicationUser create(@RequestBody Map<String, Object> body){
        Long user_id = Long.valueOf(body.get("user_id").toString()).longValue();
        Long spot_id = Long.valueOf(body.get("spot_id").toString()).longValue();
        return favoriteService.create(user_id, spot_id);
    }
}
