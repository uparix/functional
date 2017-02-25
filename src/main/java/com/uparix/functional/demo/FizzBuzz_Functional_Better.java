package com.uparix.functional.demo;

import com.codepoetics.protonpack.StreamUtils;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzz_Functional_Better {

    public static void main(String[] args) {

        Stream<String> numbers = IntStream.iterate(1, i -> i + 1).mapToObj(String::valueOf);
        Stream<String> fizzes = cycle("", "", "fizz");
        Stream<String> buzzes = cycle("", "", "", "", "buzz");

        Stream<String> fizzbuzz = StreamUtils.zip(fizzes, buzzes, String::concat);
        Stream<String> zipped = StreamUtils.zip(numbers, fizzbuzz, FizzBuzz_Functional_Better::max);

        zipped.limit(100).forEach(System.out::println);
    }

    public static <T> Stream<T> cycle(T... elements) {
        return Stream.iterate(Arrays.asList(elements), i -> i).flatMap(it -> it.stream());
    }

    public static <T extends Comparable<T>> T max(T left, T right) {
        return left.compareTo(right) > 0 ? left : right;
    }


}
