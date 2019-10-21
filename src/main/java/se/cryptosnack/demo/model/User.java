package se.cryptosnack.demo.model;

import se.cryptosnack.demo.config.util.AppReferences;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="User")
public class User {


//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(name = "user_id")
//  private Long id;

  @Id
  @Column(unique = true)
  private String username;

  private String password;

  private String role;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private Set<Message> messageList = new HashSet<>();

  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
    role = AppReferences.USER_ROLE;
  }

//  public User(String userName, String password, String role) {
//    this.userName = userName;
//    this.password = password;
//    this.role = role;
//  }

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

  public Set<Message> getMessageList() {
    return messageList;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public void setMessageList(Set<Message> messageList) {
    this.messageList = messageList;
  }
}
