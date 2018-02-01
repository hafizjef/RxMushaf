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

public class PointObjStop {

    private static final Logger logger = LoggerFactory.getLogger(PointObjStop.class);

    static int[][] arrayImage;  // save the binarize image create by method drawImage
    static int[][] arrayImageVerse; // array image for verse in binary					static int [][] arrayImageVerse = new int[2000][2000];
    static int[][] tempImageVerseBefore; // temporary to hold image before; to connect with image after
    static int[][] tempImageVerseAfter; // temporary to hold image after; to connect with image before
    static ArrayList<int[][]> verse = new ArrayList<int[][]>();
    static String filename = "";
    private static BufferedImage buffImageInput;
    static int w = 0;
    static int h = 0;
    static String nameFile;
    static int tempImageVerseBeforeLenght = 0;

    int[] frequencyYaxis;
    int[] frequencyXaxis;

    int yMarkTop = 0;
    int yMarkBottom = 0;
    int yMarkCenter = 0;

    int xMarkTop = 0;
    int xMarkBottom = 0;
    int xMarkCenter = 0;

    private ArrayList<String> lineCut = new ArrayList<String>(); // pages to line
    private ArrayList<String> overlapLines = new ArrayList<String>(); // pages to line overlap


    int YtempVerse = 0; // temporary index for arrayImageVerse (y-axis)
    int XtempVerse = 0; // temporary index for arrayImageVerse (x-axis)

    private BufferedImage image; //image to print connect verse to RGB color
    private ArrayList<File> imgVerse = new ArrayList<File>(); //image file save image from connect verse to RGB color

    /*
     * SET THE NAME OF THE FILE AND CONVERT IMAGE FILE TO BUFFERED IMAGE
     */
    public BufferedImage getImageInput(File inputFile) throws IOException {
        filename = inputFile.getName();
        try {
            buffImageInput = ImageIO.read(inputFile);
        } catch (IOException err) {
            logger.error("{} - getImageInput Error", inputFile.getName());
            throw err;
        }
        return buffImageInput;
    }

    /*
     * GET THE DIRECTORY AFTER IMAGE HAS BEEN CUT INTO COLLECTION OF SEVERAL LINE
     */
    public ArrayList<String> getDirectory() {
        return lineCut;
    }


    public ArrayList<String> getOverlapLines() {
        return overlapLines;
    }


    /*
     * CUT THE IMAGE BY LINE - THIS METHOD USE THE METHOD FORM CLASS CutImage
     */
    public void cutline(String pathLine, String directData) throws IOException, InterruptedException {
        logger.info("{} - 85 Obj Point", directData);
        OverlapLine cutimage = new OverlapLine();
        cutimage.setImage(arrayImage, buffImageInput); // set the image binary and bufferedImge
        cutimage.cutline(pathLine, directData); // VERSION 2: cut image into several line [actual line]
        cutimage.cutlineOverlap(pathLine, directData); // VERSION 2: cut image into several line [overlap line]
        lineCut.addAll(cutimage.getDirectory()); // NEW 21/2/2017 1:22 AM // [OLD]lineCut = cutimage.getDirectory(); // the place saved directory followed by [pathDirectory.doCrop.CropImage] {EXAMPLE OUTPUT:D:/tashih/processed/line/overlap/Penerbit_2-2016_003_4.jpg}
        overlapLines.addAll(cutimage.getOverlapLines());
    }

    /*
     * THRESHOLD THE BUFFERED IMAGE
     */
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

    /*
     * BINARIZE THE BUFFERED IMAGE
     */
    public static void drawImage(BufferedImage image_dest) throws IOException {
        w = image_dest.getWidth();
        h = image_dest.getHeight();

        arrayImage = new int[h][w];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) == -1) {
                    arrayImage[y][x] = 1;
                } else {
                    arrayImage[y][x] = 0;
                }
            }
        }
    }

    public void frequencyAxis() {
        frequencyYaxis = new int[buffImageInput.getHeight() + 1];
        frequencyXaxis = new int[buffImageInput.getWidth() + 1];

        int tempY = 0;
        int tempX = 0;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (arrayImage[y][x] == 0) {
                    tempY = tempY + 1;
                }
            }
            frequencyYaxis[y] = tempY;
            tempY = 0;
        }

        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                if (arrayImage[y][x] == 0) {
                    tempX = tempX + 1;
                }
            }
            frequencyXaxis[x] = tempX;
            tempX = 0;
        }
    }

    public void markObj() {

        for (int yTop = 0; yTop < frequencyYaxis.length; yTop++) {
            if (frequencyYaxis[yTop] > 0) {
                yMarkTop = yTop;
                break;
            }
        }

        for (int yBottom = frequencyYaxis.length - 1; yBottom < frequencyYaxis.length; yBottom--) {
            if (frequencyYaxis[yBottom] > 0) {
                yMarkBottom = yBottom;
                break;
            }
        }

        yMarkCenter = ((yMarkBottom - yMarkTop) / 2) + yMarkTop;

        for (int xTop = 0; xTop < frequencyXaxis.length; xTop++) {
            if (frequencyXaxis[xTop] > 0) {
                xMarkTop = xTop;
                break;
            }
        }

        for (int xBottom = frequencyXaxis.length - 1; xBottom < frequencyXaxis.length; xBottom--) {
            if (frequencyXaxis[xBottom] > 0) {
                xMarkBottom = xBottom;
                break;
            }
        }

        xMarkCenter = ((xMarkBottom - xMarkTop) / 2) + xMarkTop;
    }

    public int getYMarkCenter() {
        return yMarkCenter;
    }

    public int getXMarkCenter() {
        return xMarkCenter;
    }


    public int getYMarkTop() {
        return yMarkTop;
    }

    public int getXMarkTop() {
        return xMarkTop;
    }

    public int getXMarkWidth() {
        return (xMarkBottom - xMarkTop);
    }

    public int getYMarkHeight() {
        return (yMarkBottom - yMarkTop);
    }

    /*
     * to check last point X-axis for last width to pointer
     */
    public int lastPointWidthXaxis() {
        int xpoint = 0;
        for (int i = frequencyXaxis.length - 1; i >= 0; i--) {
            if (frequencyXaxis[i] > 0) {
                xpoint = i;
                break;
            }
        }

        return xpoint;
    }

    public int startPointWidthXaxis() {
        int xpoint = 0;
        for (int i = 0; i < frequencyXaxis.length; i++) {
            if (frequencyXaxis[i] > 0) {
                xpoint = i;
                break;
            }
        }

        return xpoint;
    }

    public void cutVerse(int beforeXaxis, int afterXaxis, int status, int heightImg) //TEST_ZONE
    {
        arrayImageVerse = new int[heightImg][afterXaxis - beforeXaxis];
        /*
         * from left to right then top to bottom
         */
        for (int y = 0; y < h; y++) {
            for (int x = beforeXaxis; x <= afterXaxis - 1; x++) {
                if (arrayImage[y][x] == 1) {
                    arrayImageVerse[YtempVerse][XtempVerse] = 1;

                } else {

                    arrayImageVerse[YtempVerse][XtempVerse] = 0;
                }
                XtempVerse++;
            }

            XtempVerse = 0;
            YtempVerse++;
        }
        YtempVerse = 0;
        XtempVerse = 0;

        if (status == 0) {
            verse.add(arrayImageVerse);
            arrayImageVerse = null;
        } else if (status == 1) {

            tempImageVerseBefore = new int[heightImg][afterXaxis - beforeXaxis];
            tempImageVerseBefore = arrayImageVerse;
            arrayImageVerse = null;
            tempImageVerseBeforeLenght = tempImageVerseBefore[1].length;
        } else if (status == 2) // status 2 refer as sentence that should be placed on the middle of ayah
        {
            int heightYaxis = 0;
            if (tempImageVerseBeforeLenght != 0) {
                if (heightImg >= tempImageVerseBefore.length) {
                    heightYaxis = heightImg;
                } else if (tempImageVerseBefore.length > heightImg) {
                    heightYaxis = tempImageVerseBefore.length;
                }
            } else {
                heightYaxis = heightImg;
            }

            int[][] tempStatus2 = new int[heightYaxis][tempImageVerseBeforeLenght + arrayImageVerse[1].length];

            /*
             * this is to make the initial layout of image after to be all white color first before paint any black color
             * from left to right then top to bottom
             */
            for (int x = 0; x < tempStatus2[1].length; x++) {
                for (int y = 0; y < tempStatus2.length; y++) {
                    tempStatus2[y][x] = 1;
                }
            }

            int countyH = 0;
            int countxW = 0;
            /*
             * This is first line of word image current to be insert into layout (image current + image before = image after)
             * top to bottom then left to right
             */
            for (int x = 0; x < arrayImageVerse[1].length; x++)        //for(int y=0; y<heightImg;y++)			for(int x =0 ; x<tempImageVerseBeforeLenght; x++)
            {
                for (int y = 0; y < heightImg; y++)                            //for(int x =0 ; x<tempImageVerseBefore[1].length; x++)			for(int y=0; y<heightImg;y++)
                {
                    if (arrayImageVerse[y][x] == 1) {
                        tempStatus2[y][x] = 1;
                    } else if (arrayImageVerse[y][x] == 0) {
                        tempStatus2[y][x] = 0;
                    }
                    countyH++;
                }
                countyH = 0;
                countxW++;
            }


            /*
             * This is to make if there is exits for image before to be equal to image before + image current = image after
             */
            if (tempImageVerseBeforeLenght != 0) // new 23/3/16 - 5:37 AM
            {
                int tempCountBeforeY = 0; // temporary to count index for image before for y axis. (array image before)
                int tempCountBeforeX = 0; // temporary to count index for image before for x axis. (array image before)
                for (int x = countxW; x < (tempImageVerseBeforeLenght + arrayImageVerse[1].length); x++) {
                    for (int y = 0; y < tempImageVerseBefore.length; y++) // 29/3/2016-11:28AM // 25/3/2016 - 4:00 AM //for (int y=1 ; y<heightImg ; y++) //for (int y=0 ; y<heightYaxis ; y++)
                    {
                        if (tempImageVerseBefore[tempCountBeforeY][tempCountBeforeX] == 1) // if (tempImageVerseBefore[tempCountBeforeY][tempCountBeforeX] == 1)  && tempImageVerseBefore != null
                        {
                            tempStatus2[y][x] = 1;
                        } else if (tempImageVerseBefore[tempCountBeforeY][tempCountBeforeX] == 0) //else if (tempImageVerseBefore[tempCountBeforeY][tempCountBeforeX] == 0)
                        {
                            tempStatus2[y][x] = 0;
                        }
                        countyH++;
                        tempCountBeforeY++;
                    }
                    countyH = 0;
                    countxW++;
                    tempCountBeforeY = 0;
                    tempCountBeforeX++;
                }
                tempCountBeforeX = 0; // 25/3/2016 - 3:11AM
            }

            tempImageVerseBefore = new int[tempStatus2.length][tempStatus2[0].length];
            tempImageVerseBefore = tempStatus2;

            arrayImageVerse = null;
            tempImageVerseBeforeLenght = tempImageVerseBefore[1].length;
            ; // new 23/3/16 - 5:37 AM

        } else if (status == -1) {

            //tempImageVerseAfter = new int[heightImg][5000];  //tempImageVerseAfter = new int[heightImg][tempImageVerseBefore[1].length+arrayImageVerse[1].length];
            int heightYaxis = 0; // this is going to be y-axis for image after (tempImageVerseAfter)
            // heightImg = this is current image

            if (tempImageVerseBeforeLenght != 0) // new 23/3/16 - 5:37 AM
            {
                if (heightImg >= tempImageVerseBefore.length) {
                    heightYaxis = heightImg;
                    //for (int y = )
                } else if (tempImageVerseBefore.length > heightImg) {
                    heightYaxis = tempImageVerseBefore.length;
                }
            } else if (tempImageVerseBeforeLenght == 0) {
                heightYaxis = heightImg;
            }

            tempImageVerseAfter = new int[heightYaxis][tempImageVerseBeforeLenght + arrayImageVerse[1].length];

            /*
             * this is to make the initial layout of image after to be all white color first before paint any black color
             * from left to right then top to bottom
             */
            for (int x = 0; x < tempImageVerseAfter[1].length; x++) {
                for (int y = 0; y < tempImageVerseAfter.length; y++) {
                    tempImageVerseAfter[y][x] = 1;
                }
            }


            int countyH = 0;
            int countxW = 0;
            /*
             * This is first line of word image current to be insert into layout (image current + image before = image after)
             * top to bottom then left to right
             */
            for (int x = 0; x < arrayImageVerse[1].length; x++)        //for(int y=0; y<heightImg;y++)			for(int x =0 ; x<tempImageVerseBeforeLenght; x++)
            {
                for (int y = 0; y < heightImg; y++)                            //for(int x =0 ; x<tempImageVerseBefore[1].length; x++)			for(int y=0; y<heightImg;y++)
                {
                    if (arrayImageVerse[y][x] == 1) {
                        tempImageVerseAfter[y][x] = 1;
                    } else if (arrayImageVerse[y][x] == 0) {
                        tempImageVerseAfter[y][x] = 0;
                    }
                    countyH++;
                }
                countyH = 0;
                countxW++;
            }

            /*
             * This is to make if there is exits for image before to be equal to image before + image current = image after
             */
            if (tempImageVerseBeforeLenght != 0) // new 23/3/16 - 5:37 AM
            {

                int tempCountBeforeY = 0; // temporary to count index for image before for y axis. (array image before)
                int tempCountBeforeX = 0; // temporary to count index for image before for x axis. (array image before)
                for (int x = countxW; x < (tempImageVerseBeforeLenght + arrayImageVerse[1].length); x++) {
                    for (int y = 0; y < tempImageVerseBefore.length; y++) // 29/3/2016-11:28AM // 25/3/2016 - 4:00 AM //for (int y=1 ; y<heightImg ; y++) //for (int y=0 ; y<heightYaxis ; y++)
                    {
                        if (tempImageVerseBefore[tempCountBeforeY][tempCountBeforeX] == 1) // if (tempImageVerseBefore[tempCountBeforeY][tempCountBeforeX] == 1)  && tempImageVerseBefore != null
                        {
                            tempImageVerseAfter[y][x] = 1;
                        } else if (tempImageVerseBefore[tempCountBeforeY][tempCountBeforeX] == 0) //else if (tempImageVerseBefore[tempCountBeforeY][tempCountBeforeX] == 0)
                        {
                            tempImageVerseAfter[y][x] = 0;
                        }
                        countyH++;
                        tempCountBeforeY++;
                    }
                    countyH = 0;
                    countxW++;
                    tempCountBeforeY = 0;
                    tempCountBeforeX++;
                }
                tempCountBeforeX = 0; // 25/3/2016 - 3:11AM
            }
            verse.add(tempImageVerseAfter);
            arrayImageVerse = null;
            tempImageVerseAfter = null;  // new 23/3/16 - 5:37 AM
            tempImageVerseBefore = null; // new 23/3/16 - 5:37 AM
            tempImageVerseBeforeLenght = 0; // new 23/3/16 - 5:37 AM

        }

    }

    public void printVerse(File picName, String directData) throws IOException {
        String imgName = picName.getName();
        String pathLineSplit[] = imgName.split("\\.");
        String namePic = pathLineSplit[0];

        int[][] tempPicPrint;

        int red = 0;
        int green = 0;
        int blue = 0;

        for (int i = 0; i < verse.size(); i++) {
            tempPicPrint = verse.get(i);

            // check either the picture image have any word/object  or not. if doesn't have don't print
            boolean objExits = false;
            for (int y = 0; y < tempPicPrint.length; y++) {
                for (int x = 0; x < tempPicPrint[1].length; x++) {
                    if (tempPicPrint[y][x] == 0) {
                        objExits = true;
                        break;
                    }
                }
                if (objExits == true) {
                    break;
                }
            }

            if (objExits == true) {
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
                String nameFile = directData + "/tashih/processed/verse/" + namePic + "_" + (i + 1) + ".jpg";

                File ouptut = new File(nameFile); // File save CutAlphabet
                ImageIO.write(image, "jpg", ouptut);
                imgVerse.add(ouptut);
                image = null;
                tempPicPrint = null;
            }

        }
        verse = new ArrayList<int[][]>(); //  21/2/2017 - 12:15 AM
    }

    public ArrayList<File> getImageVerse() {
        return imgVerse;
    }

}
