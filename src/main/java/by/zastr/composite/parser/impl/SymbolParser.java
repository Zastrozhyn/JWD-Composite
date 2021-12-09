package by.zastr.composite.parser.impl;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.Letter;
import by.zastr.composite.entity.Symbol;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.parser.CompositeParser;

public class SymbolParser implements CompositeParser{

	@Override
	public TextComponent parse(String lexeme) throws CompositeException {
		if(lexeme.isEmpty() || lexeme == null) {
        	throw new CompositeException("lexeme is null or empty");
        }
		TextComposite symbol = new TextComposite(ComponentType.LEXEME);
		for (int i=0; i<lexeme.length();i++) {
			if(Character.isLetter(lexeme.charAt(i))) {
				symbol.add(new Letter(lexeme.charAt(i)));
			}
			else {
				symbol.add(new Symbol(lexeme.charAt(i)));
			}
		}
		return symbol;
	}
}
