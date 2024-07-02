package com.unal.AST;

public class NodeSleep extends NodeLeaf implements InterfaceExpr{
    public NodeSleep(Object value) {
        super(value);
    }

    @Override
    public String toString() {
        return "sleep(" + value +");";
    }

    @Override
    public Object execute() {
        Object v = value instanceof Node n?getRealValue(value) : value;
        if (v instanceof  NodeVar nv){
            v = nv.getValue();
        }
        if (v instanceof  Double d){
            v = d.intValue();
        }
        if (v instanceof Float f){
            v = f.intValue();
        }
        if (!(v instanceof Integer)){
            throw new IllegalStateException("El valor de sleep debe ser un entero");
        }
        try {
//            System.out.println("Waiting for " + v + " milliseconds");
            // si no estamos en un hilo, tratar de dormir el hilo principal

            Thread.sleep(Integer.toUnsignedLong( (Integer) v));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object clone() {
        return value instanceof Node n? new NodeSleep(n.clone()) : new NodeSleep(value);
    }

    @Override
    public void clean() {
        if(value instanceof Node n){
            n.clean();
        }
    }
}
