package com.unal.model;

public class ConsoleWriter {

    public synchronized void writeMessage(String message) {
        System.out.print(message);
    }

}