// Generated from /home/cesar/dev/LENGUAJES/joincalculus/src/main/antlr4/com/unal/JoinCalc.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JoinCalcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JoinCalcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(JoinCalcParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#chnls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChnls(JoinCalcParser.ChnlsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#process}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcess(JoinCalcParser.ProcessContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JoinCalcParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#send}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSend(JoinCalcParser.SendContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#receive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceive(JoinCalcParser.ReceiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(JoinCalcParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#sleep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSleep(JoinCalcParser.SleepContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#channel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChannel(JoinCalcParser.ChannelContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(JoinCalcParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(JoinCalcParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#conjetura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjetura(JoinCalcParser.ConjeturaContext ctx);
	/**
	 * Visit a parse tree produced by {@link JoinCalcParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(JoinCalcParser.OpContext ctx);
}