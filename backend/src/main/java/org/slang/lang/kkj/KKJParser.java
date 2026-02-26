// Generated from lang/kkj/KKJ.g4 by ANTLR 4.13.0


      package org.slang.lang.kkj;
      import java.util.*;

      import org.core.tokens.arithmetic.*;
      import org.core.tokens.condition.*;
      import org.core.tokens.constant.*;
      import org.core.tokens.functions.*;
      import org.core.tokens.interfaces.*;
      import org.core.tokens.logic.*;
      import org.core.tokens.quotation.*;
      import org.core.tokens.stack.*;
      import static org.slang.lang.kkj.KKJ.*;
    

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class KKJParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, NUM=27, ID=28, STR=29, WHITESPACE=30, LINECOMMENT=31, 
		COMMENT=32, ERROR=33;
	public static final int
		RULE_dProgram = 0, RULE_dSequence = 1, RULE_dConstant = 2, RULE_dArithmeticOperations = 3, 
		RULE_dLogicalOperations = 4, RULE_dStackOperations = 5, RULE_dFunctionOperations = 6, 
		RULE_dConditionsOperation = 7, RULE_dNUM = 8, RULE_dID = 9, RULE_dSTR = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"dProgram", "dSequence", "dConstant", "dArithmeticOperations", "dLogicalOperations", 
			"dStackOperations", "dFunctionOperations", "dConditionsOperation", "dNUM", 
			"dID", "dSTR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "'-'", "'TRUE'", "'FALSE'", "'ADD'", "'SUB'", "'MUL'", "'CMP'", 
			"'NOT'", "'AND'", "'ISNEG'", "'ISPOS'", "'CLEAR'", "'ID'", "'POP'", "'DUP'", 
			"'OVER'", "'SWAP'", "'ROTL'", "'COMPOSE'", "'APPLY'", "'APPLYOVER'", 
			"'{ '", "' }'", "'CHOOSE'", "'WHILE'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "NUM", "ID", "STR", "WHITESPACE", "LINECOMMENT", "COMMENT", 
			"ERROR"
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
	public String getGrammarFileName() { return "KKJ.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KKJParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DProgramContext extends ParserRuleContext {
		public Program _result;
		public DSequenceContext s;
		public TerminalNode EOF() { return getToken(KKJParser.EOF, 0); }
		public DSequenceContext dSequence() {
			return getRuleContext(DSequenceContext.class,0);
		}
		public DProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).enterDProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).exitDProgram(this);
		}
	}

	public final DProgramContext dProgram() throws RecognitionException {
		DProgramContext _localctx = new DProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dProgram);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			((DProgramContext)_localctx).s = dSequence(0);
			setState(23);
			match(EOF);
			 ((DProgramContext)_localctx)._result =  new Program.Prog(((DProgramContext)_localctx).s._result); 
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
	public static class DSequenceContext extends ParserRuleContext {
		public Sequence _result;
		public DSequenceContext s1;
		public DConstantContext c;
		public DArithmeticOperationsContext a;
		public DLogicalOperationsContext l;
		public DStackOperationsContext s;
		public DFunctionOperationsContext f;
		public DConditionsOperationContext o;
		public DSequenceContext s2;
		public DConstantContext dConstant() {
			return getRuleContext(DConstantContext.class,0);
		}
		public DArithmeticOperationsContext dArithmeticOperations() {
			return getRuleContext(DArithmeticOperationsContext.class,0);
		}
		public DLogicalOperationsContext dLogicalOperations() {
			return getRuleContext(DLogicalOperationsContext.class,0);
		}
		public DStackOperationsContext dStackOperations() {
			return getRuleContext(DStackOperationsContext.class,0);
		}
		public DFunctionOperationsContext dFunctionOperations() {
			return getRuleContext(DFunctionOperationsContext.class,0);
		}
		public DConditionsOperationContext dConditionsOperation() {
			return getRuleContext(DConditionsOperationContext.class,0);
		}
		public List<DSequenceContext> dSequence() {
			return getRuleContexts(DSequenceContext.class);
		}
		public DSequenceContext dSequence(int i) {
			return getRuleContext(DSequenceContext.class,i);
		}
		public DSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).enterDSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).exitDSequence(this);
		}
	}

	public final DSequenceContext dSequence() throws RecognitionException {
		return dSequence(0);
	}

	private DSequenceContext dSequence(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DSequenceContext _localctx = new DSequenceContext(_ctx, _parentState);
		DSequenceContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_dSequence, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
			case T__3:
			case NUM:
				{
				setState(27);
				((DSequenceContext)_localctx).c = dConstant();
				 ((DSequenceContext)_localctx)._result =  new Sequence.Cons(((DSequenceContext)_localctx).c._result); 
				}
				break;
			case T__4:
			case T__5:
			case T__6:
			case T__7:
				{
				setState(30);
				((DSequenceContext)_localctx).a = dArithmeticOperations();
				 ((DSequenceContext)_localctx)._result =  new Sequence.ArithmeticOp(((DSequenceContext)_localctx).a._result); 
				}
				break;
			case T__8:
			case T__9:
			case T__10:
			case T__11:
				{
				setState(33);
				((DSequenceContext)_localctx).l = dLogicalOperations();
				 ((DSequenceContext)_localctx)._result =  new Sequence.LogicalOp(((DSequenceContext)_localctx).l._result); 
				}
				break;
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
				{
				setState(36);
				((DSequenceContext)_localctx).s = dStackOperations();
				 ((DSequenceContext)_localctx)._result =  new Sequence.StackOp(((DSequenceContext)_localctx).s._result); 
				}
				break;
			case T__19:
			case T__20:
			case T__21:
			case T__22:
				{
				setState(39);
				((DSequenceContext)_localctx).f = dFunctionOperations();
				 ((DSequenceContext)_localctx)._result =  new Sequence.FunctionOp(((DSequenceContext)_localctx).f._result); 
				}
				break;
			case T__24:
			case T__25:
				{
				setState(42);
				((DSequenceContext)_localctx).o = dConditionsOperation();
				 ((DSequenceContext)_localctx)._result =  new Sequence.ConditionsOp(((DSequenceContext)_localctx).o._result); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DSequenceContext(_parentctx, _parentState);
					_localctx.s1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_dSequence);
					setState(47);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(48);
					match(T__0);
					setState(49);
					((DSequenceContext)_localctx).s2 = dSequence(8);
					 ((DSequenceContext)_localctx)._result =  new Sequence.Seq(((DSequenceContext)_localctx).s1._result, ((DSequenceContext)_localctx).s2._result); 
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DConstantContext extends ParserRuleContext {
		public Constant _result;
		public DNUMContext n;
		public DNUMContext dNUM() {
			return getRuleContext(DNUMContext.class,0);
		}
		public DConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).enterDConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).exitDConstant(this);
		}
	}

	public final DConstantContext dConstant() throws RecognitionException {
		DConstantContext _localctx = new DConstantContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dConstant);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				((DConstantContext)_localctx).n = dNUM();
				 ((DConstantContext)_localctx)._result =  new Constant.PosNum(((DConstantContext)_localctx).n._result); 
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(T__1);
				setState(61);
				((DConstantContext)_localctx).n = dNUM();
				 ((DConstantContext)_localctx)._result =  new Constant.NegNum(((DConstantContext)_localctx).n._result); 
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				match(T__2);
				 ((DConstantContext)_localctx)._result =  new Constant.True(); 
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				match(T__3);
				 ((DConstantContext)_localctx)._result =  new Constant.False(); 
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
	public static class DArithmeticOperationsContext extends ParserRuleContext {
		public ArithmeticOperations _result;
		public DArithmeticOperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dArithmeticOperations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).enterDArithmeticOperations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).exitDArithmeticOperations(this);
		}
	}

	public final DArithmeticOperationsContext dArithmeticOperations() throws RecognitionException {
		DArithmeticOperationsContext _localctx = new DArithmeticOperationsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dArithmeticOperations);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(T__4);
				 ((DArithmeticOperationsContext)_localctx)._result =  new ArithmeticOperations.Add(); 
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(T__5);
				 ((DArithmeticOperationsContext)_localctx)._result =  new ArithmeticOperations.Sub(); 
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(T__6);
				 ((DArithmeticOperationsContext)_localctx)._result =  new ArithmeticOperations.Mul(); 
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				match(T__7);
				 ((DArithmeticOperationsContext)_localctx)._result =  new ArithmeticOperations.Cmp(); 
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
	public static class DLogicalOperationsContext extends ParserRuleContext {
		public LogicalOperations _result;
		public DLogicalOperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dLogicalOperations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).enterDLogicalOperations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).exitDLogicalOperations(this);
		}
	}

	public final DLogicalOperationsContext dLogicalOperations() throws RecognitionException {
		DLogicalOperationsContext _localctx = new DLogicalOperationsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dLogicalOperations);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(T__8);
				 ((DLogicalOperationsContext)_localctx)._result =  new LogicalOperations.Not(); 
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				match(T__9);
				 ((DLogicalOperationsContext)_localctx)._result =  new LogicalOperations.And(); 
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				match(T__10);
				 ((DLogicalOperationsContext)_localctx)._result =  new LogicalOperations.IsNeg(); 
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				match(T__11);
				 ((DLogicalOperationsContext)_localctx)._result =  new LogicalOperations.IsPos(); 
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
	public static class DStackOperationsContext extends ParserRuleContext {
		public StackOperations _result;
		public DStackOperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dStackOperations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).enterDStackOperations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).exitDStackOperations(this);
		}
	}

	public final DStackOperationsContext dStackOperations() throws RecognitionException {
		DStackOperationsContext _localctx = new DStackOperationsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_dStackOperations);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				match(T__12);
				 ((DStackOperationsContext)_localctx)._result =  new StackOperations.Clear(); 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(T__13);
				 ((DStackOperationsContext)_localctx)._result =  new StackOperations.Id(); 
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				match(T__14);
				 ((DStackOperationsContext)_localctx)._result =  new StackOperations.Pop(); 
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				match(T__15);
				 ((DStackOperationsContext)_localctx)._result =  new StackOperations.Dup(); 
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				match(T__16);
				 ((DStackOperationsContext)_localctx)._result =  new StackOperations.Over(); 
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 6);
				{
				setState(100);
				match(T__17);
				 ((DStackOperationsContext)_localctx)._result =  new StackOperations.Swap(); 
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 7);
				{
				setState(102);
				match(T__18);
				 ((DStackOperationsContext)_localctx)._result =  new StackOperations.Rotl(); 
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
	public static class DFunctionOperationsContext extends ParserRuleContext {
		public FunctionOperations _result;
		public DSequenceContext s;
		public List<DSequenceContext> dSequence() {
			return getRuleContexts(DSequenceContext.class);
		}
		public DSequenceContext dSequence(int i) {
			return getRuleContext(DSequenceContext.class,i);
		}
		public DFunctionOperationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dFunctionOperations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).enterDFunctionOperations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).exitDFunctionOperations(this);
		}
	}

	public final DFunctionOperationsContext dFunctionOperations() throws RecognitionException {
		DFunctionOperationsContext _localctx = new DFunctionOperationsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_dFunctionOperations);
		int _la;
		try {
			int _alt;
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(T__19);
				 ((DFunctionOperationsContext)_localctx)._result =  new FunctionOperations.Compose(); 
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(T__20);
				 ((DFunctionOperationsContext)_localctx)._result =  new FunctionOperations.Apply(); 
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				match(T__21);
				 ((DFunctionOperationsContext)_localctx)._result =  new FunctionOperations.ApplyOver(); 
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 4);
				{
				setState(113); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(112);
						match(T__22);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(115); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(118); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(117);
					((DFunctionOperationsContext)_localctx).s = dSequence(0);
					}
					}
					setState(120); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 251658236L) != 0) );
				setState(122);
				match(T__23);
				 ((DFunctionOperationsContext)_localctx)._result =  new FunctionOperations.Quote(((DFunctionOperationsContext)_localctx).s._result); 
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
	public static class DConditionsOperationContext extends ParserRuleContext {
		public ConditionsOperation _result;
		public DConditionsOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dConditionsOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).enterDConditionsOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).exitDConditionsOperation(this);
		}
	}

	public final DConditionsOperationContext dConditionsOperation() throws RecognitionException {
		DConditionsOperationContext _localctx = new DConditionsOperationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dConditionsOperation);
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(T__24);
				 ((DConditionsOperationContext)_localctx)._result =  new ConditionsOperation.Choose(); 
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(T__25);
				 ((DConditionsOperationContext)_localctx)._result =  new ConditionsOperation.While(); 
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
	public static class DNUMContext extends ParserRuleContext {
		public String _result;
		public Token n;
		public TerminalNode NUM() { return getToken(KKJParser.NUM, 0); }
		public DNUMContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dNUM; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).enterDNUM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).exitDNUM(this);
		}
	}

	public final DNUMContext dNUM() throws RecognitionException {
		DNUMContext _localctx = new DNUMContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dNUM);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			((DNUMContext)_localctx).n = match(NUM);
			 ((DNUMContext)_localctx)._result =  (((DNUMContext)_localctx).n!=null?((DNUMContext)_localctx).n.getText():null); 
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
	public static class DIDContext extends ParserRuleContext {
		public String _result;
		public Token i;
		public TerminalNode ID() { return getToken(KKJParser.ID, 0); }
		public DIDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dID; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).enterDID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).exitDID(this);
		}
	}

	public final DIDContext dID() throws RecognitionException {
		DIDContext _localctx = new DIDContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dID);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			((DIDContext)_localctx).i = match(ID);
			 ((DIDContext)_localctx)._result =  (((DIDContext)_localctx).i!=null?((DIDContext)_localctx).i.getText():null); 
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
	public static class DSTRContext extends ParserRuleContext {
		public String _result;
		public Token s;
		public TerminalNode STR() { return getToken(KKJParser.STR, 0); }
		public DSTRContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dSTR; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).enterDSTR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KKJListener ) ((KKJListener)listener).exitDSTR(this);
		}
	}

	public final DSTRContext dSTR() throws RecognitionException {
		DSTRContext _localctx = new DSTRContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dSTR);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			((DSTRContext)_localctx).s = match(STR);
			 ((DSTRContext)_localctx)._result =  (((DSTRContext)_localctx).s!=null?((DSTRContext)_localctx).s.getText():null); 
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return dSequence_sempred((DSequenceContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean dSequence_sempred(DSequenceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001!\u008f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001.\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u00015\b\u0001\n\u0001"+
		"\f\u00018\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002E\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003O\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004Y\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005i\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006r\b\u0006\u000b"+
		"\u0006\f\u0006s\u0001\u0006\u0004\u0006w\b\u0006\u000b\u0006\f\u0006x"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006~\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0084\b\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0000\u0001\u0002\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012"+
		"\u0014\u0000\u0000\u009e\u0000\u0016\u0001\u0000\u0000\u0000\u0002-\u0001"+
		"\u0000\u0000\u0000\u0004D\u0001\u0000\u0000\u0000\u0006N\u0001\u0000\u0000"+
		"\u0000\bX\u0001\u0000\u0000\u0000\nh\u0001\u0000\u0000\u0000\f}\u0001"+
		"\u0000\u0000\u0000\u000e\u0083\u0001\u0000\u0000\u0000\u0010\u0085\u0001"+
		"\u0000\u0000\u0000\u0012\u0088\u0001\u0000\u0000\u0000\u0014\u008b\u0001"+
		"\u0000\u0000\u0000\u0016\u0017\u0003\u0002\u0001\u0000\u0017\u0018\u0005"+
		"\u0000\u0000\u0001\u0018\u0019\u0006\u0000\uffff\uffff\u0000\u0019\u0001"+
		"\u0001\u0000\u0000\u0000\u001a\u001b\u0006\u0001\uffff\uffff\u0000\u001b"+
		"\u001c\u0003\u0004\u0002\u0000\u001c\u001d\u0006\u0001\uffff\uffff\u0000"+
		"\u001d.\u0001\u0000\u0000\u0000\u001e\u001f\u0003\u0006\u0003\u0000\u001f"+
		" \u0006\u0001\uffff\uffff\u0000 .\u0001\u0000\u0000\u0000!\"\u0003\b\u0004"+
		"\u0000\"#\u0006\u0001\uffff\uffff\u0000#.\u0001\u0000\u0000\u0000$%\u0003"+
		"\n\u0005\u0000%&\u0006\u0001\uffff\uffff\u0000&.\u0001\u0000\u0000\u0000"+
		"\'(\u0003\f\u0006\u0000()\u0006\u0001\uffff\uffff\u0000).\u0001\u0000"+
		"\u0000\u0000*+\u0003\u000e\u0007\u0000+,\u0006\u0001\uffff\uffff\u0000"+
		",.\u0001\u0000\u0000\u0000-\u001a\u0001\u0000\u0000\u0000-\u001e\u0001"+
		"\u0000\u0000\u0000-!\u0001\u0000\u0000\u0000-$\u0001\u0000\u0000\u0000"+
		"-\'\u0001\u0000\u0000\u0000-*\u0001\u0000\u0000\u0000.6\u0001\u0000\u0000"+
		"\u0000/0\n\u0007\u0000\u000001\u0005\u0001\u0000\u000012\u0003\u0002\u0001"+
		"\b23\u0006\u0001\uffff\uffff\u000035\u0001\u0000\u0000\u00004/\u0001\u0000"+
		"\u0000\u000058\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001"+
		"\u0000\u0000\u00007\u0003\u0001\u0000\u0000\u000086\u0001\u0000\u0000"+
		"\u00009:\u0003\u0010\b\u0000:;\u0006\u0002\uffff\uffff\u0000;E\u0001\u0000"+
		"\u0000\u0000<=\u0005\u0002\u0000\u0000=>\u0003\u0010\b\u0000>?\u0006\u0002"+
		"\uffff\uffff\u0000?E\u0001\u0000\u0000\u0000@A\u0005\u0003\u0000\u0000"+
		"AE\u0006\u0002\uffff\uffff\u0000BC\u0005\u0004\u0000\u0000CE\u0006\u0002"+
		"\uffff\uffff\u0000D9\u0001\u0000\u0000\u0000D<\u0001\u0000\u0000\u0000"+
		"D@\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000E\u0005\u0001\u0000"+
		"\u0000\u0000FG\u0005\u0005\u0000\u0000GO\u0006\u0003\uffff\uffff\u0000"+
		"HI\u0005\u0006\u0000\u0000IO\u0006\u0003\uffff\uffff\u0000JK\u0005\u0007"+
		"\u0000\u0000KO\u0006\u0003\uffff\uffff\u0000LM\u0005\b\u0000\u0000MO\u0006"+
		"\u0003\uffff\uffff\u0000NF\u0001\u0000\u0000\u0000NH\u0001\u0000\u0000"+
		"\u0000NJ\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000O\u0007\u0001"+
		"\u0000\u0000\u0000PQ\u0005\t\u0000\u0000QY\u0006\u0004\uffff\uffff\u0000"+
		"RS\u0005\n\u0000\u0000SY\u0006\u0004\uffff\uffff\u0000TU\u0005\u000b\u0000"+
		"\u0000UY\u0006\u0004\uffff\uffff\u0000VW\u0005\f\u0000\u0000WY\u0006\u0004"+
		"\uffff\uffff\u0000XP\u0001\u0000\u0000\u0000XR\u0001\u0000\u0000\u0000"+
		"XT\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000Y\t\u0001\u0000\u0000"+
		"\u0000Z[\u0005\r\u0000\u0000[i\u0006\u0005\uffff\uffff\u0000\\]\u0005"+
		"\u000e\u0000\u0000]i\u0006\u0005\uffff\uffff\u0000^_\u0005\u000f\u0000"+
		"\u0000_i\u0006\u0005\uffff\uffff\u0000`a\u0005\u0010\u0000\u0000ai\u0006"+
		"\u0005\uffff\uffff\u0000bc\u0005\u0011\u0000\u0000ci\u0006\u0005\uffff"+
		"\uffff\u0000de\u0005\u0012\u0000\u0000ei\u0006\u0005\uffff\uffff\u0000"+
		"fg\u0005\u0013\u0000\u0000gi\u0006\u0005\uffff\uffff\u0000hZ\u0001\u0000"+
		"\u0000\u0000h\\\u0001\u0000\u0000\u0000h^\u0001\u0000\u0000\u0000h`\u0001"+
		"\u0000\u0000\u0000hb\u0001\u0000\u0000\u0000hd\u0001\u0000\u0000\u0000"+
		"hf\u0001\u0000\u0000\u0000i\u000b\u0001\u0000\u0000\u0000jk\u0005\u0014"+
		"\u0000\u0000k~\u0006\u0006\uffff\uffff\u0000lm\u0005\u0015\u0000\u0000"+
		"m~\u0006\u0006\uffff\uffff\u0000no\u0005\u0016\u0000\u0000o~\u0006\u0006"+
		"\uffff\uffff\u0000pr\u0005\u0017\u0000\u0000qp\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000tv\u0001\u0000\u0000\u0000uw\u0003\u0002\u0001\u0000vu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0005\u0018\u0000\u0000"+
		"{|\u0006\u0006\uffff\uffff\u0000|~\u0001\u0000\u0000\u0000}j\u0001\u0000"+
		"\u0000\u0000}l\u0001\u0000\u0000\u0000}n\u0001\u0000\u0000\u0000}q\u0001"+
		"\u0000\u0000\u0000~\r\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0019"+
		"\u0000\u0000\u0080\u0084\u0006\u0007\uffff\uffff\u0000\u0081\u0082\u0005"+
		"\u001a\u0000\u0000\u0082\u0084\u0006\u0007\uffff\uffff\u0000\u0083\u007f"+
		"\u0001\u0000\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u000f"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u001b\u0000\u0000\u0086\u0087"+
		"\u0006\b\uffff\uffff\u0000\u0087\u0011\u0001\u0000\u0000\u0000\u0088\u0089"+
		"\u0005\u001c\u0000\u0000\u0089\u008a\u0006\t\uffff\uffff\u0000\u008a\u0013"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u001d\u0000\u0000\u008c\u008d"+
		"\u0006\n\uffff\uffff\u0000\u008d\u0015\u0001\u0000\u0000\u0000\n-6DNX"+
		"hsx}\u0083";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}