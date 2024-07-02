// Generated from /home/cesar/dev/LENGUAJES/joincalculus/src/main/antlr4/com/unal/JoinCalc.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JoinCalcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		INT=18, STRING=19, REAL=20, ID=21;
	public static final int
		RULE_program = 0, RULE_chnls = 1, RULE_process = 2, RULE_statement = 3, 
		RULE_send = 4, RULE_receive = 5, RULE_print = 6, RULE_sleep = 7, RULE_channel = 8, 
		RULE_value = 9, RULE_expression = 10, RULE_conjetura = 11, RULE_op = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "chnls", "process", "statement", "send", "receive", "print", 
			"sleep", "channel", "value", "expression", "conjetura", "op"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'channels'", "';'", "'process'", "'{'", "'}'", "'send'", "'('", 
			"')'", "'receive'", "'print'", "','", "'sleep'", "'conjetura'", "'+'", 
			"'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "INT", "STRING", "REAL", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "JoinCalc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JoinCalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<ChnlsContext> chnls() {
			return getRuleContexts(ChnlsContext.class);
		}
		public ChnlsContext chnls(int i) {
			return getRuleContext(ChnlsContext.class,i);
		}
		public List<ProcessContext> process() {
			return getRuleContexts(ProcessContext.class);
		}
		public ProcessContext process(int i) {
			return getRuleContext(ProcessContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(26);
				chnls();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(32);
				process();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChnlsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JoinCalcParser.ID, 0); }
		public ChnlsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chnls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterChnls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitChnls(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitChnls(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChnlsContext chnls() throws RecognitionException {
		ChnlsContext _localctx = new ChnlsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_chnls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__0);
			setState(39);
			match(ID);
			setState(40);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProcessContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JoinCalcParser.ID, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProcessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_process; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterProcess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitProcess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitProcess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcessContext process() throws RecognitionException {
		ProcessContext _localctx = new ProcessContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_process);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__2);
			setState(43);
			match(ID);
			setState(44);
			match(T__3);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5696L) != 0)) {
				{
				{
				setState(45);
				statement();
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public SendContext send() {
			return getRuleContext(SendContext.class,0);
		}
		public ReceiveContext receive() {
			return getRuleContext(ReceiveContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public SleepContext sleep() {
			return getRuleContext(SleepContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				send();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				receive();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				print();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				sleep();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SendContext extends ParserRuleContext {
		public ChannelContext channel() {
			return getRuleContext(ChannelContext.class,0);
		}
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public SendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_send; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterSend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitSend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitSend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SendContext send() throws RecognitionException {
		SendContext _localctx = new SendContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_send);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__5);
			setState(60);
			channel();
			setState(61);
			match(T__6);
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0)) {
				{
				{
				setState(62);
				value();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
			match(T__7);
			setState(69);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReceiveContext extends ParserRuleContext {
		public ChannelContext channel() {
			return getRuleContext(ChannelContext.class,0);
		}
		public TerminalNode ID() { return getToken(JoinCalcParser.ID, 0); }
		public ReceiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterReceive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitReceive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitReceive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReceiveContext receive() throws RecognitionException {
		ReceiveContext _localctx = new ReceiveContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_receive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__8);
			setState(72);
			channel();
			setState(73);
			match(T__6);
			setState(74);
			match(ID);
			setState(75);
			match(T__7);
			setState(76);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_print);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__9);
			setState(79);
			match(T__6);
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(80);
				value();
				}
				break;
			case 2:
				{
				setState(81);
				expression();
				}
				break;
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(84);
				match(T__10);
				setState(87);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(85);
					value();
					}
					break;
				case 2:
					{
					setState(86);
					expression();
					}
					break;
				}
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__7);
			setState(95);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SleepContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public SleepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sleep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterSleep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitSleep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitSleep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SleepContext sleep() throws RecognitionException {
		SleepContext _localctx = new SleepContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sleep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__11);
			setState(98);
			match(T__6);
			setState(99);
			value();
			setState(100);
			match(T__7);
			setState(101);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChannelContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JoinCalcParser.ID, 0); }
		public ChannelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_channel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterChannel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitChannel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitChannel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChannelContext channel() throws RecognitionException {
		ChannelContext _localctx = new ChannelContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_channel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(JoinCalcParser.INT, 0); }
		public TerminalNode STRING() { return getToken(JoinCalcParser.STRING, 0); }
		public TerminalNode REAL() { return getToken(JoinCalcParser.REAL, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1835008L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			value();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) {
				{
				{
				setState(108);
				op();
				setState(109);
				value();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConjeturaContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ConjeturaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjetura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterConjetura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitConjetura(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitConjetura(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjeturaContext conjetura() throws RecognitionException {
		ConjeturaContext _localctx = new ConjeturaContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_conjetura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__12);
			setState(117);
			match(T__6);
			setState(118);
			value();
			setState(119);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JoinCalcListener ) ((JoinCalcListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JoinCalcVisitor ) return ((JoinCalcVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 245760L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0015|\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000\f\u0000\u001f"+
		"\t\u0000\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002/\b\u0002\n\u0002\f\u00022\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003:\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004@\b\u0004\n\u0004\f\u0004C\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006S\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006X\b\u0006"+
		"\u0005\u0006Z\b\u0006\n\u0006\f\u0006]\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\np\b\n\n\n\f\ns\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0002\u0001\u0000"+
		"\u0012\u0014\u0001\u0000\u000e\u0011y\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0002&\u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000\u0000\u00069"+
		"\u0001\u0000\u0000\u0000\b;\u0001\u0000\u0000\u0000\nG\u0001\u0000\u0000"+
		"\u0000\fN\u0001\u0000\u0000\u0000\u000ea\u0001\u0000\u0000\u0000\u0010"+
		"g\u0001\u0000\u0000\u0000\u0012i\u0001\u0000\u0000\u0000\u0014k\u0001"+
		"\u0000\u0000\u0000\u0016t\u0001\u0000\u0000\u0000\u0018y\u0001\u0000\u0000"+
		"\u0000\u001a\u001c\u0003\u0002\u0001\u0000\u001b\u001a\u0001\u0000\u0000"+
		"\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000"+
		"\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e#\u0001\u0000\u0000\u0000"+
		"\u001f\u001d\u0001\u0000\u0000\u0000 \"\u0003\u0004\u0002\u0000! \u0001"+
		"\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000"+
		"#$\u0001\u0000\u0000\u0000$\u0001\u0001\u0000\u0000\u0000%#\u0001\u0000"+
		"\u0000\u0000&\'\u0005\u0001\u0000\u0000\'(\u0005\u0015\u0000\u0000()\u0005"+
		"\u0002\u0000\u0000)\u0003\u0001\u0000\u0000\u0000*+\u0005\u0003\u0000"+
		"\u0000+,\u0005\u0015\u0000\u0000,0\u0005\u0004\u0000\u0000-/\u0003\u0006"+
		"\u0003\u0000.-\u0001\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u0000"+
		"20\u0001\u0000\u0000\u000034\u0005\u0005\u0000\u00004\u0005\u0001\u0000"+
		"\u0000\u00005:\u0003\b\u0004\u00006:\u0003\n\u0005\u00007:\u0003\f\u0006"+
		"\u00008:\u0003\u000e\u0007\u000095\u0001\u0000\u0000\u000096\u0001\u0000"+
		"\u0000\u000097\u0001\u0000\u0000\u000098\u0001\u0000\u0000\u0000:\u0007"+
		"\u0001\u0000\u0000\u0000;<\u0005\u0006\u0000\u0000<=\u0003\u0010\b\u0000"+
		"=A\u0005\u0007\u0000\u0000>@\u0003\u0012\t\u0000?>\u0001\u0000\u0000\u0000"+
		"@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000BD\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DE\u0005\b\u0000"+
		"\u0000EF\u0005\u0002\u0000\u0000F\t\u0001\u0000\u0000\u0000GH\u0005\t"+
		"\u0000\u0000HI\u0003\u0010\b\u0000IJ\u0005\u0007\u0000\u0000JK\u0005\u0015"+
		"\u0000\u0000KL\u0005\b\u0000\u0000LM\u0005\u0002\u0000\u0000M\u000b\u0001"+
		"\u0000\u0000\u0000NO\u0005\n\u0000\u0000OR\u0005\u0007\u0000\u0000PS\u0003"+
		"\u0012\t\u0000QS\u0003\u0014\n\u0000RP\u0001\u0000\u0000\u0000RQ\u0001"+
		"\u0000\u0000\u0000S[\u0001\u0000\u0000\u0000TW\u0005\u000b\u0000\u0000"+
		"UX\u0003\u0012\t\u0000VX\u0003\u0014\n\u0000WU\u0001\u0000\u0000\u0000"+
		"WV\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000YT\u0001\u0000\u0000"+
		"\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000"+
		"\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005"+
		"\b\u0000\u0000_`\u0005\u0002\u0000\u0000`\r\u0001\u0000\u0000\u0000ab"+
		"\u0005\f\u0000\u0000bc\u0005\u0007\u0000\u0000cd\u0003\u0012\t\u0000d"+
		"e\u0005\b\u0000\u0000ef\u0005\u0002\u0000\u0000f\u000f\u0001\u0000\u0000"+
		"\u0000gh\u0005\u0015\u0000\u0000h\u0011\u0001\u0000\u0000\u0000ij\u0007"+
		"\u0000\u0000\u0000j\u0013\u0001\u0000\u0000\u0000kq\u0003\u0012\t\u0000"+
		"lm\u0003\u0018\f\u0000mn\u0003\u0012\t\u0000np\u0001\u0000\u0000\u0000"+
		"ol\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000r\u0015\u0001\u0000\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000tu\u0005\r\u0000\u0000uv\u0005\u0007\u0000\u0000vw\u0003"+
		"\u0012\t\u0000wx\u0005\b\u0000\u0000x\u0017\u0001\u0000\u0000\u0000yz"+
		"\u0007\u0001\u0000\u0000z\u0019\u0001\u0000\u0000\u0000\t\u001d#09ARW"+
		"[q";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}