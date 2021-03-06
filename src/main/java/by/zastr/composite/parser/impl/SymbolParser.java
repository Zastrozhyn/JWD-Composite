package by.zastr.composite.parser.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.Letter;
import by.zastr.composite.entity.Symbol;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.parser.CompositeParser;

public class SymbolParser implements CompositeParser{
	private static final String WORD_MATHES_REGEX = "\\w+|[?-??-?]+";
    private static Logger logger = LogManager.getLogger();

	@Override
	public TextComponent parse(String lexeme) throws CompositeException {
		if(lexeme == null || lexeme.isEmpty()) {
			logger.log(Level.ERROR, "lexeme is null or empty");
        	throw new CompositeException("lexeme is null or empty");
        }
		TextComposite symbol = new TextComposite(ComponentType.SYMBOL);
		if (lexeme.matches(WORD_MATHES_REGEX)) {
			symbol = new TextComposite(ComponentType.WORD);
		}
		for (int i=0; i<lexeme.length();i++) {
			if(!Character.isLetter(lexeme.charAt(i))) {
				symbol.add(new Symbol(lexeme.charAt(i)));
			}
			if(Character.isLetter(lexeme.charAt(i))) {
				symbol.add(new Letter(lexeme.charAt(i)));
			}
		}
		return symbol;
	}
}
