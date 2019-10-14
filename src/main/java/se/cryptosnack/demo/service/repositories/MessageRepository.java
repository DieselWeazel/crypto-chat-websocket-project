package se.cryptosnack.demo.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.User;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
