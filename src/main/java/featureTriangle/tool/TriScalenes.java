/**
 * The triangle consists of three important points as follow.
 * i. Point A as point 1 which is located on the right
 * ii. Point B as point 2 which is located on the left
 * iii. Point C as point 3 which is the centroid point.
 * <p>
 * 27/9/2015 10:47 PM.
 */

package featureTriangle.tool;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class TriScalenes {

    String filename;
    String shape = "";

    DecimalFormat df = new DecimalFormat("#.###");
    DecimalFormat df1 = new DecimalFormat("#.#########");

    BufferedImage images = null;

    private Point A;
    private Point B;
    private Point C;

    double xA = 0, yA = 0;        //default coordinate point A
    double xB = 0, yB = 0;        //default coordinate point B
    double xC = 0, yC = 0;        //default coordinate point C

    double aa = 0;                //length of b (from point a to b)
    double bb = 0;                //length of c (from point b to c)
    double cc = 0;                //length of a (from point c to a)

    double angle_A = 0.0;
    double angle_B = 0.0;
    double angle_C = 0.0;

    double angle_A_rad = 0.0;
    double angle_B_rad = 0.0;
    double angle_C_rad = 0.0;

    //For temporary coordinate or point.
    //This coordinate is used to get the length of triangle.
    //It makes theorem hipogorous ? or pythagoras triangle.
    double temp_x;
    double temp_y;

    //Length from point to temporary point and vice versa
    double temp_ap = 0;             //length from a to b
    double temp_bp = 0;             //length from b to c
    double temp_cp = 0;                //length from c to a

    public TriScalenes() {
    }

    public TriScalenes(int aa, int bb, int cc) {
        this.aa = aa;
        this.bb = bb;
        this.cc = cc;
    }

    public TriScalenes(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    public TriScalenes(ArrayList<Point> points) {
        A = points.get(0);  //Right
        B = points.get(1);  //Left
        C = points.get(2);  //Centroid
    }

    public TriScalenes(String filename, ArrayList<Point> points) {
        this.filename = filename;
        A = points.get(0);   //right
        B = points.get(1);   //left
        C = points.get(2);   //centroid
    }

    public String getFileName() {
        return filename;
    }

    public TriScalenes(BufferedImage img) {
        this.images = img;
    }

    public ArrayList<Double> getTrianglePerimeter(String database_table, String typeDataset, BufferedImage image, String type, String typeFile) {
        ArrayList<Double> edge = new ArrayList<Double>();

        double perimeter = 0;
        double peri_aa = 0;      //perimeter aa
        double peri_cc = 0;      //perimeter cc

        xA = A.getX();
        yA = A.getY();

        xB = B.getX();
        yB = B.getY();

        xC = C.getX();
        yC = C.getY();


        if (yA >= yB && yB >= yC) {
            if (yB == yC && yC != yA) {
                //shape = "A1";
                aa = xC - xB;
                bb = Math.sqrt(Math.pow(xA - xC, 2) + Math.pow(yA - yC, 2));
                cc = Math.sqrt(Math.pow(xA - xB, 2) + Math.pow(yA - yB, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            } else if (yB == yA && yC != yA) {
                //shape = "A2";
                bb = xA - xB;
                cc = Math.sqrt(Math.pow(xA - xB, 2) + Math.pow(yA - yC, 2));
                aa = Math.sqrt(Math.pow(xC - xB, 2) + Math.pow(yB - yC, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            } else if (yA == yB && yB == yC) {
                //Question: Is this for shape A3 ?

                //Case 1
                if (yA == yB) {
                    int result = SolveStraightLine.solveTriStraightLine(typeFile, typeDataset, image, filename, type, "A");
                    yA = yA + result;
                    A.y = (int) yA;
                } else {
                    int result = SolveStraightLine.solveTriStraightLine(typeFile, typeDataset, image, filename, type, "A");
                    yB = yB + result;
                    A.y = (int) yB;
                }

                peri_cc = xA - xB;
                peri_aa = yA - yB;

                cc = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xA - xC;
                peri_aa = yA - yC;

                bb = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xC - xB;
                peri_aa = yB - yC;

                aa = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            } else {
                //Question: Is this for shape A4 ?

                peri_cc = xA - xB;
                peri_aa = yA - yB;

                cc = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xA - xC;
                peri_aa = yA - yC;

                bb = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xC - xB;
                peri_aa = yB - yC;

                aa = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            }
            perimeter = cc + aa + bb;
        } else if (yA >= yC && yB <= yC) {
            if (yA == yC) {
                //shape ="B1";
                cc = xA - xC;
                bb = Math.sqrt(Math.pow(xA - xB, 2) + Math.pow(yA - yB, 2));
                aa = Math.sqrt(Math.pow(xC - xB, 2) + Math.pow(yC - yB, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            } else {
                //shape= "B2";
                peri_cc = xA - xC;
                peri_aa = yA - yC;

                bb = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xA - xB;
                peri_aa = yA - yB;

                cc = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xC - xB;
                peri_aa = yC - yB;

                aa = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);

                if (aa == bb) {
                    edge.clear();

                    //Case 2 *Problem in triangle
                    int result = SolveStraightLine.solveTriStraightLine(typeFile, typeDataset, image, filename, type, "A");
                    xA = xA + result;
                    yA = yA + result;

                    A.x = (int) xA;
                    A.y = (int) yA;

                    peri_cc = xA - xC;
                    peri_aa = yA - yC;

                    bb = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                    peri_cc = xA - xB;
                    peri_aa = yA - yB;

                    cc = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                    peri_cc = xC - xB;
                    peri_aa = yC - yB;

                    aa = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                    edge.add(aa);
                    edge.add(bb);
                    edge.add(cc);
                }
            }
            perimeter = cc + aa + bb;
        } else if (yB >= yA && yB <= yC)//satah bawah x1
        {
            if (yB == yA) {
                //shape ="C1";
                bb = xA - xB;

                cc = Math.sqrt(Math.pow(xA - xC, 2) + Math.pow(yC - yA, 2));
                aa = Math.sqrt(Math.pow(xC - xB, 2) + Math.pow(yC - yB, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            } else if (yB == yC) {
                //shape = "C2";
                aa = xC - xB;

                bb = Math.sqrt(Math.pow(xA - xB, 2) + Math.pow(yB - yA, 2));
                cc = Math.sqrt(Math.pow(xA - xC, 2) + Math.pow(yC - yA, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            } else {
                //shape = "C3";
                peri_aa = yC - yA;
                peri_cc = xA - xC;

                cc = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xC - xB;
                peri_aa = yC - yB;

                aa = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xA - xB;
                peri_aa = yC - yA;

                bb = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            }
            perimeter = cc + aa + bb;
        } else if (yC >= yA && yC < yB) {

            double yy12 = yB - yA;
            double xx12 = xA - xB;
            double yy13 = yC - yA;
            double xx13 = xA - xC;
            double m1 = yy12 / xx12;
            double m2 = yy13 / xx13;

            if (yC == yA) {
                //shape = "D1";
                cc = xA - xC;

                bb = Math.sqrt(Math.pow(xA - xB, 2) + Math.pow(yB - yA, 2));
                aa = Math.sqrt(Math.pow(xC - xB, 2) + Math.pow(yB - yC, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            } else if ((m1 == m2)) {
                //shape ="D2";
                //Case 3 *Problem in triangle
                int result = SolveStraightLine.solveTriStraightLine(typeFile, typeDataset, image, filename, type, "C");

                yC = yC + result;
                C.y = (int) yC;

                peri_cc = xA - xB;
                peri_aa = yB - yA;

                bb = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xC - xB;
                peri_aa = yB - yC;

                aa = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xA - xC;
                peri_aa = yC - yA;

                cc = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            } else {
                //shape ="D3";
                peri_cc = xA - xB;
                peri_aa = yB - yA;

                bb = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xC - xB;
                peri_aa = yB - yC;

                aa = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xA - xC;
                peri_aa = yC - yA;

                cc = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            }
            perimeter = cc + aa + bb;
        } else if (yC < yA && yB > yA) {
            //shape ="E1";
            peri_aa = xA - xB;
            peri_cc = yB - yA;

            bb = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

            peri_cc = yA - yC;
            peri_aa = xA - xC;

            cc = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

            peri_cc = xC - xB;
            peri_aa = yB - yC;

            aa = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

            edge.add(aa);
            edge.add(bb);
            edge.add(cc);

            perimeter = cc + aa + bb;
        } else if (yB < yA && yC > yA) {
            if (xB == xC) {
                //shape ="F1";
                aa = yC - yA;

                bb = Math.sqrt(Math.pow(yA - yB, 2) + Math.pow(xA - xB, 2));
                cc = Math.sqrt(Math.pow(yC - yA, 2) + Math.pow(xA - xC, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            } else {
                //shape ="F2";
                peri_aa = xA - xC;
                peri_cc = yC - yA;

                cc = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = xC - xB;
                peri_aa = yC - yB;

                aa = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                peri_cc = yA - yB;
                peri_aa = xA - xB;

                bb = Math.sqrt(Math.pow(peri_cc, 2) + Math.pow(peri_aa, 2));

                edge.add(aa);
                edge.add(bb);
                edge.add(cc);
            }
            perimeter = cc + aa + bb;
        } else {
//			System.out.println("Tidak tersenarai");
            JOptionPane.showMessageDialog(null, filename + " Not comply");
            shape = "-1";
            perimeter = -1;

        }

		/*if (edge.get(0) < 0) {
			edge.add(-(edge.get(0)));
		}

		if (edge.get(1) < 0) {
			edge.add(-(edge.get(1)));
		}

		if (edge.get(2) < 0) {
			edge.add(-(edge.get(2)));
		}*/

        return edge;
    }

    public double getRatioCbyA() {
        if (aa == 0)
            return 0;
        else
            return Double.parseDouble(df.format(cc / aa));
    }

    public double getRatioAbyB() {
        if (bb == 0)
            return 0;
        else
            return Double.parseDouble(df.format(aa / bb));
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
            double cos_C_ = Double.parseDouble(df1.format(cos_C));

            angle_C_rad = Math.acos(cos_C_);

            if (angle_C_rad == 0) {
                angle_C = 0;
            } else {
                angle_C = Math.toDegrees(angle_C_rad);
            }
            return Double.parseDouble(df.format(angle_C)) / 180;
        }
    }

    public double getAngleB() {
        if (aa == 0 || cc == 0) {
            return 0;
        } else {
            double cos_B = (Math.pow(aa, 2) + Math.pow(cc, 2) - Math.pow(bb, 2)) / (2 * aa * cc);
            double cos_B_ = Double.parseDouble(df1.format(cos_B));

            angle_B_rad = Math.acos(cos_B_);

            if (angle_B_rad == 0) {
                angle_B = 0;
            } else {
                angle_B = Math.toDegrees(angle_B_rad);
            }

            return Double.parseDouble(df.format(angle_B)) / 180;
        }
    }

    public double getAngleA() {
        double sudutA = 0.0;

        if (bb == 0 || cc == 0) {
            return 0;
        } else {
            try {

                double cos_A = (Math.pow(bb, 2) + Math.pow(cc, 2) - Math.pow(aa, 2)) / (2 * bb * cc);
                double cos_A_ = Double.parseDouble(df1.format(cos_A));

                angle_A_rad = Math.acos(cos_A_);
                angle_A = Math.toDegrees(angle_A_rad);

                sudutA = Double.parseDouble(df.format(angle_A));
            } catch (java.lang.NumberFormatException ASD) {
                aa = 0;
                bb = 0;
                cc = 0;
                sudutA = 0;
            }

            return sudutA / 180;
        }
    }

    /*==========================================================================================================================*/

    //Tak berkaitan

    //public double calcPerimeter(Point a, Point b, Point c)
    public double calcPerimeter() {
        double perimeter = 0;

//   	  coordinate of point a, b and c
        xA = A.getX();
        yA = A.getY();

        xB = B.getX();
        yB = B.getY();

        xC = C.getX();
        yC = C.getY();


        if (yA == yB && xB == xC) {
            //model 1
            //System.out.println("Model 1");
            cc = xA - xB;//can apply theorem pitogorous
//	   		 System.out.println("a :"+cc);
            aa = yB - yC;
//	   		 System.out.println("b :"+aa);
            bb = Math.sqrt(Math.pow(cc, 2) + Math.pow(aa, 2));
//	   		 System.out.println("c :"+bb);
            perimeter = cc + aa + bb;
            //telah dibuktikan betul untuk mendapatkan sudut.
        } else if (xB == xC) {
            //model 2

            //System.out.println("Model 2");
            temp_x = xB;
            temp_y = yA;

            temp_ap = xA - temp_x;
            temp_bp = yB - temp_y;
            cc = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_bp, 2));

            temp_cp = temp_y - yC;
            bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_cp, 2));
//	   		  System.out.println("bb :"+bb);

            aa = yB - yC;
//	   		  System.out.println("aa :"+aa);


            perimeter = cc + aa + bb;
            //telah dibuktikan betul untuk mendapatkan sudut.
//	   		 System.out.println("cc :"+cc);
        } else if (yA == yB && xB < xC) {
            // System.out.println("Model 3");

            temp_x = xC;
            temp_y = yA;

            temp_ap = xA - temp_x;
            temp_cp = temp_y - yC;
            bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_cp, 2));
//	   		  System.out.println("bb :"+bb);

            temp_bp = temp_x - xB;
            aa = Math.sqrt(Math.pow(temp_cp, 2) + Math.pow(temp_bp, 2));
//	   		  System.out.println("aa :"+aa);

            cc = xA - xB;
//	   		  System.out.println("cc :"+cc);//betul
            //telah dibuktikan betul untuk mendapatkan sudut.
            perimeter = cc + aa + bb;

        } else if (yB > yA && xB > xC) {
            //System.out.println("Model 4");

            temp_x = xA;
            temp_y = yB;

            temp_ap = temp_y - yA;
            temp_bp = temp_x - xB;

            cc = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_bp, 2));
//	   		  System.out.println("cc :"+cc);

            temp_x = xC;
            temp_y = yB;

            temp_bp = xB - temp_x;
            temp_cp = yC - temp_y;

            aa = Math.sqrt(Math.pow(temp_bp, 2) + Math.pow(temp_cp, 2));
//	   		  System.out.println("aa :"+aa);

            temp_x = xA;
            temp_y = yC;

            temp_ap = yA - temp_y;
            temp_cp = temp_x - xC;

            bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_cp, 2));
//	   		  System.out.println("bb :"+bb);

            perimeter = cc + aa + bb;
        } else if (yB > yA && xB < xC) {
            //System.out.println("Model 5");

            temp_x = xA;
            temp_y = yB;

            temp_ap = yB - yA;
            temp_bp = xA - xB;

            cc = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_bp, 2));
//	   		  System.out.println("cc :"+cc);

            temp_x = xB;
            temp_y = yC;

            temp_bp = yB - yC;
            temp_cp = yC - yA;

            aa = Math.sqrt(Math.pow(temp_bp, 2) + Math.pow(temp_cp, 2));
//	   		  System.out.println("aa :"+aa);

            temp_x = xA;
            temp_y = yC;

            temp_cp = xA - xC;
            temp_ap = yA - yC;

            bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_cp, 2));
//	   		  System.out.println("bb :"+bb);

            perimeter = aa + bb + cc;

        } else if (yA > yB && xB > xC) {
            //telah dibuktikan menggunakan calculator
            // System.out.println("Model 6");

            temp_x = xB;
            temp_y = yA;

            temp_ap = xA - temp_x;
            temp_bp = temp_y - yB;

            cc = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_bp, 2));
//	   		  System.out.println("cc :"+cc);

            temp_x = xC;
            temp_y = yA;

            temp_ap = xA - temp_x;
            temp_bp = temp_y - yC;

            bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_bp, 2));
//	   		  System.out.println("bb :"+bb);

            temp_x = xC;
            temp_y = yB;

            temp_cp = temp_y - yC;
            //System.out.println("temp_pc :"+temp_pc);
            temp_bp = xB - temp_x;
            // System.out.println("temp_pb :"+temp_pb);

            aa = Math.sqrt(Math.pow(temp_cp, 2) + Math.pow(temp_bp, 2));
//	   		  System.out.println("aa :"+aa);

            perimeter = aa + bb + cc;

        } else if (yA > yB && xB < xC) {
            // System.out.println("Model 7");

            temp_x = xB;
            temp_y = yA;

            temp_ap = xA - temp_x;
            temp_bp = temp_y - yB;

            if (xB == xC) {
//	   			  System.out.println("g");

                aa = yC - yA;


                bb = Math.sqrt(Math.pow(yA - yB, 2) + Math.pow(xA - xB, 2));

                cc = Math.sqrt(Math.pow(yC - yA, 2) + Math.pow(xA - xC, 2));
            } else {
//	   			  System.out.println("h");
                cc = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_bp, 2));
                //	   		  System.out.println("cc :"+cc);

                temp_x = xB;
                temp_y = yC;

                temp_bp = yB - temp_y;
                temp_cp = xC - temp_x;
                //dibuktikan dgn kalkulator. tp bgmn pula jika x2=x3
                aa = Math.sqrt(Math.pow(temp_bp, 2) + Math.pow(temp_cp, 2));
                //	   		  System.out.println("aa :"+aa);

                temp_x = xA;
                temp_y = yC;

                temp_ap = yA - temp_y;
                temp_cp = temp_x - xC;

                bb = Math.sqrt(Math.pow(temp_ap, 2) + Math.pow(temp_cp, 2));
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

        xA = A.getX();
        yA = A.getY();

        xB = B.getX();
        yB = B.getY();

        if (yA > yB) {

            temp_x = xB;
            temp_y = yA;

            temp_ap = xA - temp_x;
            temp_bp = temp_y - yB;

            //temp_pc = Math.sqrt((Math.pow(temp_ap, 2)+Math.pow(temp_pb,2)));

            based_angle = Math.atan(temp_bp / temp_ap);
            based_angle = Math.toDegrees(based_angle);


        } else if (yA < yB) {
            temp_x = xB;
            temp_y = yA;

            temp_ap = xA - temp_x;
            temp_bp = yB - temp_y;

            based_angle = Math.atan(temp_bp / temp_ap);
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
     calculating Perimeter from the given length of a, b and c
     @return parameter
     */
    public double calcPerimeter1() {
        // double p = 0;
        return (aa + bb + cc);
    }

    /**
     calculating semi-perimeter from the given length of a, b and c
     @return semi-perimeter
     */
    public double calcSemiPerimeter() {
        //   double p = 0;
        return (aa + bb + cc) / 2;
    }

    /**
     calculating semi-perimeter from the given perimeter value
     @return semi-perimeter
     */
    public double calcSemiPerimeter(double perimeter) {
        return (perimeter / 2);
    }

    /**
     Calculating area from given length of a and b and angle of C
     @return area
     */
    public double calcArea() {
        double temp_sinC = Math.sin(angle_C * Math.PI / 180);
        //DecimalFormat df = new DecimalFormat("#.##");
        double K = aa * bb * temp_sinC / 2;

        return (Double.parseDouble(df.format(K)));
    }

    /**
     Calculating area from the given of base and height <kena fikirkan samada segitiga 90darjah>
     @return area
     */
    public static double calcArea(double base, double height) {
        return (base * height / 2);
    }

    /**
     Calculating angle of bisector of a from the given angle of A in degree and length of b and c
     @return angle of bisector of a
     */
    public double calcBisectorOf_a() {
        double ta = 0;
        ta = 2 * bb * cc * (Math.cos(angle_A * Math.PI / 180 / 2)) / (bb + cc);
        return (Double.parseDouble(df.format(ta)));
    }

    /**
     Calculating angle of bisector of b from given angle of B in degree and length of a and c
     @return angle of biseftor of b
     */
    public double calcBisectorOf_b() {
        double tb = 0;
        tb = 2 * aa * cc * (Math.cos(angle_B * Math.PI / 180 / 2)) / (aa + cc);
        return (Double.parseDouble(df.format(tb)));
    }

    /**
     Calculating angle of c from given angle C and length of a and b
     @return angle of bisector of b
     */
    public double calcBisectorOf_c() {
        double tc = 0;
        tc = 2 * aa * bb * (Math.cos(angle_C * Math.PI / 180 / 2)) / (aa + bb);
        return (Double.parseDouble(df.format(tc)));
    }

    /**
     Calculating median of side a from the given length of a, b and c
     @return median of side a
     */
    public double calcMedianOfSide_a() {
        double ma = 0;
        ma = Math.sqrt((2 * Math.pow(bb, 2) + 2 * Math.pow(cc, 2) - Math.pow(aa, 2))) / 2;
        return (Double.parseDouble(df.format(ma)));
    }

    /**
     Calculating MedianOfSide_b from the given length of a, b and c
     @return median of side b
     */
    public double calcMedianOfSide_b() {
        double md = 0;
        md = Math.sqrt((2 * Math.pow(aa, 2) + 2 * Math.pow(cc, 2) - Math.pow(bb, 2))) / 2;
        return (Double.parseDouble(df.format(md)));
    }

    /**
     Calculating MedianOfSide_c from the given length of a, b and c
     @return median of side c
     */
    public double calcMedianOfSide_c() {
        double mc = 0;
        mc = Math.sqrt((2 * Math.pow(aa, 2) + 2 * Math.pow(bb, 2) - Math.pow(cc, 2))) / 2;
        return (Double.parseDouble(df.format(mc)));
    }

    /**
     Calculating Altitude of side a from the given angle of B and length of c
     @return Altitude of side a
     */
    public double calcAltitudeOfSide_a() {
        double ha = cc * Math.sin(angle_B * Math.PI / 180);
        return (Double.parseDouble(df.format(ha)));
    }

    /**
     Calculating Altitude of side b from the given angle of C and length of a
     @return Altitude of side b
     */
    public double calcAltitudeOfSide_b() {
        double hb = aa * Math.sin(angle_C * Math.PI / 180);
        return (Double.parseDouble(df.format(hb)));
    }


    /**
     Calculating Altitude of side c from the given angle of B and length of a
     @return Altitude of side c
     */
    public double calcAltitudeOfSide_c() {
        double hc = aa * Math.sin(angle_B * Math.PI / 180);
        return (Double.parseDouble(df.format(hc)));
    }

    /**
     Calculating Circumscribed Circle Radius from the given angle of A and length of a
     @return Circumscribed Circle Radius
     */
    public double calcCircumscribedCircleRadius() {
        double ccr = aa / (2 * Math.sin(angle_A * Math.PI / 180));
        return (Double.parseDouble(df.format(ccr)));
    }

    /**
     Calculating Inscribed Circle Radius from the given length of c and angles of A, B and C
     return Inscribed Circle Radius
     */
    public double calcInscribedCircleRadius() {
        double icr = cc * (Math.sin(angle_A * Math.PI / 180 / 2) * Math.sin(angle_B * Math.PI / 180 / 2)) / Math.cos(angle_C * Math.PI / 180 / 2);
        return (Double.parseDouble(df.format(icr)));
    }


    /**
     * ratio median side a / median side b
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
        TriScalenes m = new TriScalenes(p1, p2, p3);


        // m.calcPerimeter();
        //m.getTrianglePerimeter();
//    	  System.out.println(m.aa);
//    	  System.out.println(m.bb);
//    	  System.out.println(m.cc);

//    	  System.out.println("C : "+m.getAngleC());

//    	  System.out.println("B : "+m.getAngleB());
//    	  System.out.println("A : "+m.getAngleA());


//
//    	  System.out.println("Cuba ");
//    	  MyScalene m1 = new MyScalene(6, 2, 4);
//    	  System.out.println("Angle C :"+m1.getAngleC());
//    	  System.out.println("Angle A :"+m1.getAngleA());
//    	  System.out.println("Angle B :"+m1.getAngleB());


    }
}
