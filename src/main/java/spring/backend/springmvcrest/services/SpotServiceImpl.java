package spring.backend.springmvcrest.services;

import org.springframework.stereotype.Service;
import spring.backend.springmvcrest.model.Spot;
import spring.backend.springmvcrest.repositories.SpotRepository;

import java.util.List;
@Service
public class SpotServiceImpl implements SpotService {

    private final SpotRepository spotRepository;

    public SpotServiceImpl(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    @Override
    public Spot findSpotById(Long id) {
        return spotRepository.findById(id).get();
    }

    @Override
    public List<Spot> findAllSpots() {
        return spotRepository.findAll();
    }
}
