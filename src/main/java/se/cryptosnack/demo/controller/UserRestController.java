package se.cryptosnack.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import se.cryptosnack.demo.model.User;
import se.cryptosnack.demo.model.UserDTO;
import se.cryptosnack.demo.service.EntityService;
import se.cryptosnack.demo.service.MessageServiceImpl;
import se.cryptosnack.demo.service.repositories.UserRepository;

/**
 * RestController for Users. Finding a specific user by name:
 * http://localhost:8080/api/user?username=jonte
 * (Throws exception if not found)
 *
 * REQUIRES POSTMAN/or other equivalent software.
 * Adding specific new Users:
 * http://localhost:8080/api/user?username=newuser&password=hisspassword
 *                                param1,          param2
 * (Loads user jonte and shows him + his encrypted password)
 */
@RestController
@RequestMapping("api/user")
public class UserRestController {

    private static final Logger log = LoggerFactory.getLogger(UserRestController.class);

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

    @RequestMapping(method = RequestMethod.POST)
    public UserDTO create(@RequestParam("username") String username,
                          @RequestParam("password") String password){
        UserDTO userDTO = new UserDTO(username, password);
        log.info("Recieved UserDTO = {}", userDTO.toString());
        entityService.save(userDTO);
        return new UserDTO(userDTO.getUsername(), userDTO.getPassword());
    }
}
