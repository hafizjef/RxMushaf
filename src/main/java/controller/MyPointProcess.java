package controller;

import model.Bean_Triangle_Descriptor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class MyPointProcess {
    int w = 0;
    int h = 0;
    BufferedImage image_dest;
    String fname;

    DecimalFormat df = new DecimalFormat("#.#");
    /*
     * To store triangles descriptors
     *
     */
    Bean_Triangle_Descriptor tri_main = new Bean_Triangle_Descriptor();
    Bean_Triangle_Descriptor tri_bottom_left = new Bean_Triangle_Descriptor();
    Bean_Triangle_Descriptor tri_bottom_rigth = new Bean_Triangle_Descriptor();
    private String status;

    public MyPointProcess(BufferedImage image_dest, String fname) {
        //used for calling non-static methods
        this.fname = fname;
        this.image_dest = image_dest;
        w = image_dest.getWidth();
        h = image_dest.getHeight();

    }

    //begin threshold
    public static BufferedImage Threshold(BufferedImage img, int requiredThresholdValue) {

        int height = img.getHeight();
        int width = img.getWidth();
        BufferedImage finalThresholdImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //Februari 2012
        int blue = 0;
        int red = 0;
        int green = 0;


        for (int x = 0; x < width; x++) {
//			System.out.println("Row: " + x);
            try {

                for (int y = 0; y < height; y++) {
                    int color = img.getRGB(x, y);
                    //Februari 2012
                    blue = getBlue(color);
                    red = getRed(color);
                    green = getGreen(color);


//					System.out.println("Threshold : " + requiredThresholdValue);
                    if ((red + green + blue) / 3 < (int) (requiredThresholdValue)) {
                        finalThresholdImage.setRGB(x, y, mixColor(0, 0, 0));
                    } else {
                        finalThresholdImage.setRGB(x, y, mixColor(255, 255, 255));
                    }

                }
            } catch (Exception e) {
                e.getMessage();
            }
        }

        return finalThresholdImage;
    }

    private static int mixColor(int red, int green, int blue) {
        return red << 16 | green << 8 | blue;
    }

    public static int getRed(int color) {
        return (color & 0x00ff0000) >> 16;
    }

    public static int getGreen(int color) {
        return (color & 0x0000ff00) >> 8;
    }

    public static int getBlue(int color) {
        return (color & 0x000000ff) >> 0;

    }//end threshold


    //begin lukis imej

    public static void lukisImej(BufferedImage image_dest) {
        int w = image_dest.getWidth();
        int h = image_dest.getHeight();

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) == -1) {    /*System.out.print("1");*/ } else {
                    //System.err.print("X"+x+" Y : "+y);
                    //return;
//					System.out.print("0");
                }
            }
//			System.out.println("");
        }

    }


    /**
     * point[0] coordinate of the right image 0|1
     * point[1] coordinate of the left image 1|0
     * point[2] represent centroid
     *
     * @param image_dest
     * @return three triangle points for the main triangle
     */
    public ArrayList<Point> getPoints(BufferedImage image_dest) {

        int x = 0;
        int y = 0;
        int x_sum = 0;
        int y_sum = 0;
        int count = 0;

        int x_sumL = 0;
        int y_sumL = 0;
        int countL = 0;

        int x_sumR = 0;
        int y_sumR = 0;
        int countR = 0;

        Point pointA = null; //rigth 	-A
        Point pointB = null; //left		-B
        Point pointC = null; //centroid	-C


        ArrayList<Point> points = new ArrayList<Point>();

        /*
         * centroid of image - point[2]
         *
         */
        for (y = 0; y < h; y++) {
            for (x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //	System.out.print("0");
                }
                //else
                //	System.out.print("1");

            }
            //System.out.println("");
        }
        //System.out.println("count lg : "+count);
        double mycount = new Double(count).doubleValue();
        //JOptionPane.showMessageDialog(null, new Double(count).toString());
        //int y3 =0;
        double d_y3 = 0;
        double d_x3 = 0;
        if (mycount != 0) {
            d_y3 = Double.valueOf(df.format(new Double(y_sum).doubleValue() / mycount));
            d_x3 = Double.valueOf(df.format(new Double(x_sum).doubleValue() / mycount));
        }
        int y3 = (int) Math.round(new Double(d_y3));
        int x3 = (int) Math.round(new Double(d_x3));

        /*
         * x3 and y3 are assigned to point[3] (centroid of image)
         */

        pointC = new Point(x3, y3);
        //System.out.println( "Point C :::::"+pointC);
        tri_main.setPointC(pointC);
        tri_main.setCount_main(count);
        //		System.out.println("ysum : "+y_sum);
        //		System.out.println("xsum : "+x_sum);
        //		System.out.println("count :"+count);
        for (y = 0; y < h; y++) {
            for (x = 0; x <= x3; x++) {
                //correct
                if (image_dest.getRGB(x, y) != -1) {
                    //		System.out.print("A");
                    x_sumL += x;
                    y_sumL += y;
                    countL++;
//					 System.out.print("0");
                }
//				System.out.print("1");
            }

        }
//		System.out.println("");
        int y2 = 0;
        int x2 = 0;
//		System.out.println("countL : "+countL);
//		System.out.println("x_sumL : "+x_sumL);
//		System.out.println("y_sumL :"+y_sumL);
        try {
            double d_y2 = 0;
            double d_x2 = 0;
            double mycountL = new Double(countL).doubleValue();
            if (mycountL != 0) {
                d_y2 = Double.valueOf(df.format(new Double(y_sumL).doubleValue() / mycountL));
                d_x2 = Double.valueOf(df.format(new Double(x_sumL).doubleValue() / mycountL));
            }
            y2 = (int) Math.round(new Double(d_y2));
            x2 = (int) Math.round(new Double(d_x2));


            //	System.out.println(" Kiri X2, Y2 :"+"("+x2+" , "+y2+")");
        } catch (java.lang.ArithmeticException asd) {
            //	System.out.println("Hello");
        }

        pointB = new Point(x2, y2);
        tri_main.setPointB(pointB);
        tri_main.setCount_left(countL);

        countR = 0;
        for (y = 0; y < h; y++) {
            for (x = x3; x < w; x++) {

                if (image_dest.getRGB(x, y) != -1) {
                    x_sumR += x;
                    y_sumR += y;
                    countR++;
//					System.out.print("0");
                }
//				System.out.print("1");
            }
//			System.out.println("");
        }
//		System.out.println("ysumR: "+y_sumR);
//		System.out.println("xsumR: "+x_sumR);
//		System.out.println("countR: "+countR);
        double d_y1 = 0;
        double d_x1 = 0;
        double mycountR = new Double(countR).doubleValue();
        if (mycountR != 0) {
            d_y1 = Double.valueOf(df.format(new Double(y_sumR).doubleValue() / mycountR));
            d_x1 = Double.valueOf(df.format(new Double(x_sumR).doubleValue() / mycountR));
        }
        int y1 = (int) Math.round(new Double(d_y1));
        int x1 = (int) Math.round(new Double(d_x1));


        //System.out.println("Point1 : x : "+x1+" y : "+y1);
        pointA = new Point(x1, y1);
        tri_main.setPointA(pointA);
        tri_main.setCount_left(countR);

        //System.out.println("Centroid C_Main: x : "+x3+" y : "+y3+" : "+pointC);
        //System.out.println("Point A: x : "+x1+" y : "+y1+" : "+pointA);
        points.add(pointA);//on right
        points.add(pointB);//on left
        points.add(pointC);//centroid

        status = "reset";
        return points;
    }


    public ArrayList<Point> getUpperZone(BufferedImage image_dest, Point divider, int x_end, int x_begin) {
        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C

        ArrayList<Point> points = new ArrayList<Point>();

        int w = image_dest.getWidth();
        int y_divider = divider.y;
        if (x_end != 0) {
            w = x_end + 1;
            //JOptionPane.showMessageDialog(null, divider);
//			System.out.println("w : "+w);
        }
        for (int y = 0; y <= y_divider; y++) {
            int x = 0;
            if (x_begin != 0) {
                x = x_begin;
                //JOptionPane.showMessageDialog(null, x);
            }

            for (; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

//					System.out.print("0");
                } else {

//					System.out.print("1");
                }

            }
//			System.out.println("");
        }
//		System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yUpperCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xUpperCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yUpperCentroid = (int) Math.round(new Double(d_yUpperCentroid));
            xUpperCentroid = (int) Math.round(new Double(d_xUpperCentroid));


            point3 = new Point(xUpperCentroid, yUpperCentroid);

            Point begin = new Point(x_begin, 0);
            Point end = new Point(xUpperCentroid, yUpperCentroid);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xUpperCentroid;//�
            begin.y = 0;

            end.x = w;
            end.y = divider.y;

            point1 = getRight(image_dest, point3, begin, end);
            if (point1.y == point2.y && point2.y == point3.y)
                point1.y = point1.y + 1;
            if (point1.x == point2.x && point2.x == point3.x)
                point1.x = point1.x + 1;

        }
        points.add(point1);
        points.add(point2);
        points.add(point3);

//		System.out.println(points);
        status = "reset";
        return points;

    }

    public ArrayList<Point> getUpperUpperZone(BufferedImage image_dest, Point centroid_upperZone) {
        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C


        int w = image_dest.getWidth();
        int y_divider = centroid_upperZone.y;

        for (int y = 0; y <= y_divider; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //	System.out.print("0");
                } else {

                    //	System.out.print("1");
                }

            }
            //	System.out.println("");
        }
        //System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yUpperCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xUpperCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yUpperCentroid = (int) Math.round(new Double(d_yUpperCentroid));
            xUpperCentroid = (int) Math.round(new Double(d_xUpperCentroid));


            point3 = new Point(xUpperCentroid, yUpperCentroid);

            Point begin = new Point(0, 0);
            Point end = new Point(xUpperCentroid, yUpperCentroid);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xUpperCentroid;//�
            begin.y = 0;
            //tgh
            end.x = w;
            end.y = centroid_upperZone.y;

            point1 = getRight(image_dest, point3, begin, end);
            if (point1.y == point2.y && point2.y == point3.y)
                point1.y = point1.y + 1;
            if (point1.x == point2.x && point2.x == point3.x)
                point1.x = point1.x + 1;

        }
        points.add(point1);
        points.add(point2);
        points.add(point3);

        status = "reset";


        return points;
    }

    public ArrayList<Point> getUpperLowerZone(BufferedImage image_dest, Point centroid_upperZone, Point divider) {
        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C


        int w = image_dest.getWidth();
        int y_start = centroid_upperZone.y;


        for (int y = y_start; y <= divider.y; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //	System.out.print("0");
                } else {

                    //	System.out.print("1");
                }

            }
            //	System.out.println("");
        }
        //System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yUpperCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xUpperCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yUpperCentroid = (int) Math.round(new Double(d_yUpperCentroid));
            xUpperCentroid = (int) Math.round(new Double(d_xUpperCentroid));


            point3 = new Point(xUpperCentroid, yUpperCentroid);

            Point begin = new Point(0, yUpperCentroid);
            Point end = new Point(xUpperCentroid, divider.y);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xUpperCentroid;//�
            begin.y = yUpperCentroid;
            //tgh
            end.x = w;
            end.y = divider.y;

            point1 = getRight(image_dest, point3, begin, end);
            if (point1.y == point2.y && point2.y == point3.y)
                point1.y = point1.y + 1;
            if (point1.x == point2.x && point2.x == point3.x)
                point1.x = point1.x + 1;

        }
        points.add(point1);
        points.add(point2);
        points.add(point3);

        status = "reset";


        return points;
    }


    public ArrayList<Point> getLowerUpperZone(BufferedImage image_dest, Point divider, Point centroid_lowerZone) {
        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int xLowerUpperCentroid = 0;
        int yLowerUpperCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C


        int w = image_dest.getWidth();
        int y_start = divider.y;

        for (int y = y_start; y <= centroid_lowerZone.y; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //	System.out.print("0");
                } else {

                    //	System.out.print("1");
                }

            }
            //	System.out.println("");
        }
        //System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yUpperCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xUpperCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yLowerUpperCentroid = (int) Math.round(new Double(d_yUpperCentroid));
            xLowerUpperCentroid = (int) Math.round(new Double(d_xUpperCentroid));


            point3 = new Point(xLowerUpperCentroid, yLowerUpperCentroid);

            Point begin = new Point(0, divider.y);
            Point end = new Point(xLowerUpperCentroid, yLowerUpperCentroid);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xLowerUpperCentroid;//�
            begin.y = divider.y;
            //tgh
            end.x = w;
            end.y = centroid_lowerZone.y;

            point1 = getRight(image_dest, point3, begin, end);
            if (point1.y == point2.y && point2.y == point3.y)
                point1.y = point1.y + 1;
            if (point1.x == point2.x && point2.x == point3.x)
                point1.x = point1.x + 1;

        }
        points.add(point1);
        points.add(point2);
        points.add(point3);

        status = "reset";


        return points;
    }


    public ArrayList<Point> getLowerLowerZone(BufferedImage image_dest, Point centroid_lowerZone) {
        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int xLowerLowerCentroid = 0;
        int yLowerLowerCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C


        int w = image_dest.getWidth();
        int h = image_dest.getHeight();
        int y_start = centroid_lowerZone.y;

        for (int y = y_start; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //	System.out.print("0");
                } else {

                    //	System.out.print("1");
                }

            }
            //	System.out.println("");
        }
        //System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yUpperCentroid = Double.valueOf(df.format((double) y_sum / (double) count));
            double d_xUpperCentroid = Double.valueOf(df.format((double) x_sum / (double) count));
            yLowerLowerCentroid = (int) Math.round(d_yUpperCentroid);
            xLowerLowerCentroid = (int) Math.round(d_xUpperCentroid);


            point3 = new Point(xLowerLowerCentroid, yLowerLowerCentroid);

            Point begin = new Point(0, centroid_lowerZone.y);
            Point end = new Point(xLowerLowerCentroid, yLowerLowerCentroid);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xLowerLowerCentroid;//�
            begin.y = yLowerLowerCentroid;
            //tgh
            end.x = w;
            end.y = h;
            ;

            point1 = getRight(image_dest, point3, begin, end);
            if (point1.y == point2.y && point2.y == point3.y)
                point1.y = point1.y + 1;
            if (point1.x == point2.x && point2.x == point3.x)
                point1.x = point1.x + 1;

        }
        points.add(point1);
        points.add(point2);
        points.add(point3);

        status = "reset";


        return points;
    }

    public ArrayList<Point> getLowerZone(BufferedImage image_dest, Point divider) {
//		System.out.println("Hello");
        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();
        int xLowerCentroid = 0;
        int yLowerCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C

        ArrayList<Point> points = new ArrayList<Point>();

        int y_divider = divider.y;

        for (int y = y_divider; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //System.out.print("0");
                }
                //	System.out.print("1");


            }
            //System.out.println("");
        }
        //System.out.println("\n\n");
//		System.out.println("ysum : "+y_sum);
//		System.out.println("xsum : "+x_sum);
//		System.out.println("count : "+count);
        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yLowerCentroid = Double.valueOf(df.format((double) y_sum / (double) count));
            double d_xLowerCentroid = Double.valueOf(df.format((double) x_sum / (double) count));
            yLowerCentroid = (int) Math.round(d_yLowerCentroid);
            xLowerCentroid = (int) Math.round(d_xLowerCentroid);


            point3 = new Point(xLowerCentroid, yLowerCentroid);

            Point begin = new Point(0, divider.y);
            Point end = new Point(w, h);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xLowerCentroid;//�
            begin.y = divider.y;


            end.x = w;
            end.y = h;


            point1 = getRight(image_dest, point3, begin, end);
            if (point1.y == point2.y && point2.y == point3.y)
                point1.y = point1.y + 1;
            if (point1.x == point2.x && point2.x == point3.x)
                point1.x = point1.x + 1;

        }
        for (Point p : points) {    /*System.out.println("Point pada bahagian bawah : "+p);*/ }
        points.add(point1);
        points.add(point2);
        points.add(point3);

        status = "reset";
        return points;
    }


    public ArrayList<Point> getLowerZoneExtended(BufferedImage image_dest, Point divider, int x_begin, int x_end) {
        //System.out.println("Hello");
        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();
        int xLowerCentroid = 0;
        int yLowerCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C

        ArrayList<Point> points = new ArrayList<Point>();

        int y_divider = divider.y;

        if (x_end != 0) {
            w = x_end + 1;
            //JOptionPane.showMessageDialog(null, w+" mula: "+x_begin +" y mula: "+y_divider+" y akhir: "+h);
            //System.out.println("w : "+w);
        }

//		int x=0;
//		if(x_begin !=0)
//			x=x_begin;
        for (int y = y_divider; y < h; y++) {
            for (int x = x_begin; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //System.out.print("0");
                } else {

                    //	System.out.print("1");
                }

            }
            //System.out.println("");
        }
        //System.out.println("\n\n");
//		System.out.println("ysum : "+y_sum);
//		System.out.println("xsum : "+x_sum);
//		System.out.println("count : "+count);
        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yLowerCentroid = Double.valueOf(df.format((double) y_sum / (double) count));
            double d_xLowerCentroid = Double.valueOf(df.format((double) x_sum / (double) count));
            yLowerCentroid = (int) Math.round(d_yLowerCentroid);
            xLowerCentroid = (int) Math.round(d_xLowerCentroid);


            point3 = new Point(xLowerCentroid, yLowerCentroid);

            Point begin = new Point(x_begin, divider.y);
            Point end = new Point(w, h);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xLowerCentroid;//�
            begin.y = divider.y;


            end.x = w;
            end.y = h;


            point1 = getRight(image_dest, point3, begin, end);
            if (point1.y == point2.y && point2.y == point3.y)
                point1.y = point1.y + 1;
            if (point1.x == point2.x && point2.x == point3.x)
                point1.x = point1.x + 1;

        }
        for (Point p : points) {    /*System.out.println("Point pada bahagian bawah : "+p);*/ }
        points.add(point1);
        points.add(point2);
        points.add(point3);

        status = "reset";
        return points;
    }


    /**
     * 21 Februari 2012 6.38 //belum validate lagi
     *
     * @param image_dest
     * @param divider
     * @return
     */
    public ArrayList<Point> getLeftZone(BufferedImage image_dest, Point divider) {
        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();
        int xLeftCentroid = 0;
        int yLeftCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C

        ArrayList<Point> points = new ArrayList<Point>();

        //	int y_divider = divider.y;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //	System.out.print("0");
                } else {

                    //		System.out.print("1");
                }

            }
            //	System.out.println("");
        }
        //	System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yLeftCentroid = Double.valueOf(df.format((double) y_sum / (double) count));
            double d_xLeftCentroid = Double.valueOf(df.format((double) x_sum / (double) count));
            yLeftCentroid = (int) Math.round(d_yLeftCentroid);
            xLeftCentroid = (int) Math.round(d_xLeftCentroid);


            point3 = new Point(xLeftCentroid, yLeftCentroid);

            Point begin = new Point(0, 0);
            Point end = new Point(divider.x, h);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xLeftCentroid;//�
            begin.y = 0;

            end.x = divider.x;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);

        }
        points.add(point1);
        points.add(point2);
        points.add(point3);
        return points;
    }

    public ArrayList<Point> getLeftLeftZone(BufferedImage image_dest, Point centroidLeftZone) {
        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();
        int xLeftCentroid = 0;
        int yLeftCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C

        ArrayList<Point> points = new ArrayList<Point>();

        //	int y_divider = divider.y;
        int divider = centroidLeftZone.x;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x <= divider; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //	System.out.print("0");
                } else {

                    //		System.out.print("1");
                }

            }
            //	System.out.println("");
        }
        //	System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yLeftCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xLeftCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yLeftCentroid = (int) Math.round(new Double(d_yLeftCentroid));
            xLeftCentroid = (int) Math.round(new Double(d_xLeftCentroid));


            point3 = new Point(xLeftCentroid, yLeftCentroid);

            Point begin = new Point(0, 0);
            Point end = new Point(xLeftCentroid, h);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xLeftCentroid;//�
            begin.y = 0;

            end.x = centroidLeftZone.x;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);

        }
        points.add(point1);
        points.add(point2);
        points.add(point3);
        return points;
    }

    public ArrayList<Point> getLeftRightZone(BufferedImage image_dest, Point centroidLeftZone, Point divider) {
        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();
        int xLeftRightCentroid = 0;
        int yLeftRightCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C

        ArrayList<Point> points = new ArrayList<Point>();

        //	int y_divider = divider.y;
        int x_start = centroidLeftZone.x;
        int y_start = centroidLeftZone.y;

        for (int y = 0; y < h; y++) {
            for (int x = x_start; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //	System.out.print("0");
                } else {

                    //		System.out.print("1");
                }

            }
            //	System.out.println("");
        }
        //	System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yLeftCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xLeftCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yLeftRightCentroid = (int) Math.round(new Double(d_yLeftCentroid));
            xLeftRightCentroid = (int) Math.round(new Double(d_xLeftCentroid));


            point3 = new Point(xLeftRightCentroid, yLeftRightCentroid);

            Point begin = new Point(centroidLeftZone.x, 0);
            Point end = new Point(xLeftRightCentroid, h);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xLeftRightCentroid;//�
            begin.y = 0;

            end.x = divider.x;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);

        }
        points.add(point1);
        points.add(point2);
        points.add(point3);
        return points;
    }


    public void updateStatus(int count) {
        status = "ok";
        if (count == 0)
            status = "reset";

    }

    public String getStatus() {
        return status;
    }

    /**
     * 21 Februari 2012 6.38 //belum validate lagi
     *
     * @param image_dest
     * @param divider
     * @return
     */
    public ArrayList<Point> getRightZone(BufferedImage image_dest, Point divider) {
        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();
        int xRightCentroid = 0;
        int yRightCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C

        ArrayList<Point> points = new ArrayList<Point>();

        //	int y_divider = divider.y;

        for (int y = 0; y < h; y++) {
            for (int x = divider.x; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //				System.out.print("0");
                } else {
                    //
//					System.out.print("1");
                }

            }
            //		System.out.println("");
        }
//		System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {

            double d_yRightCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xRightCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yRightCentroid = (int) Math.round(new Double(d_yRightCentroid));
            xRightCentroid = (int) Math.round(new Double(d_xRightCentroid));

            //xRightCentroid = (int)Math.round(new Double(x_sum)/new Double(count));
            //yRightCentroid = (int)Math.round(new Double(y_sum)/new Double(count));

            point3 = new Point(xRightCentroid, yRightCentroid);

            Point begin = new Point(divider.x, 0);
            Point end = new Point(xRightCentroid, h);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xRightCentroid;//�
            begin.y = 0;

            end.x = w;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);

        }
        points.add(point1);
        points.add(point2);
        points.add(point3);

        status = "reset";
        return points;
    }


    public ArrayList<Point> getRightLeftZone(BufferedImage image_dest, Point divider, Point centroidRightZone) {
        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();
        int xRightLeftCentroid = 0;
        int yRightLeftCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C

        ArrayList<Point> points = new ArrayList<Point>();

        //	int y_divider = divider.y;
        int x_start = centroidRightZone.x;
        for (int y = 0; y < h; y++) {
            for (int x = divider.x; x <= x_start; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //				System.out.print("0");
                } else {
                    //
//					System.out.print("1");
                }

            }
            //		System.out.println("");
        }
//		System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {

            double d_yRightCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xRightCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yRightLeftCentroid = (int) Math.round(new Double(d_yRightCentroid));
            xRightLeftCentroid = (int) Math.round(new Double(d_xRightCentroid));

            //xRightCentroid = (int)Math.round(new Double(x_sum)/new Double(count));
            //yRightCentroid = (int)Math.round(new Double(y_sum)/new Double(count));

            point3 = new Point(xRightLeftCentroid, yRightLeftCentroid);

            Point begin = new Point(divider.x, 0);
            Point end = new Point(xRightLeftCentroid, h);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xRightLeftCentroid;//�
            begin.y = 0;

            end.x = centroidRightZone.x;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);

        }
        points.add(point1);
        points.add(point2);
        points.add(point3);

        status = "reset";
        return points;
    }

    public ArrayList<Point> getRightRightZone(BufferedImage image_dest, Point centroidRightZone) {
        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();
        int xRightRightCentroid = 0;
        int yRightRightCentroid = 0;

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C

        ArrayList<Point> points = new ArrayList<Point>();

        //	int y_divider = divider.y;
        int x_start = centroidRightZone.x;
        for (int y = 0; y < h; y++) {
            for (int x = x_start; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //				System.out.print("0");
                } else {
                    //
//					System.out.print("1");
                }

            }
            //		System.out.println("");
        }
//		System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {

            double d_yRightCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xRightCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yRightRightCentroid = (int) Math.round(new Double(d_yRightCentroid));
            xRightRightCentroid = (int) Math.round(new Double(d_xRightCentroid));

            //xRightCentroid = (int)Math.round(new Double(x_sum)/new Double(count));
            //yRightCentroid = (int)Math.round(new Double(y_sum)/new Double(count));

            point3 = new Point(xRightRightCentroid, yRightRightCentroid);

            Point begin = new Point(centroidRightZone.x, 0);
            Point end = new Point(xRightRightCentroid, h);


            point2 = getLeft(image_dest, point3, begin, end);
            //System.out.println("Point 2 :"+point2);

            begin.x = xRightRightCentroid;//�
            begin.y = 0;

            end.x = w;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);

        }
        points.add(point1);
        points.add(point2);
        points.add(point3);

        status = "reset";
        return points;
    }

    public Point getRight(BufferedImage dest_image, Point centroid, Point begin, Point end) {

        int xc = centroid.x;
        //int yc = centroid.y;

        int x = begin.x;
        int y = begin.y;

        int x_sumR = 0;
        int y_sumR = 0;

        int countR = 0;

        for (y = begin.y; y < end.y; y++) // y_center
        {
            for (x = xc; x < end.x; x++) //x lower centroid
            {

                if (image_dest.getRGB(x, y) != -1) {
                    x_sumR += x;
                    y_sumR += y;
                    countR++;
                    //				System.out.print("0");
                } else {
                    //				System.out.print("1");
                }
            }
            //		System.out.println("");
        }
//		System.out.println("Count ::"+countR);
//		System.out.println("y_sumR :"+y_sumR);
//		System.out.println("x_sumR : "+x_sumR);
        int y1 = 0;
        int x1 = 0;
        if (countR == 0) {
            //JOptionPane.showMessageDialog(null, "Kanan count 0"+fname);
            updateStatus(countR);
            x1 = 0;
            y1 = 0;

        } else {
            double d_y1 = Double.valueOf(df.format(new Double(y_sumR).doubleValue() / new Double(countR).doubleValue()));
            double d_x1 = Double.valueOf(df.format(new Double(x_sumR).doubleValue() / new Double(countR).doubleValue()));
            y1 = (int) Math.round(new Double(d_y1));
            x1 = (int) Math.round(new Double(d_x1));

//			y1 = (int)Math.round(new Double(y_sumR)/new Double(countR));
//			x1 = (int)Math.round(new Double(x_sumR)/new Double(countR));
        }
        Point point1 = new Point(x1, y1);

        return point1;
    }


    /**
     * To get left point that cxontribute to point B for each sub zone
     *
     * @param dest_image
     * @param centroid
     * @param begin
     * @param end
     * @return Point B or point[1] for the subzone.
     */

    public Point getLeft(BufferedImage dest_image, Point centroid, Point begin, Point end) {


        int xc = centroid.x;

        int x = begin.x;
        int y = begin.y;

        int x_sumL = 0;
        int y_sumL = 0;

        int countL = 0;
        for (y = begin.y; y < end.y; y++) {
            for (x = begin.x; x <= xc; x++) {

                if (image_dest.getRGB(x, y) != -1) {
                    x_sumL += x;
                    y_sumL += y;
                    countL++;
                    //				 System.out.print("0");
                } else {
                    //				System.out.print("1");
                }
            }
            //		System.out.println("");

        }
//		System.out.println("xsumL : "+x_sumL);
//		System.out.println("ysumL : "+y_sumL);
//		System.out.println("CountL :"+countL);
        int x_left = 0;
        int y_left = 0;
        if (countL == 0) {
            //JOptionPane.showMessageDialog(null, "Kiri count 0 "+fname );
            x_left = 0;
            y_left = 0;
        } else {
            double d_yLeft = Double.valueOf(df.format(new Double(y_sumL).doubleValue() / new Double(countL).doubleValue()));
            double d_xLeft = Double.valueOf(df.format(new Double(x_sumL).doubleValue() / new Double(countL).doubleValue()));
            y_left = (int) Math.round(new Double(d_yLeft));
            x_left = (int) Math.round(new Double(d_xLeft));

//			x_left = (int)Math.round(new Double(x_sumL)/new Double(countL));
//			y_left = (int)Math.round(new Double(y_sumL)/new Double(countL));
        }
        return new Point(x_left, y_left);

    }

    /*
     * 0|0
     * 1|0
     */
    public ArrayList<Point> getLowerPointsLeft(BufferedImage image_dest, Point divider) {
        //	System.out.println("\n\nKiri Bawah");


        int xLowerCentroid = 0;
        int yLowerCentroid = 0;


        int x_sum = 0;
        int y_sum = 0;

        int count = 0;
        int w = image_dest.getWidth();

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C

        ArrayList<Point> points = new ArrayList<Point>();

        for (int y = divider.y; y < h; y++) {
            for (int x = 0; x <= divider.x; x++) {

                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //				System.out.print("0");
                } else {
                    //
//					System.out.print("1");
                }
            }
            //		System.out.println("");
        }

        //	System.out.println("\n\n");

        //JOptionPane.showMessageDialog(null, "count"+count);
        //count =0;

        if (count == 0 || count <= 5) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            //System.out.println("ysum :"+y_sum);
            //System.out.println("xsum :"+x_sum);
            //System.out.println("count :"+count);
            double d_yLowerCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xLowerCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yLowerCentroid = (int) Math.round(new Double(d_yLowerCentroid));
            xLowerCentroid = (int) Math.round(new Double(d_xLowerCentroid));

//			xLowerCentroid = (int)Math.round(new Double(x_sum)/new Double(count));
//			yLowerCentroid = (int)Math.round(new Double(y_sum)/new Double(count)); //point 3

            /*
             * count is counted from number of black pixel exist in this zone.
             * the centroid point is (sum of x/count, sum of y/count) that will contribute to point[2].
             */
            point3 = new Point(xLowerCentroid, yLowerCentroid);
//			System.out.println("hai");
//			System.out.println("Point 3 cen:"+point3);

            tri_bottom_left.setPointC(point3);

            Point begin = new Point(0, divider.y);
            Point end = new Point(divider.x, h);
            //System.out.println("Point centroid LL"+point3);
            /*
             * Point 2 is get by invoking method getLeft.
             * The method requires image dest, centroid of the zone and point begin and end
             */
//			System.out.println("Bawah kiri");
            point2 = getLeft(image_dest, point3, begin, end);

//			System.out.println("Point Left LL:"+point2);


            if (point2.x == 0 && point2.y == 0) {
                point1.setLocation(0, 0);
                point2.setLocation(0, 0);
                point3.setLocation(0, 0);

            } else {
                begin.x = xLowerCentroid;//�
                begin.y = divider.y;//�


                /*
                 * To get the first coordinate of this zone
                 */
//				System.out.println("Bawah kanan");
                point1 = getRight(image_dest, point3, begin, end);
//				System.out.println("Point kanan LR :"+point1);


                if (point1.x == 0 && point1.y == 0) {
                    //JOptionPane.showMessageDialog(null, "Ade Masuk tak "+fname);
//					point1.x = point3.x;
//					point1.y = point3.y;
                    point1.setLocation(0, 0);
                    point2.setLocation(0, 0);
                    point3.setLocation(0, 0);

                }
            }

        }


        points.add(point1);

        points.add(point2);
        points.add(point3);


        return points;


    }


    /*
     * 0|0
     * 0|1
     */
    public ArrayList<Point> getLowerPointsRight(BufferedImage image_dest, Point divider) {
        //	System.out.println("Kanan Bawah");

        int xLowerCentroid = 0;
        int yLowerCentroid = 0;

        int x_sum = 0;
        int y_sum = 0;

        int count = 0;
        int w = image_dest.getWidth();

        Point point1 = null; //right 	-A
        Point point2 = null; //left		-B
        Point point3 = null; //centroid	-C

        ArrayList<Point> points = new ArrayList<Point>();


        //	System.out.println("Kanan Bawahhhh");
        for (int y = divider.y; y < h; y++) {
            for (int x = divider.x; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //				System.out.print("0");
                } else {
                    //				System.out.print("1");
                }
            }
            //		System.out.println("");
        }


        //	System.out.println("\n\n");


        if (count == 0) {
            //System.out.println("no black pixels");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yLowerCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xLowerCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yLowerCentroid = (int) Math.round(new Double(d_yLowerCentroid));
            xLowerCentroid = (int) Math.round(new Double(d_xLowerCentroid));

//			xLowerCentroid = (int)Math.round(new Double(x_sum)/new Double(count));
//			yLowerCentroid = (int)Math.round(new Double(y_sum)/new Double(count)); //point 3

//			System.out.println("\n\nKanan Bawah Kiri");

//			System.out.println("x_sum :"+x_sum);
//			System.out.println("y_sum :"+y_sum);
//			System.out.println("count :"+count);
            point3 = new Point(xLowerCentroid, yLowerCentroid);
            tri_bottom_rigth.setPointC(point3);

            Point begin = new Point(divider.x, divider.y);
            Point end = new Point(w, h);

            point2 = getLeft(image_dest, point3, begin, end);
            tri_bottom_rigth.setPointB(point2);

            begin.x = xLowerCentroid;//�
            begin.y = divider.y;//�


            point1 = getRight(image_dest, point3, begin, end);
            tri_bottom_rigth.setPointA(point1);

            if (point1.x == 0 && point1.y == 0) {
                point1.setLocation(0, 0);
                point2.setLocation(0, 0);
                point3.setLocation(0, 0);

            }

        }

        points.add(point1);
        points.add(point2);
        points.add(point3);

        return points;
    }


    /*
     * 1|0
     * 0|0
     */
    public ArrayList<Point> getUpperPointsLeft(BufferedImage image_dest, Point divider) {
        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        int x_sum = 0;
        int y_sum = 0;

        int count = 0;

        int w = image_dest.getWidth();

        Point point1 = null;//point on the right
        Point point2 = null;//point on the left
        Point point3 = null; //centroid

        //	System.out.println("Lebar imej : "+w);
        //	System.out.println("Panjang imej : "+image_dest.getHeight());


        //	System.out.println("y divider : "+divider.y);
        //	System.out.println("x divider : "+divider.x);

        ArrayList<Point> points = new ArrayList<Point>();
//		System.out.println("\n\nKiri Atas Kiri");
        for (int y = 0; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //				System.out.print("0");
                } else {
                    //				System.out.print("1");
                }
            }
            //		System.out.println("");
        }

//		System.out.println("xsum KAK:"+x_sum);
//		System.out.println("ysum KAK:"+y_sum);
//		System.out.println("count : "+count);
        if (count == 0) {
            //System.out.println("no black pixels");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yUpperCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xUpperCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yUpperCentroid = (int) Math.round(new Double(d_yUpperCentroid));
            xUpperCentroid = (int) Math.round(new Double(d_xUpperCentroid));

//			System.out.println("Kiri atas kiri : "+xUpperCentroid+" : "+yUpperCentroid);
//			xUpperCentroid = (int)Math.round(new Double(x_sum)/new Double(count));
//			yUpperCentroid = (int)Math.round(new Double(y_sum)/new Double(count)); //point 3

            //		System.out.println("\n\nKiri atas Kiri");
            point3 = new Point(xUpperCentroid, yUpperCentroid);
            Point begin = new Point(0, 0);
            Point end = new Point(divider.x, divider.y);
            point2 = getLeft(image_dest, point3, begin, end);

//			System.out.println("Point 2 kiri atas kiri : "+point2);

            begin.x = xUpperCentroid;//�
            begin.y = 0;//�

            //		System.out.println("\n\nKiri Atas Kanan");
            point1 = getRight(image_dest, point3, begin, end);
            if (point1.x == 0 && point1.y == 0) {
                point1.setLocation(0, 0);
                point2.setLocation(0, 0);
                point3.setLocation(0, 0);

            }
        }

        points.add(point1);
        points.add(point2);
        points.add(point3);

        return points;
    }

    /*
     * 0|1
     * 0|0
     */
    public ArrayList<Point> getUpperPointsRight(BufferedImage image_dest, Point divider) {
        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        int x_sum = 0;
        int y_sum = 0;

        int count = 0;

        int w = image_dest.getWidth();

        Point point1 = null;//point on the right
        Point point2 = null;//point on the left
        Point point3 = null; //centroid


        ArrayList<Point> points = new ArrayList<Point>();

        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {

                    x_sum += x;
                    y_sum += y;
                    count++;

                    //				System.out.print("0");
                } else {
                    //				System.out.print("1");
                }
            }
            //		System.out.println("");
        }


//		System.out.println("\n\n");
//		System.out.println("ysum KAr:"+y_sum);
//		System.out.println("xsum KAr:"+x_sum);
//		System.out.println("count : "+count);

        if (count == 0) {
            //System.out.println("no black pixels");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yUpperCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xUpperCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
            yUpperCentroid = (int) Math.round(new Double(d_yUpperCentroid));
            xUpperCentroid = (int) Math.round(new Double(d_xUpperCentroid));

//			xUpperCentroid = (int)Math.round(new Double(x_sum)/new Double(count));
//			yUpperCentroid = (int)Math.round(new Double(y_sum)/new Double(count)); //point 3
//
            //System.out.println("\n\nKanan Atas Kiri");


            point3 = new Point(xUpperCentroid, yUpperCentroid);
            Point end = new Point(w, divider.y);
            Point begin = new Point(divider.x, 0);
            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xUpperCentroid;//�
            begin.y = 0;//�
            //		System.out.println("\n\nKanan Atas Kanan");
            point1 = getRight(image_dest, point3, begin, end);
            if (point1.x == 0 && point1.y == 0) {
                point1.setLocation(0, 0);
                point2.setLocation(0, 0);
                point3.setLocation(0, 0);

            }


        }

        points.add(point1);
        points.add(point2);
        points.add(point3);


        return points;
    }


    public ArrayList<Point> getLowerPoints(BufferedImage image_dest, int y_center) {


        int w = image_dest.getWidth();

//		System.out.println("lebar x :" +w);
//		System.out.println("tinggi y :"+image_dest.getHeight());
        int h = image_dest.getHeight();

        int xLowerCentroid = 0;
        int yLowerCentroid = 0;

        int xLowerLeft = 0;
        int yLowerLeft = 0;

        int xLowerRight = 0;
        int yLowerRight = 0;

        int x_sum = 0;
        int y_sum = 0;

        int x_sum_left = 0;
        int y_sum_left = 0;

        int x_sum_right = 0;
        int y_sum_right = 0;


        int count = 0;

        Point point1 = null;//point on the right
        Point point2 = null;//point on the left
        Point point3 = null; //centroid

        ArrayList<Point> points = new ArrayList<Point>();
        //	System.out.println("1. Belah Bawah");
        for (int y = y_center; y < h; y++) {
            for (int x = 0; x < w; x++) {
                //System.out.println("test "+image_dest.getRGB(x, y));
                if (image_dest.getRGB(x, y) != -1) {
                    //System.out.print(image_dest.getRGB(x, y));
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //				System.out.print("0");
                } else {
                    //System.err.print("X"+x+" Y : "+y);
                    //return;
                    //System.out.print(image_dest.getRGB(x, y));
                    //				System.out.print("1");
                }
            }
            //		System.out.println("");


        }
//		System.out.println("Sum Bawah x :"+x_sum);
//		System.out.println("Sum Bawah y :"+y_sum);
//		System.out.println("sum count bawah :"+count);
//
        //System.out.println("\n\n");

        double d_yLowerCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
        double d_xLowerCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
        yLowerCentroid = (int) Math.round(new Double(d_yLowerCentroid));
        xLowerCentroid = (int) Math.round(new Double(d_xLowerCentroid));

//		xLowerCentroid = (int)Math.round(new Double(x_sum)/new Double(count));
//		yLowerCentroid = (int)Math.round(new Double(y_sum)/new Double(count)); //point 3

        count = 0;
        //	System.out.println("Bawah Kiri");
        for (int y = y_center; y < h; y++) {
            for (int x = 0; x <= xLowerCentroid; x++) {

                if (image_dest.getRGB(x, y) != -1) {
                    //System.out.print("A");
                    x_sum_left += x;
                    y_sum_left += y;
                    count++;
                    //				 System.out.print("0");
                } else {
                    //				System.out.print("1");

                }

            }
            //		System.out.println("");
        }

        double d_yLowerLeft = Double.valueOf(df.format(new Double(y_sum_left).doubleValue() / new Double(count).doubleValue()));
        double d_xLowerLeft = Double.valueOf(df.format(new Double(x_sum_left).doubleValue() / new Double(count).doubleValue()));
        yLowerLeft = (int) Math.round(new Double(d_yLowerLeft));
        xLowerLeft = (int) Math.round(new Double(d_xLowerLeft));

//		xLowerLeft = (int)Math.round(new Double(x_sum_left)/new Double(count));
//		yLowerLeft = (int)Math.round(new Double(y_sum_left)/new Double(count));

        count = 0;

        //	System.out.println("\n\n\n");

        //	System.out.println("Bawah Kanan");
        for (int y = y_center; y < h; y++) {
            for (int x = xLowerCentroid; x < w; x++) {

                if (image_dest.getRGB(x, y) != -1) {
                    //System.out.print("A");
                    x_sum_right += x;
                    y_sum_right += y;
                    count++;
                    //				 System.out.print("0");
                } else {
                    //				System.out.print("1");

                }

            }
            //		System.out.println("");
        }

        //centroid
        /*
         * 0|0
         * 0|1
         */

        double d_yLowerRight = Double.valueOf(df.format(new Double(y_sum_right).doubleValue() / new Double(count).doubleValue()));
        double d_xLowerRight = Double.valueOf(df.format(new Double(x_sum_right).doubleValue() / new Double(count).doubleValue()));
        yLowerRight = (int) Math.round(new Double(d_yLowerRight));
        xLowerRight = (int) Math.round(new Double(d_xLowerRight));

//		xLowerRight = (int)Math.round(new Double(x_sum_right)/new Double(count));
//		yLowerRight = (int)Math.round(new Double(y_sum_right)/new Double(count));


        //	System.out.println("\n");
        count = 0;
        //	System.out.println("Atas Kanan");
        for (int y = 0; y <= y_center; y++) {
            for (int x = xLowerCentroid; x < w; x++) {
                //System.out.println("x3 : "+x3);
                //System.out.println("y3 : "+x3);
                if (image_dest.getRGB(x, y) != -1) {
                    //	System.out.print("0");
                    x_sum_right += x;
                    y_sum_right += y;
                    count++;

                } else {

                    //			System.out.print("1");
                }
            }
            //	System.out.println("");
        }

        if (count == 0) {
            //System.out.println("no black pixels");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            //	System.out.println("count bhgin right : "+count);
            //musykil
            d_yLowerRight = Double.valueOf(df.format(new Double(y_sum_right).doubleValue() / new Double(count).doubleValue()));
            d_xLowerRight = Double.valueOf(df.format(new Double(x_sum_right).doubleValue() / new Double(count).doubleValue()));
            yLowerRight = (int) Math.round(new Double(d_yLowerRight));
            xLowerRight = (int) Math.round(new Double(d_xLowerRight));


//			xLowerRight= (int)Math.round(new Double(x_sum_right)/new Double(count));
//			yLowerRight =(int)Math.round(new Double(y_sum_right)/new Double(count));
//
            //	System.out.println("x right :"+xLowerRight);
            //	System.out.println("y right :"+yLowerRight);
            count = 0;

            point1 = new Point(xLowerRight, yLowerRight);
            point2 = new Point(xLowerLeft, yLowerLeft);
            point3 = new Point(xLowerCentroid, yLowerCentroid);
        }

        points.add(point1);
        points.add(point2);
        points.add(point3);
//
        return points;
    }


    public ArrayList<Point> getUpperPoints(BufferedImage image_dest, int y_center, int width) {
//		System.out.println();
//		System.out.println("UPPER PART" +y_center +"\n");

        int w = image_dest.getWidth();

        //	System.out.println("lebar x :" +w);
        //	System.out.println("tinggi y :"+image_dest.getHeight());
        //int h = image_dest.getHeight();

        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        int xUpperLeft = 0;
        int yUpperLeft = 0;

        int xUpperRight = 0;
        int yUpperRight = 0;

        int x_sum = 0;
        int y_sum = 0;

        int x_sum_left = 0;
        int y_sum_left = 0;

        int x_sum_right = 0;
        int y_sum_right = 0;


        int count = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        ArrayList<Point> points = new ArrayList<Point>();

        for (int y = 0; y <= y_center; y++) {
            if (width == 0) {

            }

            for (int x = 0; x < w; x++) {
                //System.out.println("test "+image_dest.getRGB(x, y));
                if (image_dest.getRGB(x, y) != -1) {
                    //System.out.print(image_dest.getRGB(x, y));
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //				System.out.print("0");
                } else {
                    //System.err.print("X"+x+" Y : "+y);
                    //return;
                    //System.out.print(image_dest.getRGB(x, y));
                    //				System.out.print("1");
                }
            }
            //		System.out.println("");


        }

        //	System.out.println("\n\n");
        //	System.out.println("KIRI");
        double d_yUpperCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
        double d_xUpperCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));
        yUpperCentroid = (int) Math.round(new Double(d_yUpperCentroid));
        xUpperCentroid = (int) Math.round(new Double(d_xUpperCentroid));

//		xUpperCentroid = (int)Math.round(new Double(x_sum)/new Double(count));
//		yUpperCentroid = (int)Math.round(new Double(y_sum)/new Double(count)); //point 3

        count = 0;
        for (int y = 0; y <= y_center; y++) {
            for (int x = 0; x <= xUpperCentroid; x++) {

                if (image_dest.getRGB(x, y) != -1) {
                    //System.out.print("A");
                    x_sum_left += x;
                    y_sum_left += y;
                    count++;
                    //			 System.out.print("0");
                } else {
                    //				System.out.print("1");
                }
            }
            //	System.out.println("");

        }

        double d_yUpperLeft = Double.valueOf(df.format(new Double(y_sum_left).doubleValue() / new Double(count).doubleValue()));
        double d_xUpperLeft = Double.valueOf(df.format(new Double(x_sum_left).doubleValue() / new Double(count).doubleValue()));
        yUpperLeft = (int) Math.round(new Double(d_yUpperLeft));
        xUpperLeft = (int) Math.round(new Double(d_xUpperLeft));

//		xUpperLeft = (int)Math.round(new Double(x_sum_left)/new Double(count));
//		yUpperLeft = (int)Math.round(new Double(y_sum_left)/new Double(count));

        count = 0;


        for (int y = 0; y <= y_center; y++) {
            for (int x = xUpperCentroid; x < w; x++) {
                //System.out.println("x3 : "+x3);
                //System.out.println("y3 : "+x3);
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum_right += x;
                    y_sum_right += y;
                    count++;
                    //			System.out.print("0");
                } else {
                    //			System.out.print("1");
                }
            }
            //	System.out.println("");
        }

        double d_yUpperRight = Double.valueOf(df.format(new Double(y_sum_right).doubleValue() / new Double(count).doubleValue()));
        double d_xUpperRight = Double.valueOf(df.format(new Double(x_sum_right).doubleValue() / new Double(count).doubleValue()));
        yUpperLeft = (int) Math.round(new Double(d_yUpperRight));
        xUpperLeft = (int) Math.round(new Double(d_xUpperRight));

//		xUpperRight= (int)Math.round(new Double(x_sum_right)/new Double(count));
//		yUpperRight =(int)Math.round(new Double(y_sum_right)/new Double(count));
        count = 0;

        point1 = new Point(xUpperRight, yUpperRight);
        point2 = new Point(xUpperLeft, yUpperLeft);
        point3 = new Point(xUpperCentroid, yUpperCentroid);


        points.add(point1);
        points.add(point2);
        points.add(point3);
//
        return points;
    }


    public BufferedImage doThreshold(BufferedImage img, int requiredThresholdValue) {

        int height = img.getHeight();
        int width = img.getWidth();
        BufferedImage finalThresholdImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int red = 0;
        int green = 0;
        int blue = 0;

        for (int x = 0; x < width; x++) {
//			System.out.println("Row: " + x);
            try {

                for (int y = 0; y < height; y++) {
                    int color = img.getRGB(x, y);

                    red = getRed(color);
                    green = getGreen(color);
                    blue = getBlue(color);

//					System.out.println("Threshold : " + requiredThresholdValue);
                    if ((red + green + blue) / 3 < (int) (requiredThresholdValue)) {
                        finalThresholdImage.setRGB(x, y, mixColor(0, 0, 0));
                    } else {
                        finalThresholdImage.setRGB(x, y, mixColor(255, 255, 255));
                    }

                }
            } catch (Exception e) {
                e.getMessage();
            }
        }

        return finalThresholdImage;
    }

    public static void lukisAtas(BufferedImage image_dest, int y_center) {

        int w = image_dest.getWidth();
        //int h = image_dest.getHeight();

        for (int y = 0; y <= y_center; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) == -1) {    /*System.out.print("1");*/ } else {
//					System.out.print("0");
                }
            }
//			System.out.println("");
        }
//		System.out.println("");

    }

    public static void lukisBawah(BufferedImage image_dest, int y_center) {
        int w = image_dest.getWidth();
        int h = image_dest.getHeight();

        for (int y = y_center + 1; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) == -1) {    /*System.out.print("1");*/ } else {

//					System.out.print("0");
                }
            }
//			System.out.println("");
        }
//		System.out.println("");
    }

    public Bean_Triangle_Descriptor getTri_main() {
        return tri_main;
    }

    public Bean_Triangle_Descriptor getTri_bottom_left() {
        return tri_bottom_left;
    }

}


//public static double moment(BufferedImage image_dest, int p, int q)
//{
//	int w = image_dest.getWidth();
//	int h = image_dest.getHeight();
//
//	double mpq = 0.0; //moment pq
//
//
//	for(int v = 0; v<h; v++)
//		for(int u = 0; u<w; u++)
//		{
//			if(image_dest.getRGB(u, v)!=-1)
//				mpq +=Math.pow(u,p)*Math.pow(v,q);
//
//		}
//
//	return mpq;
//
//}
//
//public static double centralMoment(BufferedImage image_dest, int p, int q)
//{
//	int w = image_dest.getWidth();
//	int h = image_dest.getHeight();
//
//	double m00= moment(image_dest, 0,0);
//	double xCtr= moment(image_dest, 1,0);
//	double yCtr= moment(image_dest, 0,1);
//
//	double c_mpq=0.0;
//
//	for(int v = 0; v<h; v++)
//		for(int u = 0; u<w; u++)
//		{
//			if(image_dest.getRGB(u, v)!=-1)
//				c_mpq +=Math.pow(u-xCtr,p)*Math.pow(v-yCtr,q);
//
//
//
//		}
//
//	return c_mpq;
//}
//
//public static double normalCentralMoment(BufferedImage image_dest, int p, int q)
//{
//
//	double m00 = moment(image_dest, 0,0);
//	double norm = Math.pow(m00, (double)(p+q+2)/2);
//	return centralMoment(image_dest, p, q)/norm;
//}



