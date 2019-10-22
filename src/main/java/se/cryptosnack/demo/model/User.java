package se.cryptosnack.demo.model;

import se.cryptosnack.demo.config.util.AppReferences;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="User")
public class User {


  @Id
  @Column(unique = true)
  private String username;

  private String password;

  private String role;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<Message> messageList = new ArrayList<>();

  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
    role = AppReferences.USER_ROLE;
  }

  public User(String username, String password, String role, List<Message> messageList) {
    this.username = username;
    this.password = password;
    this.role = role;
    this.messageList = messageList;
  }

  public String getUsername() {
    return username;
  }

  public void setUserName(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Message> getMessageList() {
    return messageList;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public void setMessageList(List<Message> messageList) {
    this.messageList = messageList;
  }

  @Override
  public String toString() {
    return "[username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", role='" + role + '\'' +
            ']';
  }
}
