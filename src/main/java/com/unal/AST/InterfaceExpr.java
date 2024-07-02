package com.unal.AST;

public interface InterfaceExpr {

    public default Object getRealValue(Object value) {
        Object v =value;
        while (true){
            if (v instanceof Node n) {
                v = n.execute();
                if(v== null){
                    return null;
                }
               return v;
            } else {
                return v;
            }
        }
    }


    public default String cleanString(String cadena) {
        cadena = cadena.replace("\"", "");
        return cadena;
    }


    public default Object copyValue(Object original) {
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
    public default String getTypeFromValue(Object value) {
        if (value instanceof Node) value = getRealValue(value);
        // System.out.println("VALOR DE VALUE: " + value + " " + value.getClass().getSimpleName() );
        return switch (value.getClass().getSimpleName()) {
            case "Integer" -> "int";
            case "Float" -> "float";
            case "String" -> "string";
            case "Boolean" -> "boolean";
            case "Character" -> "char";
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }


    default Object getDefaultValue(String type) {
        return switch (type) {
            case "int" -> 0;
            case "float" -> 0.0;
            case "string" -> "";
            case "boolean" -> false;
            case "char" -> '\u0000';
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }




}
