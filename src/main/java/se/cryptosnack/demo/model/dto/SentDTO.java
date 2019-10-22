package se.cryptosnack.demo.model.dto;

/**
 * Data Transfer Class, takes the recieved message and turns it into a Message via Controller.
 */
public class SentDTO {

    private String message;

    public SentDTO() {
    }

    public SentDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
