package se.cryptosnack.demo.site;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import se.cryptosnack.demo.model.User;

@Route(value = "")
public class Home extends VerticalLayout {

  User user;

  // chatfield containing history of messages
  TextArea chatField;

  // message input field
  TextField messageInput;
  TextField userName;

  Button sendMessage;
  Button login;


  public Home() {
    initGUI();
  }

  public void initGUI() {
    login = new Button("Connect", event -> connectClick());

    chatField = new TextArea();
    chatField.setWidth("500px");
    chatField.setHeight("300px");
    chatField.setEnabled(false);

    messageInput = new TextField();
    messageInput.setPlaceholder("Input message");

    userName = new TextField();

    sendMessage = new Button("send", event -> sendMessage(messageInput.getValue()));
    sendMessage.setEnabled(false);


    HorizontalLayout loginLayout = new HorizontalLayout();
    loginLayout.add(userName, login);

    add(loginLayout);
    add(new H1("Connected as: " + "username"));
    add(chatField);
    HorizontalLayout messageLayout = new HorizontalLayout();
    messageLayout.add(messageInput, sendMessage);
    add(messageLayout);
  }

  public void connectClick() {
    if (!userName.isEmpty()) {
      // connect with the username userName.getValue()
      // if connection is made, enable messageInput
    } else {
      Notification.show("You must enter a username to connect");
    }
  }

  public void sendMessage(String message) {
    if (!message.isEmpty()) {
      // send message
    } else {
      Notification.show("You must enter a message to send");
    }
  }
}
