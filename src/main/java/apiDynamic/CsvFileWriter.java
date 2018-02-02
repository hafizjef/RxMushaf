package apiDynamic;


import beanDynamic.BeanResult;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CsvFileWriter {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String fileName = "output/csv";
    //CSV file header
    //private static final String FILE_HEADER = "id,firstName,lastName,gender,age";
    private static final String FILE_HEADER = "Result,ref,distance,Type";
    public static int number = 0;

    public static void writeCsvFile(ArrayList<BeanResult> results) {


        ArrayList<BeanResult> csvBeanResult = new ArrayList<BeanResult>();
        csvBeanResult.addAll(results);

        /*
         * Every result will be save in CSV file. it will loop till no more data.
         */
        if (results != null) {


            //System.out.println("end");
        } else {

            //System.out.println("test data and model data not same");
        }


        FileWriter fileWriter = null;

        try {
            //fileWriter = new FileWriter("C:/Users/Ilham/workspaces/csv/csvFile"+number+"test.csv");
            fileWriter = new FileWriter("./trash data" + number + "test.csv");
            //Write the CSV file header
            fileWriter.append(FILE_HEADER);

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (BeanResult bean : csvBeanResult) {
                fileWriter.append(String.valueOf(bean.getSourcefname()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(bean.getReffname()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(bean.getDistance()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(bean.getType()));
                //fileWriter.append(COMMA_DELIMITER);
                //fileWriter.append(String.valueOf(student.getAge()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }


            System.out.println("[CsvFileWriter-76] CSV file was created successfully !!!");
            number++;

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }


    public static void writeCsvFiles(ArrayList<BeanResult> results) {


        ArrayList<BeanResult> csvBeanResult = new ArrayList<BeanResult>();
        csvBeanResult.addAll(results);

        /*
         * Every result will be save in CSV file. it will loop till no more data.
         */
        if (results != null) {

            System.out.println("Number : " + number);

            for (BeanResult r : results) {
                System.out.println("TEST Result : " + r.getSourcefname() + " ref : " + r.getReffname() + " distance : " + r.getDistance() + " Type : " + r.getType());
            }
            System.out.println("end");
        } else {

            System.out.println("test data and model data not same");
        }


        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("output/csv/" + number + "test.csv");

            //Write the CSV file header
            fileWriter.append(FILE_HEADER);

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new student object list to the CSV file
            for (BeanResult bean : csvBeanResult) {
                fileWriter.append(String.valueOf(bean.getSourcefname()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(bean.getReffname()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(bean.getDistance()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(bean.getType()));
                //fileWriter.append(COMMA_DELIMITER);
                //fileWriter.append(String.valueOf(student.getAge()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }


            System.out.println("CSV file was created successfully !!!");
            number++;

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }
    }


}