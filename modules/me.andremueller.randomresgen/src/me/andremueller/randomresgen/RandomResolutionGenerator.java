package me.andremueller.randomresgen;

import me.andremueller.resolution.Resolution;

import java.util.Random;

public class RandomResolutionGenerator {
    private final int min;
    private final int max;
    private final Random random;

    public RandomResolutionGenerator(int min, int max) {
        this.min = min;
        this.max = max;
        this.random = new Random();
    }

    public Resolution generateResolution(){
        return new Resolution(generateRandomIntInBounds(), generateRandomIntInBounds());
    }

    private int generateRandomIntInBounds() {
        return min+random.nextInt(max);
    }

}