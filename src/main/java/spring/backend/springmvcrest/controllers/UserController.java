package spring.backend.springmvcrest.controllers;

import org.springframework.web.bind.annotation.*;
import spring.backend.springmvcrest.model.ApplicationUser;
import spring.backend.springmvcrest.repositories.UserRepository;

import java.util.Map;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api";

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ApplicationUser signUp(@RequestBody Map<String, Object> body) {
        String pass = body.get("password").toString();
        String username = body.get("username").toString();

        ApplicationUser applicationUser = new ApplicationUser(username, pass);

        userRepository.save(applicationUser);

        return applicationUser;
    }
}
