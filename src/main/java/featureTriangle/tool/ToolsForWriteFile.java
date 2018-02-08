package featureTriangle.tool;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class ToolsForWriteFile {

    //To check if image filename is exist in text file.
    public static int checkFilenameIsExist(String textfiles, String imgFile) throws IOException {

        int msg = 0;
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(textfiles));
            Scanner ob = new Scanner(imgFile);

            String fname = ob.next();
            String str1 = "", str2 = "";
            int count = 0;

            while ((str1 = br.readLine()) != null) {
                str2 += str1;
            }

            int index = str2.indexOf(fname);

            while (index != -1) {
                count++;
                str2 = str2.substring(index + 1);
                index = str2.indexOf(fname);
            }
            msg = count;
        } catch (FileNotFoundException e) {
            //If text file does not exist, it will create new from here.
            String myfilename = textfiles;
            FileWriter fw = new FileWriter(myfilename, true);
            fw.close();
        }

        return msg;
    }

    public static void saveInFile(String typeOfFile, String filename, int count) {

        try {
            String myfilename = typeOfFile + "_count.txt";
            FileWriter fw = new FileWriter(myfilename, true);
            if ((filename != null || filename != "") && (typeOfFile != null || typeOfFile != "")) {
                fw.write(filename + " = " + count + "\r\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCountToFile(String textfiles, String imgFile) throws IOException {

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(textfiles + ".txt"));
            Scanner ob = new Scanner(imgFile);

            String fname = ob.next();
            String str1 = "", str2 = "";
            int count = 0;

            while ((str1 = br.readLine()) != null) {
                str2 += str1;
            }

            int index = str2.indexOf(fname);

            while (index != -1) {
                count++;
                str2 = str2.substring(index + 1);
                index = str2.indexOf(fname);
            }

            saveInFile(textfiles, fname, count);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "The text file does not exist!");
        }
    }

    public static void saveDuplicateFilename(String filename, String typeFile) {
        try {
            String myfilename = typeFile + ".txt";
            FileWriter fw = new FileWriter(myfilename, true);                //the true will append the new data
            fw.write(filename + "\r\n");                                    //appends the string to the file
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    //Used in MyScalene.java
    public static void checkAndAppend(String filename, String atPoint, String typeFile) throws IOException {

        try {
            String myfilename = typeFile + ".txt";
            FileWriter fw = new FileWriter(myfilename, true);                //the true will append the new data
            fw.write(filename + " = " + atPoint + "\r\n");                   //appends the string to the file
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void writeResultPosition(String datafilename, String typeFile, String filename, String typeOfFeatures, int value) {
        //
    }

    public static void getResultAddMinus(String filename, String atPoint, String typeFile) {

        if (!filename.isEmpty() || filename != null) {
            if (!typeFile.isEmpty() || typeFile != null) {

            }
        }
    }
}
