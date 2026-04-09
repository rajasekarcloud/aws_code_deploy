package org.example;

public class Main {
  public static void main(String[] args) {
    MessageUtil util = new MessageUtil("World!");

    util.printMessage();       // prints: World!
    util.salutationMessage();  // prints: Hi!World!
  }
}
