package me.andremueller.main;

import me.andremueller.randomresgen.RandomResolutionGenerator;
import me.andremueller.resolution.Resolution;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

import static me.andremueller.kittenfetcher.KittenFetcher.fetchKittenImage;
import static me.andremuller.convenientfileutils.ConvenientFileUtils.*;


public class Main {
    private static final String KITTEN_EMOJI = "\uD83D\uDC31";
    private static final String SAD_KITTEN_EMOJI = "\uD83D\uDE3F";

    private static Scanner inputScanner = new Scanner(System.in);
    private static String destinationPath = System.getProperty("user.home") + File.separator + "kittens";
    private static RandomResolutionGenerator resolutionGenerator = new RandomResolutionGenerator(100, 1500);

    public static void main(String[] args) throws IOException {

        promptForAmountOfKittens().ifPresentOrElse(amountOfKittens -> {
                    createDirectoriesToPaths(destinationPath);
                    IntStream.range(0, amountOfKittens)
                            .mapToObj(i -> "kitten"+i)
                            .forEach(fileName -> {
                                System.out.print(KITTEN_EMOJI);
                                Resolution resolution = resolutionGenerator.generateResolution();

                                fetchKittenImage(resolution).ifPresentOrElse(kittenImage -> {
                                    try {
                                        saveImageAsJpgToFile(kittenImage, createFile(destinationPath, fileName, "jpg"));
                                    } catch (IOException e) {
                                        System.out.println(SAD_KITTEN_EMOJI + " Couldn't save the kitten! Bye! " + SAD_KITTEN_EMOJI);
                                        System.exit(2);
                                    }
                                }, () -> System.out.println("Sorry! Couldn't fetch kitten with resolution " + resolution));
                            });
                    System.out.println("\nSaved all kittens! (check out "+destinationPath+")");
                },
                () -> {
                    System.out.println(SAD_KITTEN_EMOJI + " You've made the kittens sad! " + SAD_KITTEN_EMOJI);
                    System.exit(1);
                });
    }

    private static Optional<Integer> promptForAmountOfKittens() {
        System.out.println("How many kittens would you like?" + KITTEN_EMOJI);
        try {
            return Optional.of(inputScanner.nextInt());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}