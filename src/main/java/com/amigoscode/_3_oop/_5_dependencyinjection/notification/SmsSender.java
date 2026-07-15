package com.amigoscode._3_oop._5_dependencyinjection.notification;

// TODO: 3 - Create an SmsSender class that implements MessageSender.
//   Implement send() to print:
//   "[SMS] Sending to <to>: <message>"
public class SmsSender implements MessageSender{
    @Override
    public void send(String to, String message) {
        System.out.println("[SMS] Sending to " + to + ": " + message);
    }
}
