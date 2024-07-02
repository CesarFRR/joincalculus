// Generated from /home/cesar/dev/LENGUAJES/joincalculus/src/main/antlr4/com/unal/JoinCalc.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JoinCalcParser}.
 */
public interface JoinCalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(JoinCalcParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(JoinCalcParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#chnls}.
	 * @param ctx the parse tree
	 */
	void enterChnls(JoinCalcParser.ChnlsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#chnls}.
	 * @param ctx the parse tree
	 */
	void exitChnls(JoinCalcParser.ChnlsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#process}.
	 * @param ctx the parse tree
	 */
	void enterProcess(JoinCalcParser.ProcessContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#process}.
	 * @param ctx the parse tree
	 */
	void exitProcess(JoinCalcParser.ProcessContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JoinCalcParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JoinCalcParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#send}.
	 * @param ctx the parse tree
	 */
	void enterSend(JoinCalcParser.SendContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#send}.
	 * @param ctx the parse tree
	 */
	void exitSend(JoinCalcParser.SendContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#receive}.
	 * @param ctx the parse tree
	 */
	void enterReceive(JoinCalcParser.ReceiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#receive}.
	 * @param ctx the parse tree
	 */
	void exitReceive(JoinCalcParser.ReceiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(JoinCalcParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(JoinCalcParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#sleep}.
	 * @param ctx the parse tree
	 */
	void enterSleep(JoinCalcParser.SleepContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#sleep}.
	 * @param ctx the parse tree
	 */
	void exitSleep(JoinCalcParser.SleepContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#channel}.
	 * @param ctx the parse tree
	 */
	void enterChannel(JoinCalcParser.ChannelContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#channel}.
	 * @param ctx the parse tree
	 */
	void exitChannel(JoinCalcParser.ChannelContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(JoinCalcParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(JoinCalcParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(JoinCalcParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(JoinCalcParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#conjetura}.
	 * @param ctx the parse tree
	 */
	void enterConjetura(JoinCalcParser.ConjeturaContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#conjetura}.
	 * @param ctx the parse tree
	 */
	void exitConjetura(JoinCalcParser.ConjeturaContext ctx);
	/**
	 * Enter a parse tree produced by {@link JoinCalcParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(JoinCalcParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link JoinCalcParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(JoinCalcParser.OpContext ctx);
}