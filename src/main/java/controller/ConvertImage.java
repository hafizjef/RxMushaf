package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ConvertImage {

    private static final Logger logger = LoggerFactory.getLogger(ConvertImage.class);


    static int[][] arrayImage = new int[2000][2000];
    private static BufferedImage buffImageInput;
    private static ArrayList<File> publish = new ArrayList<>();

    static String trackName = "";
    static String filename = "";
    static String nameFile;

    static int w = 0;
    static int h = 0;


    public BufferedImage getImageInput(File inputFile) {
        filename = inputFile.getName();
        try {
            buffImageInput = ImageIO.read(inputFile);
        } catch (IOException err) {
            logger.error(err.getMessage());
        }
        return buffImageInput;
    }

    public BufferedImage getImageOutput(BufferedImage buffInputImage) {
        Raster raster = buffInputImage.getData();
        DataBuffer buffer = raster.getDataBuffer();
        DataBufferByte byteBuffer = (DataBufferByte) buffer;
        byte[] srcData = byteBuffer.getData(0);
        byte[] dstData = new byte[srcData.length];

        OtsuThresholder otsu = new OtsuThresholder();
        //to find the best threshold
        int threshold = otsu.doThreshold(srcData, dstData);
        if (threshold == 0)
            threshold = 127;

        BufferedImage bufImageOutput = OtsuThresholder.Threshold(buffInputImage, threshold);
        return bufImageOutput;
    }

    public static void drawImage(BufferedImage image_dest) throws IOException {
        w = image_dest.getWidth();
        h = image_dest.getHeight();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) == -1) {
                    arrayImage[y][x] = 1;
                } else {
                    arrayImage[y][x] = 0;
                }
            }
        }

        CutAlphabet cutimage = new CutAlphabet();
        cutimage.setImage(arrayImage, buffImageInput);
        cutimage.upperFrame();

        publish = cutimage.publish();
        String trackPath = nameFile;
    }

    public static void drawImageAfterThreasholdOnly(BufferedImage image_dest) throws IOException {
        w = image_dest.getWidth();
        h = image_dest.getHeight();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) == -1) {
                    arrayImage[y][x] = 1;
                } else {
                    arrayImage[y][x] = 0;
                }
            }
        }

        print(arrayImage, buffImageInput);
    }

    public static void print(int[][] arrayImage, BufferedImage buffImageInput) throws IOException {

        BufferedImage image = buffImageInput;
        int width = buffImageInput.getWidth();
        int height = buffImageInput.getHeight();
        int[][] arrayImageSave = arrayImage;


        int count = 0;
        int countRow = 0;

        int x = arrayImage.length;
        int y = arrayImage[1].length;

        int[][] pixelsR = new int[x][y];
        int[][] pixelsG = new int[x][y];
        int[][] pixelsB = new int[x][y];

        for (int i = 0; i < height; i++) {

            for (int j = 0; j < width; j++) {

                int red = 0;
                int green = 0;
                int blue = 0;

                if (arrayImageSave[i][j] == 1) {
                    red = 255;
                    green = 255;
                    blue = 255;
                }

                if (arrayImageSave[i][j] == 0) {
                    red = 0;
                    green = 0;
                    blue = 0;
                }
                pixelsR[i][j] = red;
                pixelsG[i][j] = green;
                pixelsB[i][j] = blue;

                Color newColor = new Color(red, green, blue);
                image.setRGB(j, i, newColor.getRGB());
            }
            countRow++;
        }

        String nameFile = Long.toString(new Date().getTime());

        File output = new File("output/tashih/binary/extract all object/Data Model/DM_" + nameFile + ".jpg"); // File save Data Model
        output.getParentFile().mkdirs();
        ImageIO.write(image, "jpg", output);
        publish.add(output);
    }

    public ArrayList<File> publish() {
        return publish;
    }

}