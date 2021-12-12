package by.zastr.composite.logic.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.zastr.composite.entity.ComponentType;
import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;
import by.zastr.composite.logic.CompositLogic;
import by.zastr.composite.parser.impl.LexemeParser;
import by.zastr.composite.parser.impl.ParagraphParser;
import by.zastr.composite.parser.impl.SentenceParser;
import by.zastr.composite.parser.impl.SymbolParser;
import by.zastr.composite.parser.impl.WordParser;

public class CompositeLogicImpl implements CompositLogic {
	private static String VOWEL_REG = "[AEIOUYaeiouy¿≈®Œ”€›ﬁﬂ‡ËÂ∏ÓÛ˚˝˛ˇ]";
	
	@Override
	public TextComposite sortParagraph (String text) throws CompositeException {
		ParagraphParser parser = new ParagraphParser();
		TextComponent composite = parser.parse(text);
		TextComposite sortedComposite = new TextComposite(ComponentType.TEXT);
		List<TextComponent> componentList = composite.getAllComponent();
		componentList.sort(Comparator.comparingInt(c -> c.getAllComponent().size()));
		for (TextComponent component : componentList) {
			sortedComposite.add(component);
		}
		return sortedComposite;
	}
	
	@Override
	public TextComponent findLongWord(String text) throws CompositeException {
		TextComponent sentence = new TextComposite(ComponentType.SENTENCE);
		SentenceParser parser = new SentenceParser();
		WordParser wordParser = new WordParser();
		int maxLenght = 0;		
		TextComponent compositeText = parser.parse(text);
		
		for (int i = 0; i < compositeText.getAllComponent().size(); i++) {
			TextComponent compositeSentence = wordParser.parse(compositeText.getAllComponent().get(i).toString());
			for (int q = 0; q < compositeSentence.getAllComponent().size(); q++) {
				int wordLenght = compositeSentence.getComponent(q).getAllComponent().size();
				if (wordLenght > maxLenght) {
					sentence = compositeSentence.getComponent(q);
					maxLenght = wordLenght;
				}
			}
		}
		return sentence;
	}
	
	@Override
	public TextComponent deleteSentence(int countWord, String text) throws CompositeException {
		TextComponent composite = new TextComposite(ComponentType.TEXT);
		SentenceParser parser = new SentenceParser();
		composite = parser.parse(text);
		for (int i = 0; i < composite.getAllComponent().size(); i++) {
			if (countWordInSentence(composite.getComponent(i).toString()) < countWord) {
				composite.remove(composite.getComponent(i));
			}
		}
		return composite;
	}
	
	@Override
	public Map<String, Integer> countSameWord (String text) throws CompositeException{
		Map<String, Integer> wordMap = new HashMap<>();
		WordParser wordParser = new WordParser();
		TextComponent compositeText = wordParser.parse(text);
		int i = 0;
		while (i < compositeText.getAllComponent().size() - 1){
			int q = i+1;
			int count = 1;
			String word = compositeText.getComponent(i).toString().toLowerCase();
			while (q < compositeText.getAllComponent().size()) {
				String currentWord = compositeText.getComponent(q).toString().toLowerCase();
				if (word.equals(currentWord)&&compositeText.getComponent(q).getComponentType().equals(ComponentType.WORD)) {
					count++;
					compositeText.getAllComponent().remove(q);
					q--;
				}
				q++;
			}
			if (count > 1) {
				wordMap.put(word, count);
			}
			i++;
		}
		return wordMap;		
	}
	
	@Override
	public int numberOfVowel(String sentence) throws CompositeException {
		SymbolParser parser = new SymbolParser();
		TextComponent component = parser.parse(sentence);
		int count = 0;
		for (int i = 0; i < component.getAllComponent().size(); i++) {
			if (component.getComponent(i).toString().matches(VOWEL_REG)) {
				count++;
			}
		}
		return count;
	}
	
	private int countWordInSentence(String sentence) throws CompositeException {
		LexemeParser lexemeParser = new LexemeParser();
		TextComponent composite = lexemeParser.parse(sentence);
		return composite.getAllComponent().size();
	}
}
