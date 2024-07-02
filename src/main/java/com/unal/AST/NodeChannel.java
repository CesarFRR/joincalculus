package com.unal.AST;
import com.unal.model.ConsoleWriter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class NodeChannel extends Node2{
    private ConcurrentLinkedDeque<Object> deque;

    public NodeChannel(Node name, Node value) {
        super(name, value);
        deque = new ConcurrentLinkedDeque<>();
    }

    @Override
    public String toString() {
        return "channel( " + child1 + " )";
    }

    @Override
    public Object execute() {
        //TODO: implementar la ejecucion de un canal
        return null;
    }

    public void send(Object message) {
        deque.addLast(message);
    }

    public Object receive()  {
        Object i = deque.peekLast();
        if (i == null) {
            return null;
        }
        return i;
    }

    @Override
    public Object clone() {
        Node2 ch1 = (Node2) super.clone();
        return new NodeChannel(ch1.child1, ch1.child2);
    }

    @Override
    public void clean() {
        super.clean();
    }

}
