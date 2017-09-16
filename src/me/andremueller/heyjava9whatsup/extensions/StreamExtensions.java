package me.andremueller.heyjava9whatsup.extensions;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamExtensions {
    public static void main(String[] args) {
        // generates stream of the longest prefix that matches the given predicate
        List<Integer> takeWhileResult = Stream.of(1, 2, 3, 3, 2, 1)
                .takeWhile(number -> number < 3)
                .collect(toList());
        System.out.println(takeWhileResult);

        // generates stream of the remainder after dropping the longest prefix that matches the given predicate
        List<Integer> dropWhileResult = Stream.of(1, 2, 3, 3, 2, 1)
                .dropWhile(number -> number < 3)
                .collect(toList());
        System.out.println(dropWhileResult);

        // generate stream, similar to for loop
        List<Integer> iterateResult = Stream.iterate(0, i -> i < 10, i -> i+1)
                .collect(toList());
        System.out.println(iterateResult);

        // stream of nullable does not proceed if null
        Stream.ofNullable(123).forEach(e -> System.out.println("This will be printed"));
        Stream.ofNullable(null).forEach(e -> System.out.println("This won't be printed"));
    }
}
