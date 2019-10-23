package se.cryptosnack.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import se.cryptosnack.demo.config.util.PageViews;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.SentDTO;
import se.cryptosnack.demo.service.MessageService;

@Controller
public class AppController {


  private MessageService<Message, SentDTO> messageService;

  @Autowired
  public AppController(MessageService<Message, SentDTO> messageService) {
    this.messageService = messageService;
  }

  @GetMapping(PageViews.INDEX)
  public String start() {
    return PageViews.HOME;
  }

  @GetMapping("/" + PageViews.CHAT)
  public String chat(Model model) {
    // August, här är ett exempel på hur du kan ladda in genom Thymeleaf
    // model.addAttribute(AppReferences.CHAT_HISTORY, messageService.loadHistory());
    return PageViews.CHAT;
  }

  @GetMapping("/" + PageViews.LOGIN)
  public String login() {
    return PageViews.LOGIN;
  }


}
