package se.cryptosnack.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.SentDTO;
import se.cryptosnack.demo.service.MessageService;

import java.util.List;

@Controller
public class MessageWebsocketController {

    private static final Logger log = LoggerFactory.getLogger(MessageWebsocketController.class);

    private final MessageService<Message, SentDTO> messageService;

    public MessageWebsocketController(MessageService<Message, SentDTO> messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message sendMessage(SentDTO sentMessage) {
        log.info("recieved: {}", sentMessage.getMessage());
//        return new Message("Hello " + HtmlUtils.htmlEscape(sentMessage.getMessage()) + ".");
        return messageService.save(sentMessage);
    }

    @SubscribeMapping("/messages")
    public List<Message> loadAllMessages() {
        log.info("loadAllMessages() has been called");
        return messageService.loadHistory();
    }
}
