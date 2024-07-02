package com.unal;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import com.unal.AST.*;
public class Main {

    private static  String EXTENSION = "jcalc";
    private static  String DIRBASE = "src/test/resources/";
    private static  boolean TEST = false;
    public static void main(String[] args) throws IOException {
        if (TEST){
            args = args.length==0? new String[]{ "test." + EXTENSION } : args;
        }else{
            if (args.length == 0) {
                // si no se pasa nada se imprime que debe pasar un archivo
                System.out.println("Ingrese con extensión .jcalc o .txt como argumento.");
                return;
            }
            // si args no es cero obtenga la ruta absoluta actual, esa es la ruta base
            DIRBASE = System.getProperty("user.dir") + "/";
        }

        for (String file : args){
            // si el archivo no termina en jcalc o txt, imprima que debe pasar un archivo con extensión .jcalc o .txt
            if (!file.endsWith(EXTENSION) && !file.endsWith("txt")) {
                System.out.println("Extensión no válida, debe pasar un archivo con extensión .jcalc o .txt como argumento.");
                return;
            }
            CharStream in = CharStreams.fromFileName(DIRBASE + file);
            JoinCalcLexer lexer = new JoinCalcLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JoinCalcParser parser = new JoinCalcParser(tokens);
            JoinCalcParser.ProgramContext tree = parser.program();
            JoinCalcCustomVisitor visitor = new JoinCalcCustomVisitor();
             Object result = visitor.visit(tree);
             result = result instanceof Node n ? n.execute() : result;
            //System.out.println("FINISH: " + file);
            System.out.println("RESULT: " + result);
        }
    }
//    public static void main(String[] args) throws IOException {
//        String files[] = args.length==0? new String[]{ "test." + EXTENSION } : args;
//        System.out.println("Dirbase: " + DIRBASE);
//        for (String file : files){
//            System.out.println("START: " + file);
//
//            CharStream in = CharStreams.fromFileName(DIRBASE + file);
//            JoinCalcLexer lexer = new JoinCalcLexer(in);
//            CommonTokenStream tokens = new CommonTokenStream(lexer);
//            JoinCalcParser parser = new JoinCalcParser(tokens);
//            JoinCalcParser.ProgramContext tree = parser.program();
//            JoinCalcCustomVisitor visitor = new JoinCalcCustomVisitor();
//            Object result = visitor.visit(tree);
//            result = result instanceof Node n ? n.execute() : result;
//            System.out.println("FINISH: " + file);
//            System.out.println("RESULT: " + result);
//        }
//    }


}
