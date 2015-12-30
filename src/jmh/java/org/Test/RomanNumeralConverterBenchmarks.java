package org.Test;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.test.RomanNumeralConverterJava8Streams;
import org.test.RomanNumeralConverterPlaceValue;
import org.test.RomanNumeralConverterPlaceValueOptimized;

import java.util.Random;

/**
 * Created by jalbrecht on 27/12/15.
 */
@State(Scope.Thread)
public class RomanNumeralConverterBenchmarks {

    private final RomanNumeralConverterPlaceValue converterPlaceValue = new RomanNumeralConverterPlaceValue();
    private final RomanNumeralConverterPlaceValueOptimized converterPlaceValueOptimized = new RomanNumeralConverterPlaceValueOptimized();
    private final RomanNumeralConverterJava8Streams converterJava8Streams = new RomanNumeralConverterJava8Streams();
    private final Random random = new Random();

    private int zero = 0;
    private int randomInt = 0;

    @Setup(Level.Invocation)
    public void prepare() {
        randomInt = random.nextInt(5000);
    }

    @Benchmark
    public String baseline() {
        return "";
    }

    @Benchmark
    public String converterPlaceValueFixedInput() {
        return converterPlaceValue.convert(zero);
    }

    @Benchmark
    public String converterPlaceValueOptimizedFixedInput() {
        return converterPlaceValueOptimized.convert(zero);
    }

    @Benchmark
    public String converterJava8StreamsFixedInput() {
        return converterJava8Streams.convert(zero);
    }

    @Benchmark
    public String converterPlaceValueRandomInput() {
        return converterPlaceValue.convert(randomInt);
    }

    @Benchmark
    public String converterPlaceValueOptimizedRandomInput() {
        return converterPlaceValueOptimized.convert(randomInt);
    }

    @Benchmark
    public String converterJava8StreamsRandomInput() {
        return converterJava8Streams.convert(randomInt);
    }

    @Benchmark
    public String converterPlaceValueNoBoundsCheckFixedInput() {
        return converterPlaceValue.convertNoBoundsCheck(zero);
    }

    @Benchmark
    public String converterPlaceValueOptimizedNoBoundsCheckFixedInput() {
        return converterPlaceValueOptimized.convertNoBoundsCheck(zero);
    }

    @Benchmark
    public String converterJava8StreamsNoBoundsCheckFixedInput() {
        return converterJava8Streams.convertNoBoundsCheck(zero);
    }

    @Benchmark
    public String converterPlaceValueNoBoundsCheckRandomInput() {
        return converterPlaceValue.convertNoBoundsCheck(randomInt);
    }

    @Benchmark
    public String converterPlaceValueOptimizedNoBoundsCheckRandomInput() {
        return converterPlaceValueOptimized.convertNoBoundsCheck(randomInt);
    }

    @Benchmark
    public String converterJava8StreamsNoBoundsCheckRandomInput() {
        return converterJava8Streams.convertNoBoundsCheck(randomInt);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(RomanNumeralConverterBenchmarks.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
