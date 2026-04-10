package org.example;

public class MessageUtil {
  private String message;

  public MessageUtil(String message) {
    if (message == null) throw new IllegalArgumentException("Message cannot be null");
    this.message = message;
  }

  public String printMessage() {
    System.out.println(message);
    return message;
  }

  public String salutationMessage() {
    String salutation = "Hi!" + message;
    System.out.println(salutation);
    return salutation;
  }
}
