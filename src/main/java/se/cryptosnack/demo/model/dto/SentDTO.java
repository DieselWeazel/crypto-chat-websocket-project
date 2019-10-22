package se.cryptosnack.demo.model.dto;

/**
 * Data Transfer Class, takes the recieved message and turns it into a Message via Controller.
 */
public class SentDTO {

    private String message;
    private String sentFrom;
    private String timeSent;

    public SentDTO() {
    }

    public SentDTO(String message, String sentFrom) {
        this.message = message;
        this.sentFrom = sentFrom;
    }

    public SentDTO(String message, String sentFrom, String timeSent) {
        this.message = message;
        this.sentFrom = sentFrom;
        this.timeSent = timeSent;
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

    public String getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(String timeSent) {
        this.timeSent = timeSent;
    }

    @Override
    public String toString() {
        return "SentDTO{" +
                "message='" + message + '\'' +
                ", sentFrom='" + sentFrom + '\'' +
                ", timeSent='" + timeSent + '\'' +
                '}';
    }
}
