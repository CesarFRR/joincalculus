package com.unal.AST;

public class NodeSend extends Node2 implements InterfaceExpr{
    private static TableAST table;

    static {
        table = new TableAST();
    }

    public NodeSend(Node channelName, Node value) {
        super(channelName, value);
    }

    @Override
    public String toString() {
        return "send " + child1 + "(" + child2 + ")";
    }

    @Override
    public Object execute() {
        String channelName = (String) child1.execute();
        NodeChannel channel = table.getChannel(channelName);
        if (channel == null) {
            System.out.println("Channel " + channelName + " not defined");
            return null;
        }

        Object value = getRealValue(child2);

        try {
            channel.send(value);
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

    @Override
    public void clean() {
        super.clean();
    }
}
