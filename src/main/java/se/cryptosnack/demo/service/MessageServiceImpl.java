package se.cryptosnack.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.dto.SentDTO;
import se.cryptosnack.demo.service.repositories.MessageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements EntityService<Message, SentDTO> {

    private static final Logger log = LoggerFactory.getLogger(EntityService.class);

    private final MessageRepository messageRepository;
    private final MessageOwnerService messageOwnerService;
    public MessageServiceImpl(MessageRepository messageRepository, MessageOwnerService messageOwnerService) {
        this.messageRepository = messageRepository;
        this.messageOwnerService = messageOwnerService;
    }

    @Override
    public List<Message> loadAll() {
//        messageRepository.findAll().stream().map(message -> log.info("Loading message = {}", new Message(message.getMessage(), message.getMessageSent()));
        log.info("loading Message = {}", messageRepository.findAll().stream().map(message -> new Message(message.getMessage(), message.getMessageSent())).collect(Collectors.toList()));
        return messageRepository.findAll().stream().map(message -> new Message(message.getMessage(), message.getMessageSent())).collect(Collectors.toList());
    }

    @Override
    public Message save(SentDTO sentDTO) {
        log.info("Saving message = {}", sentDTO.toString());
//        User user = (User) customUserDetailsService.getUser();
//        log.info("SentDTO = {}", sentDTO.getSentFrom());
//        log.info("Sent by user = {}", user.getUsername());
//        user = customUserDetailsService.getUser();
//        Message message = new Message(sentDTO.getMessage());
//        message.setUser(user);


        return messageRepository.save(new Message(sentDTO.getMessage(), messageOwnerService.getSentFromUser(sentDTO.getSentFrom())));
    }
}
