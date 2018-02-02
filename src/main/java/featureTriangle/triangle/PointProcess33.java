/*
 * Created by Nur Atikah bt Arbain.
 * Date1: 27/04/2015 10:06 AM.
 * Date2: 24/08/2015 03:04 PM.
 * Date3: 18/09/2015 11:39 AM.
 * Date4: 26/09/2015 03:56 PM.
 * To create the smaller part (binary) for each zone.
 */

package featureTriangle.triangle;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;

public class PointProcess33 {

    int w = 0;
    int h = 0;
    BufferedImage image_dest;
    String fname;

    DecimalFormat df = new DecimalFormat("#.#");

    public PointProcess33(BufferedImage image_dest, String fname) {
        this.fname = fname;
        this.image_dest = image_dest;
        this.w = image_dest.getWidth();
        this.h = image_dest.getHeight();
    }

    public static BufferedImage Threshold(BufferedImage img, int requiredThresholdValue) {

        int height = img.getHeight();
        int width = img.getWidth();

        BufferedImage finalThresholdImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        int blue = 0;
        int red = 0;
        int green = 0;

        for (int x = 0; x < width; x++) {
            try {
                for (int y = 0; y < height; y++) {

                    int color = img.getRGB(x, y);

                    blue = getBlue(color);
                    red = getRed(color);
                    green = getGreen(color);

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

    }

    public ArrayList<Point> getPoints(BufferedImage image_dest) {
        ArrayList<Point> points = new ArrayList<Point>();

        int x = 0;
        int y = 0;

        //Centroid
        int x_sum = 0;
        int y_sum = 0;
        int count = 0;

        //Left
        int x_sumL = 0;
        int y_sumL = 0;
        int countL = 0;

        //Right
        int x_sumR = 0;
        int y_sumR = 0;
        int countR = 0;

        Point pointA = null;   //Right    = A
        Point pointB = null;   //Left     = B
        Point pointC = null;   //Centroid =	C

        //Centroid of image - point[2]
        for (y = 0; y < h; y++) {
            for (x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;
                }
            }
        }

        double mycount = new Double(count).doubleValue();
        double d_y3 = 0;
        double d_x3 = 0;

        if (mycount != 0) {
            d_y3 = Double.valueOf(df.format(new Double(y_sum).doubleValue() / mycount));
            d_x3 = Double.valueOf(df.format(new Double(x_sum).doubleValue() / mycount));
        }

        int y3 = (int) Math.round(new Double(d_y3));
        int x3 = (int) Math.round(new Double(d_x3));

        //x3 and y3 are assigned to point[3] (centroid of image)
        pointC = new Point(x3, y3);

        for (y = 0; y < h; y++) {
            for (x = 0; x <= x3; x++) {
                //correct
                if (image_dest.getRGB(x, y) != -1) {
                    x_sumL += x;
                    y_sumL += y;
                    countL++;
                }
            }
        }

        //Left Part for B
        int y2 = 0;
        int x2 = 0;

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

        } catch (java.lang.ArithmeticException asd) {
        }

        pointB = new Point(x2, y2);

        //Right Part for A
        countR = 0;
        for (y = 0; y < h; y++) {
            for (x = x3; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sumR += x;
                    y_sumR += y;
                    countR++;
                }
            }
        }

        double d_y1 = 0;
        double d_x1 = 0;
        double mycountR = new Double(countR).doubleValue();

        if (mycountR != 0) {
            d_y1 = Double.valueOf(df.format(new Double(y_sumR).doubleValue() / mycountR));
            d_x1 = Double.valueOf(df.format(new Double(x_sumR).doubleValue() / mycountR));
        }

        int y1 = (int) Math.round(new Double(d_y1));
        int x1 = (int) Math.round(new Double(d_x1));

        pointA = new Point(x1, y1);

        points.add(pointA); //add point for Right
        points.add(pointB); //add point for Left
        points.add(pointC); //add point for centroid

        return points;
    }

    /*======================================================================================================================================================================*/

    public int getMainTriangle_Part1(BufferedImage img, Point main_divider) {
//		//          System.out.println("\n\nSmaller Main Triangle Part 1");
        int binary = 0;
        for (int y = 0; y <= main_divider.y; y++) {
            for (int x = main_divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }
        return binary;
    }

    public int getMainTriangle_Part2(BufferedImage img, Point main_divider) {
//		//          System.out.println("\n\nSmaller Main Triangle Part 2");
        int binary = 0;
        for (int y = 0; y <= main_divider.y; y++) {
            for (int x = 0; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }
        return binary;
    }

    public int getMainTriangle_Part3(BufferedImage img, Point main_divider) {
//		//          System.out.println("\n\nSmaller Main Triangle Part 3");
        int binary = 0;
        for (int y = main_divider.y; y < img.getHeight(); y++) {
            for (int x = main_divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }
        return binary;
    }

    public int getMainTriangle_Part4(BufferedImage img, Point main_divider) {
//		//          System.out.println("\n\nSmaller Main Triangle Part 4");
        int binary = 0;
        for (int y = main_divider.y; y < img.getHeight(); y++) {
            for (int x = 0; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }
        return binary;
    }


    //Region Points Upper Right
    public int getPointsUpperRight_Part1(BufferedImage img, Point divider) {
//		//          System.out.println("\n\nSmaller Points Upper Right Part 1");
        int binary = 0;
        //Part 1: Upper Right
        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }
        return binary;
    }

    public int getPointsUpperRight_Part2(BufferedImage img, Point divider, Point main_divider) {
//		//          System.out.println("\n\nSmaller Points Upper Right Part 2");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }
        return binary;
    }

    public int getPointsUpperRight_Part3(BufferedImage img, Point divider, Point main_divider) {
//		//          System.out.println("\n\nSmaller Points Upper Right Part 3");
        int binary = 0;
        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getPointsUpperRight_Part4(BufferedImage img, Point divider, Point main_divider) {
//		//          System.out.println("\n\nSmaller Points Upper Right Part 4");
        int binary = 0;
        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }
        return binary;
    }
    //End Region Points Upper Right


    //Region Points Lower Right
    public int getPointsLowerRight_Part1(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Lower Right Part 1");

        int binary0 = 0;

        for (int y = main_divider.y; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }
//		//          System.out.println("Jumlah binary 0 ialah: "+binary0);
//		//          System.out.println("Nilai X ialah: "+divider.x);
//		//          System.out.println("Nilai Y ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getPointsLowerRight_Part2(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Lower Right Part 2");

        int binary0 = 0;

        for (int y = main_divider.y; y <= divider.y; y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }
//		//          System.out.println("Jumlah binary 0 ialah: "+binary0);
//		//          System.out.println("Nilai X ialah: "+divider.x);
//		//          System.out.println("Nilai Y ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getPointsLowerRight_Part3(BufferedImage img, Point divider) {

//		//          System.out.println("\n\nSmaller Lower Right Part 3");

        int binary0 = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }
//		//          System.out.println("Jumlah binary 0 ialah: "+binary0);
//		//          System.out.println("Nilai X ialah: "+divider.x);
//		//          System.out.println("Nilai Y ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getPointsLowerRight_Part4(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Lower Right Part 4");

        int binary0 = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }
//		//          System.out.println("Jumlah binary 0 ialah: "+binary0);
//		//          System.out.println("Nilai X ialah: "+divider.x);
//		//          System.out.println("Nilai Y ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;
    }
    //End Region Points Lower Right


    //Region Points Upper Left
    public int getPointsUpperLeft_Part1(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Points Upper Left Part 1");

        int binary0 = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

//		//          System.out.println("Jumlah binary 0 ialah: "+binary0);
//		//          System.out.println("Jumlah W ialah: "+divider.x);
//		//          System.out.println("Jumlah H ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getPointsUpperLeft_Part2(BufferedImage img, Point divider) {

//		//          System.out.println("\n\nSmaller Points Upper Left Part 2");

        int binary0 = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

//		//          System.out.println("Jumlah binary 0 ialah: "+binary0);
//		//          System.out.println("Jumlah W ialah: "+divider.x);
//		//          System.out.println("Jumlah H ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getPointsUpperLeft_Part3(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Points Upper Left Part 3");

        int binary0 = 0;

        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

//		//          System.out.println("Jumlah binary 0 ialah: "+binary0);
//		//          System.out.println("Jumlah W ialah: "+divider.x);
//		//          System.out.println("Jumlah H ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getPointsUpperLeft_Part4(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Points Upper Left Part 4");

        int binary0 = 0;

        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

//		//          System.out.println("Jumlah binary 0 ialah: "+binary0);
//		//          System.out.println("Jumlah W ialah: "+divider.x);
//		//          System.out.println("Jumlah H ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;
    }
    //End Region Points Upper Left


    //Region Points Lower Left
    public int getPointsLowerLeft_Part1(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Points Lower Left Part 1");

        int binary0 = 0;

        for (int y = main_divider.y; y <= divider.y; y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
//		//          System.out.println("Jumlah binary ialah: "+binary0);
//		//          System.out.println("W ialah: "+divider.x);
//		//          System.out.println("H ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;

    }

    public int getPointsLowerLeft_Part2(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Points Lower Left Part 2");

        int binary0 = 0;

        for (int y = main_divider.y; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
//		//          System.out.println("Jumlah binary ialah: "+binary0);
//		//          System.out.println("W ialah: "+divider.x);
//		//          System.out.println("H ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;

    }

    public int getPointsLowerLeft_Part3(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Points Lower Left Part 3");

        int binary0 = 0;

        for (int y = divider.y; y < h; y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
//		//          System.out.println("Jumlah binary ialah: "+binary0);
//		//          System.out.println("W ialah: "+divider.x);
//		//          System.out.println("H ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;

    }

    public int getPointsLowerLeft_Part4(BufferedImage img, Point divider) {

//		//          System.out.println("\n\nSmaller Points Lower Left Part 4");

        int binary0 = 0;

        for (int y = divider.y; y < h; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
//		//          System.out.println("Jumlah binary ialah: "+binary0);
//		//          System.out.println("W ialah: "+divider.x);
//		//          System.out.println("H ialah: "+divider.y);
//		//          System.out.println("\n\n");

        return binary0;

    }
    //End Region Points Lower Left


    //Region Upper Zone
    public int getUpperZone_Part1(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Upper Zone Part 1");

        int binary0 = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getUpperZone_Part2(BufferedImage img, Point divider) {

//		//          System.out.println("\n\nSmaller Upper Zone Part 2");

        int binary0 = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: "+binary0);
        ////          System.out.println("Jumlah binary 1 ialah: "+binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getUpperZone_Part3(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Upper Zone Part 3");

        int binary0 = 0;

        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: "+binary0);
        ////          System.out.println("Jumlah binary 1 ialah: "+binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getUpperZone_Part4(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Upper Zone Part 4");

        int binary0 = 0;

        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: "+binary0);
        ////          System.out.println("Jumlah binary 1 ialah: "+binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }
    //End Region Upper Zone


    //Region Upper Upper Zone
    public int getUpperUpperZone_Part1(BufferedImage img, Point divider) {

//		//          System.out.println("\n\nSmaller Upper Upper Zone Part 1");

        int binary0 = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getUpperUpperZone_Part2(BufferedImage img, Point divider) {

//		//          System.out.println("\n\nSmaller Upper Upper Zone Part 2");

        int binary0 = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getUpperUpperZone_Part3(BufferedImage img, Point divider, Point upperZone_divider) {

//		//          System.out.println("\n\nSmaller Upper Upper Zone Part 3");

        int binary0 = 0;

        for (int y = divider.y; y <= upperZone_divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getUpperUpperZone_Part4(BufferedImage img, Point divider, Point upperZone_divider) {

//		//          System.out.println("\n\nSmaller Upper Upper Zone Part 4");

        int binary0 = 0;

        for (int y = divider.y; y <= upperZone_divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }
    //End Region Upper Upper Zone


    //Region Upper Lower Zone
    public int getUpperLowerZone_Part1(BufferedImage img, Point divider, Point upperZone_divider) {

//		//          System.out.println("\n\nSmaller Upper Lower Zone Part 1");

        int binary0 = 0;

        for (int y = upperZone_divider.y; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getUpperLowerZone_Part2(BufferedImage img, Point divider, Point upperZone_divider) {

//		//          System.out.println("\n\nSmaller Upper Lower Zone Part 2");

        int binary0 = 0;

        for (int y = upperZone_divider.y; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getUpperLowerZone_Part3(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Upper Lower Zone Part 3");

        int binary0 = 0;

        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getUpperLowerZone_Part4(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Upper Lower Zone Part 4");

        int binary0 = 0;

        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }
    //End Region Upper Lower Zone


    //Region Lower Zone
    public int getLowerZone_Part1(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Lower Zone Part 1");

        int binary0 = 0;

        for (int y = main_divider.y; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getLowerZone_Part2(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Lower Zone Part 2");

        int binary0 = 0;

        for (int y = main_divider.y; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getLowerZone_Part3(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Lower Zone Part 3");

        int binary0 = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getLowerZone_Part4(BufferedImage img, Point divider) {

//		//          System.out.println("\n\nSmaller Lower Zone Part 4");

        int binary0 = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }
    //End Region Lower Zone


    //Region Lower Upper Zone
    public int getLowerUpperZone_Part1(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Lower Upper Zone Part 1");

        int binary0 = 0;

        for (int y = main_divider.y; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getLowerUpperZone_Part2(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Lower Upper Zone Part 2");

        int binary0 = 0;

        for (int y = main_divider.y; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getLowerUpperZone_Part3(BufferedImage img, Point divider, Point lowerZone_divider) {

//		//          System.out.println("\n\nSmaller Lower Upper Zone Part 3");

        int binary0 = 0;

        for (int y = divider.y; y <= lowerZone_divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getLowerUpperZone_Part4(BufferedImage img, Point divider, Point lowerZone_divider) {

//		//          System.out.println("\n\nSmaller Lower Upper Zone Part 4");

        int binary0 = 0;

        for (int y = divider.y; y <= lowerZone_divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }
    //End Region Lower Upper Zone


    //Region Lower Lower Zone
    public int getLowerLowerZone_Part1(BufferedImage img, Point divider, Point lowerZone_divider) {

//		//          System.out.println("\n\nSmaller Lower Lower Zone Part 1");

        int binary0 = 0;

        for (int y = lowerZone_divider.y; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getLowerLowerZone_Part2(BufferedImage img, Point divider, Point lowerZone_divider) {

//		//          System.out.println("\n\nSmaller Lower Lower Zone Part 2");

        int binary0 = 0;

        for (int y = lowerZone_divider.y; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getLowerLowerZone_Part3(BufferedImage img, Point divider) {

//		//          System.out.println("\n\nSmaller Lower Lower Zone Part 3");

        int binary0 = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getLowerLowerZone_Part4(BufferedImage img, Point divider) {

//		//          System.out.println("\n\nSmaller Lower Lower Zone Part 4");

        int binary0 = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }
    //End Region Lower Lower Zone


    //Region Right
    public int getRightZone_Part1(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Right Zone Part 1");

        int binary0 = 0;

        for (int y = 0; y <= main_divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getRightZone_Part2(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Right Zone Part 2");

        int binary0 = 0;

        for (int y = 0; y <= main_divider.y; y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getRightZone_Part3(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Right Zone Part 3");

        int binary0 = 0;

        for (int y = main_divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }

    public int getRightZone_Part4(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Right Zone Part 4");

        int binary0 = 0;

        for (int y = main_divider.y; y < img.getHeight(); y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary0++;
//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }
//			//          System.out.println("");
        }

        ////          System.out.println("Jumlah binary 0 ialah: " + binary0);
        ////          System.out.println("Jumlah binary 1 ialah: " + binary1);
//		//          System.out.println("\n\n");

        return binary0;
    }
    //End Region Right


    //Region of Right Right Zone
    public int getRightRightZone_Part1(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Right Right Zone Part 1");
        int binary0 = 0;

        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary0;
    }

    public int getRightRightZone_Part2(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Right Right Zone Part 2");
        int binary0 = 0;

        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;

///					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary0;
    }

    public int getRightRightZone_Part3(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Right Right Zone Part 3");
        int binary0 = 0;

        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary0;
    }

    public int getRightRightZone_Part4(BufferedImage img, Point divider, Point main_divider) {

//		//          System.out.println("\n\nSmaller Right Right Zone Part 4");
        int binary0 = 0;

        for (int y = divider.y; y <= main_divider.y; y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary0++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary0;
    }
    //End Region of Right Right Zone


    //Region of Right Right Upper Zone
    public int getRightRightUpperZone_Part1(BufferedImage img, Point divider) {
//		//          System.out.println("\n\nSmaller Right Right Upper Zone Part 1");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getRightRightUpperZone_Part2(BufferedImage img, Point divider, Point divider_rightzone) {
//		//          System.out.println("\n\nSmaller Right Right Upper Zone Part 2");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider_rightzone.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getRightRightUpperZone_Part3(BufferedImage img, Point divider, Point divider_rightrightzone) {
//		//          System.out.println("\n\nSmaller Right Right Upper Zone Part 3");
        int binary = 0;
        for (int y = divider.y; y <= divider_rightrightzone.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getRightRightUpperZone_Part4(BufferedImage img, Point divider, Point divider_rightzone, Point divider_rightrightzone) {
//		//          System.out.println("\n\nSmaller Right Right Upper Zone Part 4");
        int binary = 0;
        for (int y = divider.y; y <= divider_rightrightzone.y; y++) {
            for (int x = divider_rightzone.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }
    //End Region of Right Right Upper Zone


    //Region of Right Right Lower Zone
    public int getRightRightLowerZone_Part1(BufferedImage img, Point divider, Point divider_rightzone) {
//		//          System.out.println("\n\nSmaller Right Right Lower Zone Part 1");
        int binary = 0;
        for (int y = divider_rightzone.y; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getRightRightLowerZone_Part2(BufferedImage img, Point divider, Point main_divider, Point divider_rightzone) {
//		//          System.out.println("\n\nSmaller Right Right Lower Zone Part 2");
        int binary = 0;
        for (int y = main_divider.y; y <= divider_rightzone.y; y++) {
            for (int x = divider_rightzone.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getRightRightLowerZone_Part3(BufferedImage img, Point divider) {
//		//          System.out.println("\n\nSmaller Right Right Lower Zone Part 3");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getRightRightLowerZone_Part4(BufferedImage img, Point divider, Point divider_rightzone) {
//		//          System.out.println("\n\nSmaller Right Right Lower Zone Part 4");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider_rightzone.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }
    //End Region of Right Right Lower Zone


    //Region of Right Left Zone
    public int getRightLeftZone_Part1(BufferedImage img, Point divider, Point divider_rightzone) {
//		//          System.out.println("\n\nSmaller Right Left Zone Part 1");
        int binary = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x <= divider_rightzone.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary;
    }

    public int getRightLeftZone_Part2(BufferedImage img, Point divider, Point main_divider) {
//		//          System.out.println("\n\nSmaller Right Left Zone Part 2");
        int binary = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary;
    }

    public int getRightLeftZone_Part3(BufferedImage img, Point divider, Point divider_rightzone) {
//		//          System.out.println("\n\nSmaller Right Left Zone Part 3");
        int binary = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x <= divider_rightzone.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary;
    }

    public int getRightLeftZone_Part4(BufferedImage img, Point divider, Point main_divider) {
//		//          System.out.println("\n\nSmaller Right Left Zone Part 4");
        int binary = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary;
    }
    //End Region of Right Left Zone


    //Region of Right Left Upper Zone
    public int getRightLeftUpperZone_Part1(BufferedImage img, Point divider, Point divider_rightzone) {
//		//          System.out.println("\n\nSmaller Right Left Upper Zone Part 1");
        int binary = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x <= divider_rightzone.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary;
    }

    public int getRightLeftUpperZone_Part2(BufferedImage img, Point divider, Point main_divider) {
//		//          System.out.println("\n\nSmaller Right Left Upper Zone Part 2");
        int binary = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary;
    }

    public int getRightLeftUpperZone_Part3(BufferedImage img, Point divider, Point divider_rightzone, Point divider_rightleftzone) {
//		//          System.out.println("\n\nSmaller Right Left Upper Zone Part 3");
        int binary = 0;

        for (int y = divider.y; y <= divider_rightleftzone.y; y++) {
            for (int x = divider.x; x <= divider_rightzone.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary;
    }

    public int getRightLeftUpperZone_Part4(BufferedImage img, Point divider, Point divider_rightzone, Point divider_rightleftzone) {
//		//          System.out.println("\n\nSmaller Right Left Upper Zone Part 4");
        int binary = 0;

        for (int y = divider.y; y <= divider_rightleftzone.y; y++) {
            for (int x = divider.x; x <= divider_rightzone.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }

        return binary;
    }
    //End Region of Right Left Upper Zone


    //Region of Right Left Lower Zone
    public int getRightLeftLowerZone_Part1(BufferedImage img, Point divider, Point divider_rightzone) {
//		//          System.out.println("\n\nSmaller Right Left Lower Zone Part 1");
        int binary = 0;
        for (int y = divider_rightzone.y; y <= divider.y; y++) {
            for (int x = divider.x; x <= divider_rightzone.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getRightLeftLowerZone_Part2(BufferedImage img, Point divider, Point main_divider, Point divider_rightleftzone) {
//		//          System.out.println("\n\nSmaller Right Left Lower Zone Part 2");
        int binary = 0;
        for (int y = divider_rightleftzone.y; y <= divider.y; y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getRightLeftLowerZone_Part3(BufferedImage img, Point divider, Point divider_rightzone) {
//		//          System.out.println("\n\nSmaller Right Left Lower Zone Part 3");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x <= divider_rightzone.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getRightLeftLowerZone_Part4(BufferedImage img, Point divider, Point main_divider) {
//		//          System.out.println("\n\nSmaller Right Left Lower Zone Part 4");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = main_divider.x; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }
    //End Region of Right Left Lower Zone

//*******************************************************************************************************************\\

    //Region of Left Zone (6,11)
    public int getLeftZone_Part1(BufferedImage img, Point divider, Point main_divider) {
//		//          System.out.println("\n\nSmaller Left Zone Part 1");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getLeftZone_Part2(BufferedImage img, Point divider) {
//		//          System.out.println("\n\nSmaller Left Zone Part 2");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getLeftZone_Part3(BufferedImage img, Point divider, Point main_divider) {
//		//          System.out.println("\n\nSmaller Left Zone Part 3");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getLeftZone_Part4(BufferedImage img, Point divider) {
//		//          System.out.println("\n\nSmaller Left Zone Part 4");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }
    //End Region of Left Zone


    //Region of Left Left Zone (3,12)
    public int getLeftLeftZone_Part1(BufferedImage img, Point divider, Point divider_leftzone) {
//		//          System.out.println("\n\nSmaller Left Left Zone Part 1");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x <= divider_leftzone.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getLeftLeftZone_Part2(BufferedImage img, Point divider) {
//		//          System.out.println("\n\nSmaller Left Left Zone Part 2");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getLeftLeftZone_Part3(BufferedImage img, Point divider, Point divider_leftzone) {
//		//          System.out.println("\n\nSmaller Left Left Zone Part 3");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x <= divider_leftzone.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getLeftLeftZone_Part4(BufferedImage img, Point divider) {
//		//          System.out.println("\n\nSmaller Left Left Zone Part 4");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }
    //End Region of Left Left Zone


    //Region of Left Right Zone (8,10)
    public int getLeftRightZone_Part1(BufferedImage img, Point divider, Point main_divider) {
//		//          System.out.println("\n\nSmaller Left Right Zone Part 1");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getLeftRightZone_Part2(BufferedImage img, Point divider, Point divider_leftzone) {
//		//          System.out.println("\n\nSmaller Left Right Zone Part 2");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider_leftzone.x; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getLeftRightZone_Part3(BufferedImage img, Point divider, Point main_divider) {
//		//          System.out.println("\n\nSmaller Left Right Zone Part 3");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }

    public int getLeftRightZone_Part4(BufferedImage img, Point divider, Point divider_leftzone) {
//		//          System.out.println("\n\nSmaller Left Right Zone Part 4");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider_leftzone.x; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

//					//          System.out.print("0");
                } else {
//					//          System.out.print("1");
                }
            }

//			//          System.out.println("");
        }
        return binary;
    }
    //End Region of Left Right Zone


    //Region of Left Right Upper Zone (8,4)
    public int getLeftRightUpperZone_Part1(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Left Right Upper Zone Part 1");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftRightUpperZone_Part2(BufferedImage img, Point divider, Point divider_leftzone) {
        //          System.out.println("\n\nSmaller Left Right Upper Zone Part 2");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider_leftzone.x; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftRightUpperZone_Part3(BufferedImage img, Point divider, Point main_divider, Point divider_leftleftzone) {
        //          System.out.println("\n\nSmaller Left Right Upper Zone Part 3");
        int binary = 0;
        for (int y = divider.y; y <= divider_leftleftzone.y; y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftRightUpperZone_Part4(BufferedImage img, Point divider, Point divider_leftzone, Point divider_leftleftzone) {
        //          System.out.println("\n\nSmaller Left Right Upper Zone Part 4");
        int binary = 0;
        for (int y = divider.y; y <= divider_leftleftzone.y; y++) {
            for (int x = divider_leftzone.x; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }
    //End Region of Left Right Upper Zone


    //Region of Left Right Lower Zone (8,17)
    public int getLeftRightLowerZone_Part1(BufferedImage img, Point divider, Point main_divider, Point divider_leftleftzone) {
        //          System.out.println("\n\nSmaller Left Right Lower Zone Part 1");
        int binary = 0;
        for (int y = divider_leftleftzone.y; y <= divider.y; y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftRightLowerZone_Part2(BufferedImage img, Point divider, Point divider_leftzone, Point divider_leftleftzone) {
        //          System.out.println("\n\nSmaller Left Right Lower Zone Part 2");
        int binary = 0;
        for (int y = divider_leftleftzone.y; y <= divider.y; y++) {
            for (int x = divider_leftzone.x; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftRightLowerZone_Part3(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Left Right Lower Zone Part 3");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x <= main_divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftRightLowerZone_Part4(BufferedImage img, Point divider, Point divider_leftzone) {
        //          System.out.println("\n\nSmaller Left Right Lower Zone Part 4");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider_leftzone.x; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }
    //End Region of Left Right Lower Zone


    //Region of Left Left Upper Zone (4,9)
    public int getLeftLeftUpperZone_Part1(BufferedImage img, Point divider, Point divider_leftzone) {
        //          System.out.println("\n\nSmaller Left Left Upper Zone Part 1");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x <= divider_leftzone.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftLeftUpperZone_Part2(BufferedImage img, Point divider) {
        //          System.out.println("\n\nSmaller Left Left Upper Zone Part 2");
        int binary = 0;
        for (int y = 0; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftLeftUpperZone_Part3(BufferedImage img, Point divider, Point divider_leftzone, Point divider_leftleftzone) {
        //          System.out.println("\n\nSmaller Left Left Upper Zone Part 3");
        int binary = 0;
        for (int y = divider.y; y <= divider_leftleftzone.y; y++) {
            for (int x = divider.x; x <= divider_leftzone.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftLeftUpperZone_Part4(BufferedImage img, Point divider, Point divider_leftleftzone) {
        //          System.out.println("\n\nSmaller Left Left Upper Zone Part 4");
        int binary = 0;
        for (int y = divider.y; y <= divider_leftleftzone.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }
    //End Region of Left Left Upper Zone


    //Region of Left Left Lower Zone (2,15)
    public int getLeftLeftLowerZone_Part1(BufferedImage img, Point divider, Point divider_leftzone, Point divider_leftleftzone) {
        //          System.out.println("\n\nSmaller Left Left Lower Zone Part 1");
        int binary = 0;
        for (int y = divider_leftleftzone.y; y <= divider.y; y++) {
            for (int x = divider.x; x <= divider_leftzone.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftLeftLowerZone_Part2(BufferedImage img, Point divider, Point divider_leftleftzone) {
        //          System.out.println("\n\nSmaller Left Left Lower Zone Part 2");
        int binary = 0;
        for (int y = divider_leftleftzone.x; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftLeftLowerZone_Part3(BufferedImage img, Point divider, Point divider_leftzone) {
        //          System.out.println("\n\nSmaller Left Left Lower Zone Part 3");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x <= divider_leftzone.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }

    public int getLeftLeftLowerZone_Part4(BufferedImage img, Point divider) {
        //          System.out.println("\n\nSmaller Left Left Lower Zone Part 4");
        int binary = 0;
        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    binary++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        return binary;
    }
    //End Region of Left Left Lower Zone


    //============================================================================================================

    //Region of Top Right Right Zone
    public int getTopRightRightZone_Part1(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Right Right Zone Part 1");

        int binary = 0;

        Point main_dividers = new Point(main_divider);

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, list.get(y).y) != -1) {
                    if (x < list.get(y).x) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(y).y) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("1");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getTopRightRightZone_Part2(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Right Right Zone Part 2");

        int binary = 0;

        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        for (int y = 0; y <= divider.y; y++) {
            for (int x = xInitial; x <= divider.x; x++) {
                if (img.getRGB(x, list.get(y).y) != -1) {
                    if (x < list.get(y).x) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(y).y) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("1");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getTopRightRightZone_Part3(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Right Right Zone Part 3");

        int binary = 0;

        Point main_dividers = new Point(main_divider);

        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        for (int y = divider.y; y <= yInitial; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, list.get(y).y) != -1) {
                    if (x < list.get(y).x) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(y).y) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("1");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getTopRightRightZone_Part4(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Right Right Zone Part 4");

        int binary = 0;

        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        for (int y = divider.y; y <= yInitial; y++) {
            for (int x = xInitial; x <= divider.x; x++) {
                if (img.getRGB(x, list.get(y).y) != -1) {
                    if (x < list.get(y).x) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(y).y) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("1");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }
    //End Region of Top Right Right Zone


    //Region of Bottom Right Right Zone
    public int getBottomRightRightZone_Part1(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Right Right Zone Part 1");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = yInitial; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomRightRightZone_Part2(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Right Right Zone Part 2");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = yInitial; y <= divider.y; y++) {
            for (int x = xInitial; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomRightRightZone_Part3(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Right Right Zone Part 3");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomRightRightZone_Part4(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Right Right Zone Part 4");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = xInitial; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }
    //End Region of Bottom Right Right Zone


    //Region of Top Right Left Zone
    public int getTopRightLeftZone_Part1(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Right Left Zone Part 1");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, list.get(y).y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x <= list.get(y).x || x == xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");
                    }
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getTopRightLeftZone_Part2(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Right Left Zone Part 2");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        for (int y = 0; y <= divider.y; y++) {
            for (int x = xInitial; x < divider.x; x++) {
                if (img.getRGB(x, list.get(y).y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x <= list.get(y).x || x == xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");
                    }
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getTopRightLeftZone_Part3(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Right Left Zone Part 3");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        for (int y = divider.y; y <= yInitial; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, list.get(y).y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x <= list.get(y).x || x == xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");
                    }
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getTopRightLeftZone_Part4(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Right Left Zone Part 4");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        for (int y = divider.y; y <= yInitial; y++) {
            for (int x = xInitial; x <= divider.x; x++) {
                if (img.getRGB(x, list.get(y).y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x <= list.get(y).x || x == xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");
                    }
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }
    //End Region of Top Right Left Zone


    //Region of Bottom Right Left Zone
    public int getBottomRightLeftZone_Part1(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Right Left Zone Part 1");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = yInitial; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x <= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomRightLeftZone_Part2(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Right Left Zone Part 2");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = yInitial; y <= divider.y; y++) {
            for (int x = xInitial; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x <= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomRightLeftZone_Part3(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Right Left Zone Part 3");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x <= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomRightLeftZone_Part4(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Right Left Zone Part 4");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x++;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = yInitial; y <= divider.y; y++) {
            for (int x = divider.x; x < img.getWidth(); x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    if (x < xInitial) {
                        //          System.out.print("Q");
                    } else if (x <= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }
    //End Region of Bottom Right Left Zone


    //Region of Top Left Right Zone
    public int getTopLeftRightZone_Part1(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Left Right Zone Part 1");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;
        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int indexList = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x <= xInitial; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    if (x >= list.get(indexList).x && x <= xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");
                    }
                } else {
                    //          System.out.print("1");
                }
            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;

            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getTopLeftRightZone_Part2(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Left Right Zone Part 2");
        int binary = 0;
        Point main_dividers = new Point(main_divider);
        int xInitial = main_dividers.x;
        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int indexList = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x >= list.get(indexList).x && x <= xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");
                    }
                } else {
                    //          System.out.print("1");
                }
            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;

            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");
        return binary;
    }

    public int getTopLeftRightZone_Part3(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Left Right Zone Part 3");
        int binary = 0;
        Point main_dividers = new Point(main_divider);
        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;
        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int indexList = 0;

        for (int y = divider.y; y <= yInitial; y++) {
            for (int x = divider.x; x <= xInitial; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x >= list.get(indexList).x && x <= xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");
                    }
                } else {
                    //          System.out.print("1");
                }
            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;

            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getTopLeftRightZone_Part4(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Left Right Zone Part 4");
        int binary = 0;
        Point main_dividers = new Point(main_divider);
        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int indexList = 0;

        for (int y = divider.y; y <= yInitial; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x >= list.get(indexList).x && x <= xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");
                    }
                } else {
                    //          System.out.print("1");
                }
            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;

            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }
    //End Region of Top Left Right Zone


    //Region of Bottom Left Right Zone
    public int getBottomLeftRightZone_Part1(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Left Right Zone Part 1");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = yInitial; y <= divider.y; y++) {
            for (int x = divider.x; x <= xInitial; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < list.get(jCount).x) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(jCount).x && x <= xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomLeftRightZone_Part2(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Left Right Zone Part 2");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = yInitial; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < list.get(jCount).x) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(jCount).x && x <= xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomLeftRightZone_Part3(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Left Right Zone Part 3");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x <= xInitial; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < list.get(jCount).x) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(jCount).x && x <= xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomLeftRightZone_Part4(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Left Right Zone Part 4");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < list.get(jCount).x) {
                        //          System.out.print("Q");
                    } else if (x >= list.get(jCount).x && x <= xInitial) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }
    //End Region of Bottom Left Right Zone


    //Region of Top Left Left Zone
    public int getTopLeftLeftZone_Part1(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Left Left Zone Part 1");
        int binary = 0;
        Point main_dividers = new Point(main_divider);
        int xInitial = main_dividers.x;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int indexList = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x <= xInitial; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < list.get(indexList).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");

                    }
                } else {
                    //          System.out.print("1");
                }
            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;

            //          System.out.println();

        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getTopLeftLeftZone_Part2(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Left Left Zone Part 2");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int indexList = 0;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < list.get(indexList).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");

                    }
                } else {
                    //          System.out.print("1");
                }
            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;

            //          System.out.println();

        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getTopLeftLeftZone_Part3(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Left Left Zone Part 3");
        int binary = 0;
        Point main_dividers = new Point(main_divider);
        int xInitial = main_dividers.x;
        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int indexList = 0;

        for (int y = divider.y; y <= yInitial; y++) {
            for (int x = divider.x; x <= xInitial; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < list.get(indexList).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");

                    }
                } else {
                    //          System.out.print("1");
                }
            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;

            //          System.out.println();

        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getTopLeftLeftZone_Part4(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Top Left Left Zone Part 4");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != -1) {
            list.addFirst(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y--;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int indexList = 0;

        for (int y = divider.y; y <= yInitial; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x < list.get(indexList).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    } else {
                        //          System.out.print("Q");

                    }
                } else {
                    //          System.out.print("1");
                }
            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;

            //          System.out.println();

        } //end for outter

        //          System.out.println("\n");

        return binary;
    }
    //End Region of Top Left Left Zone


    //Region of Bottom Left Left Zone
    public int getBottomLeftLeftZone_Part1(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Left Left Zone Part 1");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int yInitial = main_dividers.y;
        int xInitial = main_dividers.x;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = yInitial; y <= divider.y; y++) {
            for (int x = divider.x; x <= xInitial; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    if (x <= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomLeftLeftZone_Part2(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Left Left Zone Part 2");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int yInitial = main_dividers.y;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = yInitial; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x <= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomLeftLeftZone_Part3(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Left Left Zone Part 3");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        int xInitial = main_dividers.x;

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = divider.x; x <= xInitial; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x <= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }

    public int getBottomLeftLeftZone_Part4(BufferedImage img, Point divider, Point main_divider) {
        //          System.out.println("\n\nSmaller Bottom Left Left Zone Part 4");
        int binary = 0;
        Point main_dividers = new Point(main_divider);

        LinkedList<Point> list = new LinkedList<Point>();

        while (main_dividers.x != -1 && main_dividers.y != img.getHeight()) {
            list.addLast(new Point(main_dividers.x, main_dividers.y));
            main_dividers.x--;
            main_dividers.y++;
        }

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int y = divider.y; y < img.getHeight(); y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (img.getRGB(x, y) != -1) {
                    if (x <= list.get(jCount).x) {
                        allBlackPoint = new Point(x, y);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        binary++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        return binary;
    }
    //End Region of Bottom Left Left Zone


//*******************************************************************************************************************\\


    /**
     * Start from here.
     * Contain all bigger 33zones.
     */

    public ArrayList<Point> getPointsUpperRight(BufferedImage image_dest, Point divider) {
        //          System.out.println("\n\nBigger Part 1");

        ArrayList<Point> points = new ArrayList<Point>();

        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        int x_sum = 0;
        int y_sum = 0;

        int count = 0;

        int binary0 = 0;
        int binary1 = 0;

        int w = image_dest.getWidth();

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = divider.x; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;
                    binary0++;
                    //          System.out.print("0");
                } else {
                    binary1++;
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        //          System.out.println("\n\n");
        //          System.out.println("Nilai W ialah: "+divider.x);
        //          System.out.println("Nilai H ialah: "+divider.y);
        //          System.out.println("Binary 0 ialah: "+binary0);
        //          System.out.println("Binary 1 ialah: "+binary1);

        if (count == 0) {
            ////          System.out.println("no black pixels");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yUpperCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xUpperCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));

            yUpperCentroid = (int) Math.round(new Double(d_yUpperCentroid));
            xUpperCentroid = (int) Math.round(new Double(d_xUpperCentroid));

            point3 = new Point(xUpperCentroid, yUpperCentroid);

            Point end = new Point(w, divider.y);
            Point begin = new Point(divider.x, 0);

            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xUpperCentroid;
            begin.y = 0;

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

    public ArrayList<Point> getPointsLowerRight(BufferedImage image_dest, Point divider) {
        //          System.out.println("\n\nBigger Lower Right");

        int xLowerCentroid = 0;
        int yLowerCentroid = 0;

        int x_sum = 0;
        int y_sum = 0;

        int count = 0;
        int w = image_dest.getWidth();

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        ArrayList<Point> points = new ArrayList<Point>();

        for (int y = divider.y; y < h; y++) {
            for (int x = divider.x; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }
            //          System.out.println("");
        }

        //          System.out.println("\n\n");

        if (count == 0) {
            ////          System.out.println("no black pixels");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yLowerCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xLowerCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));

            yLowerCentroid = (int) Math.round(new Double(d_yLowerCentroid));
            xLowerCentroid = (int) Math.round(new Double(d_xLowerCentroid));

            point3 = new Point(xLowerCentroid, yLowerCentroid);

            Point begin = new Point(divider.x, divider.y);
            Point end = new Point(w, h);

            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xLowerCentroid;
            begin.y = divider.y;

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

    public ArrayList<Point> getPointsUpperLeft(BufferedImage image_dest, Point divider) {
        //          System.out.println("Bigger Points Upper Left");
        ArrayList<Point> points = new ArrayList<Point>();

        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        int x_sum = 0;
        int y_sum = 0;

        int count = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        for (int y = 0; y <= divider.y; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        if (count == 0) {
            ////          System.out.println("no black pixels");
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
            Point end = new Point(divider.x, divider.y);

            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xUpperCentroid;
            begin.y = 0;

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

    public ArrayList<Point> getPointsLowerLeft(BufferedImage image_dest, Point divider) {
        //          System.out.println("\n\nBigger Points Lower Left");

        ArrayList<Point> points = new ArrayList<Point>();

        int xLowerCentroid = 0;
        int yLowerCentroid = 0;

        int x_sum = 0;
        int y_sum = 0;

        int count = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        for (int y = divider.y; y < h; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        //          System.out.println("\n\n");

        if (count == 0 || count <= 5) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yLowerCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xLowerCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));

            yLowerCentroid = (int) Math.round(new Double(d_yLowerCentroid));
            xLowerCentroid = (int) Math.round(new Double(d_xLowerCentroid));

            /*
             * count is counted from number of black pixel exist in this zone.
             * the centroid point is (sum of x/count, sum of y/count) that will contribute to point[2].
             */
            point3 = new Point(xLowerCentroid, yLowerCentroid);

            Point begin = new Point(0, divider.y);
            Point end = new Point(divider.x, h);

            /*
             * Point 2 is get by invoking method getLeft.
             * The method requires image dest, centroid of the zone and point begin and end
             */

            point2 = getLeft(image_dest, point3, begin, end);

            if (point2.x == 0 && point2.y == 0) {
                point1.setLocation(0, 0);
                point2.setLocation(0, 0);
                point3.setLocation(0, 0);

            } else {
                begin.x = xLowerCentroid;
                begin.y = divider.y;


                /*
                 * To get the first coordinate of this zone
                 */
                point1 = getRight(image_dest, point3, begin, end);

                if (point1.x == 0 && point1.y == 0) {
                    //JOptionPane.showMessageDialog(null, "Ade Masuk tak "+fname);
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

    public ArrayList<Point> getUpperZone(BufferedImage image_dest, Point divider, int x_end, int x_begin) {
        //          System.out.println("\n\nBigger Upper Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        int w = image_dest.getWidth();
        int y_divider = divider.y;

        if (x_end != 0) {
            w = x_end + 1;
        }

        for (int y = 0; y <= y_divider; y++) {
            int x = 0;

            if (x_begin != 0) {
                x = x_begin;
            }

            for (; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }

            }
            //          System.out.println("");
        }
        //          System.out.println("X ialah: "+divider.x);
        //          System.out.println("Y ialah: "+divider.y);
        //          System.out.println("\n\n");

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

            begin.x = xUpperCentroid;
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

        return points;
    }

    public ArrayList<Point> getUpperUpperZone(BufferedImage image_dest, Point centroid_upperZone) {
        //          System.out.println("\n\nBigger Upper Upper Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        int w = image_dest.getWidth();
        int y_divider = centroid_upperZone.y;

        for (int y = 0; y <= y_divider; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        //          System.out.println("\n\n");

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

            begin.x = xUpperCentroid;
            begin.y = 0;

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

        return points;
    }

    public ArrayList<Point> getUpperLowerZone(BufferedImage image_dest, Point centroid_upperZone, Point divider) {
        //          System.out.println("\n\nBigger Upper Lower Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        int w = image_dest.getWidth();
        int y_start = centroid_upperZone.y;

        for (int y = y_start; y <= divider.y; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        //          System.out.println("\n\n");

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

            begin.x = xUpperCentroid;
            begin.y = yUpperCentroid;

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

        return points;
    }

    public ArrayList<Point> getLowerZone(BufferedImage image_dest, Point divider) {
        //          System.out.println("\n\nBigger Lower Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();

        int xLowerCentroid = 0;
        int yLowerCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        int y_divider = divider.y;

        for (int y = y_divider; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }
        //          System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yLowerCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xLowerCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));

            yLowerCentroid = (int) Math.round(new Double(d_yLowerCentroid));
            xLowerCentroid = (int) Math.round(new Double(d_xLowerCentroid));

            //Note: After round the value of x for point3, the centroid of x become (10.7 -> 11)
            if (divider.x != xLowerCentroid) {
                xLowerCentroid = xLowerCentroid - 1;
            }

            point3 = new Point(xLowerCentroid, yLowerCentroid);

            Point begin = new Point(0, divider.y);
            Point end = new Point(w, h);

            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xLowerCentroid;
            begin.y = divider.y;

            end.x = w;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);

            if (point1.y == point2.y && point2.y == point3.y)
                point1.y = point1.y + 1;
            if (point1.x == point2.x && point2.x == point3.x)
                point1.x = point1.x + 1;
        }

        points.add(point1);
        points.add(point2);
        points.add(point3);

        return points;
    }

    public ArrayList<Point> getLowerUpperZone(BufferedImage image_dest, Point centroid_lowerZone, Point divider) {
        //          System.out.println("\n\nBigger Lower Upper Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int xLowerUpperCentroid = 0;
        int yLowerUpperCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        int w = image_dest.getWidth();
        int y_start = divider.y;

        for (int y = y_start; y <= centroid_lowerZone.y; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }

            }

            //          System.out.println("");
        }

        //          System.out.println("\n\n");

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

            //Note: After round the value of x for point3, the centroid of x become (10.7 -> 11)
            if (divider.x != xLowerUpperCentroid) {
                xLowerUpperCentroid = xLowerUpperCentroid - 1;
            }

            point3 = new Point(xLowerUpperCentroid, yLowerUpperCentroid);

            Point begin = new Point(0, divider.y);
            Point end = new Point(xLowerUpperCentroid, yLowerUpperCentroid);

            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xLowerUpperCentroid;
            begin.y = divider.y;

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

        return points;
    }

    public ArrayList<Point> getLowerLowerZone(BufferedImage image_dest, Point centroid_lowerZone, Point divider) {
        //          System.out.println("\n\nBigger Lower Lower Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int xLowerLowerCentroid = 0;
        int yLowerLowerCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();

        int y_start = centroid_lowerZone.y;

        for (int y = y_start; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        //          System.out.println("\n\n");

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yUpperCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xUpperCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));

            yLowerLowerCentroid = (int) Math.round(new Double(d_yUpperCentroid));
            xLowerLowerCentroid = (int) Math.round(new Double(d_xUpperCentroid));

            //Note: After round the value of x for point3, the centroid of x become (10.7 -> 11)
            if (divider.x != xLowerLowerCentroid) {
                xLowerLowerCentroid = xLowerLowerCentroid - 1;
            }

            point3 = new Point(xLowerLowerCentroid, yLowerLowerCentroid);

            Point begin = new Point(0, centroid_lowerZone.y);
            Point end = new Point(xLowerLowerCentroid, yLowerLowerCentroid);

            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xLowerLowerCentroid;
            begin.y = yLowerLowerCentroid;

            end.x = w;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);

            if (point1.y == point2.y && point2.y == point3.y)
                point1.y = point1.y + 1;
            if (point1.x == point2.x && point2.x == point3.x)
                point1.x = point1.x + 1;
        }

        points.add(point1);
        points.add(point2);
        points.add(point3);

        return points;
    }

    public ArrayList<Point> getRightZone(BufferedImage image_dest, Point divider) {
        //          System.out.println("\n\nBigger Right Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();

        int xRightCentroid = 0;
        int yRightCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        for (int y = 0; y < h; y++) {
            for (int x = divider.x; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        //          System.out.println("\n\n");

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

            point3 = new Point(xRightCentroid, yRightCentroid);

            Point begin = new Point(divider.x, 0);
            Point end = new Point(xRightCentroid, h);

            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xRightCentroid;
            begin.y = 0;

            end.x = w;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);
        }

        points.add(point1);
        points.add(point2);
        points.add(point3);

        return points;
    }

    public ArrayList<Point> getRightRightZone(BufferedImage image_dest, Point centroid_rightZone) {
        //          System.out.println("\n\nBigger Right Right Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();

        int xRightRightCentroid = 0;
        int yRightRightCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        for (int y = 0; y < h; y++) {
            for (int x = centroid_rightZone.x; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        //          System.out.println("\n\n");

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

            if (yRightRightCentroid != centroid_rightZone.y) {
                yRightRightCentroid = centroid_rightZone.y;
            }

            point3 = new Point(xRightRightCentroid, yRightRightCentroid);

            Point begin = new Point(centroid_rightZone.x, 0);
            Point end = new Point(xRightRightCentroid, h);

            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xRightRightCentroid;
            begin.y = 0;

            end.x = w;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);
        }

        points.add(point1);
        points.add(point2);
        points.add(point3);

        return points;
    }

    public ArrayList<Point> getRightLeftZone(BufferedImage image_dest, Point divider, Point centroid_rightZone) {
        //          System.out.println("\n\nBigger Right Left");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int h = image_dest.getHeight();

        int xRightLeftCentroid = 0;
        int yRightLeftCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        for (int y = 0; y < h; y++) {
            for (int x = divider.x; x <= centroid_rightZone.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        //          System.out.println("\n\n");

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

            point3 = new Point(xRightLeftCentroid, yRightLeftCentroid);

            Point begin = new Point(divider.x, 0);
            Point end = new Point(xRightLeftCentroid, h);

            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xRightLeftCentroid;
            begin.y = 0;

            end.x = centroid_rightZone.x;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);
        }

        points.add(point1);
        points.add(point2);
        points.add(point3);

        return points;
    }

    public ArrayList<Point> getLeftZone(BufferedImage image_dest, Point divider) {
        //          System.out.println("\n\nBigger Left Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int h = image_dest.getHeight();

        int xLeftCentroid = 0;
        int yLeftCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        //          System.out.println("\n\n");

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
            Point end = new Point(divider.x, h);

            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xLeftCentroid;
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

    public ArrayList<Point> getLeftRightZone(BufferedImage image_dest, Point divider, Point centroidLeftZone) {

        //          System.out.println("\n\nBigger Left Right Zone");

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int h = image_dest.getHeight();

        int xLeftRightCentroid = 0;
        int yLeftRightCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        ArrayList<Point> points = new ArrayList<Point>();

        int x_start = centroidLeftZone.x;

        for (int y = 0; y < h; y++) {
            for (int x = x_start; x <= divider.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        //          System.out.println("\n\n");

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

            begin.x = xLeftRightCentroid;
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

        //          System.out.println("\n\nBigger Left Left Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int h = image_dest.getHeight();

        int xLeftCentroid = 0;
        int yLeftCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        int divider = centroidLeftZone.x;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x <= divider; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        //          System.out.println("\n\n");

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

            begin.x = xLeftCentroid;
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

    public ArrayList<Point> getUpperExtended(BufferedImage image_dest, Point divider, int x_end, int x_begin) {

        //          System.out.println("\n\nBigger Upper Extended Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int xUpperCentroid = 0;
        int yUpperCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        int w = image_dest.getWidth();
        int y_divider = divider.y;

        if (x_end != 0) {
            w = x_end + 1;
        }

        for (int y = 0; y <= y_divider; y++) {
            int x = 0;

            if (x_begin != 0) {
                x = x_begin;
            }

            for (; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }

            }
            //          System.out.println("");
        }

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

            begin.x = xUpperCentroid;
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

        return points;
    }

    public ArrayList<Point> getLowerExtended(BufferedImage image_dest, Point divider, int x_begin, int x_end) {

        //          System.out.println("\n\nBigger Lower Extended Zone");

        ArrayList<Point> points = new ArrayList<Point>();

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        int w = image_dest.getWidth();
        int h = image_dest.getHeight();

        int xLowerCentroid = 0;
        int yLowerCentroid = 0;

        Point point1 = null;
        Point point2 = null;
        Point point3 = null;

        int y_divider = divider.y;

        if (x_end != 0) {
            w = x_end + 1;
        }

        for (int y = y_divider; y < h; y++) {
            for (int x = x_begin; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        }

        if (count == 0) {
            //JOptionPane.showMessageDialog(null, "No black pixels exist");
            point1 = new Point(0, 0);
            point2 = new Point(0, 0);
            point3 = new Point(0, 0);
        } else {
            double d_yLowerCentroid = Double.valueOf(df.format(new Double(y_sum).doubleValue() / new Double(count).doubleValue()));
            double d_xLowerCentroid = Double.valueOf(df.format(new Double(x_sum).doubleValue() / new Double(count).doubleValue()));

            yLowerCentroid = (int) Math.round(new Double(d_yLowerCentroid));
            xLowerCentroid = (int) Math.round(new Double(d_xLowerCentroid));

            point3 = new Point(xLowerCentroid, yLowerCentroid);

            Point begin = new Point(x_begin, divider.y);
            Point end = new Point(w, h);

            point2 = getLeft(image_dest, point3, begin, end);

            begin.x = xLowerCentroid;
            begin.y = divider.y;

            end.x = w;
            end.y = h;

            point1 = getRight(image_dest, point3, begin, end);

            if (point1.y == point2.y && point2.y == point3.y)
                point1.y = point1.y + 1;
            if (point1.x == point2.x && point2.x == point3.x)
                point1.x = point1.x + 1;

        }

        points.add(point1);
        points.add(point2);
        points.add(point3);

        return points;
    }

    public Point getRight(BufferedImage dest_image, Point centroid, Point begin, Point end) {
        int xc = centroid.x;

        int x = begin.x;
        int y = begin.y;

        int x_sumR = 0;
        int y_sumR = 0;

        int countR = 0;

        for (y = begin.y; y < end.y; y++) {
            for (x = xc; x < end.x; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sumR += x;
                    y_sumR += y;
                    countR++;

                    ////          System.out.print("0");
                } else {

                    ////          System.out.print("1");
                }
            }

            ////          System.out.println("");
        }

        int y1 = 0;
        int x1 = 0;

        if (countR == 0) {

            x1 = 0;
            y1 = 0;
        } else {

            double d_y1 = Double.valueOf(df.format(new Double(y_sumR).doubleValue() / new Double(countR).doubleValue()));
            double d_x1 = Double.valueOf(df.format(new Double(x_sumR).doubleValue() / new Double(countR).doubleValue()));

            y1 = (int) Math.round(new Double(d_y1));
            x1 = (int) Math.round(new Double(d_x1));
        }

        return new Point(x1, y1);
    }

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

                    ////          System.out.print("0");
                } else {

                    ////          System.out.print("1");
                }
            }

            ////          System.out.println("");

        }

        int x_left = 0;
        int y_left = 0;

        if (countL == 0) {

            x_left = 0;
            y_left = 0;
        } else {

            double d_yLeft = Double.valueOf(df.format(new Double(y_sumL).doubleValue() / new Double(countL).doubleValue()));
            double d_xLeft = Double.valueOf(df.format(new Double(x_sumL).doubleValue() / new Double(countL).doubleValue()));

            y_left = (int) Math.round(new Double(d_yLeft));
            x_left = (int) Math.round(new Double(d_xLeft));
        }

        return new Point(x_left, y_left);
    }

    public ArrayList<Point> getTopRightRight(BufferedImage image_dest, Point centroid) {
        //          System.out.println("\n\nBigger Top Right Right");

        int xEnd = centroid.x;
        int yEnd = centroid.y;
        Point centroids = new Point(centroid);
        LinkedList<Point> list = new LinkedList<Point>();
        while (centroids.x != -1 && centroids.y != -1) {
            list.addFirst(new Point(centroids.x, centroids.y));
            centroids.x++;
            centroids.y--;
        }

        int x_sum = 0;
        int y_sum = 0;
        int count = 0;

        Point pointC = null; //centroid	-C
        Point pointA = null; //rigth 	-A
        Point pointB = null; //left		-B

        pointC = convertPoint(x_sum, y_sum, count);

        ArrayList<Point> points = new ArrayList<Point>();

        Point allBlackPoint = null;
        ArrayList<Point> listPoint = new ArrayList<>();

        for (int j = 0; j < yEnd; j++) {
            for (int i = xEnd; i < image_dest.getWidth(); i++) {
                if (image_dest.getRGB(i, list.get(j).y) != -1) {

                    if (i < list.get(j).x) {
                        //          System.out.print("Q");
                    } else if (i >= list.get(j).y) {
                        ////          System.out.print(i+" ,"+p.y+" ");
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//					else
                    //          System.out.print("1");
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);
        //          System.out.println("PointC : "+pointC);

        int value_xKiri = 0;
        int value_yKiri = 0;

        int value_xKanan = 0;
        int value_yKanan = 0;

        int count_Right = 0;
        int count_Left = 0;
        for (Point p1 : listPoint) {
            if (p1.x <= pointC.x) {
                value_xKiri += p1.x;
                value_yKiri += p1.y;
                count_Left++;
            }

            if (p1.x >= pointC.x) {
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;
            }
        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);
        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        return points;
    }

    public ArrayList<Point> getTopRightLeft(BufferedImage image_dest, Point centroid) {

        //          System.out.println("\n\nBigger Top Right Left");

        int xEnd = centroid.x;
        int yEnd = centroid.y;
        Point centroids = new Point(centroid);
        LinkedList<Point> list = new LinkedList<Point>();

        while (centroids.x != -1 && centroids.y != -1) {
            list.addFirst(new Point(centroids.x, centroids.y));
            centroids.x++;
            centroids.y--;
        }

        int x_sum = 0;
        int y_sum = 0;
        int count = 0;

        Point pointC = null;
        Point pointA = null;
        Point pointB = null;

        pointC = convertPoint(x_sum, y_sum, count);

        ArrayList<Point> points = new ArrayList<Point>();

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        for (int j = 0; j < yEnd; j++) {
            for (int i = xEnd; i < image_dest.getWidth(); i++) {
                if (image_dest.getRGB(i, list.get(j).y) != -1) {
                    if (i < xEnd) {
                        //          System.out.print("Q");
                    } else if (i <= list.get(j).x || i == xEnd) {
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    } else {
                        //          System.out.print("Q");
                    }
                } else {
                    //          System.out.print("1");
                }
            }

            //          System.out.println("");
        } //end for outter

        //          System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);

        int value_xKiri = 0;
        int value_yKiri = 0;

        int value_xKanan = 0;
        int value_yKanan = 0;

        int count_Right = 0;
        int count_Left = 0;

        for (Point p1 : listPoint) {
            if (p1.x <= pointC.x) {
                value_xKiri += p1.x;
                value_yKiri += p1.y;
                count_Left++;
            }

            if (p1.x >= pointC.x) {
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;
            }
        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);

        return points;
    }

    public ArrayList<Point> getTopLeftRight(BufferedImage image_dest, Point centroid) {

        //          System.out.println("\n\nBigger Top Left Right");

        int yEnd = centroid.y;
        int xEnd = centroid.x;
        Point centroids = new Point(centroid);
        LinkedList<Point> list = new LinkedList<Point>();

        while (centroids.x != -1 && centroids.y != -1) {
            list.addFirst(new Point(centroids.x, centroids.y));
            centroids.x--;
            centroids.y--;
        }

        int x_sum = 0;
        int y_sum = 0;
        int count = 0;

        Point pointC = null;
        Point pointA = null;
        Point pointB = null;

        pointC = convertPoint(x_sum, y_sum, count);

        ArrayList<Point> points = new ArrayList<Point>();

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int indexList = 0;

        for (int j = 0; j <= yEnd; j++) {
            for (int i = pointC.x; i <= xEnd; i++) {
                if (image_dest.getRGB(i, j) != -1) {
                    if (i >= list.get(indexList).x && i <= xEnd) {
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    } else {
                        //          System.out.print("Q");
                    }
                } else {
                    //          System.out.print("1");
                }
            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;

            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);

        int value_xKiri = 0;
        int value_yKiri = 0;

        int value_xKanan = 0;
        int value_yKanan = 0;

        int count_Right = 0;
        int count_Left = 0;

        for (Point p1 : listPoint) {
            if (p1.x <= pointC.x) {
                value_xKiri += p1.x;
                value_yKiri += p1.y;
                count_Left++;
            }

            if (p1.x >= pointC.x) {
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;
            }
        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);

        return points;
    }

    public ArrayList<Point> getTopLeftLeft(BufferedImage image_dest, Point centroid) {

        //          System.out.println("\n\nBigger Top Left Left");

        int yEnd = centroid.y;
        int xEnd = centroid.x;

        Point centroids = new Point(centroid);

        LinkedList<Point> list = new LinkedList<Point>();

        while (centroids.x != -1 && centroids.y != -1) {
            list.addFirst(new Point(centroids.x, centroids.y));
            centroids.x--;
            centroids.y--;
        }

        int x_sum = 0;
        int y_sum = 0;
        int count = 0;

        Point pointC = null;
        Point pointA = null;
        Point pointB = null;

        ArrayList<Point> points = new ArrayList<Point>();

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int indexList = 0;

        for (int j = 0; j <= yEnd; j++) {
            for (int i = 0; i <= xEnd; i++) {
                if (image_dest.getRGB(i, j) != -1) {
                    if (i < list.get(indexList).x) {
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    } else {
                        //          System.out.print("Q");

                    }
                } else {
                    //          System.out.print("1");
                }
            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;

            //          System.out.println();

        } //end for outter

        //          System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);

        int value_xKiri = 0;
        int value_yKiri = 0;

        int value_xKanan = 0;
        int value_yKanan = 0;

        int count_Right = 0;
        int count_Left = 0;

        for (Point p1 : listPoint) {
            if (p1.x <= pointC.x) {
                value_xKiri += p1.x;
                value_yKiri += p1.y;
                count_Left++;
            }

            if (p1.x >= pointC.x) {
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;
            }
        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);

        return points;
    }

    public ArrayList<Point> getBottomRightRight(BufferedImage image_dest, Point centroid) {

        //          System.out.println("\n\nBigger Bottom Right Right");

        int xEnd = centroid.x;
        int yEnd = centroid.y;
        Point centroids = new Point(centroid);
        LinkedList<Point> list = new LinkedList<Point>();

        while (centroids.x != -1 && centroids.y != image_dest.getHeight()) {
            list.addLast(new Point(centroids.x, centroids.y));
            centroids.x++;
            centroids.y++;
        }

        int x_sum = 0;
        int y_sum = 0;
        int count = 0;

        Point pointC = null;
        Point pointA = null;
        Point pointB = null;

        pointC = convertPoint(x_sum, y_sum, count);

        ArrayList<Point> points = new ArrayList<Point>();

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int j = yEnd; j <= image_dest.getHeight(); j++) {
            for (int i = xEnd; i < image_dest.getWidth(); i++) {
                if (image_dest.getRGB(i, j) != -1) {
                    if (i < xEnd) {
                        //          System.out.print("Q");
                    } else if (i >= list.get(jCount).x) {
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);

        int value_xKiri = 0;
        int value_yKiri = 0;

        int value_xKanan = 0;
        int value_yKanan = 0;

        int count_Right = 0;
        int count_Left = 0;

        for (Point p1 : listPoint) {
            if (p1.x <= pointC.x) {
                value_xKiri += p1.x;
                value_yKiri += p1.y;
                count_Left++;
            }

            if (p1.x >= pointC.x) {
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;
            }
        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);

        return points;
    }

    public ArrayList<Point> getBottomRightLeft(BufferedImage image_dest, Point centroid) {

        //          System.out.println("\n\nBigger Bottom Right Left");

        int xEnd = centroid.x;
        int yEnd = centroid.y;
        Point centroids = new Point(centroid);
        LinkedList<Point> list = new LinkedList<Point>();

        while (centroids.x != -1 && centroids.y != image_dest.getHeight()) {
            list.addLast(new Point(centroids.x, centroids.y));
            centroids.x++;
            centroids.y++;
        }

        int x_sum = 0;
        int y_sum = 0;
        int count = 0;

        Point pointC = null;
        Point pointA = null;
        Point pointB = null;

        pointC = convertPoint(x_sum, y_sum, count);

        ArrayList<Point> points = new ArrayList<Point>();

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int j = yEnd; j <= image_dest.getHeight(); j++) {
            for (int i = xEnd; i < image_dest.getWidth(); i++) {
                if (image_dest.getRGB(i, j) != -1) {

                    if (i < xEnd) {
                        //          System.out.print("Q");
                    } else if (i <= list.get(jCount).x) {
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);

        int value_xKiri = 0;
        int value_yKiri = 0;

        int value_xKanan = 0;
        int value_yKanan = 0;

        int count_Right = 0;
        int count_Left = 0;

        for (Point p1 : listPoint) {
            if (p1.x <= pointC.x) {
                value_xKiri += p1.x;
                value_yKiri += p1.y;
                count_Left++;
            }

            if (p1.x >= pointC.x) {
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;
            }
        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);

        return points;
    }

    public ArrayList<Point> getBottomLeftRight(BufferedImage image_dest, Point centroid) {

        //          System.out.println("\n\nBigger Bottom Left Right");

        int xEnd = centroid.x;
        int yEnd = centroid.y;
        Point centroids = new Point(centroid);
        LinkedList<Point> list = new LinkedList<Point>();

        while (centroids.x != -1 && centroids.y != image_dest.getHeight()) {
            list.addLast(new Point(centroids.x, centroids.y));
            centroids.x--;
            centroids.y++;
        }

        int x_sum = 0;
        int y_sum = 0;
        int count = 0;

        Point pointC = null;
        Point pointA = null;
        Point pointB = null;

        pointC = convertPoint(x_sum, y_sum, count);

        ArrayList<Point> points = new ArrayList<Point>();

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int j = yEnd; j <= image_dest.getHeight(); j++) {
            for (int i = 0; i <= xEnd; i++) {
                if (image_dest.getRGB(i, j) != -1) {
                    if (i < list.get(jCount).x) {
                        //          System.out.print("Q");
                    } else if (i >= list.get(jCount).x && i <= xEnd) {
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }


            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);

        int value_xKiri = 0;
        int value_yKiri = 0;

        int value_xKanan = 0;
        int value_yKanan = 0;

        int count_Right = 0;
        int count_Left = 0;

        for (Point p1 : listPoint) {
            if (p1.x <= pointC.x) {
                value_xKiri += p1.x;
                value_yKiri += p1.y;
                count_Left++;
            }

            if (p1.x >= pointC.x) {
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;
            }
        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);

        return points;
    }

    public ArrayList<Point> getBottomLeftLeft(BufferedImage image_dest, Point centroid) {

        //          System.out.println("\n\nBigger Bottom Left Left");

        int xEnd = centroid.x;
        int yEnd = centroid.y;
        Point centroids = new Point(centroid);
        LinkedList<Point> list = new LinkedList<Point>();

        while (centroids.x != -1 && centroids.y != image_dest.getHeight()) {
            list.addLast(new Point(centroids.x, centroids.y));
            centroids.x--;
            centroids.y++;
        }

        int x_sum = 0;
        int y_sum = 0;
        int count = 0;

        Point pointC = null;
        Point pointA = null;
        Point pointB = null;

        pointC = convertPoint(x_sum, y_sum, count);

        ArrayList<Point> points = new ArrayList<Point>();

        Point allBlackPoint = null;

        ArrayList<Point> listPoint = new ArrayList<>();

        int jCount = 0;

        for (int j = yEnd; j <= image_dest.getHeight(); j++) {
            for (int i = 0; i <= xEnd; i++) {
                if (image_dest.getRGB(i, j) != -1) {
                    if (i <= list.get(jCount).x) {
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
                        //          System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//					else
                    //          System.out.print("Q");
                } else {
                    //          System.out.print("1");
                }
            }

            if (jCount < list.size() - 1)
                jCount++;
            else
                break;
            //          System.out.println();
        } //end for outter

        //          System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);

        int value_xKiri = 0;
        int value_yKiri = 0;

        int value_xKanan = 0;
        int value_yKanan = 0;

        int count_Right = 0;
        int count_Left = 0;

        for (Point p1 : listPoint) {
            if (p1.x <= pointC.x) {
                value_xKiri += p1.x;
                value_yKiri += p1.y;
                count_Left++;
            }

            if (p1.x >= pointC.x) {
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;
            }
        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);

        return points;
    }

    public Point getCentroid(BufferedImage image_dest) {
        //          System.out.println("\n\nBigger Centroid of 45 degrees");

        int count = 0;
        int x_sum = 0;
        int y_sum = 0;

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (image_dest.getRGB(x, y) != -1) {
                    x_sum += x;
                    y_sum += y;
                    count++;

                    //          System.out.print("0");
                }
//				else
                //          System.out.print("1");
            }
            //          System.out.println("");
        }

        double mycount = new Double(count).doubleValue();
        double d_y3 = 0;
        double d_x3 = 0;

        if (mycount != 0) {
            d_y3 = Double.valueOf(df.format(new Double(y_sum).doubleValue() / mycount));
            d_x3 = Double.valueOf(df.format(new Double(x_sum).doubleValue() / mycount));
        }

        int y3 = (int) Math.round(new Double(d_y3));
        int x3 = (int) Math.round(new Double(d_x3));

        return new Point(x3, y3);
    }

    public Point convertPoint(int x, int y, int count) {
        double ytemp = 0;
        double xtemp = 0;

        if (count != 0) {
            ytemp = Double.valueOf(df.format(new Double(y).doubleValue() / count));
            xtemp = Double.valueOf(df.format(new Double(x).doubleValue() / count));
        }

        int yy = (int) Math.round(new Double(ytemp));
        int xx = (int) Math.round(new Double(xtemp));

        return new Point(xx, yy);
    }

}
