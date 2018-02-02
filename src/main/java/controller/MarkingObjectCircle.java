package controller;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class MarkingObjectCircle extends JComponent {

    public static File inputFile; //"C:/Users/MSI/starlight/TestBox/tools/002after.bmp"
    private static ImageIcon java2sLogo;
    private static Color m_tRed = new Color(255, 0, 0, 150);
    //private static Color m_tBlue = new Color(0, 0, 255, 150);

    private String fileDirectory; // directory of selected image (raw image)

    ArrayList<Integer> yAxis = new ArrayList<Integer>(); // collection of pieces cutting objects' yAxis center axis
    ArrayList<Integer> xAxis = new ArrayList<Integer>(); // collection of pieces cutting objects' xAxis center axis
    ArrayList<Integer> yheight = new ArrayList<Integer>(); // collection of pieces cutting objects' height
    ArrayList<Integer> xWidth = new ArrayList<Integer>(); // collection of pieces cutting objects' Width
    private int countObj = 0; // count how many pieces of cutting object they have
    ArrayList<String> topObjFile = new ArrayList<String>(); //collection of File Path directory for parent name on each pieces cutting object picture

    int w; // width of image selected (raw image)
    int h; // height of image selected (raw image)

    public MarkingObjectCircle(String fileDirectory, ArrayList<Integer> yAxis, ArrayList<Integer> xAxis, ArrayList<Integer> yheight, ArrayList<Integer> xWidth, int countObj, ArrayList<String> topObjFile) {
        this.fileDirectory = fileDirectory;
        this.yAxis = yAxis;
        this.xAxis = xAxis;
        this.yheight = yheight;
        this.xWidth = xWidth;
        this.countObj = countObj; // how many object of circle
        this.topObjFile = topObjFile; // directory from parent
    }


    public void paint(Graphics g) {
        super.paintComponent(g);

        inputFile = new File(fileDirectory);
        java2sLogo = new ImageIcon(inputFile.toString());

        w = java2sLogo.getIconWidth();
        h = java2sLogo.getIconHeight();

        java2sLogo.paintIcon(this, g, 0, 0);

        for (int count = 0; count < countObj; count++) {

            if (topObjFile.get(count) == fileDirectory) {
                g.setColor(m_tRed);
                g.fillOval(xAxis.get(count) - (xWidth.get(count) / 2), yAxis.get(count) - (yheight.get(count) / 2), xWidth.get(count), yheight.get(count));
            }

        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(w, h); // return new Dimension(400, 400);
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Oval Sample");
        //frame.getContentPane().add(new MarkingObjectCircle("C:/Users/MSI/starlight/TestBox/tools/002after.bmp", 70, 70, 40, 40,1));
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
