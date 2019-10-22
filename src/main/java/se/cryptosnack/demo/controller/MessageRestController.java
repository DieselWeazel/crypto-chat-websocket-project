package se.cryptosnack.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.dto.SentDTO;
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

    private static final Logger log = LoggerFactory.getLogger(MessageRestController.class);

    private final EntityService<SentDTO> entityService;

    public MessageRestController(EntityService<SentDTO> entityService) {
        this.entityService = entityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SentDTO> findMessages() {
        return entityService.loadAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public SentDTO create(@RequestBody SentDTO sentDTO) {
        entityService.save(sentDTO);
        return sentDTO;
    }
}
