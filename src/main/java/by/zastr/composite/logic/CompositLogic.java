package by.zastr.composite.logic;

import java.util.Map;

import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.entity.TextComposite;
import by.zastr.composite.exception.CompositeException;

public interface CompositLogic {

	TextComposite sortParagraph(String text) throws CompositeException;

	TextComponent findLongWord(String text) throws CompositeException;

	TextComponent deleteSentence(int countWord, String text) throws CompositeException;

	Map<String, Integer> countSameWord(String text) throws CompositeException;

	int numberOfVowel(String sentence) throws CompositeException;

}