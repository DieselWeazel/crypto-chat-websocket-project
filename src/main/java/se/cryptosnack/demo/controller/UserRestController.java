package se.cryptosnack.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.cryptosnack.demo.model.User;
import se.cryptosnack.demo.service.CustomUserDetailsService;
import se.cryptosnack.demo.service.repositories.UserRepository;

import java.util.Collections;

/**
 * RestController for Users. Example:
 * http://localhost:8080/api/user/?username=jonte
 * (Loads user jonte and shows him + his encrypted password)
 */
@RestController
@RequestMapping("api/user/")
public class UserRestController {

    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public User findByUsername(@RequestParam("username") String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User doesn't exist here");
        } else {
            return new User(user.getUsername(), user.getPassword());
        }
    }
}
