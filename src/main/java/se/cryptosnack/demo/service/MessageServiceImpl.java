package se.cryptosnack.demo.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import se.cryptosnack.demo.controller.MessageWebsocketController;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.SentDTO;
import se.cryptosnack.demo.service.repositories.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService<Message, SentDTO> {

  private static final Logger log = LoggerFactory.getLogger(MessageWebsocketController.class);

  private final MessageRepository messageRepository;

  public MessageServiceImpl(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @Override
  public List<Message> loadHistory() {
    // messageRepository.findAll().stream().map(message -> log.info("Loading message = {}", new
    // Message(message.getMessage(), message.getMessageSent()));
    log.info("loading Message = {}",
        messageRepository.findAll().stream()
            .map(message -> new Message(message.getMessage(), message.getTimeSent()))
            .collect(Collectors.toList()));
    return messageRepository.findAll().stream()
        .map(message -> new Message(message.getMessage(), message.getTimeSent()))
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public Message save(SentDTO sentDTO) {
    log.info("Saving message = {}", sentDTO.getMessageText());
    return messageRepository
        .save(new Message(sentDTO.getMessageText(), sentDTO.getUser(), sentDTO.getTimeSent()));
  }
}
