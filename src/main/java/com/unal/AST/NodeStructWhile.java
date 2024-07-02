package com.unal.AST;


import java.util.List;

public class NodeStructWhile extends Node2 implements InterfaceStruct, InterfaceExpr{


    private static TableAST table;
    static {
        table = new TableAST();
    }
    /**
     * Constructor de la clase.
     *
     * @param exprBoolean Debe ser de tipo NodeExprBoolean
     * @param sentList Debe ser de tipo Node o NodeTree, de preferencia NodeTree
     **/
    public NodeStructWhile(Node exprBoolean, Node sentList) {
        super(exprBoolean, sentList);
        if (!(exprBoolean instanceof NodeExprBoolean)) throw new IllegalStateException("La expresión booleana no es válida.");
    }

    /**
     * Ejecuta la acción de este nodo.
     *
     * @return
     **/
    @Override
    public Object execute() {
        if (child1 == null || child2 == null) {
            throw new IllegalStateException("No se pudo ejecutar el ciclo while, falta algún operando u operando.");
        }
        //table.pushIdMap();
        int statePosition = this.createState("while", null, null);
        List<Node> instructionNodes = (child2 instanceof NodeTree nt) ? this.getInstructionNodes(nt) : List.of(child2);
        String threadName = Thread.currentThread().getName();
        Object exprBoolean = getRealValue(child1);
        String status;
        WHILE:
        while ((boolean) exprBoolean) {
            SENTENCIAS:
            for (Node node : instructionNodes) {
                Object sentencia = node.execute();

                if(getStackSize() < statePosition) {
                    /**NOTA: Lo que aqui sucede es que en algun lugar se ejecutó un return y se eliminarion n estados hasta que la pila encontró un estado de tipo "fn" funcion
                     *  de tal manera que se van a detener cualquier ciclo que se esté ejecutando hasta que se encuentre un estado de tipo "fn" funcion y esta maneje el return
                     *  Esto es una simulacion de como se manejan las funciones en la pila de estados
                     */
                    break WHILE;
                }
                Object[] state = getState();
                if(state[1]==null) continue;

                if(state[1].equals("break") && ((String)state[2]).equals(threadName)) {
                    state[1] = null;
                    state[2] = null;
                    break WHILE;
                }
                if(state[1].equals("continue") && ((String)state[2]).equals(threadName)) {
                    state[1] = null;
                    state[2] = null;
                    //System.out.println("Se encontró un continue en el ciclo for. Se saltará a la siguiente iteración.");
                    break SENTENCIAS;
                }
            }

            exprBoolean = getRealValue(child1);
        }

        this.removeState(threadName);

        return null;
    }
}
