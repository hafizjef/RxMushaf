/**
 * Created by Nur Atikah binti Arbain.
 * Completed on 29.09.2015 02:51 PM.
 * <p>
 * This file is presented as proposed method that used to
 * solve straight line problem which occurs at selected
 * object point. The object point is identified based on
 * six positions that had stated in TriScalenes.java
 */

package featureTriangle.tool;

import featureTriangle.triangle.PointProcess33;
import featureTriangle.triangle.TriangleGeometry;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SolveStraightLine {

    private static ArrayList<Point> points_upper_right;  // [1]
    private static ArrayList<Point> points_lower_right;  // [2]
    private static ArrayList<Point> points_upper_left;   // [3]
    private static ArrayList<Point> points_lower_left;   // [4]

    private static ArrayList<Point> upperZone;           // [5]
    private static ArrayList<Point> upperUpperZone;      // [6]
    private static ArrayList<Point> upperLowerZone;      // [7]
    private static ArrayList<Point> lowerZone;             // [8]
    private static ArrayList<Point> lowerUpperZone;      // [9]
    private static ArrayList<Point> lowerLowerZone;      // [10]

    private static ArrayList<Point> rightZone;           // [11]
    private static ArrayList<Point> rightRightZone;      // [12]
    private static ArrayList<Point> rightLeftZone;       // [13]
    private static ArrayList<Point> leftZone;            // [14]
    private static ArrayList<Point> leftLeftZone;        // [15]
    private static ArrayList<Point> leftRightZone;       // [16]

    private static ArrayList<Point> rightRightUpperZone; // [17]
    private static ArrayList<Point> rightRightLowerZone; // [18]
    private static ArrayList<Point> rightLeftUpperZone;  // [19]
    private static ArrayList<Point> rightLeftLowerZone;  // [20]
    private static ArrayList<Point> leftRightUpperZone;  // [21]
    private static ArrayList<Point> leftRightLowerZone;  // [22]
    private static ArrayList<Point> leftLeftUpperZone;   // [23]
    private static ArrayList<Point> leftLeftLowerZone;   // [24]

    private static ArrayList<Point> topRightRight;       // [25]
    private static ArrayList<Point> bottomRightRight;    // [26]
    private static ArrayList<Point> topRightLeft;        // [27]
    private static ArrayList<Point> bottomRightLeft;     // [28]
    private static ArrayList<Point> topLeftRight;        // [29]
    private static ArrayList<Point> bottomLeftRight;     // [30]
    private static ArrayList<Point> topLeftLeft;         // [31]
    private static ArrayList<Point> bottomLeftLeft;      // [32]

    private static ArrayList<PointProcess33> pointProcesses = new ArrayList<PointProcess33>();
    private static ArrayList<Point> main_points = new ArrayList<Point>();
    private static int result;


    public static int solveTriStraightLine(String database_table, String type, BufferedImage image, String filename, String features, String point) {

        pointProcesses.add(new PointProcess33(image, filename));

        PointProcess33 process = pointProcesses.get(0);

        BufferedImage mainImage = image;

        main_points = process.getPoints(mainImage);
        Point main_divider = main_points.get(2);

        //Region PUR, PLR, PUL and PLL
        points_upper_right = process.getPointsUpperRight(mainImage, main_divider);
        Point divider_PUR = points_upper_right.get(2);

        points_lower_right = process.getPointsLowerRight(mainImage, main_divider);
        Point divider_PLR = points_lower_right.get(2);

        points_upper_left = process.getPointsUpperLeft(mainImage, main_divider);
        Point divider_PUL = points_upper_left.get(2);

        points_lower_left = process.getPointsLowerLeft(mainImage, main_divider);
        Point divider_PLL = points_lower_left.get(2);
        //End Region PUR, PLR, PUL and PLL

        //Region UpperZone, UpperUpperZone, UpperLowerZone
        upperZone = process.getUpperZone(mainImage, main_divider, 0, 0);
        Point divider_upperzone = upperZone.get(2);

        upperUpperZone = process.getUpperUpperZone(mainImage, divider_upperzone);
        Point divider_upperupperzone = upperUpperZone.get(2);

        upperLowerZone = process.getUpperLowerZone(mainImage, divider_upperzone, main_divider);
        Point divider_upperlowerzone = upperLowerZone.get(2);
        //End Region UpperZone, UpperUpperZone, UpperLowerZone

        //Region LowerZone, LowerUpperZone, LowerLowerZone
        lowerZone = process.getLowerZone(mainImage, main_divider);
        Point divider_lowerzone = lowerZone.get(2);

        lowerUpperZone = process.getLowerUpperZone(mainImage, divider_lowerzone, main_divider);
        Point divider_lowerupperzone = lowerUpperZone.get(2);

        lowerLowerZone = process.getLowerLowerZone(mainImage, divider_lowerzone, main_divider);
        Point divider_lowerlowerzone = lowerLowerZone.get(2);
        //End Region LowerZone, LowerUpperZone, LowerLowerZone

        //Region Right
        rightZone = process.getRightZone(mainImage, main_divider);
        Point divider_rightzone = rightZone.get(2);

        rightRightZone = process.getRightRightZone(mainImage, divider_rightzone);
        Point divider_rightrightzone = rightRightZone.get(2);

        rightRightUpperZone = process.getUpperExtended(mainImage, divider_rightrightzone, 0, divider_rightzone.x);
        Point divider_rightrightupperzone = rightRightUpperZone.get(2);

        rightRightLowerZone = process.getLowerExtended(mainImage, divider_rightrightzone, divider_rightzone.x, 0);
        Point divider_rightrightlowerzone = rightRightLowerZone.get(2);

        rightLeftZone = process.getRightLeftZone(mainImage, main_divider, divider_rightzone);
        Point divider_rightleftzone = rightLeftZone.get(2);

        rightLeftUpperZone = process.getUpperExtended(mainImage, divider_rightleftzone, divider_rightzone.x, main_divider.x);
        Point divider_rightleftupperzone = rightLeftUpperZone.get(2);

        rightLeftLowerZone = process.getLowerExtended(mainImage, divider_rightleftzone, main_divider.x, divider_rightzone.x);
        Point divider_rightleftlowerzone = rightLeftLowerZone.get(2);
        //End Region Right

        //Region Left
        leftZone = process.getLeftZone(mainImage, main_divider);
        Point divider_leftzone = leftZone.get(2);

        leftRightZone = process.getLeftRightZone(mainImage, main_divider, divider_leftzone);
        Point divider_leftrightzone = leftRightZone.get(2);

        leftRightUpperZone = process.getUpperExtended(mainImage, divider_leftrightzone, main_divider.x, divider_leftzone.x);
        Point divider_leftrightupperzone = leftRightUpperZone.get(2);

        leftRightLowerZone = process.getLowerExtended(mainImage, divider_leftrightzone, divider_leftzone.x, main_divider.x);
        Point divider_leftrightlowerzone = leftRightLowerZone.get(2);

        leftLeftZone = process.getLeftLeftZone(mainImage, divider_leftzone);
        Point divider_leftleftzone = leftLeftZone.get(2);

        leftLeftUpperZone = process.getUpperExtended(mainImage, divider_leftleftzone, divider_leftzone.x, 0);
        Point divider_leftleftupperzone = leftLeftUpperZone.get(2);

        leftLeftLowerZone = process.getLowerExtended(mainImage, divider_leftleftzone, 0, divider_leftzone.x);
        Point divider_leftleftlowerzone = leftLeftLowerZone.get(2);
        //End Region Left

        //Region of 45 degrees
        Point centroidTopLeftLeft = process.getCentroid(mainImage);
        Point centroidTopRightRight = new Point(centroidTopLeftLeft);
        Point centroidTopRightLeft = new Point(centroidTopLeftLeft);
        Point centroidTopLeftRight = new Point(centroidTopLeftLeft);
        Point centroidBottomRightRight = new Point(centroidTopLeftLeft);
        Point centroidBottomRightLeft = new Point(centroidTopLeftLeft);
        Point centroidBottomLeftRight = new Point(centroidTopLeftLeft);
        Point centroidBottomLeftLeft = new Point(centroidTopLeftLeft);

        topLeftLeft = process.getTopLeftLeft(mainImage, centroidTopLeftLeft);
        Point divider_topleftleft = topLeftLeft.get(2);

        topLeftRight = process.getTopLeftRight(mainImage, centroidTopLeftRight);
        Point divider_topleftright = topLeftRight.get(2);

        topRightLeft = process.getTopRightLeft(mainImage, centroidTopRightLeft);
        Point divider_toprightleft = topRightLeft.get(2);

        topRightRight = process.getTopRightRight(mainImage, centroidTopRightRight);
        Point divider_toprightright = topRightRight.get(2);

        bottomLeftLeft = process.getBottomLeftLeft(mainImage, centroidBottomLeftLeft);
        Point divider_bottomleftleft = bottomLeftLeft.get(2);

        bottomLeftRight = process.getBottomLeftRight(mainImage, centroidBottomLeftRight);
        Point divider_bottomleftright = bottomLeftRight.get(2);

        bottomRightLeft = process.getBottomRightLeft(mainImage, centroidBottomRightLeft);
        Point divider_bottomrightleft = bottomRightLeft.get(2);

        bottomRightRight = process.getBottomRightRight(mainImage, centroidBottomRightRight);
        Point divider_bottomrightright = bottomRightRight.get(2);
        //End of Region 45 degrees


        if (features.equalsIgnoreCase("Main Triangle")) {

            int part1 = process.getMainTriangle_Part1(mainImage, main_divider);
            int part2 = process.getMainTriangle_Part2(mainImage, main_divider);
            int part3 = process.getMainTriangle_Part3(mainImage, main_divider);
            int part4 = process.getMainTriangle_Part4(mainImage, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Main Triangle", result);
        } else if (features.equalsIgnoreCase("Points Upper Right")) {

            int part1 = process.getPointsUpperRight_Part1(mainImage, divider_PUR);
            int part2 = process.getPointsUpperRight_Part2(mainImage, divider_PUR, main_divider);
            int part3 = process.getPointsUpperRight_Part3(mainImage, divider_PUR, main_divider);
            int part4 = process.getPointsUpperRight_Part4(mainImage, divider_PUR, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Points Upper Right", result);
        } else if (features.equalsIgnoreCase("Points Lower Right")) {

            int part1 = process.getPointsLowerRight_Part1(mainImage, divider_PLR, main_divider);
            int part2 = process.getPointsLowerRight_Part2(mainImage, divider_PLR, main_divider);
            int part3 = process.getPointsLowerRight_Part3(mainImage, divider_PLR);
            int part4 = process.getPointsLowerRight_Part4(mainImage, divider_PLR, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Points Lower Right", result);
        } else if (features.equalsIgnoreCase("Points Upper Left")) {

            int part1 = process.getPointsUpperLeft_Part1(mainImage, divider_PUL, main_divider);
            int part2 = process.getPointsUpperLeft_Part2(mainImage, divider_PUL);
            int part3 = process.getPointsUpperLeft_Part3(mainImage, divider_PUL, main_divider);
            int part4 = process.getPointsUpperLeft_Part4(mainImage, divider_PUL, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Points Upper Left", result);
        } else if (features.equalsIgnoreCase("Points Lower Left")) {

            int part1 = process.getPointsLowerLeft_Part1(mainImage, divider_PLL, main_divider);
            int part2 = process.getPointsLowerLeft_Part2(mainImage, divider_PLL, main_divider);
            int part3 = process.getPointsLowerLeft_Part3(mainImage, divider_PLL, main_divider);
            int part4 = process.getPointsLowerLeft_Part4(mainImage, divider_PLL);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Points Lower Left", result);
        } else if (features.equalsIgnoreCase("Upper Zone")) {

            int part1 = process.getUpperZone_Part1(mainImage, divider_upperzone, main_divider);
            int part2 = process.getUpperZone_Part2(mainImage, divider_upperzone);
            int part3 = process.getUpperZone_Part3(mainImage, divider_upperzone, main_divider);
            int part4 = process.getUpperZone_Part4(mainImage, divider_upperzone, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Upper Zone", result);
        } else if (features.equalsIgnoreCase("Upper Upper Zone")) {

            int part1 = process.getUpperUpperZone_Part1(mainImage, divider_upperupperzone);
            int part2 = process.getUpperUpperZone_Part2(mainImage, divider_upperupperzone);
            int part3 = process.getUpperUpperZone_Part3(mainImage, divider_upperupperzone, divider_upperzone);
            int part4 = process.getUpperUpperZone_Part4(mainImage, divider_upperupperzone, divider_upperzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Upper Upper Zone", result);
        } else if (features.equalsIgnoreCase("Upper Lower Zone")) {

            int part1 = process.getUpperLowerZone_Part1(mainImage, divider_upperlowerzone, divider_upperzone);
            int part2 = process.getUpperLowerZone_Part2(mainImage, divider_upperlowerzone, divider_upperzone);
            int part3 = process.getUpperLowerZone_Part3(mainImage, divider_upperlowerzone, main_divider);
            int part4 = process.getUpperLowerZone_Part4(mainImage, divider_upperlowerzone, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Upper Lower Zone", result);
        } else if (features.equalsIgnoreCase("Lower Zone")) {

            int part1 = process.getLowerZone_Part1(mainImage, divider_lowerzone, main_divider);
            int part2 = process.getLowerZone_Part2(mainImage, divider_lowerzone, main_divider);
            int part3 = process.getLowerZone_Part3(mainImage, divider_lowerzone, main_divider);
            int part4 = process.getLowerZone_Part4(mainImage, divider_lowerzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Lower Zone", result);
        } else if (features.equalsIgnoreCase("Lower Upper Zone")) {

            int part1 = process.getLowerUpperZone_Part1(mainImage, divider_lowerupperzone, main_divider);
            int part2 = process.getLowerUpperZone_Part2(mainImage, divider_lowerupperzone, main_divider);
            int part3 = process.getLowerUpperZone_Part3(mainImage, divider_lowerupperzone, divider_lowerzone);
            int part4 = process.getLowerUpperZone_Part4(mainImage, divider_lowerupperzone, divider_lowerzone);
            ;

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Lower Upper Zone", result);
        } else if (features.equalsIgnoreCase("Lower Lower Zone")) {

            int part1 = process.getLowerLowerZone_Part1(mainImage, divider_lowerlowerzone, divider_lowerzone);
            int part2 = process.getLowerLowerZone_Part2(mainImage, divider_lowerlowerzone, divider_lowerzone);
            int part3 = process.getLowerLowerZone_Part3(mainImage, divider_lowerlowerzone);
            int part4 = process.getLowerLowerZone_Part4(mainImage, divider_lowerlowerzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Lower Lower Zone", result);
        } else if (features.equalsIgnoreCase("Right Zone")) {

            int part1 = process.getRightZone_Part1(mainImage, divider_rightzone, main_divider);
            int part2 = process.getRightZone_Part2(mainImage, divider_rightzone, main_divider);
            int part3 = process.getRightZone_Part3(mainImage, divider_rightzone, main_divider);
            int part4 = process.getRightZone_Part4(mainImage, divider_rightzone, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Right Zone", result);
        } else if (features.equalsIgnoreCase("Right Right Zone")) {

            int part1 = process.getRightRightZone_Part1(mainImage, divider_rightrightzone, main_divider);
            int part2 = process.getRightRightZone_Part2(mainImage, divider_rightrightzone, main_divider);
            int part3 = process.getRightRightZone_Part3(mainImage, divider_rightrightzone, main_divider);
            int part4 = process.getRightRightZone_Part4(mainImage, divider_rightleftzone, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Right Right Zone", result);
        } else if (features.equalsIgnoreCase("Right Right Upper Zone")) {

            int part1 = process.getRightRightUpperZone_Part1(mainImage, divider_rightrightupperzone);
            int part2 = process.getRightRightUpperZone_Part2(mainImage, divider_rightrightupperzone, divider_rightzone);
            int part3 = process.getRightRightUpperZone_Part3(mainImage, divider_rightrightupperzone, divider_rightrightzone);
            int part4 = process.getRightRightUpperZone_Part4(mainImage, divider_rightrightupperzone, divider_rightzone, divider_rightrightzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Right Right Upper Zone", result);
        } else if (features.equalsIgnoreCase("Right Right Lower Zone")) {

            int part1 = process.getRightRightLowerZone_Part1(mainImage, divider_rightrightlowerzone, divider_rightzone);
            int part2 = process.getRightRightLowerZone_Part2(mainImage, divider_rightrightlowerzone, main_divider, divider_rightzone);
            int part3 = process.getRightRightLowerZone_Part3(mainImage, divider_rightrightlowerzone);
            int part4 = process.getRightRightLowerZone_Part4(mainImage, divider_rightrightlowerzone, divider_rightzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Right Right Lower Zone", result);
        } else if (features.equalsIgnoreCase("Right Left Zone")) {

            int part1 = process.getRightLeftZone_Part1(mainImage, divider_rightleftzone, divider_rightzone);
            int part2 = process.getRightLeftZone_Part2(mainImage, divider_rightleftzone, main_divider);
            int part3 = process.getRightLeftZone_Part3(mainImage, divider_rightleftzone, divider_rightzone);
            int part4 = process.getRightLeftZone_Part4(mainImage, divider_rightleftzone, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Right Left Zone", result);
        } else if (features.equalsIgnoreCase("Right Left Upper Zone")) {

            int part1 = process.getRightLeftUpperZone_Part1(mainImage, divider_rightleftupperzone, divider_rightzone);
            int part2 = process.getRightLeftUpperZone_Part2(mainImage, divider_rightleftupperzone, main_divider);
            int part3 = process.getRightLeftUpperZone_Part3(mainImage, divider_rightleftupperzone, divider_rightzone, divider_rightleftzone);
            int part4 = process.getRightLeftUpperZone_Part4(mainImage, divider_rightleftupperzone, divider_rightzone, divider_rightleftzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Points Right Left Upper Zone", result);
        } else if (features.equalsIgnoreCase("Right Left Lower Zone")) {

            int part1 = process.getRightLeftLowerZone_Part1(mainImage, divider_rightleftlowerzone, divider_rightzone);
            int part2 = process.getRightLeftLowerZone_Part2(mainImage, divider_rightleftlowerzone, main_divider, divider_rightleftzone);
            int part3 = process.getRightLeftLowerZone_Part3(mainImage, divider_rightleftlowerzone, divider_rightzone);
            int part4 = process.getRightLeftLowerZone_Part4(mainImage, divider_rightleftlowerzone, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Right Left Lower Zone", result);
        } else if (features.equalsIgnoreCase("Left Zone")) {

            int part1 = process.getLeftZone_Part1(mainImage, divider_leftzone, main_divider);
            int part2 = process.getLeftZone_Part2(mainImage, divider_leftzone);
            int part3 = process.getLeftZone_Part3(mainImage, divider_leftzone, main_divider);
            int part4 = process.getLeftZone_Part4(mainImage, divider_leftzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Left Zone", result);
        } else if (features.equalsIgnoreCase("Left Right Zone")) {

            int part1 = process.getLeftRightZone_Part1(mainImage, divider_leftrightzone, main_divider);
            int part2 = process.getLeftRightZone_Part2(mainImage, divider_leftrightzone, divider_leftzone);
            int part3 = process.getLeftRightZone_Part3(mainImage, divider_leftrightzone, main_divider);
            int part4 = process.getLeftRightZone_Part4(mainImage, divider_leftrightzone, divider_leftzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Left Right Zone", result);
        } else if (features.equalsIgnoreCase("Left Right Upper Zone")) {

            int part1 = process.getLeftRightUpperZone_Part1(mainImage, divider_leftrightupperzone, main_divider);
            int part2 = process.getLeftRightUpperZone_Part2(mainImage, divider_leftrightupperzone, divider_leftzone);
            int part3 = process.getLeftRightUpperZone_Part3(mainImage, divider_leftrightupperzone, main_divider, divider_leftleftzone);
            int part4 = process.getLeftRightUpperZone_Part4(mainImage, divider_leftrightupperzone, divider_leftzone, divider_leftleftzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Left Right Upper Zone", result);
        } else if (features.equalsIgnoreCase("Left Right Lower Zone")) {

            int part1 = process.getLeftRightLowerZone_Part1(mainImage, divider_leftrightlowerzone, main_divider, divider_leftleftzone);
            int part2 = process.getLeftRightLowerZone_Part2(mainImage, divider_leftrightlowerzone, divider_leftzone, divider_leftleftzone);
            int part3 = process.getLeftRightLowerZone_Part3(mainImage, divider_leftrightlowerzone, main_divider);
            int part4 = process.getLeftRightLowerZone_Part4(mainImage, divider_leftrightlowerzone, divider_leftzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Left Right Lower Zone", result);
        } else if (features.equalsIgnoreCase("Left Left Zone")) {

            int part1 = process.getLeftLeftZone_Part1(mainImage, divider_leftleftzone, divider_leftzone);
            int part2 = process.getLeftLeftZone_Part2(mainImage, divider_leftleftzone);
            int part3 = process.getLeftLeftZone_Part3(mainImage, divider_leftleftzone, divider_leftzone);
            int part4 = process.getLeftLeftZone_Part4(mainImage, divider_leftleftzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Left Left Zone", result);
        } else if (features.equalsIgnoreCase("Left Left Upper Zone")) {

            int part1 = process.getLeftLeftUpperZone_Part1(mainImage, divider_leftleftupperzone, divider_leftzone);
            int part2 = process.getLeftLeftUpperZone_Part2(mainImage, divider_leftleftupperzone);
            int part3 = process.getLeftLeftUpperZone_Part3(mainImage, divider_leftleftupperzone, divider_leftzone, divider_leftleftzone);
            int part4 = process.getLeftLeftUpperZone_Part4(mainImage, divider_leftleftupperzone, divider_leftleftzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Left Left Upper Zone", result);
        } else if (features.equalsIgnoreCase("Left Left Lower Zone")) {

            int part1 = process.getLeftLeftLowerZone_Part1(mainImage, divider_leftleftlowerzone, divider_leftzone, divider_leftleftzone);
            int part2 = process.getLeftLeftLowerZone_Part2(mainImage, divider_leftleftlowerzone, divider_leftleftzone);
            int part3 = process.getLeftLeftLowerZone_Part3(mainImage, divider_leftleftlowerzone, divider_leftzone);
            int part4 = process.getLeftLeftLowerZone_Part4(mainImage, divider_leftleftlowerzone);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Left Left Lower Zone", result);
        } else if (features.equalsIgnoreCase("Top Left Left Zone")) {

            int part1 = process.getTopLeftLeftZone_Part1(mainImage, divider_topleftleft, main_divider);
            int part2 = process.getTopLeftLeftZone_Part2(mainImage, divider_topleftleft, main_divider);
            int part3 = process.getTopLeftLeftZone_Part3(mainImage, divider_topleftleft, main_divider);
            int part4 = process.getTopLeftLeftZone_Part4(mainImage, divider_topleftleft, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Top Left Left Zone", result);
        } else if (features.equalsIgnoreCase("Top Left Right Zone")) {

            int part1 = process.getTopLeftRightZone_Part1(mainImage, divider_topleftright, main_divider);
            int part2 = process.getTopLeftRightZone_Part2(mainImage, divider_topleftright, main_divider);
            int part3 = process.getTopLeftRightZone_Part3(mainImage, divider_topleftright, main_divider);
            int part4 = process.getTopLeftRightZone_Part4(mainImage, divider_topleftright, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Top Left Right Zone", result);
        } else if (features.equalsIgnoreCase("Top Right Left Zone")) {

            int part1 = process.getTopRightLeftZone_Part1(mainImage, divider_toprightleft, main_divider);
            int part2 = process.getTopRightLeftZone_Part2(mainImage, divider_toprightleft, main_divider);
            int part3 = process.getTopRightLeftZone_Part3(mainImage, divider_toprightleft, main_divider);
            int part4 = process.getTopRightLeftZone_Part4(mainImage, divider_toprightleft, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Top Right Left Zone", result);
        } else if (features.equalsIgnoreCase("Top Right Right Zone")) {

            int part1 = process.getTopRightRightZone_Part1(mainImage, divider_toprightright, main_divider);
            int part2 = process.getTopRightRightZone_Part2(mainImage, divider_toprightright, main_divider);
            int part3 = process.getTopRightRightZone_Part3(mainImage, divider_toprightright, main_divider);
            int part4 = process.getTopRightRightZone_Part4(mainImage, divider_toprightright, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Top Right Right Zone", result);
        } else if (features.equalsIgnoreCase("Bottom Left Left Zone")) {

            int part1 = process.getBottomLeftLeftZone_Part1(mainImage, divider_bottomleftleft, main_divider);
            int part2 = process.getBottomLeftLeftZone_Part2(mainImage, divider_bottomleftleft, main_divider);
            int part3 = process.getBottomLeftLeftZone_Part3(mainImage, divider_bottomleftleft, main_divider);
            int part4 = process.getBottomLeftLeftZone_Part4(mainImage, divider_bottomleftleft, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Bottom Left Left Zone", result);
        } else if (features.equalsIgnoreCase("Bottom Left Right Zone")) {

            int part1 = process.getBottomLeftRightZone_Part1(mainImage, divider_bottomleftright, main_divider);
            int part2 = process.getBottomLeftRightZone_Part2(mainImage, divider_bottomleftright, main_divider);
            int part3 = process.getBottomLeftRightZone_Part3(mainImage, divider_bottomleftright, main_divider);
            int part4 = process.getBottomLeftRightZone_Part4(mainImage, divider_bottomleftright, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Bottom Left Right Zone", result);
        } else if (features.equalsIgnoreCase("Bottom Right Left Zone")) {

            int part1 = process.getBottomRightLeftZone_Part1(mainImage, divider_bottomrightleft, main_divider);
            int part2 = process.getBottomRightLeftZone_Part2(mainImage, divider_bottomrightleft, main_divider);
            int part3 = process.getBottomRightLeftZone_Part3(mainImage, divider_bottomrightleft, main_divider);
            int part4 = process.getBottomRightLeftZone_Part4(mainImage, divider_bottomrightleft, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Bottom Right Left Zone", result);
        } else if (features.equalsIgnoreCase("Bottom Right Right Zone")) {

            int part1 = process.getBottomRightRightZone_Part1(mainImage, divider_bottomrightright, main_divider);
            int part2 = process.getBottomRightRightZone_Part2(mainImage, divider_bottomrightright, main_divider);
            int part3 = process.getBottomRightRightZone_Part3(mainImage, divider_bottomrightright, main_divider);
            int part4 = process.getBottomRightRightZone_Part4(mainImage, divider_bottomrightright, main_divider);

            result = TriangleGeometry.GetMinusOrAddValueTest(point, part1, part2, part3, part4);
            ToolsForWriteFile.writeResultPosition(database_table, type, filename, "Bottom Right Right Zone", result);
        }

        pointProcesses.clear();

        return result;
    }
}
