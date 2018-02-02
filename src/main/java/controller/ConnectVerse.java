/*
 * To split word into verse.
 */

package controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ConnectVerse {

    ArrayList<Integer> tempYaxis = new ArrayList<Integer>(); // collection of pieces cutting objects' yAxis start point axis (top to bottom -> 0 to n)
    ArrayList<Integer> tempXaxis = new ArrayList<Integer>(); // collection of pieces cutting objects' xAxis start point axis (left to right -> 0 to n)
    ArrayList<Integer> tempYHeight = new ArrayList<Integer>(); // collection of pieces cutting objects' height
    ArrayList<Integer> tempXWidth = new ArrayList<Integer>();  // collection of pieces cutting objects' Width
    ArrayList<File> inputFiles1 = new ArrayList<File>(); // directory of selected image (raw image)
    private int countObj = 0; // count how many pieces of cutting object they have
    ArrayList<String> topObjFile = new ArrayList<String>(); //collection of File Path directory for parent name on each pieces cutting object picture
    private ArrayList<File> imgVerse = new ArrayList<File>(); // save image verse

    PointObjStop convertImg = new PointObjStop();

    public ConnectVerse(ArrayList<Integer> tempYaxis, ArrayList<Integer> tempXaxis, ArrayList<Integer> tempYHeight, ArrayList<Integer> tempXWidth, ArrayList<File> inputFiles1, int countObj, ArrayList<String> topObjFile) {
        this.tempYaxis = tempYaxis;
        this.tempXaxis = tempXaxis;
        this.tempYHeight = tempYHeight;
        this.tempXWidth = tempXWidth;
        this.inputFiles1 = inputFiles1;
        this.countObj = countObj; //2
        this.topObjFile = topObjFile;

        // NOTE:
        // tempYaxis => tempYaxisStartPoint => tempYaxisStartPoint.add(objstop.getYMarkTop());
        // tempXaxis => tempXaxisStartPoint => tempXaxisStartPoint.add(objstop.getXMarkTop());
        // tempYHeight => tempYHeight.add(objstop.getYMarkHeight());
        // tempXWidth => tempXWidth.add(objstop.getXMarkWidth());
        // inputFiles1 => image already cut by line. ex: 7 line
        // countObj => indexImageCenter => count how many obj they found.
        // topObjFile => topObjFile.add(String.valueOf(r.getType())); ==> to get path for similar image.
    }

    public void cutWord(File picName, String directData) //TEST_ZONE
    {

        int afterXaxisTemp = -1;
        for (int i = 0; i < inputFiles1.size(); i++) {
            for (int count = tempXaxis.size() - 1; count >= 0; count--)  //for (int count = tempXaxis.size() ; count<tempXaxis.size() ; count--)
            {
                // SECTION A (for index
                if (topObjFile.get(count) == inputFiles1.get(i).getAbsolutePath().toString()) {
                    if (i != 0) // if (inputFiles1.get(i-1).getAbsolutePath().toString() != null)
                    {
                        splitWord(tempXaxis.get(count), afterXaxisTemp, inputFiles1.get(i).getAbsolutePath().toString(), -1);
                        afterXaxisTemp = tempXaxis.get(count);
                    } else if (i == 0) {
                        // <SPECIAL CASE : only for first line>
                        splitWord(tempXaxis.get(count), afterXaxisTemp, inputFiles1.get(i).getAbsolutePath().toString(), 0);
                        afterXaxisTemp = tempXaxis.get(count);
                    }
                }
            }

            // Start Right to the Left until meet the point of object
            // SECTION B (process the image on the last LEFT of line image)
            if (i == inputFiles1.size() - 1) //if(inputFiles1.get(i+1).getAbsolutePath().toString() != null)
            {
                // <SPECIAL CASE : only for last line>
                // (the last line image to be counter for and to make "1" to be "0")
                splitWord(0, afterXaxisTemp, inputFiles1.get(i).getAbsolutePath().toString(), 0); // show this is last verse left (last right)
                afterXaxisTemp = -1;
            } else if (i != inputFiles1.size() - 1)  // else if (inputFiles1.get(i+1).getAbsolutePath().toString() == null)
            {
                // (the first image "1")
                splitWord(0, afterXaxisTemp, inputFiles1.get(i).getAbsolutePath().toString(), 1); // show this is last verse left (last right)
                afterXaxisTemp = -1;
            }
        }
        try {
            convertImg.printVerse(picName, directData);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        imgVerse = convertImg.getImageVerse();
    }

    public ArrayList<File> getImageVerse() {
        return imgVerse;
    }

    /*
     * afterXaxis -> include object circle (stop point)
     */
    public void splitWord(int beforeXaxis, int afterXaxis, String fileName, int status) {
        try {
            if (beforeXaxis == 0 && afterXaxis == -1) {
                status = 2;
            }

            int pointafterXaxis = 0; // last point X-axis for last width to pointer
            int pointbeforeXaxis = 0; // start point X-axis for start width to pointer

            File fileNameObj = new File(fileName);

            BufferedImage buffInputImageObj = convertImg.getImageInput(fileNameObj);
            BufferedImage buffOutputImageObj = convertImg.getImageOutput(buffInputImageObj);

            convertImg.drawImage(buffOutputImageObj); // this is to make the image turn to binary and then next step call function of this object will process the binary

            convertImg.frequencyAxis();
            /*
             * to counter last point X-axis for last width to pointer to be used in SECTION C
             */
            pointafterXaxis = convertImg.lastPointWidthXaxis() + 1;

            /*
             * to counter start point X-axis for start width to pointer to be used in SECTION C (IF THE beforeXaxis == 0)
             */
            pointbeforeXaxis = convertImg.startPointWidthXaxis() - 1;
            if (beforeXaxis == 0) {
                beforeXaxis = pointbeforeXaxis;

            }
            // SECTION C : (process image on the last RIGHT of line image) to check either the verse is on last right(-1) or left(have it's own width aka it's own last x-axis point) of the line image then it will use the width(pointafterXaxis) of image to be afterXaxis
            if (afterXaxis != -1) {
                convertImg.cutVerse(beforeXaxis, afterXaxis, status, buffOutputImageObj.getHeight());
            } else if (afterXaxis == -1) {
                convertImg.cutVerse(beforeXaxis, pointafterXaxis, status, buffOutputImageObj.getHeight()); //31/3/2016 5:44 PM//convertImg.cutVerse(beforeXaxis,buffOutputImageObj.getWidth()-1,status,buffOutputImageObj.getHeight()); // this is last verse left (last right)
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}
