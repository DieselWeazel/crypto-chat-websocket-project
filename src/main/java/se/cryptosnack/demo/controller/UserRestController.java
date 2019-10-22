package se.cryptosnack.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import se.cryptosnack.demo.model.User;
import se.cryptosnack.demo.model.dto.UserDTO;
import se.cryptosnack.demo.service.EntityService;
import se.cryptosnack.demo.service.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

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
    private final EntityService<UserDTO> entityService;
    private final PasswordEncoder passwordEncoder;

    public UserRestController(UserRepository userRepository, EntityService<UserDTO> entityService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.entityService = entityService;
        this.passwordEncoder = passwordEncoder;
    }


    @RequestMapping(method = RequestMethod.GET)
    public UserDTO findByUsername(@RequestParam("username") String username) {
        User user = userRepository.findByUsername(username);
        log.info("Message 1 in messagelist = {}", userRepository.findByUsername(username).getMessageList().size());
        if (user == null) {
            throw new UsernameNotFoundException("User doesn't exist here");
        } else {
            return new UserDTO(user.getUsername(), user.getPassword(), user.getMessageList().stream().map(message -> passwordEncoder.encode(message.getMessage())).collect(Collectors.toList()));
        }
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserDTO> findAllUsers() {
        return entityService.loadAll();
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
