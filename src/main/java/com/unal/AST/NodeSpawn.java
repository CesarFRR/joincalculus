package com.unal.AST;

import java.util.ArrayList;
import java.util.List;

public class NodeSpawn extends Node2{
    private static TableAST table;
    private List<Node> processList;
    static {
        table = new TableAST();
    }

    public NodeSpawn(Node processName, Node quantity) {
        super(processName, quantity);
        processList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "spawn(" + child1 + ", " + child2 + ")";
    }

    @Override
    public Object execute() {
        String name = (String) child1.execute();
        int quantity = (int) child2.execute();
        NodeProcess p = table.getProcess(name);
        if (p == null) {
            throw new IllegalStateException("El proceso " + name + " no ha sido definido");
        }

        for (int i = 0; i < quantity; i++) {
            NodeProcess p1 = (NodeProcess) p.clone();
            p1.setName(name +"_"+ i);
            processList.add(p1);
            table.setProcess(p1.getName(), p1);
        }
        System.out.println("Executing spawn: " + name + " with " + quantity + " processes: " + processList);
        for (Node n : processList) {
            n.execute();
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
