package se.cryptosnack.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.SentDTO;
import se.cryptosnack.demo.service.EntityService;

import java.util.List;

/**
 * RestController for Users. Example:
 * http://localhost:8080/api/message/
 * (Loads all messages in the chatroom)
 */
@RestController
@RequestMapping("api/message")
public class MessageRestController {

    private final EntityService<Message, SentDTO> entityService;

    public MessageRestController(EntityService<Message, SentDTO> entityService) {
        this.entityService = entityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> findMessages() {
        return entityService.loadAll();
    }
}
