/*
package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ThreadOverlap extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(ThreadOverlap.class);


    private Thread t;
    private String threadName;
    int[][] imageBinaryCutThread;
    BufferedImage buffImageInputThread;
    String directData;
    String pathLine;
    ArrayList<int[][]> actualLineImage = new ArrayList<>(); //hold actual line image
    ArrayList<Integer> dupListCollectionObject; // hold list number of image
    ArrayList<String> directoryImage = new ArrayList<>();

    ThreadOverlap(String threadName, int[][] imageBinaryCutThread, BufferedImage buffImageInputThread, String directData, String pathLine, ArrayList<Integer> dupListCollectionObject) {
        this.threadName = threadName;
        this.imageBinaryCutThread = imageBinaryCutThread;
        this.buffImageInputThread = buffImageInputThread;
        this.directData = directData;
        this.pathLine = pathLine;
        this.dupListCollectionObject = dupListCollectionObject;
    }

    public void run() {
        logger.info("40 THREADOVERLAP");
        RemoveOverlapLines cutimage = new RemoveOverlapLines();
        cutimage.setImage(imageBinaryCutThread, imageBinaryCutThread, buffImageInputThread);
        cutimage.histogram(imageBinaryCutThread); // VERSION 3.0
        ArrayList<int[][]> noOverlapImage = cutimage.getactualLine();
        for (int index = 0; index < noOverlapImage.size(); index++) {
            actualLineImage.add(noOverlapImage.get(index));
            try {
                directoryImage.addAll(printVerse(directData + "/tashih/processed/line/actual/ThreadOverlapJava_", actualLineImage, pathLine, index));   // NEW 21/02/2017 1:37 AM // ASSIGNED BACK TO STACK OF ACTUAL LINE PICTURE AFTER CONSTRUCTION  INTO OVERLAP FOLDER (ONLY FOR OVERLAP PICTURE)
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
            actualLineImage = new ArrayList<>();
        }
    }

    */
/*
     * PRINT RGB COLOR
     *//*

    public ArrayList<String> printVerse(String path, ArrayList<int[][]> aLImage, String imgName, int index) throws IOException {
        ArrayList<String> directoryImageSingle = new ArrayList<String>();   // NEW 21/02/2017 1:37 AM

        ArrayList<int[][]> verse = aLImage;

        int[][] tempPicPrint;
        BufferedImage image;

        String pathLineSplit[] = imgName.split("\\.");
        String namePic = pathLineSplit[0];

        String dateFile = new Long(new Date().getTime()).toString();

        int red = 0;
        int green = 0;
        int blue = 0;

        for (int i = 0; i < verse.size(); i++) {
            tempPicPrint = verse.get(i);

            image = new BufferedImage(tempPicPrint[1].length, tempPicPrint.length, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < tempPicPrint.length; y++) {
                for (int x = 0; x < tempPicPrint[1].length; x++) {
                    if (tempPicPrint[y][x] == 0) {
                        red = 0;
                        green = 0;
                        blue = 0;
                    } else if (tempPicPrint[y][x] == 1) {
                        red = 255;
                        green = 255;
                        blue = 255;
                    }
                    Color newColor = new Color(red, green, blue);
                    image.setRGB(x, y, newColor.getRGB());
                    red = 0;
                    green = 0;
                    blue = 0;
                }
            }
            String nameFile = path + namePic + "_" + dupListCollectionObject.get(index) + ".jpg";

            File ouptut = new File(nameFile); // File save CutAlphabet
            ouptut.getParentFile().mkdirs();
            ImageIO.write(image, "jpg", ouptut);
            directoryImageSingle.add(ouptut.getAbsolutePath());   // NEW 21/02/2017 1:37 AM
            //System.out.println("[ThreadOverlap:139] ouptut.getAbsolutePath() = "+ouptut.getAbsolutePath());
            image = null;
            tempPicPrint = null;
        }

        //System.out.println("[ThreadOverlap:144] directoryImageSingle = "+directoryImageSingle);
        return directoryImageSingle;  // NEW 21/02/2017 1:37 AM
    }

    public ArrayList<String> getDirectoryImage() {
        return directoryImage;
    }

    */
/*
     * PRINT BINARY: print the image in array (int[][] outputImage)
     *//*

    public void printBinary(int[][] outputImage) {
        for (int y = 0; y < outputImage.length; y++) {
            for (int x = 0; x < outputImage[1].length; x++) {
                if (outputImage[y][x] == 0) {
                    System.out.print("0");
                }
                if (outputImage[y][x] == 1) {
                    System.out.print("1");
                }
            }
            System.out.println("");
        }
    }

}
*/
