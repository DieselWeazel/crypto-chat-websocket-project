package se.cryptosnack.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import se.cryptosnack.demo.controller.MessageWebsocketController;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.SentDTO;
import se.cryptosnack.demo.service.repositories.MessageRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements EntityService<Message, SentDTO> {

    private static final Logger log = LoggerFactory.getLogger(MessageWebsocketController.class);

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> loadAll() {
//        messageRepository.findAll().stream().map(message -> log.info("Loading message = {}", new Message(message.getMessage(), message.getMessageSent()));
        log.info("loading Message = {}", messageRepository.findAll().stream().map(message -> new Message(message.getMessage(), message.getMessageSent())).collect(Collectors.toList()));
        return messageRepository.findAll().stream().map(message -> new Message(message.getMessage(), message.getMessageSent())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Message save(SentDTO sentDTO) {
        log.info("Saving message = {}", sentDTO.getMessage());
        return messageRepository.save(new Message(sentDTO.getMessage()));
    }
}
