package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class RemoveOverlapLines {

    private BufferedImage buffImageInput;
    private int width = 0;
    private int height = 0;
    private int[][] imagebinary;                                // the correction from arrayImage

    private ArrayList<Integer> xaxispoint = new ArrayList<Integer>();
    private ArrayList<Integer> yaxispoint = new ArrayList<Integer>();
    private ArrayList<String> lineCut = new ArrayList<String>();
    private ArrayList<int[][]> imageObjectLine = new ArrayList<int[][]>();
    ArrayList<int[][]> actualLine = new ArrayList<int[][]>();

    /*
     * SET THRESHOLD BINARY IMAGE AND BUFFERED IMAGE
     */
    public void setImage(int[][] arrayImage, int[][] imagebinary, BufferedImage buffImageInput) {
        this.imagebinary = new int[imagebinary.length][imagebinary[1].length]; // [y-axis.lenght][x-axis.lenght]
        this.imagebinary = imagebinary;
        this.buffImageInput = buffImageInput;

        width = buffImageInput.getWidth();
        height = buffImageInput.getHeight();
    }

    /*	VERSION 2
     *  Find the frequency for each point top and point bottom given. To get the shortest length of frequency to be.
     *  return String winPointTemp;
     */
    public String pointMinMaxFrequencyV2(int[] pointMaxMin, int[][] imagebinary) {
        int pointLeft = pointMaxMin[0];
        int pointRight = pointMaxMin[1];
        int pointTop = pointMaxMin[2];
        int pointBottom = pointMaxMin[3];

        int tempCountBottom = 0;
        ArrayList<Integer> tempBottom = new ArrayList<Integer>();

        int tempCountTop = 0;
        ArrayList<Integer> tempTop = new ArrayList<Integer>();

        int winTop = 0;
        int winBottom = 0;

        int winPoint = 0;
        String winPointTemp = "NO";

        // Bottom
        for (int x = pointLeft; x <= pointRight; x++) {
            for (int y = pointBottom + 1; y < imagebinary.length; y++) {
                if (imagebinary[y][x] == 1) {
                    tempCountBottom++;
                }

                if (imagebinary[y][x] == 0) {
                    break;
                }
            }
            tempBottom.add(tempCountBottom);
            tempCountBottom = 0;
        }
        tempCountBottom = 0;

        // Top
        for (int x = pointLeft; x <= pointRight; x++) {
            for (int y = pointTop - 2; y >= 0; y--) {
                if (imagebinary[y][x] == 1) {
                    tempCountTop++;
                }
                if (imagebinary[y][x] == 0) {
                    break;
                }
            }
            tempTop.add(tempCountTop);
            tempCountTop = 0;
        }
        tempCountTop = 0;

        // Find the win top (the lowest frequency to the point of top)
        winTop = tempTop.get(0);
        for (int index = 1; index < tempTop.size(); index++) {
            if (tempTop.get(index) < winTop) {
                winTop = tempTop.get(index);
            }
        }

        // Find the win bottom (the lowest frequency to the point of bottom)
        winBottom = tempBottom.get(0);
        for (int index = 1; index < tempBottom.size(); index++) {
            if (tempBottom.get(index) < winBottom) {
                winBottom = tempBottom.get(index);
            }
        }

        if (winTop <= winBottom) {
            winPoint = winTop;
            winPointTemp = "TOP";
        } else if (winBottom < winTop) {
            winPoint = winBottom;
            winPointTemp = "BOTTOM";
        }

        return winPointTemp;
    }

    /*
     * GET THE DIRECTORY AFTER IMAGE HAS BEEN CUT INTO COLLECTION OF SEVERAL LINE
     */
    public ArrayList<String> getDirectory() {
        return lineCut;
    }

    /*
     * GET THE COLLECTION OF LINE FINAL RESULT
     */
    public ArrayList<int[][]> getactualLine() {
        return actualLine;
    }

    /*
     * New Algorithm Code (version 3.0)
     */
    public void histogram(int[][] imagebinary) {

        ArrayList<Integer> frequencyY = new ArrayList<Integer>(); // hold value of frequency height
        ArrayList<Integer> frequencyYconvert0 = new ArrayList<Integer>(); // hold value of frequency height that have been converted to ZERO if less than 0.03% (example:<11)

        ArrayList<Integer> topPoint = new ArrayList<Integer>(); // hold all top point
        ArrayList<Integer> bottomPoint = new ArrayList<Integer>(); // hold all bottom point
        ArrayList<Integer> baselinePoint = new ArrayList<Integer>(); // hold all baseline point

        double values = (imagebinary[0].length * 0.03); // point that value be converted to be ZERO (example:<11.1)

        // Find frequency of Y-Axis (height)
        frequencyY = frequencyHeight(imagebinary);

        // Remove value frequency that less than 0.03% to be 0
        for (int tempHeight : frequencyY) {
            if (tempHeight <= values) {
                frequencyYconvert0.add(0);
            } else if (tempHeight > values) {
                frequencyYconvert0.add(tempHeight);
            }
        }

        // Find top
        for (int i = 0; i < frequencyYconvert0.size() - 4; i++) {
            if (frequencyYconvert0.get(i) == 0)  // detect FIRST ZERO to be process
            {
                if (frequencyYconvert0.get(i + 1) > 0 && frequencyYconvert0.get(i + 2) > 0 && frequencyYconvert0.get(i + 3) > 0 && frequencyYconvert0.get(i + 4) > 0) // detect make sure the first four number must be greater than 0 to be TOP POINT
                {
                    topPoint.add(i + 1);

                }
            }
        }

        // Find bottom
        for (int i = 4; i < frequencyYconvert0.size(); i++) {
            if (frequencyYconvert0.get(i) == 0)  // detect FIRST ZERO to be process START at index 4
            {
                if (frequencyYconvert0.get(i - 1) > 0 && frequencyYconvert0.get(i - 2) > 0 && frequencyYconvert0.get(i - 3) > 0 && frequencyYconvert0.get(i - 4) > 0) // detect make sure the last four number must be greater than 0 to be BOTTOM POINT
                {
                    bottomPoint.add(i - 1);

                }
            }
        }


        // Find baseline point histogram (highest frequency of each point)
        for (int i = 0; i < topPoint.size(); i++) {
            int tempHighest = frequencyYconvert0.get(topPoint.get(i));
            int tempIndex = topPoint.get(i);
            for (int count = topPoint.get(i); count <= bottomPoint.get(i); count++) {
                if (frequencyYconvert0.get(count) >= tempHighest) {
                    tempHighest = frequencyYconvert0.get(count);
                    tempIndex = count;
                }
            }
            baselinePoint.add(tempIndex);

        }

        // detect and strikes all one Y point line of word(not include its' diacritics)						public int[][] object(int yaxis,int xaxis, int[][] getImagebinary)
        int[][] tempEachWord = new int[imagebinary.length][imagebinary[0].length]; // strike SINGLE object for SINGLE line created by object(y,x,image) function
        int[][] tempLineWord = new int[imagebinary.length][imagebinary[0].length]; // the creator image [strike top and bootom image]
        ArrayList<int[][]> wordNoDiacritics = new ArrayList<int[][]>(); // image line without diacritics
        tempEachWord = intializesImage(tempEachWord);  // initialize 2D array to be white canvas
        tempLineWord = intializesImage(tempLineWord);  // initialize 2D array to be white canvas
        for (int i = 0; i < baselinePoint.size(); i++) {
            // strike all object that crossed the top point
            for (int x = 0; x < imagebinary[0].length; x++) // x coordinate on single y coordinate TOP
            {
                // detect single word object
                tempEachWord = object(topPoint.get(i), x, imagebinary); //24/4/2016 6:48 AM tempEachWord = object(baselinePoint.get(i),x,imagebinary);

                // put into tempLineWord to make whole one line
                for (int yaxis = 0; yaxis < imagebinary.length; yaxis++) {
                    for (int xaxis = 0; xaxis < imagebinary[0].length; xaxis++) {
                        if (tempEachWord[yaxis][xaxis] == 0) {
                            tempLineWord[yaxis][xaxis] = 0;
                        }
                        /*###########################*/        //	System.out.println(" Detect"+" "+i+" "+"TOP"+" "+x+" "+yaxis+" "+xaxis+" ");
                    }
                }
            }

            tempEachWord = intializesImage(tempEachWord);

            // strike all object that crossed the bottom point
            for (int x = 0; x < imagebinary[0].length; x++) // x coordinate on single y coordinate bottom
            {
                // detect single word object
                tempEachWord = object(bottomPoint.get(i), x, imagebinary); //24/4/2016 6:48 AM tempEachWord = object(baselinePoint.get(i),x,imagebinary);

                // put into tempLineWord to make whole one line
                for (int yaxis = 0; yaxis < imagebinary.length; yaxis++) {
                    for (int xaxis = 0; xaxis < imagebinary[0].length; xaxis++) {
                        if (tempEachWord[yaxis][xaxis] == 0) {
                            tempLineWord[yaxis][xaxis] = 0;
                        }
                        /*###########################*/        //			System.out.println(" Detect"+" "+i+" "+"BOTTOM"+" "+x+" "+yaxis+" "+xaxis+" ");
                    }
                }
            }

            // strike all object that in between the top point and bottom point
            for (int y = topPoint.get(i); y <= bottomPoint.get(i); y++) // y coordinate on single y coordinate ; from TOP to BOTTOM for each line
            {
                for (int x = 0; x < imagebinary[0].length; x++) {
                    if (this.imagebinary[y][x] == 0)  // IF THE IMAGE GOT PROBLEM 1 THIS IS THE POINT
                    {
                        tempLineWord[y][x] = 0;
                    }
                    if (this.imagebinary[y][x] == 1) {
                    }
                }
            }
            wordNoDiacritics.add(tempLineWord);
            tempEachWord = intializesImage(tempEachWord);
            tempLineWord = intializesImage(tempLineWord);
        }

        // print wordNoDiacritics and put on one single canvas 	many[wordNoDiacritics] --> one[allWordNoDiacritics]	 																	public void printBinaryObjCross(int[][] objImageCross, String position, int line, int index) throws IOException
        int[][] allWordNoDiacritics = new int[imagebinary.length][imagebinary[0].length]; // print all word on single canvas (followed based on TOP and BOTTOM)
        allWordNoDiacritics = intializesImage(allWordNoDiacritics);

        for (int i = 0; i < wordNoDiacritics.size(); i++) {
            //printBinaryObjCross(wordNoDiacritics.get(i),"noDiacritics",(i+1),0); // PRINT TEXT: print on directory one to one
            for (int y = 0; y < wordNoDiacritics.get(i).length; y++) {
                for (int x = 0; x < wordNoDiacritics.get(i)[0].length; x++) {
                    if (wordNoDiacritics.get(i)[y][x] == 0) {
                        allWordNoDiacritics[y][x] = 0;
                    }
                }
            }

        }

        // detect and strikes all diacritics(not include its' word) [convert 0 to 1~>each line word] [DIACRITIC ONLY]
        int[][] diacriticsNoWord = new int[imagebinary.length][imagebinary[0].length]; // single canvas that contains all diacritics only
        diacriticsNoWord = imagebinary;
        for (int i = 0; i < wordNoDiacritics.size(); i++) {
            for (int y = 0; y < imagebinary.length; y++) {
                for (int x = 0; x < imagebinary[0].length; x++) {
                    if (wordNoDiacritics.get(i)[y][x] == 0) {
                        diacriticsNoWord[y][x] = 1;
                    }
                }
            }
        }

        //printBinaryObjCross(diacriticsNoWord,"DiacriticsOnly",0,0); // PRINT TEXT:print diacritics

        // Capture each diacritics object and put into the line(project on its' line)
        int[][] tempdiacriticsNoWord = diacriticsNoWord; // used to be removed diacritics one  by one  from this screen
        ArrayList<int[][]> oneDiacriticSpace = new ArrayList<int[][]>(); // hold each of diacritics one diacritics by one container of array
        ArrayList<int[][]> lineWord = new ArrayList<int[][]>(); // hold each line of diacritics

        //################### START baselinePoint
        for (int i = 0; i < baselinePoint.size() - 1; i++) // baseline minus 1 -> ONLY SPACE BETWEEN THEM NEED TO BE PROJECTED (all baseline)
        {
            for (int y = baselinePoint.get(i); y <= baselinePoint.get(i + 1); y++) // 	CAPTURE ONE DIACRITICS OF ONE POINT (along between space baseline)
            {
                for (int x = 0; x < tempdiacriticsNoWord[0].length; x++) {
                    if (tempdiacriticsNoWord[y][x] == 0) {
                        int xPoint = x;
                        int yPoint = y;

                        int[][] tempOneDiacriticSpace = new int[tempdiacriticsNoWord.length][tempdiacriticsNoWord[0].length];
                        tempOneDiacriticSpace = intializesImage(tempOneDiacriticSpace);

                        tempOneDiacriticSpace = object(yPoint, xPoint, tempdiacriticsNoWord); // strikes on one diacritics
                        oneDiacriticSpace.add(tempOneDiacriticSpace); // add one diacritics on ArrayList<int[][]> oneDiacriticSpace ERROR

                        // purge of one detected diacritics (int[][] tempOneDiacriticSpace) from (int[][] tempdiacriticsNoWord)
                        for (int yaxis = 0; yaxis < tempOneDiacriticSpace.length; yaxis++) {
                            for (int xaxis = 0; xaxis < tempOneDiacriticSpace[0].length; xaxis++) {
                                if (tempOneDiacriticSpace[yaxis][xaxis] == 0) {
                                    tempdiacriticsNoWord[yaxis][xaxis] = 1;
                                }
                            }
                        }
                    }

                }

            }

            //time to check the status position of every diacritics
            int[][] topLine = new int[imagebinary.length][imagebinary[0].length]; // diacritics result to be placed on top will printed on this
            topLine = intializesImage(topLine);
            int[][] bottomLine = new int[imagebinary.length][imagebinary[0].length]; // diacritics result to be placed on bottom will printed on this
            bottomLine = intializesImage(bottomLine);
            ArrayList<String> position = new ArrayList<String>(); // position of diacritics
            for (int index = 0; index < oneDiacriticSpace.size(); index++) // oneDiacriticSpace - one diacritics object is on one container array
            {
                int pointMaxMin[] = calFrequencyMaxMinY(oneDiacriticSpace.get(index)); // Find the minimum(top) frequency and maximum(bottom) frequency of height  AND the left frequency and right frequency ~~> [return new int[] {pointLeft, pointRight, pointTop, pointBottom};]
                String possessObj = pointMinMaxFrequencyV2(pointMaxMin, allWordNoDiacritics); // Find the object belong to with line either top or bottom ~~>[return String winPointTemp;]  ( calculate[pointMaxMin[]] the different range with actual image[imagebinary] )
                position.add(possessObj);
                if (possessObj == "TOP") {
                    for (int y = 0; y < imagebinary.length; y++) {
                        for (int x = 0; x < imagebinary[0].length; x++) {
                            if (oneDiacriticSpace.get(index)[y][x] == 0) {
                                topLine[y][x] = 0;
                            }
                        }
                    }
                } else if (possessObj == "BOTTOM") {
                    for (int y = 0; y < imagebinary.length; y++) {
                        for (int x = 0; x < imagebinary[0].length; x++) {
                            if (oneDiacriticSpace.get(index)[y][x] == 0) {
                                bottomLine[y][x] = 0;
                            }
                        }
                    }
                }

            }

            //TESTING NEW ALGORITHM
            if (i == 0) {
                lineWord.add(topLine);
                lineWord.add(bottomLine);
            } else if (i >= 1) {
                // special case: top line placed on single last lineword
                int[][] tempLineWordBeforeSingle = lineWord.get(lineWord.size() - 1);
                for (int y = 0; y < topLine.length; y++) {
                    for (int x = 0; x < topLine[0].length; x++) {
                        if (topLine[y][x] == 0) {
                            tempLineWordBeforeSingle[y][x] = 0;
                        }
                    }
                }
                lineWord.set(lineWord.size() - 1, tempLineWordBeforeSingle);

                lineWord.add(bottomLine);
            }
            //END TESTING NEW ALGORITHM

            oneDiacriticSpace = new ArrayList<int[][]>();// flash the value
        }
        //################### END baselinePoint

        // special case for first TOP on first 	INDEX [diacriticsNoWord [(0)-baselinePoint.get(0)] ] --> lineWord.get(0)
        int[][] tempTopIndex = lineWord.get(0);
        for (int y = 0; y <= baselinePoint.get(0); y++) {
            for (int x = 0; x < this.imagebinary[0].length; x++) // [try this.imagebinary]
            {
                if (this.imagebinary[y][x] == 0) {
                    tempTopIndex[y][x] = 0;
                }
            }
        }
        lineWord.set(0, tempTopIndex);

        // special case for BOTTOM on last INDEX
        int[][] tempBottomIndex = lineWord.get(lineWord.size() - 1);
        for (int y = baselinePoint.get(baselinePoint.size() - 1); y < imagebinary.length; y++) {
            for (int x = 0; x < this.imagebinary[0].length; x++) {
                if (this.imagebinary[y][x] == 0)      // IF THE IMAGE GOT PROBLEM 1 THIS IS THE POINT [try this.imagebinary]
                {
                    tempBottomIndex[y][x] = 0;
                }
            }
        }
        lineWord.set(lineWord.size() - 1, tempBottomIndex);

        // add word into the line	[wordNoDiacritics] --> [lineWord] = [actualLineWord]
        ArrayList<int[][]> actualLineWord = new ArrayList<int[][]>(); // hold each line of word
        for (int i = 0; i < wordNoDiacritics.size(); i++) {
            int[][] tempactualLineWord = new int[imagebinary.length][imagebinary[0].length];
            tempactualLineWord = intializesImage(tempactualLineWord);
            for (int y = 0; y < imagebinary.length; y++) {
                for (int x = 0; x < imagebinary[0].length; x++) {
                    if (wordNoDiacritics.get(i)[y][x] == 0) {
                        tempactualLineWord[y][x] = 0; // [wordNoDiacritics]
                    }
                }
            }
            for (int y = 0; y < imagebinary.length; y++) {
                for (int x = 0; x < imagebinary[0].length; x++) {
                    if (lineWord.get(i)[y][x] == 0) // SET OF DIACRITICS (DOESNT HAVE WORD) FOLLOWED BY TOP AND BOTTOM
                    {
                        tempactualLineWord[y][x] = 0; // [wordNoDiacritics]
                    }
                }
            }
            actualLineWord.add(tempactualLineWord);
        }

        // LETS' PRINT :)
        for (int i = 0; i < actualLineWord.size(); i++) {
            int top = findTopCor(actualLineWord.get(i));
            int bottom = findBottomCor(actualLineWord.get(i));
            int[][] tempactualLine = new int[((bottom + 1) - (top - 1) + 1)][actualLineWord.get(i)[0].length];
            int tempYaxis = 0;
            int tempXaxis = 0;

            for (int y = (top - 1); y <= (bottom + 1); y++)    //for (int y=0 ; y<actualLineWord.get(i).length ; y++)
            {
                for (int x = 0; x < actualLineWord.get(i)[0].length; x++) {
                    if (actualLineWord.get(i)[y][x] == 0) {
                        tempactualLine[tempYaxis][tempXaxis] = 0;
                        tempXaxis++;
                    } else if (actualLineWord.get(i)[y][x] == 1) {
                        tempactualLine[tempYaxis][tempXaxis] = 1;
                        tempXaxis++;
                    }
                }
                tempXaxis = 0;
                tempYaxis++;
            }
            tempXaxis = 0;
            tempYaxis = 0;
            actualLine.add(tempactualLine);

        }


    }


    /*
     * To initialize the whole image as "1"(white)
     */
    public int[][] intializesImage(int[][] imagebinary) {
        int[][] tempimagebinary = new int[imagebinary.length][imagebinary[0].length];

        for (int y = 0; y < imagebinary.length; y++) {
            for (int x = 0; x < imagebinary[0].length; x++) {
                tempimagebinary[y][x] = 1;
            }
        }

        return tempimagebinary;
    }

    /*
     * Find frequency of Y-Axis (height)
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

    /*
     * Print binary all specific the object cross into directory (C:\Users\MSI\starlight\tashih\binary)
     */
    public void printBinaryObjCross(int[][] objImageCross, String position, int line, int index) throws IOException {
        FileWriter writer;
        String nameFile = "C:/Users/MSI/starlight/tashih/binary/" + "line_" + line + " position_" + position + " index_" + index + " " + new Long(new Date().getTime()).toString() + ".txt";
        File file = new File(nameFile);
        if (file.exists()) {
            //System.out.println("Found");
            writer = new FileWriter(file, true);
        } else {
            //System.out.println("Not Found");
            writer = new FileWriter(file);

            for (int y = 0; y < objImageCross.length; y++) {
                for (int x = 0; x < objImageCross[1].length; x++) {
                    if (objImageCross[y][x] == 1) {
                        writer.append("1");
                    } else if (objImageCross[y][x] == 0) {
                        writer.append("0");
                    }
                }
                writer.append(System.lineSeparator());
            }

        }

    }


    /*
     * Find top coordinate of each object
     */
    public int findTopCor(int[][] objImageCross) {
        int top = 0;

        boolean stopLoop = false;

        for (int y = 0; y < objImageCross.length; y++) {
            for (int x = 0; x < objImageCross[1].length; x++) {
                if (objImageCross[y][x] == 0) {
                    top = y;
                    stopLoop = true;
                    break;
                }
            }

            if (stopLoop == true) {
                break;
            }
        }

        return top;
    }


    /*
     * Find bottom coordinate of each object
     */
    public int findBottomCor(int[][] objImageCross) {
        int bottom = 0;
        boolean stopLoop = false;

        for (int y = objImageCross.length - 1; y >= 0; y--) {
            for (int x = 0; x < objImageCross[1].length; x++) {
                if (objImageCross[y][x] == 0) {
                    bottom = y;
                    stopLoop = true;
                    break;
                }
            }
            if (stopLoop == true) {
                break;
            }
        }
        return bottom;
    }

    /*
     * Find the minimum(top) frequency and maximum(bottom) frequency of height  AND the left frequency and right frequency
     * return new int[] {pointLeft, pointRight, pointTop, pointBottom};
     */
    public int[] calFrequencyMaxMinY(int[][] objImage) {
        int[] arrayFreqHeight = new int[objImage.length];
        int countFreqHeight = 0;
        int[] arrayFreqWidth = new int[objImage[1].length];
        int countFreqWidth = 0;

        int pointBottom = 0;
        int pointTop = 0;
        int pointLeft = 0;
        int pointRight = 0;

        // calculate frequency HEIGHT
        for (int y = 0; y < objImage.length; y++) {
            for (int x = 0; x < objImage[1].length; x++) {
                if (objImage[y][x] == 0) {
                    countFreqHeight++;
                }
            }
            arrayFreqHeight[y] = countFreqHeight;
            countFreqHeight = 0;
        }

        // calculate frequency WIDTH
        for (int x = 0; x < objImage[1].length; x++) {
            for (int y = 0; y < objImage.length; y++) {
                if (objImage[y][x] == 0) {
                    countFreqWidth++;
                }
            }
            arrayFreqWidth[x] = countFreqWidth;
            countFreqWidth = 0;
        }

        // find the Left
        for (int x = 0; x < objImage[1].length; x++) {
            if (arrayFreqWidth[x] > 0) {
                pointLeft = x;
                break;
            }
        }

        // find the Right
        for (int x = objImage[1].length - 1; x >= 0; x--) {
            if (arrayFreqWidth[x] > 0) {
                pointRight = x;
                break;
            }
        }

        // find the TOP
        for (int y = 0; y < objImage.length; y++) {
            if (arrayFreqHeight[y] > 0) {
                pointTop = y;
                break;
            }
        }

        // find the BOTTOM
        for (int y = objImage.length - 1; y >= 0; y--) {
            if (arrayFreqHeight[y] > 0) {
                pointBottom = y;
                break;
            }
        }
        return new int[]{pointLeft, pointRight, pointTop, pointBottom};
    }

    /*
     * Find the neighbor point
     */
    public int[][] object(int yaxis, int xaxis, int[][] getImagebinary) {
        boolean pointer1 = false; //SECTION 1
        boolean pointer2 = false; //SECTION 2
        boolean pointer3 = false; //SECTION 3
        boolean pointer4 = false; //SECTION 4
        boolean pointer5 = false; //SECTION 5
        boolean pointer6 = false; //SECTION 6
        boolean pointer7 = false; //SECTION 7
        boolean pointer8 = false; //SECTION 8

        // initialize actImagebinary ~~> actual binary
        int[][] actImagebinary = getImagebinary;

        // initialize tempImagebinary ~~> finalize binary
        int[][] tempImagebinary = new int[actImagebinary.length][actImagebinary[1].length];

        // to make tempImagebinary as white canvas
        for (int y = 0; y < actImagebinary.length; y++) {
            for (int x = 0; x < actImagebinary[1].length; x++) {
                tempImagebinary[y][x] = 1;
            }
        }

        // to make point first dot on tempImagebinary as reference to check its neighbor
        tempImagebinary[yaxis][xaxis] = 0;

        /* CHECK NEIGHBOR
         * SECTION 1 : <start from LEFT to RIGHT then TOP to BOTTOM>
         * SECTION 2 : <start from LEFT to RIGHT then BOTTOM to TOP>
         * SECTION 3 : <start from RIGHT to LEFT then TOP to BOTTOM>
         * SECTION 4 : <start from RIGHT to LEFT then BOTTOM to TOP>
         *
         * SECTION 5 : <start from TOP to BOTTOM then LEFT to RIGHT>
         * SECTION 6 : <start from TOP to BOTTOM then RIGHT to LEFT>
         * SECTION 7 : <start from BOTTOM to TOP then LEFT to RIGHT>
         * SECTION 8 : <start from BOTTOM to TOP then RIGHT to LEFT>
         *
         */

        // SECTION 1 : <start from LEFT to RIGHT then TOP to BOTTOM>
        for (int y = 1; y < actImagebinary.length - 1; y++) {
            for (int x = 1; x < actImagebinary[1].length - 1; x++) {
                int yT = y - 1; // y back (TOP)
                int yC = y;    // y current (CENTER)
                int yB = y + 1; // y front (BOTTOM)

                int xL = x - 1; // x back (LEFT)
                int xC = x;    // x current (CENTER)
                int xR = x + 1; // x front (RIGHT)

                if (actImagebinary[yT][xL] == 0)    // SECTION A : <y-top x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer1 = true;
                    }
                }

                if (actImagebinary[yT][xC] == 0)    // SECTION B : <y-top x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer1 = true;
                    }
                }

                if (actImagebinary[yT][xR] == 0)    // SECTION C : <y-top x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer1 = true;
                    }
                }

                if (actImagebinary[yC][xL] == 0)    // SECTION D : <y-center x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer1 = true;
                    }
                }

                if (actImagebinary[yC][xC] == 0)    // SECTION E : <y-center x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer1 = true;
                    }
                }

                if (actImagebinary[yC][xR] == 0)    // SECTION F : <y-center x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer1 = true;
                    }
                }

                if (actImagebinary[yB][xL] == 0)    // SECTION G : <y-bottom x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer1 = true;
                    }
                }

                if (actImagebinary[yB][xC] == 0)    // SECTION H : <y-bottom x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer1 = true;
                    }
                }

                if (actImagebinary[yB][xR] == 0)    // SECTION I : <y-bottom x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer1 = true;
                    }
                }

                if (actImagebinary[y][x] == 0 && pointer1 == true) {
                    tempImagebinary[y][x] = 0;
                    actImagebinary[y][x] = 1;

                }
                pointer1 = false;
            }
        }

        // SECTION 2 : <start from LEFT to RIGHT then BOTTOM to TOP>
        for (int y = actImagebinary.length - 2; y > 0; y--) {
            for (int x = 1; x < actImagebinary[1].length - 1; x++) {
                int yT = y - 1; // y back (TOP)
                int yC = y;    // y current (CENTER)
                int yB = y + 1; // y front (BOTTOM)

                int xL = x - 1; // x back (LEFT)
                int xC = x;    // x current (CENTER)
                int xR = x + 1; // x front (RIGHT)

                if (actImagebinary[yT][xL] == 0)    // SECTION A : <y-top x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer2 = true;
                    }
                }

                if (actImagebinary[yT][xC] == 0)    // SECTION B : <y-top x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer2 = true;
                    }
                }

                if (actImagebinary[yT][xR] == 0)    // SECTION C : <y-top x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer2 = true;
                    }
                }

                if (actImagebinary[yC][xL] == 0)    // SECTION D : <y-center x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer2 = true;
                    }
                }

                if (actImagebinary[yC][xC] == 0)    // SECTION E : <y-center x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer2 = true;
                    }
                }

                if (actImagebinary[yC][xR] == 0)    // SECTION F : <y-center x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer2 = true;
                    }
                }

                if (actImagebinary[yB][xL] == 0)    // SECTION G : <y-bottom x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer2 = true;
                    }
                }

                if (actImagebinary[yB][xC] == 0)    // SECTION H : <y-bottom x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer2 = true;
                    }
                }

                if (actImagebinary[yB][xR] == 0)    // SECTION I : <y-bottom x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer2 = true;
                    }
                }

                if (actImagebinary[y][x] == 0 && pointer2 == true) {
                    tempImagebinary[y][x] = 0;
                    actImagebinary[y][x] = 1;

                }
                pointer2 = false;
            }
        }

        // SECTION 3 : <start from RIGHT to LEFT then TOP to BOTTOM>
        for (int y = 1; y < actImagebinary.length - 1; y++) {
            for (int x = actImagebinary[1].length - 2; x > 0; x--) {
                int yT = y - 1; // y back (TOP)
                int yC = y;    // y current (CENTER)
                int yB = y + 1; // y front (BOTTOM)

                int xL = x - 1; // x back (LEFT)
                int xC = x;    // x current (CENTER)
                int xR = x + 1; // x front (RIGHT)

                if (actImagebinary[yT][xL] == 0)    // SECTION A : <y-top x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer3 = true;
                    }
                }

                if (actImagebinary[yT][xC] == 0)    // SECTION B : <y-top x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer3 = true;
                    }
                }

                if (actImagebinary[yT][xR] == 0)    // SECTION C : <y-top x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer3 = true;
                    }
                }

                if (actImagebinary[yC][xL] == 0)    // SECTION D : <y-center x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer3 = true;
                    }
                }

                if (actImagebinary[yC][xC] == 0)    // SECTION E : <y-center x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer3 = true;
                    }
                }

                if (actImagebinary[yC][xR] == 0)    // SECTION F : <y-center x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer3 = true;
                    }
                }

                if (actImagebinary[yB][xL] == 0)    // SECTION G : <y-bottom x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer3 = true;
                    }
                }

                if (actImagebinary[yB][xC] == 0)    // SECTION H : <y-bottom x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer3 = true;
                    }
                }

                if (actImagebinary[yB][xR] == 0)    // SECTION I : <y-bottom x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer3 = true;
                    }
                }

                if (actImagebinary[y][x] == 0 && pointer3 == true) {
                    tempImagebinary[y][x] = 0;
                    actImagebinary[y][x] = 1;

                }
                pointer3 = false;
            }
        }

        // SECTION 4 : <start from RIGHT to LEFT then BOTTOM to TOP>
        for (int y = actImagebinary.length - 2; y > 0; y--) {
            for (int x = actImagebinary[1].length - 2; x > 0; x--) {
                int yT = y - 1; // y back (TOP)
                int yC = y;    // y current (CENTER)
                int yB = y + 1; // y front (BOTTOM)

                int xL = x - 1; // x back (LEFT)
                int xC = x;    // x current (CENTER)
                int xR = x + 1; // x front (RIGHT)

                if (actImagebinary[yT][xL] == 0)    // SECTION A : <y-top x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer4 = true;
                    }
                }

                if (actImagebinary[yT][xC] == 0)    // SECTION B : <y-top x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer4 = true;
                    }
                }

                if (actImagebinary[yT][xR] == 0)    // SECTION C : <y-top x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer4 = true;
                    }
                }

                if (actImagebinary[yC][xL] == 0)    // SECTION D : <y-center x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer4 = true;
                    }
                }

                if (actImagebinary[yC][xC] == 0)    // SECTION E : <y-center x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer4 = true;
                    }
                }

                if (actImagebinary[yC][xR] == 0)    // SECTION F : <y-center x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer4 = true;
                    }
                }

                if (actImagebinary[yB][xL] == 0)    // SECTION G : <y-bottom x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer4 = true;
                    }
                }

                if (actImagebinary[yB][xC] == 0)    // SECTION H : <y-bottom x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer4 = true;
                    }
                }

                if (actImagebinary[yB][xR] == 0)    // SECTION I : <y-bottom x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer4 = true;
                    }
                }

                if (actImagebinary[y][x] == 0 && pointer4 == true) {
                    tempImagebinary[y][x] = 0;
                    actImagebinary[y][x] = 1;

                }
                pointer4 = false;
            }
        }

        // SECTION 5 : <start from TOP to BOTTOM then LEFT to RIGHT>
        for (int x = 1; x < actImagebinary[1].length - 1; x++) {
            for (int y = 1; y < actImagebinary.length - 1; y++) {
                int yT = y - 1; // y back (TOP)
                int yC = y;    // y current (CENTER)
                int yB = y + 1; // y front (BOTTOM)

                int xL = x - 1; // x back (LEFT)
                int xC = x;    // x current (CENTER)
                int xR = x + 1; // x front (RIGHT)

                if (actImagebinary[yT][xL] == 0)    // SECTION A : <y-top x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer5 = true;
                    }
                }

                if (actImagebinary[yT][xC] == 0)    // SECTION B : <y-top x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer5 = true;
                    }
                }

                if (actImagebinary[yT][xR] == 0)    // SECTION C : <y-top x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer5 = true;
                    }
                }

                if (actImagebinary[yC][xL] == 0)    // SECTION D : <y-center x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer5 = true;
                    }
                }

                if (actImagebinary[yC][xC] == 0)    // SECTION E : <y-center x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer5 = true;
                    }
                }

                if (actImagebinary[yC][xR] == 0)    // SECTION F : <y-center x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer5 = true;
                    }
                }

                if (actImagebinary[yB][xL] == 0)    // SECTION G : <y-bottom x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer5 = true;
                    }
                }

                if (actImagebinary[yB][xC] == 0)    // SECTION H : <y-bottom x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer5 = true;
                    }
                }

                if (actImagebinary[yB][xR] == 0)    // SECTION I : <y-bottom x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer5 = true;
                    }
                }

                if (actImagebinary[y][x] == 0 && pointer5 == true) {
                    tempImagebinary[y][x] = 0;
                    actImagebinary[y][x] = 1;

                }
                pointer5 = false;
            }
        }

        // SECTION 6 : <start from TOP to BOTTOM then RIGHT to LEFT>
        for (int x = actImagebinary[1].length - 2; x > 0; x--) {
            for (int y = 1; y < actImagebinary.length - 1; y++) {
                int yT = y - 1; // y back (TOP)
                int yC = y;    // y current (CENTER)
                int yB = y + 1; // y front (BOTTOM)

                int xL = x - 1; // x back (LEFT)
                int xC = x;    // x current (CENTER)
                int xR = x + 1; // x front (RIGHT)

                if (actImagebinary[yT][xL] == 0)    // SECTION A : <y-top x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer6 = true;
                    }
                }

                if (actImagebinary[yT][xC] == 0)    // SECTION B : <y-top x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer6 = true;
                    }
                }

                if (actImagebinary[yT][xR] == 0)    // SECTION C : <y-top x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer6 = true;
                    }
                }

                if (actImagebinary[yC][xL] == 0)    // SECTION D : <y-center x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer6 = true;
                    }
                }

                if (actImagebinary[yC][xC] == 0)    // SECTION E : <y-center x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer6 = true;
                    }
                }

                if (actImagebinary[yC][xR] == 0)    // SECTION F : <y-center x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer6 = true;
                    }
                }

                if (actImagebinary[yB][xL] == 0)    // SECTION G : <y-bottom x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer6 = true;
                    }
                }

                if (actImagebinary[yB][xC] == 0)    // SECTION H : <y-bottom x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer6 = true;
                    }
                }

                if (actImagebinary[yB][xR] == 0)    // SECTION I : <y-bottom x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer6 = true;
                    }
                }

                if (actImagebinary[y][x] == 0 && pointer6 == true) {
                    tempImagebinary[y][x] = 0;
                    actImagebinary[y][x] = 1;

                }
                pointer6 = false;
            }
        }

        // SECTION 7 : <start from BOTTOM to TOP then LEFT to RIGHT>
        for (int x = 1; x < actImagebinary[1].length - 1; x++) {
            for (int y = actImagebinary.length - 2; y > 0; y--) {
                int yT = y - 1; // y back (TOP)
                int yC = y;    // y current (CENTER)
                int yB = y + 1; // y front (BOTTOM)

                int xL = x - 1; // x back (LEFT)
                int xC = x;    // x current (CENTER)
                int xR = x + 1; // x front (RIGHT)

                if (actImagebinary[yT][xL] == 0)    // SECTION A : <y-top x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer7 = true;
                    }
                }

                if (actImagebinary[yT][xC] == 0)    // SECTION B : <y-top x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer7 = true;
                    }
                }

                if (actImagebinary[yT][xR] == 0)    // SECTION C : <y-top x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer7 = true;
                    }
                }

                if (actImagebinary[yC][xL] == 0)    // SECTION D : <y-center x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer7 = true;
                    }
                }

                if (actImagebinary[yC][xC] == 0)    // SECTION E : <y-center x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer7 = true;
                    }
                }

                if (actImagebinary[yC][xR] == 0)    // SECTION F : <y-center x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer7 = true;
                    }
                }

                if (actImagebinary[yB][xL] == 0)    // SECTION G : <y-bottom x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer7 = true;
                    }
                }

                if (actImagebinary[yB][xC] == 0)    // SECTION H : <y-bottom x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer7 = true;
                    }
                }

                if (actImagebinary[yB][xR] == 0)    // SECTION I : <y-bottom x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer7 = true;
                    }
                }

                if (actImagebinary[y][x] == 0 && pointer7 == true) {
                    tempImagebinary[y][x] = 0;
                    actImagebinary[y][x] = 1;

                }
                pointer7 = false;
            }
        }

        // SECTION 8 : <start from BOTTOM to TOP then RIGHT to LEFT>
        for (int x = actImagebinary[1].length - 2; x > 0; x--) {
            for (int y = actImagebinary.length - 2; y > 0; y--) {
                int yT = y - 1; // y back (TOP)
                int yC = y;    // y current (CENTER)
                int yB = y + 1; // y front (BOTTOM)

                int xL = x - 1; // x back (LEFT)
                int xC = x;    // x current (CENTER)
                int xR = x + 1; // x front (RIGHT)

                if (actImagebinary[yT][xL] == 0)    // SECTION A : <y-top x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer8 = true;
                    }
                }

                if (actImagebinary[yT][xC] == 0)    // SECTION B : <y-top x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer8 = true;
                    }
                }

                if (actImagebinary[yT][xR] == 0)    // SECTION C : <y-top x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer8 = true;
                    }
                }

                if (actImagebinary[yC][xL] == 0)    // SECTION D : <y-center x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer8 = true;
                    }
                }

                if (actImagebinary[yC][xC] == 0)    // SECTION E : <y-center x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer8 = true;
                    }
                }

                if (actImagebinary[yC][xR] == 0)    // SECTION F : <y-center x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer8 = true;
                    }
                }

                if (actImagebinary[yB][xL] == 0)    // SECTION G : <y-bottom x-left>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer8 = true;
                    }
                }

                if (actImagebinary[yB][xC] == 0)    // SECTION H : <y-bottom x-center>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer8 = true;
                    }
                }

                if (actImagebinary[yB][xR] == 0)    // SECTION I : <y-bottom x-right>
                {
                    if (tempImagebinary[yT][xL] == 0 || tempImagebinary[yT][xC] == 0 || tempImagebinary[yT][xR] == 0 || tempImagebinary[yC][xL] == 0 || tempImagebinary[yC][xC] == 0 || tempImagebinary[yC][xR] == 0 || tempImagebinary[yB][xL] == 0 || tempImagebinary[yB][xC] == 0 || tempImagebinary[yB][xR] == 0) {
                        pointer8 = true;
                    }
                }

                if (actImagebinary[y][x] == 0 && pointer8 == true) {
                    tempImagebinary[y][x] = 0;
                    actImagebinary[y][x] = 1;

                }
                pointer8 = false;
            }
        }

        // check either if the start point is truly 0 or not [special used on baseline]
        if (actImagebinary[yaxis][xaxis] == 0) {
            tempImagebinary[yaxis][xaxis] = 0;
        }
        if (actImagebinary[yaxis][xaxis] == 1) {
            tempImagebinary[yaxis][xaxis] = 1;
        }

        return tempImagebinary;

    }


    /*
     * print the image in array (int[][] outputImage) (PRINT BINARY)
     */
    public void outputVerse(int[][] outputImage) {
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
