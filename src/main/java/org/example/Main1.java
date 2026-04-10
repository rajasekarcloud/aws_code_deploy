# This is another program that run on port 80
  package org.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {

  public static void main(String[] args) throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);

    server.createContext("/", new HttpHandler() {
      @Override
      public void handle(HttpExchange exchange) throws IOException {
        MessageUtil util = new MessageUtil("World!");

        String printResponse    = util.printMessage();
        String salutationResponse = util.salutationMessage();

        String response = "Message: "      + printResponse + "\n"
                        + "Salutation: "   + salutationResponse + "\n";

        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
      }
    });

    server.setExecutor(null);
    server.start();
    System.out.println("Server started on port 80");
  }
}
