package com.amigoscode._3_oop._5_dependencyinjection.notification;

// TODO: 2 - Create an EmailSender class that implements MessageSender.
//   Implement send() to print:
//   "[Email] Sending to <to>: <message>"
public class EmailSender implements MessageSender{

    @Override
    public void send(String to, String message) {
        System.out.println("[EMAIL] Sending to " + to + ": " + message);
    }
}
