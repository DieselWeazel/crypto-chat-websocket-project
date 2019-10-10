package se.cryptosnack.demo.site;

import java.util.Scanner;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

public class StompClient {

  private static String url = "ws://172.20.35.64:8080/cryptosnack-websocket";

  public static void main(String[] args) {
    WebSocketClient webSocketClient = new StandardWebSocketClient();
    WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
    stompClient.setMessageConverter(new MappingJackson2MessageConverter());
    stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

    StompSessionHandler sessionHandler = new MyStompSessionHandler();
    stompClient.connect(url, sessionHandler);

    new Scanner(System.in).nextLine();
  }

}
