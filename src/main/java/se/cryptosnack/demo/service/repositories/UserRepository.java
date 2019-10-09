package se.cryptosnack.demo.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.cryptosnack.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
