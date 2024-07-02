package com.unal.AST;

public class NodeRandom extends Node2{

    public NodeRandom(Node min, Node max) {
        super(min, max);
    }

    @Override
    public String toString() {
        return "random(" + child1 + ", " + child2 + ")";
    }

    @Override
    public Object execute() {
        Object min = child1.execute();
        Object max = child2.execute();
        if (min instanceof Integer int1 && max instanceof Integer int2){
            return new NodeLeaf((int) (Math.random() * (int2 - int1 + 1)) + int1);
        }

        return null;
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public void clean() {

    }
}
