package spring.backend.springmvcrest.services;

import org.springframework.stereotype.Service;
import spring.backend.springmvcrest.exceptions.NotFoundException;
import spring.backend.springmvcrest.model.Spot;
import spring.backend.springmvcrest.repositories.SpotRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SpotServiceImpl implements SpotService {

    private final SpotRepository spotRepository;

    public SpotServiceImpl(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    @Override
    public Spot findSpotById(Long id) {
        Optional<Spot> spot = spotRepository.findById(id);
        if(!spot.isPresent())
            throw new NotFoundException("Spot not found");

        return spotRepository.findById(id).get();
    }

    @Override
    public List<Spot> findAllSpots() {
        return spotRepository.findAll();
    }
}
