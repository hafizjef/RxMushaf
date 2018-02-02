package featureTriangle.api;

import featureTriangle.bean.Bean_Triangle_Descriptor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;


public class MyPointProcess45 {
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

    public MyPointProcess45(BufferedImage image_dest, String fname) {
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

//		for(int y=0; y<h;y++)
//		{
//			for(int x =0 ; x<w; x++)
//			{
//				if(image_dest.getRGB(x, y)==-1)
//					System.out.print("1");
//				else
//				{
//					//System.err.print("X"+x+" Y : "+y);
//					//return;
//					System.out.print("0");
//				}
//			}
//			System.out.println("");
//		}

    }


    /**
     * point[0] coordinate of the right image 0|1
     * point[1] coordinate of the left image 1|0
     * point[2] represent centroid
     *
     * @param image_dest
     * @return three triangle points for the main triangle
     * ********************************************************************
     * Method Name            Data type            Method in Eng
     * *******************************************************************
     * [1]  getCentroid           :Point
     * [2]  keAtasKiriKiri        :ArrayList<Point>    :Upper Left Left
     * [3]  keAtasKiriKanan       :ArrayList<Point>    :Upper Left Right
     * [4]  keAtasKananKiri       :ArrayList<Point>    :Upper Right Left
     * [5]  keAtasKananKanan      :ArrayList<Point>    :Upper Right Right
     * [6]  keBawahKiriKiri       :ArrayList<Point>    :Lower Left Left
     * [7]  keBawahKiriKanan      :ArrayList<Point>    :Lower Left Right
     * [8]  keBawahKananKiri      :ArrayList<Point>    :Lower Right Left
     * [9]  keBawahKananKanan     :ArrayList<Point>    :Lower Right Right
     * [10] convertPoint          :Point
     * [11] getPointKiri          :Point
     * [12] getPoints             :ArrayList<Point>
     * [13] getRight              :Point
     * [14] getLeft               :Point
     */

    public Point getCentroid(BufferedImage image_dest) {
        int count = 0;
        int x_sum = 0;
        int y_sum = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
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

        return new Point(x3, y3);

    }

    public ArrayList<Point> keAtasKiriKiri(BufferedImage image_dest, Point centroid) {
        int yEnd = centroid.y;
        int xEnd = centroid.x;
        LinkedList<Point> list = new LinkedList<Point>();
        while (centroid.x != -1 && centroid.y != -1) {
            list.addFirst(new Point(centroid.x, centroid.y));
//			System.out.println(centroid);
            centroid.x--;
            centroid.y--;

        }

        int x_sum = 0;
        int y_sum = 0;
        int count = 0;


        Point pointC = null; //centroid	-C
        Point pointA = null; //rigth 	-A
        Point pointB = null; //left		-B

        ArrayList<Point> points = new ArrayList<Point>();


        Point allBlackPoint = null;
        ArrayList<Point> listPoint = new ArrayList<>();

//		System.out.println("yEnd "+yEnd);

        int indexList = 0;
//		System.out.println("List Size : "+indexList);
        for (int j = 0; j <= yEnd; j++) {
            //System.out.println("JJJJ : "+j);
            for (int i = 0; i <= xEnd; i++) {
                //if(image_dest.getRGB(i, list.get(j).y)!=-1)


                if (image_dest.getRGB(i, j) != -1) {
                    if (i < list.get(indexList).x) {
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
//							System.out.print("0");

                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//						else
//						{	System.out.print("Q");
//
//						}
                    //}

                }
//				else
//				{	System.out.print("1");
//
//				}

            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;
//			System.out.println();

        } //end for outter

//		System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);


        //System.out.println("Point C :"+pointC);

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
                //System.out.println("p1besar :"+p1);
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;

            }

        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);
        //System.out.println("Point B :"+pointB);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);
        //System.out.println("Point A :"+pointA);


        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        return points;
    }

    public ArrayList<Point> keAtasKiriKanan(BufferedImage image_dest, Point centroid) {

//		System.out.println("\n atas kiri kanan");

        int yEnd = centroid.y;
        int xEnd = centroid.x;

        //System.out.println("yEnd : "+yEnd);
        //System.out.println("xEnd : "+xEnd);

        LinkedList<Point> list = new LinkedList<Point>();
        while (centroid.x != -1 && centroid.y != -1) {
            list.addFirst(new Point(centroid.x, centroid.y));
            //System.out.println(centroid);
            centroid.x--;
            centroid.y--;

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

        int indexList = 0;
        for (int j = 0; j <= yEnd; j++) {
            for (int i = pointC.x; i <= xEnd; i++) {
                if (image_dest.getRGB(i, j) != -1) {
                    if (i >= list.get(indexList).x && i <= xEnd) {
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
//						System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//					else
//					{	System.out.print("Q");
//					}

                }
//				else
//				{	System.out.print("1");
//				}

            }

            if (indexList < list.size() - 1)
                indexList++;
            else
                break;


//			System.out.println();
        } //end for outter

//		System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);
//		System.out.println("PointC : "+pointC);

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
                //System.out.println("p1besar :"+p1);
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;

            }

        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);
//		System.out.println("Point B :"+pointB);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);
//		System.out.println("Point A :"+pointA);


        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        return points;
    }

    public ArrayList<Point> keAtasKananKiri(BufferedImage image_dest, Point centroid) {
        int xEnd = centroid.x;
        int yEnd = centroid.y;
//		System.out.println("x y end : "+xEnd+", "+yEnd);
        LinkedList<Point> list = new LinkedList<Point>();
        while (centroid.x != -1 && centroid.y != -1) {
            list.addFirst(new Point(centroid.x, centroid.y));
//			System.out.println(centroid);
            centroid.x++;
            centroid.y--;

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

                    if (i < xEnd) {
//						System.out.print("Q");
                    } else if (i <= list.get(j).x || i == xEnd) {
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
//						System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//					else
//					{	System.out.print("Q");
//					}

                }
//				else
//				{	System.out.print("1");
//				}

            }


//			System.out.println();
        } //end for outter

//		System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);
//		System.out.println("PointC : "+pointC);

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
                //System.out.println("p1besar :"+p1);
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;

            }

        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);
//		System.out.println("Point B :"+pointB);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);
//		System.out.println("Point A :"+pointA);


        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        //JOptionPane.showMessageDialog(null, points);

        return points;
    }

    public ArrayList<Point> keAtasKananKanan(BufferedImage image_dest, Point centroid) {
        int xEnd = centroid.x;
        int yEnd = centroid.y;
//		System.out.println("x y end : "+xEnd+", "+yEnd);
        LinkedList<Point> list = new LinkedList<Point>();
        while (centroid.x != -1 && centroid.y != -1) {
            list.addFirst(new Point(centroid.x, centroid.y));
//			System.out.println(centroid);
            centroid.x++;
            centroid.y--;

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

        //imej dlm database menggunkan j<=yEnd
        for (int j = 0; j < yEnd; j++) {
            for (int i = xEnd; i < image_dest.getWidth(); i++) {
                if (image_dest.getRGB(i, list.get(j).y) != -1) {

                    if (i < list.get(j).x) {
//						System.out.print("Q");
                    } else if (i >= list.get(j).y) {
                        //System.out.print(i+" ,"+p.y+" ");
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
//						System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//					else
//						System.out.print("1");
                }
//				else
//				{	System.out.print("1");
//				}

            }


//			System.out.println();
        } //end for outter

//		System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);
//		System.out.println("PointC : "+pointC);

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
                //System.out.println("p1besar :"+p1);
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;

            }

        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);
//		System.out.println("Point B :"+pointB);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);
//		System.out.println("Point A :"+pointA);


        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        return points;
    }

    public ArrayList<Point> keBawahKiriKiri(BufferedImage image_dest, Point centroid) {
        int xEnd = centroid.x;
        int yEnd = centroid.y;
//		System.out.println("x y end : "+xEnd+", "+yEnd);
        LinkedList<Point> list = new LinkedList<Point>();

        while (centroid.x != -1 && centroid.y != image_dest.getHeight()) {
//			System.out.println(centroid);
            list.addLast(new Point(centroid.x, centroid.y));
            centroid.x--;
            centroid.y++;

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


        int jCount = 0;
        for (int j = yEnd; j <= image_dest.getHeight(); j++) {
            for (int i = 0; i <= xEnd; i++) {
                if (image_dest.getRGB(i, j) != -1) {

                    if (i <= list.get(jCount).x) {
                        //System.out.print(i+" ,"+p.y+" ");
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
//						System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }

//					else
//						System.out.print("Q");

                    //System.out.println();


                }
//				else
//				{	System.out.print("1");
//				}
                //System.out.println("");

            }
//			System.out.println();
            if (jCount < list.size() - 1)
                jCount++;
            else
                break;

        } //end for outter

//		System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);
//		System.out.println("PointC : "+pointC);

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
                //System.out.println("p1besar :"+p1);
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;

            }

        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);
//		System.out.println("Point B :"+pointB);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);
//		System.out.println("Point A :"+pointA);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        return points;
    }

    public ArrayList<Point> keBawahKiriKanan(BufferedImage image_dest, Point centroid) {
        int xEnd = centroid.x;
        int yEnd = centroid.y;
//		System.out.println("x y end : "+xEnd+", "+yEnd);
        LinkedList<Point> list = new LinkedList<Point>();

        while (centroid.x != -1 && centroid.y != image_dest.getHeight()) {
//			System.out.println(centroid);
            list.addLast(new Point(centroid.x, centroid.y));
            centroid.x--;
            centroid.y++;

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


        int jCount = 0;
        for (int j = yEnd; j <= image_dest.getHeight(); j++) {
            for (int i = 0; i <= xEnd; i++) {
                if (image_dest.getRGB(i, j) != -1) {

                    if (i < list.get(jCount).x) {
//						System.out.print("Q");
                    } else if (i >= list.get(jCount).x && i <= xEnd) {
                        //System.out.print(i+" ,"+p.y+" ");
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
//						System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//					else
//						System.out.print("Q");


                    //System.out.println();


                }
//				else
//				{	System.out.print("1");
//				}
                //System.out.println("");

            }
//			System.out.println();
            if (jCount < list.size() - 1)
                jCount++;
            else
                break;

        } //end for outter

//		System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);
//		System.out.println("PointC : "+pointC);

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
                //System.out.println("p1besar :"+p1);
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;

            }

        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);
//		System.out.println("Point B :"+pointB);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);
//		System.out.println("Point A :"+pointA);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        return points;
    }

    public ArrayList<Point> keBawahKananKiri(BufferedImage image_dest, Point centroid) {
        int xEnd = centroid.x;
        int yEnd = centroid.y;
//		System.out.println("x y end : "+xEnd+", "+yEnd);
        LinkedList<Point> list = new LinkedList<Point>();

        while (centroid.x != -1 && centroid.y != image_dest.getHeight()) {
//			System.out.println(centroid);
            list.addLast(new Point(centroid.x, centroid.y));
            centroid.x++;
            centroid.y++;

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


        int jCount = 0;
        for (int j = yEnd; j <= image_dest.getHeight(); j++) {
            for (int i = xEnd; i < image_dest.getWidth(); i++) {
                if (image_dest.getRGB(i, j) != -1) {

                    if (i < xEnd) {
//						System.out.print("Q");
                    } else if (i <= list.get(jCount).x) {
                        //System.out.print(i+" ,"+p.y+" ");
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
//						System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//					else
//						System.out.print("Q");


                    //System.out.println();


                }
//				else
//				{	System.out.print("1");
//				}
                //System.out.println("");

            }
//			System.out.println();
            if (jCount < list.size() - 1)
                jCount++;
            else
                break;

        } //end for outter

//		System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);
//		System.out.println("PointC : "+pointC);

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
                //System.out.println("p1besar :"+p1);
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;

            }

        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);
//		System.out.println("Point B :"+pointB);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);
//		System.out.println("Point A :"+pointA);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        return points;
    }

    public ArrayList<Point> keBawahKananKanan(BufferedImage image_dest, Point centroid) {
        int xEnd = centroid.x;
        int yEnd = centroid.y;
//		System.out.println("x y end : "+xEnd+", "+yEnd);
        LinkedList<Point> list = new LinkedList<Point>();

        while (centroid.x != -1 && centroid.y != image_dest.getHeight()) {
//			System.out.println(centroid);
            list.addLast(new Point(centroid.x, centroid.y));
            centroid.x++;
            centroid.y++;

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


        int jCount = 0;
        for (int j = yEnd; j <= image_dest.getHeight(); j++) {
            for (int i = xEnd; i < image_dest.getWidth(); i++) {
                if (image_dest.getRGB(i, j) != -1) {


                    if (i < xEnd) {
//						System.out.print("Q");
                    } else if (i >= list.get(jCount).x) {
                        //System.out.print(i+" ,"+p.y+" ");
                        allBlackPoint = new Point(i, j);
                        listPoint.add(allBlackPoint);
//						System.out.print("0");
                        x_sum += i;
                        y_sum += j;
                        count++;
                    }
//					else
//						System.out.print("Q");


                    //System.out.println();


                }
//				else
//				{	System.out.print("1");
//				}
                //System.out.println("");

            }
//			System.out.println();
            if (jCount < list.size() - 1)
                jCount++;
            else
                break;

        } //end for outter

//		System.out.println("\n");

        pointC = convertPoint(x_sum, y_sum, count);
//		System.out.println("PointC : "+pointC);

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
                //System.out.println("p1besar :"+p1);
                value_xKanan += p1.x;
                value_yKanan += p1.y;
                count_Right++;

            }

        }

        pointB = convertPoint(value_xKiri, value_yKiri, count_Left);
//		System.out.println("Point B :"+pointB);

        pointA = convertPoint(value_xKanan, value_yKanan, count_Right);
//		System.out.println("Point A :"+pointA);

        points.add(pointA);
        points.add(pointB);
        points.add(pointC);
        return points;
    }

    public Point convertPoint(int x, int y, int count) {

        double ytemp = 0;
        double xtemp = 0;
        if (count != 0) {
            ytemp = Double.valueOf(df.format(new Double(y).doubleValue() / count));
            xtemp = Double.valueOf(df.format(new Double(x).doubleValue() / count));
        }

//		System.out.println("xtemp :"+xtemp);
//		System.out.println("ytemp :"+ytemp);
        int yy = (int) Math.round(new Double(ytemp));
        int xx = (int) Math.round(new Double(xtemp));

        return new Point(xx, yy);
    }

    public Point getPointKiri(BufferedImage image_dest, Point start, Point end) {
        int count = 0;
        int sum_x = 0;
        int sum_y = 0;

//		System.out.println();
        for (int j = start.y; j <= end.y; j++) {
            for (int i = start.x; i <= end.x; i++) {
                //System.out.println("masuk");
                if (image_dest.getRGB(i, j) != -1) {
//					System.out.print("0");
                    sum_x += i;
                    sum_y += j;
                    count++;
                }
//				else
//				{
//					System.out.print("1");
//				}

            }
//			System.out.println();
        }
//		System.out.println();

        double mycount = new Double(count).doubleValue();

        double d_y2 = 0;
        double d_x2 = 0;
        if (mycount != 0) {
            d_y2 = Double.valueOf(df.format(new Double(sum_y).doubleValue() / mycount));
            d_x2 = Double.valueOf(df.format(new Double(sum_x).doubleValue() / mycount));
        }

        int y2 = (int) Math.round(new Double(d_y2));
        int x2 = (int) Math.round(new Double(d_x2));

        //System.out.println("point :"+x2+" , "+y2);

        return new Point(x2, y2);
    }

    public Point readFile(String file) throws IOException {

        File fail = new File(file);
        int count = 0;
        int countNewLine = 0;
        if (fail.exists()) {
            FileReader reader = new FileReader(fail);


            //System.out.println(value);

            char value = (char) reader.read();
            for (int i = 0; i < fail.length(); i++) {
                if (value == '0') {
//					System.out.print("0");

                    count++;
                } else if (value == '1') {
//					System.out.print("1");
                } else {
                    if (countNewLine == 0) {
//						System.out.println();
                        countNewLine++;
                    } else
                        countNewLine = 0;

                }
                value = (char) reader.read();
                //System.out.println();
            }
            //System.out.println();
        }
//		else
//			System.out.println("Not exists");
//		System.out.println("CountLagh " +count);
        return null;

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

    public void updateStatus(int count) {
        status = "ok";
        if (count == 0)
            status = "reset";

    }

    public String getStatus() {
        return status;
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



