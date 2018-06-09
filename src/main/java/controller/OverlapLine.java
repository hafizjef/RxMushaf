package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.regex.Pattern;


/*
 * NEED TO FIX THE ALGORITHM OF CUTTING THE LINE
 */
public class OverlapLine {

    private static final Logger logger = LoggerFactory.getLogger(OverlapLine.class);


    public static int[][] arrayImage;
    private BufferedImage buffImageInput;
    private int width = 0;
    private int height = 0;

    private ArrayList<String> lineCut = new ArrayList<String>();
    private ArrayList<String> overlapLines = new ArrayList<String>();

    /*
     * SET THE BINARY IMAGE AND BUFFERED IMAGE
     */
    public void setImage(int[][] arrayImage, BufferedImage buffImageInput) {
        OverlapLine.arrayImage = arrayImage;
        this.buffImageInput = buffImageInput;

        width = buffImageInput.getWidth();
        height = buffImageInput.getHeight();
    }

    /*
     * GET THE DIRECTORY AFTER IMAGE HAS BEEN CUT INTO COLLECTION OF SEVERAL LINE
     */
    public ArrayList<String> getDirectory() {
        return lineCut;
    }

    /*
     * VERSION 2.0: CUT IMGE INTO LINE (NEW)
     */
    public void cutline(String pathLine, String directData) throws IOException, InterruptedException {
        ArrayList<Integer> frequencyY; // hold value of frequency height
        ArrayList<Integer> topPoint = new ArrayList<>(); // hold all top point
        ArrayList<Integer> bottomPoint = new ArrayList<>(); // hold all bottom point
        ArrayList<int[][]> overlapLineImage = new ArrayList<>(); //holds overlap line image

        frequencyY = frequencyHeight(arrayImage);

        // Find top
        for (int i = 0; i < frequencyY.size() - 4; i++) {
            if (frequencyY.get(i) == 0)  // detect FIRST ZERO to be process
            {
                if (frequencyY.get(i + 1) > 0 && frequencyY.get(i + 2) > 0 && frequencyY.get(i + 3) > 0 && frequencyY.get(i + 4) > 0) // detect make sure the first four number must be greater than 0 to be TOP POINT
                {
                    topPoint.add(i + 1);
                }
            }
        }

        // Find bottom
        for (int i = 4; i < frequencyY.size(); i++) {
            if (frequencyY.get(i) == 0)  // detect FIRST ZERO to be process START at index 4
            {
                if (frequencyY.get(i - 1) > 0 && frequencyY.get(i - 2) > 0 && frequencyY.get(i - 3) > 0 && frequencyY.get(i - 4) > 0) // detect make sure the last four number must be greater than 0 to be BOTTOM POINT
                {
                    bottomPoint.add(i - 1);
                }
            }
        }

        ArrayList<int[][]> imageBinaryCutThread = new ArrayList<>();
        ArrayList<BufferedImage> buffImageInputThread = new ArrayList<>();

        ArrayList<Integer> collections = new ArrayList<>(); // To collect the line number that have no overlap ONLY.
        ArrayList<int[][]> collectionImages = new ArrayList<>(); // To collect the images that have no overlap ONLY.
        ArrayList<Integer> duplicates = new ArrayList<>(); // To collect the line number that have overlap;
        ArrayList<Integer> duplicateLineNumbers; //To collect the how many number of line that exist on SINGLE overlap image.
        duplicateLineNumbers = new ArrayList<>();

        // to make it run faster : split which it can be cut out and which need to be reconstruct
        OverlapLine overlapObj = new OverlapLine();

        for (int i = 0; i < topPoint.size(); i++) {
            int topCoordinate = (topPoint.get(i) - 1);
            int bottomCoordinate = (bottomPoint.get(i) + 1);
            //to make sure the line does not having overlap
            int overlap = checkOverlap(frequencyY, topCoordinate, bottomCoordinate); //testTHREAD
            int[][] imageBinaryCut = binarizeImage(arrayImage, topCoordinate, bottomCoordinate); //testTHREAD

            if (overlap <= 1) {
                //LINE IMAGE CAN BE CUT OUT
                overlapLineImage.add(imageBinaryCut);

                collections.add(i + 1);
                collectionImages.add(imageBinaryCut);
            } else if (overlap > 1) {
                //LINE IMAGE FOR OVERLAP RECONSTRUCTION
//				overlapObj.setOverlapLines(imageBinaryCut);
                overlapLineImage.add(imageBinaryCut);
                duplicates.add(i + 1);
                duplicateLineNumbers.add(overlap);


                // START: TEST WITH THREAD
                imageBinaryCutThread.add(imageBinaryCut); //testTHREAD
                buffImageInputThread.add(buffImageInput); //testTHREAD
                // END: TEST WITH THREAD

            }
        }

        //START: RearrangePosition
        int count = collections.size();
        for (int duplicateLineNumber : duplicateLineNumbers) {
            count = count + duplicateLineNumber;
        }

        ArrayList<Integer> collectionObjects = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < count; i++) {
            if (collections.contains(i + 1)) {
                collectionObjects.add(i + 1);
            } else if (!collections.contains(i + 1) && !collections.containsAll(duplicates) && (i + 1 == duplicates.get(index))) {
                for (int tempDuplicateLineNumbers = 1; tempDuplicateLineNumbers <= duplicateLineNumbers.get(index); tempDuplicateLineNumbers++) {
                    collectionObjects.add(-1);
                }
                if (index < duplicateLineNumbers.size() - 1) {
                    index++;
                }
            }
        }

        ArrayList<Integer> reNumcollectionObjects = new ArrayList<>();
        for (int reNum = 0; reNum < collectionObjects.size(); reNum++) {
            if (collectionObjects.get(reNum) != -1) {
                reNumcollectionObjects.add(reNum + 1);
            }
        }

        ArrayList<Integer> dupListCollectionObjects = new ArrayList<>();
        for (int dupList = 0; dupList < collectionObjects.size(); dupList++) {
            if (collectionObjects.get(dupList) == -1) {
                dupListCollectionObjects.add(dupList + 1);
            }
        }
        //END: RearrangePosition

        // Using thread for every single duplicate line
        /*ThreadOverlap[] threadOverlapArray = new ThreadOverlap[duplicateLineNumbers.size()];
        for (int i = 0; i < duplicateLineNumbers.size(); i++) {
            ArrayList<Integer> dupListCollectionObjectT = new ArrayList<>();
            for (int tempIndT = 0; tempIndT < duplicateLineNumbers.get(i); tempIndT++) {
                dupListCollectionObjectT.add(dupListCollectionObjects.get(0));
                dupListCollectionObjects.remove(0);
            }
            threadOverlapArray[i] = new ThreadOverlap("overlap" + i, imageBinaryCutThread.get(i), buffImageInputThread.get(i), directData, pathLine, dupListCollectionObjectT);
            threadOverlapArray[i].start();
        }*/

        /*for (int i = 0; i < threadOverlapArray.length; i++) {
	    	System.out.println(threadOverlapArray[i]+".join(); - Start [OverlapLine.java]");
            threadOverlapArray[i].join();
	    	System.out.println(threadOverlapArray[i]+".join(); - Finish [OverlapLine.java]");
	    	System.out.println("[OverlapLine.java] threadOverlapArray[i].getDirectoryImage() = "+ threadOverlapArray[i].getDirectoryImage());
        }*/

        /*if (threadOverlapArray.length >= 1) {
            for (int i = 0; i < threadOverlapArray.length; i++)
                lineCut.addAll(threadOverlapArray[i].getDirectoryImage()); //NEW 21/02/2017 2:03 AM - [OLD]--> lineCut.addAll(threadOverlapArray[threadOverlapArray.length-1].getDirectoryImage());
	    	System.out.println("AllThread.join(); - Finish [OverlapLine.java]");
        }*/

        ArrayList<Integer> dupNumcollectionObjects = new ArrayList<Integer>();
        for (int dupNum = 0; dupNum < overlapLineImage.size(); dupNum++) {
            dupNumcollectionObjects.add(dupNum + 1);
        }
//	    printVerseSingleImage(directData+"tashih/processed/line/overlap/", overlapLineImage, pathLine, dupNumcollectionObjects); //overlapObj
//	    overlapObj.printVerseSingleImageOverlap(directData+"tashih/processed/line/overlap/", overlapObj, pathLine, dupNumcollectionObjects);

        //print RGB color [actual line)
        lineCut.addAll(printVerseSingleImage(directData + "/tashih/processed/line/actual/OverlapLineJava_", collectionImages, pathLine, reNumcollectionObjects)); // if picture does not have overlap it will going through this (If picture has overlap during segmentation it will through ThreadOverlap.java)

        // Sort file Name
        Collections.sort(lineCut, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] arrayS1 = s1.split("_");
                String[] arrayS2 = s2.split("_");
                String part1 = arrayS1[arrayS1.length - 1];
                String part2 = arrayS2[arrayS2.length - 1];

                String[] formatS1 = part1.split(Pattern.quote("."));
                String[] formatS2 = part2.split(Pattern.quote("."));
                int intS1 = Integer.parseInt(formatS1[0]);
                int intS2 = Integer.parseInt(formatS2[0]);
                return Integer.toHexString(intS1).compareToIgnoreCase(Integer.toHexString(intS2));
            }
        });

    }

    /*
     * VERSION 2.0: CUT IMGE INTO OVERLAP (NEW)
     */
    public void cutlineOverlap(String pathLine, String directData) throws IOException, InterruptedException {
        ArrayList<Integer> frequencyY = new ArrayList<Integer>(); // hold value of frequency height
        ArrayList<Integer> topPoint = new ArrayList<Integer>(); // hold all top point
        ArrayList<Integer> bottomPoint = new ArrayList<Integer>(); // hold all bottom point
        ArrayList<int[][]> overlapLineImage = new ArrayList<int[][]>(); //holds overlap line image

        frequencyY = frequencyHeight(arrayImage);

        // Find top
        for (int i = 0; i < frequencyY.size() - 4; i++) {
            if (frequencyY.get(i) == 0)  // detect FIRST ZERO to be process
            {
                if (frequencyY.get(i + 1) > 0 && frequencyY.get(i + 2) > 0 && frequencyY.get(i + 3) > 0 && frequencyY.get(i + 4) > 0) // detect make sure the first four number must be greater than 0 to be TOP POINT
                {
                    topPoint.add(i + 1);
                }
            }
        }

        // Find bottom
        for (int i = 4; i < frequencyY.size(); i++) {
            if (frequencyY.get(i) == 0)  // detect FIRST ZERO to be process START at index 4
            {
                if (frequencyY.get(i - 1) > 0 && frequencyY.get(i - 2) > 0 && frequencyY.get(i - 3) > 0 && frequencyY.get(i - 4) > 0) // detect make sure the last four number must be greater than 0 to be BOTTOM POINT
                {
                    bottomPoint.add(i - 1);
                }
            }
        }

        // to make it run faster : split which it can be cut out and which need to be reconstruct

        ArrayList<Integer> indexNumber = new ArrayList<Integer>(); //pointer to index (collect how many overlap) eg; 2-5
        ArrayList<Integer> listNumber = new ArrayList<Integer>(); //list number (list of number) eg; 2,3-5,6

        int countIndexNumber = 0;
        for (int i = 0; i < topPoint.size(); i++) {
            int topCoordinate = (topPoint.get(i) - 1);
            int bottomCoordinate = (bottomPoint.get(i) + 1);
            //to make sure the line does not having overlap
            int overlap = checkOverlap(frequencyY, topCoordinate, bottomCoordinate); //testTHREAD
            int[][] imageBinaryCut = binarizeImage(arrayImage, topCoordinate, bottomCoordinate); //testTHREAD

            if (overlap <= 1) {
                //LINE IMAGE CAN BE CUT OUT
                countIndexNumber++;
            } else if (overlap > 1) {
                for (int index = 1; index <= overlap; index++) {
                    countIndexNumber++;
                    listNumber.add(countIndexNumber);
                }

                indexNumber.add(overlap);//2	3

                //LINE IMAGE FOR OVERLAP RECONSTRUCTION
                overlapLineImage.add(imageBinaryCut);

            }
        }

        //START: RearrangePosition

        //END: RearrangePosition

        ArrayList<Integer> dupNumcollectionObjects = new ArrayList<Integer>();
        for (int dupNum = 0; dupNum < overlapLineImage.size(); dupNum++) {
            dupNumcollectionObjects.add(dupNum + 1);
        }
        overlapLines.addAll(printVerseSingleImageOverlap(directData + "/tashih/processed/line/overlap/", overlapLineImage, pathLine, dupNumcollectionObjects, indexNumber, listNumber));


        // Sort file Name
        Collections.sort(lineCut, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] arrayS1 = s1.split("_");
                String[] arrayS2 = s2.split("_");
                String part1 = arrayS1[arrayS1.length - 1];
                String part2 = arrayS2[arrayS2.length - 1];

                String[] formatS1 = part1.split(Pattern.quote("."));
                String[] formatS2 = part2.split(Pattern.quote("."));
                int intS1 = Integer.parseInt(formatS1[0]);
                int intS2 = Integer.parseInt(formatS2[0]);
                return Integer.toHexString(intS1).compareToIgnoreCase(Integer.toHexString(intS2));
            }
        });

    }

    /*
     * PRINT RGB COLOR
     */
    public ArrayList<String> printVerseSingleImage(String path, ArrayList<int[][]> aLImage, String imgName, ArrayList<Integer> reNumcollectionObjects) throws IOException {

        ArrayList<int[][]> verse = aLImage;
        ArrayList<String> directoryImage = new ArrayList<>();

        int[][] tempPicPrint;
        BufferedImage image;

        String pathLineSplit[] = imgName.split("\\.");
        String namePic = pathLineSplit[0];

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
            String nameFile = Long.toString(new Date().getTime());

            File output = new File(path + namePic + "_" + reNumcollectionObjects.get(i) + ".jpg"); // File save CutAlphabet
            output.getParentFile().mkdirs();
            ImageIO.write(image, "jpg", output);
            directoryImage.add(output.getAbsolutePath());

            image = null;
            tempPicPrint = null;
        }

        return directoryImage;
    }

    public ArrayList<String> printVerseSingleImageOverlap(String path, ArrayList<int[][]> aLImage, String imgName, ArrayList<Integer> reNumcollectionObjects, ArrayList<Integer> indexNumber, ArrayList<Integer> listNumber) throws IOException {

        ArrayList<int[][]> verse = aLImage;
        ArrayList<String> directoryImage = new ArrayList<String>();

        int[][] tempPicPrint;
        BufferedImage image;

        String pathLineSplit[] = imgName.split("\\.");
        String namePic = pathLineSplit[0];

        int red = 0;
        int green = 0;
        int blue = 0;

        int temp = 0;
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
            String nameFile = Long.toString(new Date().getTime());

            StringBuilder lineNumber = new StringBuilder();
            boolean plug = true;

            for (int count = 1; count <= indexNumber.get(i); count++) {
                if (plug) {
                    lineNumber.append(listNumber.get(temp));
                    plug = false;
                } else {
                    lineNumber.append("&").append(listNumber.get(temp));
                }
                temp++;
            }

            File output = new File(path + namePic + "_" + lineNumber + ".jpg"); //File ouptut = new File(path +namePic+"_"+reNumcollectionObjects.get(i)+".jpg"); // File save CutAlphabet
            output.getParentFile().mkdirs();
            ImageIO.write(image, "jpg", output);
            directoryImage.add(output.getAbsolutePath());

            image = null;
            tempPicPrint = null;
        }

        return directoryImage;
    }


    /* overlapObj
     * PRINT BINARY: print the image in array (int[][] outputImage)
     */
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

    /*
     * RECHECK METHOD: TO MAKE SURE THE LINE DOES NOT HAVING OVERLAP
     */
    public int checkOverlap(ArrayList<Integer> frequencyY, int topPoint, int bottomPoint) {

        int overlap = 0; // Count how many line of top its have
        double values = (arrayImage[0].length * 0.03); // point that value be converted to be ZERO (example:<11.1)
        ArrayList<Integer> frequencyYconvert0 = new ArrayList<Integer>(); // hold value of frequency height that have been converted to ZERO if less than 0.03% (example:<11)

        // Remove value frequency that less than 0.03% to be 0
        for (int tempHeight : frequencyY) {
            if (tempHeight <= values) {
                frequencyYconvert0.add(0);
            } else if (tempHeight > values) {
                frequencyYconvert0.add(tempHeight);
            }
        }

        // Count how many line of top its have
        for (int i = topPoint; i < bottomPoint - 4; i++) {
            if (frequencyYconvert0.get(i) == 0)  // detect FIRST ZERO to be process
            {
                if (frequencyYconvert0.get(i + 1) > 0 && frequencyYconvert0.get(i + 2) > 0 && frequencyYconvert0.get(i + 3) > 0 && frequencyYconvert0.get(i + 4) > 0) // detect make sure the first four number must be greater than 0 to be TOP POINT
                {
                    overlap++;
                }
            }
        }

        return overlap;
    }

    /*
     * BINARIZE IMAGE: binary the image in array (int[][] outputImage)
     */
    public int[][] binarizeImage(int[][] outputImage, int topY, int bottomY) {
        int[][] tempBinarizeImage = new int[(1 + (bottomY - topY))][outputImage[1].length];
        int tempY = 0;
        int tempX = 0;

        for (int y = topY; y <= bottomY; y++) {
            for (int x = 0; x < outputImage[1].length; x++) {
                if (outputImage[y][x] == 0) {
                    tempBinarizeImage[tempY][tempX] = 0;
                    tempX++;
                } else if (outputImage[y][x] == 1) {
                    tempBinarizeImage[tempY][tempX] = 1;
                    tempX++;
                }
            }
            tempX = 0;
            tempY++;
        }
        return tempBinarizeImage;
    }

    /*
     * FIND FREQUEANCY OF Y-AXIS (HEIGHT)
     */
    public ArrayList<Integer> frequencyHeight(int[][] imagebinary) {
        ArrayList<Integer> frequencyY = new ArrayList<Integer>();
        int count = 0;

        for (int y = 0; y < imagebinary.length; y++) {
            for (int x = 0; x < imagebinary[0].length; x++) {
                if (imagebinary[y][x] == 0) {
                    count++;
                }
            }
            frequencyY.add(count);
            count = 0;
        }

        return frequencyY;
    }

    public ArrayList<String> getOverlapLines() {
        return overlapLines;
    }


}
