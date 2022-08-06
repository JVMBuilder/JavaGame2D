package com.javagame.game;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class ImageRotate {


    public static void rotation(File input, File output){
        try {
            ImageInputStream inputStream = ImageIO.createImageInputStream(input);
            Iterator<ImageReader> iterator = ImageIO.getImageReaders(inputStream);
            ImageReader reader = iterator.next();
            String format = reader.getFormatName();

            BufferedImage image = ImageIO.read(inputStream);
            int width = image.getWidth();
            int height = image.getHeight();

            BufferedImage rotated = new BufferedImage(width, height, image.getType());

            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    rotated.setRGB((width-1) - y, (height-1) - x, image.getRGB(x, y));
                }
            }

            ImageIO.write(rotated, format,output);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
