package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MarkedRed {

    private static final Logger logger = LoggerFactory.getLogger(MarkedRed.class);

    private ArrayList<File> fileMarkedRed = new ArrayList<File>();
    private ArrayList<File> imgVerse = new ArrayList<File>(); // save image verse

    public void coordinateObj(ArrayList<String> obj, ArrayList<String> topObjFile, ArrayList<File> pathFileNamePic, String directData, ArrayList<File> inputFiles1, File filePicWithoutFrame) //public void coordinateObj(ArrayList<String> obj, ArrayList<String> topObjFile,String pathFileNamePic)
    {
        int indexImageCenter = 0; // count how many obj they found

        ArrayList<Integer> tempYaxis = new ArrayList<Integer>();
        ArrayList<Integer> tempXaxis = new ArrayList<Integer>();
        ArrayList<Integer> tempYHeight = new ArrayList<Integer>();
        ArrayList<Integer> tempXWidth = new ArrayList<Integer>();
        ArrayList<Integer> tempYaxisStartPoint = new ArrayList<Integer>();
        ArrayList<Integer> tempXaxisStartPoint = new ArrayList<Integer>();

        PointObjStop objstop;
        String pathFileObj = "";


        // Find the coordinate based on the object that it get.
        for (String tempObj : obj) {
            objstop = new PointObjStop(); // need to be test for whether it will flush for new object or not

            pathFileObj = directData + "/tashih/binary/extract all object/Cut Alphabet/" + tempObj;
            File fileNameObj = new File(pathFileObj);
            fileNameObj.getParentFile().mkdirs();
            try {
                BufferedImage buffInputImageObj = objstop.getImageInput(fileNameObj);
                BufferedImage buffOutputImageObj = objstop.getImageOutput(buffInputImageObj);
                objstop.drawImage(buffOutputImageObj);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            objstop.frequencyAxis();
            objstop.markObj();
            tempYaxis.add(objstop.getYMarkCenter());
            tempXaxis.add(objstop.getXMarkCenter());
            tempYHeight.add(objstop.getYMarkHeight());
            tempXWidth.add(objstop.getXMarkWidth());
            tempYaxisStartPoint.add(objstop.getYMarkTop());
            tempXaxisStartPoint.add(objstop.getXMarkTop());
        }

        for (int tempCenter : tempYaxis) {
            indexImageCenter++;
        }

        //Mark process from the coordinate that it get into the picture.
        for (int i = 0; i < pathFileNamePic.size(); i++) {
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy@hh-mm-ss");
            String string = pathFileNamePic.get(i).getName();
            String[] parts = string.split("\\.");
            String sPathImage = directData + "/tashih/processed/line with stop/segmentLine" + (i + 1) + "_" + parts[0] + "_(" + ft.format(dNow) + ").jpeg";
            File fPathImage = new File(sPathImage);
            fPathImage.getParentFile().mkdirs();
            fileMarkedRed.add(fPathImage);

            MarkingObjectCircle moc = new MarkingObjectCircle(pathFileNamePic.get(i).getAbsolutePath(), tempYaxis, tempXaxis, tempYHeight, tempXWidth, indexImageCenter, topObjFile);
            ImageIcon imageFile = new ImageIcon(pathFileNamePic.get(i).getAbsolutePath());
            BufferedImage image = new BufferedImage(imageFile.getIconWidth(), imageFile.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            moc.paint(g);
            try {
                ImageIO.write(image, "jpeg", new File(sPathImage));
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

        ConnectVerse cv = new ConnectVerse(tempYaxisStartPoint, tempXaxisStartPoint, tempYHeight, tempXWidth, inputFiles1, indexImageCenter, topObjFile); //TEST_ZONE
        cv.cutWord(filePicWithoutFrame, directData);
        setImgVerse(cv.getImageVerse());



        /*
         * To display/print verse into Jpanel
         */
//		for (int i = 0; i<imgVerse.size(); i++) //displayVerse
//		{
//			ImageIcon picTempOri = new ImageIcon (imgVerse.get(i).getAbsolutePath().toString());
//			JLabel lblTempOri = new JLabel ("", picTempOri, SwingConstants.CENTER);
//			JLabel labelimgOri = new JLabel (imgVerse.get(i).getAbsolutePath().toString(),SwingConstants.CENTER);
//			labelimgOri.setForeground(Color.WHITE);
//
//			panel_Verses.add(addNewPanel);
//			panel_Verses.add(lblTempOri);
//			panel_Verses.add(labelimgOri);
//		}


    }

    public ArrayList<File> getFileMarkedRed() {
        return fileMarkedRed;
    }

    public ArrayList<File> getImgVerse() {
        return imgVerse;
    }

    public void setImgVerse(ArrayList<File> imgVerse) {
        this.imgVerse = imgVerse;
    }

}
