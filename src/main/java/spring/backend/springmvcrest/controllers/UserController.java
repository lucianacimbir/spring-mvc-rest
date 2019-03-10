package spring.backend.springmvcrest.controllers;

import org.springframework.web.bind.annotation.*;
import spring.backend.springmvcrest.model.ApplicationUser;
import spring.backend.springmvcrest.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Map;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api";

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/signup")
    public ApplicationUser signUp(@RequestBody Map<String, Object> body) {
        String pass = bCryptPasswordEncoder.encode(body.get("password").toString());
        String username = body.get("username").toString();

        ApplicationUser applicationUser = new ApplicationUser(username, pass);

        userRepository.save(applicationUser);

        return applicationUser;
    }
    }
}
