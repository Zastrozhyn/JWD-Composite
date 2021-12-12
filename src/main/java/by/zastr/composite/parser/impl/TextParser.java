package by.zastr.composite.parser.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.parser.CompositeParser;


public class TextParser implements CompositeParser{
	private static final String TEXT_DELIMETER_REGEX = "\n{2,}";
	private CompositeParser parser = new ParagraphParser();
    private static Logger logger = LogManager.getLogger();

	@Override
	public TextComponent parse(String document) throws CompositeException {
		if(document == null || document.isBlank()) {
			logger.log(Level.ERROR, "Document is null or empty");
        	throw new CompositeException("Document is null or empty");
        }
		String[] textArray = document.split(TEXT_DELIMETER_REGEX);
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


	