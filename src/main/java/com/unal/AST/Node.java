package com.unal.AST;

public abstract class Node implements Cloneable {
    public Node() {}
    public abstract String toString();
    public abstract Object execute();
    public abstract Object clone();
    public abstract void clean();
}

