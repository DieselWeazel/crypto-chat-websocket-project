package se.cryptosnack.demo.model.dto;

import java.util.List;

public class UserDTO {

    private String username;
    private String password;
    private List<String> messageList;

    public UserDTO() {
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTO(String username, String password, List<String> messageList) {
        this.username = username;
        this.password = password;
        this.messageList = messageList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<String> messageList) {
        this.messageList = messageList;
    }

    @Override
    public String
    toString() {
        return  "[username='" + username + '\'' +
                ", password='" + password + '\'' +
                ']';
    }
}
