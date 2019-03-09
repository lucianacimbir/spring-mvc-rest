package spring.backend.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "users")
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private float longitude;
    private float latitude;
    private float wind;
    @ManyToOne
    @JsonManagedReference
    private Country country;
    private String month;

    @ManyToMany
    @JoinTable(name = "favorites",
        joinColumns = @JoinColumn(name = "spot_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonBackReference
    private Set<User> users = new HashSet<>();



}
