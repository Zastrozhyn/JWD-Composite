package by.zastr.composite.parser.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.parser.CompositeParser;

public class LexemeParser implements CompositeParser{
	private static final String LEXEME_DELIMETER_REGEX = "\s+";	
	private CompositeParser parser = new WordParser();
    private static Logger logger = LogManager.getLogger();

	@Override
	public TextComponent parse(String sentence) throws CompositeException {
		if(sentence == null || sentence.isEmpty()) {
			logger.log(Level.ERROR, "Sentence is null or empty");
        	throw new CompositeException("Sentence is null or empty");
        }
		String[] lexemeArray = sentence.split(LEXEME_DELIMETER_REGEX);
		TextComposite sentenceComposit = new TextComposite(ComponentType.SENTENCE);
		for (int i = 0; i < lexemeArray.length;i++) {
			if(!lexemeArray [i].isBlank()) {
				TextComponent wordComposit = new TextComposite(ComponentType.LEXEME);
			    wordComposit = parser.parse(lexemeArray[i]);
			    sentenceComposit.add(wordComposit);
			}
		}
		return sentenceComposit;
	}
}
