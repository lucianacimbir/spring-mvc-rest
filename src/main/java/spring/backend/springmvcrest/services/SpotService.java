package spring.backend.springmvcrest.services;

import spring.backend.springmvcrest.model.Spot;

import java.util.List;

public interface SpotService {

    Spot findSpotById(Long id);

    List<Spot> findAllSpots();
}
