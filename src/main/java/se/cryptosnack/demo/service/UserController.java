package se.cryptosnack.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import se.cryptosnack.demo.model.User;

@Service
public class UserController {


  @PersistenceContext
  private EntityManager em;


  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @Transactional
  public void add(String username) {
    User user = new User(username);
    em.persist(user);
    LOGGER.info("Book: " + user.getUserName() + " stored");
  }
}
