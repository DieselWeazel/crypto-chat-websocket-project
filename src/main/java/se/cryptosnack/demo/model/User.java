package se.cryptosnack.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="User")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  @Column(unique = true)
  private String userName;

  private String password;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
  private Set<Message> messageList = new HashSet<>();

  public User(String userName) {
    this.userName = userName;
  }

  public Long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
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

  public void setMessageList(Set<Message> messageList) {
    this.messageList = messageList;
  }
}
