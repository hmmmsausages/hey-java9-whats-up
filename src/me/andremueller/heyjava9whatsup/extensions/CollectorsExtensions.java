package me.andremueller.heyjava9whatsup.extensions;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class CollectorsExtensions {
    public static void main(String[] args) {
        List<String> animals = List.of("Bee", "Squid", "Sloth", "Elephant", "Unicorn", "Eel", "Donkey");

        // Filtering applies before grouping - no entry for group that doesn't match the criteria
        Map<Character, List<String>> groupedAnimalsFilteredByLength = animals.stream()
                .filter(animal -> animal.length() > 3)
                .collect(groupingBy(animal -> animal.charAt(0),
                        toList()
                ));
        System.out.println(groupedAnimalsFilteredByLength);

        // Filtering applies after grouping - entry for the group will still exist with filtered result
        Map<Character, List<String>> groupedAnimalsFilteredByLengthWithEmptyGroups = animals.stream()
                .collect(groupingBy(animal -> animal.charAt(0),
                        filtering(animal -> animal.length() > 3,
                                toList()
                        )));
        System.out.println(groupedAnimalsFilteredByLengthWithEmptyGroups);

    }
}
