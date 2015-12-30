package org.test;

/**
 * An optimized version of a roman numeral converter. Unrolls the loop, and uses literals
 * in division and mod operators.
 */
public class RomanNumeralConverterPlaceValueOptimized implements RomanNumeralConverter {

    private enum RomanNumeralLookup {
        ONES(new String[] {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}),
        TENS(new String[] {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}),
        HUNDREDS(new String[] {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}),
        THOUSANDS(new String[] {"", "M", "MM", "MMM", "MMMM", "", "", "", "", ""});

        private String[] numerals;

        RomanNumeralLookup(String[] numerals) {
            this.numerals = numerals;
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
        builder.append(RomanNumeralLookup.THOUSANDS.getNumerals()[(number / 1000) % 10]);
        builder.append(RomanNumeralLookup.HUNDREDS.getNumerals()[(number / 100) % 10]);
        builder.append(RomanNumeralLookup.TENS.getNumerals()[(number / 10) % 10]);
        builder.append(RomanNumeralLookup.ONES.getNumerals()[number % 10]);
        return builder.toString();
    }
}
