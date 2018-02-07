package featureTriangle.dbconnection;

import featureTriangle.bean.Bean_Feature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DB_Api {

    String database_table;

    public DB_Api(String database_table) {
        this.database_table = database_table;

    }

    public int updateData(ArrayList<Bean_Feature> list) throws ClassNotFoundException, SQLException {
        Connection con = MyDatabase.doConnection(database_table);
        for (Bean_Feature b : list) {
//			System.out.println("cbya sall :"+b.getsALL_cbya());
            java.sql.PreparedStatement ps = con.prepareStatement("select id from " + database_table + " where fname =?");
            ps.setString(1, b.getFname());
            //"select id, fname from tbl_datasetv2 where fname ='"+b.getFname()+"'"

//			System.out.println("Nilai b : "+b.getFname());
            String nama = b.getFname();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                PreparedStatement ps_update = con.prepareStatement("update " + database_table + " set fname=?, sALL_cbya=?, sALL_abyb=?, sALL_bbyc=?, sALL_A=?, sALL_B=?, sALL_C=?, sALL_GraBA=?, sALL_GraCA=?, sALL_GraBC=?," +
                        "sALR_cbya=?, sALR_abyb=?, sALR_bbyc=?, sALR_A=?, sALR_B=?, sALR_C=?, sALR_GraBA=?, sALR_GraCA=?, sALR_GraBC=?, " +
                        "sARL_cbya=?, sARL_abyb=?, sARL_bbyc=?, sARL_A=?, sARL_B=?, sARL_C=?, sARL_GraBA=?, sARL_GraCA=?, sARL_GraBC=?," +
                        "sARR_cbya=?, sARR_abyb=?, sARR_bbyc=?, sARR_A=?, sARR_B=?, sARR_C=?, sARR_GraBA=?, sARR_GraCA=?, sARR_GraBC=?," +
                        "" +
                        "" +
                        "sBLL_cbya=?, sBLL_abyb=?, sBLL_bbyc=?, sBLL_A=?, sBLL_B=?, sBLL_C=?, sBLL_GraBA=?, sBLL_GraCA=?, sBLL_GraBC=?," +
                        "sBLR_cbya=?, sBLR_abyb=?, sBLR_bbyc=?, sBLR_A=?, sBLR_B=?, sBLR_C=?, sBLR_GraBA=?, sBLR_GraCA=?, sBLR_GraBC=?," +
                        "sBRL_cbya=?, sBRL_abyb=?, sBRL_bbyc=?, sBRL_A=?, sBRL_B=?, sBRL_C=?, sBRL_GraBA=?, sBRL_GraCA=?, sBRL_GraBC=?," +
                        "sBRR_cbya=?, sBRR_abyb=?, sBRR_bbyc=?, sBRR_A=?, sBRR_B=?, sBRR_C=?, sBRR_GraBA=?, sBRR_GraCA=?, sBRR_GraBC=? where fname=?");

                ps_update.setString(1, b.getFname());

                ps_update.setFloat(2, b.getsALL_cbya());
                ps_update.setFloat(3, b.getsALL_abyb());
                ps_update.setFloat(4, b.getsALL_bbyc());
                ps_update.setFloat(5, b.getsALL_A());
                ps_update.setFloat(6, b.getsALL_B());
                ps_update.setFloat(7, b.getsALL_C());
                ps_update.setFloat(8, b.getsALL_GraBA());
                ps_update.setFloat(9, b.getsALL_GraCA());
                ps_update.setFloat(10, b.getsALL_GraBC());

                ps_update.setFloat(11, b.getsALR_cbya());
                ps_update.setFloat(12, b.getsALR_abyb());
                ps_update.setFloat(13, b.getsALR_bbyc());
                ps_update.setFloat(14, b.getsALR_A());
                ps_update.setFloat(15, b.getsALR_B());
                ps_update.setFloat(16, b.getsALR_C());
                ps_update.setFloat(17, b.getsALR_GraBA());
                ps_update.setFloat(18, b.getsALR_GraCA());
                ps_update.setFloat(19, b.getsALR_GraBC());

                ps_update.setFloat(20, b.getsARL_cbya());
                ps_update.setFloat(21, b.getsARL_abyb());
                ps_update.setFloat(22, b.getsARL_bbyc());
                ps_update.setFloat(23, b.getsARL_A());
                ps_update.setFloat(24, b.getsARL_B());
                ps_update.setFloat(25, b.getsARL_C());
                ps_update.setFloat(26, b.getsARL_GraBA());
                ps_update.setFloat(27, b.getsARL_GraCA());
                ps_update.setFloat(28, b.getsARL_GraBC());

                ps_update.setFloat(29, b.getsARR_cbya());
                ps_update.setFloat(30, b.getsARR_abyb());
                ps_update.setFloat(31, b.getsARR_bbyc());
                ps_update.setFloat(32, b.getsARR_A());
                ps_update.setFloat(33, b.getsARR_B());
                ps_update.setFloat(34, b.getsARR_C());
                ps_update.setFloat(35, b.getsARR_GraBA());
                ps_update.setFloat(36, b.getsARR_GraCA());
                ps_update.setFloat(37, b.getsARR_GraBC());


                ps_update.setFloat(38, b.getsBLL_cbya());
                ps_update.setFloat(39, b.getsBLL_abyb());
                ps_update.setFloat(40, b.getsBLL_bbyc());
                ps_update.setFloat(41, b.getsBLL_A());
                ps_update.setFloat(42, b.getsBLL_B());
                ps_update.setFloat(43, b.getsBLL_C());
                ps_update.setFloat(44, b.getsBLL_GraBA());
                ps_update.setFloat(45, b.getsBLL_GraCA());
                ps_update.setFloat(46, b.getsBLL_GraBC());

                ps_update.setFloat(47, b.getsBLR_cbya());
                ps_update.setFloat(48, b.getsBLR_abyb());
                ps_update.setFloat(49, b.getsBLR_bbyc());
                ps_update.setFloat(50, b.getsBLR_A());
                ps_update.setFloat(51, b.getsBLR_B());
                ps_update.setFloat(52, b.getsBLR_C());
                ps_update.setFloat(53, b.getsBLR_GraBA());
                ps_update.setFloat(54, b.getsBLR_GraCA());
                ps_update.setFloat(55, b.getsBLR_GraBC());

                ps_update.setFloat(56, b.getsBRL_cbya());
                ps_update.setFloat(57, b.getsBRL_abyb());
                ps_update.setFloat(58, b.getsBRL_bbyc());
                ps_update.setFloat(59, b.getsBRL_A());
                ps_update.setFloat(60, b.getsBRL_B());
                ps_update.setFloat(61, b.getsBRL_C());
                ps_update.setFloat(62, b.getsBRL_GraBA());
                ps_update.setFloat(63, b.getsBRL_GraCA());
                ps_update.setFloat(64, b.getsBRL_GraBC());

                ps_update.setFloat(65, b.getsBRR_cbya());
                ps_update.setFloat(66, b.getsBRR_abyb());
                ps_update.setFloat(67, b.getsBRR_bbyc());
                ps_update.setFloat(68, b.getsBRR_A());
                ps_update.setFloat(69, b.getsBRR_B());
                ps_update.setFloat(70, b.getsBRR_C());
                ps_update.setFloat(71, b.getsBRR_GraBA());
                ps_update.setFloat(72, b.getsBRR_GraCA());
                ps_update.setFloat(73, b.getsBRR_GraBC());
                ps_update.setString(74, b.getFname());

                ps_update.executeUpdate();
                ps_update.close();
            } else
//				System.out.println("Data Tiada Lagi wei");
                ps.close();
        }
        list.clear();
        con.close();


        return 0;
    }

    public int insertData(ArrayList<Bean_Feature> list) throws ClassNotFoundException, SQLException {
        int flag = 0;
        //String sql1 = "select id, fname from tbl_datasetv2 where fname =?";
        //String sql2 = "insert into tbl_datasetv2 (fname, cbya, abyb, bbyc, A, B,C) values (?,?,?,?,?,?,?)";
        Connection con = MyDatabase.doConnection(database_table);

        for (Bean_Feature b : list) {
            java.sql.PreparedStatement ps = con.prepareStatement("select id from " + database_table + " where fname =?");
            ps.setString(1, b.getFname());
            //"select id, fname from tbl_datasetv2 where fname ='"+b.getFname()+"'"

//			System.out.println("Nilai b : "+b.getFname());

            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return 0;
            else {
//				System.out.println("tak wujud");
                PreparedStatement ps2 = con.prepareStatement("insert into " + database_table + " " +
                        "(fname, cbya, abyb, bbyc, A, B, C, GraBA, GraBC, GraCA," +
                        "pu_cbya, pu_abyb, pu_bbyc, pu_A, pu_B, pu_C, pu_GraBA, pu_GraBC, pu_GraCA," +
                        "pl_cbya, pl_abyb, pl_bbyc, pl_A, pl_B, pl_C, pl_GraBA, pl_GraBC, pl_GraCA," +

                        "tu_cbya, tu_abyb, tu_bbyc, tu_A, tu_B, tu_C, tu_GraBA, tu_GraBC, tu_GraCA," +
                        "tl_cbya, tl_abyb, tl_bbyc, tl_A, tl_B, tl_C, tl_GraBA, tl_GraBC, tl_GraCA," +

                        "bu_cbya, bu_abyb, bu_bbyc, bu_A, bu_B, bu_C, bu_GraBA, bu_GraBC, bu_GraCA," +
                        "bl_cbya, bl_abyb, bl_bbyc, bl_A, bl_B, bl_C, bl_GraBA, bl_GraBC, bl_GraCA," +

                        "p_Lcbya, p_Labyb, p_Lbbyc, p_LA, p_LB,p_LC, p_LGraBA, p_LGraBC, p_LGraCA," +
                        "p_Rcbya, p_Rabyb, p_Rbbyc, p_RA, p_RB,p_RC, p_RGraBA, p_RGraBC, p_RGraCA," +

                        /*
                         * ------------------------------------------
                         * LEFT Zone - left+left & left+right
                         * ------------------------------------------
                         */
                        "LLZ_cbya, LLZ_abyb, LLZ_bbyc, LLZ_A, LLZ_B, LLZ_C, LLZ_GraBA, LLZ_GraBC, LLZ_GraCA," +
                        "LRZ_cbya, LRZ_abyb, LRZ_bbyc, LRZ_A, LRZ_B, LRZ_C, LRZ_GraBA, LRZ_GraBC, LRZ_GraCA," +

                        /*
                         * ------------------------------------------
                         * RIGHT Zone - right+left & right+right
                         * ------------------------------------------
                         */

                        "RLZ_cbya, RLZ_abyb, RLZ_bbyc, RLZ_A, RLZ_B, RLZ_C, RLZ_GraBA, RLZ_GraBC, RLZ_GraCA," +
                        "RRZ_cbya, RRZ_abyb, RRZ_bbyc, RRZ_A, RRZ_B, RRZ_C, RRZ_GraBA, RRZ_GraBC, RRZ_GraCA," +


                        /*
                         * ------------------------------------------
                         * LEFT Zone - left+left & left+right upper and bottom
                         * ------------------------------------------
                         */
                        "LLUZ_cbya, LLUZ_abyb, LLUZ_bbyc, LLUZ_A, LLUZ_B, LLUZ_C, LLUZ_GraBA, LLUZ_GraBC, LLUZ_GraCA," +
                        "LLBZ_cbya, LLBZ_abyb, LLBZ_bbyc, LLBZ_A, LLBZ_B, LLBZ_C, LLBZ_GraBA, LLBZ_GraBC, LLBZ_GraCA," +

                        "LRUZ_cbya, LRUZ_abyb, LRUZ_bbyc, LRUZ_A, LRUZ_B, LRUZ_C, LRUZ_GraBA, LRUZ_GraBC, LRUZ_GraCA," +
                        "LRBZ_cbya, LRBZ_abyb, LRBZ_bbyc, LRBZ_A, LRBZ_B, LRBZ_C, LRBZ_GraBA, LRBZ_GraBC, LRBZ_GraCA," +

                        /*
                         * ------------------------------------------
                         * RIGHT Zone - right+left & right+right upper and bottom
                         * ------------------------------------------
                         */
                        "RLUZ_cbya, RLUZ_abyb, RLUZ_bbyc, RLUZ_A, RLUZ_B, RLUZ_C, RLUZ_GraBA, RLUZ_GraBC, RLUZ_GraCA," +
                        "RLBZ_cbya, RLBZ_abyb, RLBZ_bbyc, RLBZ_A, RLBZ_B, RLBZ_C, RLBZ_GraBA, RLBZ_GraBC, RLBZ_GraCA," +

                        "RRUZ_cbya, RRUZ_abyb, RRUZ_bbyc, RRUZ_A, RRUZ_B, RRUZ_C, RRUZ_GraBA, RRUZ_GraBC, RRUZ_GraCA," +
                        "RRBZ_cbya, RRBZ_abyb, RRBZ_bbyc, RRBZ_A, RRBZ_B, RRBZ_C, RRBZ_GraBA, RRBZ_GraBC, RRBZ_GraCA," +


                        "pul_cbya, pul_abyb, pul_bbyc, pul_A, pul_B,pul_C, pul_GraBA, pul_GraBC, pul_GraCA," +
                        "pur_cbya, pur_abyb, pur_bbyc, pur_A, pur_B, pur_C, pur_GraBA, pur_GraBC, pur_GraCA," +
                        "pll_cbya, pll_abyb, pll_bbyc, pll_A, pll_B, pll_C, pll_GraBA, pll_GraBC, pll_GraCA," +
                        "plr_cbya, plr_abyb, plr_bbyc, plr_A, plr_B, plr_C, plr_GraBA, plr_GraBC, plr_GraCA," +

                        "sALL_cbya, sALL_abyb, sALL_bbyc, sALL_A, sALL_B, sALL_C, sALL_GraBA, sALL_GraBC, sALL_GraCA," +
                        "sALR_cbya, sALR_abyb, sALR_bbyc, sALR_A, sALR_B, sALR_C, sALR_GraBA, sALR_GraBC, sALR_GraCA," +

                        "sARL_cbya, sARL_abyb, sARL_bbyc, sARL_A, sARL_B, sARL_C, sARL_GraBA, sARL_GraBC, sARL_GraCA," +
                        "sARR_cbya, sARR_abyb, sARR_bbyc, sARR_A, sARR_B, sARR_C, sARR_GraBA, sARR_GraBC, sARR_GraCA," +

                        "sBLL_cbya, sBLL_abyb, sBLL_bbyc, sBLL_A, sBLL_B,sBLL_C, sBLL_GraBA, sBLL_GraBC, sBLL_GraCA," +
                        "sBLR_cbya, sBLR_abyb, sBLR_bbyc, sBLR_A, sBLR_B,sBLR_C, sBLR_GraBA, sBLR_GraBC, sBLR_GraCA," +

                        "sBRL_cbya, sBRL_abyb, sBRL_bbyc, sBRL_A, sBRL_B,sBRL_C, sBRL_GraBA, sBRL_GraBC, sBRL_GraCA," +
                        "sBRR_cbya, sBRR_abyb, sBRR_bbyc, sBRR_A, sBRR_B,sBRR_C, sBRR_GraBA, sBRR_GraBC, sBRR_GraCA," +

                        "type) " +
                        "values" +
                        "(?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +

                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +

                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +

                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +

                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +

                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +

                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +

                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +

                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +

                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?," +
                        "?)");

                ps2.setString(1, b.getFname());
                ps2.setFloat(2, b.getCbya());
                ps2.setFloat(3, b.getAbyb());
                ps2.setFloat(4, b.getBbyc());
                ps2.setFloat(5, b.getA());
                ps2.setFloat(6, b.getB());
                ps2.setFloat(7, b.getC());

                ps2.setFloat(8, b.getGraBA());
                ps2.setFloat(9, b.getGraBC());
                ps2.setFloat(10, b.getGraCA());


                ps2.setFloat(11, b.getPu_cbya());
                ps2.setFloat(12, b.getPu_abyb());
                ps2.setFloat(13, b.getPu_bbyc());
                ps2.setFloat(14, b.getPu_A());
                ps2.setFloat(15, b.getPu_B());
                ps2.setFloat(16, b.getPu_C());

                ps2.setFloat(17, b.getPu_GraBA());
                ps2.setFloat(18, b.getPu_GraBC());
                ps2.setFloat(19, b.getPu_GraCA());

                ps2.setFloat(20, b.getPl_cbya());
                ps2.setFloat(21, b.getPl_abyb());
                ps2.setFloat(22, b.getPl_bbyc());
                ps2.setFloat(23, b.getPl_A());
                ps2.setFloat(24, b.getPl_B());
                ps2.setFloat(25, b.getPl_C());

                ps2.setFloat(26, b.getPl_GraBA());
                ps2.setFloat(27, b.getPl_GraBC());
                ps2.setFloat(28, b.getPl_GraCA());


                //tambah top bottom zones
                ps2.setFloat(29, b.getTu_cbya());
                ps2.setFloat(30, b.getTu_abyb());
                ps2.setFloat(31, b.getTu_bbyc());
                ps2.setFloat(32, b.getTu_A());
                ps2.setFloat(33, b.getTu_B());
                ps2.setFloat(34, b.getTu_C());

                ps2.setFloat(35, b.getTu_GraBA());
                ps2.setFloat(36, b.getTu_GraBC());
                ps2.setFloat(37, b.getTu_GraCA());


                ps2.setFloat(38, b.getTl_cbya());
                ps2.setFloat(39, b.getTl_abyb());
                ps2.setFloat(40, b.getTl_bbyc());
                ps2.setFloat(41, b.getTl_A());
                ps2.setFloat(42, b.getTl_B());
                ps2.setFloat(43, b.getTl_C());

                ps2.setFloat(44, b.getTl_GraBA());
                ps2.setFloat(45, b.getTl_GraBC());
                ps2.setFloat(46, b.getTl_GraCA());


                ps2.setFloat(47, b.getBu_cbya());
                ps2.setFloat(48, b.getBu_abyb());
                ps2.setFloat(49, b.getBu_bbyc());
                ps2.setFloat(50, b.getBu_A());
                ps2.setFloat(51, b.getBu_B());
                ps2.setFloat(52, b.getBu_C());

                ps2.setFloat(53, b.getBu_GraBA());
                ps2.setFloat(54, b.getBu_GraBC());
                ps2.setFloat(55, b.getBu_GraCA());


                ps2.setFloat(56, b.getBl_cbya());
                ps2.setFloat(57, b.getBl_abyb());
                ps2.setFloat(58, b.getBl_bbyc());
                ps2.setFloat(59, b.getBl_A());
                ps2.setFloat(60, b.getBl_B());
                ps2.setFloat(61, b.getBl_C());

                ps2.setFloat(62, b.getBl_GraBA());
                ps2.setFloat(63, b.getBl_GraBC());
                ps2.setFloat(64, b.getBl_GraCA());


                //Left Right Zone
                ps2.setFloat(65, b.getP_Lcbya());
                ps2.setFloat(66, b.getP_Labyb());
                ps2.setFloat(67, b.getP_Lbbyc());
                ps2.setFloat(68, b.getP_LA());
                ps2.setFloat(69, b.getP_LB());
                ps2.setFloat(70, b.getP_LC());

                ps2.setFloat(71, b.getP_LGraBA());
                ps2.setFloat(72, b.getP_LGraBC());
                ps2.setFloat(73, b.getP_LGraCA());

                //
                ps2.setFloat(74, b.getP_Rcbya());
                ps2.setFloat(75, b.getP_Rabyb());
                ps2.setFloat(76, b.getP_Rbbyc());
                ps2.setFloat(77, b.getP_RA());
                ps2.setFloat(78, b.getP_RB());
                ps2.setFloat(79, b.getP_RC());

                ps2.setFloat(80, b.getP_RGraBA());
                ps2.setFloat(81, b.getP_RGraBC());
                ps2.setFloat(82, b.getP_RGraCA());


                //tambah 2 sisi bahagi 2
                ps2.setFloat(83, b.getsLLZ_cbya());
                ps2.setFloat(84, b.getsLLZ_abyb());
                ps2.setFloat(85, b.getsLLZ_bbyc());
                ps2.setFloat(86, b.getsLLZ_A());
                ps2.setFloat(87, b.getsLLZ_B());
                ps2.setFloat(88, b.getsLLZ_C());

                ps2.setFloat(89, b.getsLLZ_GraBA());
                ps2.setFloat(90, b.getsLLZ_GraBC());
                ps2.setFloat(91, b.getsLLZ_GraCA());


                ps2.setFloat(92, b.getsLRZ_cbya());
                ps2.setFloat(93, b.getsLRZ_abyb());
                ps2.setFloat(94, b.getsLRZ_bbyc());
                ps2.setFloat(95, b.getsLRZ_A());
                ps2.setFloat(96, b.getsLRZ_B());
                ps2.setFloat(97, b.getsLRZ_C());

                ps2.setFloat(98, b.getsLRZ_GraBA());
                ps2.setFloat(99, b.getsLRZ_GraBC());
                ps2.setFloat(100, b.getsLRZ_GraCA());


                ps2.setFloat(101, b.getsRLZ_cbya());
                ps2.setFloat(102, b.getsRLZ_abyb());
                ps2.setFloat(103, b.getsRLZ_bbyc());
                ps2.setFloat(104, b.getsRLZ_A());
                ps2.setFloat(105, b.getsRLZ_B());
                ps2.setFloat(106, b.getsRLZ_C());

                ps2.setFloat(107, b.getsRLZ_GraBA());
                ps2.setFloat(108, b.getsRLZ_GraBC());
                ps2.setFloat(109, b.getsRLZ_GraCA());


                ps2.setFloat(110, b.getsRRZ_cbya());
                ps2.setFloat(111, b.getsRRZ_abyb());
                ps2.setFloat(112, b.getsRRZ_bbyc());
                ps2.setFloat(113, b.getsRRZ_A());
                ps2.setFloat(114, b.getsRRZ_B());
                ps2.setFloat(115, b.getsRRZ_C());

                ps2.setFloat(116, b.getsRRZ_GraBA());
                ps2.setFloat(117, b.getsRRZ_GraBC());
                ps2.setFloat(118, b.getsRRZ_GraCA());
                //
                /*
                 * ------------------------------------------
                 * LEFT Zone - left+left & left+right upper and bottom
                 * ------------------------------------------
                 */
                //LEFT+LEFT
                ps2.setFloat(119, b.getsLLUZ_cbya());
                ps2.setFloat(120, b.getsLLUZ_abyb());
                ps2.setFloat(121, b.getsLLUZ_bbyc());
                ps2.setFloat(122, b.getsLLUZ_A());
                ps2.setFloat(123, b.getsLLUZ_B());
                ps2.setFloat(124, b.getsLLUZ_C());

                ps2.setFloat(125, b.getsLLUZ_GraBA());
                ps2.setFloat(126, b.getsLLUZ_GraBC());
                ps2.setFloat(127, b.getsLLUZ_GraCA());

                ps2.setFloat(128, b.getsLLBZ_cbya());
                ps2.setFloat(129, b.getsLLBZ_abyb());
                ps2.setFloat(130, b.getsLLBZ_bbyc());
                ps2.setFloat(131, b.getsLLBZ_A());
                ps2.setFloat(132, b.getsLLBZ_B());
                ps2.setFloat(133, b.getsLLBZ_C());

                ps2.setFloat(134, b.getsLLBZ_GraBA());
                ps2.setFloat(135, b.getsLLBZ_GraBC());
                ps2.setFloat(136, b.getsLLBZ_GraCA());

                //LEFT+RIGHT UPPER AND BOTTOM
                ps2.setFloat(137, b.getsLRUZ_cbya());
                ps2.setFloat(138, b.getsLRUZ_abyb());
                ps2.setFloat(139, b.getsLRUZ_bbyc());
                ps2.setFloat(140, b.getsLRUZ_A());
                ps2.setFloat(141, b.getsLRUZ_B());
                ps2.setFloat(142, b.getsLRUZ_C());

                ps2.setFloat(143, b.getsLRUZ_GraBA());
                ps2.setFloat(144, b.getsLRUZ_GraBC());
                ps2.setFloat(145, b.getsLRUZ_GraCA());

                ps2.setFloat(146, b.getsLRBZ_cbya());
                ps2.setFloat(147, b.getsLRBZ_abyb());
                ps2.setFloat(148, b.getsLRBZ_bbyc());
                ps2.setFloat(149, b.getsLRBZ_A());
                ps2.setFloat(150, b.getsLRBZ_B());
                ps2.setFloat(151, b.getsLRBZ_C());

                ps2.setFloat(152, b.getsLRBZ_GraBA());
                ps2.setFloat(153, b.getsLRBZ_GraBC());
                ps2.setFloat(154, b.getsLRBZ_GraCA());

                /*
                 * ------------------------------------------
                 * RIGHT Zone - right+left & right+right upper and bottom
                 * ------------------------------------------
                 */
                //RIGHT+LEFT
                ps2.setFloat(155, b.getsRLUZ_cbya());
                ps2.setFloat(156, b.getsRLUZ_abyb());
                ps2.setFloat(157, b.getsRLUZ_bbyc());
                ps2.setFloat(158, b.getsRLUZ_A());
                ps2.setFloat(159, b.getsRLUZ_B());
                ps2.setFloat(160, b.getsRLUZ_C());

                ps2.setFloat(161, b.getsRLUZ_GraBA());
                ps2.setFloat(162, b.getsRLUZ_GraBC());
                ps2.setFloat(163, b.getsRLUZ_GraCA());

                ps2.setFloat(164, b.getsRLBZ_cbya());
                ps2.setFloat(165, b.getsRLBZ_abyb());
                ps2.setFloat(166, b.getsRLBZ_bbyc());
                ps2.setFloat(167, b.getsRLBZ_A());
                ps2.setFloat(168, b.getsRLBZ_B());
                ps2.setFloat(169, b.getsRLBZ_C());

                ps2.setFloat(170, b.getsRLBZ_GraBA());
                ps2.setFloat(171, b.getsRLBZ_GraBC());
                ps2.setFloat(172, b.getsRLBZ_GraCA());

                //RIGHT+RIGHT UPPER AND BOTTOM
                ps2.setFloat(173, b.getsRRUZ_cbya());
                ps2.setFloat(174, b.getsRRUZ_abyb());
                ps2.setFloat(175, b.getsRRUZ_bbyc());
                ps2.setFloat(176, b.getsRRUZ_A());
                ps2.setFloat(177, b.getsRRUZ_B());
                ps2.setFloat(178, b.getsRRUZ_C());

                ps2.setFloat(179, b.getsRRUZ_GraBA());
                ps2.setFloat(180, b.getsRRUZ_GraBC());
                ps2.setFloat(181, b.getsRRUZ_GraCA());

                ps2.setFloat(182, b.getsRRBZ_cbya());
                ps2.setFloat(183, b.getsRRBZ_abyb());
                ps2.setFloat(184, b.getsRRBZ_bbyc());
                ps2.setFloat(185, b.getsRRBZ_A());
                ps2.setFloat(186, b.getsRRBZ_B());
                ps2.setFloat(187, b.getsRRBZ_C());

                ps2.setFloat(188, b.getsRRBZ_GraBA());
                ps2.setFloat(189, b.getsRRBZ_GraBC());
                ps2.setFloat(190, b.getsRRBZ_GraCA());


                ps2.setFloat(191, b.getPul_cbya());
                ps2.setFloat(192, b.getPul_abyb());
                ps2.setFloat(193, b.getPul_bbyc());
                ps2.setFloat(194, b.getPul_A());
                ps2.setFloat(195, b.getPul_B());
                ps2.setFloat(196, b.getPul_C());

                ps2.setFloat(197, b.getPul_GraBA());
                ps2.setFloat(198, b.getPul_GraBC());
                ps2.setFloat(199, b.getPul_GraCA());

                ps2.setFloat(200, b.getPur_cbya());
                ps2.setFloat(201, b.getPur_abyb());
                ps2.setFloat(202, b.getPur_bbyc());
                ps2.setFloat(203, b.getPur_A());
                ps2.setFloat(204, b.getPur_B());
                ps2.setFloat(205, b.getPur_C());

                ps2.setFloat(206, b.getPur_GraBA());
                ps2.setFloat(207, b.getPur_GraBC());
                ps2.setFloat(208, b.getPur_GraCA());

                ps2.setFloat(209, b.getPll_cbya());
                ps2.setFloat(210, b.getPll_abyb());
                ps2.setFloat(211, b.getPll_bbyc());
                ps2.setFloat(212, b.getPll_A());
                ps2.setFloat(213, b.getPll_B());
                ps2.setFloat(214, b.getPll_C());

                ps2.setFloat(215, b.getPll_GraBA());
                ps2.setFloat(216, b.getPll_GraBC());
                ps2.setFloat(217, b.getPll_GraCA());

                ps2.setFloat(218, b.getPlr_cbya());
                ps2.setFloat(219, b.getPlr_abyb());
                ps2.setFloat(220, b.getPlr_bbyc());
                ps2.setFloat(221, b.getPlr_A());
                ps2.setFloat(222, b.getPlr_B());
                ps2.setFloat(223, b.getPlr_C());

                ps2.setFloat(224, b.getPlr_GraBA());
                ps2.setFloat(225, b.getPlr_GraBC());
                ps2.setFloat(226, b.getPlr_GraCA());

                // Sudut 45 darjah
                ps2.setFloat(227, b.getsALL_cbya());
                ps2.setFloat(228, b.getsALL_abyb());
                ps2.setFloat(229, b.getsALL_bbyc());
                ps2.setFloat(230, b.getsALL_A());
                ps2.setFloat(231, b.getsALL_B());
                ps2.setFloat(232, b.getsALL_C());
                ps2.setFloat(233, b.getsALL_GraBA());
                ps2.setFloat(234, b.getsALL_GraBC());
                ps2.setFloat(235, b.getsALL_GraCA());

                ps2.setFloat(236, b.getsALR_cbya());
                ps2.setFloat(237, b.getsALR_abyb());
                ps2.setFloat(238, b.getsALR_bbyc());
                ps2.setFloat(239, b.getsALR_A());
                ps2.setFloat(240, b.getsALR_B());
                ps2.setFloat(241, b.getsALR_C());
                ps2.setFloat(242, b.getsALR_GraBA());
                ps2.setFloat(243, b.getsALR_GraBC());
                ps2.setFloat(244, b.getsALR_GraCA());

                ps2.setFloat(245, b.getsARL_cbya());
                ps2.setFloat(246, b.getsARL_abyb());
                ps2.setFloat(247, b.getsARL_bbyc());
                ps2.setFloat(248, b.getsARL_A());
                ps2.setFloat(249, b.getsARL_B());
                ps2.setFloat(250, b.getsARL_C());
                ps2.setFloat(251, b.getsARL_GraBA());
                ps2.setFloat(252, b.getsARL_GraBC());
                ps2.setFloat(253, b.getsARL_GraCA());

                ps2.setFloat(254, b.getsARR_cbya());
                ps2.setFloat(255, b.getsARR_abyb());
                ps2.setFloat(256, b.getsARR_bbyc());
                ps2.setFloat(257, b.getsARR_A());
                ps2.setFloat(258, b.getsARR_B());
                ps2.setFloat(259, b.getsARR_C());
                ps2.setFloat(260, b.getsARR_GraBA());
                ps2.setFloat(261, b.getsARR_GraBC());
                ps2.setFloat(262, b.getsARR_GraCA());

                ps2.setFloat(263, b.getsBLL_cbya());
                ps2.setFloat(264, b.getsBLL_abyb());
                ps2.setFloat(265, b.getsBLL_bbyc());
                ps2.setFloat(266, b.getsBLL_A());
                ps2.setFloat(267, b.getsBLL_B());
                ps2.setFloat(268, b.getsBLL_C());
                ps2.setFloat(269, b.getsBLL_GraBA());
                ps2.setFloat(270, b.getsBLL_GraBC());
                ps2.setFloat(271, b.getsBLL_GraCA());

                ps2.setFloat(272, b.getsBLR_cbya());
                ps2.setFloat(273, b.getsBLR_abyb());
                ps2.setFloat(274, b.getsBLR_bbyc());
                ps2.setFloat(275, b.getsBLR_A());
                ps2.setFloat(276, b.getsBLR_B());
                ps2.setFloat(277, b.getsBLR_C());
                ps2.setFloat(278, b.getsBLR_GraBA());
                ps2.setFloat(279, b.getsBLR_GraBC());
                ps2.setFloat(280, b.getsBLR_GraCA());

                ps2.setFloat(281, b.getsBRL_cbya());
                ps2.setFloat(282, b.getsBRL_abyb());
                ps2.setFloat(283, b.getsBRL_bbyc());
                ps2.setFloat(284, b.getsBRL_A());
                ps2.setFloat(285, b.getsBRL_B());
                ps2.setFloat(286, b.getsBRL_C());
                ps2.setFloat(287, b.getsBRL_GraBA());
                ps2.setFloat(288, b.getsBRL_GraBC());
                ps2.setFloat(289, b.getsBRL_GraCA());

                ps2.setFloat(290, b.getsBRR_cbya());
                ps2.setFloat(291, b.getsBRR_abyb());
                ps2.setFloat(292, b.getsBRR_bbyc());
                ps2.setFloat(293, b.getsBRR_A());
                ps2.setFloat(294, b.getsBRR_B());
                ps2.setFloat(295, b.getsBRR_C());
                ps2.setFloat(296, b.getsBRR_GraBA());
                ps2.setFloat(297, b.getsBRR_GraBC());
                ps2.setFloat(298, b.getsBRR_GraCA());

                ps2.setString(299, b.getType());
                //(fname, cbya, abyb, bbyc, A, B,C)
                flag = ps2.executeUpdate();
                ps2.close();
            }

            ps.close();
        }
        list.clear();
        con.close();

        return flag;
    }

//	public ArrayList<Bean> getData() throws ClassNotFoundException, SQLException
//	{
//		ArrayList<Bean> array = new ArrayList<Bean>();
//		Connection conn = MyDatabase.doConnection();
//		Statement statement = conn.createStatement();
//		ResultSet rs = statement.executeQuery("select * from tbl_datasetv2");
//		while(rs.next())
//		{
//			Bean b = new Bean();
//			b.setFname(rs.getString(2));
//
//			b.setCbya(rs.getFloat(3));
//			b.setAbyb(rs.getFloat(4));
//			b.setBbyc(rs.getFloat(5));
//			b.setA(rs.getFloat(6));
//			b.setB(rs.getFloat(7));
//			b.setC(rs.getFloat(8));
//
//			b.setPul_cbya(rs.getFloat(9));
//			b.setPul_abyb(rs.getFloat(10));
//			b.setPul_bbyc(rs.getFloat(11));
//			b.setPul_A(rs.getFloat(12));
//			b.setPul_B(rs.getFloat(13));
//			b.setPul_C(rs.getFloat(14));
//
//			b.setPur_cbya(rs.getFloat(15));
//			b.setPur_abyb(rs.getFloat(16));
//			b.setPur_bbyc(rs.getFloat(17));
//			b.setPur_A(rs.getFloat(18));
//			b.setPur_B(rs.getFloat(19));
//			b.setPur_C(rs.getFloat(20));
//
//			b.setPll_cbya(rs.getFloat(21));
//			b.setPll_abyb(rs.getFloat(22));
//			b.setPll_bbyc(rs.getFloat(23));
//			b.setPll_A(rs.getFloat(24));
//			b.setPll_B(rs.getFloat(25));
//			b.setPll_C(rs.getFloat(26));
//
//			b.setPlr_cbya(rs.getFloat(27));
//			b.setPlr_abyb(rs.getFloat(28));
//			b.setPlr_bbyc(rs.getFloat(29));
//			b.setPlr_A(rs.getFloat(30));
//			b.setPlr_B(rs.getFloat(31));
//			b.setPlr_C(rs.getFloat(32));
//
//
//
//			b.setType(rs.getString(33));
//
//			array.add(b);
//
//		}
//		return array;
//
//	}
//


    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		DB_Api db = new DB_Api();
//		ArrayList<Bean_Feature> arr = new ArrayList<Bean_Feature>();
//		Bean_Feature z = new Bean_Feature();
//		z.setFname("aisyah");
//		z.setCbya(2.1f);
//		z.setAbyb(2.1f);
//		z.setBbyc(2.1f);
//		z.setA(3.1f);
//		z.setB(3.1f);
//		z.setC(3.1f);
//
//		Bean_Feature z1 = new Bean_Feature();
//		z1.setFname("khadijah");
//		z1.setCbya(2.1f);
//		z1.setAbyb(2.1f);
//		z1.setBbyc(2.1f);
//		z1.setA(3.1f);
//		z1.setB(3.1f);
//		z1.setC(3.1f);
//
//		Bean_Feature z2 = new Bean_Feature();
//		z2.setFname("asmak");
//		z2.setCbya(2.1f);
//		z2.setAbyb(2.1f);
//		z2.setBbyc(2.1f);
//		z2.setA(3.1f);
//		z2.setB(3.1f);
//		z2.setC(3.1f);
//
//
//		arr.add(z);
//		arr.add(z1);
//		arr.add(z2);
//		System.out.println("isi : "+db.insertData(arr));


    }
}
