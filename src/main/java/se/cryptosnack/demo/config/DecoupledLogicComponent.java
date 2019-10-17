package se.cryptosnack.demo.config;

import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

/**
 * Decouples Logic, I've added this as a small bonus after the Discord talk we had 17/10
 * This demonstrates something that's pretty much done the same way each time, unless
 * you want additional fixes. Basically what this does it enables us to implement
 * ThymeLeafs logic, outside of the html files that Thymeleaf renders.
 *
 * So index.html + index.th.xml are both read simultaneously. Pretty straight forward right?
 *
 * Else, you wouild have to add all the TH:replace/th:object etc etc etc
 * directly into the file you want it in, now the HTML file works WITHOUT thymeleaf
 * so we can preview it accordingly, and our code looks way smexier. (Y)
 */
@Component
public class DecoupledLogicComponent {

    private final SpringResourceTemplateResolver template;

    public DecoupledLogicComponent(SpringResourceTemplateResolver template) {
        this.template = template;
    }

    @PostConstruct
    public void init() {
        template.setUseDecoupledLogic(true);
    }

}
