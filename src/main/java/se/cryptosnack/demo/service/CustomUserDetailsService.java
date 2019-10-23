package se.cryptosnack.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.cryptosnack.demo.model.User;
import se.cryptosnack.demo.service.repositories.UserRepository;

import java.util.Collection;
import java.util.Collections;

@Qualifier("customUserDetailsService")
@Service
public class CustomUserDetailsService extends User implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        if (null == user) {
            throw new UsernameNotFoundException("No user found");
        } else {
            return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
        }
    }

    public User getUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = new User();
        // If Principal is of type User, getList the User.
        // Mandatory
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();

            user = userRepository.findByUsername(username);
            return user;
        }
        return user;
    }
}
