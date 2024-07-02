package com.unal.AST;

import java.util.List;

public class NodeStructIfElse extends Node3 implements InterfaceStruct{
    /**
     * Constructor de la clase.
     *
     * @param exprBool  Expresión booleana
     * @param sentList1 Lista de sentencias 1 si la expresión es verdadera
     * @param sentList2 Lista de sentencias 2 si la expresión es falsa (else)
     **/
    public NodeStructIfElse(Node exprBool, Node sentList1, Node sentList2) {
        super(exprBool, sentList1, sentList2);
    }


    /**
     * Ejecuta la acción de este nodo.
     *
     * @return
     **/
    @Override
    public Object execute() {
//        System.out.println("NodeStructIfElse " + child1 + child2 + child3);
        if (child1 == null) throw new IllegalStateException("La expresión booleana es null o vacía.");
        if (child2 == null) {
            child2 = new NodeTree(null, null);
        }
        Object exprBool = child1.execute();
        if (!(exprBool instanceof Boolean)) throw new IllegalStateException("La expresión booleana no es booleana.");
        Object sent;
        String status;
        List<Node> instructionNodes;
//        System.out.println("NodeStructIfElse " + exprBool + " " + child2 + " " + child3 + "");
        if ((boolean) exprBool) {
            instructionNodes = (child2 instanceof NodeTree nt) ? this.getInstructionNodes(nt) : List.of(child2);
            for (Node node : instructionNodes) {
                sent = node.execute();
                status = getStatus();
                if (status==null) continue;
                if (status.equals("break") || status.equals("continue") || status.equals("return")) return null;
            }
        } else {
            if (child3 != null) {
                instructionNodes = (child3 instanceof NodeTree nt) ? this.getInstructionNodes(nt) : List.of(child3);
                for (Node node : instructionNodes) {
                    sent = node.execute();
                    status = getStatus();
                    if (status==null) continue;
                    if (status.equals("break") || status.equals("continue") || status.equals("return")) return null;
                }

            }
        }
        return null;
    }

}

