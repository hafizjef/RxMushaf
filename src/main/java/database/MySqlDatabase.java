package database;

import java.sql.*;

public class MySqlDatabase {
    private static String DB_URL = "jdbc:mysql://127.0.1:3306/tashihdb?serverTimezone=Asia/Kuala_Lumpur";
    private static String USER = "root";
    private static String PASS = "";

    public static Connection doConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }

    public static void main(String[] args) {
        //test database
        //insertUserInfo();
        //searchMushafalquran();

        Mushafalquran_DBModel mushafalquran = new Mushafalquran_DBModel();
        mushafalquran.setNegara("");
        //mushafalquran.setMukaSurat("2");
        //mushafalquran.setVersi("Test");
        searchMushafalquran(mushafalquran);

    }

    private static void insertUserInfo() {
        int status = 0;
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO userinfo (userid, user, pass) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            //			ps.setString(1, "5");
            //			ps.setString(2, "test");
            //			ps.setString(3, "123");
            writeCustomer(ps);
            status = ps.executeUpdate();
            if (status != 0) {
                ResultSet rs = ps.getGeneratedKeys();

                if (rs.next())
                    System.out.println(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("status : " + status);
    }

    private static void searchMushafalquran() {
//		try {
//			Connection conn = MySqlDatabase.doConnection();
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT userid,user,pass FROM userinfo");
//			if(rs.isBeforeFirst()){
//				while(rs.next()){
//					int userid  = rs.getInt("userid");
//					String user = rs.getString("user");
//					String pass = rs.getString("pass");
//
//					System.out.print("userid: " + userid);
//					System.out.print(", user: " + user);
//					System.out.print(", pass: " + pass+"\n");
//				}
//			}else{
//				System.out.print("No result! ");
//			}
//			rs.close();
//			stmt.close();
//			conn.close();
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT userid,user,pass FROM userinfo WHERE userid = ? OR user = ? OR pass = ?");
            ps.setString(1, "1");
            ps.setString(2, null);
            ps.setString(3, null);

            ResultSet rs = ps.executeQuery();

            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int userid = rs.getInt("userid");
                    String user = rs.getString("user");
                    String pass = rs.getString("pass");

                    System.out.print("userid: " + userid);
                    System.out.print(", user: " + user);
                    System.out.print(", pass: " + pass + "\n");
                }
            } else {
                System.out.print("No result! ");
            }
            if (!rs.isClosed()) rs.close();
            if (!ps.isClosed()) ps.close();
            if (!conn.isClosed()) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private static void writeCustomer(PreparedStatement ps) throws SQLException {
        ps.setString(1, "3");
        ps.setString(2, "test3");
        ps.setString(3, "1233");
    }

    public static void searchMushafalquran(Mushafalquran_DBModel mushafalquran) {
        try {
            Connection conn = MySqlDatabase.doConnection();
            String sql = "SELECT MushafId,Penerbit,Negara,Versi,TahunPenerbitan,Penyalin,TahunDisahkan,MukaSurat,NamaFail,Direktori FROM mushafalquran ";

            if (mushafalquran.getMushafId() != null || mushafalquran.getPenerbit() != "" || mushafalquran.getNegara() != "" || mushafalquran.getVersi() != "" || mushafalquran.getTahunPenerbitan() != "" || mushafalquran.getPenyalin() != "" || mushafalquran.getTahunDisahkan() != "" || mushafalquran.getMukaSurat() != "" || mushafalquran.getNamaFail() != "" || mushafalquran.getDirektori() != "") {
                sql = sql + " WHERE ";
                boolean andExits = false;

                if (mushafalquran.getMushafId() != null) {
                    if (andExits) {
                        if (mushafalquran.getMushafId() == null)
                            sql = sql + " AND MushafId IS ? ";
                        else
                            sql = sql + " AND MushafId = ? ";
                    } else {
                        if (mushafalquran.getMushafId() == null)
                            sql = sql + " MushafId IS ? ";
                        else
                            sql = sql + " MushafId = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquran.getPenerbit() != "") {
                    if (andExits) {
                        if (mushafalquran.getPenerbit() == null)
                            sql = sql + " AND Penerbit IS ? ";
                        else
                            sql = sql + " AND Penerbit = ? ";
                    } else {
                        if (mushafalquran.getPenerbit() == null)
                            sql = sql + " Penerbit IS ? ";
                        else
                            sql = sql + " Penerbit = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquran.getNegara() != "") {
                    if (andExits) {
                        if (mushafalquran.getNegara() == null)
                            sql = sql + " AND Negara IS ? ";
                        else
                            sql = sql + " AND Negara = ? ";
                    } else {
                        if (mushafalquran.getNegara() == null)
                            sql = sql + " Negara IS ? ";
                        else
                            sql = sql + " Negara = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquran.getVersi() != "") {
                    if (andExits) {
                        if (mushafalquran.getVersi() == null)
                            sql = sql + " AND Versi IS ? ";
                        else
                            sql = sql + " AND Versi = ? ";
                    } else {
                        if (mushafalquran.getVersi() == null)
                            sql = sql + " Versi IS ? ";
                        else
                            sql = sql + " Versi = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquran.getTahunPenerbitan() != "") {
                    if (andExits) {
                        if (mushafalquran.getTahunPenerbitan() == null)
                            sql = sql + " AND TahunPenerbitan IS ? ";
                        else
                            sql = sql + " AND TahunPenerbitan = ? ";
                    } else {
                        if (mushafalquran.getTahunPenerbitan() == null)
                            sql = sql + " TahunPenerbitan IS ? ";
                        else
                            sql = sql + " TahunPenerbitan = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquran.getPenyalin() != "") {
                    if (andExits) {
                        if (mushafalquran.getTahunPenerbitan() == null)
                            sql = sql + " AND TahunPenerbitan IS ? ";
                        else
                            sql = sql + " AND TahunPenerbitan = ? ";
                    } else {
                        if (mushafalquran.getTahunPenerbitan() == null)
                            sql = sql + " TahunPenerbitan IS ? ";
                        else
                            sql = sql + " TahunPenerbitan = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquran.getTahunDisahkan() != "") {
                    if (andExits) {
                        if (mushafalquran.getTahunDisahkan() == null)
                            sql = sql + " AND TahunDisahkan IS ? ";
                        else
                            sql = sql + " AND TahunDisahkan = ? ";
                    } else {
                        if (mushafalquran.getTahunDisahkan() == null)
                            sql = sql + " TahunDisahkan IS ? ";
                        else
                            sql = sql + " TahunDisahkan = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquran.getMukaSurat() != "") {
                    if (andExits) {
                        if (mushafalquran.getMukaSurat() == null)
                            sql = sql + " AND MukaSurat IS ? ";
                        else
                            sql = sql + " AND MukaSurat = ? ";
                    } else {
                        if (mushafalquran.getMukaSurat() == null)
                            sql = sql + " MukaSurat IS ? ";
                        else
                            sql = sql + " MukaSurat = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquran.getNamaFail() != "") {
                    if (andExits) {
                        if (mushafalquran.getNamaFail() == null)
                            sql = sql + " AND NamaFail IS ? ";
                        else
                            sql = sql + " AND NamaFail = ? ";
                    } else {
                        if (mushafalquran.getNamaFail() == null)
                            sql = sql + " NamaFail IS ? ";
                        else
                            sql = sql + " NamaFail = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquran.getDirektori() != "") {
                    if (andExits) {
                        if (mushafalquran.getDirektori() == null)
                            sql = sql + " AND Direktori IS ? ";
                        else
                            sql = sql + " AND Direktori = ? ";
                    } else {
                        if (mushafalquran.getDirektori() == null)
                            sql = sql + " Direktori IS ? ";
                        else
                            sql = sql + " Direktori = ? ";
                        andExits = true;
                    }
                }

            }

            PreparedStatement ps = conn.prepareStatement(sql);

            int parameterIndex = 1;

            if (mushafalquran.getMushafId() != null) {
                if (mushafalquran.getMushafId() == null) {
                    ps.setNull(parameterIndex, java.sql.Types.INTEGER);
                } else {
                    ps.setInt(parameterIndex, mushafalquran.getMushafId());
                }
                parameterIndex++;
            }

            if (mushafalquran.getPenerbit() != "") {
                if (mushafalquran.getPenerbit() == null) {
                    ps.setNull(parameterIndex, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(parameterIndex, mushafalquran.getPenerbit());
                }
                parameterIndex++;
            }

            if (mushafalquran.getNegara() != "") {
                if (mushafalquran.getNegara() == null) {
                    ps.setNull(parameterIndex, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(parameterIndex, mushafalquran.getNegara());
                }
                parameterIndex++;
            }

            if (mushafalquran.getVersi() != "") {
                if (mushafalquran.getVersi() == null) {
                    ps.setNull(parameterIndex, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(parameterIndex, mushafalquran.getVersi());
                }
                parameterIndex++;
            }

            if (mushafalquran.getTahunPenerbitan() != "") {
                if (mushafalquran.getTahunPenerbitan() == null) {
                    ps.setNull(parameterIndex, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(parameterIndex, mushafalquran.getTahunPenerbitan());
                }
                parameterIndex++;
            }

            if (mushafalquran.getPenyalin() != "") {
                if (mushafalquran.getPenyalin() == null) {
                    ps.setNull(parameterIndex, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(parameterIndex, mushafalquran.getPenyalin());
                }
                parameterIndex++;
            }

            if (mushafalquran.getTahunDisahkan() != "") {
                if (mushafalquran.getTahunDisahkan() == null) {
                    ps.setNull(parameterIndex, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(parameterIndex, mushafalquran.getTahunDisahkan());
                }
                parameterIndex++;
            }

            if (mushafalquran.getMukaSurat() != "") {
                if (mushafalquran.getMukaSurat() == null) {
                    ps.setNull(parameterIndex, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(parameterIndex, mushafalquran.getMukaSurat());
                }
                parameterIndex++;
            }

            if (mushafalquran.getNamaFail() != "") {
                if (mushafalquran.getNamaFail() == null) {
                    ps.setNull(parameterIndex, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(parameterIndex, mushafalquran.getNamaFail());
                }
                parameterIndex++;
            }

            if (mushafalquran.getDirektori() != "") {
                if (mushafalquran.getDirektori() == null) {
                    ps.setNull(parameterIndex, java.sql.Types.VARCHAR);
                } else {
                    ps.setString(parameterIndex, mushafalquran.getDirektori());
                }
                parameterIndex++;
            }

            ResultSet rs = ps.executeQuery();


            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    Integer mushafId = rs.getInt("MushafId");
                    String penerbit = rs.getString("Penerbit");
                    String negara = rs.getString("Negara");
                    String versi = rs.getString("Versi");
                    String tahunPenerbitan = rs.getString("TahunPenerbitan");
                    String penyalin = rs.getString("Penyalin");
                    String tahunDisahkan = rs.getString("TahunDisahkan");
                    String mukaSurat = rs.getString("MukaSurat");
                    String namaFail = rs.getString("NamaFail");
                    String direktori = rs.getString("Direktori");

                    System.out.print("mushafId: " + mushafId);
                    System.out.print(", penerbit: " + penerbit);
                    System.out.print(", negara: " + negara);
                    System.out.print(", versi: " + versi);
                    System.out.print(", tahunPenerbitan: " + tahunPenerbitan);
                    System.out.print(", penyalin: " + penyalin);
                    System.out.print(", tahunDisahkan: " + tahunDisahkan);
                    System.out.print(", mukaSurat: " + mukaSurat);
                    System.out.print(", namaFail: " + namaFail);
                    System.out.print(", direktori: " + direktori + "\n");
                }
            } else {
                System.out.print("No result! ");
            }
            if (!rs.isClosed()) rs.close();
            if (!ps.isClosed()) ps.close();
            if (!conn.isClosed()) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
