package featureTriangle.main;
/*
 * Testing for tashih
 */

import featureTriangle.api.MyPointProcess;
import featureTriangle.api.MyPointProcess45;
import featureTriangle.api.OtsuThresholder;
import featureTriangle.bean.Bean_Feature;
import featureTriangle.tool.TriScalenes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Triangle {

    private ArrayList<Bean_Feature> beans = new ArrayList<Bean_Feature>();                    //buffer for storing and accessing features.
    private ArrayList<BufferedImage> image_src_arr = new ArrayList<BufferedImage>();        //input images
    private ArrayList<File> files = new ArrayList<File>(); // select image
    private int SIZE;
    private ArrayList<BufferedImage> image_dest_arr = new ArrayList<BufferedImage>();        //output images in list
    private ArrayList<MyPointProcess45> pointProcess45 = new ArrayList<MyPointProcess45>();
    private ArrayList<MyPointProcess> pointProcesses = new ArrayList<MyPointProcess>();
    private ArrayList<Point> points = new ArrayList<Point>();
    private ArrayList<String> file_Name = new ArrayList<String>();
    private ArrayList<String> file_AbsolutePath = new ArrayList<String>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//		File[] arrayfiles = new File[4];
        File file1 = new File("C:/Users/amirul/Documents/Test Atikah Triangle/01_SP1487214617359.jpg");
        File file2 = new File("C:/Users/amirul/Documents/Test Atikah Triangle/02_SP1487214617605.jpg");
        File file3 = new File("C:/Users/amirul/Documents/Test Atikah Triangle/100_0.bmp");
        File file4 = new File("C:/Users/amirul/Documents/Test Atikah Triangle/101_0.bmp");
//
//		arrayfiles[0] = file1;
//		arrayfiles[1] = file2;
//		arrayfiles[2] = file3;
//		arrayfiles[3] = file4;

        ArrayList<File> arrayfiles = new ArrayList<File>();
        arrayfiles.add(file1);
        arrayfiles.add(file2);
        arrayfiles.add(file3);
        arrayfiles.add(file4);

        Triangle triObject = new Triangle();
        triObject.setFilesAndImages(arrayfiles);
        ArrayList<Bean_Feature> beansCollection = triObject.generateFeatures();
        triObject.save(beansCollection);
    }

    public void setFilesAndImages(ArrayList<File> files) {
        if (!this.files.isEmpty())
            this.files.clear();

        if (!beans.isEmpty())
            beans.clear();

        if (!image_src_arr.isEmpty())
            image_src_arr.clear();

        if (!image_dest_arr.isEmpty())
            image_dest_arr.clear();

        if (!pointProcess45.isEmpty())
            pointProcess45.clear();

        if (!pointProcesses.isEmpty())
            pointProcesses.clear();

        if (!points.isEmpty())
            points.clear();

        if (!file_Name.isEmpty())
            file_Name.clear();

        if (!file_AbsolutePath.isEmpty())
            file_AbsolutePath.clear();

        this.files = files;

        if (files.size() != 0) {
            for (int i = 0; i < files.size(); i++) {
                file_Name.add(files.get(i).getName());
                file_AbsolutePath.add(files.get(i).getAbsolutePath().toString());
                try {
                    this.image_src_arr.add(ImageIO.read(files.get(i)));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } else {
//			System.out.println("No file selected");
//			System.out.println("size file : " + files.length);
        }

    }

    public ArrayList<Bean_Feature> generateFeatures() {
        //Points Upper
        ArrayList<Point> points_upper;
        ArrayList<Point> points_upper_upper;
        ArrayList<Point> points_upper_lower;

        //Points Lower
        ArrayList<Point> points_lower;
        ArrayList<Point> points_lower_upper;
        ArrayList<Point> points_lower_lower;

        //Points Left
        ArrayList<Point> points_left;
        ArrayList<Point> points_upper_left;
        ArrayList<Point> points_lower_left;

        //Points Right
        ArrayList<Point> points_right;
        ArrayList<Point> points_upper_right;
        ArrayList<Point> points_lower_right;

        ArrayList<Point> points_left_left_zone;               //LLZ
        ArrayList<Point> points_left_right_zone;              //LRZ
        ArrayList<Point> points_right_left_zone;              //RLZ
        ArrayList<Point> points_right_right_zone;             //RRZ

        //Level 3
        ArrayList<Point> points_left_left_upper_zone;         //LLUZ
        ArrayList<Point> points_left_right_upper_zone;        //LRUZ
        ArrayList<Point> points_right_left_upper_zone;        //RLUZ
        ArrayList<Point> points_right_right_upper_zone;       //RRUZ

        ArrayList<Point> points_left_left_bottom_zone;        //LLBZ
        ArrayList<Point> points_left_right_bottom_zone;       //LRBZ
        ArrayList<Point> points_right_left_bottom_zone;       //RLBZ
        ArrayList<Point> points_right_right_bottom_zone;      //RRBZ

        //Untuk sudut 45 darjah atas
        ArrayList<Point> pointsAtasKiriKiri = new ArrayList<Point>();    //Upper Left Left    :ULL
        ArrayList<Point> pointsAtasKiriKanan = new ArrayList<Point>();   //Upper Left Right   :ULR
        ArrayList<Point> pointsAtasKananKiri = new ArrayList<Point>();   //Upper Right Left   :URL
        ArrayList<Point> pointsAtasKananKanan = new ArrayList<Point>();  //Upper Right Right  :URR

        //Untuk sudut 45 darjah bawah
        ArrayList<Point> pointsBawahKiriKiri = new ArrayList<Point>();   //Lower Left Left    :LLL
        ArrayList<Point> pointsBawahKiriKanan = new ArrayList<Point>();  //Lower Left Right   :LLR
        ArrayList<Point> pointsBawahKananKiri = new ArrayList<Point>();  //Lower Right Left   :LRL
        ArrayList<Point> pointsBawahKananKanan = new ArrayList<Point>(); //Lower Right Right  :LRR

        SIZE = image_src_arr.size();

        for (int i = 0; i < SIZE; i++) {
            OtsuThresholder otsu = new OtsuThresholder();

            // Get raw image data
            Raster raster = image_src_arr.get(i).getData();
            DataBuffer buffer = raster.getDataBuffer();

            DataBufferByte byteBuffer = (DataBufferByte) buffer;
            byte[] srcData = byteBuffer.getData(0);
            byte[] dstData = new byte[srcData.length];

            //to find the best threshold
            int threshold = otsu.doThreshold(srcData, dstData);
//			System.out.println("threshold : "+threshold);
            String filename = file_Name.get(i);//files.get(i).getName();

            if (threshold == 0) {
                image_dest_arr.add(MyPointProcess.Threshold(image_src_arr.get(i), 127));
            } else {
                image_dest_arr.add(MyPointProcess.Threshold(image_src_arr.get(i), threshold));
            }

            //Add all images from JInputDialog into image_dest_arr.
            //The image_dest_arr then will be added into method add into array Point_Processes
            pointProcess45.add(new MyPointProcess45(image_dest_arr.get(i), filename));
            pointProcesses.add(new MyPointProcess(image_dest_arr.get(i), filename));

            //each element from array point process will be invoked and assigned to MyPointProcess class
            MyPointProcess45 process45 = pointProcess45.get(i);
            MyPointProcess process = pointProcesses.get(i);

            BufferedImage image_dest1 = image_dest_arr.get(i);
            points = process.getPoints(image_dest1);                    //For NFV2

            //point in the third element which is started with 0 is a centroid of image
            int y_center = points.get(2).y;
            int x_center = points.get(2).x;

            MyPointProcess.lukisImej(image_dest1);
//			System.out.println("\n");

            //- Get point(coordinate x,y)
            Point centroid = process45.getCentroid(image_dest1);        //For NF45

            Point centroid_upper_left_right = new Point(centroid);        //Upper Left Right  :c_ULR
            Point centroid_upper_right_left = new Point(centroid);      //Upper Right Left  :c_URL
            Point centroid_upper_right_right = new Point(centroid);     //Upper Right Right :c_URR

            Point centroid_lower_left_left = new Point(centroid);       //Lower Left Left   :c_LLL
            Point centroid_lower_left_right = new Point(centroid);      //Lower Left Right  :c_LLR
            Point centroid_lower_right_left = new Point(centroid);      //Lower Right Left  :c_LRL
            Point centroid_lower_right_right = new Point(centroid);     //Lower Right Right :c_LRR

            points = process45.getPoints(image_dest1);                  //Main Image

            pointsAtasKiriKiri = process45.keAtasKiriKiri(image_dest1, centroid);
            pointsAtasKiriKanan = process45.keAtasKiriKanan(image_dest1, centroid_upper_left_right);
            pointsAtasKananKiri = process45.keAtasKananKiri(image_dest1, centroid_upper_right_left);
            pointsAtasKananKanan = process45.keAtasKananKanan(image_dest1, centroid_upper_right_right);

            pointsBawahKiriKiri = process45.keBawahKiriKiri(image_dest1, centroid_lower_left_left);
            pointsBawahKiriKanan = process45.keBawahKiriKanan(image_dest1, centroid_lower_left_right);
            pointsBawahKananKiri = process45.keBawahKananKiri(image_dest1, centroid_lower_right_left);
            pointsBawahKananKanan = process45.keBawahKananKanan(image_dest1, centroid_lower_right_right);

            Point divider = new Point(x_center, y_center);
            points_upper = process.getUpperZone(image_dest1, divider, 0, 0);
            points_lower = process.getLowerZone(image_dest1, divider);

            Point centroid_upper = points_upper.get(2);
            points_upper_upper = process.getUpperUpperZone(image_dest1, centroid_upper);
            points_upper_lower = process.getUpperLowerZone(image_dest1, centroid_upper, divider);

            Point centroid_lower = points_lower.get(2);
            points_lower_upper = process.getLowerUpperZone(image_dest1, divider, centroid_lower);
            points_lower_lower = process.getLowerLowerZone(image_dest1, centroid_lower);

            points_left = process.getLeftZone(image_dest1, divider);
            points_right = process.getRightZone(image_dest1, divider);

            Point centroidLeftZone = points_left.get(2);
            points_left_left_zone = process.getLeftLeftZone(image_dest1, centroidLeftZone);

            Point centroidLeftLeftLeftUpperZone = points_left_left_zone.get(2);
            points_left_left_upper_zone = process.getUpperZone(image_dest1, centroidLeftLeftLeftUpperZone, centroidLeftZone.x, 0);

            Point centroidLeftLeftLeftBottomZone = points_left_left_zone.get(2);
            points_left_left_bottom_zone = process.getLowerZoneExtended(image_dest1, centroidLeftLeftLeftBottomZone, 0, centroidLeftZone.x);

            points_left_right_zone = process.getLeftRightZone(image_dest1, centroidLeftZone, divider);
            Point centroidLeftLeftRightUpperZone = points_left_right_zone.get(2);
            points_left_right_upper_zone = process.getUpperZone(image_dest1, centroidLeftLeftRightUpperZone, divider.x, centroidLeftZone.x);

            Point centroidLeftLeftRightBottomZone = points_left_right_zone.get(2);
            points_left_right_bottom_zone = process.getLowerZoneExtended(image_dest1, centroidLeftLeftRightBottomZone, centroidLeftZone.x, divider.x);

            Point centroidRightZone = points_right.get(2);
            points_right_left_zone = process.getRightLeftZone(image_dest1, divider, centroidRightZone);

            Point centroidRigthLeftUpperZone = points_right_left_zone.get(2);
            points_right_left_upper_zone = process.getUpperZone(image_dest1, centroidRigthLeftUpperZone, centroidRightZone.x, divider.x);

            Point centroidRigthLeftBottomZone = points_right_left_zone.get(2);
            points_right_left_bottom_zone = process.getLowerZoneExtended(image_dest1, centroidRigthLeftBottomZone, divider.x, centroidRightZone.x);

            points_right_right_zone = process.getRightRightZone(image_dest1, centroidRightZone);

            Point centroidRightRightUpperZone = points_right_right_zone.get(2);
            points_right_right_upper_zone = process.getUpperZone(image_dest1, centroidRightRightUpperZone, 0, centroidRightZone.x);

            Point centroidRigthRightBottomZone = points_right_right_zone.get(2);
            points_right_right_bottom_zone = process.getLowerZoneExtended(image_dest1, centroidRigthRightBottomZone, centroidRightZone.x, 0);

            points_lower_left = process.getLowerPointsLeft(image_dest1, divider);
            points_lower_right = process.getLowerPointsRight(image_dest1, divider);
            points_upper_left = process.getUpperPointsLeft(image_dest1, divider);
            points_upper_right = process.getUpperPointsRight(image_dest1, divider);

            //Use the value of point in TriScalenes Method (33zones)
            TriScalenes scalene = new TriScalenes(filename, points);
            TriScalenes scalene_upper = new TriScalenes(filename, points_upper);
            TriScalenes scalene_lower = new TriScalenes(filename, points_lower);

            TriScalenes scalene_upper_upper = new TriScalenes(filename, points_upper_upper);
            TriScalenes scalene_upper_lower = new TriScalenes(filename, points_upper_lower);
            TriScalenes scalene_lower_upper = new TriScalenes(filename, points_lower_upper);
            TriScalenes scalene_lower_lower = new TriScalenes(filename, points_lower_lower);


            TriScalenes scalene_left = new TriScalenes(filename, points_left);
            TriScalenes scalene_right = new TriScalenes(filename, points_right);

            TriScalenes scalene_left_left_zone = new TriScalenes(filename, points_left_left_zone);
            TriScalenes scalene_left_left_upper_zone = new TriScalenes(filename, points_left_left_upper_zone);
            TriScalenes scalene_left_left_lower_zone = new TriScalenes(filename, points_left_left_bottom_zone);
            TriScalenes scalene_left_right_zone = new TriScalenes(filename, points_left_right_zone);

            TriScalenes scalene_left_right_upper_zone = new TriScalenes(filename, points_left_right_upper_zone);
            TriScalenes scalene_left_right_lower_zone = new TriScalenes(filename, points_left_right_bottom_zone);
            TriScalenes scalene_right_left_zone = new TriScalenes(filename, points_right_left_zone);

            TriScalenes scalene_right_left_upper_zone = new TriScalenes(filename, points_right_left_upper_zone);
            TriScalenes scalene_right_left_lower_zone = new TriScalenes(filename, points_right_left_bottom_zone);
            TriScalenes scalene_right_right_zone = new TriScalenes(filename, points_right_right_zone);

            TriScalenes scalene_right_right_upper_zone = new TriScalenes(filename, points_right_right_upper_zone);
            TriScalenes scalene_right_right_lower_zone = new TriScalenes(filename, points_right_right_bottom_zone);

            TriScalenes scalene_points_upper_left = new TriScalenes(filename, points_upper_left);
            TriScalenes scalene_points_upper_right = new TriScalenes(filename, points_upper_right);
            TriScalenes scalene_points_lower_left = new TriScalenes(filename, points_lower_left);
            TriScalenes scalene_points_lower_right = new TriScalenes(filename, points_lower_right);

            TriScalenes sALL = new TriScalenes(filename, pointsAtasKiriKiri);
            TriScalenes sALR = new TriScalenes(filename, pointsAtasKiriKanan);
            TriScalenes sARL = new TriScalenes(filename, pointsAtasKananKiri);
            TriScalenes sARR = new TriScalenes(filename, pointsAtasKananKanan);

            TriScalenes sBLL = new TriScalenes(filename, pointsBawahKiriKiri);
            TriScalenes sBLR = new TriScalenes(filename, pointsBawahKiriKanan);
            TriScalenes sBRL = new TriScalenes(filename, pointsBawahKananKiri);
            TriScalenes sBRR = new TriScalenes(filename, pointsBawahKananKanan);

            //Feature Extraction - 33zones produces 297features
            //13 April 2015

            // Start New Code - AUTHOR: Amirul Ramzani (04/03/2017 7:18 PM)
            String database_table = "database_table";//file_Name.get(i); // Picture Name
            String type = file_AbsolutePath.get(i);//file_Name.get(i); // Path Picture
            String nameForTextFile = "nameForTextFile";//file_Name.get(i);
            //End New Code - AUTHOR: Amirul Ramzani

            scalene.getTrianglePerimeter(database_table, type, image_dest1, "Main Triangle", nameForTextFile);
            scalene_upper.getTrianglePerimeter(database_table, type, image_dest1, "Points Upper", nameForTextFile);
            scalene_lower.getTrianglePerimeter(database_table, type, image_dest1, "Points Lower", nameForTextFile);

            scalene_upper_upper.getTrianglePerimeter(database_table, type, image_dest1, "Upper Upper Zone", nameForTextFile);
            scalene_upper_lower.getTrianglePerimeter(database_table, type, image_dest1, "Upper Lower Zone", nameForTextFile);
            scalene_lower_upper.getTrianglePerimeter(database_table, type, image_dest1, "Lower Upper Zone", nameForTextFile);
            scalene_lower_lower.getTrianglePerimeter(database_table, type, image_dest1, "Lower Lower Zone", nameForTextFile);

            scalene_left.getTrianglePerimeter(database_table, type, image_dest1, "Left Zone", nameForTextFile);
            scalene_right.getTrianglePerimeter(database_table, type, image_dest1, "Right Zone", nameForTextFile);

            scalene_left_left_zone.getTrianglePerimeter(database_table, type, image_dest1, "Left Left Zone", nameForTextFile);
            scalene_left_right_zone.getTrianglePerimeter(database_table, type, image_dest1, "Left Right Zone", nameForTextFile);
            scalene_right_left_zone.getTrianglePerimeter(database_table, type, image_dest1, "Right Left Zone", nameForTextFile);
            scalene_right_right_zone.getTrianglePerimeter(database_table, type, image_dest1, "Right Right Zone", nameForTextFile);

            scalene_left_left_upper_zone.getTrianglePerimeter(database_table, type, image_dest1, "Left Left Upper Zone", nameForTextFile);
            scalene_left_left_lower_zone.getTrianglePerimeter(database_table, type, image_dest1, "Left Left Lower Zone", nameForTextFile);

            scalene_left_right_upper_zone.getTrianglePerimeter(database_table, type, image_dest1, "Left Right Upper Zone", nameForTextFile);
            scalene_left_right_lower_zone.getTrianglePerimeter(database_table, type, image_dest1, "Left Right Lower Zone", nameForTextFile);

            scalene_right_left_upper_zone.getTrianglePerimeter(database_table, type, image_dest1, "Right Left Upper Zone", nameForTextFile);
            scalene_right_left_lower_zone.getTrianglePerimeter(database_table, type, image_dest1, "Right Left Lower Zone", nameForTextFile);

            scalene_right_right_upper_zone.getTrianglePerimeter(database_table, type, image_dest1, "Right Right Upper Zone", nameForTextFile);
            scalene_right_right_lower_zone.getTrianglePerimeter(database_table, type, image_dest1, "Right Right Lower Zone", nameForTextFile);

            scalene_points_upper_left.getTrianglePerimeter(database_table, type, image_dest1, "Points Upper Left", nameForTextFile);
            scalene_points_upper_right.getTrianglePerimeter(database_table, type, image_dest1, "Points Upper Right", nameForTextFile);
            scalene_points_lower_left.getTrianglePerimeter(database_table, type, image_dest1, "Points Lower Left", nameForTextFile);
            scalene_points_lower_right.getTrianglePerimeter(database_table, type, image_dest1, "Points Lower Right", nameForTextFile);

            //Bahagian Atas 45 darjah
            sALL.getTrianglePerimeter(database_table, type, image_dest1, "Top Left Left Zone", nameForTextFile);
            sALR.getTrianglePerimeter(database_table, type, image_dest1, "Top Left Right Zone", nameForTextFile);
            sARL.getTrianglePerimeter(database_table, type, image_dest1, "Top Right Left Zone", nameForTextFile);
            sARR.getTrianglePerimeter(database_table, type, image_dest1, "Top Right Right Zone", nameForTextFile);

            //Bahagian Bawah 45 darjah
            sBLL.getTrianglePerimeter(database_table, type, image_dest1, "Bottom Left Left Zone", nameForTextFile);
            sBLR.getTrianglePerimeter(database_table, type, image_dest1, "Bottom Left RIght Zone", nameForTextFile);
            sBRL.getTrianglePerimeter(database_table, type, image_dest1, "Bottom Right Left Zone", nameForTextFile);
            sBRR.getTrianglePerimeter(database_table, type, image_dest1, "Bottom Right Right Zone", nameForTextFile);

            /*
             * Main Triangle
             */
            String s_fname = scalene.getFileName();
            float s_cbya = (float) scalene.getRatioCbyA();
            float s_abyb = (float) scalene.getRatioAbyB();
            float s_bbyc = (float) scalene.getRatioBbyC();
            float s_A = (float) scalene.getAngleA();
            float s_B = (float) scalene.getAngleB();
            float s_C = (float) scalene.getAngleC();
            float s_GBA = (float) scalene.getGradientBA();
            float s_GBC = (float) scalene.getGradientBC();
            float s_GCA = (float) scalene.getGradientCA();

            /*
             * Upper Zone 02
             */

            float su_cbya = (float) scalene_upper.getRatioCbyA();
            float su_abyb = (float) scalene_upper.getRatioAbyB();
            float su_bbyc = (float) scalene_upper.getRatioBbyC();
            float su_A = (float) scalene_upper.getAngleA();
            float su_B = (float) scalene_upper.getAngleB();
            float su_C = (float) scalene_upper.getAngleC();
            float su_GBA = (float) scalene_upper.getGradientBA();
            float su_GBC = (float) scalene_upper.getGradientBC();
            float su_GCA = (float) scalene_upper.getGradientCA();

            /*
             * Lower Zone 03
             */

            float sl_cbya = (float) scalene_lower.getRatioCbyA();
            float sl_abyb = (float) scalene_lower.getRatioAbyB();
            float sl_bbyc = (float) scalene_lower.getRatioBbyC();
            float sl_A = (float) scalene_lower.getAngleA();
            float sl_B = (float) scalene_lower.getAngleB();
            float sl_C = (float) scalene_lower.getAngleC();
            float sl_GBA = (float) scalene_lower.getGradientBA();
            float sl_GBC = (float) scalene_lower.getGradientBC();
            float sl_GCA = (float) scalene_lower.getGradientCA();

            /*
             * Top Upper Zone 04
             */

            float stu_cbya = (float) scalene_upper_upper.getRatioCbyA();
            float stu_abyb = (float) scalene_upper_upper.getRatioAbyB();
            float stu_bbyc = (float) scalene_upper_upper.getRatioBbyC();
            float stu_A = (float) scalene_upper_upper.getAngleA();
            float stu_B = (float) scalene_upper_upper.getAngleB();
            float stu_C = (float) scalene_upper_upper.getAngleC();
            float stu_GBA = (float) scalene_upper_upper.getGradientBA();
            float stu_GBC = (float) scalene_upper_upper.getGradientBC();
            float stu_GCA = (float) scalene_upper_upper.getGradientCA();

            /*
             * Top Lower Zone 05
             */
            float stl_cbya = (float) scalene_upper_lower.getRatioCbyA();
            float stl_abyb = (float) scalene_upper_lower.getRatioAbyB();
            float stl_bbyc = (float) scalene_upper_lower.getRatioBbyC();
            float stl_A = (float) scalene_upper_lower.getAngleA();
            float stl_B = (float) scalene_upper_lower.getAngleB();
            float stl_C = (float) scalene_upper_lower.getAngleC();
            float stl_GBA = (float) scalene_upper_lower.getGradientBA();
            float stl_GBC = (float) scalene_upper_lower.getGradientBC();
            float stl_GCA = (float) scalene_upper_lower.getGradientCA();

            /*
             * Bottom Upper Zone 06
             */
            float sbu_cbya = (float) scalene_lower_upper.getRatioCbyA();
            float sbu_abyb = (float) scalene_lower_upper.getRatioAbyB();
            float sbu_bbyc = (float) scalene_lower_upper.getRatioBbyC();
            float sbu_A = (float) scalene_lower_upper.getAngleA();
            float sbu_B = (float) scalene_lower_upper.getAngleB();
            float sbu_C = (float) scalene_lower_upper.getAngleC();
            float sbu_GBA = (float) scalene_lower_upper.getGradientBA();
            float sbu_GBC = (float) scalene_lower_upper.getGradientBC();
            float sbu_GCA = (float) scalene_lower_upper.getGradientCA();

            /*
             * Bottom Lower Zone 07
             */
            float sbl_cbya = (float) scalene_lower_lower.getRatioCbyA();
            float sbl_abyb = (float) scalene_lower_lower.getRatioAbyB();
            float sbl_bbyc = (float) scalene_lower_lower.getRatioBbyC();
            float sbl_A = (float) scalene_lower_lower.getAngleA();
            float sbl_B = (float) scalene_lower_lower.getAngleB();
            float sbl_C = (float) scalene_lower_lower.getAngleC();
            float sbl_GBA = (float) scalene_lower_lower.getGradientBA();
            float sbl_GBC = (float) scalene_lower_lower.getGradientBC();
            float sbl_GCA = (float) scalene_lower_lower.getGradientCA();

            /*
             * Left Zone 08
             */
            float s_Lcbya = (float) scalene_left.getRatioCbyA();
            float s_Labyb = (float) scalene_left.getRatioAbyB();
            float s_Lbbyc = (float) scalene_left.getRatioBbyC();
            float s_LA = (float) scalene_left.getAngleA();
            float s_LB = (float) scalene_left.getAngleB();
            float s_LC = (float) scalene_left.getAngleC();
            float s_LGBA = (float) scalene_left.getGradientBA();
            float s_LGBC = (float) scalene_left.getGradientBC();
            float s_LGCA = (float) scalene_left.getGradientCA();

            /*
             * Right Zone 09
             */

            float s_Rcbya = (float) scalene_right.getRatioCbyA();
            float s_Rabyb = (float) scalene_right.getRatioAbyB();
            float s_Rbbyc = (float) scalene_right.getRatioBbyC();
            float s_RA = (float) scalene_right.getAngleA();
            float s_RB = (float) scalene_right.getAngleB();
            float s_RC = (float) scalene_right.getAngleC();
            float s_RGBA = (float) scalene_right.getGradientBA();
            float s_RGBC = (float) scalene_right.getGradientBC();
            float s_RGCA = (float) scalene_right.getGradientCA();

            /*
             * tepi 2 side bahagi 2 10
             */
            float sLLZ_cbya = (float) scalene_left_left_zone.getRatioCbyA();
            float sLLZ_abyb = (float) scalene_left_left_zone.getRatioAbyB();
            float sLLZ_bbyc = (float) scalene_left_left_zone.getRatioBbyC();
            float sLLZ_A = (float) scalene_left_left_zone.getAngleA();
            float sLLZ_B = (float) scalene_left_left_zone.getAngleB();
            float sLLZ_C = (float) scalene_left_left_zone.getAngleC();
            float sLLZ_GBA = (float) scalene_left_left_zone.getGradientBA();
            float sLLZ_GBC = (float) scalene_left_left_zone.getGradientBC();
            float sLLZ_GCA = (float) scalene_left_left_zone.getGradientCA();

//			11

            float sLRZ_cbya = (float) scalene_left_right_zone.getRatioCbyA();
            float sLRZ_abyb = (float) scalene_left_right_zone.getRatioAbyB();
            float sLRZ_bbyc = (float) scalene_left_right_zone.getRatioBbyC();
            float sLRZ_A = (float) scalene_left_right_zone.getAngleA();
            float sLRZ_B = (float) scalene_left_right_zone.getAngleB();
            float sLRZ_C = (float) scalene_left_right_zone.getAngleC();
            float sLRZ_GBA = (float) scalene_left_right_zone.getGradientBA();
            float sLRZ_GBC = (float) scalene_left_right_zone.getGradientBC();
            float sLRZ_GCA = (float) scalene_left_right_zone.getGradientCA();

//			12
            float sRLZ_cbya = (float) scalene_right_left_zone.getRatioCbyA();
            float sRLZ_abyb = (float) scalene_right_left_zone.getRatioAbyB();
            float sRLZ_bbyc = (float) scalene_right_left_zone.getRatioBbyC();
            float sRLZ_A = (float) scalene_right_left_zone.getAngleA();
            float sRLZ_B = (float) scalene_right_left_zone.getAngleB();
            float sRLZ_C = (float) scalene_right_left_zone.getAngleC();
            float sRLZ_GBA = (float) scalene_right_left_zone.getGradientBA();
            float sRLZ_GBC = (float) scalene_right_left_zone.getGradientBC();
            float sRLZ_GCA = (float) scalene_right_left_zone.getGradientCA();

//			13
            float sRRZ_cbya = (float) scalene_right_right_zone.getRatioCbyA();
            float sRRZ_abyb = (float) scalene_right_right_zone.getRatioAbyB();
            float sRRZ_bbyc = (float) scalene_right_right_zone.getRatioBbyC();
            float sRRZ_A = (float) scalene_right_right_zone.getAngleA();
            float sRRZ_B = (float) scalene_right_right_zone.getAngleB();
            float sRRZ_C = (float) scalene_right_right_zone.getAngleC();
            float sRRZ_GBA = (float) scalene_right_right_zone.getGradientBA();
            float sRRZ_GBC = (float) scalene_right_right_zone.getGradientBC();
            float sRRZ_GCA = (float) scalene_right_right_zone.getGradientCA();

            /*
             * Features under Left Zone and Right Zone 14
             */
            float sLLUZ_cbya = (float) scalene_left_left_upper_zone.getRatioCbyA();
            float sLLUZ_abyb = (float) scalene_left_left_upper_zone.getRatioAbyB();
            float sLLUZ_bbyc = (float) scalene_left_left_upper_zone.getRatioBbyC();
            float sLLUZ_A = (float) scalene_left_left_upper_zone.getAngleA();
            float sLLUZ_B = (float) scalene_left_left_upper_zone.getAngleB();
            float sLLUZ_C = (float) scalene_left_left_upper_zone.getAngleC();
            float sLLUZ_GBA = (float) scalene_left_left_upper_zone.getGradientBA();
            float sLLUZ_GBC = (float) scalene_left_left_upper_zone.getGradientBC();
            float sLLUZ_GCA = (float) scalene_left_left_upper_zone.getGradientCA();

//				15
            float sLLBZ_cbya = (float) scalene_left_left_lower_zone.getRatioCbyA();
            float sLLBZ_abyb = (float) scalene_left_left_lower_zone.getRatioAbyB();
            float sLLBZ_bbyc = (float) scalene_left_left_lower_zone.getRatioBbyC();
            float sLLBZ_A = (float) scalene_left_left_lower_zone.getAngleA();
            float sLLBZ_B = (float) scalene_left_left_lower_zone.getAngleB();
            float sLLBZ_C = (float) scalene_left_left_lower_zone.getAngleC();
            float sLLBZ_GBA = (float) scalene_left_left_lower_zone.getGradientBA();
            float sLLBZ_GBC = (float) scalene_left_left_lower_zone.getGradientBC();
            float sLLBZ_GCA = (float) scalene_left_left_lower_zone.getGradientCA();

//				16
            float sLRUZ_cbya = (float) scalene_left_right_upper_zone.getRatioCbyA();
            float sLRUZ_abyb = (float) scalene_left_right_upper_zone.getRatioAbyB();
            float sLRUZ_bbyc = (float) scalene_left_right_upper_zone.getRatioBbyC();
            float sLRUZ_A = (float) scalene_left_right_upper_zone.getAngleA();
            float sLRUZ_B = (float) scalene_left_right_upper_zone.getAngleB();
            float sLRUZ_C = (float) scalene_left_right_upper_zone.getAngleC();
            float sLRUZ_GBA = (float) scalene_left_right_upper_zone.getGradientBA();
            float sLRUZ_GBC = (float) scalene_left_right_upper_zone.getGradientBC();
            float sLRUZ_GCA = (float) scalene_left_right_upper_zone.getGradientCA();

//				17
            float sLRBZ_cbya = (float) scalene_left_right_lower_zone.getRatioCbyA();
            float sLRBZ_abyb = (float) scalene_left_right_lower_zone.getRatioAbyB();
            float sLRBZ_bbyc = (float) scalene_left_right_lower_zone.getRatioBbyC();
            float sLRBZ_A = (float) scalene_left_right_lower_zone.getAngleA();
            float sLRBZ_B = (float) scalene_left_right_lower_zone.getAngleB();
            float sLRBZ_C = (float) scalene_left_right_lower_zone.getAngleC();
            float sLRBZ_GBA = (float) scalene_left_right_lower_zone.getGradientBA();
            float sLRBZ_GBC = (float) scalene_left_right_lower_zone.getGradientBC();
            float sLRBZ_GCA = (float) scalene_left_right_lower_zone.getGradientCA();

            /*
             * ------------------------------------------------------------
             * Right Zone left and Right Zone Right 18
             * ------------------------------------------------------------
             */
            float sRLUZ_cbya = (float) scalene_right_left_upper_zone.getRatioCbyA();
            float sRLUZ_abyb = (float) scalene_right_left_upper_zone.getRatioAbyB();
            float sRLUZ_bbyc = (float) scalene_right_left_upper_zone.getRatioBbyC();
            float sRLUZ_A = (float) scalene_right_left_upper_zone.getAngleA();
            float sRLUZ_B = (float) scalene_right_left_upper_zone.getAngleB();
            float sRLUZ_C = (float) scalene_right_left_upper_zone.getAngleC();
            float sRLUZ_GBA = (float) scalene_right_left_upper_zone.getGradientBA();
            float sRLUZ_GBC = (float) scalene_right_left_upper_zone.getGradientBC();
            float sRLUZ_GCA = (float) scalene_right_left_upper_zone.getGradientCA();

//				19
            float sRLBZ_cbya = (float) scalene_right_left_lower_zone.getRatioCbyA();
            float sRLBZ_abyb = (float) scalene_right_left_lower_zone.getRatioAbyB();
            float sRLBZ_bbyc = (float) scalene_right_left_lower_zone.getRatioBbyC();
            float sRLBZ_A = (float) scalene_right_left_lower_zone.getAngleA();
            float sRLBZ_B = (float) scalene_right_left_lower_zone.getAngleB();
            float sRLBZ_C = (float) scalene_right_left_lower_zone.getAngleC();
            float sRLBZ_GBA = (float) scalene_right_left_lower_zone.getGradientBA();
            float sRLBZ_GBC = (float) scalene_right_left_lower_zone.getGradientBC();
            float sRLBZ_GCA = (float) scalene_right_left_lower_zone.getGradientCA();

//				20
            float sRRUZ_cbya = (float) scalene_right_right_upper_zone.getRatioCbyA();
            float sRRUZ_abyb = (float) scalene_right_right_upper_zone.getRatioAbyB();
            float sRRUZ_bbyc = (float) scalene_right_right_upper_zone.getRatioBbyC();
            float sRRUZ_A = (float) scalene_right_right_upper_zone.getAngleA();
            float sRRUZ_B = (float) scalene_right_right_upper_zone.getAngleB();
            float sRRUZ_C = (float) scalene_right_right_upper_zone.getAngleC();
            float sRRUZ_GBA = (float) scalene_right_right_upper_zone.getGradientBA();
            float sRRUZ_GBC = (float) scalene_right_right_upper_zone.getGradientBC();
            float sRRUZ_GCA = (float) scalene_right_right_upper_zone.getGradientCA();

//				21
            float sRRBZ_cbya = (float) scalene_right_right_lower_zone.getRatioCbyA();
            float sRRBZ_abyb = (float) scalene_right_right_lower_zone.getRatioAbyB();
            float sRRBZ_bbyc = (float) scalene_right_right_lower_zone.getRatioBbyC();
            float sRRBZ_A = (float) scalene_right_right_lower_zone.getAngleA();
            float sRRBZ_B = (float) scalene_right_right_lower_zone.getAngleB();
            float sRRBZ_C = (float) scalene_right_right_lower_zone.getAngleC();
            float sRRBZ_GBA = (float) scalene_right_right_lower_zone.getGradientBA();
            float sRRBZ_GBC = (float) scalene_right_right_lower_zone.getGradientBC();
            float sRRBZ_GCA = (float) scalene_right_right_lower_zone.getGradientCA();
//			22
            float sPUL_cbya = (float) scalene_points_upper_left.getRatioCbyA();
            float sPUL_abyb = (float) scalene_points_upper_left.getRatioAbyB();
            float sPUL_bbyc = (float) scalene_points_upper_left.getRatioBbyC();
            float sPUL_A = (float) scalene_points_upper_left.getAngleA();
            float sPUL_B = (float) scalene_points_upper_left.getAngleB();
            float sPUL_C = (float) scalene_points_upper_left.getAngleC();
            float sPUL_GBA = (float) scalene_points_upper_left.getGradientBA();
            float sPUL_GBC = (float) scalene_points_upper_left.getGradientBC();
            float sPUL_GCA = (float) scalene_points_upper_left.getGradientCA();

            /*
             * Upper Right 23
             */
            float sPUR_cbya = (float) scalene_points_upper_right.getRatioCbyA();
            float sPUR_abyb = (float) scalene_points_upper_right.getRatioAbyB();
            float sPUR_bbyc = (float) scalene_points_upper_right.getRatioBbyC();
            float sPUR_A = (float) scalene_points_upper_right.getAngleA();
            float sPUR_B = (float) scalene_points_upper_right.getAngleB();
            float sPUR_C = (float) scalene_points_upper_right.getAngleC();
            float sPUR_GBA = (float) scalene_points_upper_right.getGradientBA();
            float sPUR_GBC = (float) scalene_points_upper_right.getGradientBC();
            float sPUR_GCA = (float) scalene_points_upper_right.getGradientCA();

            /*
             * Lower Left 24
             */
            float sPLL_cbya = (float) scalene_points_lower_left.getRatioCbyA();
            float sPLL_abyb = (float) scalene_points_lower_left.getRatioAbyB();
            float sPLL_bbyc = (float) scalene_points_lower_left.getRatioBbyC();
            float sPLL_A = (float) scalene_points_lower_left.getAngleA();
            float sPLL_B = (float) scalene_points_lower_left.getAngleB();
            float sPLL_C = (float) scalene_points_lower_left.getAngleC();
            float sPLL_GBA = (float) scalene_points_lower_left.getGradientBA();
            float sPLL_GBC = (float) scalene_points_lower_left.getGradientBC();
            float sPLL_GCA = (float) scalene_points_lower_left.getGradientCA();

            /*
             * Lower Right 25
             */
            float sPLR_cbya = (float) scalene_points_lower_right.getRatioCbyA();
            float sPLR_abyb = (float) scalene_points_lower_right.getRatioAbyB();
            float sPLR_bbyc = (float) scalene_points_lower_right.getRatioBbyC();
            float sPLR_A = (float) scalene_points_lower_right.getAngleA();
            float sPLR_B = (float) scalene_points_lower_right.getAngleB();
            float sPLR_C = (float) scalene_points_lower_right.getAngleC();
            float sPLR_GBA = (float) scalene_points_lower_right.getGradientBA();
            float sPLR_GBC = (float) scalene_points_lower_right.getGradientBC();
            float sPLR_GCA = (float) scalene_points_lower_right.getGradientCA();

            //sALL
            float sALL_cbya = (float) sALL.getRatioCbyA();
            float sALL_abyb = (float) sALL.getRatioAbyB();
            float sALL_bbyc = (float) sALL.getRatioBbyC();
            float sALL_A = (float) sALL.getAngleA();
            float sALL_B = (float) sALL.getAngleB();
            float sALL_C = (float) sALL.getAngleC();
            float sALL_GBA = (float) sALL.getGradientBA();
            float sALL_GBC = (float) sALL.getGradientBC();
            float sALL_GCA = (float) sALL.getGradientCA();

            //sALR
            float sALR_cbya = (float) sALR.getRatioCbyA();
            float sALR_abyb = (float) sALR.getRatioAbyB();
            float sALR_bbyc = (float) sALR.getRatioBbyC();
            float sALR_A = (float) sALR.getAngleA();
            float sALR_B = (float) sALR.getAngleB();
            float sALR_C = (float) sALR.getAngleC();
            float sALR_GBA = (float) sALR.getGradientBA();
            float sALR_GBC = (float) sALR.getGradientBC();
            float sALR_GCA = (float) sALR.getGradientCA();

            //sARL
            float sARL_cbya = (float) sARL.getRatioCbyA();
            float sARL_abyb = (float) sARL.getRatioAbyB();
            float sARL_bbyc = (float) sARL.getRatioBbyC();
            float sARL_A = (float) sARL.getAngleA();
            float sARL_B = (float) sARL.getAngleB();
            float sARL_C = (float) sARL.getAngleC();
            float sARL_GBA = (float) sARL.getGradientBA();
            float sARL_GBC = (float) sARL.getGradientBC();
            float sARL_GCA = (float) sARL.getGradientCA();

            //sARR
            float sARR_cbya = (float) sARR.getRatioCbyA();
            float sARR_abyb = (float) sARR.getRatioAbyB();
            float sARR_bbyc = (float) sARR.getRatioBbyC();
            float sARR_A = (float) sARR.getAngleA();
            float sARR_B = (float) sARR.getAngleB();
            float sARR_C = (float) sARR.getAngleC();
            float sARR_GBA = (float) sARR.getGradientBA();
            float sARR_GBC = (float) sARR.getGradientBC();
            float sARR_GCA = (float) sARR.getGradientCA();

            //sBLL
            float sBLL_cbya = (float) sBLL.getRatioCbyA();
            float sBLL_abyb = (float) sBLL.getRatioAbyB();
            float sBLL_bbyc = (float) sBLL.getRatioBbyC();
            float sBLL_A = (float) sBLL.getAngleA();
            float sBLL_B = (float) sBLL.getAngleB();
            float sBLL_C = (float) sBLL.getAngleC();
            float sBLL_GBA = (float) sBLL.getGradientBA();
            float sBLL_GBC = (float) sBLL.getGradientBC();
            float sBLL_GCA = (float) sBLL.getGradientCA();

            //sBLR
            float sBLR_cbya = (float) sBLR.getRatioCbyA();
            float sBLR_abyb = (float) sBLR.getRatioAbyB();
            float sBLR_bbyc = (float) sBLR.getRatioBbyC();
            float sBLR_A = (float) sBLR.getAngleA();
            float sBLR_B = (float) sBLR.getAngleB();
            float sBLR_C = (float) sBLR.getAngleC();
            float sBLR_GBA = (float) sBLR.getGradientBA();
            float sBLR_GBC = (float) sBLR.getGradientBC();
            float sBLR_GCA = (float) sBLR.getGradientCA();

            //sBRL
            float sBRL_cbya = (float) sBRL.getRatioCbyA();
            float sBRL_abyb = (float) sBRL.getRatioAbyB();
            float sBRL_bbyc = (float) sBRL.getRatioBbyC();
            float sBRL_A = (float) sBRL.getAngleA();
            float sBRL_B = (float) sBRL.getAngleB();
            float sBRL_C = (float) sBRL.getAngleC();
            float sBRL_GBA = (float) sBRL.getGradientBA();
            float sBRL_GBC = (float) sBRL.getGradientBC();
            float sBRL_GCA = (float) sBRL.getGradientCA();

            //sBRR
            float sBRR_cbya = (float) sBRR.getRatioCbyA();
            float sBRR_abyb = (float) sBRR.getRatioAbyB();
            float sBRR_bbyc = (float) sBRR.getRatioBbyC();
            float sBRR_A = (float) sBRR.getAngleA();
            float sBRR_B = (float) sBRR.getAngleB();
            float sBRR_C = (float) sBRR.getAngleC();
            float sBRR_GBA = (float) sBRR.getGradientBA();
            float sBRR_GBC = (float) sBRR.getGradientBC();
            float sBRR_GCA = (float) sBRR.getGradientCA();

            Bean_Feature bean = new Bean_Feature();
            //NFV2
            bean.setFname(s_fname);
            bean.setCbya(s_cbya);
            bean.setAbyb(s_abyb);
            bean.setBbyc(s_bbyc);
            bean.setA(s_A);
            bean.setB(s_B);
            bean.setC(s_C);
            bean.setGraBA(s_GBA);
            bean.setGraBC(s_GBC);
            bean.setGraCA(s_GCA);

            bean.setPu_cbya(su_cbya);
            bean.setPu_abyb(su_abyb);
            bean.setPu_bbyc(su_bbyc);
            bean.setPu_A(su_A);
            bean.setPu_B(su_B);
            bean.setPu_C(su_C);
            bean.setPu_GraBA(su_GBA);
            bean.setPu_GraBC(su_GBC);
            bean.setPu_GraCA(su_GCA);

            bean.setPl_cbya(sl_cbya);
            bean.setPl_abyb(sl_abyb);
            bean.setPl_bbyc(sl_bbyc);
            bean.setPl_A(sl_A);
            bean.setPl_B(sl_B);
            bean.setPl_C(sl_C);
            bean.setPl_GraBA(sl_GBA);
            bean.setPl_GraBC(sl_GBC);
            bean.setPl_GraCA(sl_GCA);

            //27 Feb 2012
            bean.setTu_cbya(stu_cbya);
            bean.setTu_abyb(stu_abyb);
            bean.setTu_bbyc(stu_bbyc);
            bean.setTu_A(stu_A);
            bean.setTu_B(stu_B);
            bean.setTu_C(stu_C);
            bean.setTu_GraBA(stu_GBA);
            bean.setTu_GraBC(stu_GBC);
            bean.setTu_GraCA(stu_GCA);

            bean.setTl_cbya(stl_cbya);
            bean.setTl_abyb(stl_abyb);
            bean.setTl_bbyc(stl_bbyc);
            bean.setTl_A(stl_A);
            bean.setTl_B(stl_B);
            bean.setTl_C(stl_C);
            bean.setTl_GraBA(stl_GBA);
            bean.setTl_GraBC(stl_GBC);
            bean.setTl_GraCA(stl_GCA);

            bean.setBu_cbya(sbu_cbya);
            bean.setBu_abyb(sbu_abyb);
            bean.setBu_bbyc(sbu_bbyc);
            bean.setBu_A(sbu_A);
            bean.setBu_B(sbu_B);
            bean.setBu_C(sbu_C);
            bean.setBu_GraBA(sbu_GBA);
            bean.setBu_GraBC(sbu_GBC);
            bean.setBu_GraCA(sbu_GCA);

            bean.setBl_cbya(sbl_cbya);
            bean.setBl_abyb(sbl_abyb);
            bean.setBl_bbyc(sbl_bbyc);
            bean.setBl_A(sbl_A);
            bean.setBl_B(sbl_B);
            bean.setBl_C(sbl_C);
            bean.setBl_GraBA(sbl_GBA);
            bean.setBl_GraBC(sbl_GBC);
            bean.setBl_GraCA(sbl_GCA);

            //24 Feb 2012
            bean.setP_Lcbya(s_Lcbya);
            bean.setP_Labyb(s_Labyb);
            bean.setP_Lbbyc(s_Lbbyc);
            bean.setP_LA(s_LA);
            bean.setP_LB(s_LB);
            bean.setP_LC(s_LC);
            bean.setP_LGraBA(s_LGBA);
            bean.setP_LGraBC(s_LGBC);
            bean.setP_LGraCA(s_LGCA);

            bean.setP_Rcbya(s_Rcbya);
            bean.setP_Rabyb(s_Rabyb);
            bean.setP_Rbbyc(s_Rbbyc);
            bean.setP_RA(s_RA);
            bean.setP_RB(s_RB);
            bean.setP_RC(s_RC);
            bean.setP_RGraBA(s_RGBA);
            bean.setP_RGraBC(s_RGBC);
            bean.setP_RGraCA(s_RGCA);
            //28 Feb 2012
            bean.setsLLZ_cbya(sLLZ_cbya);/*FIXED*/
            bean.setsLLZ_abyb(sLLZ_abyb);
            bean.setsLLZ_bbyc(sLLZ_bbyc);
            bean.setsLLZ_A(sLLZ_A);
            bean.setsLLZ_B(sLLZ_B);
            bean.setsLLZ_C(sLLZ_C);
            bean.setsLLZ_GraBA(sLLZ_GBA);
            bean.setsLLZ_GraBC(sLLZ_GBC);
            bean.setsLLZ_GraCA(sLLZ_GCA);

            bean.setsLRZ_cbya(sLRZ_cbya);/*FIXED*/
            bean.setsLRZ_abyb(sLRZ_abyb);
            bean.setsLRZ_bbyc(sLRZ_bbyc);
            bean.setsLRZ_A(sLRZ_A);
            bean.setsLRZ_B(sLRZ_B);
            bean.setsLRZ_C(sLRZ_C);
            bean.setsLRZ_GraBA(sLRZ_GBA);
            bean.setsLRZ_GraBC(sLRZ_GBC);
            bean.setsLRZ_GraCA(sLRZ_GCA);

            bean.setsRLZ_cbya(sRLZ_cbya);/*FIXED*/
            bean.setsRLZ_abyb(sRLZ_abyb);
            bean.setsRLZ_bbyc(sRLZ_bbyc);
            bean.setsRLZ_A(sRLZ_A);
            bean.setsRLZ_B(sRLZ_B);/*FIXED*/
            bean.setsRLZ_C(sRLZ_C);
            bean.setsRLZ_GraBA(sRLZ_GBA);
            bean.setsRLZ_GraBC(sRLZ_GBC);
            bean.setsRLZ_GraCA(sRLZ_GCA);

            bean.setsRRZ_cbya(sRRZ_cbya);/*FIXED*/
            bean.setsRRZ_abyb(sRRZ_abyb);
            bean.setsRRZ_bbyc(sRRZ_bbyc);
            bean.setsRRZ_A(sRRZ_A);
            bean.setsRRZ_B(sRRZ_B);
            bean.setsRRZ_C(sRRZ_C);
            bean.setsRRZ_GraBA(sRRZ_GBA);
            bean.setsRRZ_GraBC(sRRZ_GBC);
            bean.setsRRZ_GraCA(sRRZ_GCA);

            /*
             * ------------------------------------------
             * features under left UPPER and BOTTOM zone
             * ------------------------------------------
             */

            bean.setsLLUZ_cbya(sLLUZ_cbya);/*FIXED*/
            bean.setsLLUZ_abyb(sLLUZ_abyb);
            bean.setsLLUZ_bbyc(sLLUZ_bbyc);
            bean.setsLLUZ_A(sLLUZ_A);
            bean.setsLLUZ_B(sLLUZ_B);
            bean.setsLLUZ_C(sLLUZ_C);
            bean.setsLLUZ_GraBA(sLLUZ_GBA);
            bean.setsLLUZ_GraBC(sLLUZ_GBC);
            bean.setsLLUZ_GraCA(sLLUZ_GCA);

            bean.setsLLBZ_cbya(sLLBZ_cbya);/*FIXED*/
            bean.setsLLBZ_abyb(sLLBZ_abyb);
            bean.setsLLBZ_bbyc(sLLBZ_bbyc);
            bean.setsLLBZ_A(sLLBZ_A);
            bean.setsLLBZ_B(sLLBZ_B);
            bean.setsLLBZ_C(sLLBZ_C);
            bean.setsLLBZ_GraBA(sLLBZ_GBA);
            bean.setsLLBZ_GraBC(sLLBZ_GBC);
            bean.setsLLBZ_GraCA(sLLBZ_GCA);

            bean.setsLRUZ_cbya(sLRUZ_cbya);/*FIXED*/
            bean.setsLRUZ_abyb(sLRUZ_abyb);
            bean.setsLRUZ_bbyc(sLRUZ_bbyc);
            bean.setsLRUZ_A(sLRUZ_A);
            bean.setsLRUZ_B(sLRUZ_B);
            bean.setsLRUZ_C(sLRUZ_C);
            bean.setsLRUZ_GraBA(sLRUZ_GBA);
            bean.setsLRUZ_GraBC(sLRUZ_GBC);
            bean.setsLRUZ_GraCA(sLRUZ_GCA);

            bean.setsLRBZ_cbya(sLRBZ_cbya);/*FIXED*/
            bean.setsLRBZ_abyb(sLRBZ_abyb);
            bean.setsLRBZ_bbyc(sLRBZ_bbyc);
            bean.setsLRBZ_A(sLRBZ_A);
            bean.setsLRBZ_B(sLRBZ_B);
            bean.setsLRBZ_C(sLRBZ_C);
            bean.setsLRBZ_GraBA(sLRBZ_GBA);
            bean.setsLRBZ_GraBC(sLRBZ_GBC);
            bean.setsLRBZ_GraCA(sLRBZ_GCA);

            /*
             * ------------------------------------------
             * features under right UPPER and BOTTOM zone
             * ------------------------------------------
             */

            bean.setsRLUZ_cbya(sRLUZ_cbya);/*FIXED*/
            bean.setsRLUZ_abyb(sRLUZ_abyb);
            bean.setsRLUZ_bbyc(sRLUZ_bbyc);
            bean.setsRLUZ_A(sRLUZ_A);
            bean.setsRLUZ_B(sRLUZ_B);
            bean.setsRLUZ_C(sRLUZ_C);
            bean.setsRLUZ_GraBA(sRLUZ_GBA);
            bean.setsRLUZ_GraBC(sRLUZ_GBC);
            bean.setsRLUZ_GraCA(sRLUZ_GCA);

            bean.setsRLBZ_cbya(sRLBZ_cbya);/*FIXED*/
            bean.setsRLBZ_abyb(sRLBZ_abyb);
            bean.setsRLBZ_bbyc(sRLBZ_bbyc);
            bean.setsRLBZ_A(sRLBZ_A);
            bean.setsRLBZ_B(sRLBZ_B);
            bean.setsRLBZ_C(sRLBZ_C);
            bean.setsRLBZ_GraBA(sRLBZ_GBA);
            bean.setsRLBZ_GraBC(sRLBZ_GBC);
            bean.setsRLBZ_GraCA(sRLBZ_GCA);

            bean.setsRRUZ_cbya(sRRUZ_cbya);/*FIXED*/
            bean.setsRRUZ_abyb(sRRUZ_abyb);
            bean.setsRRUZ_bbyc(sRRUZ_bbyc);
            bean.setsRRUZ_A(sRRUZ_A);
            bean.setsRRUZ_B(sRRUZ_B);
            bean.setsRRUZ_C(sRRUZ_C);
            bean.setsRRUZ_GraBA(sRRUZ_GBA);
            bean.setsRRUZ_GraBC(sRRUZ_GBC);
            bean.setsRRUZ_GraCA(sRRUZ_GCA);

            bean.setsRRBZ_cbya(sRRBZ_cbya);/*FIXED*/
            bean.setsRRBZ_abyb(sRRBZ_abyb);
            bean.setsRRBZ_bbyc(sRRBZ_bbyc);
            bean.setsRRBZ_A(sRRBZ_A);
            bean.setsRRBZ_B(sRRBZ_B);
            bean.setsRRBZ_C(sRRBZ_C);
            bean.setsRRBZ_GraBA(sRRBZ_GBA);
            bean.setsRRBZ_GraBC(sRRBZ_GBC);
            bean.setsRRBZ_GraCA(sRRBZ_GCA);

            bean.setPul_cbya(sPUL_cbya);
            bean.setPul_abyb(sPUL_abyb);
            bean.setPul_bbyc(sPUL_bbyc);
            bean.setPul_A(sPUL_A);
            bean.setPul_B(sPUL_B);
            bean.setPul_C(sPUL_C);
            bean.setPul_GraBA(sPUL_GBA);
            bean.setPul_GraBC(sPUL_GBC);
            bean.setPul_GraCA(sPUL_GCA);

            bean.setPur_cbya(sPUR_cbya);
            bean.setPur_abyb(sPUR_abyb);
            bean.setPur_bbyc(sPUR_bbyc);
            bean.setPur_A(sPUR_A);
            bean.setPur_B(sPUR_B);
            bean.setPur_C(sPUR_C);
            bean.setPur_GraBA(sPUR_GBA);
            bean.setPur_GraBC(sPUR_GBC);
            bean.setPur_GraCA(sPUR_GCA);

            bean.setPll_cbya(sPLL_cbya);
            bean.setPll_abyb(sPLL_abyb);
            bean.setPll_bbyc(sPLL_bbyc);
            bean.setPll_A(sPLL_A);
            bean.setPll_B(sPLL_B);
            bean.setPll_C(sPLL_C);
            bean.setPll_GraBA(sPLL_GBA);
            bean.setPll_GraBC(sPLL_GBC);
            bean.setPll_GraCA(sPLL_GCA);

            bean.setPlr_cbya(sPLR_cbya);
            bean.setPlr_abyb(sPLR_abyb);
            bean.setPlr_bbyc(sPLR_bbyc);
            bean.setPlr_A(sPLR_A);
            bean.setPlr_B(sPLR_B);
            bean.setPlr_C(sPLR_C);
            bean.setPlr_GraBA(sPLR_GBA);
            bean.setPlr_GraBC(sPLR_GBC);
            bean.setPlr_GraCA(sPLR_GCA);

            //NF45
            //Bahagian Atas 45 darjah
            bean.setsALL_cbya(sALL_cbya);
            bean.setsALL_abyb(sALL_abyb);
            bean.setsALL_bbyc(sALL_bbyc);
            bean.setsALL_A(sALL_A);
            bean.setsALL_B(sALL_B);
            bean.setsALL_C(sALL_C);
            bean.setsALL_GraBA(sALL_GBA);
            bean.setsALL_GraBC(sALL_GBC);
            bean.setsALL_GraCA(sALL_GCA);

            bean.setsALR_cbya(sALR_cbya);
            bean.setsALR_abyb(sALR_abyb);
            bean.setsALR_bbyc(sALR_bbyc);
            bean.setsALR_A(sALR_A);
            bean.setsALR_B(sALR_B);
            bean.setsALR_C(sALR_C);
            bean.setsALR_GraBA(sALR_GBA);
            bean.setsALR_GraBC(sALR_GBC);
            bean.setsALR_GraCA(sALR_GCA);

            bean.setsARL_cbya(sARL_cbya);
            bean.setsARL_abyb(sARL_abyb);
            bean.setsARL_bbyc(sARL_bbyc);
            bean.setsARL_A(sARL_A);
            bean.setsARL_B(sARL_B);
            bean.setsARL_C(sARL_C);
            bean.setsARL_GraBA(sARL_GBA);
            bean.setsARL_GraBC(sARL_GBC);
            bean.setsARL_GraCA(sARL_GCA);

            bean.setsARR_cbya(sARR_cbya);
            bean.setsARR_abyb(sARR_abyb);
            bean.setsARR_bbyc(sARR_bbyc);
            bean.setsARR_A(sARR_A);
            bean.setsARR_B(sARR_B);
            bean.setsARR_C(sARR_C);
            bean.setsARR_GraBA(sARR_GBA);
            bean.setsARR_GraBC(sARR_GBC);
            bean.setsARR_GraCA(sARR_GCA);


            //Bahagian Bawah 45 darjah
            bean.setsBLL_cbya(sBLL_cbya);
            bean.setsBLL_abyb(sBLL_abyb);
            bean.setsBLL_bbyc(sBLL_bbyc);
            bean.setsBLL_A(sBLL_A);
            bean.setsBLL_B(sBLL_B);
            bean.setsBLL_C(sBLL_C);
            bean.setsBLL_GraBA(sBLL_GBA);
            bean.setsBLL_GraBC(sBLL_GBC);
            bean.setsBLL_GraCA(sBLL_GCA);

            bean.setsBLR_cbya(sBLR_cbya);
            bean.setsBLR_abyb(sBLR_abyb);
            bean.setsBLR_bbyc(sBLR_bbyc);
            bean.setsBLR_A(sBLR_A);
            bean.setsBLR_B(sBLR_B);
            bean.setsBLR_C(sBLR_C);
            bean.setsBLR_GraBA(sBLR_GBA);
            bean.setsBLR_GraBC(sBLR_GBC);
            bean.setsBLR_GraCA(sBLR_GCA);

            bean.setsBRL_cbya(sBRL_cbya);
            bean.setsBRL_abyb(sBRL_abyb);
            bean.setsBRL_bbyc(sBRL_bbyc);
            bean.setsBRL_A(sBRL_A);
            bean.setsBRL_B(sBRL_B);
            bean.setsBRL_C(sBRL_C);
            bean.setsBRL_GraBA(sBRL_GBA);
            bean.setsBRL_GraBC(sBRL_GBC);
            bean.setsBRL_GraCA(sBRL_GCA);

            bean.setsBRR_cbya(sBRR_cbya);
            bean.setsBRR_abyb(sBRR_abyb);
            bean.setsBRR_bbyc(sBRR_bbyc);
            bean.setsBRR_A(sBRR_A);
            bean.setsBRR_B(sBRR_B);
            bean.setsBRR_C(sBRR_C);
            bean.setsBRR_GraBA(sBRR_GBA);
            bean.setsBRR_GraBC(sBRR_GBC);
            bean.setsBRR_GraCA(sBRR_GCA);

            bean.setType(type);

            beans.add(bean);
        }

        return beans;
    }

    public void save(ArrayList<Bean_Feature> beansCollection) {
        for (Bean_Feature bean : beansCollection) {
            System.out.print(bean.getFname());
            System.out.print(" , " + bean.getCbya());//1
            System.out.print(" , " + bean.getAbyb());//2
            System.out.print(" , " + bean.getBbyc());//3
            System.out.print(" , " + bean.getA());//4
            System.out.print(" , " + bean.getB());//5
            System.out.print(" , " + bean.getC());//6
            System.out.print(" , " + bean.getGraBA());//7
            System.out.print(" , " + bean.getGraBC());//8
            System.out.print(" , " + bean.getGraCA());//9
            System.out.print(" , " + bean.getPu_cbya());//10
            System.out.print(" , " + bean.getPu_abyb());//11
            System.out.print(" , " + bean.getPu_bbyc());//12
            System.out.print(" , " + bean.getPu_A());//13
            System.out.print(" , " + bean.getPu_B());//14
            System.out.print(" , " + bean.getPu_C());//15
            System.out.print(" , " + bean.getPu_GraBA());//16
            System.out.print(" , " + bean.getPu_GraBC());//17
            System.out.print(" , " + bean.getPu_GraCA());//18
            System.out.print(" , " + bean.getPl_cbya());//19
            System.out.print(" , " + bean.getPl_abyb());//20
            System.out.print(" , " + bean.getPl_bbyc());//21
            System.out.print(" , " + bean.getPl_A());//22
            System.out.print(" , " + bean.getPl_B());//23
            System.out.print(" , " + bean.getPl_C());//24
            System.out.print(" , " + bean.getPl_GraBA());//25
            System.out.print(" , " + bean.getPl_GraBC());//26
            System.out.print(" , " + bean.getPl_GraCA());//27
            System.out.print(" , " + bean.getTu_cbya());//28
            System.out.print(" , " + bean.getTu_abyb());//29
            System.out.print(" , " + bean.getTu_bbyc());//30
            System.out.print(" , " + bean.getTu_A());//31
            System.out.print(" , " + bean.getTu_B());//32
            System.out.print(" , " + bean.getTu_C());//33
            System.out.print(" , " + bean.getTu_GraBA());//34
            System.out.print(" , " + bean.getTu_GraBC());//35
            System.out.print(" , " + bean.getTu_GraCA());//36
            System.out.print(" , " + bean.getTl_cbya());//37
            System.out.print(" , " + bean.getTl_abyb());//38
            System.out.print(" , " + bean.getTl_bbyc());//39
            System.out.print(" , " + bean.getTl_A());//40
            System.out.print(" , " + bean.getTl_B());//41
            System.out.print(" , " + bean.getTl_C());//42
            System.out.print(" , " + bean.getTl_GraBA());//43
            System.out.print(" , " + bean.getTl_GraBC());//44
            System.out.print(" , " + bean.getTl_GraCA());//45
            System.out.print(" , " + bean.getBu_cbya());//46
            System.out.print(" , " + bean.getBu_abyb());//47
            System.out.print(" , " + bean.getBu_bbyc());//48
            System.out.print(" , " + bean.getBu_A());//49
            System.out.print(" , " + bean.getBu_B());//50
            System.out.print(" , " + bean.getBu_C());//51
            System.out.print(" , " + bean.getBu_GraBA());//52
            System.out.print(" , " + bean.getBu_GraBC());//53
            System.out.print(" , " + bean.getBu_GraCA());//54
            System.out.print(" , " + bean.getBl_cbya());//55
            System.out.print(" , " + bean.getBl_abyb());//56
            System.out.print(" , " + bean.getBl_bbyc());//57
            System.out.print(" , " + bean.getBl_A());//58
            System.out.print(" , " + bean.getBl_B());//59
            System.out.print(" , " + bean.getBl_C());//60
            System.out.print(" , " + bean.getBl_GraBA());//61
            System.out.print(" , " + bean.getBl_GraBC());//62
            System.out.print(" , " + bean.getBl_GraCA());//63
            System.out.print(" , " + bean.getP_Lcbya());//64
            System.out.print(" , " + bean.getP_Labyb());//65
            System.out.print(" , " + bean.getP_Lbbyc());//66
            System.out.print(" , " + bean.getP_LA());//67
            System.out.print(" , " + bean.getP_LB());//68
            System.out.print(" , " + bean.getP_LC());//69
            System.out.print(" , " + bean.getP_LGraBA());//70
            System.out.print(" , " + bean.getP_LGraBC());//71
            System.out.print(" , " + bean.getP_LGraCA());//72
            System.out.print(" , " + bean.getP_Rcbya());//73
            System.out.print(" , " + bean.getP_Rabyb());//74
            System.out.print(" , " + bean.getP_Rbbyc());//75
            System.out.print(" , " + bean.getP_RA());//76
            System.out.print(" , " + bean.getP_RB());//77
            System.out.print(" , " + bean.getP_RC());//78
            System.out.print(" , " + bean.getP_RGraBA());//79
            System.out.print(" , " + bean.getP_RGraBC());//80
            System.out.print(" , " + bean.getP_RGraCA());//81
            System.out.print(" , " + bean.getsLLZ_cbya());//System.out.print(" , "+bean.getsLLZ_bbyc());//82
            System.out.print(" , " + bean.getsLLZ_abyb());//83
            System.out.print(" , " + bean.getsLLZ_bbyc());//84
            System.out.print(" , " + bean.getsLLZ_A());//85
            System.out.print(" , " + bean.getsLLZ_B());//86
            System.out.print(" , " + bean.getsLLZ_C());//87
            System.out.print(" , " + bean.getsLLZ_GraBA());//88
            System.out.print(" , " + bean.getsLLZ_GraBC());//89
            System.out.print(" , " + bean.getsLLZ_GraCA());//90
            System.out.print(" , " + bean.getsLRZ_cbya());//System.out.print(" , "+bean.getsLRZ_bbyc());//91
            System.out.print(" , " + bean.getsLRZ_abyb());//92
            System.out.print(" , " + bean.getsLRZ_bbyc());//93
            System.out.print(" , " + bean.getsLRZ_A());//94
            System.out.print(" , " + bean.getsLRZ_B());//95
            System.out.print(" , " + bean.getsLRZ_C());//96
            System.out.print(" , " + bean.getsLRZ_GraBA());//97
            System.out.print(" , " + bean.getsLRZ_GraBC());//98
            System.out.print(" , " + bean.getsLRZ_GraCA());//99
            System.out.print(" , " + bean.getsRLZ_cbya());//System.out.print(" , "+bean.getsRLZ_bbyc());//100
            System.out.print(" , " + bean.getsRLZ_abyb());//101
            System.out.print(" , " + bean.getsRLZ_bbyc());//102
            System.out.print(" , " + bean.getsRLZ_A());//103
            System.out.print(" , " + bean.getsRLZ_B());//104
            System.out.print(" , " + bean.getsRLZ_C());//105
            System.out.print(" , " + bean.getsRLZ_GraBA());//106
            System.out.print(" , " + bean.getsRLZ_GraBC());//107
            System.out.print(" , " + bean.getsRLZ_GraCA());//108
            System.out.print(" , " + bean.getsRRZ_cbya());//System.out.print(" , "+bean.getsRRZ_bbyc());//109
            System.out.print(" , " + bean.getsRRZ_abyb());//110
            System.out.print(" , " + bean.getsRRZ_bbyc());//111
            System.out.print(" , " + bean.getsRRZ_A());//112
            System.out.print(" , " + bean.getsRRZ_B());//113
            System.out.print(" , " + bean.getsRRZ_C());//114
            System.out.print(" , " + bean.getsRRZ_GraBA());//115
            System.out.print(" , " + bean.getsRRZ_GraBC());//116
            System.out.print(" , " + bean.getsRRZ_GraCA());//117
            System.out.print(" , " + bean.getsLLUZ_cbya());//System.out.print(" , "+bean.getsLLUZ_bbyc());//118
            System.out.print(" , " + bean.getsLLUZ_abyb());//119
            System.out.print(" , " + bean.getsLLUZ_bbyc());//120
            System.out.print(" , " + bean.getsLLUZ_A());//121
            System.out.print(" , " + bean.getsLLUZ_B());//122
            System.out.print(" , " + bean.getsLLUZ_C());//123
            System.out.print(" , " + bean.getsLLUZ_GraBA());//124
            System.out.print(" , " + bean.getsLLUZ_GraBC());//125
            System.out.print(" , " + bean.getsLLUZ_GraCA());//126
            System.out.print(" , " + bean.getsLLBZ_cbya());//System.out.print(" , "+bean.getsLLBZ_bbyc());//127
            System.out.print(" , " + bean.getsLLBZ_abyb());//128
            System.out.print(" , " + bean.getsLLBZ_bbyc());//129
            System.out.print(" , " + bean.getsLLBZ_A());//130
            System.out.print(" , " + bean.getsLLBZ_B());//131
            System.out.print(" , " + bean.getsLLBZ_C());//132
            System.out.print(" , " + bean.getsLLBZ_GraBA());//133
            System.out.print(" , " + bean.getsLLBZ_GraBC());//134
            System.out.print(" , " + bean.getsLLBZ_GraCA());//135
            System.out.print(" , " + bean.getsLRUZ_cbya());//System.out.print(" , "+bean.getsLRUZ_bbyc());//136
            System.out.print(" , " + bean.getsLRUZ_abyb());//137
            System.out.print(" , " + bean.getsLRUZ_bbyc());//138
            System.out.print(" , " + bean.getsLRUZ_A());//139
            System.out.print(" , " + bean.getsLRUZ_B());//140
            System.out.print(" , " + bean.getsLRUZ_C());//141
            System.out.print(" , " + bean.getsLRUZ_GraBA());//142
            System.out.print(" , " + bean.getsLRUZ_GraBC());//143
            System.out.print(" , " + bean.getsLRUZ_GraCA());//144
            System.out.print(" , " + bean.getsLRBZ_cbya());//System.out.print(" , "+bean.getsLRBZ_bbyc());//145
            System.out.print(" , " + bean.getsLRBZ_abyb());//146
            System.out.print(" , " + bean.getsLRBZ_bbyc());//147
            System.out.print(" , " + bean.getsLRBZ_A());//148
            System.out.print(" , " + bean.getsLRBZ_B());//149
            System.out.print(" , " + bean.getsLRBZ_C());//150
            System.out.print(" , " + bean.getsLRBZ_GraBA());//151
            System.out.print(" , " + bean.getsLRBZ_GraBC());//152
            System.out.print(" , " + bean.getsLRBZ_GraCA());//153
            System.out.print(" , " + bean.getsRLUZ_cbya());//System.out.print(" , "+bean.getsRLUZ_bbyc());//154
            System.out.print(" , " + bean.getsRLUZ_abyb());//155
            System.out.print(" , " + bean.getsRLUZ_bbyc());//156
            System.out.print(" , " + bean.getsRLUZ_A());//157
            System.out.print(" , " + bean.getsRLUZ_B());//158
            System.out.print(" , " + bean.getsRLUZ_C());//159
            System.out.print(" , " + bean.getsRLUZ_GraBA());//160
            System.out.print(" , " + bean.getsRLUZ_GraBC());//161
            System.out.print(" , " + bean.getsRLUZ_GraCA());//162
            System.out.print(" , " + bean.getsRLBZ_cbya());//System.out.print(" , "+bean.getsRLBZ_bbyc());//163
            System.out.print(" , " + bean.getsRLBZ_abyb());//164
            System.out.print(" , " + bean.getsRLBZ_bbyc());//165
            System.out.print(" , " + bean.getsRLBZ_A());//166
            System.out.print(" , " + bean.getsRLBZ_B());//167
            System.out.print(" , " + bean.getsRLBZ_C());//168
            System.out.print(" , " + bean.getsRLBZ_GraBA());//169
            System.out.print(" , " + bean.getsRLBZ_GraBC());//170
            System.out.print(" , " + bean.getsRLBZ_GraCA());//171
            System.out.print(" , " + bean.getsRRUZ_cbya());//System.out.print(" , "+bean.getsRRUZ_bbyc());//172
            System.out.print(" , " + bean.getsRRUZ_abyb());//173
            System.out.print(" , " + bean.getsRRUZ_bbyc());//174
            System.out.print(" , " + bean.getsRRUZ_A());//175
            System.out.print(" , " + bean.getsRRUZ_B());//176
            System.out.print(" , " + bean.getsRRUZ_C());//177
            System.out.print(" , " + bean.getsRRUZ_GraBA());//178
            System.out.print(" , " + bean.getsRRUZ_GraBC());//179
            System.out.print(" , " + bean.getsRRUZ_GraCA());//180
            System.out.print(" , " + bean.getsRRBZ_cbya());//System.out.print(" , "+bean.getsRRBZ_bbyc());//181
            System.out.print(" , " + bean.getsRRBZ_abyb());//182
            System.out.print(" , " + bean.getsRRBZ_bbyc());//183
            System.out.print(" , " + bean.getsRRBZ_A());//184
            System.out.print(" , " + bean.getsRRBZ_B());//185
            System.out.print(" , " + bean.getsRRBZ_C());//186
            System.out.print(" , " + bean.getsRRBZ_GraBA());//187
            System.out.print(" , " + bean.getsRRBZ_GraBC());//188
            System.out.print(" , " + bean.getsRRBZ_GraCA());//189
            System.out.print(" , " + bean.getPul_cbya());//190
            System.out.print(" , " + bean.getPul_abyb());//191
            System.out.print(" , " + bean.getPul_bbyc());//192
            System.out.print(" , " + bean.getPul_A());//193
            System.out.print(" , " + bean.getPul_B());//194
            System.out.print(" , " + bean.getPul_C());//195
            System.out.print(" , " + bean.getPul_GraBA());//196
            System.out.print(" , " + bean.getPul_GraBC());//197
            System.out.print(" , " + bean.getPul_GraCA());//198
            System.out.print(" , " + bean.getPur_cbya());//199
            System.out.print(" , " + bean.getPur_abyb());//200
            System.out.print(" , " + bean.getPur_bbyc());//201
            System.out.print(" , " + bean.getPur_A());//202
            System.out.print(" , " + bean.getPur_B());//203
            System.out.print(" , " + bean.getPur_C());//204
            System.out.print(" , " + bean.getPur_GraBA());//205
            System.out.print(" , " + bean.getPur_GraBC());//206
            System.out.print(" , " + bean.getPur_GraCA());//207
            System.out.print(" , " + bean.getPll_cbya());//208
            System.out.print(" , " + bean.getPll_abyb());//209
            System.out.print(" , " + bean.getPll_bbyc());//210
            System.out.print(" , " + bean.getPll_A());//211
            System.out.print(" , " + bean.getPll_B());//212
            System.out.print(" , " + bean.getPll_C());//213
            System.out.print(" , " + bean.getPll_GraBA());//214
            System.out.print(" , " + bean.getPll_GraBC());//215
            System.out.print(" , " + bean.getPll_GraCA());//216
            System.out.print(" , " + bean.getPlr_cbya());//217
            System.out.print(" , " + bean.getPlr_abyb());//218
            System.out.print(" , " + bean.getPlr_bbyc());//219
            System.out.print(" , " + bean.getPlr_A());//220
            System.out.print(" , " + bean.getPlr_B());//221
            System.out.print(" , " + bean.getPlr_C());//222
            System.out.print(" , " + bean.getPlr_GraBA());//223
            System.out.print(" , " + bean.getPlr_GraBC());//224
            System.out.print(" , " + bean.getPlr_GraCA());//225
            System.out.print(" , " + bean.getsALL_cbya());//226
            System.out.print(" , " + bean.getsALL_abyb());//227
            System.out.print(" , " + bean.getsALL_bbyc());//228
            System.out.print(" , " + bean.getsALL_A());//229
            System.out.print(" , " + bean.getsALL_B());//230
            System.out.print(" , " + bean.getsALL_C());//231
            System.out.print(" , " + bean.getsALL_GraBA());//232
            System.out.print(" , " + bean.getsALL_GraBC());//233
            System.out.print(" , " + bean.getsALL_GraCA());//234
            System.out.print(" , " + bean.getsALR_cbya());//235
            System.out.print(" , " + bean.getsALR_abyb());//236
            System.out.print(" , " + bean.getsALR_bbyc());//237
            System.out.print(" , " + bean.getsALR_A());//238
            System.out.print(" , " + bean.getsALR_B());//239
            System.out.print(" , " + bean.getsALR_C());//240
            System.out.print(" , " + bean.getsALR_GraBA());//241
            System.out.print(" , " + bean.getsALR_GraBC());//242
            System.out.print(" , " + bean.getsALR_GraCA());//243
            System.out.print(" , " + bean.getsARL_cbya());//244
            System.out.print(" , " + bean.getsARL_abyb());//245
            System.out.print(" , " + bean.getsARL_bbyc());//246
            System.out.print(" , " + bean.getsARL_A());//247
            System.out.print(" , " + bean.getsARL_B());//248
            System.out.print(" , " + bean.getsARL_C());//249
            System.out.print(" , " + bean.getsARL_GraBA());//250
            System.out.print(" , " + bean.getsARL_GraBC());//251
            System.out.print(" , " + bean.getsARL_GraCA());//252
            System.out.print(" , " + bean.getsARR_cbya());//253
            System.out.print(" , " + bean.getsARR_abyb());//254
            System.out.print(" , " + bean.getsARR_bbyc());//255
            System.out.print(" , " + bean.getsARR_A());//256
            System.out.print(" , " + bean.getsARR_B());//257
            System.out.print(" , " + bean.getsARR_C());//258
            System.out.print(" , " + bean.getsARR_GraBA());//259
            System.out.print(" , " + bean.getsARR_GraBC());//260
            System.out.print(" , " + bean.getsARR_GraCA());//261
            System.out.print(" , " + bean.getsBLL_cbya());//262
            System.out.print(" , " + bean.getsBLL_abyb());//263
            System.out.print(" , " + bean.getsBLL_bbyc());//264
            System.out.print(" , " + bean.getsBLL_A());//265
            System.out.print(" , " + bean.getsBLL_B());//266
            System.out.print(" , " + bean.getsBLL_C());//267
            System.out.print(" , " + bean.getsBLL_GraBA());//268
            System.out.print(" , " + bean.getsBLL_GraBC());//269
            System.out.print(" , " + bean.getsBLL_GraCA());//270
            System.out.print(" , " + bean.getsBLR_cbya());//271
            System.out.print(" , " + bean.getsBLR_abyb());//272
            System.out.print(" , " + bean.getsBLR_bbyc());//273
            System.out.print(" , " + bean.getsBLR_A());//274
            System.out.print(" , " + bean.getsBLR_B());//275
            System.out.print(" , " + bean.getsBLR_C());//276
            System.out.print(" , " + bean.getsBLR_GraBA());//277
            System.out.print(" , " + bean.getsBLR_GraBC());//278
            System.out.print(" , " + bean.getsBLR_GraCA());//279
            System.out.print(" , " + bean.getsBRL_cbya());//280
            System.out.print(" , " + bean.getsBRL_abyb());//281
            System.out.print(" , " + bean.getsBRL_bbyc());//282
            System.out.print(" , " + bean.getsBRL_A());//283
            System.out.print(" , " + bean.getsBRL_B());//284
            System.out.print(" , " + bean.getsBRL_C());//285
            System.out.print(" , " + bean.getsBRL_GraBA());//286
            System.out.print(" , " + bean.getsBRL_GraBC());//287
            System.out.print(" , " + bean.getsBRL_GraCA());//288
            System.out.print(" , " + bean.getsBRR_cbya());//289
            System.out.print(" , " + bean.getsBRR_abyb());//290
            System.out.print(" , " + bean.getsBRR_bbyc());//291
            System.out.print(" , " + bean.getsBRR_A());//292
            System.out.print(" , " + bean.getsBRR_B());//293
            System.out.print(" , " + bean.getsBRR_C());//294
            System.out.print(" , " + bean.getsBRR_GraBA());//295
            System.out.print(" , " + bean.getsBRR_GraBC());//296
            System.out.print(" , " + bean.getsBRR_GraCA());//297
            System.out.print(" , " + bean.getType());//

            System.out.println("\n");
        }

    }


}
