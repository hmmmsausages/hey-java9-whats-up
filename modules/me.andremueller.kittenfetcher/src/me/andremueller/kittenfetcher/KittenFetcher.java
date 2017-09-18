package me.andremueller.kittenfetcher;

import me.andremueller.resolution.Resolution;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import static java.lang.String.format;

public class KittenFetcher {
    private static final String KITTEN_URL_TEMPLATE = "https://placekitten.com/%d/%d";

    public static Optional<BufferedImage> fetchKittenImage(Resolution resolution) {
        try {
            URL fetchKittenUrl = new URL(format(KITTEN_URL_TEMPLATE, resolution.getWidth(), resolution.getHeight()));
            return Optional.ofNullable(ImageIO.read(fetchKittenUrl));
        } catch (IOException e) {
            return Optional.empty();
        }
    }
}