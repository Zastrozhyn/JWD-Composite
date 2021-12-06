package by.zastr.composite.parser.impl;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.parser.TextParser;


public class TextParserImpl implements TextParser{
	private static final String DELIMETER_REGIX="\t|\s{2,4}";
	private TextParser parser= new ParagraphParser();

	@Override
	public TextComponent parse(String text) throws CompositeException {
		String[] paragraph = text.split(DELIMETER_REGIX);
		TextComposite paragraphComposit = new TextComposite(ComponentType.PARAGRAPH);
		for (int i=0; i< paragraph.length;i++) {
			if(!paragraph[i].isBlank()) {
				TextComponent sentenceComposit = new TextComposite(ComponentType.SENTENCE);
			    sentenceComposit=parser.parse(paragraph[i]);
			    paragraphComposit.add(sentenceComposit);
			}
		}
		return paragraphComposit;
	} 

}


	