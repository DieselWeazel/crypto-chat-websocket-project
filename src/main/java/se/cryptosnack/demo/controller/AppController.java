package se.cryptosnack.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import se.cryptosnack.demo.config.PageViews;

@RequestMapping(PageViews.INDEX)
@Controller
public class AppController {


    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model) {
        return PageViews.CHAT;
    }


}
