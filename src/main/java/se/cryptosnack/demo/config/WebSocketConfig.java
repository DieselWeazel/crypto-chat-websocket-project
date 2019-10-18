package se.cryptosnack.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//    public static final String WEBSOCKET_MESSAGES = "messages";
//    public static final String WEBSOCKET_APP = "/app";
//    public static final String WEBSOCKET_ENDPOINT = "/cryptosnack-websocket";
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(WebSocketReferences.WEBSOCKET_TOPIC);
        registry.setApplicationDestinationPrefixes(WebSocketReferences.WEBSOCKET_APP);
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(WebSocketReferences.WEBSOCKET_ENDPOINT).withSockJS();
    }
}
