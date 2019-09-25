package se.cryptosnack.demo.site;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "")
public class Home extends VerticalLayout {

  public Home() {
    // WAT
    add(new H1("Hem"));
  }
}
