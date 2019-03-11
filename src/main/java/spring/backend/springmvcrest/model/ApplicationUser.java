package spring.backend.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @Size(min = 6)
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Favorite> favorites = new HashSet<>();

    public ApplicationUser(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = bCryptPasswordEncoder().encode(password);
    }

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public ApplicationUser() {
    }
}
