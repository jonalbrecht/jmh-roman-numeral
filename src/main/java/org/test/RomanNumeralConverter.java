package org.test;

/**
 * Created by jalbrecht on 26/12/15.
 */
public interface RomanNumeralConverter {
    String convert(int number);

    String convertNoBoundsCheck(int number);
}
