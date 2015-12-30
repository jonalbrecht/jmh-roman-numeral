package org.test;

import com.google.common.collect.ImmutableMap;

import java.util.*;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * A java implementation of the c# solution from:
 *
 * http://geekswithblogs.net/theArchitectsNapkin/archive/2014/05/28/informed-tdd-ndash-kata-ldquoto-roman-numeralsrdquo.aspx
 */
public class RomanNumeralConverterJava8Streams implements RomanNumeralConverter {

    private enum RomanNumeralFactors {
        ONE(1, "I"),
        FOUR(4, "IV"),
        FIVE(5, "V"),
        NINE(9, "IX"),
        TEN(10, "X"),
        FORTY(40, "XL"),
        FIFTY(50, "L"),
        NINETY(90, "XC"),
        ONE_HUNDRED(100, "C"),
        FOUR_HUNDRED(400, "CD"),
        FIVE_HUNDRED(500, "D"),
        NINE_HUNDRED(900, "CM"),
        ONE_THOUSAND(1000, "M");

        private int factor;
        private String numeral;

        public static final Comparator<RomanNumeralFactors> DESCENDING_COMPARATOR = new Comparator<RomanNumeralFactors>() {
            // Overriding the compare method to sort the age
            public int compare(RomanNumeralFactors first, RomanNumeralFactors second) {
                return second.factor - first.factor;
            }
        };

        RomanNumeralFactors(int factor, String numeral) {
            this.factor = factor;
            this.numeral = numeral;
        }
    }

    private static Map<Integer, String> FACTOR_TO_NUMERAL_MAP;
    static {
        final ImmutableMap.Builder<Integer, String> builder = ImmutableMap.builder();
        for (RomanNumeralFactors factor: RomanNumeralFactors.values()) {
            builder.put(factor.factor, factor.numeral);
        }
        FACTOR_TO_NUMERAL_MAP = builder.build();
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
        return StreamSupport.intStream(new FactorSpliterator(number), false)
                .boxed()
                .map(i -> FACTOR_TO_NUMERAL_MAP.get(i))
                .collect(Collectors.joining());
    }

    private static class FactorSpliterator extends Spliterators.AbstractIntSpliterator {

        private static int[] FACTORS;

        static {
            FACTORS = Arrays.stream(RomanNumeralFactors.values())
                    .sorted(RomanNumeralFactors.DESCENDING_COMPARATOR)
                    .mapToInt(f -> f.factor)
                    .toArray();
        }

        private int number;

        private FactorSpliterator(int number) {
            super(FACTORS.length, 0);
            this.number = number;
        }

        @Override
        public boolean tryAdvance(IntConsumer action) {
            final OptionalInt optionalFactor = Arrays.stream(FACTORS).filter(i -> number >= i).findFirst();
            if (!optionalFactor.isPresent()) {
                return false;
            }
            final int factor = optionalFactor.getAsInt();
            number -= factor;
            action.accept(factor);
            return true;
        }
    }
}
