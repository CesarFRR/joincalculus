package com.unal.AST;


public class NodeExprArithmetic extends Node3 implements InterfaceExpr{

    public NodeExprArithmetic( Node expr1, Node operator, Node expr2) {
        super(expr1, operator, expr2);
    }

    /**
     * Ejecuta la acción de este nodo.
     *
     * @return
     **/
    @Override
    public Object execute() {


        Object l, r;
        l = child1;
        r = child3;



        if(child1 instanceof NodeID nvid){
            l = nvid.execute();
        }
        if(child3 instanceof NodeID nvid){
            //System.out.println("es instancia de NodeVarId" + nvid.execute() + "\n");
            r =  nvid.execute();
        }
        if (l instanceof NodeVar nv){
            l = new NodeLeaf(nv.getValue());
        }
        if (r instanceof NodeVar nv){
            r = new NodeLeaf(nv.getValue());
        }


        if(!(child1 instanceof Node nl)){
            l = new NodeLeaf(child1);
        }
        if(!(child2 instanceof Node nl)){
            r = new NodeLeaf(child3);
        }
        l = (l==null) ? child1.execute() : l;
        r = (r==null) ? child3.execute() : r;

//        System.out.println("operacion: " + l + " " + child2.execute() + " " + r + "\n");
        Object left = getRealValue(l); // getRealValue(
        Object operator = getRealValue(child2);
        Object right = getRealValue(r);


//        System.out.println("operacion aritmetica: " + left + " " + operator + " " + right + "\n");


        switch (operator.toString()) {
            case "+" -> {
                if (isType(left, "String") || isType(right, "String")) {
                    return (left.toString() + right.toString()).replace("\"", "");
                } else if (isType(left, "Float") || isType(right, "Float")) {
                    return Float.parseFloat(left.toString()) + Float.parseFloat(right.toString());
                } else {

                    //System.out.println("left: " + left.toString() + " right: " + right.toString());
                    return Integer.parseInt(left.toString()) + Integer.parseInt(right.toString());
                }
            }
            case "-" -> {
                if (isType(left, "Float") || isType(right, "Float")) {
                    //this.result_type = "Float";
                    return Float.parseFloat(left.toString()) - Float.parseFloat(right.toString());
                } else {
                    //this.result_type = "Integer";
//                    System.out.println("e1: " + left + " e2: " + right + " operator: " + operator + "\n");
                    return Integer.parseInt(left.toString()) - Integer.parseInt(right.toString());
                }
            }
            case "*" -> {
                if (isType(left, "Float") || isType(right, "Float")) {
                    //this.result_type = "Float";
                    return Float.parseFloat(left.toString()) * Float.parseFloat(right.toString());
                } else {
                    //this.result_type = "Integer";
                    return Integer.parseInt(left.toString()) * Integer.parseInt(right.toString());
                }
            }
            case "/" -> {
                if (Float.parseFloat(right.toString()) == 0) {
                    throw new IllegalStateException("No se puede dividir por 0");
                }
                if (isType(left, "Float") || isType(right, "Float")) {
                    //this.result_type = "Float";
                    return Float.parseFloat(left.toString()) / Float.parseFloat(right.toString());
                } else {
                    //this.result_type = "Integer";
                    return Integer.parseInt(left.toString()) / Integer.parseInt(right.toString());
                }
            }
            case "%" -> {
                if (isType(left, "Float") || isType(right, "Float")) {
                    //this.result_type = "Float";
                    return Float.parseFloat(left.toString()) % Float.parseFloat(right.toString());
                } else {
                    //this.result_type = "Integer";
                    return Integer.parseInt(left.toString()) % Integer.parseInt(right.toString());
                }
            }
            case "^" -> {
                Double result;
                if (isType(left, "Float") || isType(right, "Float")) {
                    result = Math.pow(Float.parseFloat(left.toString()), Float.parseFloat(right.toString()));
                } else {
                    result = Math.pow(Integer.parseInt(left.toString()), Integer.parseInt(right.toString()));
                }

                if (result.equals(Math.floor(result))) {
                    // result es un número entero, devolver como int
                    return result.intValue();
                } else {
                    // result no es un número entero, devolver como float
                    return result.floatValue();
                }
            }
            default -> {
                throw new IllegalStateException("Operador no válido");
            }
        }
    }


    public static boolean isType(Object obj, String type) {
        String actualType = getDataType(obj);

        if (actualType.equals("Double") && type.equals("Float")) {
            return true;
        }
        return actualType.equals(type);
    }

    public static String getDataType(Object obj) {
        switch (obj) {
            case Integer i -> {
                return "Integer";
            }
            case Float v -> {
                return "Float";
            }
            case String s -> {
                String str = obj.toString();
                if (str.matches("\\d+\\.\\d+")) {
                    return "Float";
                } else {
                    return "String";
                }
            }
            case null, default -> {
                return "Unknown";
            }
        }
    }
}
