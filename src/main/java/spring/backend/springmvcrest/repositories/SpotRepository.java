package spring.backend.springmvcrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.backend.springmvcrest.model.Spot;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {
}
