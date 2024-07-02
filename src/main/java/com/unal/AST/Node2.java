package com.unal.AST;

public class Node2 extends Node{
    public Node child1;
    public Node child2;

    public Node2(Node child1, Node child2) {
        this.child1 = child1;
        this.child2 = child2;
    }

    @Override
    public String toString() {
        return " " + child1.toString() +
                  " " + child2.toString();
    }

    @Override
    public Object execute() {
        if (child1 != null  && child2 != null) {
            Object result1 = child1.execute();
            Object result2 = child2.execute();
            System.out.println("-> " + result1 + " " + result2);
        }
        return null;
    }

    @Override
    public Object clone() {
        Node ch1 = (Node) child1.clone();
        Node ch2 = (Node) child2.clone();
        return new Node2(ch1, ch2);
    }

    @Override
    public void clean() {
        child1.clean();
        child2.clean();
    }
}
