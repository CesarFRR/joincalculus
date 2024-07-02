package com.unal.AST;

public class Node4  extends Node{
    public Node child1;
    public Node child2;
    public Node child3;
    public Node child4;

    public Node4(Node child1, Node child2, Node child3, Node child4) {
        this.child1 = child1;
        this.child2 = child2;
        this.child3 = child3;
        this.child4 = child4;
    }

    @Override
    public String toString() {
        return "Node4: " + child1 + " " + child2 + " " + child3 + " " + child4 ;
    }

    /**
     * Ejecuta la acción de este nodo.
     *
     * @return
     **/
    @Override
    public Object execute() {
        if (child1 != null  && child2 != null && child3 != null && child4 != null) {
            Object result1 = child1.execute();
            Object result2 = child2.execute();
            Object result3 = child3.execute();
            Object result4 = child4.execute();
            System.out.println("-> " + result1 + " " + result2 + " " + result3 + " " + result4);
        }
        return null;
    }

    @Override
    public Object clone() {
        Node child1 = this.child1 != null ? (Node) this.child1.clone() : null;
        Node child2 = this.child2 != null ? (Node) this.child2.clone() : null;
        Node child3 = this.child3 != null ? (Node) this.child3.clone() : null;
        Node child4 = this.child4 != null ? (Node) this.child4.clone() : null;
        return new Node4(child1, child2, child3, child4);
    }

    @Override
    public void clean() {
        if (child1 != null) {
            child1.clean();
        }
        if (child2 != null) {
            child2.clean();
        }
        if (child3 != null) {
            child3.clean();
        }
        if (child4 != null) {
            child4.clean();
        }
    }
}