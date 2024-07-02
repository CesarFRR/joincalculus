package com.unal.AST;


import com.unal.model.ConsoleWriter;

public class NodeFnPrint extends NodeLeaf implements InterfaceExpr{
    private static ConsoleWriter consoleWriter = new ConsoleWriter();

    public NodeFnPrint(Object value) {
        super( value);
    }


    public String toString() {
        return "PRINT: " + this.value;
    }

    @Override
    public Object execute() {
        Object result=null;
        if (this.value == null) {
            throw new IllegalStateException("No se puede imprimir un valor nulo");
        }

        if(this.value instanceof Node nd) {
//            System.out.println("SE IMPRIME UN NODE:--> "  + result);
//            System.out.println("ANTES DE IMPRIMIR REAL VALUE: ----_>_->_>_>_****: " + nd + nd.getClass());
            result = getRealValue(nd);
            result = result == null ? "null" : result;
        } else {
//            System.out.println("SE IMPRIME UN object:--> "  + this.value.getClass().getSimpleName());
            result = this.value;
        }
        //System.out.println("el hilo actual es: " + Thread.currentThread().getName());
        consoleWriter.writeMessage(cleanString(result.toString()));  // "Hello, world!"
        return null;
    }

}