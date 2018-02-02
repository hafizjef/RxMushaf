package apiDynamic;

import beanDynamic.BeanComparator;
import beanDynamic.BeanResult;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;


public class UnsupervisedTools {
    /**
     * This process need to be done before invoking distance methods in this class.
     *
     * @param arrayList
     * @return number of column of test or model
     */
    private static int getColumnLength(ArrayList<String[]> arrayList) {
        int size = 0;
        for (String[] list : arrayList) {
            size = list.length;
        }
        return size;
    }


    public ArrayList<BeanResult> calcPraDistance(String inputTest, ArrayList<String[]> listModel)  // USE THIS METHOD FORM MAIN GUI
    {
        int testSize = inputTest.split(";").length;
        int modelSize = getColumnLength(listModel);

        float distance = 0;
        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        JOptionPane.showMessageDialog(null, "Size model : <" + modelSize + "> Size test : <" + testSize + ">");

        if (testSize != modelSize) {
            return null;
        } else {
            //System.out.println("list test size :"+listTest.size());
            //for(String [] tests :listTest)
            //{
//				for(String t : tests)
//					System.out.println("t :"+t);
            listResult = calcEuclidan(inputTest, listModel);
            //}
        }


        return listResult;
    }

    //PraDistant Manhattan

    public ArrayList<BeanResult> calcPraDistanceManhattan(String inputTest, ArrayList<String[]> listModel) {
        int testSize = inputTest.split(";").length;
        int modelSize = getColumnLength(listModel);

        float distance = 0;
        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        if (testSize != modelSize) {
            return null;
        } else {

            listResult = calcManhattan(inputTest, listModel);

        }


        return listResult;
    }

    //PraDistant Chebyshev
    public ArrayList<BeanResult> calcPraDistanceChebyshev(String inputTest, ArrayList<String[]> listModel) {
        int testSize = inputTest.split(";").length;
        int modelSize = getColumnLength(listModel);

        float distance = 0;
        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        if (testSize != modelSize) {
            return null;
        } else {

            listResult = calcChebyshev(inputTest, listModel);

        }


        return listResult;
    }

    //PraDistant Canberra
    public ArrayList<BeanResult> calcPraDistanceCanberra(String inputTest, ArrayList<String[]> listModel) {
        int testSize = inputTest.split(";").length;
        int modelSize = getColumnLength(listModel);

        float distance = 0;
        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        if (testSize != modelSize) {
            return null;
        } else {

            listResult = calcCanberra(inputTest, listModel);

        }


        return listResult;
    }

    //PraDistant Sorenson
    public ArrayList<BeanResult> calcPraDistanceSorenson(String inputTest, ArrayList<String[]> listModel) {
        int testSize = inputTest.split(";").length;
        int modelSize = getColumnLength(listModel);

        float distance = 0;
        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        if (testSize != modelSize) {
            return null;
        } else {

            listResult = calcSorenson(inputTest, listModel);

        }


        return listResult;
    }

    //PraDistant Angular

    public ArrayList<BeanResult> calcPraDistanceAngular(String inputTest, ArrayList<String[]> listModel) {
        int testSize = inputTest.split(";").length;
        int modelSize = getColumnLength(listModel);

        float distance = 0;
        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        if (testSize != modelSize) {
            return null;
        } else {

            listResult = calcAngularSeparation(inputTest, listModel);

        }


        return listResult;
    }

    //Pradistant Miwkowski

    public ArrayList<BeanResult> calcPraDistanMinkowski(String inputTest, ArrayList<String[]> listModel) {
        int testSize = inputTest.split(";").length;
        int modelSize = getColumnLength(listModel);

        float distance = 0;
        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        if (testSize != modelSize) {
            return null;
        } else {

            listResult = calcMinkowski(inputTest, listModel);

        }


        return listResult;
    }


    public ArrayList<BeanResult> calcPraDistance(ArrayList<String[]> listTest, ArrayList<String[]> listModel) {
        int testSize = getColumnLength(listTest);
        int modelSize = getColumnLength(listModel);

        float distance = 0;
        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        if (testSize != modelSize) {
            return null;
        } else {
//			System.out.println("list test size :"+listTest.size());
            for (String[] tests : listTest) {
//				for(String t : tests)
//					System.out.println("t :"+t);
                listResult = calcEuclidan(tests, listModel);  //calcEuclidan(tests, listModel);
            }
        }


        return listResult;
    }


    public ArrayList<BeanResult> calcEuclidan(String inputTest, ArrayList<String[]> listModel) {

        float distance = 0.0f;
        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        for (String[] models : listModel) {
            float sum = 0.0f;
            String[] inputs = inputTest.split(";");
            for (int i = 1; i < models.length - 1; i++) {

                sum += Math.pow(Float.parseFloat(inputs[i]) - Float.parseFloat(models[i]), 2);
            }

            distance = (float) Math.sqrt(sum);
            BeanResult beanresult = new BeanResult(inputs[0], distance, models[0], models[models.length - 1]); //String sourcefname, double distance, String reffname, String type

            listResult.add(beanresult);
        }

        CsvFileWriter csv = new CsvFileWriter();
        csv.writeCsvFile(listResult);

        BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
        Collections.sort(listResult, bean_comparator);

        System.out.println("\n\n\n\n Distance Ecludian ");
        for (BeanResult b : listResult) {
            System.out.println("Test : " + b.getSourcefname() + " Distance " + b.getDistance() + " Model :" + b.getReffname() + " type : " + b.getType());
        }
        System.out.println("oools");
        return listResult;
    }

    /*
     * Not use in this project
     */
    public ArrayList<BeanResult> calcEuclidan(String[] testArray, ArrayList<String[]> listModel) {

        float distance = 0.0f;
        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        for (String[] models : listModel) {
            float sum = 0.0f;
            for (int i = 1; i < models.length - 1; i++) {

                sum += Math.pow(Float.parseFloat(testArray[i]) - Float.parseFloat(models[i]), 2);
            }

            distance = (float) Math.sqrt(sum);
            BeanResult beanresult = new BeanResult(testArray[0], distance, models[0], models[models.length - 1]);

            listResult.add(beanresult);
        }

//		System.out.println("GHe");
//		for(BeanResult b : listResult)
//		{
//			System.out.println("Test : "+b.getSourcefname()+" Distance "+b.getDistance()+" Model :"+b.getReffname()+" type : "+b.getType());
//		}
//		System.out.println("oools");

        /* 6.4.2015
         * create csv file. when the result will be save in csv file
         */

//		CsvFileWriter csv = new CsvFileWriter();
//		csv.writeCsvFile(listResult);


        return listResult;
    }

    // calculation for manhattan
    public ArrayList<BeanResult> calcManhattan(String inputTest, ArrayList<String[]> listModel) {


        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        for (String[] models : listModel) {


            float manhattan = 0;
            String[] inputs = inputTest.split(";");
            for (int i = 1; i < models.length - 1; i++) {

                manhattan += Math.abs((Float.parseFloat(inputs[i])) - (Float.parseFloat(models[i])));

            }
            float distance = manhattan;
            BeanResult beanresult = new BeanResult(inputs[0], distance, models[0], models[models.length - 1]);

            listResult.add(beanresult);

        }

        CsvFileWriter csv = new CsvFileWriter();
        csv.writeCsvFile(listResult);

        BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
        Collections.sort(listResult, bean_comparator);


        System.out.println("\n\n\n\n Distance Manhattan");
        for (BeanResult b : listResult) {
            System.out.println("Test : " + b.getSourcefname() + " Distance " + b.getDistance() + " Model :" + b.getReffname() + " type : " + b.getType());
        }
        System.out.println("oools");

        return listResult;
    }

    // calculation for Chelbyshev

    public ArrayList<BeanResult> calcChebyshev(String inputTest, ArrayList<String[]> listModel) {


        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        for (String[] models : listModel) {
            String[] inputs = inputTest.split(";");
            float max = Float.parseFloat(inputs[1]) - Float.parseFloat(models[1]);
            ;
            for (int i = 1; i < models.length - 1; i++) {

                max += Math.abs((Float.parseFloat(inputs[i])) - (Float.parseFloat(models[i])));

            }
            float distance = max;
            BeanResult beanresult = new BeanResult(inputs[0], distance, models[0], models[models.length - 1]);

            listResult.add(beanresult);

        }

        CsvFileWriter csv = new CsvFileWriter();
        csv.writeCsvFile(listResult);

        BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
        Collections.sort(listResult, bean_comparator);

        System.out.println("\n\n\n\n Distance Chelbyshev");
        for (BeanResult b : listResult) {
            System.out.println("Test : " + b.getSourcefname() + " Distance " + b.getDistance() + " Model :" + b.getReffname() + " type : " + b.getType());
        }
        System.out.println("oools");

        return listResult;
    }

    // calculation for canberra

    public ArrayList<BeanResult> calcCanberra(String inputTest, ArrayList<String[]> listModel) {


        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        for (String[] models : listModel) {

            float canberra = 0;
            String[] inputs = inputTest.split(";");
            for (int i = 1; i < models.length - 1; i++) {

                canberra += Math.abs(Float.parseFloat(inputs[i]) - Float.parseFloat(models[i])) / (Float.parseFloat(inputs[i]) + Float.parseFloat(models[i]));

            }
            float distance = canberra;
            BeanResult beanresult = new BeanResult(inputs[0], distance, models[0], models[models.length - 1]);

            listResult.add(beanresult);

        }

        CsvFileWriter csv = new CsvFileWriter();
        csv.writeCsvFile(listResult);

        BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
        Collections.sort(listResult, bean_comparator);

        System.out.println("\n\n\n\n Distance Canberra");
        for (BeanResult b : listResult) {
            System.out.println("Test : " + b.getSourcefname() + " Distance " + b.getDistance() + " Model :" + b.getReffname() + " type : " + b.getType());
        }
        System.out.println("oools");

        return listResult;
    }

    //calculation for sorenson
    public ArrayList<BeanResult> calcSorenson(String inputTest, ArrayList<String[]> listModel) {


        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        for (String[] models : listModel) {

            float sorensonUp = 0;
            float sorensonDown = 0;
            String[] inputs = inputTest.split(";");
            for (int i = 1; i < models.length - 1; i++) {

                sorensonUp += Math.abs((Float.parseFloat(inputs[i])) - (Float.parseFloat(models[i])));
                sorensonDown += ((Float.parseFloat(inputs[i])) - (Float.parseFloat(models[i])));
            }
            float distance = sorensonUp / sorensonDown;
            BeanResult beanresult = new BeanResult(inputs[0], distance, models[0], models[models.length - 1]);

            listResult.add(beanresult);

        }

        CsvFileWriter csv = new CsvFileWriter();
        csv.writeCsvFile(listResult);

        BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
        Collections.sort(listResult, bean_comparator);

        System.out.println("\n\n\n\n Distance Sorensson");
        for (BeanResult b : listResult) {
            System.out.println("Test : " + b.getSourcefname() + " Distance " + b.getDistance() + " Model :" + b.getReffname() + " type : " + b.getType());
        }
        System.out.println("oools");

        return listResult;
    }

    //calculation AngularSeparation

    public ArrayList<BeanResult> calcAngularSeparation(String inputTest, ArrayList<String[]> listModel) {


        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        for (String[] models : listModel) {

            float angularUp = 0;
            float angularDown1 = 0;
            float angularDown2 = 0;
            String[] inputs = inputTest.split(";");
            for (int i = 1; i < models.length - 1; i++) {

                angularUp += Math.abs((Float.parseFloat(inputs[i]) * Float.parseFloat(models[i])));
                angularDown1 += Math.pow(Float.parseFloat(inputs[i]), 2);
                angularDown2 += Math.pow(Float.parseFloat(models[i]), 2);

            }
            float distance = angularUp / (angularDown1 * angularDown2);
            BeanResult beanresult = new BeanResult(inputs[0], distance, models[0], models[models.length - 1]);

            listResult.add(beanresult);

        }
        CsvFileWriter csv = new CsvFileWriter();
        csv.writeCsvFile(listResult);

        BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
        Collections.sort(listResult, bean_comparator);

        System.out.println("\n\n\n\n Distance Anggular Separation");
        for (BeanResult b : listResult) {
            System.out.println("Test : " + b.getSourcefname() + " Distance " + b.getDistance() + " Model :" + b.getReffname() + " type : " + b.getType());
        }
        System.out.println("oools");

        return listResult;
    }

    //calculation for Minkowski
    public ArrayList<BeanResult> calcMinkowski(String inputTest, ArrayList<String[]> listModel) {


        ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();

        for (String[] models : listModel) {

            float minkowski = 0;
            String[] inputs = inputTest.split(";");

            for (int i = 1; i < models.length - 1; i++) {

                minkowski += Math.pow(Math.abs((Float.parseFloat(inputs[i]) - Float.parseFloat(models[i]))), 3);

            }
            float distance = (float) (1 / (Math.pow(minkowski, 1 / 3.0)));
            BeanResult beanresult = new BeanResult(inputs[0], distance, models[0], models[models.length - 1]);

            listResult.add(beanresult);

        }
        CsvFileWriter csv = new CsvFileWriter();
        csv.writeCsvFile(listResult);

        BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
        Collections.sort(listResult, bean_comparator);

        System.out.println("\n\n\n\n Distance Minkowski");
        for (BeanResult b : listResult) {
//			b.getSourcefname() tukarkan kepada filenam dari double click
            System.out.println("Test : " + b.getSourcefname() + " Distance " + b.getDistance() + " Model :" + b.getReffname() + " type : " + b.getType());
        }
        //System.out.println("oools");


        return listResult;
    }


    public static void main(String[] args) {
    }





	/* Mula
	 *
	 *
	 *
	 public static ArrayList<BeanResult> calcEcludian(String [] input, ArrayList<String [] > getDB) throws ClassNotFoundException, SQLException
	{


		ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();



		int count =0;
		for(String [] s1 : getDB)
		{
		//	if(count<2000)
		//	{
				if(s1.length ==input.length)
				{

					//System.out.println("length : "+s1.length);
					float sum =0;
					for(int i=1; i<s1.length-1; i++)
					{

						 sum+= Math.pow(Float.parseFloat(input[i])-Float.parseFloat(s1[i]), 2);

					}
					float distance = (float) Math.sqrt(sum);
					BeanResult beanresult = new BeanResult(input[0], distance , s1[0], s1[s1.length-1]);

					listResult.add(beanresult);
					count++;

				}
				else
				{
					System.out.println("Different size of data");
					break;
				}
//			}
//			else
//				break;


		}
		BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
		Collections.sort(listResult,bean_comparator);
		return listResult;
	}

	public static ArrayList<BeanResult> calcManhattan(String [] input, ArrayList<String [] > getDB) throws ClassNotFoundException, SQLException
	{

		//Bean b from database
		//bb dari gui
		ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();



		System.out.println("size list :"+getDB.size());
	//	JOptionPane.showMessageDialog(null, "size list :"+arr.size());
		//FileWriter fw = new FileWriter("D:/mydata.txt");

		for(String [] s1 : getDB)
		{
			if(s1.length ==input.length)
			{

			//	System.out.println("length : "+s1.length);
				float manhattan =0;
				for(int i=1; i<s1.length-1; i++)
				{

					 manhattan = Math.abs((Float.parseFloat(input[i]))-(Float.parseFloat(s1[i])));

				}
				float distance = manhattan;
				BeanResult beanresult = new BeanResult(input[0], distance , s1[0], s1[s1.length-1]);
				listResult.add(beanresult);
			}
			else
				System.out.println("Different size of data");


		}
		BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
		Collections.sort(listResult,bean_comparator);
		return listResult;
	}
	public static ArrayList<BeanResult> calcChebyshev(String [] input, ArrayList<String [] > getDB) throws ClassNotFoundException, SQLException
	{

		//Bean b from database
		//bb dari gui
		ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();


		//System.out.println("size list :"+getDB.size());
	//	JOptionPane.showMessageDialog(null, "size list :"+arr.size());
		//FileWriter fw = new FileWriter("D:/mydata.txt");

		for(String [] s1 : getDB)
		{
			if(s1.length ==input.length)
			{

			//	System.out.println("length : "+s1.length);
				float max =Float.parseFloat(input[1])-Float.parseFloat(s1[1]);
				for(int i=2; i<s1.length-1; i++)
				{
					max = Math.max(max,Float.parseFloat(input[i])-Float.parseFloat(s1[i]));


				}
				float distance = max;
				BeanResult beanresult = new BeanResult(input[0], distance , s1[0], s1[s1.length-1]);
				listResult.add(beanresult);
			}
			else
				System.out.println("Different size of data");


		}
		BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
		Collections.sort(listResult,bean_comparator);
		return listResult;

	}

	public static ArrayList<BeanResult> calcCanberra(String [] input, ArrayList<String [] > getDB) throws ClassNotFoundException, SQLException
	{

		//Bean b from database
		//bb dari gui
		ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();



	//	System.out.println("size list :"+getDB.size());
	//	JOptionPane.showMessageDialog(null, "size list :"+arr.size());
		//FileWriter fw = new FileWriter("D:/mydata.txt");

		for(String [] s1 : getDB)
		{
			if(s1.length ==input.length)
			{

		//		System.out.println("length : "+s1.length);
				float canberra = 0;
				for(int i=1; i<s1.length-1; i++)
				{

					 canberra +=Math.abs(Float.parseFloat(input[i])-Float.parseFloat(s1[i]))/(Float.parseFloat(input[i])+Float.parseFloat(s1[i]));

				}
				float distance = canberra;
				BeanResult beanresult = new BeanResult(input[0], distance , s1[0], s1[s1.length-1]);
				listResult.add(beanresult);
			}
			else
				System.out.println("Different size of data");


		}
		BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
		Collections.sort(listResult,bean_comparator);
		return listResult;

	}

	public static ArrayList<BeanResult> calcSorenson(String [] input, ArrayList<String [] > getDB) throws ClassNotFoundException, SQLException
	{

		//Bean b from database
		//bb dari gui
		ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();


	//	System.out.println("size list :"+getDB.size());
	//	JOptionPane.showMessageDialog(null, "size list :"+arr.size());
		//FileWriter fw = new FileWriter("D:/mydata.txt");

		for(String [] s1 : getDB)
		{
			if(s1.length ==input.length)
			{

		//		System.out.println("length : "+s1.length);
				float sorensonUp = 0;
				float sorensonDown=0;
				for(int i=1; i<s1.length-1; i++)
				{


					 sorensonUp+=Math.abs(Float.parseFloat(input[i])-Float.parseFloat(s1[i]));
					 sorensonDown+=(Float.parseFloat(input[i])+Float.parseFloat(s1[i]));

				}
				float distance = sorensonUp/sorensonDown;
				BeanResult beanresult = new BeanResult(input[0], distance , s1[0], s1[s1.length-1]);
				listResult.add(beanresult);
			}
			else
				System.out.println("Different size of data");


		}
		BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
		Collections.sort(listResult,bean_comparator);
		return listResult;

	}


	public static ArrayList<BeanResult> calcAngularSeparation(String [] input, ArrayList<String [] > getDB) throws ClassNotFoundException, SQLException
	{

		//Bean b from database
		//bb dari gui
		ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();


	//	System.out.println("size list :"+getDB.size());
	//	JOptionPane.showMessageDialog(null, "size list :"+arr.size());
		//FileWriter fw = new FileWriter("D:/mydata.txt");

		for(String [] s1 : getDB)
		{
			if(s1.length ==input.length)
			{

	//			System.out.println("length : "+s1.length);
				float angularUp = 0;
				float angularDown1=0;
				float angularDown2=0;
				for(int i=1; i<s1.length-1; i++)
				{


					 angularUp += Math.abs((Float.parseFloat(input[i])*Float.parseFloat(s1[i])));
					 angularDown1 += Math.pow(Float.parseFloat(input[i]), 2);
					 angularDown2 += Math.pow(Float.parseFloat(s1[i]),2);

				}

				float distance = angularUp/(angularDown1*angularDown2);
				BeanResult beanresult = new BeanResult(input[0], distance , s1[0], s1[s1.length-1]);
				listResult.add(beanresult);
			}
			else
				System.out.println("Different size of data");


		}
		BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
		Collections.sort(listResult,bean_comparator);
		return listResult;

	}

	public static ArrayList<BeanResult> calcMinkowski(String [] input, ArrayList<String []> getDB) throws ClassNotFoundException, SQLException
	{

		//Bean b from database
		//bb dari gui
		ArrayList<BeanResult> listResult = new ArrayList<BeanResult>();


	//	System.out.println("size list :"+getDB.size());
	//	JOptionPane.showMessageDialog(null, "size list :"+arr.size());
		//FileWriter fw = new FileWriter("D:/mydata.txt");

		for(String [] s1 : getDB)
		{
			if(s1.length ==input.length)
			{

	//			System.out.println("length : "+s1.length);
				float minkowski = 0;

				for(int i=1; i<s1.length-1; i++)
				{
					 minkowski += Math.pow(Math.abs((Float.parseFloat(input[i])-Float.parseFloat(s1[i]))),3);
				}

				float distance = (float) (1/(Math.pow(minkowski, 1/3.0)));
				BeanResult beanresult = new BeanResult(input[0], distance , s1[0], s1[s1.length-1]);
				listResult.add(beanresult);
			}
			else
				System.out.println("Different size of data");


		}
		BeanComparator bean_comparator = new BeanComparator(BeanResult.class, "getDistance");
		Collections.sort(listResult,bean_comparator);
		return listResult;

	}

	Tamat */

//	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
//		String sql = "select fname, cbya, abyb, bbyc, A, B, C, type from sem4hoda_test";
//
//
//		String input[]  ={"th_10009_0.bmp","0.632","0.62","2.55","0.0628333","0.897583","0.0395833","hoda0"} ;
//		ArrayList<String[]> db = MyDataAPI.getDB("select fname, cbya, abyb, bbyc, A, B, C, type from sem4hoda_test");
//
//		FileWriter fw = new FileWriter("d:/minkowski.txt");
//		for(BeanResult b: calcMinkowski(input, db))
//		{
//			//System.out.println(b.getSourcefname()+ " :"+b.getDistance()+" : "+b.getType()+" : "+b.getReffname());
//			fw.append(b.getSourcefname()+ " :"+b.getDistance()+" : "+b.getType()+" : "+b.getReffname()+"\n");
//			fw.flush();
//		}
//		fw.close();
//		db.clear();


//	}
}
