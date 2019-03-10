package spring.backend.springmvcrest.controllers;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.web.bind.annotation.*;
import spring.backend.springmvcrest.model.ApplicationUser;
import spring.backend.springmvcrest.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
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
    public void signUp(@RequestBody Map<String, Object> body) {
        System.out.println(body);
        String pass = bCryptPasswordEncoder.encode(body.get("password").toString());
        String username = body.get("username").toString();

        ApplicationUser applicationUser = new ApplicationUser(username, pass);

        userRepository.save(applicationUser);
    }
}
