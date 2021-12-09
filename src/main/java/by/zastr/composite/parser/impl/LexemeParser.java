package by.zastr.composite.parser.impl;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.parser.CompositeParser;

public class LexemeParser implements CompositeParser{
	private static final String SENTENCE_DELIMETER_REGIX = " ";
//	private static final String SENTENCE_DELIMETER_REGIX = "\s";	
	private CompositeParser parser = new SymbolParser();

	@Override
	public TextComponent parse(String sentence) throws CompositeException {
		if(sentence.isEmpty() || sentence == null) {
        	throw new CompositeException("Sentence is null or empty");
        }
		String[] lexemeArray = sentence.split(SENTENCE_DELIMETER_REGIX);
		TextComposite sentenceComposit = new TextComposite(ComponentType.SENTENCE);
		for (int i = 0; i < lexemeArray.length;i++) {
			if(!lexemeArray [i].isBlank()) {
				TextComponent symbolComposit = new TextComposite(ComponentType.LEXEME);
			    symbolComposit = parser.parse(lexemeArray[i]);
			    sentenceComposit.add(symbolComposit);
			}
		}
		return sentenceComposit;
	}
}
