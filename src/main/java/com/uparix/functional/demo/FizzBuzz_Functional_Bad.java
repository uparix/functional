package com.uparix.functional.demo;

import java.util.stream.IntStream;

public class FizzBuzz_Functional_Bad {

    public static void main(String...args) {
        IntStream.range(1, 101)
                .mapToObj(n -> {
                    if (n % 15 == 0) return "FizzBuzz";
                    else if (n % 3 == 0) return "Fizz";
                    else if (n % 5 == 0) return "Buzz";
                    else return n;
                }).forEach(System.out::println);
    }

}
