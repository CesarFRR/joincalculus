package com.unal.AST;

public class NodeLeaf  extends Node{
    Object value;

    public NodeLeaf(Object value){
        this.value = value;
    }


    @Override
    public String toString() {
        String s = value == null ? "*null*" : value.toString();
        return s;
    }

    @Override
    public Object execute() {
        Object result = value;
        if (result instanceof Node n) {
            return n.execute();
        }
        return result;
    }

    @Override
    public Object clone() {
        Object v = value instanceof Node n ? n.clone() : value;
        return new NodeLeaf(v);
    }

    @Override
    public void clean() {
        value = null;
    }
}
