package se.cryptosnack.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.SentDTO;
import se.cryptosnack.demo.service.MessageService;

import java.util.List;

/**
 * RestController for Users. Example:
 * http://localhost:8080/api/message/
 * (Loads all messages in the chatroom)
 */
@RestController
@RequestMapping("api/message")
public class MessageRestController {

    private final MessageService<Message, SentDTO> messageService;

    public MessageRestController(MessageService<Message, SentDTO> messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> findMessages() {
        return messageService.loadHistory();
    }
}
