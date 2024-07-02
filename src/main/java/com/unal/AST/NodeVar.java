package com.unal.AST;

import com.unal.model.ConsoleWriter;

public class NodeVar extends Node3{

    private static TableAST table;

    static {
        table = new TableAST();
    }
    public NodeVar(Node type, Node name, Node value) {
        super(type, name, value);
    }

    public String toString() {
        return child1 + " " + child2 + " = " + child3;
    }



    @Override
    public Object execute() {

        String nameid = (String) this.child2.execute();
        String thread = Thread.currentThread().getName();
        Node ch1 = this.child1;
        Node ch2 =  this.child2;
        Node ch3 =  this.child3;

        Object c3 = ch3 instanceof NodeReceive nr? nr.execute() : ch3;

        if (c3 instanceof NodeVar nv){
            ch3 = new NodeLeaf(nv.getValue());
        }

//        System.out.println(" NodeVar.execute() -> "+ ch1 + " " + ch2 + " " + ch3);


        if (ch1 == null && ch3 == null) {
//            System.out.println("NodeVar.execute() -> ch1 == null && ch3 == null");
            Object var = table.getId(thread, nameid);
            if (var == null) {
                var = table.getId("main", nameid);
            }
            return var;
        }

        String type;
        Object value;
        NodeVar result;

        if (ch1 == null && ch3 != null) { // asignacion
//            System.out.println("NodeVar.execute() -> ch1 == null && ch3 != null");
            NodeVar var = (NodeVar) table.getId(thread, nameid);
            if (var == null) {
//                System.out.println("averiguar donde está var " + nameid + " hilo actual: " + thread);
//                table.printAllMaps();
//                System.out.println("var " + nameid + " no está en: " + thread + " buscando en main");
                var = (NodeVar) table.getId("main", nameid);

            }
            //if (nameid.equals("fibo"))  System.out.println("variable: " + var + " disponible en: " + thread);
            type = var.getType();


            value = this.getRealValue(ch3);
            Object n = value !=null ?this.isNumeric(value.toString()):null;

            if (n instanceof Integer || n instanceof Float){
                value = n;
            }
            if (this.getTypeFromValue(value).equals("int") && type.equals("float")) {
                value = ((Integer)value).floatValue();
            }

            if (!this.getTypeFromValue(value).equals(type)) {
                    if (getTypeFromValue(value).equals("int") && type.equals("string")){
                        assert value != null;
                        value = value.toString();
                        var.setValue(value);
                        return null;
                    }
                    throw new IllegalStateException("Type mismatch: " + type + " expected, but " + this.getTypeFromValue(value) + ": "+value+" found.");

            } else {
                var.setValue(value);
                return null;
            }
        }


        if (ch1 != null && ch3 == null) { // declaracion con valor por defecto
//            System.out.println("NodeVar.execute() -> ch1 != null && ch3 == null");
            type = (String)ch1.execute();
            value = this.getDefaultValue(type);
            result = new NodeVar(new NodeLeaf(type), new NodeLeaf(nameid), new NodeLeaf(value));
            if (table.existsId(null, nameid) && thread.equals("main")){
                throw new IllegalStateException("Variable " + nameid + " already exists.");
            }
            table.setId(null, nameid, result);
            return null;
        }

        if (ch1 != null && ch3 != null) { // declaracion con valor
//            new ConsoleWriter().writeMessage(" declaracion con valor NodeVar.execute() -> ch1 != null && ch3 != null0 | " + ch1 + " " + ch2 + " " + ch3 + " " + ch3.execute() + " " + ch3.getClass());
//            table.printAllMaps();
            type = (String)ch1.execute();


            value = this.getRealValue(ch3);

//            if (value ==null){
//                System.out.println("caso ES VALOR NULL:  VAR: " + this + "  " + ch3 + " " + ch3.getClass() + " " + ch3.execute());
//                if (ch3 instanceof NodeID ni){
//                    System.out.println("es nodeID con valor null: " + ni.value + " "+ ni.value.getClass());
//                }
//            }

            if (this.getTypeFromValue(value).equals("int") && type.equals("float")) {
                value = ((Integer)value).floatValue();
            }

            if (!this.getTypeFromValue(value).equals(type)) {
//                System.out.println("NodeVar.execute() -> Type mismatch  error");

                throw new IllegalStateException("Type mismatch: " + type + " expected, but " + this.getTypeFromValue(value) + " :  "+value+ "  " + value.getClass()+"  found.");
            } else {
                if (table.existsId(thread, nameid) && thread.equals("main")){
//                    System.out.println("NodeVar.execute() -> variable exists error");
                    throw new IllegalStateException("Variable " + nameid + " already exists.");
                }
                result = new NodeVar( new NodeLeaf(type), new NodeLeaf(nameid), new NodeLeaf(value));
//                System.out.println("\n\nNodeVar.execute()  -> nv:" + result);
                table.setId(null, nameid, result);
                return null;
            }
        }

        return null;

    }
    public String getType() {
        return (String) child1.execute();
    }
    public void setType(Object type) {
        child1 = (type instanceof Node)? (Node) type : new NodeLeaf(type);
    }

    public String getName() {
        return (String) child2.execute();
    }
    public void setName(Object name) {
        child2 = (name instanceof Node)? (Node) name : new NodeLeaf(name);
    }



    public void setValue(Object value) {
        child3 = (value instanceof Node)? (Node) value : new NodeLeaf(value);
        // Node forma2 = value;
    }

    public Object getValue() {
        return child3.execute();
    }

    private Object getDefaultValue(String type) {
        return switch (type) {
            case "int" -> 0;
            case "float" -> 0.0;
            case "string" -> "";
            case "boolean" -> false;
            case "char" -> '\u0000';
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    private String getTypeFromValue(Object value) {
        if (value instanceof Node) value = getRealValue(value);
        //    System.out.println("VALOR DE VALUE - getTypeFromValue: " + value + " " + value.getClass().getSimpleName() );
        return switch (value.getClass().getSimpleName()) {
            case "Integer" -> "int";
            case "Float" -> "float";
            case "String" -> "string";
            case "Boolean" -> "boolean";
            case "Character" -> "char";
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }


    private Object getRealValue(Object value) {
        while (true){
            if (value instanceof Node ){
                value = ((Node) value).execute();
                if (value instanceof NodeVar) {
                    value = ((NodeVar) value).getValue();
                }
            } else {
                return value;
            }
        }
    }

    private Object isNumeric(String strNum) {
        if (strNum == null) {
            return null;
        }
        // ver si tiene punto, si lo tiene es float
        if (strNum.contains(".")){
            try {
                return Float.parseFloat(strNum);
            } catch (NumberFormatException nfe) {
                return null;
            }
        } else {
            try {
               return  Integer.parseInt(strNum);
            } catch (NumberFormatException nfe) {
                return null;
            }
        }
    }



    public Object copyValue(Object original) {
        String type = getTypeFromValue(original);
        return switch (type) {
            case "int" -> Integer.valueOf((Integer) original);
            case "float" -> Float.valueOf((Float) original);
            case "string" -> new String((String) original);
            case "boolean" -> Boolean.valueOf((Boolean) original);
            case "char" -> Character.valueOf((Character) original);
            default -> throw new IllegalStateException("Unexpected value: " + original);
        };
    }

    public Object copy(){
        String name, type;
        name = (String)this.copyValue(this.getName());
        type = (String)this.copyValue(this.getType());
        Object value = this.copyValue(this.getValue());
        Node nname = new NodeLeaf(name);
        Node ntype = new NodeLeaf(type);
        Node nvalue = new NodeLeaf(value);
        return new NodeVar(ntype, nname, nvalue);
    }

}
