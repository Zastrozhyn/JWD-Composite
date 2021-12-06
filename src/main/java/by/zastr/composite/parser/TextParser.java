package by.zastr.composite.parser;

import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.exception.CompositeException;

public interface TextParser {

	TextComponent parse(String text) throws CompositeException;

}