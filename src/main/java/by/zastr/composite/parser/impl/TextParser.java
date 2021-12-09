package by.zastr.composite.parser.impl;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.parser.CompositeParser;


public class TextParser implements CompositeParser{
	private static final String TEXT_DELIMETER_REGIX = "\n{2,}";
	private CompositeParser parser = new ParagraphParser();

	@Override
	public TextComponent parse(String document) throws CompositeException {
		if(document.isBlank() || document == null) {
        	throw new CompositeException("Text is null or empty");
        }
		String[] textArray = document.split(TEXT_DELIMETER_REGIX);
		TextComposite textComposit = new TextComposite(ComponentType.DOCUMENT);
		for (int i = 0; i < textArray.length; i++) {
			if(!textArray[i].isBlank()) {
				TextComponent paragraphComposit = new TextComposite(ComponentType.TEXT);
			    paragraphComposit = parser.parse(textArray[i]);
			    textComposit.add(paragraphComposit);
			}
		}
		return textComposit;
	} 

}


	