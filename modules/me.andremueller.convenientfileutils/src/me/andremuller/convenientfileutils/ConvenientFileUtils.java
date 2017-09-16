package me.andremuller.convenientfileutils;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class ConvenientFileUtils {
    public static boolean createDirectoriesToPaths(String directoryPath) {
        return new File(directoryPath).mkdirs();
    }

    public static boolean saveImageAsJpgToFile(RenderedImage image, File file) throws IOException {
        return ImageIO.write(image, "jpg", file);
    }

    public static File createFile(String absoluteDirectoryPath, String fileName, String fileType) {
        String absoluteFilePath = absoluteDirectoryPath + File.separator + fileName + "." + fileType;
        return new File(absoluteFilePath);
    }
}
