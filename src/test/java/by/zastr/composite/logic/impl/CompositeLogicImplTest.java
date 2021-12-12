package by.zastr.composite.logic.impl;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import by.zastr.composite.exception.CompositeException;

public class CompositeLogicImplTest {
  CompositeLogicImpl logic = new CompositeLogicImpl();
  String text = "    It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига)with the release of Letraset sheets.toString() containing Lorem Ipsum passages, andmore recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum! \n"
  		+ "    It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here),content here's, making it look like readable English? \n"
  		+ "    It is a established fact that a reader will be of a page when looking at its layout... \n"
  		+ "    Bye бандерлоги. ";

  @Test(expectedExceptions = CompositeException.class)
  public void deleteSentenceNullTest() throws CompositeException {
    logic.deleteSentence(1, null);
  }

  @Test
  public void findLongWordTest() throws CompositeException {
    String expected = "distribution";
    String actual = logic.findLongWord(text).toString();
    assertEquals(actual, expected);
  }

  @Test
  public void numberOfVowelTest() throws CompositeException {
    int expected = 250;
    int actual = logic.numberOfVowel(text);
    assertEquals(actual, expected);
  }
}
