package model;

import java.awt.*;

public class Bean_Triangle_Descriptor {
    Point pointA; //point[0] (right)
    Point pointB; //point[1] (left)
    Point pointC; //point[2] (centroid)


    int count_main; //main triangle
    int count_left; //1|0
    int count_right;


    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public int getCount_main() {
        return count_main;
    }

    public void setCount_main(int count_main) {
        this.count_main = count_main;
    }

    public int getCount_left() {
        return count_left;
    }

    public void setCount_left(int count_left) {
        this.count_left = count_left;
    }

    public int getCount_right() {
        return count_right;
    }

    public void setCount_right(int count_right) {
        this.count_right = count_right;
    }


}
