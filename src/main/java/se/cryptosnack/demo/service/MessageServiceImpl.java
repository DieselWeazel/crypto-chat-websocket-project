package se.cryptosnack.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.dto.SentDTO;
import se.cryptosnack.demo.service.repositories.MessageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements EntityService<SentDTO> {

    private static final Logger log = LoggerFactory.getLogger(EntityService.class);

    private final MessageRepository messageRepository;
    private final MessageOwnerService messageOwnerService;
    private final DateFormatService dateFormatService;
    private final PasswordEncoder passWordEncoder;

    public MessageServiceImpl(MessageRepository messageRepository, MessageOwnerService messageOwnerService, DateFormatService dateFormatService, PasswordEncoder passWordEncoder) {
        this.messageRepository = messageRepository;
        this.messageOwnerService = messageOwnerService;
        this.dateFormatService = dateFormatService;
        this.passWordEncoder = passWordEncoder;
    }

    @Override
    public List<SentDTO> loadAll() {
//        messageRepository.findAll().stream().map(message -> log.info("Loading message = {}", new Message(message.getMessage(), message.getMessageSent()));
//        log.info("loading Message = {}", messageRepository.findAll().stream().map(message -> new Message(message.getMessage(), message.getMessageSent())).collect(Collectors.toList()));
        return messageRepository.findAll().stream().map(message -> new SentDTO(passWordEncoder.encode(message.getMessage()), message.getUser().getUsername(), dateFormatService.getDateTimeSent(message.getMessageSent()))).collect(Collectors.toList());
    }

    @Override
    public SentDTO save(SentDTO sentDTO) {
        log.info("Saving message = {}", sentDTO.toString());
        Message incomingMessage = new Message(sentDTO.getMessage(), messageOwnerService.getSentFromUser(sentDTO.getSentFrom()));
        sentDTO.setTimeSent(dateFormatService.getDateTimeSent(incomingMessage.getMessageSent()));
        messageRepository.save(incomingMessage);
        return sentDTO;
    }
}
