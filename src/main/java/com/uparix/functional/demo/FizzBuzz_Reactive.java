package com.uparix.functional.demo;

import reactor.core.publisher.Flux;

import java.util.stream.Stream;

public class FizzBuzz_Reactive {

    public static void main(String[] args) {

        Flux<String> numbers = Flux.fromStream(Stream.iterate(1, i -> i + 1)).map(String::valueOf);
        Flux<String> fizzes = Flux.just("", "", "fizz").repeat();
        Flux<String> buzzes = Flux.just("", "", "", "", "buzz").repeat();

        Flux<String> fizzbuzz = Flux.zip(fizzes, buzzes, String::concat);
        Flux<String> zipped = Flux.zip(numbers, fizzbuzz, (left, right) -> left.compareTo(right) > 0 ? left : right);

        zipped.take(100).subscribe(System.out::println);

    }


}
