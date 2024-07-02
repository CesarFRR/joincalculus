package com.unal.tests;

public class ConsoleWriter {
    private final Object lock = new Object();

    public void writeMessage(String message) {
        synchronized (lock) {
            System.out.println(message);
        }
    }
}