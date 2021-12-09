package by.zastr.composite.parser;

import by.zastr.composite.entity.TextComponent;
import by.zastr.composite.exception.CompositeException;

public interface CompositeParser {

	TextComponent parse(String text) throws CompositeException;

}