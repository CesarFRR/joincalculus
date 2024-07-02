package com.unal.AST;


public class NodeStructContinue extends NodeLeaf implements InterfaceStruct, InterfaceExpr{
    public NodeStructContinue() {
        super(null);
    }


    @Override
    public String toString() {
        return "continue";
    }

    @Override
    public Object execute() {
        this.updateState("continue", Thread.currentThread().getName());
        return null;
    }
}
