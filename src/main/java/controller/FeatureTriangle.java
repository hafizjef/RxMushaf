package controller;

import model.BeanComparator;
import model.Bean_Feature;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FeatureTriangle {

    private ArrayList<String[]> contentTests = new ArrayList<>();


    public void extractFeatureTriangle(ArrayList<File> publishFile, String specFileNameInput) {
        File[] filess;
        String type = specFileNameInput; //String type = null;
        BufferedImage imej_src;                                                            //source image in BufferedImaged form
        BufferedImage imej_dest;                                                        //output image
        ArrayList<BufferedImage> image_src_arr = new ArrayList<BufferedImage>();        //input images
        ArrayList<BufferedImage> image_dest_arr = new ArrayList<BufferedImage>();        //output images in list
        ArrayList<MyPointProcess45> pointProcess45 = new ArrayList<MyPointProcess45>();
        ArrayList<MyPointProcess> pointProcesses = new ArrayList<MyPointProcess>();
        ArrayList<Bean_Feature> beans = new ArrayList<Bean_Feature>();                    //buffer for storing and accessing features.
        ArrayList<Point> points = new ArrayList<Point>();

        int saiz_fail = 0;
        int SIZE;
        String path_file = null;
        File f;

        /*  UL | UR  */
        /* 	LL | LR  */

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

        /**
         * 14 May 2012
         */
        ArrayList<Point> points_left_left_upper_zone;         //LLUZ
        ArrayList<Point> points_left_right_upper_zone;        //LRUZ
        ArrayList<Point> points_right_left_upper_zone;        //RLUZ
        ArrayList<Point> points_right_right_upper_zone;       //RRUZ

        ArrayList<Point> points_left_left_bottom_zone;        //LLBZ
        ArrayList<Point> points_left_right_bottom_zone;       //LRBZ
        ArrayList<Point> points_right_left_bottom_zone;       //RLBZ
        ArrayList<Point> points_right_right_bottom_zone;      //RRBZ

        //Bahagian Atas
        ArrayList<Point> pointsAtasKiriKiri = new ArrayList<Point>();   //Upper Left Left    :ULL
        ArrayList<Point> pointsAtasKiriKanan = new ArrayList<Point>();  //Upper Left Right   :ULR
        ArrayList<Point> pointsAtasKananKiri = new ArrayList<Point>();  //Upper Right Left   :URL
        ArrayList<Point> pointsAtasKananKanan = new ArrayList<Point>(); //Upper Right Right  :URR

        //Bahagian Bawah
        ArrayList<Point> pointsBawahKiriKiri = new ArrayList<Point>();   //Lower Left Left    :LLL
        ArrayList<Point> pointsBawahKiriKanan = new ArrayList<Point>();  //Lower Left Right   :LLR
        ArrayList<Point> pointsBawahKananKiri = new ArrayList<Point>();  //Lower Right Left   :LRL
        ArrayList<Point> pointsBawahKananKanan = new ArrayList<Point>(); //Lower Right Right  :LRR

        String khat_name = null;
        JTable table;

        /***************************************************/
        /*          Function of Button Open                */
        /***************************************************/

        if (!beans.isEmpty())
            beans.clear();

        if (!image_src_arr.isEmpty())
            image_src_arr.clear();

        File currentfile;

        currentfile = new File("A:/senarai_dataset.txt");

        filess = publishFile.toArray(new File[publishFile.size()]);

        path_file = filess[0].toString();
        saiz_fail = filess.length;
        for (int i = 0; i < filess.length; i++) {
            try {
                image_src_arr.add(ImageIO.read(filess[i]));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        /***************************************************/
        /*          Function of Button Generate            */
        /***************************************************/

        /*************************************************************/
        /* If the IFHCDB is chosen, uncomment the two comments below.*/
        /* For dataset IFHCDB                                        */
        /*************************************************************/

        SIZE = image_src_arr.size();

        //To display the column name
//			textArea_Features.append("\n\n\n");
//			textArea_Features.append("**********fname**********"+",\tcbya"+",\tabyb"+",\tbbyc"+ ",\tA,\t"+"B,\t"+"C,\t"+"GrBA,\t"+"GrBC,\t"+"GrCA,\t"
//
//			+"pu_cbya"+",\tpu_abyb"+",\tpu_bbyc"+ ",\tpu_A,\t"+"pu_B,\t"+"pu_C,\t"+"pu_GrBA,\t"+"pu_GrBC,\t"+"pu_GrCA,\t"
//			+"pl_cbya"+",\tpl_abyb"+",\tpl_bbyc"+ ",\tpl_A,\t"+"pl_B,\t"+"pl_C,\t"+"pl_GrBA,\t"+"pl_GrBC,\t"+"pl_GrCA,\t"
//
//			+"ptu_cbya"+",\tptu_abyb"+",\tptu_bbyc"+ ",\tptu_A,\t"+"ptu_B,\t"+"ptu_C,\t"+"ptu_GrBA,\t"+"ptu_GrBC,\t"+"ptu_GrCA,\t"
//			+"ptl_cbya"+",\tptl_abyb"+",\tptl_bbyc"+ ",\tptl_A,\t"+"ptl_B,\t"+"ptl_C,\t"+"ptl_GrBA,\t"+"ptl_GrBC,\t"+"ptl_GrCA,\t"
//
//			+"pbu_cbya"+",\tpbu_abyb"+",\tpbu_bbyc"+ ",\tpbu_A,\t"+"pbu_B,\t"+"pbu_C,\t"+"pbu_GrBA,\t"+"pbu_GrBC,\t"+"pbu_GrCA,\t"
//			+"pbl_cbya"+",\tpbl_abyb"+",\tpbl_bbyc"+ ",\tpbl_A,\t"+"pbl_B,\t"+"pbl_C,\t"+"pbl_GrBA,\t"+"pbl_GrBC,\t"+"pbl_GrCA,\t"
//
//			+"pL_cbya"+",\tpL_abyb"+",\tpL_bbyc"+ ",\tpL_A,\t"+"pL_B,\t"+"pL_C,\t"+"pL_GrBA,\t"+"pL_GrBC,\t"+"pL_GrCA,\t"
//			+"pR_cbya"+",\tpR_abyb"+",\tpR_bbyc"+ ",\tpR_A,\t"+"pR_B,\t"+"pR_C,\t"+"pR_GrBA,\t"+"pR_GrBC,\t"+"pR_GrCA,\t"
//
//			+"pLL_cbya"+",\tpLL_abyb"+",\tpLL_bbyc"+ ",\tpLL_A,\t"+"pLL_B,\t"+"pLL_C,\t"+"pLL_GrBA,\t"+"pLL_GrBC,\t"+"pLL_GrCA,\t"
//			+"pLR_cbya"+",\tpLR_abyb"+",\tpLR_bbyc"+ ",\tpLR_A,\t"+"pLR_B,\t"+"pLR_C,\t"+"pLR_GrBA,\t"+"pLR_GrBC,\t"+"pLR_GrCA,\t"
//			+"pRL_cbya"+",\tpRL_abyb"+",\tpRL_bbyc"+ ",\tpRL_A,\t"+"pRL_B,\t"+"pRL_C,\t"+"pRL_GrBA,\t"+"pRL_GrBC,\t"+"pRL_GrCA,\t"
//			+"pRR_cbya"+",\tpRR_abyb"+",\tpRR_bbyc"+ ",\tpRR_A,\t"+"pRR_B,\t"+"pRR_C,\t"+"pRR_GrBA,\t"+"pRR_GrBC,\t"+"pRR_GrCA,\t"
//
//			+"pLLU_cbya"+",\tpLLU_abyb"+",\tpLLU_bbyc"+ ",\tpLLU_A,\t"+"pLLU_B,\t"+"pLLU_C,\t"+"pLLU_GrBA,\t"+"pLLU_GrBC,\t"+"pLLU_GrCA,\t"
//			+"pLLB_cbya"+",\tpLLB_abyb"+",\tpLLB_bbyc"+ ",\tpLLB_A,\t"+"pLLB_B,\t"+"pLLB_C,\t"+"pLLB_GrBA,\t"+"pLLB_GrBC,\t"+"pLLB_GrCA,\t"
//			+"pLRU_cbya"+",\tpLRU_abyb"+",\tpLRU_bbyc"+ ",\tpLRU_A,\t"+"pLRU_B,\t"+"pLRU_C,\t"+"pLRU_GrBA,\t"+"pLRU_GrBC,\t"+"pLRU_GrCA,\t"
//			+"pLRB_cbya"+",\tpLRB_abyb"+",\tpLRB_bbyc"+ ",\tpLRB_A,\t"+"pLRB_B,\t"+"pLRB_C,\t"+"pLRB_GrBA,\t"+"pLRB_GrBC,\t"+"pLRB_GrCA,\t"
//
//			+"pRLU_cbya"+",\tpRLU_abyb"+",\tpRLU_bbyc"+ ",\tpRLU_A,\t"+"pRLU_B,\t"+"pRLU_C,\t"+"pRLU_GrBA,\t"+"pRLU_GrBC,\t"+"pRLU_GrCA,\t"
//			+"pRLB_cbya"+",\tpRLB_abyb"+",\tpRLB_bbyc"+ ",\tpRLB_A,\t"+"pRLB_B,\t"+"pRLB_C,\t"+"pRLB_GrBA,\t"+"pRLB_GrBC,\t"+"pRLB_GrCA,\t"
//			+"pRRU_cbya"+",\tpRRU_abyb"+",\tpRRU_bbyc"+ ",\tpRRU_A,\t"+"pRRU_B,\t"+"pRRU_C,\t"+"pRRU_GrBA,\t"+"pRRU_GrBC,\t"+"pRRU_GrCA,\t"
//			+"pRRB_cbya"+",\tpRRB_abyb"+",\tpRRB_bbyc"+ ",\tpRRB_A,\t"+"pRRB_B,\t"+"pRRB_C,\t"+"pRRB_GrBA,\t"+"pRRB_GrBC,\t"+"pRRB_GrCA,\t"
//
//			+"pul_cbya"+",\tpul_abyb"+",\tpul_bbyc"+ ",\tpul_A,\t"+"pul_B,\t"+"pul_C,\t"+"pul_GrBA,\t"+"pul_GrBC,\t"+"pul_GrCA,\t"
//			+"pur_cbya"+",\tpur_abyb"+",\tpur_bbyc"+ ",\tpur_A,\t"+"pur_B,\t"+"pur_C,\t"+"pur_GrBA,\t"+"pur_GrBC,\t"+"pur_GrCA,\t"
//			+"pll_cbya"+",\tpll_abyb"+",\tpll_bbyc"+ ",\tpll_A,\t"+"pll_B,\t"+"pll_C,\t"+"pll_GrBA,\t"+"pll_GrBC,\t"+"pll_GrCA,\t"
//			+"plr_cbya"+",\tplr_abyb"+",\tplr_bbyc"+ ",\tplr_A,\t"+"plr_B,\t"+"plr_C,\t"+"plr_GrBA,\t"+"plr_GrBC,\t"+"plr_GrCA,\t"
//
//			+"sALL_cbya"+",\tsALL_abyb"+",\tsALL_bbyc"+",\tsALL_A"+",\tsALL_B"+",\tsALL_C"+",\tsALL_GrBA"+",\tsALL_GrBC"+",\tsALL_GrCA,\t"
//			+"sALR_cbya"+",\tsALR_abyb"+",\tsALR_bbyc"+",\tsALR_A"+",\tsALR_B"+",\tsALR_C"+",\tsALR_GrBA"+",\tsALR_GrBC"+",\tsALR_GrCA,\t"
//			+"sARL_cbya"+",\tsARL_abyb"+",\tsARL_bbyc"+",\tsARL_A"+",\tsARL_B"+",\tsARL_C"+",\tsARL_GrBA"+",\tsARL_GrBC"+",\tsARL_GrCA,\t"
//			+"sARR_cbya"+",\tsARR_abyb"+",\tsARR_bbyc"+",\tsARR_A"+",\tsARR_B"+",\tsARR_C"+",\tsARR_GrBA"+",\tsARR_GrBC"+",\tsARR_GrCA,\t"
//
//			+"sBLL_cbya"+",\tsBLL_abyb"+",\tsBLL_bbyc"+",\tsBLL_A"+",\tsBLL_B"+",\tsBLL_C"+",\tsBLL_GrBA"+",\tsBLL_GrBC"+",\tsBLL_GrCA,\t"
//			+"sBLR_cbya"+",\tsBLR_abyb"+",\tsBLR_bbyc"+",\tsBLR_A"+",\tsBLR_B"+",\tsBLR_C"+",\tsBLR_GrBA"+",\tsBLR_GrBC"+",\tsBLR_GrCA,\t"
//			+"sBRL_cbya"+",\tsBRL_abyb"+",\tsBRL_bbyc"+",\tsBRL_A"+",\tsBRL_B"+",\tsBRL_C"+",\tsBRL_GrBA"+",\tsBRL_GrBC"+",\tsBRL_GrCA,\t"
//			+"sBRR_cbya"+",\tsBRR_abyb"+",\tsBRR_bbyc"+",\tsBRR_A"+",\tsBRR_B"+",\tsBRR_C"+",\tsBRR_GrBA"+",\tsBRR_GrBC"+",\tsBRR_GrCA,\t"
//
//			+"File From Parents Directory\n");

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

            String filename = filess[i].getName();
//				String filename = path.getName();		take note for single uncomment if multiple file
            /*********************************/
            /*   For dataset Hoda and mnist  */
            /*********************************/

            Bean_Feature bean = new Bean_Feature();
            if (threshold == 0) {
                image_dest_arr.add(MyPointProcess.Threshold(image_src_arr.get(i), 127));
            } else
                image_dest_arr.add(MyPointProcess.Threshold(image_src_arr.get(i), threshold));

            //Add all images from JInputDialog into image_dest_arr.
            //The image_dest_arr then will be added into method add into array Point_Processes
            pointProcess45.add(new MyPointProcess45(image_dest_arr.get(i), filename));
            pointProcesses.add(new MyPointProcess(image_dest_arr.get(i), filename));

            //each element from array point process will be invoked and assigned to MyPointProcess class
            MyPointProcess45 process45 = pointProcess45.get(i);
            MyPointProcess process = pointProcesses.get(i);

            /*******************************************************/
            /*  The object process will be used to extract points. */
            /*  To get main triangle.                              */
            /*                       1|1                           */
            /*                       1|1                           */
            /*******************************************************/

            BufferedImage image_dest1 = image_dest_arr.get(i);
            points = process.getPoints(image_dest1);                    //For NFV2

            //point in the third element which is started with 0 is a centroid of image
            int y_center = points.get(2).y;
            int x_center = points.get(2).x;

            MyPointProcess.lukisImej(image_dest1);

            Point centroid = process45.getCentroid(image_dest1);        //For NF45

            Point centroid_upper_left_right = new Point(centroid);        //Upper Left Right  :c_ULR
            Point centroid_upper_right_left = new Point(centroid);      //Upper Right Left  :c_URL
            Point centroid_upper_right_right = new Point(centroid);     //Upper Right Right :c_URR

            Point centroid_lower_left_left = new Point(centroid);       //Lower Left Left   :c_LLL
            Point centroid_lower_left_right = new Point(centroid);      //Lower Left Right  :c_LLR
            Point centroid_lower_right_left = new Point(centroid);      //Lower Right Left  :c_LRL
            Point centroid_lower_right_right = new Point(centroid);     //Lower Right Right :c_LRR

//				System.out.println("**** Main Image ****");
            points = process45.getPoints(image_dest1);

//				System.out.println("**** Atas Kiri Kiri ****");
            pointsAtasKiriKiri = process45.keAtasKiriKiri(image_dest1, centroid);

//				System.out.println("**** Atas Kiri Kanan ****");
            pointsAtasKiriKanan = process45.keAtasKiriKanan(image_dest1, centroid_upper_left_right);


//				System.out.println("**** Atas Kanan Kiri ****");
            pointsAtasKananKiri = process45.keAtasKananKiri(image_dest1, centroid_upper_right_left);

//				System.out.println("**** Atas Kanan Kanan ****");
            pointsAtasKananKanan = process45.keAtasKananKanan(image_dest1, centroid_upper_right_right);

//				System.out.println("**** Bawah Kiri Kiri ****");
            pointsBawahKiriKiri = process45.keBawahKiriKiri(image_dest1, centroid_lower_left_left);

//				System.out.println("**** Bawah Kiri Kanan ****");
            pointsBawahKiriKanan = process45.keBawahKiriKanan(image_dest1, centroid_lower_left_right);

//				System.out.println("**** Bawah Kanan Kiri ****");
            pointsBawahKananKiri = process45.keBawahKananKiri(image_dest1, centroid_lower_right_left);

//				System.out.println("**** Bawah Kanan Kanan ****");
            pointsBawahKananKanan = process45.keBawahKananKanan(image_dest1, centroid_lower_right_right);

            MyPointProcess45.lukisImej(image_dest1);
//				System.out.println("\n");

            /**************************************************************************/
            /* To draw image top and bottom.                                          */
            /* Call method LukisAtas or lukisBawah and use image_dest1 with y_center. */
            /* End of main triangle.                                                  */
            /**************************************************************************/

            /*      0|0
             * 		1|0
             */
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

            /* 	0|0  */
            /* 	0|1  */
            points_lower_right = process.getLowerPointsRight(image_dest1, divider);

            /* 	1|0  */
            /* 	0|0  */
            points_upper_left = process.getUpperPointsLeft(image_dest1, divider);

            /* 	0|1  */
            /* 	0|0  */
            points_upper_right = process.getUpperPointsRight(image_dest1, divider);

            /* 	1|1  */
            /* 	1|1  */
            MyScalene scalene = new MyScalene(filename, points);
            MyScalene scalene_upper = new MyScalene(filename, points_upper);
            MyScalene scalene_lower = new MyScalene(filename, points_lower);

            // bahagian atas /2 bawah bahagi 2
            MyScalene scalene_top_upper = new MyScalene(filename, points_upper_upper);
            MyScalene scalene_top_lower = new MyScalene(filename, points_upper_lower);
            MyScalene scalene_bottom_upper = new MyScalene(filename, points_lower_upper);
            MyScalene scalene_bottom_lower = new MyScalene(filename, points_lower_lower);


            MyScalene scalene_left = new MyScalene(filename, points_left);
            MyScalene scalene_right = new MyScalene(filename, points_right);

            //tepi kiri kanan bahagi 2
            MyScalene scalene_left_left_zone = new MyScalene(filename, points_left_left_zone);
            MyScalene scalene_left_left_upper_zone = new MyScalene(filename, points_left_left_upper_zone);
            MyScalene scalene_left_left_bottom_zone = new MyScalene(filename, points_left_left_bottom_zone);
            MyScalene scalene_left_right_zone = new MyScalene(filename, points_left_right_zone);

            MyScalene scalene_left_right_upper_zone = new MyScalene(filename, points_left_right_upper_zone);
            MyScalene scalene_left_right_bottom_zone = new MyScalene(filename, points_left_right_bottom_zone);
            MyScalene scalene_right_left_zone = new MyScalene(filename, points_right_left_zone);

            MyScalene scalene_right_left_upper_zone = new MyScalene(filename, points_right_left_upper_zone);
            MyScalene scalene_right_left_bottom_zone = new MyScalene(filename, points_right_left_bottom_zone);
            MyScalene scalene_right_right_zone = new MyScalene(filename, points_right_right_zone);

            MyScalene scalene_right_right_upper_zone = new MyScalene(filename, points_right_right_upper_zone);
            MyScalene scalene_right_right_bottom_zone = new MyScalene(filename, points_right_right_bottom_zone);

            MyScalene scalene_points_upper_left = new MyScalene(filename, points_upper_left);
            MyScalene scalene_points_upper_right = new MyScalene(filename, points_upper_right);
            MyScalene scalene_points_lower_left = new MyScalene(filename, points_lower_left);
            MyScalene scalene_points_lower_right = new MyScalene(filename, points_lower_right);

            //NF45
            //Bahagian Atas 45 darjah
            MyScalene sALL = new MyScalene(filename, pointsAtasKiriKiri);
            MyScalene sALR = new MyScalene(filename, pointsAtasKiriKanan);
            MyScalene sARL = new MyScalene(filename, pointsAtasKananKiri);
            MyScalene sARR = new MyScalene(filename, pointsAtasKananKanan);

            //Bahagian Bawah 45 darjah
            MyScalene sBLL = new MyScalene(filename, pointsBawahKiriKiri);
            MyScalene sBLR = new MyScalene(filename, pointsBawahKiriKanan);
            MyScalene sBRL = new MyScalene(filename, pointsBawahKananKiri);
            MyScalene sBRR = new MyScalene(filename, pointsBawahKananKanan);

            scalene.getTrianglePerimeter();
            scalene_upper.getTrianglePerimeter();
            scalene_lower.getTrianglePerimeter();

            scalene_top_upper.getTrianglePerimeter();
            scalene_top_lower.getTrianglePerimeter();
            scalene_bottom_upper.getTrianglePerimeter();
            scalene_bottom_lower.getTrianglePerimeter();


            scalene_left.getTrianglePerimeter();
            scalene_right.getTrianglePerimeter();

            scalene_left_left_zone.getTrianglePerimeter();
            scalene_left_right_zone.getTrianglePerimeter();
            scalene_right_left_zone.getTrianglePerimeter();
            scalene_right_right_zone.getTrianglePerimeter();

            /*
             * Features under Left and Right Zones
             */

            scalene_left_left_upper_zone.getTrianglePerimeter();
            scalene_left_left_bottom_zone.getTrianglePerimeter();

            scalene_left_right_upper_zone.getTrianglePerimeter();
            scalene_left_right_bottom_zone.getTrianglePerimeter();

            scalene_right_left_upper_zone.getTrianglePerimeter();
            scalene_right_left_bottom_zone.getTrianglePerimeter();

            scalene_right_right_upper_zone.getTrianglePerimeter();
            scalene_right_right_bottom_zone.getTrianglePerimeter();

            scalene_points_upper_left.getTrianglePerimeter();
            scalene_points_upper_right.getTrianglePerimeter();
            scalene_points_lower_left.getTrianglePerimeter();
            scalene_points_lower_right.getTrianglePerimeter();

            //Bahagian Atas 45 darjah
            sALL.getTrianglePerimeter();
            sALR.getTrianglePerimeter();
            sARL.getTrianglePerimeter();
            sARR.getTrianglePerimeter();

            //Bahagian Bawah 45 darjah
            sBLL.getTrianglePerimeter();
            sBLR.getTrianglePerimeter();
            sBRL.getTrianglePerimeter();
            sBRR.getTrianglePerimeter();

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
            float su_bbyc = (float) scalene_upper.getRatioBbyC();
            float su_A = (float) scalene_upper.getAngleA();
            float su_B = (float) scalene_upper.getAngleB();
            float su_C = (float) scalene_upper.getAngleC();
            float su_GBA = (float) scalene_upper.getGradientBA();
            float su_GBC = (float) scalene_upper.getGradientBC();
            float su_GCA = (float) scalene_upper.getGradientCA();
            float su_abyb = (float) scalene_upper.getRatioAbyB();

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

            float stu_cbya = (float) scalene_top_upper.getRatioCbyA();
            float stu_abyb = (float) scalene_top_upper.getRatioAbyB();
            float stu_bbyc = (float) scalene_top_upper.getRatioBbyC();
            float stu_A = (float) scalene_top_upper.getAngleA();
            float stu_B = (float) scalene_top_upper.getAngleB();
            float stu_C = (float) scalene_top_upper.getAngleC();
            float stu_GBA = (float) scalene_top_upper.getGradientBA();
            float stu_GBC = (float) scalene_top_upper.getGradientBC();
            float stu_GCA = (float) scalene_top_upper.getGradientCA();

            /*
             * Top Lower Zone 05
             */
            float stl_cbya = (float) scalene_top_lower.getRatioCbyA();
            float stl_abyb = (float) scalene_top_lower.getRatioAbyB();
            float stl_bbyc = (float) scalene_top_lower.getRatioBbyC();
            float stl_A = (float) scalene_top_lower.getAngleA();
            float stl_B = (float) scalene_top_lower.getAngleB();
            float stl_C = (float) scalene_top_lower.getAngleC();
            float stl_GBA = (float) scalene_top_lower.getGradientBA();
            float stl_GBC = (float) scalene_top_lower.getGradientBC();
            float stl_GCA = (float) scalene_top_lower.getGradientCA();

            /*
             * Bottom Upper Zone 06
             */
            float sbu_cbya = (float) scalene_bottom_upper.getRatioCbyA();
            float sbu_abyb = (float) scalene_bottom_upper.getRatioAbyB();
            float sbu_bbyc = (float) scalene_bottom_upper.getRatioBbyC();
            float sbu_A = (float) scalene_bottom_upper.getAngleA();
            float sbu_B = (float) scalene_bottom_upper.getAngleB();
            float sbu_C = (float) scalene_bottom_upper.getAngleC();
            float sbu_GBA = (float) scalene_bottom_upper.getGradientBA();
            float sbu_GBC = (float) scalene_bottom_upper.getGradientBC();
            float sbu_GCA = (float) scalene_bottom_upper.getGradientCA();

            /*
             * Bottom Lower Zone 07
             */
            float sbl_cbya = (float) scalene_bottom_lower.getRatioCbyA();
            float sbl_abyb = (float) scalene_bottom_lower.getRatioAbyB();
            float sbl_bbyc = (float) scalene_bottom_lower.getRatioBbyC();
            float sbl_A = (float) scalene_bottom_lower.getAngleA();
            float sbl_B = (float) scalene_bottom_lower.getAngleB();
            float sbl_C = (float) scalene_bottom_lower.getAngleC();
            float sbl_GBA = (float) scalene_bottom_lower.getGradientBA();
            float sbl_GBC = (float) scalene_bottom_lower.getGradientBC();
            float sbl_GCA = (float) scalene_bottom_lower.getGradientCA();

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

//				11

            float sLRZ_cbya = (float) scalene_left_right_zone.getRatioCbyA();
            float sLRZ_abyb = (float) scalene_left_right_zone.getRatioAbyB();
            float sLRZ_bbyc = (float) scalene_left_right_zone.getRatioBbyC();
            float sLRZ_A = (float) scalene_left_right_zone.getAngleA();
            float sLRZ_B = (float) scalene_left_right_zone.getAngleB();
            float sLRZ_C = (float) scalene_left_right_zone.getAngleC();
            float sLRZ_GBA = (float) scalene_left_right_zone.getGradientBA();
            float sLRZ_GBC = (float) scalene_left_right_zone.getGradientBC();
            float sLRZ_GCA = (float) scalene_left_right_zone.getGradientCA();

//				12
            float sRLZ_cbya = (float) scalene_right_left_zone.getRatioCbyA();
            float sRLZ_abyb = (float) scalene_right_left_zone.getRatioAbyB();
            float sRLZ_bbyc = (float) scalene_right_left_zone.getRatioBbyC();
            float sRLZ_A = (float) scalene_right_left_zone.getAngleA();
            float sRLZ_B = (float) scalene_right_left_zone.getAngleB();
            float sRLZ_C = (float) scalene_right_left_zone.getAngleC();
            float sRLZ_GBA = (float) scalene_right_left_zone.getGradientBA();
            float sRLZ_GBC = (float) scalene_right_left_zone.getGradientBC();
            float sRLZ_GCA = (float) scalene_right_left_zone.getGradientCA();

//				13
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

//					15
            float sLLBZ_cbya = (float) scalene_left_left_bottom_zone.getRatioCbyA();
            float sLLBZ_abyb = (float) scalene_left_left_bottom_zone.getRatioAbyB();
            float sLLBZ_bbyc = (float) scalene_left_left_bottom_zone.getRatioBbyC();
            float sLLBZ_A = (float) scalene_left_left_bottom_zone.getAngleA();
            float sLLBZ_B = (float) scalene_left_left_bottom_zone.getAngleB();
            float sLLBZ_C = (float) scalene_left_left_bottom_zone.getAngleC();
            float sLLBZ_GBA = (float) scalene_left_left_bottom_zone.getGradientBA();
            float sLLBZ_GBC = (float) scalene_left_left_bottom_zone.getGradientBC();
            float sLLBZ_GCA = (float) scalene_left_left_bottom_zone.getGradientCA();

//					16
            float sLRUZ_cbya = (float) scalene_left_right_upper_zone.getRatioCbyA();
            float sLRUZ_abyb = (float) scalene_left_right_upper_zone.getRatioAbyB();
            float sLRUZ_bbyc = (float) scalene_left_right_upper_zone.getRatioBbyC();
            float sLRUZ_A = (float) scalene_left_right_upper_zone.getAngleA();
            float sLRUZ_B = (float) scalene_left_right_upper_zone.getAngleB();
            float sLRUZ_C = (float) scalene_left_right_upper_zone.getAngleC();
            float sLRUZ_GBA = (float) scalene_left_right_upper_zone.getGradientBA();
            float sLRUZ_GBC = (float) scalene_left_right_upper_zone.getGradientBC();
            float sLRUZ_GCA = (float) scalene_left_right_upper_zone.getGradientCA();

//					17
            float sLRBZ_cbya = (float) scalene_left_right_bottom_zone.getRatioCbyA();
            float sLRBZ_abyb = (float) scalene_left_right_bottom_zone.getRatioAbyB();
            float sLRBZ_bbyc = (float) scalene_left_right_bottom_zone.getRatioBbyC();
            float sLRBZ_A = (float) scalene_left_right_bottom_zone.getAngleA();
            float sLRBZ_B = (float) scalene_left_right_bottom_zone.getAngleB();
            float sLRBZ_C = (float) scalene_left_right_bottom_zone.getAngleC();
            float sLRBZ_GBA = (float) scalene_left_right_bottom_zone.getGradientBA();
            float sLRBZ_GBC = (float) scalene_left_right_bottom_zone.getGradientBC();
            float sLRBZ_GCA = (float) scalene_left_right_bottom_zone.getGradientCA();

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

//					19
            float sRLBZ_cbya = (float) scalene_right_left_bottom_zone.getRatioCbyA();
            float sRLBZ_abyb = (float) scalene_right_left_bottom_zone.getRatioAbyB();
            float sRLBZ_bbyc = (float) scalene_right_left_bottom_zone.getRatioBbyC();
            float sRLBZ_A = (float) scalene_right_left_bottom_zone.getAngleA();
            float sRLBZ_B = (float) scalene_right_left_bottom_zone.getAngleB();
            float sRLBZ_C = (float) scalene_right_left_bottom_zone.getAngleC();
            float sRLBZ_GBA = (float) scalene_right_left_bottom_zone.getGradientBA();
            float sRLBZ_GBC = (float) scalene_right_left_bottom_zone.getGradientBC();
            float sRLBZ_GCA = (float) scalene_right_left_bottom_zone.getGradientCA();

//					20
            float sRRUZ_cbya = (float) scalene_right_right_upper_zone.getRatioCbyA();
            float sRRUZ_abyb = (float) scalene_right_right_upper_zone.getRatioAbyB();
            float sRRUZ_bbyc = (float) scalene_right_right_upper_zone.getRatioBbyC();
            float sRRUZ_A = (float) scalene_right_right_upper_zone.getAngleA();
            float sRRUZ_B = (float) scalene_right_right_upper_zone.getAngleB();
            float sRRUZ_C = (float) scalene_right_right_upper_zone.getAngleC();
            float sRRUZ_GBA = (float) scalene_right_right_upper_zone.getGradientBA();
            float sRRUZ_GBC = (float) scalene_right_right_upper_zone.getGradientBC();
            float sRRUZ_GCA = (float) scalene_right_right_upper_zone.getGradientCA();

//					21
            float sRRBZ_cbya = (float) scalene_right_right_bottom_zone.getRatioCbyA();
            float sRRBZ_abyb = (float) scalene_right_right_bottom_zone.getRatioAbyB();
            float sRRBZ_bbyc = (float) scalene_right_right_bottom_zone.getRatioBbyC();
            float sRRBZ_A = (float) scalene_right_right_bottom_zone.getAngleA();
            float sRRBZ_B = (float) scalene_right_right_bottom_zone.getAngleB();
            float sRRBZ_C = (float) scalene_right_right_bottom_zone.getAngleC();
            float sRRBZ_GBA = (float) scalene_right_right_bottom_zone.getGradientBA();
            float sRRBZ_GBC = (float) scalene_right_right_bottom_zone.getGradientBC();
            float sRRBZ_GCA = (float) scalene_right_right_bottom_zone.getGradientCA();
//				22
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

            String[] testdata = new String[299];
            testdata[0] = s_fname.toString();
            testdata[1] = String.valueOf(s_cbya);
            testdata[2] = String.valueOf(s_abyb);
            testdata[3] = String.valueOf(s_bbyc);
            testdata[4] = String.valueOf(s_A);
            testdata[5] = String.valueOf(s_B);
            testdata[6] = String.valueOf(s_C);
            testdata[7] = String.valueOf(s_GBA);
            testdata[8] = String.valueOf(s_GBC);
            testdata[9] = String.valueOf(s_GCA);

            /*
             * Upper Zone 02
             */

            testdata[10] = String.valueOf(su_cbya);
            testdata[11] = String.valueOf(su_bbyc);
            testdata[12] = String.valueOf(su_A);
            testdata[13] = String.valueOf(su_B);
            testdata[14] = String.valueOf(su_C);
            testdata[15] = String.valueOf(su_GBA);
            testdata[16] = String.valueOf(su_GBC);
            testdata[17] = String.valueOf(su_GCA);
            testdata[18] = String.valueOf(su_abyb);

            /*
             * Lower Zone 03
             */

            testdata[19] = String.valueOf(sl_cbya);
            testdata[20] = String.valueOf(sl_abyb);
            testdata[21] = String.valueOf(sl_bbyc);
            testdata[22] = String.valueOf(sl_A);
            testdata[23] = String.valueOf(sl_B);
            testdata[24] = String.valueOf(sl_C);
            testdata[25] = String.valueOf(sl_GBA);
            testdata[26] = String.valueOf(sl_GBC);
            testdata[27] = String.valueOf(sl_GCA);

            /*
             * Top Upper Zone 04
             */

            testdata[28] = String.valueOf(stu_cbya);
            testdata[29] = String.valueOf(stu_abyb);
            testdata[30] = String.valueOf(stu_bbyc);
            testdata[31] = String.valueOf(stu_A);
            testdata[32] = String.valueOf(stu_B);
            testdata[33] = String.valueOf(stu_C);
            testdata[34] = String.valueOf(stu_GBA);
            testdata[35] = String.valueOf(stu_GBC);
            testdata[36] = String.valueOf(stu_GCA);

            /*
             * Top Lower Zone 05
             */
            testdata[37] = String.valueOf(stl_cbya);
            testdata[38] = String.valueOf(stl_abyb);
            testdata[39] = String.valueOf(stl_bbyc);
            testdata[40] = String.valueOf(stl_A);
            testdata[41] = String.valueOf(stl_B);
            testdata[42] = String.valueOf(stl_C);
            testdata[43] = String.valueOf(stl_GBA);
            testdata[44] = String.valueOf(stl_GBC);
            testdata[45] = String.valueOf(stl_GCA);

            /*
             * Bottom Upper Zone 06
             */
            testdata[46] = String.valueOf(sbu_cbya);
            testdata[47] = String.valueOf(sbu_abyb);
            testdata[48] = String.valueOf(sbu_bbyc);
            testdata[49] = String.valueOf(sbu_A);
            testdata[50] = String.valueOf(sbu_B);
            testdata[51] = String.valueOf(sbu_C);
            testdata[52] = String.valueOf(sbu_GBA);
            testdata[53] = String.valueOf(sbu_GBC);
            testdata[54] = String.valueOf(sbu_GCA);

            /*
             * Bottom Lower Zone 07
             */
            testdata[55] = String.valueOf(sbl_cbya);
            testdata[56] = String.valueOf(sbl_abyb);
            testdata[57] = String.valueOf(sbl_bbyc);
            testdata[58] = String.valueOf(sbl_A);
            testdata[59] = String.valueOf(sbl_B);
            testdata[60] = String.valueOf(sbl_C);
            testdata[61] = String.valueOf(sbl_GBA);
            testdata[62] = String.valueOf(sbl_GBC);
            testdata[63] = String.valueOf(sbl_GCA);

            /*
             * Left Zone 08
             */
            testdata[64] = String.valueOf(s_Lcbya);
            testdata[65] = String.valueOf(s_Labyb);
            testdata[66] = String.valueOf(s_Lbbyc);
            testdata[67] = String.valueOf(s_LA);
            testdata[68] = String.valueOf(s_LB);
            testdata[69] = String.valueOf(s_LC);
            testdata[70] = String.valueOf(s_LGBA);
            testdata[71] = String.valueOf(s_LGBC);
            testdata[72] = String.valueOf(s_LGCA);

            /*
             * Right Zone 09
             */

            testdata[73] = String.valueOf(s_Rcbya);
            testdata[74] = String.valueOf(s_Rabyb);
            testdata[75] = String.valueOf(s_Rbbyc);
            testdata[76] = String.valueOf(s_RA);
            testdata[77] = String.valueOf(s_RB);
            testdata[78] = String.valueOf(s_RC);
            testdata[79] = String.valueOf(s_RGBA);
            testdata[80] = String.valueOf(s_RGBC);
            testdata[81] = String.valueOf(s_RGCA);

            /*
             * tepi 2 side bahagi 2 10
             */
            testdata[82] = String.valueOf(sLLZ_cbya);
            testdata[83] = String.valueOf(sLLZ_abyb);
            testdata[84] = String.valueOf(sLLZ_bbyc);
            testdata[85] = String.valueOf(sLLZ_A);
            testdata[86] = String.valueOf(sLLZ_B);
            testdata[87] = String.valueOf(sLLZ_C);
            testdata[88] = String.valueOf(sLLZ_GBA);
            testdata[89] = String.valueOf(sLLZ_GBC);
            testdata[90] = String.valueOf(sLLZ_GCA);

//				11

            testdata[91] = String.valueOf(sLRZ_cbya);
            testdata[92] = String.valueOf(sLRZ_abyb);
            testdata[93] = String.valueOf(sLRZ_bbyc);
            testdata[94] = String.valueOf(sLRZ_A);
            testdata[95] = String.valueOf(sLRZ_B);
            testdata[96] = String.valueOf(sLRZ_C);
            testdata[97] = String.valueOf(sLRZ_GBA);
            testdata[98] = String.valueOf(sLRZ_GBC);
            testdata[99] = String.valueOf(sLRZ_GCA);

//				12
            testdata[100] = String.valueOf(sRLZ_cbya);
            testdata[101] = String.valueOf(sRLZ_abyb);
            testdata[102] = String.valueOf(sRLZ_bbyc);
            testdata[103] = String.valueOf(sRLZ_A);
            testdata[104] = String.valueOf(sRLZ_B);
            testdata[105] = String.valueOf(sRLZ_C);
            testdata[106] = String.valueOf(sRLZ_GBA);
            testdata[107] = String.valueOf(sRLZ_GBC);
            testdata[108] = String.valueOf(sRLZ_GCA);

//				13
            testdata[109] = String.valueOf(sRRZ_cbya);
            testdata[110] = String.valueOf(sRRZ_abyb);
            testdata[111] = String.valueOf(sRRZ_bbyc);
            testdata[112] = String.valueOf(sRRZ_A);
            testdata[113] = String.valueOf(sRRZ_B);
            testdata[114] = String.valueOf(sRRZ_C);
            testdata[115] = String.valueOf(sRRZ_GBA);
            testdata[116] = String.valueOf(sRRZ_GBC);
            testdata[117] = String.valueOf(sRRZ_GCA);

            /*
             * Features under Left Zone and Right Zone 14
             */
            testdata[118] = String.valueOf(sLLUZ_cbya);
            testdata[119] = String.valueOf(sLLUZ_abyb);
            testdata[120] = String.valueOf(sLLUZ_bbyc);
            testdata[121] = String.valueOf(sLLUZ_A);
            testdata[122] = String.valueOf(sLLUZ_B);
            testdata[123] = String.valueOf(sLLUZ_C);
            testdata[124] = String.valueOf(sLLUZ_GBA);
            testdata[125] = String.valueOf(sLLUZ_GBC);
            testdata[126] = String.valueOf(sLLUZ_GCA);

//					15
            testdata[127] = String.valueOf(sLLBZ_cbya);
            testdata[128] = String.valueOf(sLLBZ_abyb);
            testdata[129] = String.valueOf(sLLBZ_bbyc);
            testdata[130] = String.valueOf(sLLBZ_A);
            testdata[131] = String.valueOf(sLLBZ_B);
            testdata[132] = String.valueOf(sLLBZ_C);
            testdata[133] = String.valueOf(sLLBZ_GBA);
            testdata[134] = String.valueOf(sLLBZ_GBC);
            testdata[135] = String.valueOf(sLLBZ_GCA);

//					16
            testdata[136] = String.valueOf(sLRUZ_cbya);
            testdata[137] = String.valueOf(sLRUZ_abyb);
            testdata[138] = String.valueOf(sLRUZ_bbyc);
            testdata[139] = String.valueOf(sLRUZ_A);
            testdata[140] = String.valueOf(sLRUZ_B);
            testdata[141] = String.valueOf(sLRUZ_C);
            testdata[142] = String.valueOf(sLRUZ_GBA);
            testdata[143] = String.valueOf(sLRUZ_GBC);
            testdata[144] = String.valueOf(sLRUZ_GCA);

//					17
            testdata[145] = String.valueOf(sLRBZ_cbya);
            testdata[146] = String.valueOf(sLRBZ_abyb);
            testdata[147] = String.valueOf(sLRBZ_bbyc);
            testdata[148] = String.valueOf(sLRBZ_A);
            testdata[149] = String.valueOf(sLRBZ_B);
            testdata[150] = String.valueOf(sLRBZ_C);
            testdata[151] = String.valueOf(sLRBZ_GBA);
            testdata[152] = String.valueOf(sLRBZ_GBC);
            testdata[153] = String.valueOf(sLRBZ_GCA);

            /*
             * ------------------------------------------------------------
             * Right Zone left and Right Zone Right 18
             * ------------------------------------------------------------
             */
            testdata[154] = String.valueOf(sRLUZ_cbya);
            testdata[155] = String.valueOf(sRLUZ_abyb);
            testdata[156] = String.valueOf(sRLUZ_bbyc);
            testdata[157] = String.valueOf(sRLUZ_A);
            testdata[158] = String.valueOf(sRLUZ_B);
            testdata[159] = String.valueOf(sRLUZ_C);
            testdata[160] = String.valueOf(sRLUZ_GBA);
            testdata[161] = String.valueOf(sRLUZ_GBC);
            testdata[162] = String.valueOf(sRLUZ_GCA);

//					19
            testdata[163] = String.valueOf(sRLBZ_cbya);
            testdata[164] = String.valueOf(sRLBZ_abyb);
            testdata[165] = String.valueOf(sRLBZ_bbyc);
            testdata[166] = String.valueOf(sRLBZ_A);
            testdata[167] = String.valueOf(sRLBZ_B);
            testdata[168] = String.valueOf(sRLBZ_C);
            testdata[169] = String.valueOf(sRLBZ_GBA);
            testdata[170] = String.valueOf(sRLBZ_GBC);
            testdata[171] = String.valueOf(sRLBZ_GCA);

//					20
            testdata[172] = String.valueOf(sRRUZ_cbya);
            testdata[173] = String.valueOf(sRRUZ_abyb);
            testdata[174] = String.valueOf(sRRUZ_bbyc);
            testdata[175] = String.valueOf(sRRUZ_A);
            testdata[176] = String.valueOf(sRRUZ_B);
            testdata[177] = String.valueOf(sRRUZ_C);
            testdata[178] = String.valueOf(sRRUZ_GBA);
            testdata[179] = String.valueOf(sRRUZ_GBC);
            testdata[180] = String.valueOf(sRRUZ_GCA);

//					21
            testdata[181] = String.valueOf(sRRBZ_cbya);
            testdata[182] = String.valueOf(sRRBZ_abyb);
            testdata[183] = String.valueOf(sRRBZ_bbyc);
            testdata[184] = String.valueOf(sRRBZ_A);
            testdata[185] = String.valueOf(sRRBZ_B);
            testdata[186] = String.valueOf(sRRBZ_C);
            testdata[187] = String.valueOf(sRRBZ_GBA);
            testdata[188] = String.valueOf(sRRBZ_GBC);
            testdata[189] = String.valueOf(sRRBZ_GCA);
//				22
            testdata[190] = String.valueOf(sPUL_cbya);
            testdata[191] = String.valueOf(sPUL_abyb);
            testdata[192] = String.valueOf(sPUL_bbyc);
            testdata[193] = String.valueOf(sPUL_A);
            testdata[194] = String.valueOf(sPUL_B);
            testdata[195] = String.valueOf(sPUL_C);
            testdata[196] = String.valueOf(sPUL_GBA);
            testdata[197] = String.valueOf(sPUL_GBC);
            testdata[198] = String.valueOf(sPUL_GCA);

            /*
             * Upper Right 23
             */
            testdata[199] = String.valueOf(sPUR_cbya);
            testdata[200] = String.valueOf(sPUR_abyb);
            testdata[201] = String.valueOf(sPUR_bbyc);
            testdata[202] = String.valueOf(sPUR_A);
            testdata[203] = String.valueOf(sPUR_B);
            testdata[204] = String.valueOf(sPUR_C);
            testdata[205] = String.valueOf(sPUR_GBA);
            testdata[206] = String.valueOf(sPUR_GBC);
            testdata[207] = String.valueOf(sPUR_GCA);

            /*
             * Lower Left 24
             */
            testdata[208] = String.valueOf(sPLL_cbya);
            testdata[209] = String.valueOf(sPLL_abyb);
            testdata[210] = String.valueOf(sPLL_bbyc);
            testdata[211] = String.valueOf(sPLL_A);
            testdata[212] = String.valueOf(sPLL_B);
            testdata[213] = String.valueOf(sPLL_C);
            testdata[214] = String.valueOf(sPLL_GBA);
            testdata[215] = String.valueOf(sPLL_GBC);
            testdata[216] = String.valueOf(sPLL_GCA);

            /*
             * Lower Right 25
             */
            testdata[217] = String.valueOf(sPLR_cbya);
            testdata[218] = String.valueOf(sPLR_abyb);
            testdata[219] = String.valueOf(sPLR_bbyc);
            testdata[220] = String.valueOf(sPLR_A);
            testdata[221] = String.valueOf(sPLR_B);
            testdata[222] = String.valueOf(sPLR_C);
            testdata[223] = String.valueOf(sPLR_GBA);
            testdata[224] = String.valueOf(sPLR_GBC);
            testdata[225] = String.valueOf(sPLR_GCA);

            //sALL 26
            testdata[226] = String.valueOf(sALL_cbya);
            testdata[227] = String.valueOf(sALL_abyb);
            testdata[228] = String.valueOf(sALL_bbyc);
            testdata[229] = String.valueOf(sALL_A);
            testdata[230] = String.valueOf(sALL_B);
            testdata[231] = String.valueOf(sALL_C);
            testdata[232] = String.valueOf(sALL_GBA);
            testdata[233] = String.valueOf(sALL_GBC);
            testdata[234] = String.valueOf(sALL_GCA);

            //sALR 27
            testdata[235] = String.valueOf(sALR_cbya);
            testdata[236] = String.valueOf(sALR_abyb);
            testdata[237] = String.valueOf(sALR_bbyc);
            testdata[238] = String.valueOf(sALR_A);
            testdata[239] = String.valueOf(sALR_B);
            testdata[240] = String.valueOf(sALR_C);
            testdata[241] = String.valueOf(sALR_GBA);
            testdata[242] = String.valueOf(sALR_GBC);
            testdata[243] = String.valueOf(sALR_GCA);

            //sARL 28
            testdata[244] = String.valueOf(sARL_cbya);
            testdata[245] = String.valueOf(sARL_abyb);
            testdata[246] = String.valueOf(sARL_bbyc);
            testdata[247] = String.valueOf(sARL_A);
            testdata[248] = String.valueOf(sARL_B);
            testdata[249] = String.valueOf(sARL_C);
            testdata[250] = String.valueOf(sARL_GBA);
            testdata[251] = String.valueOf(sARL_GBC);
            testdata[252] = String.valueOf(sARL_GCA);

            //sARR 29
            testdata[253] = String.valueOf(sARR_cbya);
            testdata[254] = String.valueOf(sARR_abyb);
            testdata[255] = String.valueOf(sARR_bbyc);
            testdata[256] = String.valueOf(sARR_A);
            testdata[257] = String.valueOf(sARR_B);
            testdata[258] = String.valueOf(sARR_C);
            testdata[259] = String.valueOf(sARR_GBA);
            testdata[260] = String.valueOf(sARR_GBC);
            testdata[261] = String.valueOf(sARR_GCA);

            //sBLL 30
            testdata[262] = String.valueOf(sBLL_cbya);
            testdata[263] = String.valueOf(sBLL_abyb);
            testdata[264] = String.valueOf(sBLL_bbyc);
            testdata[265] = String.valueOf(sBLL_A);
            testdata[266] = String.valueOf(sBLL_B);
            testdata[267] = String.valueOf(sBLL_C);
            testdata[268] = String.valueOf(sBLL_GBA);
            testdata[269] = String.valueOf(sBLL_GBC);
            testdata[270] = String.valueOf(sBLL_GCA);

            //sBLR 31
            testdata[271] = String.valueOf(sBLR_cbya);
            testdata[272] = String.valueOf(sBLR_abyb);
            testdata[273] = String.valueOf(sBLR_bbyc);
            testdata[274] = String.valueOf(sBLR_A);
            testdata[275] = String.valueOf(sBLR_B);
            testdata[276] = String.valueOf(sBLR_C);
            testdata[277] = String.valueOf(sBLR_GBA);
            testdata[278] = String.valueOf(sBLR_GBC);
            testdata[279] = String.valueOf(sBLR_GCA);

            //sBRL 32
            testdata[280] = String.valueOf(sBRL_cbya);
            testdata[281] = String.valueOf(sBRL_abyb);
            testdata[282] = String.valueOf(sBRL_bbyc);
            testdata[283] = String.valueOf(sBRL_A);
            testdata[284] = String.valueOf(sBRL_B);
            testdata[285] = String.valueOf(sBRL_C);
            testdata[286] = String.valueOf(sBRL_GBA);
            testdata[287] = String.valueOf(sBRL_GBC);
            testdata[288] = String.valueOf(sBRL_GCA);

            //sBRR 33
            testdata[289] = String.valueOf(sBRR_cbya);
            testdata[290] = String.valueOf(sBRR_abyb);
            testdata[291] = String.valueOf(sBRR_bbyc);
            testdata[292] = String.valueOf(sBRR_A);
            testdata[293] = String.valueOf(sBRR_B);
            testdata[294] = String.valueOf(sBRR_C);
            testdata[295] = String.valueOf(sBRR_GBA);
            testdata[296] = String.valueOf(sBRR_GBC);
            testdata[297] = String.valueOf(sBRR_GCA);
            testdata[298] = type;

            contentTests.add(testdata);

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
            bean.setsLLZ_bbyc(sLLZ_cbya);
            bean.setsLLZ_abyb(sLLZ_abyb);
            bean.setsLLZ_bbyc(sLLZ_bbyc);
            bean.setsLLZ_A(sLLZ_A);
            bean.setsLLZ_B(sLLZ_B);
            bean.setsLLZ_C(sLLZ_C);
            bean.setsLLZ_GraBA(sLLZ_GBA);
            bean.setsLLZ_GraBC(sLLZ_GBC);
            bean.setsLLZ_GraCA(sLLZ_GCA);

            bean.setsLRZ_bbyc(sLRZ_cbya);
            bean.setsLRZ_abyb(sLRZ_abyb);
            bean.setsLRZ_bbyc(sLRZ_bbyc);
            bean.setsLRZ_A(sLRZ_A);
            bean.setsLRZ_B(sLRZ_B);
            bean.setsLRZ_C(sLRZ_C);
            bean.setsLRZ_GraBA(sLRZ_GBA);
            bean.setsLRZ_GraBC(sLRZ_GBC);
            bean.setsLRZ_GraCA(sLRZ_GCA);

            bean.setsRLZ_bbyc(sRLZ_cbya);
            bean.setsRLZ_abyb(sRLZ_abyb);
            bean.setsRLZ_bbyc(sRLZ_bbyc);
            bean.setsRLZ_A(sRLZ_A);
            bean.setsRLZ_B(sLLZ_B);
            bean.setsRLZ_C(sRLZ_C);
            bean.setsRLZ_GraBA(sRLZ_GBA);
            bean.setsRLZ_GraBC(sRLZ_GBC);
            bean.setsRLZ_GraCA(sRLZ_GCA);

            bean.setsRRZ_bbyc(sRRZ_cbya);
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

            bean.setsLLUZ_bbyc(sLLUZ_cbya);
            bean.setsLLUZ_abyb(sLLUZ_abyb);
            bean.setsLLUZ_bbyc(sLLUZ_bbyc);
            bean.setsLLUZ_A(sLLUZ_A);
            bean.setsLLUZ_B(sLLUZ_B);
            bean.setsLLUZ_C(sLLUZ_C);
            bean.setsLLUZ_GraBA(sLLUZ_GBA);
            bean.setsLLUZ_GraBC(sLLUZ_GBC);
            bean.setsLLUZ_GraCA(sLLUZ_GCA);

            bean.setsLLBZ_bbyc(sLLBZ_cbya);
            bean.setsLLBZ_abyb(sLLBZ_abyb);
            bean.setsLLBZ_bbyc(sLLBZ_bbyc);
            bean.setsLLBZ_A(sLLBZ_A);
            bean.setsLLBZ_B(sLLBZ_B);
            bean.setsLLBZ_C(sLLBZ_C);
            bean.setsLLBZ_GraBA(sLLBZ_GBA);
            bean.setsLLBZ_GraBC(sLLBZ_GBC);
            bean.setsLLBZ_GraCA(sLLBZ_GCA);

            bean.setsLRUZ_bbyc(sLRUZ_cbya);
            bean.setsLRUZ_abyb(sLRUZ_abyb);
            bean.setsLRUZ_bbyc(sLRUZ_bbyc);
            bean.setsLRUZ_A(sLRUZ_A);
            bean.setsLRUZ_B(sLRUZ_B);
            bean.setsLRUZ_C(sLRUZ_C);
            bean.setsLRUZ_GraBA(sLRUZ_GBA);
            bean.setsLRUZ_GraBC(sLRUZ_GBC);
            bean.setsLRUZ_GraCA(sLRUZ_GCA);

            bean.setsLRBZ_bbyc(sLRBZ_cbya);
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

            bean.setsRLUZ_bbyc(sRLUZ_cbya);
            bean.setsRLUZ_abyb(sRLUZ_abyb);
            bean.setsRLUZ_bbyc(sRLUZ_bbyc);
            bean.setsRLUZ_A(sRLUZ_A);
            bean.setsRLUZ_B(sRLUZ_B);
            bean.setsRLUZ_C(sRLUZ_C);
            bean.setsRLUZ_GraBA(sRLUZ_GBA);
            bean.setsRLUZ_GraBC(sRLUZ_GBC);
            bean.setsRLUZ_GraCA(sRLUZ_GCA);

            bean.setsRLBZ_bbyc(sRLBZ_cbya);
            bean.setsRLBZ_abyb(sRLBZ_abyb);
            bean.setsRLBZ_bbyc(sRLBZ_bbyc);
            bean.setsRLBZ_A(sRLBZ_A);
            bean.setsRLBZ_B(sRLBZ_B);
            bean.setsRLBZ_C(sRLBZ_C);
            bean.setsRLBZ_GraBA(sRLBZ_GBA);
            bean.setsRLBZ_GraBC(sRLBZ_GBC);
            bean.setsRLBZ_GraCA(sRLBZ_GCA);

            bean.setsRRUZ_bbyc(sRRUZ_cbya);
            bean.setsRRUZ_abyb(sRRUZ_abyb);
            bean.setsRRUZ_bbyc(sRRUZ_bbyc);
            bean.setsRRUZ_A(sRRUZ_A);
            bean.setsRRUZ_B(sRRUZ_B);
            bean.setsRRUZ_C(sRRUZ_C);
            bean.setsRRUZ_GraBA(sRRUZ_GBA);
            bean.setsRRUZ_GraBC(sRRUZ_GBC);
            bean.setsRRUZ_GraCA(sRRUZ_GCA);

            bean.setsRRBZ_bbyc(sRRBZ_cbya);
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BeanComparator bean_comparator = new BeanComparator(Bean_Feature.class, "getType");
        Collections.sort(beans, bean_comparator);

        pointProcesses.clear();
        image_dest_arr.clear();
        image_src_arr.clear();
    }

    public ArrayList<String[]> getContentTests() {
        return contentTests;
    }
}
