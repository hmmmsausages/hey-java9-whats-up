package me.andremueller.heyjava9whatsup.extensions;

import java.util.Optional;

public class OptionalExtensions {
    public static void main(String[] args) {
        Optional<String> someOptional = Optional.of("something");

        // stream on optionals
        someOptional.stream();

        // if present then consume or else run
        someOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Nothing"));

        // if present returns optional with that value, or otherwise provide defined optional
        someOptional.or(() -> Optional.of("Nothing"));
    }
}
