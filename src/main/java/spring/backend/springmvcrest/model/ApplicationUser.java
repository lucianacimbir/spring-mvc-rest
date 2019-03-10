package spring.backend.springmvcrest.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "applicationUsers")
    private Set<Spot> spots = new HashSet<>();

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ApplicationUser() {
    }
}
