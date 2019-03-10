package spring.backend.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "applicationUsers")
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float longitude;
    private float latitude;
    private float wind;
    @ManyToOne
    private Country country;
    private String month;

    @ManyToMany
    @JoinTable(name = "favorites",
        joinColumns = @JoinColumn(name = "spot_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnore
    private Set<ApplicationUser> applicationUsers = new HashSet<>();



}
