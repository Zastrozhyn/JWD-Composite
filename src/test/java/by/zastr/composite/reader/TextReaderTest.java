package by.zastr.composite.reader;

import org.testng.annotations.Test;

import by.zastr.composite.exception.CompositeException;

public class TextReaderTest {

  @Test(expectedExceptions = CompositeException.class)
  public void readTextTest() throws CompositeException {
    TextReader reader = new TextReader();
    reader.readText(null);
  }
}
