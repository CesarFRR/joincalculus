package com.unal.AST;


public class NodeStructBreak extends NodeLeaf implements InterfaceStruct, InterfaceExpr{

    public NodeStructBreak() {
        super(null);
    }

    @Override
    public String toString() {
        return "break";
    }

    @Override
    public Object execute() {
        this.updateState("break", Thread.currentThread().getName());
        return null;
    }
}
