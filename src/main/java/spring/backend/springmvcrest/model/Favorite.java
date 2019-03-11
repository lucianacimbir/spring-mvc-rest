package spring.backend.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private ApplicationUser user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "spot_id")
    private Spot spot;
}
