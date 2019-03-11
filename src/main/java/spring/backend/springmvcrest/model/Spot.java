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
    private float windProbability;
    @ManyToOne
    private Country country;
    private String whenToGo;

    @OneToMany(mappedBy = "spot")
    @JsonIgnore
    private Set<Favorite> favorites = new HashSet<>();

    @Override
    public String toString(){
        return this.id + " " + this.name;
    }



}
