package com.unal.model;

import com.unal.AST.Node;

import java.util.List;

public class Process extends Thread {

    private List<Node> sentlist;

    public Process(String name, List<Node> sentlist) {
        super(name);
        this.sentlist = sentlist;
    }

    public Process(String name) {
        super(name);
        this.sentlist = null;
    }

    public void setSentlist(List<Node> sentlist) {
        this.sentlist = sentlist;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
//        System.out.println("Running in thread: " + threadName);
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Process code
                for (Node node : sentlist) {
                    Object result = node.execute();
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR CON EL HILO " + threadName + " interrupted: " + e);
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
    public void stopProcess() {
        this.interrupt();
    }
}