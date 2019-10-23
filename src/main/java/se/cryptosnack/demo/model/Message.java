package se.cryptosnack.demo.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Message")
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "message_id")
  private Long id;

  @Column
  private String message;

  @Column
  private LocalDateTime timeSent;

  @ManyToOne
  private User user;

  public Message() {}

  public Message(String message) {
    this.message = message;
    this.timeSent = LocalDateTime.now();
  }

  public Message(String message, LocalDateTime timeSent) {
    this.message = message;
    this.timeSent = timeSent;
  }

  public Message(String message, User user, LocalDateTime timeSent) {
    this.message = message;
    this.user = user;
    this.timeSent = timeSent;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalDateTime getTimeSent() {
    return timeSent;
  }

  public void setTimeSent(LocalDateTime timeSent) {
    this.timeSent = timeSent;
  }

  @Override
  public String toString() {
    return "Message [id=" + id + ", message=" + message + ", timeSent=" + timeSent + ", user="
        + user + "]";
  }


}
