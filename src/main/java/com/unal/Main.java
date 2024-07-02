package com.unal;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import com.unal.AST.*;
public class Main {

    private static final String EXTENSION = "jcalc";
    private static final String DIRBASE = "src/test/resources/";

    public static void main(String[] args) throws IOException {
        String files[] = args.length==0? new String[]{ "test." + EXTENSION } : args;
        System.out.println("Dirbase: " + DIRBASE);
        for (String file : files){
            System.out.println("START: " + file);

            CharStream in = CharStreams.fromFileName(DIRBASE + file);
            JoinCalcLexer lexer = new JoinCalcLexer(in);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JoinCalcParser parser = new JoinCalcParser(tokens);
            JoinCalcParser.ProgramContext tree = parser.program();
            JoinCalcCustomVisitor visitor = new JoinCalcCustomVisitor();
             Object result = visitor.visit(tree);
             result = result instanceof Node n ? n.execute() : result;
            System.out.println("FINISH: " + file);
            System.out.println("RESULT: " + result);
        }
    }
}
