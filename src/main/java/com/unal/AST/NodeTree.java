package com.unal.AST;


import java.util.ArrayList;
import java.util.List;

public class NodeTree extends Node implements InterfaceStruct, InterfaceExpr{
    public Node n;
    public NodeTree child;
    private static  boolean isRoot = true;


    public NodeTree(Node n, NodeTree child) {
        this.n = n;
        this.child = child;
    }

    public String toString(){
        return n + " " + child;
    }

    /** Ejecuta la acción de este nodo.
     * @return
     **/
    @Override
    public Object execute() {
        if(isRoot){
            System.out.println("es root " );
            isRoot = false;
            NodeTree nt = this;
            List<Node> sents = this.getInstructionNodes(nt);
            System.out.println("sents: " + sents + " " + sents.getClass().getSimpleName());
//            for (Node n : sents) {
//                System.out.println("n-> " + n + " " + n.getClass().getSimpleName());
//            }
        }


        List<Object> results = new ArrayList<>();

        if (n != null) {
            Object result = n.execute();
            result = result == null ? "null" : result;
//            System.out.println("n-> " + result + " " + result.getClass().getSimpleName());
            results.add(result);
        }

        if (child != null) {
            Object childResult = child.execute();
            if (childResult != null) {
                results.add(childResult);
            }
        }

        Object finalResult = results.isEmpty() ? null : results.getLast();
        //System.out.println("Count: " + count + " result-> " + finalResult);
        return finalResult;
    }

    @Override
    public Object clone() {
        Node n = (Node) this.n.clone();
        NodeTree ch ;
        if (this.child == null) {
            ch = null;
        } else {
            ch = (NodeTree) this.child.clone();
        }
        return new NodeTree(n, ch);
    }

    @Override
    public void clean() {
        n.clean();
        child.clean();
    }

}
