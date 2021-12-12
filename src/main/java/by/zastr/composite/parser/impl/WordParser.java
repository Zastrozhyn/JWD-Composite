package by.zastr.composite.parser.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.parser.CompositeParser;

public class WordParser implements CompositeParser{
	private static final String WORD_DELIMETER_REGEX = "\\b";
	private CompositeParser parser = new SymbolParser();
    private static Logger logger = LogManager.getLogger();

	@Override
	public TextComponent parse(String lexeme) throws CompositeException {
		if(lexeme == null || lexeme.isEmpty()) {
			logger.log(Level.ERROR, "lexeme is null or empty");
        	throw new CompositeException("lexeme is null or empty");
        }
		String[] lexemeArray = lexeme.split(WORD_DELIMETER_REGEX);
		TextComposite sentenceComposit = new TextComposite(ComponentType.LEXEME);
		for (int i = 0; i < lexemeArray.length;i++) {
			if(!lexemeArray [i].isBlank()) {
				TextComponent symbolComposit = new TextComposite(ComponentType.WORD);
			    symbolComposit = parser.parse(lexemeArray[i]);
			    sentenceComposit.add(symbolComposit);
			}
		}
		return sentenceComposit;
	}

}
