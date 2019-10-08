package se.cryptosnack.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.SentDTO;

import java.util.List;

@Controller
public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages/created")
    public Message requestSend(SentDTO sentMessage) {
        return messageService.saveMessage(sentMessage);
    }

    @SubscribeMapping("/messages/get")
    public List<Message> loadAllMessages() {
        return messageService.loadChat();
    }



}
