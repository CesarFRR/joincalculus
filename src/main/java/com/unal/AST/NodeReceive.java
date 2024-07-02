package com.unal.AST;

import com.unal.model.ConsoleWriter;

public class NodeReceive extends NodeLeaf{
    static TableAST table;

    static {
        table = new TableAST();
    }

    public NodeReceive(Object channelName) {
        super(channelName);
    }

    @Override
    public String toString() {
        return "receive " + value + "()";
    }

    @Override
    public Object execute() {
        Object name = value;
        Object result = null;
        name = name instanceof Node ? ((Node) name).execute() : name;
        String channelName = (String) name;
        NodeChannel channel = (NodeChannel) table.getChannel(channelName);
        result = channel.receive();
        return result;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public void clean() {

    }
}
