package se.cryptosnack.demo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;
    private String message;
    private LocalDate messageSent;

    @ManyToOne
    private User user;

    public Message(String message) {
        this.message = message;
        this.messageSent = LocalDate.now();
    }

    public Message(String message, LocalDate messageSent) {
        this.message = message;
        this.messageSent = messageSent;
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

    public LocalDate getMessageSent() {
        return messageSent;
    }

    public void setMessageSent(LocalDate messageSent) {
        this.messageSent = messageSent;
    }
}
