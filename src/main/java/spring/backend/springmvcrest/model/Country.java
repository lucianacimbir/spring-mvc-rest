package spring.backend.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    @JsonIgnore
    private Set<Spot> spot = new HashSet<>();
}
