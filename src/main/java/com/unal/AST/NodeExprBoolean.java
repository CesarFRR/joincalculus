package com.unal.AST;

public class NodeExprBoolean extends Node3 implements InterfaceExpr{

    public NodeExprBoolean(Node expr1, Node boolOperator, Node expr2) {
        super( expr1, boolOperator, expr2);
    }


    /**
     * Ejecuta la acción de este nodo.
     *
     * @return
     **/
    @Override
    public Object execute() {
        Object result, ch1, ch3;
        if (child1 != null  && child2 != null) {
            ch1 = getRealValue(child1);
            ch3 = getRealValue(child3);

            Object e1 = getRealValue(child1);
            Object operator = getRealValue(child2);
            Object e2 = getRealValue(child3);

            e1 = e1 instanceof NodeVar nv ? nv.getValue() : e1;
            e2 = e2 instanceof NodeVar nv ? nv.getValue() : e2;
            e1 = getRealValue(e1);
            e2 = getRealValue(e2);
            if (!(operator instanceof String)) throw new IllegalStateException("El operador no es válido. (1)");

            String op = (String) operator;
            if (op.equals("&&") || op.equals("||") || op.equals("!")) {
                return switch (op) {
                    case "&&" -> {
                        if (!(e1 instanceof Boolean && e2 instanceof Boolean))
                            throw new IllegalStateException("Operador no válido");
                        yield (Boolean) e1 && (Boolean) e2;
                    }
                    case "||" -> {
                        if (!(e1 instanceof Boolean && e2 instanceof Boolean))
                            throw new IllegalStateException("Operador no válido");
                        yield (Boolean) e1 || (Boolean) e2;
                    }
                    case "!" -> {
                        if (!(e1 instanceof Boolean)) throw new IllegalStateException("Operador no válido");
                        yield !(Boolean) e1;
                    }
                    default -> throw new IllegalStateException("Operador no válido");
                };

            }
//            System.out.println("operacion bool: " + e1 + " " + operator + " " + e2 + "\n");

            if (e1 instanceof String || e2 instanceof String) {
                Object a, b;
                a = e1 instanceof Node n? n.execute() : e1;
                b = e2 instanceof Node n? n.execute() : e2;
                a = a.toString().replace("\"", "");
                b = b.toString().replace("\"", "");
                result = a.toString().equals(b.toString());
                if (operator.equals("!=")) result = !((boolean) result);

            }else if( operator.equals("&&") || operator.equals("||")){
                if(!(e1 instanceof Boolean && e2 instanceof Boolean)) throw new IllegalStateException("Operador no válido");
                result = switch ((String) operator) {
                    case "&&" -> (Boolean) e1 && (Boolean) e2;
                    case "||" -> (Boolean) e1 || (Boolean) e2;
                    default -> "Operador no válido";
                };
            } else if(e1 instanceof Boolean && e2 == null && operator.equals("!")){
                result = !(Boolean) e1;

            } else {

                double diff = 0;
                double epsilon = 1e-10; // o cualquier otro valor pequeño
//                System.out.println("e1: " + e1 + " e2: " + e2 + " operator: " + operator + "\n");
                diff = ((Number) e1).doubleValue() - ((Number) e2).doubleValue();
                result = switch ((String) operator) {
                    case "<" -> Math.abs(diff) < epsilon ? false : diff < 0;
                    case "<=" -> Math.abs(diff) < epsilon ? true : diff < 0;
                    case ">" -> Math.abs(diff) < epsilon ? false : diff > 0;
                    case ">=" -> Math.abs(diff) < epsilon ? true : diff > 0;
                    case "==" -> Math.abs(diff) < epsilon;
                    case "!=" -> Math.abs(diff) > epsilon;
                    default -> "Operador no válido";
                };

                if (result instanceof String s) throw new IllegalStateException("El operador no es válido. (2)");
            }
        }else throw new IllegalStateException("No se pudo ejecutar la expresión booleana, falta algún operando u operando.");

        return result;
    }
}
