package by.zastr.composite.parser.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.Letter;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.parser.CompositeParser;

public class LetterParser implements CompositeParser{
    private static Logger logger = LogManager.getLogger();

	@Override
	public TextComponent parse(String word) throws CompositeException {
		if( word == null || word.isEmpty()) {
			logger.log(Level.ERROR, "word is null or empty");
        	throw new CompositeException("word is null or empty");
        }
		TextComposite letter = new TextComposite(ComponentType.WORD);
		for (int i=0; i<word.length();i++) {
			if(Character.isLetter(word.charAt(i))) {
				letter.add(new Letter(word.charAt(i)));
			}
		}
		return letter;
	}

}
