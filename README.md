# jmh-roman-numeral

At work, Oracle provided us some unit test training with C\# and NUnit by [Gerard Meszaros](http://www.gerardmeszaros.com/). 
One of the hands on exercises was the To Roman Numeral kata. My original C\# implementation was pretty convoluted,
so I thought I'd redo it in Java:

[RomanNumeralConverterPlaceValue.java](src/main/java/org/test/RomanNumeralConverterPlaceValue.java)

I've been wanting to try the [JMH microbenchmarking framework](http://openjdk.java.net/projects/code-tools/jmh/) so I
added an optimized version to compare:

[RomanNumeralConverterPlaceValueOptimized.java](src/main/java/org/test/RomanNumeralConverterPlaceValueOptimized.java)

Lastly, I liked this article [Informed TDD – Kata “To Roman Numerals”](http://geekswithblogs.net/theArchitectsNapkin/archive/2014/05/28/informed-tdd-ndash-kata-ldquoto-roman-numeralsrdquo.aspx)
so I ported that implementation to Java to see how it could be done in Java 8:

[RomanNumeralConverterJava8Streams.java](src/main/java/org/test/RomanNumeralConverterJava8Streams.java)

The benchmark code is under: [src/jmh](src/jmh) and is built with the [jmh-gradle-plugin](https://github.com/melix/jmh-gradle-plugin).
