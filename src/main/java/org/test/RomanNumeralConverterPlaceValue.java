package org.test;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * An implementation that converts each decimal digit to a roman numeral.
 */
public class RomanNumeralConverterPlaceValue implements RomanNumeralConverter {

    private static final List<RomanNumeralLookup> ROMAN_NUMERAL_LOOKUPS = ImmutableList.of(RomanNumeralLookup.THOUSANDS, RomanNumeralLookup.HUNDREDS, RomanNumeralLookup.TENS, RomanNumeralLookup.ONES);

    private enum RomanNumeralLookup {
        ONES(1, new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}),
        TENS(10, new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}),
        HUNDREDS(100, new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}),
        THOUSANDS(1000, new String[] {"", "M", "MM", "MMM", "MMMM", "", "", "", "", ""});

        private int placeValue;
        private String[] numerals;

        RomanNumeralLookup(int placeValue, String[] numerals) {
            this.placeValue = placeValue;
            this.numerals = numerals;
        }

        public int getPlaceValue() {
            return placeValue;
        }

        public String[] getNumerals() {
            return numerals;
        }
    }

    @Override
    public String convert(int number) {
        if (number > 4999) {
            throw new IllegalArgumentException("number cannot be greater than 4999");
        }
        if (number < 0) {
            throw new IllegalArgumentException("number cannot be less than 0");
        }
        return convertNoBoundsCheck(number);
    }

    @Override
    public String convertNoBoundsCheck(int number) {
        final StringBuilder builder = new StringBuilder();
        for (RomanNumeralLookup romanNumeralLookup : ROMAN_NUMERAL_LOOKUPS) {
            final int digit = getDigitAtPlaceValue(number, romanNumeralLookup);
            if (digit == 0) {
                continue;
            }
            builder.append(romanNumeralLookup.getNumerals()[digit]);
        }
        return builder.toString();
    }

    private int getDigitAtPlaceValue(int number, RomanNumeralLookup romanNumeralLookup) {
        return (number / romanNumeralLookup.getPlaceValue()) % 10;
    }
}
