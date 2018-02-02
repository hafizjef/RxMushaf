package model;

public class Bean_Feature {

    String fname;    //1

    //General Part
    /*
     * 1|1
     * 1|1
     */
    float cbya;                 //2
    float abyb;                 //3
    float bbyc;                 //4
    float A;                 //5
    float B;                 //6
    float C;                 //7
    float GraBA;
    float GraCA;
    float GraBC;

    /*
     * Upper Zone
     */

    float pu_cbya;              //2
    float pu_abyb;              //3
    float pu_bbyc;              //4
    float pu_A;                  //5
    float pu_B;                  //6
    float pu_C;                  //7
    float pu_GraBA;
    float pu_GraCA;
    float pu_GraBC;

    /*
     * Lower Zone
     */

    float pl_cbya;              //2
    float pl_abyb;              //3
    float pl_bbyc;              //4
    float pl_A;                  //5
    float pl_B;                  //6
    float pl_C;                  //7
    float pl_GraBA;
    float pl_GraCA;
    float pl_GraBC;

    /*
     * Top Upper
     */

    float tu_cbya;               //2
    float tu_abyb;               //3
    float tu_bbyc;               //4
    float tu_A;                   //5
    float tu_B;                   //6
    float tu_C;                   //7
    float tu_GraBA;
    float tu_GraCA;
    float tu_GraBC;

    /*
     * Top Lower
     */

    float tl_cbya;               //2
    float tl_abyb;               //3
    float tl_bbyc;               //4
    float tl_A;                   //5
    float tl_B;                   //6
    float tl_C;                   //7
    float tl_GraBA;
    float tl_GraCA;
    float tl_GraBC;

    /*
     * Bottom Upper
     */

    float bu_cbya;               //2
    float bu_abyb;               //3
    float bu_bbyc;               //4
    float bu_A;                   //5
    float bu_B;                   //6
    float bu_C;                   //7
    float bu_GraBA;
    float bu_GraCA;
    float bu_GraBC;

    /*
     * Bottom Lower
     */

    float bl_cbya;               //2
    float bl_abyb;               //3
    float bl_bbyc;               //4
    float bl_A;                   //5
    float bl_B;                   //6
    float bl_C;                   //7
    float bl_GraBA;
    float bl_GraCA;
    float bl_GraBC;


    // Point Left
    float p_Lcbya;               //2
    float p_Labyb;               //3
    float p_Lbbyc;               //4
    float p_LA;                   //5
    float p_LB;                   //6
    float p_LC;                   //7
    float p_LGraBA;
    float p_LGraCA;
    float p_LGraBC;

    // Point Right
    float p_Rcbya;               //2
    float p_Rabyb;               //3
    float p_Rbbyc;               //4
    float p_RA;                   //5
    float p_RB;                   //6
    float p_RC;                   //7
    float p_RGraBA;
    float p_RGraCA;
    float p_RGraBC;

    //Sudut Left Left Zone
    float sLLZ_cbya;           //8
    float sLLZ_abyb;           //9
    float sLLZ_bbyc;           //10
    float sLLZ_A;               //11
    float sLLZ_B;               //12
    float sLLZ_C;               //13
    float sLLZ_GraBA;
    float sLLZ_GraCA;
    float sLLZ_GraBC;

    //Sudut Left Right Zone
    float sLRZ_cbya;           //8
    float sLRZ_abyb;           //9
    float sLRZ_bbyc;           //10
    float sLRZ_A;               //11
    float sLRZ_B;               //12
    float sLRZ_C;               //13
    float sLRZ_GraBA;
    float sLRZ_GraCA;
    float sLRZ_GraBC;

    //Sudut Right Left Zone
    float sRLZ_cbya;            //8
    float sRLZ_abyb;            //9
    float sRLZ_bbyc;            //10
    float sRLZ_A;                //11
    float sRLZ_B;                //12
    float sRLZ_C;                //13
    float sRLZ_GraBA;
    float sRLZ_GraCA;
    float sRLZ_GraBC;

    //Sudut Right Right Zone
    float sRRZ_cbya;            //8
    float sRRZ_abyb;            //9
    float sRRZ_bbyc;            //10
    float sRRZ_A;                //11
    float sRRZ_B;                //12
    float sRRZ_C;                //13
    float sRRZ_GraBA;
    float sRRZ_GraCA;
    float sRRZ_GraBC;

    /*
     * Features under Left Zone and Right Zone
     */

    // Sudut Left Left Upper Zone
    float sLLUZ_cbya;
    float sLLUZ_abyb;
    float sLLUZ_bbyc;
    float sLLUZ_A;
    float sLLUZ_B;
    float sLLUZ_C;
    float sLLUZ_GraBA;
    float sLLUZ_GraBC;
    float sLLUZ_GraCA;

    // Sudut Left Left Bottom ZOne
    float sLLBZ_cbya;
    float sLLBZ_abyb;
    float sLLBZ_bbyc;
    float sLLBZ_A;
    float sLLBZ_B;
    float sLLBZ_C;
    float sLLBZ_GraBA;
    float sLLBZ_GraBC;
    float sLLBZ_GraCA;

    // Sudut Left Right Upper Zone
    float sLRUZ_cbya;
    float sLRUZ_abyb;
    float sLRUZ_bbyc;
    float sLRUZ_A;
    float sLRUZ_B;
    float sLRUZ_C;
    float sLRUZ_GraBA;
    float sLRUZ_GraBC;
    float sLRUZ_GraCA;

    // Sudut Left Right Bottom Zone
    float sLRBZ_cbya;
    float sLRBZ_abyb;
    float sLRBZ_bbyc;
    float sLRBZ_A;
    float sLRBZ_B;
    float sLRBZ_C;
    float sLRBZ_GraBA;
    float sLRBZ_GraBC;
    float sLRBZ_GraCA;

    /*
     * ------------------------------------------------------------
     * Right Zone left and Right Zone Right
     * ------------------------------------------------------------
     */

    // Sudut Right Left Upper Zone
    float sRLUZ_cbya;
    float sRLUZ_abyb;
    float sRLUZ_bbyc;
    float sRLUZ_A;
    float sRLUZ_B;
    float sRLUZ_C;
    float sRLUZ_GraBA;
    float sRLUZ_GraBC;
    float sRLUZ_GraCA;

    // Sudut Right Left Bottom Zone
    float sRLBZ_cbya;
    float sRLBZ_abyb;
    float sRLBZ_bbyc;
    float sRLBZ_A;
    float sRLBZ_B;
    float sRLBZ_C;
    float sRLBZ_GraBA;
    float sRLBZ_GraBC;
    float sRLBZ_GraCA;

    // Sudut Right Right Upper Zone
    float sRRUZ_cbya;
    float sRRUZ_abyb;
    float sRRUZ_bbyc;
    float sRRUZ_A;
    float sRRUZ_B;
    float sRRUZ_C;
    float sRRUZ_GraBA;
    float sRRUZ_GraBC;
    float sRRUZ_GraCA;

    // Sudut Right Right Bottom Zone
    float sRRBZ_cbya;
    float sRRBZ_abyb;
    float sRRBZ_bbyc;
    float sRRBZ_A;
    float sRRBZ_B;
    float sRRBZ_C;
    float sRRBZ_GraBA;
    float sRRBZ_GraBC;
    float sRRBZ_GraCA;


    /*
     * 1|0
     * 0|0
     */
    float pul_cbya;        //8
    float pul_abyb;        //9
    float pul_bbyc;        //10
    float pul_A;        //11
    float pul_B;        //12
    float pul_C;        //13
    float pul_GraBA;
    float pul_GraCA;
    float pul_GraBC;


    /*
     * 0|1
     * 0|0
     */
    float pur_cbya;        //14
    float pur_abyb;        //15
    float pur_bbyc;        //16
    float pur_A;        //17
    float pur_B;        //18
    float pur_C;        //19
    float pur_GraBA;
    float pur_GraCA;
    float pur_GraBC;
    /*
     * 0|0
     * 1|0
     */
    float pll_cbya;        //20
    float pll_abyb;        //21
    float pll_bbyc;        //22
    float pll_A;        //23
    float pll_B;        //24
    float pll_C;        //25
    float pll_GraBA;
    float pll_GraCA;
    float pll_GraBC;
    /*
     * 0|0
     * 0|1
     */
    float plr_cbya;        //26
    float plr_abyb;        //27
    float plr_bbyc;        //28
    float plr_A;        //29
    float plr_B;        //30
    float plr_C;        //31
    float plr_GraBA;
    float plr_GraCA;
    float plr_GraBC;


    //feature 45 darjah atas

    // Sudut Atas Left Left
    float sALL_cbya;
    float sALL_abyb;
    float sALL_bbyc;
    float sALL_A;
    float sALL_B;
    float sALL_C;
    float sALL_GraBA;
    float sALL_GraCA;
    float sALL_GraBC;

    // Sudut Atas Left Right
    float sALR_cbya;
    float sALR_abyb;
    float sALR_bbyc;
    float sALR_A;
    float sALR_B;
    float sALR_C;
    float sALR_GraBA;
    float sALR_GraCA;
    float sALR_GraBC;

    // Sudut Atas Right Left
    float sARL_cbya;
    float sARL_abyb;
    float sARL_bbyc;
    float sARL_A;
    float sARL_B;
    float sARL_C;
    float sARL_GraBA;
    float sARL_GraCA;
    float sARL_GraBC;

    // Sudut Atas Right Right
    float sARR_cbya;
    float sARR_abyb;
    float sARR_bbyc;
    float sARR_A;
    float sARR_B;
    float sARR_C;
    float sARR_GraBA;
    float sARR_GraCA;
    float sARR_GraBC;


    //feature 45 darjah bawah

    // Sudut Bawah Left Left
    float sBLL_cbya;
    float sBLL_abyb;
    float sBLL_bbyc;
    float sBLL_A;
    float sBLL_B;
    float sBLL_C;
    float sBLL_GraBA;
    float sBLL_GraCA;
    float sBLL_GraBC;

    // Sudut Bawah Left Right
    float sBLR_cbya;
    float sBLR_abyb;
    float sBLR_bbyc;
    float sBLR_A;
    float sBLR_B;
    float sBLR_C;
    float sBLR_GraBA;
    float sBLR_GraCA;
    float sBLR_GraBC;

    // Sudut Bawah Right Left
    float sBRL_cbya;
    float sBRL_abyb;
    float sBRL_bbyc;
    float sBRL_A;
    float sBRL_B;
    float sBRL_C;
    float sBRL_GraBA;
    float sBRL_GraCA;
    float sBRL_GraBC;

    // Sudut Bawah Right Right
    float sBRR_cbya;
    float sBRR_abyb;
    float sBRR_bbyc;
    float sBRR_A;
    float sBRR_B;
    float sBRR_C;
    float sBRR_GraBA;
    float sBRR_GraCA;
    float sBRR_GraBC;

    String Type;        //32


    public float getTu_cbya() {
        return tu_cbya;
    }

    public void setTu_cbya(float tu_cbya) {
        this.tu_cbya = tu_cbya;
    }

    public float getTu_abyb() {
        return tu_abyb;
    }

    public void setTu_abyb(float tu_abyb) {
        this.tu_abyb = tu_abyb;
    }

    public float getTu_bbyc() {
        return tu_bbyc;
    }

    public void setTu_bbyc(float tu_bbyc) {
        this.tu_bbyc = tu_bbyc;
    }

    public float getTu_A() {
        return tu_A;
    }

    public void setTu_A(float tu_A) {
        this.tu_A = tu_A;
    }

    public float getTu_B() {
        return tu_B;
    }

    public void setTu_B(float tu_B) {
        this.tu_B = tu_B;
    }

    public float getTu_C() {
        return tu_C;
    }

    public void setTu_C(float tu_C) {
        this.tu_C = tu_C;
    }

    public float getTu_GraBA() {
        return tu_GraBA;
    }

    public void setTu_GraBA(float tu_GraBA) {
        this.tu_GraBA = tu_GraBA;
    }

    public float getTu_GraCA() {
        return tu_GraCA;
    }

    public void setTu_GraCA(float tu_GraCA) {
        this.tu_GraCA = tu_GraCA;
    }

    public float getTu_GraBC() {
        return tu_GraBC;
    }

    public void setTu_GraBC(float tu_GraBC) {
        this.tu_GraBC = tu_GraBC;
    }

    public float getTl_cbya() {
        return tl_cbya;
    }

    public void setTl_cbya(float tl_cbya) {
        this.tl_cbya = tl_cbya;
    }

    public float getTl_abyb() {
        return tl_abyb;
    }

    public void setTl_abyb(float tl_abyb) {
        this.tl_abyb = tl_abyb;
    }

    public float getTl_bbyc() {
        return tl_bbyc;
    }

    public void setTl_bbyc(float tl_bbyc) {
        this.tl_bbyc = tl_bbyc;
    }

    public float getTl_A() {
        return tl_A;
    }

    public void setTl_A(float tl_A) {
        this.tl_A = tl_A;
    }

    public float getTl_B() {
        return tl_B;
    }

    public void setTl_B(float tl_B) {
        this.tl_B = tl_B;
    }

    public float getTl_C() {
        return tl_C;
    }

    public void setTl_C(float tl_C) {
        this.tl_C = tl_C;
    }

    public float getTl_GraBA() {
        return tl_GraBA;
    }

    public void setTl_GraBA(float tl_GraBA) {
        this.tl_GraBA = tl_GraBA;
    }

    public float getTl_GraCA() {
        return tl_GraCA;
    }

    public void setTl_GraCA(float tl_GraCA) {
        this.tl_GraCA = tl_GraCA;
    }

    public float getTl_GraBC() {
        return tl_GraBC;
    }

    public void setTl_GraBC(float tl_GraBC) {
        this.tl_GraBC = tl_GraBC;
    }

    public float getBu_cbya() {
        return bu_cbya;
    }

    public void setBu_cbya(float bu_cbya) {
        this.bu_cbya = bu_cbya;
    }

    public float getBu_abyb() {
        return bu_abyb;
    }

    public void setBu_abyb(float bu_abyb) {
        this.bu_abyb = bu_abyb;
    }

    public float getBu_bbyc() {
        return bu_bbyc;
    }

    public void setBu_bbyc(float bu_bbyc) {
        this.bu_bbyc = bu_bbyc;
    }

    public float getBu_A() {
        return bu_A;
    }

    public void setBu_A(float bu_A) {
        this.bu_A = bu_A;
    }

    public float getBu_B() {
        return bu_B;
    }

    public void setBu_B(float bu_B) {
        this.bu_B = bu_B;
    }

    public float getBu_C() {
        return bu_C;
    }

    public void setBu_C(float bu_C) {
        this.bu_C = bu_C;
    }

    public float getBu_GraBA() {
        return bu_GraBA;
    }

    public void setBu_GraBA(float bu_GraBA) {
        this.bu_GraBA = bu_GraBA;
    }

    public float getBu_GraCA() {
        return bu_GraCA;
    }

    public void setBu_GraCA(float bu_GraCA) {
        this.bu_GraCA = bu_GraCA;
    }

    public float getBu_GraBC() {
        return bu_GraBC;
    }

    public void setBu_GraBC(float bu_GraBC) {
        this.bu_GraBC = bu_GraBC;
    }

    public float getBl_cbya() {
        return bl_cbya;
    }

    public void setBl_cbya(float bl_cbya) {
        this.bl_cbya = bl_cbya;
    }

    public float getBl_abyb() {
        return bl_abyb;
    }

    public void setBl_abyb(float bl_abyb) {
        this.bl_abyb = bl_abyb;
    }

    public float getBl_bbyc() {
        return bl_bbyc;
    }

    public void setBl_bbyc(float bl_bbyc) {
        this.bl_bbyc = bl_bbyc;
    }

    public float getBl_A() {
        return bl_A;
    }

    public void setBl_A(float bl_A) {
        this.bl_A = bl_A;
    }

    public float getBl_B() {
        return bl_B;
    }

    public void setBl_B(float bl_B) {
        this.bl_B = bl_B;
    }

    public float getBl_C() {
        return bl_C;
    }

    public void setBl_C(float bl_C) {
        this.bl_C = bl_C;
    }

    public float getBl_GraBA() {
        return bl_GraBA;
    }

    public void setBl_GraBA(float bl_GraBA) {
        this.bl_GraBA = bl_GraBA;
    }

    public float getBl_GraCA() {
        return bl_GraCA;
    }

    public void setBl_GraCA(float bl_GraCA) {
        this.bl_GraCA = bl_GraCA;
    }

    public float getBl_GraBC() {
        return bl_GraBC;
    }

    public void setBl_GraBC(float bl_GraBC) {
        this.bl_GraBC = bl_GraBC;
    }

    /*
     * Left
     */


    public float getsLLZ_cbya() {
        return sLLZ_cbya;
    }

    public void setsLLZ_cbya(float sLLZ_cbya) {
        this.sLLZ_cbya = sLLZ_cbya;
    }

    public float getsLLZ_abyb() {
        return sLLZ_abyb;
    }

    public void setsLLZ_abyb(float sLLZ_abyb) {
        this.sLLZ_abyb = sLLZ_abyb;
    }

    public float getsLLZ_bbyc() {
        return sLLZ_bbyc;
    }

    public void setsLLZ_bbyc(float sLLZ_bbyc) {
        this.sLLZ_bbyc = sLLZ_bbyc;
    }

    public float getsLLZ_A() {
        return sLLZ_A;
    }

    public void setsLLZ_A(float sLLZ_A) {
        this.sLLZ_A = sLLZ_A;
    }

    public float getsLLZ_B() {
        return sLLZ_B;
    }

    public void setsLLZ_B(float sLLZ_B) {
        this.sLLZ_B = sLLZ_B;
    }

    public float getsLLZ_C() {
        return sLLZ_C;
    }

    public void setsLLZ_C(float sLLZ_C) {
        this.sLLZ_C = sLLZ_C;
    }

    public float getsLLZ_GraBA() {
        return sLLZ_GraBA;
    }

    public void setsLLZ_GraBA(float sLLZ_GraBA) {
        this.sLLZ_GraBA = sLLZ_GraBA;
    }

    public float getsLLZ_GraCA() {
        return sLLZ_GraCA;
    }

    public void setsLLZ_GraCA(float sLLZ_GraCA) {
        this.sLLZ_GraCA = sLLZ_GraCA;
    }

    public float getsLLZ_GraBC() {
        return sLLZ_GraBC;
    }

    public void setsLLZ_GraBC(float sLLZ_GraBC) {
        this.sLLZ_GraBC = sLLZ_GraBC;
    }

    public float getsLRZ_cbya() {
        return sLRZ_cbya;
    }

    public void setsLRZ_cbya(float sLRZ_cbya) {
        this.sLRZ_cbya = sLRZ_cbya;
    }

    public float getsLRZ_abyb() {
        return sLRZ_abyb;
    }

    public void setsLRZ_abyb(float sLRZ_abyb) {
        this.sLRZ_abyb = sLRZ_abyb;
    }

    public float getsLRZ_bbyc() {
        return sLRZ_bbyc;
    }

    public void setsLRZ_bbyc(float sLRZ_bbyc) {
        this.sLRZ_bbyc = sLRZ_bbyc;
    }

    public float getsLRZ_A() {
        return sLRZ_A;
    }

    public void setsLRZ_A(float sLRZ_A) {
        this.sLRZ_A = sLRZ_A;
    }

    public float getsLRZ_B() {
        return sLRZ_B;
    }

    public void setsLRZ_B(float sLRZ_B) {
        this.sLRZ_B = sLRZ_B;
    }

    public float getsLRZ_C() {
        return sLRZ_C;
    }

    public void setsLRZ_C(float sLRZ_C) {
        this.sLRZ_C = sLRZ_C;
    }

    public float getsLRZ_GraBA() {
        return sLRZ_GraBA;
    }

    public void setsLRZ_GraBA(float sLRZ_GraBA) {
        this.sLRZ_GraBA = sLRZ_GraBA;
    }

    public float getsLRZ_GraCA() {
        return sLRZ_GraCA;
    }

    public void setsLRZ_GraCA(float sLRZ_GraCA) {
        this.sLRZ_GraCA = sLRZ_GraCA;
    }

    public float getsLRZ_GraBC() {
        return sLRZ_GraBC;
    }

    public void setsLRZ_GraBC(float sLRZ_GraBC) {
        this.sLRZ_GraBC = sLRZ_GraBC;
    }

    public float getsRLZ_cbya() {
        return sRLZ_cbya;
    }

    public void setsRLZ_cbya(float sRLZ_cbya) {
        this.sRLZ_cbya = sRLZ_cbya;
    }

    public float getsRLZ_abyb() {
        return sRLZ_abyb;
    }

    public void setsRLZ_abyb(float sRLZ_abyb) {
        this.sRLZ_abyb = sRLZ_abyb;
    }

    public float getsRLZ_bbyc() {
        return sRLZ_bbyc;
    }

    public void setsRLZ_bbyc(float sRLZ_bbyc) {
        this.sRLZ_bbyc = sRLZ_bbyc;
    }

    public float getsRLZ_A() {
        return sRLZ_A;
    }

    public void setsRLZ_A(float sRLZ_A) {
        this.sRLZ_A = sRLZ_A;
    }

    public float getsRLZ_B() {
        return sRLZ_B;
    }

    public void setsRLZ_B(float sRLZ_B) {
        this.sRLZ_B = sRLZ_B;
    }

    public float getsRLZ_C() {
        return sRLZ_C;
    }

    public void setsRLZ_C(float sRLZ_C) {
        this.sRLZ_C = sRLZ_C;
    }

    public float getsRLZ_GraBA() {
        return sRLZ_GraBA;
    }

    public void setsRLZ_GraBA(float sRLZ_GraBA) {
        this.sRLZ_GraBA = sRLZ_GraBA;
    }

    public float getsRLZ_GraCA() {
        return sRLZ_GraCA;
    }

    public void setsRLZ_GraCA(float sRLZ_GraCA) {
        this.sRLZ_GraCA = sRLZ_GraCA;
    }

    public float getsRLZ_GraBC() {
        return sRLZ_GraBC;
    }

    public void setsRLZ_GraBC(float sRLZ_GraBC) {
        this.sRLZ_GraBC = sRLZ_GraBC;
    }

    public float getsRRZ_cbya() {
        return sRRZ_cbya;
    }

    public void setsRRZ_cbya(float sRRZ_cbya) {
        this.sRRZ_cbya = sRRZ_cbya;
    }

    public float getsRRZ_abyb() {
        return sRRZ_abyb;
    }

    public void setsRRZ_abyb(float sRRZ_abyb) {
        this.sRRZ_abyb = sRRZ_abyb;
    }

    public float getsRRZ_bbyc() {
        return sRRZ_bbyc;
    }

    public void setsRRZ_bbyc(float sRRZ_bbyc) {
        this.sRRZ_bbyc = sRRZ_bbyc;
    }

    public float getsRRZ_A() {
        return sRRZ_A;
    }

    public void setsRRZ_A(float sRRZ_A) {
        this.sRRZ_A = sRRZ_A;
    }

    public float getsRRZ_B() {
        return sRRZ_B;
    }

    public void setsRRZ_B(float sRRZ_B) {
        this.sRRZ_B = sRRZ_B;
    }

    public float getsRRZ_C() {
        return sRRZ_C;
    }

    public void setsRRZ_C(float sRRZ_C) {
        this.sRRZ_C = sRRZ_C;
    }

    public float getsRRZ_GraBA() {
        return sRRZ_GraBA;
    }

    public void setsRRZ_GraBA(float sRRZ_GraBA) {
        this.sRRZ_GraBA = sRRZ_GraBA;
    }

    public float getsRRZ_GraCA() {
        return sRRZ_GraCA;
    }

    public void setsRRZ_GraCA(float sRRZ_GraCA) {
        this.sRRZ_GraCA = sRRZ_GraCA;
    }

    public float getsRRZ_GraBC() {
        return sRRZ_GraBC;
    }

    public void setsRRZ_GraBC(float sRRZ_GraBC) {
        this.sRRZ_GraBC = sRRZ_GraBC;
    }


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public float getCbya() {
        return cbya;
    }

    public void setCbya(float cbya) {
        this.cbya = cbya;
    }

    public float getAbyb() {
        return abyb;
    }

    public void setAbyb(float abyb) {
        this.abyb = abyb;
    }

    public float getBbyc() {
        return bbyc;
    }

    public void setBbyc(float bbyc) {
        this.bbyc = bbyc;
    }

    public float getA() {
        return A;
    }

    public void setA(float a) {
        A = a;
    }

    public float getB() {
        return B;
    }

    public void setB(float b) {
        B = b;
    }

    public float getC() {
        return C;
    }

    public void setC(float c) {
        C = c;
    }

    public float getGraBA() {
        return GraBA;
    }

    public void setGraBA(float graBA) {
        GraBA = graBA;
    }

    public float getGraCA() {
        return GraCA;
    }

    public void setGraCA(float graCA) {
        GraCA = graCA;
    }

    public float getGraBC() {
        return GraBC;
    }

    public void setGraBC(float graBC) {
        GraBC = graBC;
    }


    public float getP_Lcbya() {
        return p_Lcbya;
    }

    public void setP_Lcbya(float p_Lcbya) {
        this.p_Lcbya = p_Lcbya;
    }

    public float getP_Labyb() {
        return p_Labyb;
    }

    public void setP_Labyb(float p_Labyb) {
        this.p_Labyb = p_Labyb;
    }

    public float getP_Lbbyc() {
        return p_Lbbyc;
    }

    public void setP_Lbbyc(float p_Lbbyc) {
        this.p_Lbbyc = p_Lbbyc;
    }

    public float getP_LA() {
        return p_LA;
    }

    public void setP_LA(float p_LA) {
        this.p_LA = p_LA;
    }

    public float getP_LB() {
        return p_LB;
    }

    public void setP_LB(float p_LB) {
        this.p_LB = p_LB;
    }

    public float getP_LC() {
        return p_LC;
    }

    public void setP_LC(float p_LC) {
        this.p_LC = p_LC;
    }

    public float getP_LGraBA() {
        return p_LGraBA;
    }

    public void setP_LGraBA(float p_LGraBA) {
        this.p_LGraBA = p_LGraBA;
    }

    public float getP_LGraCA() {
        return p_LGraCA;
    }

    public void setP_LGraCA(float p_LGraCA) {
        this.p_LGraCA = p_LGraCA;
    }

    public float getP_LGraBC() {
        return p_LGraBC;
    }

    public void setP_LGraBC(float p_LGraBC) {
        this.p_LGraBC = p_LGraBC;
    }

    public float getP_Rcbya() {
        return p_Rcbya;
    }

    public void setP_Rcbya(float p_Rcbya) {
        this.p_Rcbya = p_Rcbya;
    }

    public float getP_Rabyb() {
        return p_Rabyb;
    }

    public void setP_Rabyb(float p_Rabyb) {
        this.p_Rabyb = p_Rabyb;
    }

    public float getP_Rbbyc() {
        return p_Rbbyc;
    }

    public void setP_Rbbyc(float p_Rbbyc) {
        this.p_Rbbyc = p_Rbbyc;
    }

    public float getP_RA() {
        return p_RA;
    }

    public void setP_RA(float p_RA) {
        this.p_RA = p_RA;
    }

    public float getP_RB() {
        return p_RB;
    }

    public void setP_RB(float p_RB) {
        this.p_RB = p_RB;
    }

    public float getP_RC() {
        return p_RC;
    }

    public void setP_RC(float p_RC) {
        this.p_RC = p_RC;
    }

    public float getP_RGraBA() {
        return p_RGraBA;
    }

    public void setP_RGraBA(float p_RGraBA) {
        this.p_RGraBA = p_RGraBA;
    }

    public float getP_RGraCA() {
        return p_RGraCA;
    }

    public void setP_RGraCA(float p_RGraCA) {
        this.p_RGraCA = p_RGraCA;
    }

    public float getP_RGraBC() {
        return p_RGraBC;
    }

    public void setP_RGraBC(float p_RGraBC) {
        this.p_RGraBC = p_RGraBC;
    }


    public float getPu_cbya() {
        return pu_cbya;
    }

    public void setPu_cbya(float pu_cbya) {
        this.pu_cbya = pu_cbya;
    }

    public float getPu_abyb() {
        return pu_abyb;
    }

    public void setPu_abyb(float pu_abyb) {
        this.pu_abyb = pu_abyb;
    }

    public float getPu_bbyc() {
        return pu_bbyc;
    }

    public void setPu_bbyc(float pu_bbyc) {
        this.pu_bbyc = pu_bbyc;
    }

    public float getPu_A() {
        return pu_A;
    }

    public void setPu_A(float pu_A) {
        this.pu_A = pu_A;
    }

    public float getPu_B() {
        return pu_B;
    }

    public void setPu_B(float pu_B) {
        this.pu_B = pu_B;
    }

    public float getPu_C() {
        return pu_C;
    }

    public void setPu_C(float pu_C) {
        this.pu_C = pu_C;
    }

    public float getPu_GraBA() {
        return pu_GraBA;
    }

    public void setPu_GraBA(float pu_GraBA) {
        this.pu_GraBA = pu_GraBA;
    }

    public float getPu_GraCA() {
        return pu_GraCA;
    }

    public void setPu_GraCA(float pu_GraCA) {
        this.pu_GraCA = pu_GraCA;
    }

    public float getPu_GraBC() {
        return pu_GraBC;
    }

    public void setPu_GraBC(float pu_GraBC) {
        this.pu_GraBC = pu_GraBC;
    }

    public float getPl_cbya() {
        return pl_cbya;
    }

    public void setPl_cbya(float pl_cbya) {
        this.pl_cbya = pl_cbya;
    }

    public float getPl_abyb() {
        return pl_abyb;
    }

    public void setPl_abyb(float pl_abyb) {
        this.pl_abyb = pl_abyb;
    }

    public float getPl_bbyc() {
        return pl_bbyc;
    }

    public void setPl_bbyc(float pl_bbyc) {
        this.pl_bbyc = pl_bbyc;
    }

    public float getPl_A() {
        return pl_A;
    }

    public void setPl_A(float pl_A) {
        this.pl_A = pl_A;
    }

    public float getPl_B() {
        return pl_B;
    }

    public void setPl_B(float pl_B) {
        this.pl_B = pl_B;
    }

    public float getPl_C() {
        return pl_C;
    }

    public void setPl_C(float pl_C) {
        this.pl_C = pl_C;
    }

    public float getPl_GraBA() {
        return pl_GraBA;
    }

    public void setPl_GraBA(float pl_GraBA) {
        this.pl_GraBA = pl_GraBA;
    }

    public float getPl_GraCA() {
        return pl_GraCA;
    }

    public void setPl_GraCA(float pl_GraCA) {
        this.pl_GraCA = pl_GraCA;
    }

    public float getPl_GraBC() {
        return pl_GraBC;
    }

    public void setPl_GraBC(float pl_GraBC) {
        this.pl_GraBC = pl_GraBC;
    }


    public float getPul_cbya() {
        return pul_cbya;
    }

    public void setPul_cbya(float pul_cbya) {
        this.pul_cbya = pul_cbya;
    }

    public float getPul_abyb() {
        return pul_abyb;
    }

    public void setPul_abyb(float pul_abyb) {
        this.pul_abyb = pul_abyb;
    }

    public float getPul_bbyc() {
        return pul_bbyc;
    }

    public void setPul_bbyc(float pul_bbyc) {
        this.pul_bbyc = pul_bbyc;
    }

    public float getPul_A() {
        return pul_A;
    }

    public void setPul_A(float pul_A) {
        this.pul_A = pul_A;
    }

    public float getPul_B() {
        return pul_B;
    }

    public void setPul_B(float pul_B) {
        this.pul_B = pul_B;
    }

    public float getPul_C() {
        return pul_C;
    }

    public void setPul_C(float pul_C) {
        this.pul_C = pul_C;
    }

    public float getPul_GraBA() {
        return pul_GraBA;
    }

    public void setPul_GraBA(float pul_GraBA) {
        this.pul_GraBA = pul_GraBA;
    }

    public float getPul_GraCA() {
        return pul_GraCA;
    }

    public void setPul_GraCA(float pul_GraCA) {
        this.pul_GraCA = pul_GraCA;
    }

    public float getPul_GraBC() {
        return pul_GraBC;
    }

    public void setPul_GraBC(float pul_GraBC) {
        this.pul_GraBC = pul_GraBC;
    }

    public float getPur_cbya() {
        return pur_cbya;
    }

    public void setPur_cbya(float pur_cbya) {
        this.pur_cbya = pur_cbya;
    }

    public float getPur_abyb() {
        return pur_abyb;
    }

    public void setPur_abyb(float pur_abyb) {
        this.pur_abyb = pur_abyb;
    }

    public float getPur_bbyc() {
        return pur_bbyc;
    }

    public void setPur_bbyc(float pur_bbyc) {
        this.pur_bbyc = pur_bbyc;
    }

    public float getPur_A() {
        return pur_A;
    }

    public void setPur_A(float pur_A) {
        this.pur_A = pur_A;
    }

    public float getPur_B() {
        return pur_B;
    }

    public void setPur_B(float pur_B) {
        this.pur_B = pur_B;
    }

    public float getPur_C() {
        return pur_C;
    }

    public void setPur_C(float pur_C) {
        this.pur_C = pur_C;
    }

    public float getPur_GraBA() {
        return pur_GraBA;
    }

    public void setPur_GraBA(float pur_GraBA) {
        this.pur_GraBA = pur_GraBA;
    }

    public float getPur_GraCA() {
        return pur_GraCA;
    }

    public void setPur_GraCA(float pur_GraCA) {
        this.pur_GraCA = pur_GraCA;
    }

    public float getPur_GraBC() {
        return pur_GraBC;
    }

    public void setPur_GraBC(float pur_GraBC) {
        this.pur_GraBC = pur_GraBC;
    }

    public float getPll_cbya() {
        return pll_cbya;
    }

    public void setPll_cbya(float pll_cbya) {
        this.pll_cbya = pll_cbya;
    }

    public float getPll_abyb() {
        return pll_abyb;
    }

    public void setPll_abyb(float pll_abyb) {
        this.pll_abyb = pll_abyb;
    }

    public float getPll_bbyc() {
        return pll_bbyc;
    }

    public void setPll_bbyc(float pll_bbyc) {
        this.pll_bbyc = pll_bbyc;
    }

    public float getPll_A() {
        return pll_A;
    }

    public void setPll_A(float pll_A) {
        this.pll_A = pll_A;
    }

    public float getPll_B() {
        return pll_B;
    }

    public void setPll_B(float pll_B) {
        this.pll_B = pll_B;
    }

    public float getPll_C() {
        return pll_C;
    }

    public void setPll_C(float pll_C) {
        this.pll_C = pll_C;
    }

    public float getPll_GraBA() {
        return pll_GraBA;
    }

    public void setPll_GraBA(float pll_GraBA) {
        this.pll_GraBA = pll_GraBA;
    }

    public float getPll_GraCA() {
        return pll_GraCA;
    }

    public void setPll_GraCA(float pll_GraCA) {
        this.pll_GraCA = pll_GraCA;
    }

    public float getPll_GraBC() {
        return pll_GraBC;
    }

    public void setPll_GraBC(float pll_GraBC) {
        this.pll_GraBC = pll_GraBC;
    }

    public float getPlr_cbya() {
        return plr_cbya;
    }

    public void setPlr_cbya(float plr_cbya) {
        this.plr_cbya = plr_cbya;
    }

    public float getPlr_abyb() {
        return plr_abyb;
    }

    public void setPlr_abyb(float plr_abyb) {
        this.plr_abyb = plr_abyb;
    }

    public float getPlr_bbyc() {
        return plr_bbyc;
    }

    public void setPlr_bbyc(float plr_bbyc) {
        this.plr_bbyc = plr_bbyc;
    }

    public float getPlr_A() {
        return plr_A;
    }

    public void setPlr_A(float plr_A) {
        this.plr_A = plr_A;
    }

    public float getPlr_B() {
        return plr_B;
    }

    public void setPlr_B(float plr_B) {
        this.plr_B = plr_B;
    }

    public float getPlr_C() {
        return plr_C;
    }

    public void setPlr_C(float plr_C) {
        this.plr_C = plr_C;
    }

    public float getPlr_GraBA() {
        return plr_GraBA;
    }

    public void setPlr_GraBA(float plr_GraBA) {
        this.plr_GraBA = plr_GraBA;
    }

    public float getPlr_GraCA() {
        return plr_GraCA;
    }

    public void setPlr_GraCA(float plr_GraCA) {
        this.plr_GraCA = plr_GraCA;
    }

    public float getPlr_GraBC() {
        return plr_GraBC;
    }

    public void setPlr_GraBC(float plr_GraBC) {
        this.plr_GraBC = plr_GraBC;
    }


    public float getsLLUZ_cbya() {
        return sLLUZ_cbya;
    }

    public void setsLLUZ_cbya(float sLLUZ_cbya) {
        this.sLLUZ_cbya = sLLUZ_cbya;
    }

    public float getsLLUZ_abyb() {
        return sLLUZ_abyb;
    }

    public void setsLLUZ_abyb(float sLLUZ_abyb) {
        this.sLLUZ_abyb = sLLUZ_abyb;
    }

    public float getsLLUZ_bbyc() {
        return sLLUZ_bbyc;
    }

    public void setsLLUZ_bbyc(float sLLUZ_bbyc) {
        this.sLLUZ_bbyc = sLLUZ_bbyc;
    }

    public float getsLLUZ_A() {
        return sLLUZ_A;
    }

    public void setsLLUZ_A(float sLLUZ_A) {
        this.sLLUZ_A = sLLUZ_A;
    }

    public float getsLLUZ_B() {
        return sLLUZ_B;
    }

    public void setsLLUZ_B(float sLLUZ_B) {
        this.sLLUZ_B = sLLUZ_B;
    }

    public float getsLLUZ_C() {
        return sLLUZ_C;
    }

    public void setsLLUZ_C(float sLLUZ_C) {
        this.sLLUZ_C = sLLUZ_C;
    }

    public float getsLLUZ_GraBA() {
        return sLLUZ_GraBA;
    }

    public void setsLLUZ_GraBA(float sLLUZ_GraBA) {
        this.sLLUZ_GraBA = sLLUZ_GraBA;
    }

    public float getsLLUZ_GraBC() {
        return sLLUZ_GraBC;
    }

    public void setsLLUZ_GraBC(float sLLUZ_GraBC) {
        this.sLLUZ_GraBC = sLLUZ_GraBC;
    }

    public float getsLLUZ_GraCA() {
        return sLLUZ_GraCA;
    }

    public void setsLLUZ_GraCA(float sLLUZ_GraCA) {
        this.sLLUZ_GraCA = sLLUZ_GraCA;
    }

    public float getsLLBZ_cbya() {
        return sLLBZ_cbya;
    }

    public void setsLLBZ_cbya(float sLLBZ_cbya) {
        this.sLLBZ_cbya = sLLBZ_cbya;
    }

    public float getsLLBZ_abyb() {
        return sLLBZ_abyb;
    }

    public void setsLLBZ_abyb(float sLLBZ_abyb) {
        this.sLLBZ_abyb = sLLBZ_abyb;
    }

    public float getsLLBZ_bbyc() {
        return sLLBZ_bbyc;
    }

    public void setsLLBZ_bbyc(float sLLBZ_bbyc) {
        this.sLLBZ_bbyc = sLLBZ_bbyc;
    }

    public float getsLLBZ_A() {
        return sLLBZ_A;
    }

    public void setsLLBZ_A(float sLLBZ_A) {
        this.sLLBZ_A = sLLBZ_A;
    }

    public float getsLLBZ_B() {
        return sLLBZ_B;
    }

    public void setsLLBZ_B(float sLLBZ_B) {
        this.sLLBZ_B = sLLBZ_B;
    }

    public float getsLLBZ_C() {
        return sLLBZ_C;
    }

    public void setsLLBZ_C(float sLLBZ_C) {
        this.sLLBZ_C = sLLBZ_C;
    }

    public float getsLLBZ_GraBA() {
        return sLLBZ_GraBA;
    }

    public void setsLLBZ_GraBA(float sLLBZ_GraBA) {
        this.sLLBZ_GraBA = sLLBZ_GraBA;
    }

    public float getsLLBZ_GraBC() {
        return sLLBZ_GraBC;
    }

    public void setsLLBZ_GraBC(float sLLBZ_GraBC) {
        this.sLLBZ_GraBC = sLLBZ_GraBC;
    }

    public float getsLLBZ_GraCA() {
        return sLLBZ_GraCA;
    }

    public void setsLLBZ_GraCA(float sLLBZ_GraCA) {
        this.sLLBZ_GraCA = sLLBZ_GraCA;
    }

    public float getsLRUZ_cbya() {
        return sLRUZ_cbya;
    }

    public void setsLRUZ_cbya(float sLRUZ_cbya) {
        this.sLRUZ_cbya = sLRUZ_cbya;
    }

    public float getsLRUZ_abyb() {
        return sLRUZ_abyb;
    }

    public void setsLRUZ_abyb(float sLRUZ_abyb) {
        this.sLRUZ_abyb = sLRUZ_abyb;
    }

    public float getsLRUZ_bbyc() {
        return sLRUZ_bbyc;
    }

    public void setsLRUZ_bbyc(float sLRUZ_bbyc) {
        this.sLRUZ_bbyc = sLRUZ_bbyc;
    }

    public float getsLRUZ_A() {
        return sLRUZ_A;
    }

    public void setsLRUZ_A(float sLRUZ_A) {
        this.sLRUZ_A = sLRUZ_A;
    }

    public float getsLRUZ_B() {
        return sLRUZ_B;
    }

    public void setsLRUZ_B(float sLRUZ_B) {
        this.sLRUZ_B = sLRUZ_B;
    }

    public float getsLRUZ_C() {
        return sLRUZ_C;
    }

    public void setsLRUZ_C(float sLRUZ_C) {
        this.sLRUZ_C = sLRUZ_C;
    }

    public float getsLRUZ_GraBA() {
        return sLRUZ_GraBA;
    }

    public void setsLRUZ_GraBA(float sLRUZ_GraBA) {
        this.sLRUZ_GraBA = sLRUZ_GraBA;
    }

    public float getsLRUZ_GraBC() {
        return sLRUZ_GraBC;
    }

    public void setsLRUZ_GraBC(float sLRUZ_GraBC) {
        this.sLRUZ_GraBC = sLRUZ_GraBC;
    }

    public float getsLRUZ_GraCA() {
        return sLRUZ_GraCA;
    }

    public void setsLRUZ_GraCA(float sLRUZ_GraCA) {
        this.sLRUZ_GraCA = sLRUZ_GraCA;
    }

    public float getsLRBZ_cbya() {
        return sLRBZ_cbya;
    }

    public void setsLRBZ_cbya(float sLRBZ_cbya) {
        this.sLRBZ_cbya = sLRBZ_cbya;
    }

    public float getsLRBZ_abyb() {
        return sLRBZ_abyb;
    }

    public void setsLRBZ_abyb(float sLRBZ_abyb) {
        this.sLRBZ_abyb = sLRBZ_abyb;
    }

    public float getsLRBZ_bbyc() {
        return sLRBZ_bbyc;
    }

    public void setsLRBZ_bbyc(float sLRBZ_bbyc) {
        this.sLRBZ_bbyc = sLRBZ_bbyc;
    }

    public float getsLRBZ_A() {
        return sLRBZ_A;
    }

    public void setsLRBZ_A(float sLRBZ_A) {
        this.sLRBZ_A = sLRBZ_A;
    }

    public float getsLRBZ_B() {
        return sLRBZ_B;
    }

    public void setsLRBZ_B(float sLRBZ_B) {
        this.sLRBZ_B = sLRBZ_B;
    }

    public float getsLRBZ_C() {
        return sLRBZ_C;
    }

    public void setsLRBZ_C(float sLRBZ_C) {
        this.sLRBZ_C = sLRBZ_C;
    }

    public float getsLRBZ_GraBA() {
        return sLRBZ_GraBA;
    }

    public void setsLRBZ_GraBA(float sLRBZ_GraBA) {
        this.sLRBZ_GraBA = sLRBZ_GraBA;
    }

    public float getsLRBZ_GraBC() {
        return sLRBZ_GraBC;
    }

    public void setsLRBZ_GraBC(float sLRBZ_GraBC) {
        this.sLRBZ_GraBC = sLRBZ_GraBC;
    }

    public float getsLRBZ_GraCA() {
        return sLRBZ_GraCA;
    }

    public void setsLRBZ_GraCA(float sLRBZ_GraCA) {
        this.sLRBZ_GraCA = sLRBZ_GraCA;
    }

    public float getsRLUZ_cbya() {
        return sRLUZ_cbya;
    }

    public void setsRLUZ_cbya(float sRLUZ_cbya) {
        this.sRLUZ_cbya = sRLUZ_cbya;
    }

    public float getsRLUZ_abyb() {
        return sRLUZ_abyb;
    }

    public void setsRLUZ_abyb(float sRLUZ_abyb) {
        this.sRLUZ_abyb = sRLUZ_abyb;
    }

    public float getsRLUZ_bbyc() {
        return sRLUZ_bbyc;
    }

    public void setsRLUZ_bbyc(float sRLUZ_bbyc) {
        this.sRLUZ_bbyc = sRLUZ_bbyc;
    }

    public float getsRLUZ_A() {
        return sRLUZ_A;
    }

    public void setsRLUZ_A(float sRLUZ_A) {
        this.sRLUZ_A = sRLUZ_A;
    }

    public float getsRLUZ_B() {
        return sRLUZ_B;
    }

    public void setsRLUZ_B(float sRLUZ_B) {
        this.sRLUZ_B = sRLUZ_B;
    }

    public float getsRLUZ_C() {
        return sRLUZ_C;
    }

    public void setsRLUZ_C(float sRLUZ_C) {
        this.sRLUZ_C = sRLUZ_C;
    }

    public float getsRLUZ_GraBA() {
        return sRLUZ_GraBA;
    }

    public void setsRLUZ_GraBA(float sRLUZ_GraBA) {
        this.sRLUZ_GraBA = sRLUZ_GraBA;
    }

    public float getsRLUZ_GraBC() {
        return sRLUZ_GraBC;
    }

    public void setsRLUZ_GraBC(float sRLUZ_GraBC) {
        this.sRLUZ_GraBC = sRLUZ_GraBC;
    }

    public float getsRLUZ_GraCA() {
        return sRLUZ_GraCA;
    }

    public void setsRLUZ_GraCA(float sRLUZ_GraCA) {
        this.sRLUZ_GraCA = sRLUZ_GraCA;
    }

    public float getsRLBZ_cbya() {
        return sRLBZ_cbya;
    }

    public void setsRLBZ_cbya(float sRLBZ_cbya) {
        this.sRLBZ_cbya = sRLBZ_cbya;
    }

    public float getsRLBZ_abyb() {
        return sRLBZ_abyb;
    }

    public void setsRLBZ_abyb(float sRLBZ_abyb) {
        this.sRLBZ_abyb = sRLBZ_abyb;
    }

    public float getsRLBZ_bbyc() {
        return sRLBZ_bbyc;
    }

    public void setsRLBZ_bbyc(float sRLBZ_bbyc) {
        this.sRLBZ_bbyc = sRLBZ_bbyc;
    }

    public float getsRLBZ_A() {
        return sRLBZ_A;
    }

    public void setsRLBZ_A(float sRLBZ_A) {
        this.sRLBZ_A = sRLBZ_A;
    }

    public float getsRLBZ_B() {
        return sRLBZ_B;
    }

    public void setsRLBZ_B(float sRLBZ_B) {
        this.sRLBZ_B = sRLBZ_B;
    }

    public float getsRLBZ_C() {
        return sRLBZ_C;
    }

    public void setsRLBZ_C(float sRLBZ_C) {
        this.sRLBZ_C = sRLBZ_C;
    }

    public float getsRLBZ_GraBA() {
        return sRLBZ_GraBA;
    }

    public void setsRLBZ_GraBA(float sRLBZ_GraBA) {
        this.sRLBZ_GraBA = sRLBZ_GraBA;
    }

    public float getsRLBZ_GraBC() {
        return sRLBZ_GraBC;
    }

    public void setsRLBZ_GraBC(float sRLBZ_GraBC) {
        this.sRLBZ_GraBC = sRLBZ_GraBC;
    }

    public float getsRLBZ_GraCA() {
        return sRLBZ_GraCA;
    }

    public void setsRLBZ_GraCA(float sRLBZ_GraCA) {
        this.sRLBZ_GraCA = sRLBZ_GraCA;
    }

    public float getsRRUZ_cbya() {
        return sRRUZ_cbya;
    }

    public void setsRRUZ_cbya(float sRRUZ_cbya) {
        this.sRRUZ_cbya = sRRUZ_cbya;
    }

    public float getsRRUZ_abyb() {
        return sRRUZ_abyb;
    }

    public void setsRRUZ_abyb(float sRRUZ_abyb) {
        this.sRRUZ_abyb = sRRUZ_abyb;
    }

    public float getsRRUZ_bbyc() {
        return sRRUZ_bbyc;
    }

    public void setsRRUZ_bbyc(float sRRUZ_bbyc) {
        this.sRRUZ_bbyc = sRRUZ_bbyc;
    }

    public float getsRRUZ_A() {
        return sRRUZ_A;
    }

    public void setsRRUZ_A(float sRRUZ_A) {
        this.sRRUZ_A = sRRUZ_A;
    }

    public float getsRRUZ_B() {
        return sRRUZ_B;
    }

    public void setsRRUZ_B(float sRRUZ_B) {
        this.sRRUZ_B = sRRUZ_B;
    }

    public float getsRRUZ_C() {
        return sRRUZ_C;
    }

    public void setsRRUZ_C(float sRRUZ_C) {
        this.sRRUZ_C = sRRUZ_C;
    }

    public float getsRRUZ_GraBA() {
        return sRRUZ_GraBA;
    }

    public void setsRRUZ_GraBA(float sRRUZ_GraBA) {
        this.sRRUZ_GraBA = sRRUZ_GraBA;
    }

    public float getsRRUZ_GraBC() {
        return sRRUZ_GraBC;
    }

    public void setsRRUZ_GraBC(float sRRUZ_GraBC) {
        this.sRRUZ_GraBC = sRRUZ_GraBC;
    }

    public float getsRRUZ_GraCA() {
        return sRRUZ_GraCA;
    }

    public void setsRRUZ_GraCA(float sRRUZ_GraCA) {
        this.sRRUZ_GraCA = sRRUZ_GraCA;
    }

    public float getsRRBZ_cbya() {
        return sRRBZ_cbya;
    }

    public void setsRRBZ_cbya(float sRRBZ_cbya) {
        this.sRRBZ_cbya = sRRBZ_cbya;
    }

    public float getsRRBZ_abyb() {
        return sRRBZ_abyb;
    }

    public void setsRRBZ_abyb(float sRRBZ_abyb) {
        this.sRRBZ_abyb = sRRBZ_abyb;
    }

    public float getsRRBZ_bbyc() {
        return sRRBZ_bbyc;
    }

    public void setsRRBZ_bbyc(float sRRBZ_bbyc) {
        this.sRRBZ_bbyc = sRRBZ_bbyc;
    }

    public float getsRRBZ_A() {
        return sRRBZ_A;
    }

    public void setsRRBZ_A(float sRRBZ_A) {
        this.sRRBZ_A = sRRBZ_A;
    }

    public float getsRRBZ_B() {
        return sRRBZ_B;
    }

    public void setsRRBZ_B(float sRRBZ_B) {
        this.sRRBZ_B = sRRBZ_B;
    }

    public float getsRRBZ_C() {
        return sRRBZ_C;
    }

    public void setsRRBZ_C(float sRRBZ_C) {
        this.sRRBZ_C = sRRBZ_C;
    }

    public float getsRRBZ_GraBA() {
        return sRRBZ_GraBA;
    }

    public void setsRRBZ_GraBA(float sRRBZ_GraBA) {
        this.sRRBZ_GraBA = sRRBZ_GraBA;
    }

    public float getsRRBZ_GraBC() {
        return sRRBZ_GraBC;
    }

    public void setsRRBZ_GraBC(float sRRBZ_GraBC) {
        this.sRRBZ_GraBC = sRRBZ_GraBC;
    }

    public float getsRRBZ_GraCA() {
        return sRRBZ_GraCA;
    }

    public void setsRRBZ_GraCA(float sRRBZ_GraCA) {
        this.sRRBZ_GraCA = sRRBZ_GraCA;
    }


    public float getsALL_cbya() {
        return sALL_cbya;
    }

    public void setsALL_cbya(float sALL_cbya) {
        this.sALL_cbya = sALL_cbya;
    }

    public float getsALL_abyb() {
        return sALL_abyb;
    }

    public void setsALL_abyb(float sALL_abyb) {
        this.sALL_abyb = sALL_abyb;
    }

    public float getsALL_bbyc() {
        return sALL_bbyc;
    }

    public void setsALL_bbyc(float sALL_bbyc) {
        this.sALL_bbyc = sALL_bbyc;
    }

    public float getsALL_A() {
        return sALL_A;
    }

    public void setsALL_A(float sALL_A) {
        this.sALL_A = sALL_A;
    }

    public float getsALL_B() {
        return sALL_B;
    }

    public void setsALL_B(float sALL_B) {
        this.sALL_B = sALL_B;
    }

    public float getsALL_C() {
        return sALL_C;
    }

    public void setsALL_C(float sALL_C) {
        this.sALL_C = sALL_C;
    }

    public float getsALL_GraBA() {
        return sALL_GraBA;
    }

    public void setsALL_GraBA(float sALL_GraBA) {
        this.sALL_GraBA = sALL_GraBA;
    }

    public float getsALL_GraCA() {
        return sALL_GraCA;
    }

    public void setsALL_GraCA(float sALL_GraCA) {
        this.sALL_GraCA = sALL_GraCA;
    }

    public float getsALL_GraBC() {
        return sALL_GraBC;
    }

    public void setsALL_GraBC(float sALL_GraBC) {
        this.sALL_GraBC = sALL_GraBC;
    }

    public float getsALR_cbya() {
        return sALR_cbya;
    }

    public void setsALR_cbya(float sALR_cbya) {
        this.sALR_cbya = sALR_cbya;
    }

    public float getsALR_abyb() {
        return sALR_abyb;
    }

    public void setsALR_abyb(float sALR_abyb) {
        this.sALR_abyb = sALR_abyb;
    }

    public float getsALR_bbyc() {
        return sALR_bbyc;
    }

    public void setsALR_bbyc(float sALR_bbyc) {
        this.sALR_bbyc = sALR_bbyc;
    }

    public float getsALR_A() {
        return sALR_A;
    }

    public void setsALR_A(float sALR_A) {
        this.sALR_A = sALR_A;
    }

    public float getsALR_B() {
        return sALR_B;
    }

    public void setsALR_B(float sALR_B) {
        this.sALR_B = sALR_B;
    }

    public float getsALR_C() {
        return sALR_C;
    }

    public void setsALR_C(float sALR_C) {
        this.sALR_C = sALR_C;
    }

    public float getsALR_GraBA() {
        return sALR_GraBA;
    }

    public void setsALR_GraBA(float sALR_GraBA) {
        this.sALR_GraBA = sALR_GraBA;
    }

    public float getsALR_GraCA() {
        return sALR_GraCA;
    }

    public void setsALR_GraCA(float sALR_GraCA) {
        this.sALR_GraCA = sALR_GraCA;
    }

    public float getsALR_GraBC() {
        return sALR_GraBC;
    }

    public void setsALR_GraBC(float sALR_GraBC) {
        this.sALR_GraBC = sALR_GraBC;
    }

    public float getsARL_cbya() {
        return sARL_cbya;
    }

    public void setsARL_cbya(float sARL_cbya) {
        this.sARL_cbya = sARL_cbya;
    }

    public float getsARL_abyb() {
        return sARL_abyb;
    }

    public void setsARL_abyb(float sARL_abyb) {
        this.sARL_abyb = sARL_abyb;
    }

    public float getsARL_bbyc() {
        return sARL_bbyc;
    }

    public void setsARL_bbyc(float sARL_bbyc) {
        this.sARL_bbyc = sARL_bbyc;
    }

    public float getsARL_A() {
        return sARL_A;
    }

    public void setsARL_A(float sARL_A) {
        this.sARL_A = sARL_A;
    }

    public float getsARL_B() {
        return sARL_B;
    }

    public void setsARL_B(float sARL_B) {
        this.sARL_B = sARL_B;
    }

    public float getsARL_C() {
        return sARL_C;
    }

    public void setsARL_C(float sARL_C) {
        this.sARL_C = sARL_C;
    }

    public float getsARL_GraBA() {
        return sARL_GraBA;
    }

    public void setsARL_GraBA(float sARL_GraBA) {
        this.sARL_GraBA = sARL_GraBA;
    }

    public float getsARL_GraCA() {
        return sARL_GraCA;
    }

    public void setsARL_GraCA(float sARL_GraCA) {
        this.sARL_GraCA = sARL_GraCA;
    }

    public float getsARL_GraBC() {
        return sARL_GraBC;
    }

    public void setsARL_GraBC(float sARL_GraBC) {
        this.sARL_GraBC = sARL_GraBC;
    }

    public float getsARR_cbya() {
        return sARR_cbya;
    }

    public void setsARR_cbya(float sARR_cbya) {
        this.sARR_cbya = sARR_cbya;
    }

    public float getsARR_abyb() {
        return sARR_abyb;
    }

    public void setsARR_abyb(float sARR_abyb) {
        this.sARR_abyb = sARR_abyb;
    }

    public float getsARR_bbyc() {
        return sARR_bbyc;
    }

    public void setsARR_bbyc(float sARR_bbyc) {
        this.sARR_bbyc = sARR_bbyc;
    }

    public float getsARR_A() {
        return sARR_A;
    }

    public void setsARR_A(float sARR_A) {
        this.sARR_A = sARR_A;
    }

    public float getsARR_B() {
        return sARR_B;
    }

    public void setsARR_B(float sARR_B) {
        this.sARR_B = sARR_B;
    }

    public float getsARR_C() {
        return sARR_C;
    }

    public void setsARR_C(float sARR_C) {
        this.sARR_C = sARR_C;
    }

    public float getsARR_GraBA() {
        return sARR_GraBA;
    }

    public void setsARR_GraBA(float sARR_GraBA) {
        this.sARR_GraBA = sARR_GraBA;
    }

    public float getsARR_GraCA() {
        return sARR_GraCA;
    }

    public void setsARR_GraCA(float sARR_GraCA) {
        this.sARR_GraCA = sARR_GraCA;
    }

    public float getsARR_GraBC() {
        return sARR_GraBC;
    }

    public void setsARR_GraBC(float sARR_GraBC) {
        this.sARR_GraBC = sARR_GraBC;
    }

    public float getsBLL_cbya() {
        return sBLL_cbya;
    }

    public void setsBLL_cbya(float sBLL_cbya) {
        this.sBLL_cbya = sBLL_cbya;
    }

    public float getsBLL_abyb() {
        return sBLL_abyb;
    }

    public void setsBLL_abyb(float sBLL_abyb) {
        this.sBLL_abyb = sBLL_abyb;
    }

    public float getsBLL_bbyc() {
        return sBLL_bbyc;
    }

    public void setsBLL_bbyc(float sBLL_bbyc) {
        this.sBLL_bbyc = sBLL_bbyc;
    }

    public float getsBLL_A() {
        return sBLL_A;
    }

    public void setsBLL_A(float sBLL_A) {
        this.sBLL_A = sBLL_A;
    }

    public float getsBLL_B() {
        return sBLL_B;
    }

    public void setsBLL_B(float sBLL_B) {
        this.sBLL_B = sBLL_B;
    }

    public float getsBLL_C() {
        return sBLL_C;
    }

    public void setsBLL_C(float sBLL_C) {
        this.sBLL_C = sBLL_C;
    }

    public float getsBLL_GraBA() {
        return sBLL_GraBA;
    }

    public void setsBLL_GraBA(float sBLL_GraBA) {
        this.sBLL_GraBA = sBLL_GraBA;
    }

    public float getsBLL_GraCA() {
        return sBLL_GraCA;
    }

    public void setsBLL_GraCA(float sBLL_GraCA) {
        this.sBLL_GraCA = sBLL_GraCA;
    }

    public float getsBLL_GraBC() {
        return sBLL_GraBC;
    }

    public void setsBLL_GraBC(float sBLL_GraBC) {
        this.sBLL_GraBC = sBLL_GraBC;
    }

    public float getsBLR_cbya() {
        return sBLR_cbya;
    }

    public void setsBLR_cbya(float sBLR_cbya) {
        this.sBLR_cbya = sBLR_cbya;
    }

    public float getsBLR_abyb() {
        return sBLR_abyb;
    }

    public void setsBLR_abyb(float sBLR_abyb) {
        this.sBLR_abyb = sBLR_abyb;
    }

    public float getsBLR_bbyc() {
        return sBLR_bbyc;
    }

    public void setsBLR_bbyc(float sBLR_bbyc) {
        this.sBLR_bbyc = sBLR_bbyc;
    }

    public float getsBLR_A() {
        return sBLR_A;
    }

    public void setsBLR_A(float sBLR_A) {
        this.sBLR_A = sBLR_A;
    }

    public float getsBLR_B() {
        return sBLR_B;
    }

    public void setsBLR_B(float sBLR_B) {
        this.sBLR_B = sBLR_B;
    }

    public float getsBLR_C() {
        return sBLR_C;
    }

    public void setsBLR_C(float sBLR_C) {
        this.sBLR_C = sBLR_C;
    }

    public float getsBLR_GraBA() {
        return sBLR_GraBA;
    }

    public void setsBLR_GraBA(float sBLR_GraBA) {
        this.sBLR_GraBA = sBLR_GraBA;
    }

    public float getsBLR_GraCA() {
        return sBLR_GraCA;
    }

    public void setsBLR_GraCA(float sBLR_GraCA) {
        this.sBLR_GraCA = sBLR_GraCA;
    }

    public float getsBLR_GraBC() {
        return sBLR_GraBC;
    }

    public void setsBLR_GraBC(float sBLR_GraBC) {
        this.sBLR_GraBC = sBLR_GraBC;
    }

    public float getsBRL_cbya() {
        return sBRL_cbya;
    }

    public void setsBRL_cbya(float sBRL_cbya) {
        this.sBRL_cbya = sBRL_cbya;
    }

    public float getsBRL_abyb() {
        return sBRL_abyb;
    }

    public void setsBRL_abyb(float sBRL_abyb) {
        this.sBRL_abyb = sBRL_abyb;
    }

    public float getsBRL_bbyc() {
        return sBRL_bbyc;
    }

    public void setsBRL_bbyc(float sBRL_bbyc) {
        this.sBRL_bbyc = sBRL_bbyc;
    }

    public float getsBRL_A() {
        return sBRL_A;
    }

    public void setsBRL_A(float sBRL_A) {
        this.sBRL_A = sBRL_A;
    }

    public float getsBRL_B() {
        return sBRL_B;
    }

    public void setsBRL_B(float sBRL_B) {
        this.sBRL_B = sBRL_B;
    }

    public float getsBRL_C() {
        return sBRL_C;
    }

    public void setsBRL_C(float sBRL_C) {
        this.sBRL_C = sBRL_C;
    }

    public float getsBRL_GraBA() {
        return sBRL_GraBA;
    }

    public void setsBRL_GraBA(float sBRL_GraBA) {
        this.sBRL_GraBA = sBRL_GraBA;
    }

    public float getsBRL_GraCA() {
        return sBRL_GraCA;
    }

    public void setsBRL_GraCA(float sBRL_GraCA) {
        this.sBRL_GraCA = sBRL_GraCA;
    }

    public float getsBRL_GraBC() {
        return sBRL_GraBC;
    }

    public void setsBRL_GraBC(float sBRL_GraBC) {
        this.sBRL_GraBC = sBRL_GraBC;
    }

    public float getsBRR_cbya() {
        return sBRR_cbya;
    }

    public void setsBRR_cbya(float sBRR_cbya) {
        this.sBRR_cbya = sBRR_cbya;
    }

    public float getsBRR_abyb() {
        return sBRR_abyb;
    }

    public void setsBRR_abyb(float sBRR_abyb) {
        this.sBRR_abyb = sBRR_abyb;
    }

    public float getsBRR_bbyc() {
        return sBRR_bbyc;
    }

    public void setsBRR_bbyc(float sBRR_bbyc) {
        this.sBRR_bbyc = sBRR_bbyc;
    }

    public float getsBRR_A() {
        return sBRR_A;
    }

    public void setsBRR_A(float sBRR_A) {
        this.sBRR_A = sBRR_A;
    }

    public float getsBRR_B() {
        return sBRR_B;
    }

    public void setsBRR_B(float sBRR_B) {
        this.sBRR_B = sBRR_B;
    }

    public float getsBRR_C() {
        return sBRR_C;
    }

    public void setsBRR_C(float sBRR_C) {
        this.sBRR_C = sBRR_C;
    }

    public float getsBRR_GraBA() {
        return sBRR_GraBA;
    }

    public void setsBRR_GraBA(float sBRR_GraBA) {
        this.sBRR_GraBA = sBRR_GraBA;
    }

    public float getsBRR_GraCA() {
        return sBRR_GraCA;
    }

    public void setsBRR_GraCA(float sBRR_GraCA) {
        this.sBRR_GraCA = sBRR_GraCA;
    }

    public float getsBRR_GraBC() {
        return sBRR_GraBC;
    }

    public void setsBRR_GraBC(float sBRR_GraBC) {
        this.sBRR_GraBC = sBRR_GraBC;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
