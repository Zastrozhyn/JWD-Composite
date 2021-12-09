package by.zastr.composite.parser.impl;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.parser.CompositeParser;

public class ParagraphParser implements CompositeParser{
	private static final String PARAGRAPH_DELIMETER_REGIX = "\s{2,}|\t";
	private CompositeParser parser = new SentenceParser();

	@Override
	public TextComponent parse(String text) throws CompositeException {
		if(text.isEmpty() || text == null) {
        	throw new CompositeException("Text is null or empty");
        }
		String[] paragraphArray = text.split(PARAGRAPH_DELIMETER_REGIX);
		TextComposite paragraphComposit = new TextComposite(ComponentType.TEXT);
		for (int i = 0; i < paragraphArray.length;i++) {
			if(!paragraphArray[i].isBlank()) {
				TextComponent sentenceComposit = new TextComposite(ComponentType.PARAGRAPH);
			    sentenceComposit = parser.parse(paragraphArray[i]);
			    paragraphComposit.add(sentenceComposit);
			}
		}
		return paragraphComposit;
	}

}
