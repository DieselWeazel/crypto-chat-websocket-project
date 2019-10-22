package se.cryptosnack.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.SentDTO;
import se.cryptosnack.demo.model.User;
import se.cryptosnack.demo.service.EntityService;
import se.cryptosnack.demo.service.repositories.UserRepository;

@SpringBootApplication
public class DemoApplication {


  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner addSomeMessages(EntityService<Message, SentDTO> entityService) {
    return args -> {
      entityService.save(new SentDTO("Hello"));
      entityService.save(new SentDTO("Sup"));
      entityService.save(new SentDTO("Yo dude"));
    };
  }

  @Bean
  public CommandLineRunner addSomeUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    return args -> {
      userRepository.save(new User("august", passwordEncoder.encode("august")));
      userRepository.save(new User("david", passwordEncoder.encode("david")));
      userRepository.save(new User("erik", passwordEncoder.encode("erik")));
      userRepository.save(new User("jonte", passwordEncoder.encode("jonte")));
    };
  }



}
