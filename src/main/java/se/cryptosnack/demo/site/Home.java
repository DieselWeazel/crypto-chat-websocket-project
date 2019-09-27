package se.cryptosnack.demo.site;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import se.cryptosnack.demo.model.User;

@Route(value = "")
public class Home extends VerticalLayout {

  User user;

  // history
  TextArea chatField = new TextArea();

  // message input field
  TextField messageInput = new TextField();

  Button sendMessage = new Button("send");

  public Home() {
    initGUI();
  }

  public void initGUI() {
    chatField.setWidth("500px");
    chatField.setHeight("300px");
    chatField.setEnabled(false);

    messageInput.setPlaceholder("Input message");

    add(new H1("Logged in as: " + "username"));
    add(chatField);
    HorizontalLayout horizontalLayout = new HorizontalLayout();
    horizontalLayout.add(messageInput, sendMessage);
    add(horizontalLayout);
  }


}
