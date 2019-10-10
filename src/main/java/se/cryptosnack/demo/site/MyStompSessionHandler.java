package se.cryptosnack.demo.site;

import java.lang.reflect.Type;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

public class MyStompSessionHandler extends StompSessionHandlerAdapter {

  private Logger logger = LogManager.getLogger(MyStompSessionHandler.class);

  @Override
  public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {
    logger.info("YAY New session connected: " + stompSession.getSessionId());
    stompSession.subscribe("/topic/messages", this);
    logger.info("YAY session: " + stompSession.getSessionId() + "subscribed to /topic/messages");
    stompSession.send("/app/chat", getSampleMessage());
  }

  @Override
  public void handleException(StompSession session, StompCommand command, StompHeaders headers,
      byte[] payload, Throwable exception) {
    logger.error("OH NO Got an exception", exception);
  }

  @Override
  public Type getPayloadType(StompHeaders headers) {
    return String.class;
  }

  @Override
  public void handleFrame(StompHeaders stompHeaders, Object payload) {
    String message = (String) payload;
    logger.info("YAY Recieved string: " + message);
  }

  private String getSampleMessage() {
    return "Howdy!!";
  }

}
