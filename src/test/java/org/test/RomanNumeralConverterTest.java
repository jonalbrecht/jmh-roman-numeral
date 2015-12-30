package org.test;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jalbrecht on 23/12/15.
 */
public class RomanNumeralConverterTest {

    private RomanNumeralConverter romanNumeralConverter;

    @Before
    public void SetUp() {
        romanNumeralConverter = new RomanNumeralConverterJava8Streams();
    }

    @Test
    public void testNegativeNumberThrows() throws Exception {
        try {
            final String romanNumeral = romanNumeralConverter.convert(-1);
            fail("should throw for negative number");
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("wrong exception type thrown");
    }

    @Test
    public void testNumberGreaterThan4999Throws() throws Exception {
        try {
            final String romanNumeral = romanNumeralConverter.convert(5000);
            fail("should throw for number greater than 4999");
        } catch (IllegalArgumentException e) {
            return;
        }
        fail("wrong exception type thrown");
    }

    @Test
    public void test0IsEmpty() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(0);
        assertEquals("0", "", romanNumeral);
    }

    @Test
    public void test1IsI() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(1);
        assertEquals("1", "I", romanNumeral);
    }

    @Test
    public void test2IsII() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(2);
        assertEquals("2", "II", romanNumeral);
    }

    @Test
    public void test3IsIII() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(3);
        assertEquals("3", "III", romanNumeral);
    }

    @Test
    public void test4IsIV() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(4);
        assertEquals("4", "IV", romanNumeral);
    }

    @Test
    public void test5IsV() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(5);
        assertEquals("5", "V", romanNumeral);
    }

    @Test
    public void test6IsVI() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(6);
        assertEquals("6", "VI", romanNumeral);
    }

    @Test
    public void test9IsIX() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(9);
        assertEquals("9", "IX", romanNumeral);
    }

    @Test
    public void test10IsX() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(10);
        assertEquals("X", "X", romanNumeral);
    }

    @Test
    public void test11IsXI() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(11);
        assertEquals("XI", "XI", romanNumeral);
    }

    @Test
    public void test12IsXII() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(12);
        assertEquals("XII", "XII", romanNumeral);
    }

    @Test
    public void test13IsXIII() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(13);
        assertEquals("XIII", "XIII", romanNumeral);
    }

    @Test
    public void test14IsXIV() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(14);
        assertEquals("XIV", "XIV", romanNumeral);
    }

    @Test
    public void test15IsXV() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(15);
        assertEquals("XV", "XV", romanNumeral);
    }

    @Test
    public void test16IsXVI() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(16);
        assertEquals("XVI", "XVI", romanNumeral);
    }

    @Test
    public void test19IsXIX() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(19);
        assertEquals("XIX", "XIX", romanNumeral);
    }

    @Test
    public void test20IsXX() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(20);
        assertEquals("XX", "XX", romanNumeral);
    }

    @Test
    public void test21IsXXI() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(21);
        assertEquals("XXI", "XXI", romanNumeral);
    }

    @Test
    public void test39IsXXXIX() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(39);
        assertEquals("XXXIX", "XXXIX", romanNumeral);
    }

    @Test
    public void test40IsXL() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(40);
        assertEquals("XL", "XL", romanNumeral);
    }

    @Test
    public void test41IsXLI() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(41);
        assertEquals("XLI", "XLI", romanNumeral);
    }

    @Test
    public void test99IsXCIX() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(99);
        assertEquals("XCIX", "XCIX", romanNumeral);
    }

    @Test
    public void test100IsC() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(100);
        assertEquals("C", "C", romanNumeral);
    }

    @Test
    public void test909IsCMIX() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(909);
        assertEquals("CMIX", "CMIX", romanNumeral);
    }

    @Test
    public void test3999IsMMMCMXCIX() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(3999);
        assertEquals("MMMCMXCIX", "MMMCMXCIX", romanNumeral);
    }

    @Test
    public void test4888IsMMMMMCCCLXXXVIII() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(4888);
        assertEquals("MMMMDCCCLXXXVIII", "MMMMDCCCLXXXVIII", romanNumeral);
    }

    @Test
    public void test4999IsMMMMCMXCIX() throws Exception {
        final String romanNumeral = romanNumeralConverter.convert(4999);
        assertEquals("MMMMCMXCIX", "MMMMCMXCIX", romanNumeral);
    }
}