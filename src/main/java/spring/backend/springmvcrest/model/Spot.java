package spring.backend.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "applicationUsers")
public class Spot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    private float longitude;
    private float latitude;
    @Min(0)
    @Max(100)
    private float windProbability;
    @ManyToOne
    private Country country;
    @NotBlank
    private String whenToGo;

    @OneToMany(mappedBy = "spot")
    @JsonIgnore
    private Set<Favorite> favorites = new HashSet<>();

    @Override
    public String toString(){
        return this.id + " " + this.name;
    }



}
