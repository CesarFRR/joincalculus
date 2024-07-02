
package com.unal;
import com.unal.AST.*;

public class JoinCalcCustomVisitor extends JoinCalcBaseVisitor<Node>  implements InterfaceExpr{
    private static TableAST table;
    static {
        table = new TableAST();
    }


    /**
     * Visit a parse tree produced by {JoinCalcParser#program}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitProgram(JoinCalcParser.ProgramContext ctx) {
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by {JoinCalcParser#sent_list}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitSent_list(JoinCalcParser.Sent_listContext ctx) {
        NodeTree nt = null;
        NodeTree current = null;
        //System.out.println("sentencias: " + ctx.sent());
        //System.out.println("Hay en total " + ctx.sent().size() + " sentencias.");
        for (int i = 0; i < ctx.sent().size(); i++) {
            Node n = visit(ctx.sent(i));
//            System.out.println("n: " + n);
            if (i == 0) {
                nt = new NodeTree(n, null);
                current = nt;
            } else {
                NodeTree next = new NodeTree(n, null);
                current.child = next;
                current = next;
            }
        }
        return nt;
    }

    /**
     * Visit a parse tree produced by {JoinCalcParser#sent}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitSent(JoinCalcParser.SentContext ctx) {
        if (ctx.declar() != null) {
            return visit(ctx.declar());
        } else if (ctx.assign() != null) {
            return visit(ctx.assign());
        } else if (ctx.expr() != null) {
            return visit(ctx.expr());
        } else if (ctx.sent_if() != null) {
            return visit(ctx.sent_if());
        } else if (ctx.sleep()!=null) {
            return visit(ctx.sleep());
        }  else if (ctx.println()!=null) {
            return visit(ctx.println());
        }else if (ctx.print()!=null) {
            return visit(ctx.print());
        }else if (ctx.channel_decl()!=null) {
            return visit(ctx.channel_decl());
        } else if (ctx.channel_send()!=null) {
            return visit(ctx.channel_send());
        } else if (ctx.process_decl()!=null) {
            return visit(ctx.process_decl());
        } else if (ctx.process_run()!=null) {
            return visit(ctx.process_run());
        } else if (ctx.process_stop()!=null) {
            return visit(ctx.process_stop());
        } else if (ctx.spawn()!=null) {
            return visit(ctx.spawn());
        } else if (ctx.sent_for()!=null) {
            return visit(ctx.sent_for());
        } else if (ctx.sent_while()!=null) {
            return visit(ctx.sent_while());
        } else if (ctx.sent_break()!=null) {
            return visit(ctx.sent_break());
        } else if (ctx.sent_continue()!=null) {
            return visit(ctx.sent_continue());
        }



        // Añadir más condiciones para las nuevas alternativas
        //System.out.println("sent: " + ctx.getText() + "\n");
        return visitChildren(ctx);
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#print}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitPrint(JoinCalcParser.PrintContext ctx) {
        return new NodeFnPrint(visit(ctx.expr()));
    }

    /**
     * Visit a parse tree produced by {JoinCalcParser#assign}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitAssign(JoinCalcParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        NodeVar nv;
        Node v = visit(ctx.expr());
        nv = new NodeVar(null, new NodeLeaf(id), v);
        return nv;
    }

    /**
     * Visit a parse tree produced by { JoinCalcParser#sleep}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitSleep(JoinCalcParser.SleepContext ctx) {
        return new NodeSleep(visit(ctx.expr()));
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#random}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitRandom(JoinCalcParser.RandomContext ctx) {
        Node min = visit(ctx.expr(0));
        Node max = visit(ctx.expr(1));
        return new NodeRandom(min, max);
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#spawn}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitSpawn(JoinCalcParser.SpawnContext ctx) {
        Node name = new NodeLeaf(ctx.ID().getText());
        Node quantity = visit(ctx.expr());
        return new NodeSpawn(name, quantity);
    }

    /**
     * Visit a parse tree produced by { JoinCalcParser#declar}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitDeclar(JoinCalcParser.DeclarContext ctx) {

        Node t = visit(ctx.type());
        String type = (String) t.execute();
        Node id = new NodeLeaf(ctx.ID().getText() );
        Node v = ctx.expr() != null ? visit(ctx.expr()) : null;
//        //System.out.println("Declar: " + type + " " + id + " " + v + "\n");
        return new NodeVar(t, id, v);
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#channel_decl}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitChannel_decl(JoinCalcParser.Channel_declContext ctx) {
        Node id;
        NodeChannel chn;
        for (int i = 0; i < ctx.ID().size(); i++) {
            id = new NodeLeaf(ctx.ID(i).getText());
            chn = new NodeChannel(id, null);
            table.setChannel(id.toString(), chn);
        }
//        //System.out.println("channels:\n");
//        table.printChannels();
        return null;
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#channel_send}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitChannel_send(JoinCalcParser.Channel_sendContext ctx) {
        Node channelName = new NodeLeaf(ctx.ID().getText());
        Node v = visit(ctx.expr());
        return new NodeSend(channelName, v);
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#channel_receive}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitChannel_receive(JoinCalcParser.Channel_receiveContext ctx) {
        Node channelName = new NodeLeaf(ctx.ID().getText());
        return new NodeReceive(channelName);
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#process_decl}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitProcess_decl(JoinCalcParser.Process_declContext ctx) {
        Node id;
        NodeTree sentlist;
        String name = ctx.ID().getText();
        id = new NodeLeaf(name);
        sentlist = (NodeTree) visit(ctx.sent_list());
        table.setProcess(name,  new NodeProcess(id, sentlist)) ;
        return null;
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#process_run}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitProcess_run(JoinCalcParser.Process_runContext ctx) {
        return table.getProcess(ctx.ID().getText());
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#process_stop}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitProcess_stop(JoinCalcParser.Process_stopContext ctx) {

        NodeProcess p = new NodeProcess(null, null);
        p.stopInstruccion();
        return p;
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#is_empty}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitIs_empty(JoinCalcParser.Is_emptyContext ctx) {
        Node id = visit(ctx.expr());
        return new NodeIsEmpty(id);
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#println}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitPrintln(JoinCalcParser.PrintlnContext ctx) {
        Node v = visit(ctx.expr());
        return new NodeFnPrintln(v);
    }

    /**
     * Visit a parse tree produced by { JoinCalcParser#type}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitType(JoinCalcParser.TypeContext ctx) {
        return new NodeLeaf(ctx.getText());
    }

    /**
     * Visit a parse tree produced by the {@code litInt}
     * labeled alternative in {JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitLitInt(JoinCalcParser.LitIntContext ctx) {
        Object i = Integer.parseInt(ctx.INT().getText());
        return new NodeLeaf(i);
    }

    /**
     * Visit a parse tree produced by the {@code opDiv}
     * labeled alternative in { JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitOpDiv(JoinCalcParser.OpDivContext ctx) {
        Node e1 = visit(ctx.expr(0));
        Node e2 = visit(ctx.expr(1));
        return new NodeExprArithmetic( e1, new NodeLeaf("/"), e2);
    }

    /**
     * Visit a parse tree produced by the {@code notBool}
     * labeled alternative in { JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitNotBool(JoinCalcParser.NotBoolContext ctx) {
        Node e = visit(ctx.expr());
        return new NodeExprBoolean(e, new NodeLeaf("!"), null);
    }

    /**
     * Visit a parse tree produced by the {@code opPot}
     * labeled alternative in { JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitOpPot(JoinCalcParser.OpPotContext ctx) {
        Node e1 = visit(ctx.expr(0));
        Node e2 = visit(ctx.expr(1));
        return new NodeExprArithmetic( e1, new NodeLeaf("^"), e2);
    }

    /**
     * Visit a parse tree produced by the {@code opMod}
     * labeled alternative in { JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitOpMod(JoinCalcParser.OpModContext ctx) {
        Node e1 = visit(ctx.expr(0));
        Node e2 = visit(ctx.expr(1));
        return new NodeExprArithmetic( e1, new NodeLeaf("%"), e2);
    }

    /**
     * Visit a parse tree produced by the {@code fnIsEmpty}
     * labeled alternative in { JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitFnIsEmpty(JoinCalcParser.FnIsEmptyContext ctx) {
        return visit(ctx.is_empty());
    }

    /**
     * Visit a parse tree produced by the {@code andBool}
     * labeled alternative in { JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitAndBool(JoinCalcParser.AndBoolContext ctx) {
        Node e1 = visit(ctx.expr(0));
        Node e2 = visit(ctx.expr(1));
        Node op = new NodeLeaf("&&");
        return new NodeExprBoolean(e1, op, e2);
    }

    /**
     * Visit a parse tree produced by the {@code negExpr}
     * labeled alternative in { JoinCalcParser #expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitNegExpr(JoinCalcParser.NegExprContext ctx) {
        Node e = visit(ctx.expr());
        return new NodeExprArithmetic(new NodeLeaf(0), new NodeLeaf("-"), e);
    }

    /**
     * Visit a parse tree produced by the {@code fnRandom}
     * labeled alternative in { JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitFnRandom(JoinCalcParser.FnRandomContext ctx) {
        return visit(ctx.random());
    }

    /**
     * Visit a parse tree produced by the {@code litBoolean}
     * labeled alternative in { JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitLitBoolean(JoinCalcParser.LitBooleanContext ctx) {
        String lit = ctx.BOOLEAN().getText();
        boolean b = Boolean.parseBoolean(lit);
        return new NodeExprBoolean(new NodeLeaf(b), new NodeLeaf("&&"), new NodeLeaf(b));
    }

    /**
     * Visit a parse tree produced by the {@code opBool}
     * labeled alternative in { JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitOpBool(JoinCalcParser.OpBoolContext ctx) {
        Node e1 = visit(ctx.expr(0));
        Node e2 = visit(ctx.expr(1));
        Node op = visit(ctx.operators_bool());
        return new NodeExprBoolean(e1, op, e2);
    }

    /**
     * Visit a parse tree produced by the {@code litFloat}
     * labeled alternative in {JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitLitFloat(JoinCalcParser.LitFloatContext ctx) {
        Object f = Float.parseFloat(ctx.FLOAT().getText());
        return new NodeLeaf(f);
    }

    /**
     * Visit a parse tree produced by the {@code opResta}
     * labeled alternative in {JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitOpResta(JoinCalcParser.OpRestaContext ctx) {
        Node e1 = visit(ctx.expr(0));
        Node e2 = visit(ctx.expr(1));
        return new NodeExprArithmetic( e1, new NodeLeaf("-"), e2);
    }

    /**
     * Visit a parse tree produced by the {@code opMult}
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitOpMult(JoinCalcParser.OpMultContext ctx) {
        Node e1 = visit(ctx.expr(0));
        Node e2 = visit(ctx.expr(1));
        return new NodeExprArithmetic( e1, new NodeLeaf("*"), e2);
    }

    /**
     * Visit a parse tree produced by the {@code innerExpr}
     * labeled alternative in {JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitInnerExpr(JoinCalcParser.InnerExprContext ctx) {
        if(ctx.expr() != null)
            return visit(ctx.expr());
        return visitChildren(ctx);
    }


    /**
     * Visit a parse tree produced by the {@code id}
     * labeled alternative in {JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitId(JoinCalcParser.IdContext ctx) {
        String id = ctx.ID().getText();
        //System.out.println("id: " + id + "\n");
        return new NodeID(id);
    }

    /**
     * Visit a parse tree produced by the {@code fnReceive}
     * labeled alternative in { JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitFnReceive(JoinCalcParser.FnReceiveContext ctx) {
        return visit(ctx.channel_receive());
    }

    /**
     * Visit a parse tree produced by the {@code orBool}
     * labeled alternative in { JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitOrBool(JoinCalcParser.OrBoolContext ctx) {
        Node e1 = visit(ctx.expr(0));
        Node e2 = visit(ctx.expr(1));
        Node op = new NodeLeaf("||");
        return new NodeExprBoolean(e1, op, e2);
    }

    /**
     * Visit a parse tree produced by the {@code opSuma}
     * labeled alternative in {JoinCalcParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitOpSuma(JoinCalcParser.OpSumaContext ctx) {
        Node e1 = visit(ctx.expr(0));
        Node e2 = visit(ctx.expr(1));
        ////System.out.println("opSuma: " + e1 + " " + e2 + "\n");
        return new NodeExprArithmetic( e1, new NodeLeaf("+"), e2);
    }

    /**
     * Visit a parse tree produced by the {@code litString}
     * labeled alternative in { JoinCalcParser#}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitLitString(JoinCalcParser.LitStringContext ctx) {
        String s = ctx.STRING().getText();
        return new NodeLeaf(s);
    }

    /**
     * Visit a parse tree produced by { JoinCalcParser#operators_bool}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitOperators_bool(JoinCalcParser.Operators_boolContext ctx) {
        String op = ctx.getText();
        return new NodeLeaf(op);
    }

    /**
     * Visit a parse tree produced by { JoinCalcParser#sent_if}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitSent_if(JoinCalcParser.Sent_ifContext ctx) {
        Node cond = visit(ctx.expr());
        NodeTree sentlist1 = null;
        NodeTree sentlist2 = null;
        if (ctx.sent_list(0)!=null){
            sentlist1 = (NodeTree) visit(ctx.sent_list(0));
        }
        if (ctx.sent_list(1) != null) {
            sentlist2 = (NodeTree) visit(ctx.sent_list(1));
            //System.out.println("hay un else es este: " + sentlist2 + " " + sentlist2.getClass());
        }
        return new NodeStructIfElse(cond, sentlist1, sentlist2);
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#sent_for}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitSent_for(JoinCalcParser.Sent_forContext ctx) {
        NodeTree sentlist = (NodeTree) visit(ctx.sent_list());
        Node declar = visit(ctx.declar());
        Node expr = visit(ctx.expr());
        Node assign = visit(ctx.assign());
        return new NodeStructFor(declar, expr, assign, sentlist);
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#sent_while}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitSent_while(JoinCalcParser.Sent_whileContext ctx) {
        Node cond = visit(ctx.expr());
        NodeTree sentlist = (NodeTree) visit(ctx.sent_list());
        return new NodeStructWhile(cond, sentlist);
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#sent_break}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitSent_break(JoinCalcParser.Sent_breakContext ctx) {
        return new NodeStructBreak();
    }

    /**
     * Visit a parse tree produced by {@link JoinCalcParser#sent_continue}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    @Override
    public Node visitSent_continue(JoinCalcParser.Sent_continueContext ctx) {
        return new NodeStructContinue();
    }

}