package com.uparix.functional.demo;

import javaslang.collection.Stream;

public class FizzBuzz_JavaSlang {

    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.from(1);
        Stream<String> fizzes = Stream.of("", "", "fizz").cycle();
        Stream<String> buzzes = Stream.of("", "", "", "", "buzz").cycle();
        Stream<String> pattern = fizzes.zip(buzzes).map(t -> t._1 + t._2);
        Stream<String> fizzbuzz = numbers.zip(pattern).map(t -> t._2.isEmpty() ? String.valueOf(t._1) : t._2);

        fizzbuzz.take(100).forEach(System.out::println);
    }

}
