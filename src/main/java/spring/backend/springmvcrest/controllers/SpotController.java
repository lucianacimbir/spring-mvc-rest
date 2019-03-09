package spring.backend.springmvcrest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.backend.springmvcrest.model.Spot;
import spring.backend.springmvcrest.services.SpotService;
import java.util.List;

@RestController
@RequestMapping(SpotController.BASE_URL)
public class SpotController {

    public static final String BASE_URL = "/api/spots";

    private final SpotService spotService;

    public SpotController(SpotService spotService) {
        this.spotService = spotService;
    }

    @GetMapping
    public List<Spot> getAllSpots(){
        return spotService.findAllSpots();
    }

    @GetMapping("/{id}")
    public Spot getSpotById(@PathVariable Long id){
        return spotService.findSpotById(id);
    }
}
