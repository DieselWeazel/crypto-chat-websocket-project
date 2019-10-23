package se.cryptosnack.demo.model;

import java.time.LocalDateTime;

/**
 * Data Transfer Class, takes the recieved message and turns it into a Message via Controller.
 */
public class SentDTO {

  private String messageText;
  private LocalDateTime timeSent;
  private User user;

  public SentDTO(String messageText, User user) {
    this.messageText = messageText;
    this.user = user;
  }

  public String getMessageText() {
    return messageText;
  }

  public void setMessageText(String messageText) {
    this.messageText = messageText;
  }

  public LocalDateTime getTimeSent() {
    return timeSent;
  }

  public void setTimeSent(LocalDateTime timeSent) {
    this.timeSent = timeSent;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "SentDTO [messageText=" + messageText + ", timeSent=" + timeSent + ", user=" + user
        + "]";
  }


}
