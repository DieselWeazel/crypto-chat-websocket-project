package se.cryptosnack.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.cryptosnack.demo.controller.MessageRestController;
import se.cryptosnack.demo.model.User;
import se.cryptosnack.demo.model.UserDTO;
import se.cryptosnack.demo.service.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements EntityService<User, UserDTO> {

    private static final Logger log = LoggerFactory.getLogger(EntityService.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> loadAll() {
        return userRepository.findAll().stream().map(user -> new User(user.getUsername(), user.getPassword())).collect(Collectors.toList());

    }

    @Override
    public User save(UserDTO userDTO) {
        log.info("Saving new User = {}", new User(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword())));
        return userRepository.save(new User(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword())));
    }

}
