package se.cryptosnack.demo.model.dto;

/**
 * Data Transfer Class, takes the recieved message and turns it into a Message via Controller.
 */
public class SentDTO {

    private String message;
    private String sentFrom;

    public SentDTO() {
    }

    public SentDTO(String message, String sentFrom) {
        this.message = message;
        this.sentFrom = sentFrom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSentFrom() {
        return sentFrom;
    }

    public void setSentFrom(String sentFrom) {
        this.sentFrom = sentFrom;
    }

    @Override
    public String toString() {
        return "SentDTO{" +
                "message='" + message + '\'' +
                ", sentFrom='" + sentFrom + '\'' +
                '}';
    }
}
