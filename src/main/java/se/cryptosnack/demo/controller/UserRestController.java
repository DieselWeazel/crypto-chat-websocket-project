package se.cryptosnack.demo.controller;


import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import se.cryptosnack.demo.model.User;
import se.cryptosnack.demo.model.UserDTO;
import se.cryptosnack.demo.service.EntityService;
import se.cryptosnack.demo.service.repositories.UserRepository;

/**
 * RestController for Users. Example:
 * http://localhost:8080/api/user/?username=jonte
 * (Loads user jonte and shows him + his encrypted password)
 */
@RestController
@RequestMapping("api/user/")
public class UserRestController {

    private final UserRepository userRepository;
    private final EntityService<User, UserDTO> entityService;

    public UserRestController(UserRepository userRepository, EntityService<User, UserDTO> entityService) {
        this.userRepository = userRepository;
        this.entityService = entityService;
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

    @RequestMapping(value="/post", method = RequestMethod.POST)
    public User create(@RequestBody UserDTO userDTO){
        return entityService.save(userDTO);
    }
}
