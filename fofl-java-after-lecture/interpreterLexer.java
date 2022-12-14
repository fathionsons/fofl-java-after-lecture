// Generated from interpreter.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class interpreterLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, NUM=13, ID=14, WHITESPACE=15, COMMENT=16, 
		LONGCOMMENT=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "NUM", "ID", "WHITESPACE", "COMMENT", "LONGCOMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'='", "'int'", "'bool'", "','", "'*'", "'+'", "'=='", 
			"'if'", "'then'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "NUM", "ID", "WHITESPACE", "COMMENT", "LONGCOMMENT"
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


	public interpreterLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "interpreter.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0011{\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0003\fJ\b\f\u0001\f\u0004\fM\b\f\u000b\f\f\fN\u0001"+
		"\r\u0004\rR\b\r\u000b\r\f\rS\u0001\u000e\u0004\u000eW\b\u000e\u000b\u000e"+
		"\f\u000eX\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0005\u000fa\b\u000f\n\u000f\f\u000fd\t\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0004\u0010"+
		"l\b\u0010\u000b\u0010\f\u0010m\u0001\u0010\u0001\u0010\u0005\u0010r\b"+
		"\u0010\n\u0010\f\u0010u\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0000\u0000\u0011\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011\u0001"+
		"\u0000\u0005\u0003\u0000AZ__az\u0003\u0000\t\n\r\r  \u0001\u0000\n\n\u0001"+
		"\u0000**\u0001\u0000//\u0082\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001"+
		"\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001"+
		"\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0001#\u0001\u0000\u0000"+
		"\u0000\u0003%\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000"+
		"\u0007)\u0001\u0000\u0000\u0000\t-\u0001\u0000\u0000\u0000\u000b2\u0001"+
		"\u0000\u0000\u0000\r4\u0001\u0000\u0000\u0000\u000f6\u0001\u0000\u0000"+
		"\u0000\u00118\u0001\u0000\u0000\u0000\u0013;\u0001\u0000\u0000\u0000\u0015"+
		">\u0001\u0000\u0000\u0000\u0017C\u0001\u0000\u0000\u0000\u0019I\u0001"+
		"\u0000\u0000\u0000\u001bQ\u0001\u0000\u0000\u0000\u001dV\u0001\u0000\u0000"+
		"\u0000\u001f\\\u0001\u0000\u0000\u0000!g\u0001\u0000\u0000\u0000#$\u0005"+
		"(\u0000\u0000$\u0002\u0001\u0000\u0000\u0000%&\u0005)\u0000\u0000&\u0004"+
		"\u0001\u0000\u0000\u0000\'(\u0005=\u0000\u0000(\u0006\u0001\u0000\u0000"+
		"\u0000)*\u0005i\u0000\u0000*+\u0005n\u0000\u0000+,\u0005t\u0000\u0000"+
		",\b\u0001\u0000\u0000\u0000-.\u0005b\u0000\u0000./\u0005o\u0000\u0000"+
		"/0\u0005o\u0000\u000001\u0005l\u0000\u00001\n\u0001\u0000\u0000\u0000"+
		"23\u0005,\u0000\u00003\f\u0001\u0000\u0000\u000045\u0005*\u0000\u0000"+
		"5\u000e\u0001\u0000\u0000\u000067\u0005+\u0000\u00007\u0010\u0001\u0000"+
		"\u0000\u000089\u0005=\u0000\u00009:\u0005=\u0000\u0000:\u0012\u0001\u0000"+
		"\u0000\u0000;<\u0005i\u0000\u0000<=\u0005f\u0000\u0000=\u0014\u0001\u0000"+
		"\u0000\u0000>?\u0005t\u0000\u0000?@\u0005h\u0000\u0000@A\u0005e\u0000"+
		"\u0000AB\u0005n\u0000\u0000B\u0016\u0001\u0000\u0000\u0000CD\u0005e\u0000"+
		"\u0000DE\u0005l\u0000\u0000EF\u0005s\u0000\u0000FG\u0005e\u0000\u0000"+
		"G\u0018\u0001\u0000\u0000\u0000HJ\u0005-\u0000\u0000IH\u0001\u0000\u0000"+
		"\u0000IJ\u0001\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KM\u000209\u0000"+
		"LK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000"+
		"\u0000NO\u0001\u0000\u0000\u0000O\u001a\u0001\u0000\u0000\u0000PR\u0007"+
		"\u0000\u0000\u0000QP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000"+
		"SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T\u001c\u0001\u0000"+
		"\u0000\u0000UW\u0007\u0001\u0000\u0000VU\u0001\u0000\u0000\u0000WX\u0001"+
		"\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z[\u0006\u000e\u0000\u0000[\u001e\u0001\u0000"+
		"\u0000\u0000\\]\u0005/\u0000\u0000]^\u0005/\u0000\u0000^b\u0001\u0000"+
		"\u0000\u0000_a\b\u0002\u0000\u0000`_\u0001\u0000\u0000\u0000ad\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000ce\u0001"+
		"\u0000\u0000\u0000db\u0001\u0000\u0000\u0000ef\u0006\u000f\u0000\u0000"+
		"f \u0001\u0000\u0000\u0000gh\u0005/\u0000\u0000hi\u0005*\u0000\u0000i"+
		"s\u0001\u0000\u0000\u0000jl\b\u0003\u0000\u0000kj\u0001\u0000\u0000\u0000"+
		"lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000"+
		"\u0000nr\u0001\u0000\u0000\u0000op\u0005*\u0000\u0000pr\b\u0004\u0000"+
		"\u0000qk\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000ru\u0001\u0000"+
		"\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001"+
		"\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0005*\u0000\u0000wx\u0005"+
		"/\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0006\u0010\u0000\u0000z\"\u0001"+
		"\u0000\u0000\u0000\t\u0000INSXbmqs\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}