package spring.backend.springmvcrest.controllers;

import org.springframework.web.bind.annotation.*;
import spring.backend.springmvcrest.exceptions.InvalidParametersException;
import spring.backend.springmvcrest.exceptions.NotFoundException;
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
        if(!(body.containsKey("name")&&body.containsKey("password")&&body.containsKey("username")))
            throw new InvalidParametersException("Parameter missing");

        String name = body.get("name").toString();
        String pass = body.get("password").toString();
        String username = body.get("username").toString();

        ApplicationUser applicationUser = new ApplicationUser(name, username, pass);

        userRepository.saveAndFlush(applicationUser);

        return applicationUser;
    }
}
