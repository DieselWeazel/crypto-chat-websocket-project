package se.cryptosnack.demo.service;

import org.springframework.stereotype.Service;
import se.cryptosnack.demo.model.User;
import se.cryptosnack.demo.service.repositories.UserRepository;

@Service
public class MessageOwnerService extends User {

    private final UserRepository userRepository;

    public MessageOwnerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getSentFromUser(String sentFrom) {
        return userRepository.findByUsername(sentFrom);
    }
}
