package com.unal.tests;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Channel {
    private BlockingQueue<Object> queue = new LinkedBlockingQueue<>();

    public void send(Object message) throws InterruptedException {
        queue.clear();
        queue.put(message);
    }

    public Object receive()  {
        return queue.peek();
    }
}