package spring.backend.springmvcrest.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@JsonIdentityInfo(
                  generator = ObjectIdGenerators.PropertyGenerator.class,
                  property = "id"
                 )
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;

    @ManyToMany(mappedBy = "users")
    private Set<Spot> spots = new HashSet<>();

    public User(String username, String password, List<Object> emptyList) {
    }
}
