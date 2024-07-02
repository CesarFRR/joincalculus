package com.unal.AST;

public class Node3 extends Node{
    public Node child1;
    public Node child2;
    public Node child3;

    public Node3(Node child1, Node child2, Node child3) {
        this.child1 = child1;
        this.child2 = child2;
        this.child3 = child3;
    }

    @Override
    public String toString() {
        return " " + child1 +
                " " + child2 +
                " " + child3;
    }

    @Override
    public Object execute() {
        if (child1 != null  && child2 != null) {
            Object result1 = child1.execute();
            Object result2 = child2.execute();
            Object result3 = child3.execute();
            System.out.println("-> " + result1 + " " + result2 + " " + result3);
        }
        return null;
    }

    @Override
    public Object clone() {
        Node ch1 = (Node) child1.clone();
        Node ch2 = (Node) child2.clone();
        Node ch3 = (Node) child3.clone();
        return new Node3(ch1, ch2, ch3);
    }

    @Override
    public void clean() {
        child1.clean();
        child2.clean();
        child3.clean();
    }
}