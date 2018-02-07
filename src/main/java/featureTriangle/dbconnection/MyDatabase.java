package featureTriangle.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDatabase {
    static Connection conn = null;

    public static Connection doConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/paleography?"+"user=root");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/paleographydb", "root", "");
        return conn;
    }

    public static Connection doConnection(String database_table) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
//		System.out.println(System.getProperty("os.name").substring(0, 3));
        try {

            if (System.getProperty("os.name").substring(0, 3).equals("Win")) {
//				System.out.println("Windows based");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/paleographydb", "root", "");

//				System.out.println("Database status : "+createDatabase(database_table));
            } else {
//				System.out.println("Mac Based");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:8081/paleography", "root", "sanusi");

//				System.out.println("Database status : "+createDatabase(database_table));

            }

        } catch (SQLException es) {
//			System.out.println("err"+es.getMessage());
        }

        return conn;
    }

    public static Connection doConnection(String dbname, String derby) throws ClassNotFoundException {

        String sql = "create table san_tbl(num int, addr varchar(40))";


//		System.out.println("ini derby");
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//		System.out.println(System.getProperty("os.name").substring(0, 3));
        try {

            if (System.getProperty("os.name").substring(0, 3).equals("Win")) {
//				System.out.println("Windows based");
                String protocol = "jdbc:derby:";


                Connection dbConnection = null;
                String connectionURL = "jdbc:derby:" + dbname + ";create=true";
                try {

                    dbConnection = DriverManager.getConnection(connectionURL);
//					System.out.println("Connected to database");


                    Statement s = dbConnection.createStatement();
                    // Call utility method to check if table exists.
                    //      Create the table if needed


                    s.execute(sql);
                    s.close();
                    dbConnection.close();
//		                  System.out.println (" . . . . creating table WISH_LIST");

                } catch (SQLException sqle) {
                    sqle.printStackTrace();
                }
                //	System.out.println("Database status : "+createDatabase(database_table));
            } else {
//				System.out.println("Mac Based");

                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/paleography", "root", "sanusi");

//				System.out.println("Database status : "+createDatabase(dbname));

            }

        } catch (SQLException es) {
//			System.out.println("err"+es.getMessage());
        }

        return conn;
    }

    public static int createDatabase(String database_table) throws ClassNotFoundException {
//		System.out.println("hai");
        int status = 0;
        try {

            Statement state = conn.createStatement();
            String database_name = "sandby";
            state.executeUpdate("CREATE DATABASE " + database_name);
//				System.out.println("Database created");
            status = 1;
            //System.out.println("create table status :"+createTable());
            state.close();
        } catch (SQLException e) {

            //System.out.println("create table status :"+createTable());
        }
//		 System.out.println("create table status :"+createTable(database_table));

        return status;
    }

    /**
     * @return
     */
    public static int createTable(String database_table) {
        int status = 0;
        String sql = "CREATE table " + database_table + " (id int(11) not null auto_increment, fname varchar(45)," +
                "cbya float, abyb float, bbyc float, A float, B float, C float, GraBA float, GraBC float, GraCA float," +

                "pu_cbya float, pu_abyb float, pu_bbyc float, pu_A float, pu_B float, pu_C float, pu_GraBA float, pu_GraBC float, pu_GraCA float" +
                "pl_cbya float, pl_abyb float, pl_bbyc float, pl_A float, pl_B float, pl_C float, pl_GraBA float, pl_GraBC float, pl_GraCA float" +

                "tu_cbya float, tu_abyb float, tu_bbyc float, tu_A float, tu_B float, tu_C float, tu_GraBA float, tu_GraBC float, tu_GraCA float" +
                "tl_cbya float, tl_abyb float, tl_bbyc float, tl_A float, tl_B float, tl_C float, tl_GraBA float, tl_GraBC float, tl_GraCA float" +

                "bu_cbya float, bu_abyb float, bu_bbyc float, bu_A float, bu_B float, bu_C float, bu_GraBA float, bu_GraBC float, bu_GraCA float" +
                "bl_cbya float, bl_abyb float, bl_bbyc float, bl_A float, bl_B float, bl_C float, bl_GraBA float, bl_GraBC float, bl_GraCA float" +

                "p_Lcbya float, p_Labyb float, p_Lbbyc float, p_LA float, p_LB float, p_LC float, p_LGraBA float, p_LGraBC float, p_LGraCA float" +
                "p_Rcbya float, p_Rabyb float, p_Rbbyc float, p_RA float, p_RB float, p_RC float, p_RGraBA float, p_RGraBC float, p_RGraCA float" +

                "LLZ_cbya float, LLZ_abyb float, LLZ_bbyc float, LLZ_A float, LLZ_B float, LLZ_C float, LLZ_GraBA float, LLZ_GraBC float, LLZ_GraCA float" +
                "LRZ_cbya float, LRZ_abyb float, LRZ_bbyc float, LRZ_A float, LRZ_B float, LRZ_C float, LRZ_GraBA float, LRZ_GraBC float, LRZ_GraCA float" +

                "RLZ_cbya float, RLZ_abyb float, RLZ_bbyc float, RLZ_A float, RLZ_B float, RLZ_C float, RLZ_GraBA float, RLZ_GraBC float, RLZ_GraCA float" +
                "RRZ_cbya float, RRZ_abyb float, RRZ_bbyc float, RRZ_A float, RRZ_B float, RRZ_C float, RRZ_GraBA float, RRZ_GraBC float, RRZ_GraCA float" +

                "pul_cbya float, pul_abyb float, pul_bbyc float, pul_A float, pul_B float, pul_C float, pul_GraBA float, pul_GraBC float, pul_GraCA float" +
                "pur_cbya float, pur_abyb float, pur_bbyc float, pur_A float, pur_B float, pur_C float, pur_GraBA float, pur_GraBC float, pur_GraCA float" +
                "pll_cbya float, pll_abyb float, pll_bbyc float, pll_A float, pll_B float, pll_C float, pll_GraBA float, pll_GraBC float, pll_GraCA float" +
                "plr_cbya float, plr_abyb float, plr_bbyc float, plr_A float, plr_B float, plr_C float, plr_GraBA float, plr_GraBC float, plr_GraCA float" +
                "type varchar(20)," +
                "primary key(id))";


        try {

            Statement state = conn.createStatement();
            state.executeUpdate(sql);
            status = 1;
            state.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
//			System.out.println("Table exists");
        }

        return status;
    }


    public static void main(String[] args) {

        try {
            doConnection("zone33");
//			System.out.println("done");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//		try {
//			doConnection();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("done");
//

    }

}


//DatabaseMetaData dbm = con.getMetaData();
//// check if "employee" table is there
//ResultSet tables = dbm.getTables(null, null, "employee", null);
//if (tables.next()) {
//  // Table exists
//}
//else {
//  // Table does not exist
//}
