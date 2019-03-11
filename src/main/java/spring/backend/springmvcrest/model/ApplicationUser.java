package spring.backend.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Favorite> favorites = new HashSet<>();

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = bCryptPasswordEncoder().encode(password);
    }

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public ApplicationUser() {
    }
}
