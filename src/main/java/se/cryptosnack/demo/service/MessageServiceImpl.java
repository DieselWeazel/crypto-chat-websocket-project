package se.cryptosnack.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.SentDTO;
import se.cryptosnack.demo.service.repositories.MessageRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService<Message, SentDTO> {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> loadHistory() {
        return messageRepository.findAll().stream().map(message -> new Message(message.getMessage(), message.getMessageSent())).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Message save(SentDTO sentDTO) {
        return new Message(sentDTO.getMessage());
    }
}
