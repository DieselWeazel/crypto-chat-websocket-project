package se.cryptosnack.demo.controller;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.SentDTO;
import se.cryptosnack.demo.service.MessageService;

@Controller
public class MessageWebsocketController {

  private static final Logger log = LoggerFactory.getLogger(MessageWebsocketController.class);

  private final MessageService<Message, SentDTO> messageService;

  public MessageWebsocketController(MessageService<Message, SentDTO> messageService) {
    this.messageService = messageService;
  }

  @MessageMapping("/chat")
  @SendTo("/topic/messages")
  public List<Message> sendMessage(Message messageText) {

    System.out.println();
    System.out.println();
    System.out.println("IIIIIIIIIIIIIIIIIIIIIII " + messageText);
    System.out.println();
    System.out.println();

    SentDTO dto = new SentDTO(messageText.getMessage(), null);

    log.info("recieved: {}", messageText);
    // return new Message("Hello " + HtmlUtils.htmlEscape(sentMessage.getMessageText()) + ".");

    List<Message> messages = new ArrayList<Message>();

    // messages.add(messageService.save(messageText));
    messageService.save(dto);

    return messages;
  }

  @SendTo("/topic/messages")
  @MessageMapping("/getAll")
  public List<Message> loadAllMessages() {
    log.info("loadAllMessages() has been called");
    return messageService.loadHistory();
  }

}
