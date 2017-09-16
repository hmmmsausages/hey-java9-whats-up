package me.andremueller.heyjava9whatsup.extensions;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsExtensions {
    public static void main(String[] args) {
        Set<String> immutableSet = Set.of("immutable", "set");
        List<String> immutableList = List.of("immutable", "immutable", "list");
        Map<String, Collection<String>> immutableMap = Map.of("immutableSet", immutableSet, "immutableList", immutableList);

        System.out.println(immutableMap);
    }
}
