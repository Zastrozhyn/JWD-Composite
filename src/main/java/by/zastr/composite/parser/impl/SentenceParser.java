package by.zastr.composite.parser.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.parser.CompositeParser;

public class SentenceParser implements CompositeParser{
	private static final String SENTENCE_DELIMETER_REGEX = "(?<=\\!|\\.|\\?)\s+|\n";
	private CompositeParser parser = new LexemeParser();
    private static Logger logger = LogManager.getLogger();

	@Override
	public TextComponent parse(String paragraph) throws CompositeException {
		if(paragraph == null || paragraph.isEmpty()) {
			logger.log(Level.ERROR, "Paragraph is null or empty");
        	throw new CompositeException("Paragraph is null or empty");
        }
		String[] sentenceArray = paragraph.split(SENTENCE_DELIMETER_REGEX);
		TextComposite sentenceComposit = new TextComposite(ComponentType.PARAGRAPH);
		for (int i = 0; i < sentenceArray .length;i++) {
			if(!sentenceArray [i].isBlank()) {
				TextComponent lexemeComposit = new TextComposite(ComponentType.SENTENCE);
			    lexemeComposit = parser.parse(sentenceArray[i]);
			    sentenceComposit.add(lexemeComposit);
			}
		}
		return sentenceComposit;
	}

}
