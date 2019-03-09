package spring.backend.springmvcrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.backend.springmvcrest.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}

