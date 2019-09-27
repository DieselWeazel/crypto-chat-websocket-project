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
  TextField userName = new TextField();

  Button sendMessage = new Button("send");
  Button login = new Button("Log in");

  public Home() {
    initGUI();
  }

  public void initGUI() {
    chatField.setWidth("500px");
    chatField.setHeight("300px");
    chatField.setEnabled(false);

    messageInput.setPlaceholder("Input message");

    HorizontalLayout loginLayout = new HorizontalLayout();
    loginLayout.add(userName, login);

    add(loginLayout);
    add(new H1("Logged in as: " + "username"));
    add(chatField);
    HorizontalLayout messageLayout = new HorizontalLayout();
    messageLayout.add(messageInput, sendMessage);
    add(messageLayout);
  }


}
