/**
 * The triangle consists of three important points as follow.
 * i. Point A as point 1 that is located on the right
 * ii. Point B as point 2 that is located on the left
 * iii. Point C as point 3 that is the centroid point.
 */

package controller;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

//import javax.print.attribute.standard.MediaName;


public class MyScalene {
    String filename;

    // points get from image.
    private Point A;
    private Point B;
    private Point C;

    //	coordinate extracted from Point a, b and c
    double x1 = 0, y1 = 0;
    double x2 = 0, y2 = 0;
    double x3 = 0, y3 = 0;

    //	length of a named aa (from point a to b)
//	length of b named bb (from point b to c)
//	length of c named cc (from point c to a)
    double cc = 0;// length of a
    double aa = 0;// length of b
    double bb = 0;// length of c

    //	temporary coordinate/ point. This coordinate is used to get the length of triangle.
//	It makes theorem hipogorous triangle.
    double temp_x;
    double temp_y;

    //	Length from point to temporary point and vice versa
    double temp_ap = 0; //length from ab
    double temp_pb = 0;
    double temp_pc = 0;

    //	 Angle of A, B and C
    double angle_A = 0.0;
    double angle_B = 0.0;
    double angle_C = 0.0;

    double angle_A_rad = 0.0;
    double angle_B_rad = 0.0;
    double angle_C_rad = 0.0;

    String shape = "";

    DecimalFormat df = new DecimalFormat("#.###");
    DecimalFormat df1 = new DecimalFormat("#.#########");


    public MyScalene() {
        // TODO Auto-generated constructor stub
    }

    public MyScalene(int aa, int bb, int cc) {
        this.aa = aa;
        this.bb = bb;
        this.cc = cc;

    }

    public MyScalene(Point a, Point b, Point c) {
        this.A = a;
        this.B = b;
        this.C = c;
    }

    public MyScalene(ArrayList<Point> points) {

        A = points.get(0);
        B = points.get(1);
        C = points.get(2);//centroid

    }

    /**
     * frequently used by main
     *
     * @param filename
     * @param points
     */

    public MyScalene(String filename, ArrayList<Point> points) {
        this.filename = filename;
        //JOptionPane.showMessageDialog(null, points);
        A = points.get(0);//right
        B = points.get(1);//left
        C = points.get(2);//centroid
        //System.out.println("Nama Fail lah :"+filename);

    }

    public String getFileName() {
        return filename;
    }

    public ArrayList<Double> getTrianglePerimeter() {
        ArrayList<Double> sisi = new ArrayList<Double>();
        double perimeter = 0;
        double p_aa = 0;      //perimeter aa
        double p_cc = 0;      //perimeter cc

        x1 = A.getX();
        y1 = A.getY();

        x2 = B.getX();
        y2 = B.getY();

        x3 = C.getX();
        y3 = C.getY();


        if (y1 >= y2 && y2 >= y3) {
            shape = "A";
//			System.out.println("Shape: " + shape);

            if (y2 == y3 && y3 != y1) {
                //shape = "A1";
                aa = x3 - x2;
                bb = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
                cc = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            } else if (y2 == y1 && y3 != y1) {
                //shape = "A2";
                bb = x1 - x2;
                cc = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y3, 2));
                aa = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y2 - y3, 2));
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            } else if (y1 == y2 && y2 == y3) {

//				JOptionPane.showMessageDialog(null, filename+" pembaikan dilakukan");
                //shape = "linearA";
                //aa=-1;
                //bb=-1;
                //cc=-1;
//				System.out.println("A ditambah");
                if (y1 == y2) {
                    y1 = y1 + 1;
                    A.y = (int) y1;
                } else {
                    y2 = y2 + 1;
                    A.y = (int) y2;
                }


                p_cc = x1 - x2;
                p_aa = y1 - y2;

                cc = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));

                p_cc = x1 - x3;
                p_aa = y1 - y3;

                bb = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));

                p_cc = x3 - x2;
                p_aa = y2 - y3;

                aa = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);

            } else {

                p_cc = x1 - x2;
                p_aa = y1 - y2;

                cc = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));

                p_cc = x1 - x3;
                p_aa = y1 - y3;

                bb = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));

                p_cc = x3 - x2;
                p_aa = y2 - y3;

                aa = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            }
            perimeter = cc + aa + bb;
        } else if (y1 >= y3 && y2 <= y3) {
            shape = "B";
//			System.out.println(shape);

            if (y1 == y3) {
                //shape ="B1";
                cc = x1 - x3;
                bb = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
                aa = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            } else {
                //shape= "B2";
                p_cc = x1 - x3;

                p_aa = y1 - y3;
                bb = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                //System.out.println("bb :"+bb);
                p_cc = x1 - x2;
                p_aa = y1 - y2;

                cc = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                //System.out.println("cc :"+cc);
                p_cc = x3 - x2;
                p_aa = y3 - y2;

                aa = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                //System.out.println("Hai aa"+aa);
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
                if (aa == bb) {
                    sisi.clear();

                    /*
                     * Problem in triangle
                     *
                     */
                    x1 = x1 + 1;
                    y1 = y1 + 1;
                    A.x = (int) x1;
                    A.y = (int) y1;
                    p_cc = x1 - x3;

                    p_aa = y1 - y3;
                    bb = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                    //System.out.println("bb :"+bb);
                    p_cc = x1 - x2;
                    p_aa = y1 - y2;

                    cc = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                    //System.out.println("cc :"+cc);
                    p_cc = x3 - x2;
                    p_aa = y3 - y2;

                    aa = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
//					JOptionPane.showMessageDialog(null, filename+" normalized");
                    sisi.add(aa);
                    sisi.add(bb);
                    sisi.add(cc);
                }
            }
            perimeter = cc + aa + bb;
            //System.out.println(perimeter);
        } else if (y2 >= y1 && y2 <= y3)//satah bawah x1
        {
            shape = "C";
//			System.out.println(shape);

            if (y2 == y1) {
                //shape ="C1";
                bb = x1 - x2;

                cc = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y3 - y1, 2));

                aa = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            } else if (y2 == y3) {


                //shape = "C2";
//				System.out.println("c2");

                aa = x3 - x2;
                bb = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y2 - y1, 2));
                cc = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y3 - y1, 2));
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            } else {
                p_aa = y3 - y1;
                p_cc = x1 - x3;
                cc = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));

                p_cc = x3 - x2;
                p_aa = y3 - y2;

                aa = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));

                p_cc = x1 - x2;
                p_aa = y3 - y1;

                bb = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            }
            perimeter = cc + aa + bb;
        } else if (y3 >= y1 && y3 < y2) {

            double yy12 = y2 - y1;
            double xx12 = x1 - x2;
            double yy13 = y3 - y1;
            double xx13 = x1 - x3;
            double m1 = yy12 / xx12;
            double m2 = yy13 / xx13;
            //System.out.println("M : "+m1);
//			System.out.println("m1 :"+m1);
//			System.out.println("m2 :"+m2);

            shape = "D";
//			System.out.println(shape);

            if (y3 == y1) {
                //shape = "D1";
//				System.out.println("D1");
                cc = x1 - x3;
                bb = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y2 - y1, 2));
                aa = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y2 - y3, 2));
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            } else if ((m1 == m2)) {
                //shape ="lD";
                /*
                 * Problem in Triangle
                 */
                y3 = y3 + 1;
                C.y = (int) y3;

//				System.out.println("D2");
//				JOptionPane.showMessageDialog(null, filename+" ditambah baik");
                //aa= x1-x2;
                //cc=y2-y1;
                //bb=Math.sqrt(Math.pow(aa, 2)+Math.pow(cc, 2));

                p_cc = x1 - x2;
                p_aa = y2 - y1;
                bb = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                //System.out.println("cuba bb"+bb);
                p_cc = x3 - x2;
                p_aa = y2 - y3;

                aa = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                //System.out.println("cuba aa"+aa);

                p_cc = x1 - x3;
                p_aa = y3 - y1;

                cc = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                //System.out.println("cuba cc"+cc);
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            } else {
//				System.out.println("Dlain");
                p_cc = x1 - x2;
                p_aa = y2 - y1;
                bb = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                //System.out.println("cuba bb"+bb);
                p_cc = x3 - x2;
                p_aa = y2 - y3;

                aa = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                //System.out.println("cuba aa"+aa);

                p_cc = x1 - x3;
                p_aa = y3 - y1;

                cc = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                //System.out.println("cuba cc"+cc);
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            }
            perimeter = cc + aa + bb;
        } else if (y3 < y1 && y2 > y1) {
            shape = "E";
//			System.out.println(shape);

            p_aa = x1 - x2;
            p_cc = y2 - y1;
            bb = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));

            p_cc = y1 - y3;
            p_aa = x1 - x3;

            cc = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));

            p_cc = x3 - x2;
            p_aa = y2 - y3;

            aa = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
            sisi.add(aa);
            sisi.add(bb);
            sisi.add(cc);
            perimeter = cc + aa + bb;

        } else if (y2 < y1 && y3 > y1) {
            shape = "F";
//			System.out.println(shape);

            if (x2 == x3) {
//   			  System.out.println("F1");

                aa = y3 - y1;


                bb = Math.sqrt(Math.pow(y1 - y2, 2) + Math.pow(x1 - x2, 2));

                cc = Math.sqrt(Math.pow(y3 - y1, 2) + Math.pow(x1 - x3, 2));
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            }
//		  else if(y3-y1 ==1)
//		  {
//			  System.out.println("F2");
//			  shape = "not";
//			  aa = -1;
//			  bb = -1;
//			  cc = -1;
//		  }
            else {
//			 System.out.println("F3");
                p_aa = x1 - x3;
                p_cc = y3 - y1;
                cc = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));

                p_cc = x3 - x2;
                p_aa = y3 - y2;

                aa = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));

                p_cc = y1 - y2;
                p_aa = x1 - x2;

                bb = Math.sqrt(Math.pow(p_cc, 2) + Math.pow(p_aa, 2));
                sisi.add(aa);
                sisi.add(bb);
                sisi.add(cc);
            }
            perimeter = cc + aa + bb;


        } else {
//			System.out.println("Tidak tersenarai");
            JOptionPane.showMessageDialog(null, filename + " Not comply");
            shape = "-1";
            perimeter = -1;

        }
//		System.out.println("perimeter : "+perimeter);
        //return perimeter;
        return sisi;

    }

    public double getRatioCbyA() {
//		System.out.println("cc lah :"+cc);
        if (aa == 0)
            return 0;
        else
            return Double.parseDouble(df.format(cc / aa));

    }

    public double getRatioAbyB() {

        if (bb == 0) {
            return 0;
        } else {

            return Double.parseDouble(df.format(aa / bb));
        }
    }

    public double getRatioBbyC() {
        if (cc == 0)
            return 0;
        else
            return Double.parseDouble(df.format(bb / cc));
    }

    public double getGradientBA() {
        double graBA = 0;

        double dx = (A.x - B.x);
        if (dx == 0)
            graBA = 0;
        else
            graBA = (A.y - B.y) / dx;
        return Double.parseDouble(df.format(graBA));
    }

    public double getGradientCA() {

        double gradCA = 0;
        double dx = (A.x - C.x);
        if (dx == 0)
            gradCA = 0;
        else
            gradCA = (A.y - C.y) / dx;
        return Double.parseDouble(df.format(gradCA));
    }

    public double getGradientBC() {
        double gradBC = 0;
        double dx = (C.x - B.x);
        if (dx == 0)
            gradBC = 0;
        else
            gradBC = (C.y - B.y) / dx;
        return Double.parseDouble(df.format(gradBC));
    }


    public double getAngleC() {

        if (aa == 0 || bb == 0) {
            return 0;
        } else {
            double cos_C = (Math.pow(aa, 2) + Math.pow(bb, 2) - Math.pow(cc, 2)) / (2 * aa * bb);
            //System.out.println("Kos C :"+cos_C);
            //cos_C = -0.25;
            double cos_C_ = Double.parseDouble(df1.format(cos_C));
            angle_C_rad = Math.acos(cos_C_);
            if (angle_C_rad == 0) {
                angle_C = 0;
            } else {
                //System.out.println("rad C:"+angle_C_rad);
                angle_C = Math.toDegrees(angle_C_rad);

                //return Double.parseDouble(df.format(angle_C));
                //return angle_C;
            }
            return Double.parseDouble(df.format(angle_C)) / 180;
        }

    }


    public double getAngleB() {
//    	System.out.println("bb1 : "+bb);
//    	System.out.println("cc1 : "+cc);
//    	System.out.println("aa1 : "+aa);

        if (aa == 0 || cc == 0) {
            return 0;
        } else {
            double cos_B = (Math.pow(aa, 2) + Math.pow(cc, 2) - Math.pow(bb, 2)) / (2 * aa * cc);
//			System.out.println("Kos B :"+cos_B);
            //cos_C = -0.25;
            double cos_B_ = Double.parseDouble(df1.format(cos_B));
            angle_B_rad = Math.acos(cos_B_);
//			System.out.println("rad b:"+angle_B_rad);
            if (angle_B_rad == 0) {
                angle_B = 0;
            }
            {
                angle_B = Math.toDegrees(angle_B_rad);
//				System.out.println("Angle_B : "+angle_B);
                //return Double.parseDouble(df.format(angle_B));
                //return angle_B;
            }

            return Double.parseDouble(df.format(angle_B)) / 180;
            //return 180-angle_A-angle_C;
        }

    }

    public double getAngleA() {
        double sudutA = 0.0;
        //   	System.out.println("bb : "+bb);
        //   	System.out.println("cc : "+cc);
        //   	System.out.println("aa : "+aa);

        if (bb == 0 || cc == 0) {
            return 0;
        } else {
            try {
//	    		System.out.println("Hello");
                double cos_A = (Math.pow(bb, 2) + Math.pow(cc, 2) - Math.pow(aa, 2)) / (2 * bb * cc);
//				System.out.println("Kos A :"+cos_A);
                //cos_C = -0.25;
                double cos_A_ = Double.parseDouble(df1.format(cos_A));
//		    	System.out.println("Cos_A_ :"+cos_A_);
                angle_A_rad = Math.acos(cos_A_);


//					System.out.println("Haa Salah");

//				System.out.println("Rad A :" +angle_A_rad);
                //System.out.println("rad b:"+angle_A_rad);
                //angle_B = Math.toDegrees(angle_A_rad);
                angle_A = Math.toDegrees(angle_A_rad);
//		  	  	System.out.println("value A :"+angle_A );
                sudutA = Double.parseDouble(df.format(angle_A));
            } catch (java.lang.NumberFormatException ASD) {
                aa = 0;
                bb = 0;
                cc = 0;
                sudutA = 0;
            }

            return sudutA / 180;
        }
        //return angle_A;


    }


    //Tak berkaitan

    //public double calcPerimeter(Point a, Point b, Point c)
    public double calcPerimeter() {
        double perimeter = 0;

//   	  coordinate of point a, b and c
        x1 = A.getX();
        y1 = A.getY();

        x2 = B.getX();
        y2 = B.getY();

        x3 = C.getX();
        y3 = C.getY();


        if (y1 == y2 && x2 == x3) {
            //model 1
            //System.out.println("Model 1");
            cc = x1 - x2;//can apply theorem pitogorous
//	   		 System.out.println("a :"+cc);
            aa = y2 - y3;
//	   		 System.out.println("b :"+aa);
            bb = Math.sqrt(Math.pow(cc, 2) + Math.pow(aa, 2));
//	   		 System.out.println("c :"+bb);
            perimeter = cc + aa + bb;
            //telah dibuktikan betul untuk mendapatkan sudut.
        } else if (x2 == x3) {
            //model 2

            //System.out.println("Model 2");
            temp_x = x2;
            temp_y = y1;

            temp_ap = x1 - temp_x;
            temp_pb = y2 - temp_y;
            cc = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_pb, 2));

            temp_pc = temp_y - y3;
            bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_pc, 2));
//	   		  System.out.println("bb :"+bb);

            aa = y2 - y3;
//	   		  System.out.println("aa :"+aa);


            perimeter = cc + aa + bb;
            //telah dibuktikan betul untuk mendapatkan sudut.
//	   		 System.out.println("cc :"+cc);
        } else if (y1 == y2 && x2 < x3) {
            // System.out.println("Model 3");

            temp_x = x3;
            temp_y = y1;

            temp_ap = x1 - temp_x;
            temp_pc = temp_y - y3;
            bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_pc, 2));
//	   		  System.out.println("bb :"+bb);

            temp_pb = temp_x - x2;
            aa = Math.sqrt(Math.pow(temp_pc, 2) + Math.pow(temp_pb, 2));
//	   		  System.out.println("aa :"+aa);

            cc = x1 - x2;
//	   		  System.out.println("cc :"+cc);//betul
            //telah dibuktikan betul untuk mendapatkan sudut.
            perimeter = cc + aa + bb;

        } else if (y2 > y1 && x2 > x3) {
            //System.out.println("Model 4");

            temp_x = x1;
            temp_y = y2;

            temp_ap = temp_y - y1;
            temp_pb = temp_x - x2;

            cc = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_pb, 2));
//	   		  System.out.println("cc :"+cc);

            temp_x = x3;
            temp_y = y2;

            temp_pb = x2 - temp_x;
            temp_pc = y3 - temp_y;

            aa = Math.sqrt(Math.pow(temp_pb, 2) + Math.pow(temp_pc, 2));
//	   		  System.out.println("aa :"+aa);

            temp_x = x1;
            temp_y = y3;

            temp_ap = y1 - temp_y;
            temp_pc = temp_x - x3;

            bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_pc, 2));
//	   		  System.out.println("bb :"+bb);

            perimeter = cc + aa + bb;
        } else if (y2 > y1 && x2 < x3) {
            //System.out.println("Model 5");

            temp_x = x1;
            temp_y = y2;

            temp_ap = y2 - y1;
            temp_pb = x1 - x2;

            cc = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_pb, 2));
//	   		  System.out.println("cc :"+cc);

            temp_x = x2;
            temp_y = y3;

            temp_pb = y2 - y3;
            temp_pc = y3 - y1;

            aa = Math.sqrt(Math.pow(temp_pb, 2) + Math.pow(temp_pc, 2));
//	   		  System.out.println("aa :"+aa);

            temp_x = x1;
            temp_y = y3;

            temp_pc = x1 - x3;
            temp_ap = y1 - y3;

            bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_pc, 2));
//	   		  System.out.println("bb :"+bb);

            perimeter = aa + bb + cc;

        } else if (y1 > y2 && x2 > x3) {
            //telah dibuktikan menggunakan calculator
            // System.out.println("Model 6");

            temp_x = x2;
            temp_y = y1;

            temp_ap = x1 - temp_x;
            temp_pb = temp_y - y2;

            cc = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_pb, 2));
//	   		  System.out.println("cc :"+cc);

            temp_x = x3;
            temp_y = y1;

            temp_ap = x1 - temp_x;
            temp_pb = temp_y - y3;

            bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_pb, 2));
//	   		  System.out.println("bb :"+bb);

            temp_x = x3;
            temp_y = y2;

            temp_pc = temp_y - y3;
            //System.out.println("temp_pc :"+temp_pc);
            temp_pb = x2 - temp_x;
            // System.out.println("temp_pb :"+temp_pb);

            aa = Math.sqrt(Math.pow(temp_pc, 2) + Math.pow(temp_pb, 2));
//	   		  System.out.println("aa :"+aa);

            perimeter = aa + bb + cc;

        } else if (y1 > y2 && x2 < x3) {
            // System.out.println("Model 7");

            temp_x = x2;
            temp_y = y1;

            temp_ap = x1 - temp_x;
            temp_pb = temp_y - y2;

            if (x2 == x3) {
//	   			  System.out.println("g");

                aa = y3 - y1;


                bb = Math.sqrt(Math.pow(y1 - y2, 2) + Math.pow(x1 - x2, 2));

                cc = Math.sqrt(Math.pow(y3 - y1, 2) + Math.pow(x1 - x3, 2));
            } else {
//	   			  System.out.println("h");
                cc = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_pb, 2));
                //	   		  System.out.println("cc :"+cc);

                temp_x = x2;
                temp_y = y3;

                temp_pb = y2 - temp_y;
                temp_pc = x3 - temp_x;
                //dibuktikan dgn kalkulator. tp bgmn pula jika x2=x3
                aa = Math.sqrt(Math.pow(temp_pb, 2) + Math.pow(temp_pc, 2));
                //	   		  System.out.println("aa :"+aa);

                temp_x = x1;
                temp_y = y3;

                temp_ap = y1 - temp_y;
                temp_pc = temp_x - x3;

                bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_pc, 2));
                //	   		  System.out.println("bb :"+bb);
            }
            perimeter = aa + bb + cc;
        } else {

            //System.out.println("Tidak tersenarai");
            perimeter = -1;
        }

        return perimeter;

    }

    public double get_a() {


        return Double.parseDouble(df.format(aa));
    }

    public double get_b() {
        return Double.parseDouble(df.format(bb));
    }

    public double get_c() {
        return Double.parseDouble(df.format(cc));
    }

    public String getShape() {
        return shape;
    }

    //to get angle from A to based line
    public double getAngleFromA() {

        double based_angle = 0;

        x1 = A.getX();
        y1 = A.getY();

        x2 = B.getX();
        y2 = B.getY();

        if (y1 > y2) {

            temp_x = x2;
            temp_y = y1;

            temp_ap = x1 - temp_x;
            temp_pb = temp_y - y2;

            //temp_pc = Math.sqrt((Math.pow(temp_ap, 2)+Math.pow(temp_pb,2)));

            based_angle = Math.atan(temp_pb / temp_ap);
            based_angle = Math.toDegrees(based_angle);


        } else if (y1 < y2) {
            temp_x = x2;
            temp_y = y1;

            temp_ap = x1 - temp_x;
            temp_pb = y2 - temp_y;

            based_angle = Math.atan(temp_pb / temp_ap);
            based_angle = Math.toDegrees(based_angle);
            Double doub = new Double(based_angle);
//			  String temp_value = "-"+doub.toString();
            String temp_value = doub.toString();

            based_angle = Double.parseDouble(temp_value);


        } else {
            based_angle = -1;

        }

        return Double.parseDouble(df.format(based_angle));

    }

    /**
     * calculating Perimeter from the given length of a, b and c
     *
     * @return parameter
     */
    public double calcPerimeter1() {
        // double p = 0;
        return (aa + bb + cc);
    }

    /**
     * calculating semi-perimeter from the given length of a, b and c
     *
     * @return semi-perimeter
     */
    public double calcSemiPerimeter() {
        //   double p = 0;
        return (aa + bb + cc) / 2;
    }

    /**
     * calculating semi-perimeter from the given perimeter value
     *
     * @return semi-perimeter
     */
    public double calcSemiPerimeter(double perimeter) {
        return (perimeter / 2);
    }

    /**
     * Calculating area from given length of a and b and angle of C
     *
     * @return area
     */
    public double calcArea() {
        double temp_sinC = Math.sin(angle_C * Math.PI / 180);
        //DecimalFormat df = new DecimalFormat("#.##");
        double K = aa * bb * temp_sinC / 2;

        return (Double.parseDouble(df.format(K)));
    }

    /**
     * Calculating area from the given of base and height <kena fikirkan samada segitiga 90darjah>
     *
     * @return area
     */
    public static double calcArea(double base, double height) {
        return (base * height / 2);
    }

    /**
     * Calculating angle of bisector of a from the given angle of A in degree and length of b and c
     *
     * @return angle of bisector of a
     */
    public double calcBisectorOf_a() {
        double ta = 0;
        ta = 2 * bb * cc * (Math.cos(angle_A * Math.PI / 180 / 2)) / (bb + cc);
        return (Double.parseDouble(df.format(ta)));
    }

    /**
     * Calculating angle of bisector of b from given angle of B in degree and length of a and c
     *
     * @return angle of biseftor of b
     */
    public double calcBisectorOf_b() {
        double tb = 0;
        tb = 2 * aa * cc * (Math.cos(angle_B * Math.PI / 180 / 2)) / (aa + cc);
        return (Double.parseDouble(df.format(tb)));
    }

    /**
     * Calculating angle of c from given angle C and length of a and b
     *
     * @return angle of bisector of b
     */
    public double calcBisectorOf_c() {
        double tc = 0;
        tc = 2 * aa * bb * (Math.cos(angle_C * Math.PI / 180 / 2)) / (aa + bb);
        return (Double.parseDouble(df.format(tc)));
    }

    /**
     * Calculating median of side a from the given length of a, b and c
     *
     * @return median of side a
     */
    public double calcMedianOfSide_a() {
        double ma = 0;
        ma = Math.sqrt((2 * Math.pow(bb, 2) + 2 * Math.pow(cc, 2) - Math.pow(aa, 2))) / 2;
        return (Double.parseDouble(df.format(ma)));
    }

    /**
     * Calculating MedianOfSide_b from the given length of a, b and c
     *
     * @return median of side b
     */
    public double calcMedianOfSide_b() {
        double md = 0;
        md = Math.sqrt((2 * Math.pow(aa, 2) + 2 * Math.pow(cc, 2) - Math.pow(bb, 2))) / 2;
        return (Double.parseDouble(df.format(md)));
    }

    /**
     * Calculating MedianOfSide_c from the given length of a, b and c
     *
     * @return median of side c
     */
    public double calcMedianOfSide_c() {
        double mc = 0;
        mc = Math.sqrt((2 * Math.pow(aa, 2) + 2 * Math.pow(bb, 2) - Math.pow(cc, 2))) / 2;
        return (Double.parseDouble(df.format(mc)));
    }

    /**
     * Calculating Altitude of side a from the given angle of B and length of c
     *
     * @return Altitude of side a
     */
    public double calcAltitudeOfSide_a() {
        double ha = cc * Math.sin(angle_B * Math.PI / 180);
        return (Double.parseDouble(df.format(ha)));
    }

    /**
     * Calculating Altitude of side b from the given angle of C and length of a
     *
     * @return Altitude of side b
     */
    public double calcAltitudeOfSide_b() {
        double hb = aa * Math.sin(angle_C * Math.PI / 180);
        return (Double.parseDouble(df.format(hb)));
    }


    /**
     * Calculating Altitude of side c from the given angle of B and length of a
     *
     * @return Altitude of side c
     */
    public double calcAltitudeOfSide_c() {
        double hc = aa * Math.sin(angle_B * Math.PI / 180);
        return (Double.parseDouble(df.format(hc)));
    }

    /**
     * Calculating Circumscribed Circle Radius from the given angle of A and length of a
     *
     * @return Circumscribed Circle Radius
     */
    public double calcCircumscribedCircleRadius() {
        double ccr = aa / (2 * Math.sin(angle_A * Math.PI / 180));
        return (Double.parseDouble(df.format(ccr)));
    }

    /**
     * Calculating Inscribed Circle Radius from the given length of c and angles of A, B and C
     * return Inscribed Circle Radius
     */
    public double calcInscribedCircleRadius() {
        double icr = cc * (Math.sin(angle_A * Math.PI / 180 / 2) * Math.sin(angle_B * Math.PI / 180 / 2)) / Math.cos(angle_C * Math.PI / 180 / 2);
        return (Double.parseDouble(df.format(icr)));
    }


    /**
     * ratio median side a / median side b
     *
     * @param args
     */
    public double getMOAbyMOB() {

        return Double.parseDouble(df.format((calcMedianOfSide_a() / calcMedianOfSide_b())));
    }

    public double getMOBbyMOC() {
        return Double.parseDouble(df.format((calcMedianOfSide_b() / calcMedianOfSide_c())));
    }

    public double getMOCbyMOA() {
        return Double.parseDouble(df.format((calcMedianOfSide_c() / calcMedianOfSide_a())));
    }

    public double getAOAbyAOB() {
        return Double.parseDouble(df.format((calcAltitudeOfSide_a() / calcAltitudeOfSide_b())));
    }

    public double getAOBbyAOC() {
        return Double.parseDouble(df.format((calcAltitudeOfSide_b() / calcAltitudeOfSide_c())));
    }

    public double getAOCbyAOA() {
        return Double.parseDouble(df.format((calcAltitudeOfSide_c() / calcAltitudeOfSide_a())));
    }

    public double getBOAbyBOB() {
        return Double.parseDouble(df.format((calcBisectorOf_a() / calcBisectorOf_b())));
    }

    public double getBOBbyBOC() {
        return Double.parseDouble(df.format((calcBisectorOf_b() / calcBisectorOf_c())));
    }

    public double getBOCbyBOA() {
        return Double.parseDouble(df.format((calcBisectorOf_c() / calcBisectorOf_a())));
    }


    public static void main(String[] args) {

//    	  Point p1 = new Point(12,9);
//    	  Point p2 = new Point(6,13);
//    	  Point p3 = new Point(9,11);
//    	  Point p1 = new Point(12,9);
//    	  Point p2 = new Point(9,11);
//    	  Point p3 = new Point(6,3);
//


//    	  //Model 1
//    	  Point p1 = new Point(10,8);
//    	  Point p2 = new Point(7,8);
//    	  Point p3 = new Point(7,4);

        //Model 2
//    	  Point p1 = new Point(10,8);
//    	  Point p2 = new Point(7,12);
//    	  Point p3 = new Point(7,6);

        //Model 3
        Point p1 = new Point(10, 8);
        Point p2 = new Point(4, 8);
        Point p3 = new Point(6, 4);

        //Model 4
//    	  Point p1 = new Point(10,4);
//    	  Point p2 = new Point(7,8);
//    	  Point p3 = new Point(5,2);
        MyScalene m = new MyScalene(p1, p2, p3);


        // m.calcPerimeter();
        m.getTrianglePerimeter();
//    	  System.out.println(m.aa);
//   	  System.out.println(m.bb);
//    	  System.out.println(m.cc);

//    	  System.out.println("C : "+m.getAngleC());

//   	  System.out.println("B : "+m.getAngleB());
//    	  System.out.println("A : "+m.getAngleA());


//
//    	  System.out.println("Cuba ");
//    	  MyScalene m1 = new MyScalene(6, 2, 4);
//    	  System.out.println("Angle C :"+m1.getAngleC());
//    	  System.out.println("Angle A :"+m1.getAngleA());
//    	  System.out.println("Angle B :"+m1.getAngleB());


    }


}
