package se.cryptosnack.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import se.cryptosnack.demo.config.util.AppReferences;
import se.cryptosnack.demo.config.util.PageViews;
import se.cryptosnack.demo.model.Message;
import se.cryptosnack.demo.model.dto.SentDTO;
import se.cryptosnack.demo.service.CustomUserDetailsService;
import se.cryptosnack.demo.service.EntityService;

@Controller
public class AppController {

    private static final Logger log = LoggerFactory.getLogger(AppController.class);

    private final EntityService<SentDTO> entityService;
    private final CustomUserDetailsService customUserDetailsService;

    @Autowired
    public AppController(EntityService<SentDTO> entityService, CustomUserDetailsService customUserDetailsService) {
        this.entityService = entityService;
        this.customUserDetailsService = customUserDetailsService;
    }

    @GetMapping(PageViews.INDEX)
    public String start() {
        return PageViews.HOME;
    }

    @GetMapping("/" + PageViews.CHAT)
    public String chat(Model model) {
        // August, här är ett exempel på hur du kan ladda in genom Thymeleaf
        model.addAttribute(AppReferences.CHAT_HISTORY, entityService.loadAll());

        model.addAttribute(AppReferences.CURRENT_USER, customUserDetailsService.getUser().getUsername());
        log.info("Current Username String = {}", customUserDetailsService.getUser().getUsername());
        log.info("Chat.html, model = {}", model);
        return PageViews.CHAT;
    }

    @GetMapping("/" + PageViews.LOGIN)
    public String login() {
        return PageViews.LOGIN;
    }


}
