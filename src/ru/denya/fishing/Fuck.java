package ru.denya.fishing;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fuck {
    public static void main(String[] args) {

        File file1 = new File("D:\\1.jpg");
        File file2 = new File("D:\\2.jpg");
        int count1 = 0;
        int count2 = 0;

        try {
            BufferedImage image1 = ImageIO.read(file1);
            BufferedImage image2 = ImageIO.read(file2);

            int width1 = image1.getWidth();
            int height1 = image1.getHeight();

            int width2 = image2.getWidth();
            int height2 = image2.getHeight();

            int maxCount1 = width1 * height1;
            int maxCount2 = width2 * height2;

            int rgb1;
            int rgb1P;

            int rgb2;
            int rgb2P;

            for (int i = 0; i < width1; i++) {
                for (int j = 0; j < height1 - 1; j++) {
                    rgb1 = image1.getRGB(i, j);
                    rgb1P = image1.getRGB(i, j + 1);

                    if (rgb1 != rgb1P) {
                        count1++;
                    }
                }
            }
            int dif1;
            dif1 = maxCount1 / 100;
            dif1 = count1 / dif1;


            for (int i = 0; i < width2; i++) {
                for (int j = 0; j < height2 - 1; j++) {
                    rgb2 = image2.getRGB(i, j);
                    rgb2P = image2.getRGB(i, j + 1);

                    if (rgb2 != rgb2P) {
                        count2++;
                    }
                }
            }
            int dif2;
            dif2 = maxCount2 / 100;
            dif2 = count2 / dif2;

            System.out.println("Разница: " + (dif2 - dif1));

            if (dif2 - dif1 == 0 || dif2 - dif1 <= 2) {
                System.out.println("Одинаковые");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
