package database;


import featureTriangle.bean.Bean_Feature;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DMLsql {

    private void writeFeatures(int initialParameterIndex,PreparedStatement ps, Bean_Feature beanPage) throws SQLException
    {
        int parameterIndex = initialParameterIndex;
        ps.setFloat(parameterIndex, beanPage.getCbya());//1
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getAbyb());//2
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBbyc());//3
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getA());//4
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getB());//5
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getC());//6
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getGraBA());//7
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getGraBC());//ps.setFloat(parameterIndex, beanPage.getGraCA());//8
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getGraCA());//ps.setFloat(parameterIndex, beanPage.getGraBC());//9
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPu_cbya());//10
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPu_abyb());//11
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPu_bbyc());//12
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPu_A());//13
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPu_B());//14
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPu_C());//15
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPu_GraBA());//16
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPu_GraBC());//ps.setFloat(parameterIndex, beanPage.getPu_GraCA());//17
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPu_GraCA());//ps.setFloat(parameterIndex, beanPage.getPu_GraBC());//18
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPl_cbya());//19
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPl_abyb());//20
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPl_bbyc());//21
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPl_A());//22
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPl_B());//23
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPl_C());//24
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPl_GraBA());//25
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPl_GraBC());//ps.setFloat(parameterIndex, beanPage.getPl_GraCA());//26
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPl_GraCA());//ps.setFloat(parameterIndex, beanPage.getPl_GraBC());//27
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTu_cbya());//28
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTu_abyb());//29
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTu_bbyc());//30
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTu_A());//31
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTu_B());//32
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTu_C());//33
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTu_GraBA());//34
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTu_GraBC());//ps.setFloat(parameterIndex, beanPage.getTu_GraCA());//35
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTu_GraCA());//ps.setFloat(parameterIndex, beanPage.getTu_GraBC());//36
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTl_cbya());//37
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTl_abyb());//38
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTl_bbyc());//39
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTl_A());//40
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTl_B());//41
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTl_C());//42
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTl_GraBA());//43
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTl_GraBC());//ps.setFloat(parameterIndex, beanPage.getTl_GraCA());//44
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getTl_GraCA());//ps.setFloat(parameterIndex, beanPage.getTl_GraBC());//45
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBu_cbya());//46
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBu_abyb());//47
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBu_bbyc());//48
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBu_A());//49
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBu_B());//50
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBu_C());//51
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBu_GraBA());//52
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBu_GraBC());//ps.setFloat(parameterIndex, beanPage.getBu_GraCA());//53
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBu_GraCA());//ps.setFloat(parameterIndex, beanPage.getBu_GraBC());//54
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBl_cbya());//55
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBl_abyb());//56
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBl_bbyc());//57
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBl_A());//58
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBl_B());//59
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBl_C());//60
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBl_GraBA());//61
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBl_GraBC());//ps.setFloat(parameterIndex, beanPage.getBl_GraCA());//62
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getBl_GraCA());//ps.setFloat(parameterIndex, beanPage.getBl_GraBC());//63
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_Lcbya());//64
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_Labyb());//65
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_Lbbyc());//66
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_LA());//67
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_LB());//68
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_LC());//69
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_LGraBA());//70
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_LGraBC());//ps.setFloat(parameterIndex, beanPage.getP_LGraCA());//71
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_LGraCA());//ps.setFloat(parameterIndex, beanPage.getP_LGraBC());//72
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_Rcbya());//73
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_Rabyb());//74
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_Rbbyc());//75
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_RA());//76
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_RB());//77
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_RC());//78
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_RGraBA());//79
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_RGraBC());//ps.setFloat(parameterIndex, beanPage.getP_RGraCA());//80
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getP_RGraCA());//ps.setFloat(parameterIndex, beanPage.getP_RGraBC());//81
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLZ_cbya());//82
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLZ_abyb());//83
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLZ_bbyc());//84
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLZ_A());//85
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLZ_B());//86
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLZ_C());//87
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLZ_GraBA());//88
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLZ_GraBC());//ps.setFloat(parameterIndex, beanPage.getsLLZ_GraCA());//89
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLZ_GraCA());//ps.setFloat(parameterIndex, beanPage.getsLLZ_GraBC());//90
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRZ_cbya());//91
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRZ_abyb());//92
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRZ_bbyc());//93
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRZ_A());//94
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRZ_B());//95
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRZ_C());//96
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRZ_GraBA());//97
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRZ_GraBC());//ps.setFloat(parameterIndex, beanPage.getsLRZ_GraCA());//98
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRZ_GraCA());//ps.setFloat(parameterIndex, beanPage.getsLRZ_GraBC());//99
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLZ_cbya());//100
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLZ_abyb());//101
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLZ_bbyc());//102
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLZ_A());//103
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLZ_B());//104
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLZ_C());//105
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLZ_GraBA());//106
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLZ_GraBC());//ps.setFloat(parameterIndex, beanPage.getsRLZ_GraCA());//107
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLZ_GraCA());//ps.setFloat(parameterIndex, beanPage.getsRLZ_GraBC());//108
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRZ_cbya());//109
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRZ_abyb());//110
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRZ_bbyc());//111
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRZ_A());//112
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRZ_B());//113
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRZ_C());//114
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRZ_GraBA());//115
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRZ_GraBC());//ps.setFloat(parameterIndex, beanPage.getsRRZ_GraCA());//116
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRZ_GraCA());//ps.setFloat(parameterIndex, beanPage.getsRRZ_GraBC());//117
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLUZ_cbya());//118
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLUZ_abyb());//119
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLUZ_bbyc());//120
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLUZ_A());//121
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLUZ_B());//122
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLUZ_C());//123
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLUZ_GraBA());//124
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLUZ_GraBC());//125
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLUZ_GraCA());//126
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLBZ_cbya());//127
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLBZ_abyb());//128
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLBZ_bbyc());//129
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLBZ_A());//130
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLBZ_B());//131
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLBZ_C());//132
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLBZ_GraBA());//133
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLBZ_GraBC());//134
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLLBZ_GraCA());//135
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRUZ_cbya());//136
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRUZ_abyb());//137
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRUZ_bbyc());//138
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRUZ_A());//139
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRUZ_B());//140
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRUZ_C());//141
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRUZ_GraBA());//142
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRUZ_GraBC());//143
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRUZ_GraCA());//144
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRBZ_cbya());//145
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRBZ_abyb());//146
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRBZ_bbyc());//147
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRBZ_A());//148
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRBZ_B());//149
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRBZ_C());//150
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRBZ_GraBA());//151
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRBZ_GraBC());//152
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsLRBZ_GraCA());//153
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLUZ_cbya());//154
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLUZ_abyb());//155
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLUZ_bbyc());//156
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLUZ_A());//157
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLUZ_B());//158
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLUZ_C());//159
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLUZ_GraBA());//160
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLUZ_GraBC());//161
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLUZ_GraCA());//162
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLBZ_cbya());//163
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLBZ_abyb());//164
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLBZ_bbyc());//165
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLBZ_A());//166
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLBZ_B());//167
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLBZ_C());//168
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLBZ_GraBA());//169
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLBZ_GraBC());//170
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRLBZ_GraCA());//171
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRUZ_cbya());//172
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRUZ_abyb());//173
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRUZ_bbyc());//174
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRUZ_A());//175
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRUZ_B());//176
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRUZ_C());//177
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRUZ_GraBA());//178
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRUZ_GraBC());//179
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRUZ_GraCA());//180
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRBZ_cbya());//181
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRBZ_abyb());//182
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRBZ_bbyc());//183
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRBZ_A());//184
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRBZ_B());//185
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRBZ_C());//186
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRBZ_GraBA());//187
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRBZ_GraBC());//188
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsRRBZ_GraCA());//189
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPul_cbya());//190
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPul_abyb());//191
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPul_bbyc());//192
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPul_A());//193
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPul_B());//194
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPul_C());//195
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPul_GraBA());//196
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPul_GraBC());//ps.setFloat(parameterIndex, beanPage.getPul_GraCA());//197
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPul_GraCA());//ps.setFloat(parameterIndex, beanPage.getPul_GraBC());//198
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPur_cbya());//199
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPur_abyb());//200
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPur_bbyc());//201
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPur_A());//202
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPur_B());//203
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPur_C());//204
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPur_GraBA());//205
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPur_GraBC());//ps.setFloat(parameterIndex, beanPage.getPur_GraCA());//206
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPur_GraCA());//ps.setFloat(parameterIndex, beanPage.getPur_GraBC());//207
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPll_cbya());//208
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPll_abyb());//209
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPll_bbyc());//210
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPll_A());//211
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPll_B());//212
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPll_C());//213
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPll_GraBA());//214
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPll_GraBC());//ps.setFloat(parameterIndex, beanPage.getPll_GraCA());//215
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPll_GraCA());//ps.setFloat(parameterIndex, beanPage.getPll_GraBC());//216
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPlr_cbya());//217
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPlr_abyb());//218
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPlr_bbyc());//219
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPlr_A());//220
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPlr_B());//221
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPlr_C());//222
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPlr_GraBA());//223
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPlr_GraBC());//ps.setFloat(parameterIndex, beanPage.getPlr_GraCA());//224
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getPlr_GraCA());//ps.setFloat(parameterIndex, beanPage.getPlr_GraBC());//225
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALL_cbya());//226
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALL_abyb());//227
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALL_bbyc());//228
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALL_A());//229
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALL_B());//230
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALL_C());//231
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALL_GraBA());//232
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALL_GraBC());//ps.setFloat(parameterIndex, beanPage.getsALL_GraCA());//233
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALL_GraCA());//ps.setFloat(parameterIndex, beanPage.getsALL_GraBC());//234
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALR_cbya());//235
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALR_abyb());//236
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALR_bbyc());//237
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALR_A());//238
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALR_B());//239
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALR_C());//240
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALR_GraBA());//241
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALR_GraBC());//ps.setFloat(parameterIndex, beanPage.getsALR_GraCA());//242
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsALR_GraCA());//ps.setFloat(parameterIndex, beanPage.getsALR_GraBC());//243
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARL_cbya());//244
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARL_abyb());//245
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARL_bbyc());//246
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARL_A());//247
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARL_B());//248
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARL_C());//249
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARL_GraBA());//250
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARL_GraBC());//ps.setFloat(parameterIndex, beanPage.getsARL_GraCA());//251
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARL_GraCA());//ps.setFloat(parameterIndex, beanPage.getsARL_GraBC());//252
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARR_cbya());//253
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARR_abyb());//254
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARR_bbyc());//255
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARR_A());//256
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARR_B());//257
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARR_C());//258
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARR_GraBA());//259
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARR_GraBC());//ps.setFloat(parameterIndex, beanPage.getsARR_GraCA());//260
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsARR_GraCA());//ps.setFloat(parameterIndex, beanPage.getsARR_GraBC());//261
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLL_cbya());//262
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLL_abyb());//263
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLL_bbyc());//264
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLL_A());//265
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLL_B());//266
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLL_C());//267
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLL_GraBA());//268
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLL_GraBC());//ps.setFloat(parameterIndex, beanPage.getsBLL_GraCA());//269
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLL_GraCA());//ps.setFloat(parameterIndex, beanPage.getsBLL_GraBC());//270
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLR_cbya());//271
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLR_abyb());//272
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLR_bbyc());//273
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLR_A());//274
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLR_B());//275
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLR_C());//276
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLR_GraBA());//277
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLR_GraBC());//ps.setFloat(parameterIndex, beanPage.getsBLR_GraCA());//278
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBLR_GraCA());//ps.setFloat(parameterIndex, beanPage.getsBLR_GraBC());//279
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRL_cbya());//280
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRL_abyb());//281
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRL_bbyc());//282
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRL_A());//283
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRL_B());//284
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRL_C());//285
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRL_GraBA());//286
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRL_GraBC());//ps.setFloat(parameterIndex, beanPage.getsBRL_GraCA());//287
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRL_GraCA());//ps.setFloat(parameterIndex, beanPage.getsBRL_GraBC());//288
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRR_cbya());//289
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRR_abyb());//290
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRR_bbyc());//291
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRR_A());//292
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRR_B());//293
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRR_C());//294
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRR_GraBA());//295
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRR_GraBC());//ps.setFloat(parameterIndex, beanPage.getsBRR_GraCA());//296
        parameterIndex++;
        ps.setFloat(parameterIndex, beanPage.getsBRR_GraCA());//ps.setFloat(parameterIndex, beanPage.getsBRR_GraBC());//297
        parameterIndex++;


    }

    public ArrayList<Mushafalquran_DBModel> searchMushafalquran(Mushafalquran_DBModel mushafalquranSearch)
    {
        ArrayList<Mushafalquran_DBModel> mushafalquranResultArray = new ArrayList<Mushafalquran_DBModel>();

        try {
            Connection conn = MySqlDatabase.doConnection();
            String sql = "SELECT MushafId,Penerbit,Negara,Versi,TahunPenerbitan,Penyalin,TahunDisahkan,MukaSurat,NamaFail,Direktori FROM mushafalquran ";

            if (mushafalquranSearch.getMushafId() != null || mushafalquranSearch.getPenerbit() != "" || mushafalquranSearch.getNegara() != "" || mushafalquranSearch.getVersi() != "" || mushafalquranSearch.getTahunPenerbitan() != "" || mushafalquranSearch.getPenyalin() != "" || mushafalquranSearch.getTahunDisahkan() != "" || mushafalquranSearch.getMukaSurat() != "" || mushafalquranSearch.getNamaFail() != "" || mushafalquranSearch.getDirektori() != "" ) {
                sql = sql+" WHERE ";
                boolean andExits = false;

                if (mushafalquranSearch.getMushafId() != null) {
                    if (andExits){
                        if(mushafalquranSearch.getMushafId() == null)
                            sql = sql+" AND MushafId IS ? ";
                        else
                            sql = sql+" AND MushafId = ? ";
                    }else{
                        if(mushafalquranSearch.getMushafId() == null)
                            sql = sql+" MushafId IS ? ";
                        else
                            sql = sql+" MushafId = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquranSearch.getPenerbit() != "") {
                    if (andExits){
                        if(mushafalquranSearch.getPenerbit() == null)
                            sql = sql+" AND Penerbit IS ? ";
                        else
                            sql = sql+" AND Penerbit = ? ";
                    }else{
                        if(mushafalquranSearch.getPenerbit() == null)
                            sql = sql+" Penerbit IS ? ";
                        else
                            sql = sql+" Penerbit = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquranSearch.getNegara() != "") {
                    if (andExits){
                        if(mushafalquranSearch.getNegara() == null)
                            sql = sql+" AND Negara IS ? ";
                        else
                            sql = sql+" AND Negara = ? ";
                    }else{
                        if(mushafalquranSearch.getNegara() == null)
                            sql = sql+" Negara IS ? ";
                        else
                            sql = sql+" Negara = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquranSearch.getVersi() != "") {
                    if (andExits){
                        if(mushafalquranSearch.getVersi() == null)
                            sql = sql+" AND Versi IS ? ";
                        else
                            sql = sql+" AND Versi = ? ";
                    }else{
                        if(mushafalquranSearch.getVersi() == null)
                            sql = sql+" Versi IS ? ";
                        else
                            sql = sql+" Versi = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquranSearch.getTahunPenerbitan() != "") {
                    if (andExits){
                        if(mushafalquranSearch.getTahunPenerbitan() == null)
                            sql = sql+" AND TahunPenerbitan IS ? ";
                        else
                            sql = sql+" AND TahunPenerbitan = ? ";
                    }else{
                        if(mushafalquranSearch.getTahunPenerbitan() == null)
                            sql = sql+" TahunPenerbitan IS ? ";
                        else
                            sql = sql+" TahunPenerbitan = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquranSearch.getPenyalin() != "") {
                    if (andExits){
                        if(mushafalquranSearch.getTahunPenerbitan() == null)
                            sql = sql+" AND TahunPenerbitan IS ? ";
                        else
                            sql = sql+" AND TahunPenerbitan = ? ";
                    }else{
                        if(mushafalquranSearch.getTahunPenerbitan() == null)
                            sql = sql+" TahunPenerbitan IS ? ";
                        else
                            sql = sql+" TahunPenerbitan = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquranSearch.getTahunDisahkan() != "") {
                    if (andExits){
                        if(mushafalquranSearch.getTahunDisahkan() == null)
                            sql = sql+" AND TahunDisahkan IS ? ";
                        else
                            sql = sql+" AND TahunDisahkan = ? ";
                    }else{
                        if(mushafalquranSearch.getTahunDisahkan() == null)
                            sql = sql+" TahunDisahkan IS ? ";
                        else
                            sql = sql+" TahunDisahkan = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquranSearch.getMukaSurat() != "") {
                    if (andExits){
                        if(mushafalquranSearch.getMukaSurat() == null)
                            sql = sql+" AND MukaSurat IS ? ";
                        else
                            sql = sql+" AND MukaSurat = ? ";
                    }else{
                        if(mushafalquranSearch.getMukaSurat() == null)
                            sql = sql+" MukaSurat IS ? ";
                        else
                            sql = sql+" MukaSurat = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquranSearch.getNamaFail() != "") {
                    if (andExits){
                        if(mushafalquranSearch.getNamaFail() == null)
                            sql = sql+" AND NamaFail IS ? ";
                        else
                            sql = sql+" AND NamaFail = ? ";
                    }else{
                        if(mushafalquranSearch.getNamaFail() == null)
                            sql = sql+" NamaFail IS ? ";
                        else
                            sql = sql+" NamaFail = ? ";
                        andExits = true;
                    }
                }

                if (mushafalquranSearch.getDirektori() != "") {
                    if (andExits){
                        if(mushafalquranSearch.getDirektori() == null)
                            sql = sql+" AND Direktori IS ? ";
                        else
                            sql = sql+" AND Direktori = ? ";
                    }else{
                        if(mushafalquranSearch.getDirektori() == null)
                            sql = sql+" Direktori IS ? ";
                        else
                            sql = sql+" Direktori = ? ";
                        andExits = true;
                    }
                }

            }

            //System.out.println(sql);

            PreparedStatement ps = conn.prepareStatement(sql);

            int parameterIndex = 1;

            if (mushafalquranSearch.getMushafId() != null) {
                if (mushafalquranSearch.getMushafId()==null){
                    ps.setNull(parameterIndex,  java.sql.Types.INTEGER);
                }else{
                    ps.setInt(parameterIndex, mushafalquranSearch.getMushafId());
                }
                parameterIndex++;
            }

            if (mushafalquranSearch.getPenerbit() != "") {
                if (mushafalquranSearch.getPenerbit()==null){
                    ps.setNull(parameterIndex,  java.sql.Types.VARCHAR);
                }else{
                    ps.setString(parameterIndex, mushafalquranSearch.getPenerbit());
                }
                parameterIndex++;
            }

            if (mushafalquranSearch.getNegara() != "") {
                if (mushafalquranSearch.getNegara()==null){
                    ps.setNull(parameterIndex,  java.sql.Types.VARCHAR);
                }else{
                    ps.setString(parameterIndex, mushafalquranSearch.getNegara());
                }
                parameterIndex++;
            }

            if (mushafalquranSearch.getVersi() != "") {
                if (mushafalquranSearch.getVersi()==null){
                    ps.setNull(parameterIndex,  java.sql.Types.VARCHAR);
                }else{
                    ps.setString(parameterIndex, mushafalquranSearch.getVersi());
                }
                parameterIndex++;
            }

            if (mushafalquranSearch.getTahunPenerbitan() != "") {
                if (mushafalquranSearch.getTahunPenerbitan()==null){
                    ps.setNull(parameterIndex,  java.sql.Types.VARCHAR);
                }else{
                    ps.setString(parameterIndex, mushafalquranSearch.getTahunPenerbitan());
                }
                parameterIndex++;
            }

            if (mushafalquranSearch.getPenyalin() != "") {
                if (mushafalquranSearch.getPenyalin()==null){
                    ps.setNull(parameterIndex,  java.sql.Types.VARCHAR);
                }else{
                    ps.setString(parameterIndex, mushafalquranSearch.getPenyalin());
                }
                parameterIndex++;
            }

            if (mushafalquranSearch.getTahunDisahkan() != "") {
                if (mushafalquranSearch.getTahunDisahkan()==null){
                    ps.setNull(parameterIndex,  java.sql.Types.VARCHAR);
                }else{
                    ps.setString(parameterIndex, mushafalquranSearch.getTahunDisahkan());
                }
                parameterIndex++;
            }

            if (mushafalquranSearch.getMukaSurat() != "") {
                if (mushafalquranSearch.getMukaSurat()==null){
                    ps.setNull(parameterIndex,  java.sql.Types.VARCHAR);
                }else{
                    ps.setString(parameterIndex, mushafalquranSearch.getMukaSurat());
                }
                parameterIndex++;
            }

            if (mushafalquranSearch.getNamaFail() != "") {
                if (mushafalquranSearch.getNamaFail()==null){
                    ps.setNull(parameterIndex,  java.sql.Types.VARCHAR);
                }else{
                    ps.setString(parameterIndex, mushafalquranSearch.getNamaFail());
                }
                parameterIndex++;
            }

            if (mushafalquranSearch.getDirektori() != "") {
                if (mushafalquranSearch.getDirektori()==null){
                    ps.setNull(parameterIndex,  java.sql.Types.VARCHAR);
                }else{
                    ps.setString(parameterIndex, mushafalquranSearch.getDirektori());
                }
                parameterIndex++;
            }

            ResultSet rs = ps.executeQuery();

            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Mushafalquran_DBModel mushafalquranResult = new Mushafalquran_DBModel();

                    Integer mushafId = rs.getInt("MushafId");
                    String penerbit = rs.getString("Penerbit");
                    String negara = rs.getString("Negara");
                    String versi = rs.getString("Versi");
                    String tahunPenerbitan = rs.getString("TahunPenerbitan");
                    String penyalin = rs.getString("Penyalin");
                    String tahunDisahkan = rs.getString("TahunDisahkan");
                    String mukaSurat = rs.getString("MukaSurat");
                    String namaFail = rs.getString("NamaFail");
                    String direktori= rs.getString("Direktori");

                    mushafalquranResult.setMushafId(mushafId);
                    mushafalquranResult.setPenerbit(penerbit);
                    mushafalquranResult.setNegara(negara);
                    mushafalquranResult.setVersi(versi);
                    mushafalquranResult.setTahunPenerbitan(tahunPenerbitan);
                    mushafalquranResult.setPenyalin(penyalin);
                    mushafalquranResult.setTahunDisahkan(tahunDisahkan);
                    mushafalquranResult.setMukaSurat(mukaSurat);
                    mushafalquranResult.setNamaFail(namaFail);
                    mushafalquranResult.setDirektori(direktori);

                    mushafalquranResultArray.add(mushafalquranResult);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return mushafalquranResultArray;

    }

    public void insertPage(ArrayList<Bean_Feature> beansCollectionPage, Integer mushafId)
    {
        for(Bean_Feature beanPage : beansCollectionPage)
        {
            String NamePage = beanPage.getFname(); //NamaFail
            String DirectoryPage = beanPage.getType(); //Direktori

            int status = 0;
            try {
                Connection conn = MySqlDatabase.doConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO mukasurat (Mushaf,NamaFail,Direktori,s_cbya,s_abyb,s_bbyc,s_A,s_B,s_C,s_GBA,s_GBC,s_GCA,su_cbya,su_abyb,su_bbyc,su_A,su_B,su_C,su_GBA,su_GBC,su_GCA,sl_cbya,sl_abyb,sl_bbyc,sl_A,sl_B,sl_C,sl_GBA,sl_GBC,sl_GCA,stu_cbya,stu_abyb,stu_bbyc,stu_A,stu_B,stu_C,stu_GBA,stu_GBC,stu_GCA,stl_cbya,stl_abyb,stl_bbyc,stl_A,stl_B,stl_C,stl_GBA,stl_GBC,stl_GCA,sbu_cbya,sbu_abyb,sbu_bbyc,sbu_A,sbu_B,sbu_C,sbu_GBA,sbu_GBC,sbu_GCA,sbl_cbya,sbl_abyb,sbl_bbyc,sbl_A,sbl_B,sbl_C,sbl_GBA,sbl_GBC,sbl_GCA,s_Lcbya,s_Labyb,s_Lbbyc,s_LA,s_LB,s_LC,s_LGBA,s_LGBC,s_LGCA,s_Rcbya,s_Rabyb,s_Rbbyc,s_RA,s_RB,s_RC,s_RGBA,s_RGBC,s_RGCA,sLLZ_cbya,sLLZ_abyb,sLLZ_bbyc,sLLZ_A,sLLZ_B,sLLZ_C,sLLZ_GBA,sLLZ_GBC,sLLZ_GCA,sLRZ_cbya,sLRZ_abyb,sLRZ_bbyc,sLRZ_A,sLRZ_B,sLRZ_C,sLRZ_GBA,sLRZ_GBC,sLRZ_GCA,sRLZ_cbya,sRLZ_abyb,sRLZ_bbyc,sRLZ_A,sRLZ_B,sRLZ_C,sRLZ_GBA,sRLZ_GBC,sRLZ_GCA,sRRZ_cbya,sRRZ_abyb,sRRZ_bbyc,sRRZ_A,sRRZ_B,sRRZ_C,sRRZ_GBA,sRRZ_GBC,sRRZ_GCA,sLLUZ_cbya,sLLUZ_abyb,sLLUZ_bbyc,sLLUZ_A,sLLUZ_B,sLLUZ_C,sLLUZ_GBA,sLLUZ_GBC,sLLUZ_GCA,sLLBZ_cbya,sLLBZ_abyb,sLLBZ_bbyc,sLLBZ_A,sLLBZ_B,sLLBZ_C,sLLBZ_GBA,sLLBZ_GBC,sLLBZ_GCA,sLRUZ_cbya,sLRUZ_abyb,sLRUZ_bbyc,sLRUZ_A,sLRUZ_B,sLRUZ_C,sLRUZ_GBA,sLRUZ_GBC,sLRUZ_GCA,sLRBZ_cbya,sLRBZ_abyb,sLRBZ_bbyc,sLRBZ_A,sLRBZ_B,sLRBZ_C,sLRBZ_GBA,sLRBZ_GBC,sLRBZ_GCA,sRLUZ_cbya,sRLUZ_abyb,sRLUZ_bbyc,sRLUZ_A,sRLUZ_B,sRLUZ_C,sRLUZ_GBA,sRLUZ_GBC,sRLUZ_GCA,sRLBZ_cbya,sRLBZ_abyb,sRLBZ_bbyc,sRLBZ_A,sRLBZ_B,sRLBZ_C,sRLBZ_GBA,sRLBZ_GBC,sRLBZ_GCA,sRRUZ_cbya,sRRUZ_abyb,sRRUZ_bbyc,sRRUZ_A,sRRUZ_B,sRRUZ_C,sRRUZ_GBA,sRRUZ_GBC,sRRUZ_GCA,sRRBZ_cbya,sRRBZ_abyb,sRRBZ_bbyc,sRRBZ_A,sRRBZ_B,sRRBZ_C,sRRBZ_GBA,sRRBZ_GBC,sRRBZ_GCA,sPUL_cbya,sPUL_abyb,sPUL_bbyc,sPUL_A,sPUL_B,sPUL_C,sPUL_GBA,sPUL_GBC,sPUL_GCA,sPUR_cbya,sPUR_abyb,sPUR_bbyc,sPUR_A,sPUR_B,sPUR_C,sPUR_GBA,sPUR_GBC,sPUR_GCA,sPLL_cbya,sPLL_abyb,sPLL_bbyc,sPLL_A,sPLL_B,sPLL_C,sPLL_GBA,sPLL_GBC,sPLL_GCA,sPLR_cbya,sPLR_abyb,sPLR_bbyc,sPLR_A,sPLR_B,sPLR_C,sPLR_GBA,sPLR_GBC,sPLR_GCA,sALL_cbya,sALL_abyb,sALL_bbyc,sALL_A,sALL_B,sALL_C,sALL_GBA,sALL_GBC,sALL_GCA,sALR_cbya,sALR_abyb,sALR_bbyc,sALR_A,sALR_B,sALR_C,sALR_GBA,sALR_GBC,sALR_GCA,sARL_cbya,sARL_abyb,sARL_bbyc,sARL_A,sARL_B,sARL_C,sARL_GBA,sARL_GBC,sARL_GCA,sARR_cbya,sARR_abyb,sARR_bbyc,sARR_A,sARR_B,sARR_C,sARR_GBA,sARR_GBC,sARR_GCA,sBLL_cbya,sBLL_abyb,sBLL_bbyc,sBLL_A,sBLL_B,sBLL_C,sBLL_GBA,sBLL_GBC,sBLL_GCA,sBLR_cbya,sBLR_abyb,sBLR_bbyc,sBLR_A,sBLR_B,sBLR_C,sBLR_GBA,sBLR_GBC,sBLR_GCA,sBRL_cbya,sBRL_abyb,sBRL_bbyc,sBRL_A,sBRL_B,sBRL_C,sBRL_GBA,sBRL_GBC,sBRL_GCA,sBRR_cbya,sBRR_abyb,sBRR_bbyc,sBRR_A,sBRR_B,sBRR_C,sBRR_GBA,sBRR_GBC,sBRR_GCA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, mushafId);
                ps.setString(2, NamePage);
                ps.setString(3, DirectoryPage);
                writeFeatures(4,ps,beanPage);

                status = ps.executeUpdate();
                if (status != 0)
                {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next())
                        //System.out.println(rs.getInt(1));
                        if(!rs.isClosed())rs.close();
                }
                if(!ps.isClosed())ps.close();
                if(!conn.isClosed())conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //System.out.println("status : "+ status);
        }
    }

    public void insertFrame(ArrayList<Bean_Feature> beansCollectionFrame, int mushafId) {
        for(Bean_Feature beanFrame : beansCollectionFrame)
        {
            String NameFrame = beanFrame.getFname(); //NamaFail
            String DirectoryFrame = beanFrame.getType(); //Direktori

            int status = 0;
            try {
                Connection conn = MySqlDatabase.doConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO bingkai (Mushaf,NamaFail,Direktori,s_cbya,s_abyb,s_bbyc,s_A,s_B,s_C,s_GBA,s_GBC,s_GCA,su_cbya,su_abyb,su_bbyc,su_A,su_B,su_C,su_GBA,su_GBC,su_GCA,sl_cbya,sl_abyb,sl_bbyc,sl_A,sl_B,sl_C,sl_GBA,sl_GBC,sl_GCA,stu_cbya,stu_abyb,stu_bbyc,stu_A,stu_B,stu_C,stu_GBA,stu_GBC,stu_GCA,stl_cbya,stl_abyb,stl_bbyc,stl_A,stl_B,stl_C,stl_GBA,stl_GBC,stl_GCA,sbu_cbya,sbu_abyb,sbu_bbyc,sbu_A,sbu_B,sbu_C,sbu_GBA,sbu_GBC,sbu_GCA,sbl_cbya,sbl_abyb,sbl_bbyc,sbl_A,sbl_B,sbl_C,sbl_GBA,sbl_GBC,sbl_GCA,s_Lcbya,s_Labyb,s_Lbbyc,s_LA,s_LB,s_LC,s_LGBA,s_LGBC,s_LGCA,s_Rcbya,s_Rabyb,s_Rbbyc,s_RA,s_RB,s_RC,s_RGBA,s_RGBC,s_RGCA,sLLZ_cbya,sLLZ_abyb,sLLZ_bbyc,sLLZ_A,sLLZ_B,sLLZ_C,sLLZ_GBA,sLLZ_GBC,sLLZ_GCA,sLRZ_cbya,sLRZ_abyb,sLRZ_bbyc,sLRZ_A,sLRZ_B,sLRZ_C,sLRZ_GBA,sLRZ_GBC,sLRZ_GCA,sRLZ_cbya,sRLZ_abyb,sRLZ_bbyc,sRLZ_A,sRLZ_B,sRLZ_C,sRLZ_GBA,sRLZ_GBC,sRLZ_GCA,sRRZ_cbya,sRRZ_abyb,sRRZ_bbyc,sRRZ_A,sRRZ_B,sRRZ_C,sRRZ_GBA,sRRZ_GBC,sRRZ_GCA,sLLUZ_cbya,sLLUZ_abyb,sLLUZ_bbyc,sLLUZ_A,sLLUZ_B,sLLUZ_C,sLLUZ_GBA,sLLUZ_GBC,sLLUZ_GCA,sLLBZ_cbya,sLLBZ_abyb,sLLBZ_bbyc,sLLBZ_A,sLLBZ_B,sLLBZ_C,sLLBZ_GBA,sLLBZ_GBC,sLLBZ_GCA,sLRUZ_cbya,sLRUZ_abyb,sLRUZ_bbyc,sLRUZ_A,sLRUZ_B,sLRUZ_C,sLRUZ_GBA,sLRUZ_GBC,sLRUZ_GCA,sLRBZ_cbya,sLRBZ_abyb,sLRBZ_bbyc,sLRBZ_A,sLRBZ_B,sLRBZ_C,sLRBZ_GBA,sLRBZ_GBC,sLRBZ_GCA,sRLUZ_cbya,sRLUZ_abyb,sRLUZ_bbyc,sRLUZ_A,sRLUZ_B,sRLUZ_C,sRLUZ_GBA,sRLUZ_GBC,sRLUZ_GCA,sRLBZ_cbya,sRLBZ_abyb,sRLBZ_bbyc,sRLBZ_A,sRLBZ_B,sRLBZ_C,sRLBZ_GBA,sRLBZ_GBC,sRLBZ_GCA,sRRUZ_cbya,sRRUZ_abyb,sRRUZ_bbyc,sRRUZ_A,sRRUZ_B,sRRUZ_C,sRRUZ_GBA,sRRUZ_GBC,sRRUZ_GCA,sRRBZ_cbya,sRRBZ_abyb,sRRBZ_bbyc,sRRBZ_A,sRRBZ_B,sRRBZ_C,sRRBZ_GBA,sRRBZ_GBC,sRRBZ_GCA,sPUL_cbya,sPUL_abyb,sPUL_bbyc,sPUL_A,sPUL_B,sPUL_C,sPUL_GBA,sPUL_GBC,sPUL_GCA,sPUR_cbya,sPUR_abyb,sPUR_bbyc,sPUR_A,sPUR_B,sPUR_C,sPUR_GBA,sPUR_GBC,sPUR_GCA,sPLL_cbya,sPLL_abyb,sPLL_bbyc,sPLL_A,sPLL_B,sPLL_C,sPLL_GBA,sPLL_GBC,sPLL_GCA,sPLR_cbya,sPLR_abyb,sPLR_bbyc,sPLR_A,sPLR_B,sPLR_C,sPLR_GBA,sPLR_GBC,sPLR_GCA,sALL_cbya,sALL_abyb,sALL_bbyc,sALL_A,sALL_B,sALL_C,sALL_GBA,sALL_GBC,sALL_GCA,sALR_cbya,sALR_abyb,sALR_bbyc,sALR_A,sALR_B,sALR_C,sALR_GBA,sALR_GBC,sALR_GCA,sARL_cbya,sARL_abyb,sARL_bbyc,sARL_A,sARL_B,sARL_C,sARL_GBA,sARL_GBC,sARL_GCA,sARR_cbya,sARR_abyb,sARR_bbyc,sARR_A,sARR_B,sARR_C,sARR_GBA,sARR_GBC,sARR_GCA,sBLL_cbya,sBLL_abyb,sBLL_bbyc,sBLL_A,sBLL_B,sBLL_C,sBLL_GBA,sBLL_GBC,sBLL_GCA,sBLR_cbya,sBLR_abyb,sBLR_bbyc,sBLR_A,sBLR_B,sBLR_C,sBLR_GBA,sBLR_GBC,sBLR_GCA,sBRL_cbya,sBRL_abyb,sBRL_bbyc,sBRL_A,sBRL_B,sBRL_C,sBRL_GBA,sBRL_GBC,sBRL_GCA,sBRR_cbya,sBRR_abyb,sBRR_bbyc,sBRR_A,sBRR_B,sBRR_C,sBRR_GBA,sBRR_GBC,sBRR_GCA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, mushafId);
                ps.setString(2, NameFrame);
                ps.setString(3, DirectoryFrame);
                writeFeatures(4,ps,beanFrame);

                status = ps.executeUpdate();
                if (status != 0)
                {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next())
                        //System.out.println(rs.getInt(1));
                        if(!rs.isClosed())rs.close();
                }
                if(!ps.isClosed())ps.close();
                if(!conn.isClosed())conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void insertText(ArrayList<Bean_Feature> beansCollectionText, Integer mushafId) {
        for(Bean_Feature beanText : beansCollectionText)
        {
            String NameText = beanText.getFname(); //NamaFail
            String DirectoryText = beanText.getType(); //Direktori

            int status = 0;
            try {
                Connection conn = MySqlDatabase.doConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO teks (Mushaf,NamaFail,Direktori,s_cbya,s_abyb,s_bbyc,s_A,s_B,s_C,s_GBA,s_GBC,s_GCA,su_cbya,su_abyb,su_bbyc,su_A,su_B,su_C,su_GBA,su_GBC,su_GCA,sl_cbya,sl_abyb,sl_bbyc,sl_A,sl_B,sl_C,sl_GBA,sl_GBC,sl_GCA,stu_cbya,stu_abyb,stu_bbyc,stu_A,stu_B,stu_C,stu_GBA,stu_GBC,stu_GCA,stl_cbya,stl_abyb,stl_bbyc,stl_A,stl_B,stl_C,stl_GBA,stl_GBC,stl_GCA,sbu_cbya,sbu_abyb,sbu_bbyc,sbu_A,sbu_B,sbu_C,sbu_GBA,sbu_GBC,sbu_GCA,sbl_cbya,sbl_abyb,sbl_bbyc,sbl_A,sbl_B,sbl_C,sbl_GBA,sbl_GBC,sbl_GCA,s_Lcbya,s_Labyb,s_Lbbyc,s_LA,s_LB,s_LC,s_LGBA,s_LGBC,s_LGCA,s_Rcbya,s_Rabyb,s_Rbbyc,s_RA,s_RB,s_RC,s_RGBA,s_RGBC,s_RGCA,sLLZ_cbya,sLLZ_abyb,sLLZ_bbyc,sLLZ_A,sLLZ_B,sLLZ_C,sLLZ_GBA,sLLZ_GBC,sLLZ_GCA,sLRZ_cbya,sLRZ_abyb,sLRZ_bbyc,sLRZ_A,sLRZ_B,sLRZ_C,sLRZ_GBA,sLRZ_GBC,sLRZ_GCA,sRLZ_cbya,sRLZ_abyb,sRLZ_bbyc,sRLZ_A,sRLZ_B,sRLZ_C,sRLZ_GBA,sRLZ_GBC,sRLZ_GCA,sRRZ_cbya,sRRZ_abyb,sRRZ_bbyc,sRRZ_A,sRRZ_B,sRRZ_C,sRRZ_GBA,sRRZ_GBC,sRRZ_GCA,sLLUZ_cbya,sLLUZ_abyb,sLLUZ_bbyc,sLLUZ_A,sLLUZ_B,sLLUZ_C,sLLUZ_GBA,sLLUZ_GBC,sLLUZ_GCA,sLLBZ_cbya,sLLBZ_abyb,sLLBZ_bbyc,sLLBZ_A,sLLBZ_B,sLLBZ_C,sLLBZ_GBA,sLLBZ_GBC,sLLBZ_GCA,sLRUZ_cbya,sLRUZ_abyb,sLRUZ_bbyc,sLRUZ_A,sLRUZ_B,sLRUZ_C,sLRUZ_GBA,sLRUZ_GBC,sLRUZ_GCA,sLRBZ_cbya,sLRBZ_abyb,sLRBZ_bbyc,sLRBZ_A,sLRBZ_B,sLRBZ_C,sLRBZ_GBA,sLRBZ_GBC,sLRBZ_GCA,sRLUZ_cbya,sRLUZ_abyb,sRLUZ_bbyc,sRLUZ_A,sRLUZ_B,sRLUZ_C,sRLUZ_GBA,sRLUZ_GBC,sRLUZ_GCA,sRLBZ_cbya,sRLBZ_abyb,sRLBZ_bbyc,sRLBZ_A,sRLBZ_B,sRLBZ_C,sRLBZ_GBA,sRLBZ_GBC,sRLBZ_GCA,sRRUZ_cbya,sRRUZ_abyb,sRRUZ_bbyc,sRRUZ_A,sRRUZ_B,sRRUZ_C,sRRUZ_GBA,sRRUZ_GBC,sRRUZ_GCA,sRRBZ_cbya,sRRBZ_abyb,sRRBZ_bbyc,sRRBZ_A,sRRBZ_B,sRRBZ_C,sRRBZ_GBA,sRRBZ_GBC,sRRBZ_GCA,sPUL_cbya,sPUL_abyb,sPUL_bbyc,sPUL_A,sPUL_B,sPUL_C,sPUL_GBA,sPUL_GBC,sPUL_GCA,sPUR_cbya,sPUR_abyb,sPUR_bbyc,sPUR_A,sPUR_B,sPUR_C,sPUR_GBA,sPUR_GBC,sPUR_GCA,sPLL_cbya,sPLL_abyb,sPLL_bbyc,sPLL_A,sPLL_B,sPLL_C,sPLL_GBA,sPLL_GBC,sPLL_GCA,sPLR_cbya,sPLR_abyb,sPLR_bbyc,sPLR_A,sPLR_B,sPLR_C,sPLR_GBA,sPLR_GBC,sPLR_GCA,sALL_cbya,sALL_abyb,sALL_bbyc,sALL_A,sALL_B,sALL_C,sALL_GBA,sALL_GBC,sALL_GCA,sALR_cbya,sALR_abyb,sALR_bbyc,sALR_A,sALR_B,sALR_C,sALR_GBA,sALR_GBC,sALR_GCA,sARL_cbya,sARL_abyb,sARL_bbyc,sARL_A,sARL_B,sARL_C,sARL_GBA,sARL_GBC,sARL_GCA,sARR_cbya,sARR_abyb,sARR_bbyc,sARR_A,sARR_B,sARR_C,sARR_GBA,sARR_GBC,sARR_GCA,sBLL_cbya,sBLL_abyb,sBLL_bbyc,sBLL_A,sBLL_B,sBLL_C,sBLL_GBA,sBLL_GBC,sBLL_GCA,sBLR_cbya,sBLR_abyb,sBLR_bbyc,sBLR_A,sBLR_B,sBLR_C,sBLR_GBA,sBLR_GBC,sBLR_GCA,sBRL_cbya,sBRL_abyb,sBRL_bbyc,sBRL_A,sBRL_B,sBRL_C,sBRL_GBA,sBRL_GBC,sBRL_GCA,sBRR_cbya,sBRR_abyb,sBRR_bbyc,sBRR_A,sBRR_B,sBRR_C,sBRR_GBA,sBRR_GBC,sBRR_GCA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, mushafId);
                ps.setString(2, NameText);
                ps.setString(3, DirectoryText);
                writeFeatures(4,ps,beanText);

                status = ps.executeUpdate();
                if (status != 0)
                {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next())
                        //System.out.println(rs.getInt(1));
                        if(!rs.isClosed())rs.close();
                }
                if(!ps.isClosed())ps.close();
                if(!conn.isClosed())conn.close();
            } catch ( SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void insertRowsOverlap(ArrayList<Bean_Feature> beansCollectionRowsOverlap, Integer mushafId) {
        for(Bean_Feature beanRowsOverlap : beansCollectionRowsOverlap)
        {
            String NameRowsOverlap = beanRowsOverlap.getFname(); //NamaFail
            String DirectoryRowsOverlap = beanRowsOverlap.getType(); //Direktori

            String[] parts = NameRowsOverlap.split("_");//OverlapLineJava_Majeed_2015_001_1&2.jpg
            String part = parts[parts.length-1];//1&2.jpg
            String[] rowNumbers = part.split("\\.");//1&2.jpg
            String rowNumber = rowNumbers[0];//1&2

            int status = 0;
            try {
                Connection conn = MySqlDatabase.doConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO barisbertindih (Mushaf,NomborBaris,NamaFail,Direktori,s_cbya,s_abyb,s_bbyc,s_A,s_B,s_C,s_GBA,s_GBC,s_GCA,su_cbya,su_abyb,su_bbyc,su_A,su_B,su_C,su_GBA,su_GBC,su_GCA,sl_cbya,sl_abyb,sl_bbyc,sl_A,sl_B,sl_C,sl_GBA,sl_GBC,sl_GCA,stu_cbya,stu_abyb,stu_bbyc,stu_A,stu_B,stu_C,stu_GBA,stu_GBC,stu_GCA,stl_cbya,stl_abyb,stl_bbyc,stl_A,stl_B,stl_C,stl_GBA,stl_GBC,stl_GCA,sbu_cbya,sbu_abyb,sbu_bbyc,sbu_A,sbu_B,sbu_C,sbu_GBA,sbu_GBC,sbu_GCA,sbl_cbya,sbl_abyb,sbl_bbyc,sbl_A,sbl_B,sbl_C,sbl_GBA,sbl_GBC,sbl_GCA,s_Lcbya,s_Labyb,s_Lbbyc,s_LA,s_LB,s_LC,s_LGBA,s_LGBC,s_LGCA,s_Rcbya,s_Rabyb,s_Rbbyc,s_RA,s_RB,s_RC,s_RGBA,s_RGBC,s_RGCA,sLLZ_cbya,sLLZ_abyb,sLLZ_bbyc,sLLZ_A,sLLZ_B,sLLZ_C,sLLZ_GBA,sLLZ_GBC,sLLZ_GCA,sLRZ_cbya,sLRZ_abyb,sLRZ_bbyc,sLRZ_A,sLRZ_B,sLRZ_C,sLRZ_GBA,sLRZ_GBC,sLRZ_GCA,sRLZ_cbya,sRLZ_abyb,sRLZ_bbyc,sRLZ_A,sRLZ_B,sRLZ_C,sRLZ_GBA,sRLZ_GBC,sRLZ_GCA,sRRZ_cbya,sRRZ_abyb,sRRZ_bbyc,sRRZ_A,sRRZ_B,sRRZ_C,sRRZ_GBA,sRRZ_GBC,sRRZ_GCA,sLLUZ_cbya,sLLUZ_abyb,sLLUZ_bbyc,sLLUZ_A,sLLUZ_B,sLLUZ_C,sLLUZ_GBA,sLLUZ_GBC,sLLUZ_GCA,sLLBZ_cbya,sLLBZ_abyb,sLLBZ_bbyc,sLLBZ_A,sLLBZ_B,sLLBZ_C,sLLBZ_GBA,sLLBZ_GBC,sLLBZ_GCA,sLRUZ_cbya,sLRUZ_abyb,sLRUZ_bbyc,sLRUZ_A,sLRUZ_B,sLRUZ_C,sLRUZ_GBA,sLRUZ_GBC,sLRUZ_GCA,sLRBZ_cbya,sLRBZ_abyb,sLRBZ_bbyc,sLRBZ_A,sLRBZ_B,sLRBZ_C,sLRBZ_GBA,sLRBZ_GBC,sLRBZ_GCA,sRLUZ_cbya,sRLUZ_abyb,sRLUZ_bbyc,sRLUZ_A,sRLUZ_B,sRLUZ_C,sRLUZ_GBA,sRLUZ_GBC,sRLUZ_GCA,sRLBZ_cbya,sRLBZ_abyb,sRLBZ_bbyc,sRLBZ_A,sRLBZ_B,sRLBZ_C,sRLBZ_GBA,sRLBZ_GBC,sRLBZ_GCA,sRRUZ_cbya,sRRUZ_abyb,sRRUZ_bbyc,sRRUZ_A,sRRUZ_B,sRRUZ_C,sRRUZ_GBA,sRRUZ_GBC,sRRUZ_GCA,sRRBZ_cbya,sRRBZ_abyb,sRRBZ_bbyc,sRRBZ_A,sRRBZ_B,sRRBZ_C,sRRBZ_GBA,sRRBZ_GBC,sRRBZ_GCA,sPUL_cbya,sPUL_abyb,sPUL_bbyc,sPUL_A,sPUL_B,sPUL_C,sPUL_GBA,sPUL_GBC,sPUL_GCA,sPUR_cbya,sPUR_abyb,sPUR_bbyc,sPUR_A,sPUR_B,sPUR_C,sPUR_GBA,sPUR_GBC,sPUR_GCA,sPLL_cbya,sPLL_abyb,sPLL_bbyc,sPLL_A,sPLL_B,sPLL_C,sPLL_GBA,sPLL_GBC,sPLL_GCA,sPLR_cbya,sPLR_abyb,sPLR_bbyc,sPLR_A,sPLR_B,sPLR_C,sPLR_GBA,sPLR_GBC,sPLR_GCA,sALL_cbya,sALL_abyb,sALL_bbyc,sALL_A,sALL_B,sALL_C,sALL_GBA,sALL_GBC,sALL_GCA,sALR_cbya,sALR_abyb,sALR_bbyc,sALR_A,sALR_B,sALR_C,sALR_GBA,sALR_GBC,sALR_GCA,sARL_cbya,sARL_abyb,sARL_bbyc,sARL_A,sARL_B,sARL_C,sARL_GBA,sARL_GBC,sARL_GCA,sARR_cbya,sARR_abyb,sARR_bbyc,sARR_A,sARR_B,sARR_C,sARR_GBA,sARR_GBC,sARR_GCA,sBLL_cbya,sBLL_abyb,sBLL_bbyc,sBLL_A,sBLL_B,sBLL_C,sBLL_GBA,sBLL_GBC,sBLL_GCA,sBLR_cbya,sBLR_abyb,sBLR_bbyc,sBLR_A,sBLR_B,sBLR_C,sBLR_GBA,sBLR_GBC,sBLR_GCA,sBRL_cbya,sBRL_abyb,sBRL_bbyc,sBRL_A,sBRL_B,sBRL_C,sBRL_GBA,sBRL_GBC,sBRL_GCA,sBRR_cbya,sBRR_abyb,sBRR_bbyc,sBRR_A,sBRR_B,sBRR_C,sBRR_GBA,sBRR_GBC,sBRR_GCA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, mushafId);
                ps.setString(2, rowNumber);
                ps.setString(3, NameRowsOverlap);
                ps.setString(4, DirectoryRowsOverlap);
                writeFeatures(5,ps,beanRowsOverlap);

                status = ps.executeUpdate();
                if (status != 0)
                {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next())
                        //System.out.println(rs.getInt(1));
                        if(!rs.isClosed())rs.close();
                }
                if(!ps.isClosed())ps.close();
                if(!conn.isClosed())conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void insertRowsActual(ArrayList<Bean_Feature> beansCollectionRowsActual, Integer mushafId) {
        for(Bean_Feature beanRowsActual : beansCollectionRowsActual)
        {
            String NameRowsActual = beanRowsActual.getFname(); //NamaFail
            String DirectoryRowsActual = beanRowsActual.getType(); //Direktori

            String[] parts = DirectoryRowsActual.split("_");//OverlapLineJava_Majeed_2015_001_1.jpg
            String part = parts[parts.length-1];//1.jpg
            String[] rowNumbers = part.split("\\.");//1.jpg
            int rowNumber = Integer.parseInt(rowNumbers[0]);//1

            int status = 0;
            try {
                Connection conn = MySqlDatabase.doConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO baris (Mushaf,NomborBaris,NamaFail,Direktori,s_cbya,s_abyb,s_bbyc,s_A,s_B,s_C,s_GBA,s_GBC,s_GCA,su_cbya,su_abyb,su_bbyc,su_A,su_B,su_C,su_GBA,su_GBC,su_GCA,sl_cbya,sl_abyb,sl_bbyc,sl_A,sl_B,sl_C,sl_GBA,sl_GBC,sl_GCA,stu_cbya,stu_abyb,stu_bbyc,stu_A,stu_B,stu_C,stu_GBA,stu_GBC,stu_GCA,stl_cbya,stl_abyb,stl_bbyc,stl_A,stl_B,stl_C,stl_GBA,stl_GBC,stl_GCA,sbu_cbya,sbu_abyb,sbu_bbyc,sbu_A,sbu_B,sbu_C,sbu_GBA,sbu_GBC,sbu_GCA,sbl_cbya,sbl_abyb,sbl_bbyc,sbl_A,sbl_B,sbl_C,sbl_GBA,sbl_GBC,sbl_GCA,s_Lcbya,s_Labyb,s_Lbbyc,s_LA,s_LB,s_LC,s_LGBA,s_LGBC,s_LGCA,s_Rcbya,s_Rabyb,s_Rbbyc,s_RA,s_RB,s_RC,s_RGBA,s_RGBC,s_RGCA,sLLZ_cbya,sLLZ_abyb,sLLZ_bbyc,sLLZ_A,sLLZ_B,sLLZ_C,sLLZ_GBA,sLLZ_GBC,sLLZ_GCA,sLRZ_cbya,sLRZ_abyb,sLRZ_bbyc,sLRZ_A,sLRZ_B,sLRZ_C,sLRZ_GBA,sLRZ_GBC,sLRZ_GCA,sRLZ_cbya,sRLZ_abyb,sRLZ_bbyc,sRLZ_A,sRLZ_B,sRLZ_C,sRLZ_GBA,sRLZ_GBC,sRLZ_GCA,sRRZ_cbya,sRRZ_abyb,sRRZ_bbyc,sRRZ_A,sRRZ_B,sRRZ_C,sRRZ_GBA,sRRZ_GBC,sRRZ_GCA,sLLUZ_cbya,sLLUZ_abyb,sLLUZ_bbyc,sLLUZ_A,sLLUZ_B,sLLUZ_C,sLLUZ_GBA,sLLUZ_GBC,sLLUZ_GCA,sLLBZ_cbya,sLLBZ_abyb,sLLBZ_bbyc,sLLBZ_A,sLLBZ_B,sLLBZ_C,sLLBZ_GBA,sLLBZ_GBC,sLLBZ_GCA,sLRUZ_cbya,sLRUZ_abyb,sLRUZ_bbyc,sLRUZ_A,sLRUZ_B,sLRUZ_C,sLRUZ_GBA,sLRUZ_GBC,sLRUZ_GCA,sLRBZ_cbya,sLRBZ_abyb,sLRBZ_bbyc,sLRBZ_A,sLRBZ_B,sLRBZ_C,sLRBZ_GBA,sLRBZ_GBC,sLRBZ_GCA,sRLUZ_cbya,sRLUZ_abyb,sRLUZ_bbyc,sRLUZ_A,sRLUZ_B,sRLUZ_C,sRLUZ_GBA,sRLUZ_GBC,sRLUZ_GCA,sRLBZ_cbya,sRLBZ_abyb,sRLBZ_bbyc,sRLBZ_A,sRLBZ_B,sRLBZ_C,sRLBZ_GBA,sRLBZ_GBC,sRLBZ_GCA,sRRUZ_cbya,sRRUZ_abyb,sRRUZ_bbyc,sRRUZ_A,sRRUZ_B,sRRUZ_C,sRRUZ_GBA,sRRUZ_GBC,sRRUZ_GCA,sRRBZ_cbya,sRRBZ_abyb,sRRBZ_bbyc,sRRBZ_A,sRRBZ_B,sRRBZ_C,sRRBZ_GBA,sRRBZ_GBC,sRRBZ_GCA,sPUL_cbya,sPUL_abyb,sPUL_bbyc,sPUL_A,sPUL_B,sPUL_C,sPUL_GBA,sPUL_GBC,sPUL_GCA,sPUR_cbya,sPUR_abyb,sPUR_bbyc,sPUR_A,sPUR_B,sPUR_C,sPUR_GBA,sPUR_GBC,sPUR_GCA,sPLL_cbya,sPLL_abyb,sPLL_bbyc,sPLL_A,sPLL_B,sPLL_C,sPLL_GBA,sPLL_GBC,sPLL_GCA,sPLR_cbya,sPLR_abyb,sPLR_bbyc,sPLR_A,sPLR_B,sPLR_C,sPLR_GBA,sPLR_GBC,sPLR_GCA,sALL_cbya,sALL_abyb,sALL_bbyc,sALL_A,sALL_B,sALL_C,sALL_GBA,sALL_GBC,sALL_GCA,sALR_cbya,sALR_abyb,sALR_bbyc,sALR_A,sALR_B,sALR_C,sALR_GBA,sALR_GBC,sALR_GCA,sARL_cbya,sARL_abyb,sARL_bbyc,sARL_A,sARL_B,sARL_C,sARL_GBA,sARL_GBC,sARL_GCA,sARR_cbya,sARR_abyb,sARR_bbyc,sARR_A,sARR_B,sARR_C,sARR_GBA,sARR_GBC,sARR_GCA,sBLL_cbya,sBLL_abyb,sBLL_bbyc,sBLL_A,sBLL_B,sBLL_C,sBLL_GBA,sBLL_GBC,sBLL_GCA,sBLR_cbya,sBLR_abyb,sBLR_bbyc,sBLR_A,sBLR_B,sBLR_C,sBLR_GBA,sBLR_GBC,sBLR_GCA,sBRL_cbya,sBRL_abyb,sBRL_bbyc,sBRL_A,sBRL_B,sBRL_C,sBRL_GBA,sBRL_GBC,sBRL_GCA,sBRR_cbya,sBRR_abyb,sBRR_bbyc,sBRR_A,sBRR_B,sBRR_C,sBRR_GBA,sBRR_GBC,sBRR_GCA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, mushafId);
                ps.setInt(2, rowNumber);
                ps.setString(3, NameRowsActual);
                ps.setString(4, DirectoryRowsActual);
                writeFeatures(5,ps,beanRowsActual);

                status = ps.executeUpdate();
                if (status != 0)
                {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next())
                        //System.out.println(rs.getInt(1));
                        if(!rs.isClosed())rs.close();
                }
                if(!ps.isClosed())ps.close();
                if(!conn.isClosed())conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void insertMarkedRed(ArrayList<Bean_Feature> beansCollectionMarkedRed) {
        for(Bean_Feature beanMarkedRed : beansCollectionMarkedRed)
        {
            String NameMarkedRed = beanMarkedRed.getFname(); //NamaFail
            String DirectoryMarkedRed = beanMarkedRed.getType(); //Direktori

            Mushafalquran_DBModel mushafalquranSearch = new Mushafalquran_DBModel();
            mushafalquranSearch.setNamaFail(NameMarkedRed);
            ArrayList<Mushafalquran_DBModel> mushafalquranResultArray = searchMushafalquran (mushafalquranSearch);
            if (mushafalquranResultArray.isEmpty())
                JOptionPane.showMessageDialog(null, "File name has no record in database.Please insert record before procced.", "No record", JOptionPane.WARNING_MESSAGE);
            if (mushafalquranResultArray.size()>=2)
                JOptionPane.showMessageDialog(null, "File name has more than one record in database. Hence, first ID index will be choose to save in the database.", "Duplicate record", JOptionPane.WARNING_MESSAGE);

            Integer mushafId = mushafalquranResultArray.get(0).getMushafId(); //Mushaf

            int status = 0;
            try {
                Connection conn = MySqlDatabase.doConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO wakafpadabaris (Mushaf,NamaFail,Direktori,s_cbya,s_abyb,s_bbyc,s_A,s_B,s_C,s_GBA,s_GBC,s_GCA,su_cbya,su_abyb,su_bbyc,su_A,su_B,su_C,su_GBA,su_GBC,su_GCA,sl_cbya,sl_abyb,sl_bbyc,sl_A,sl_B,sl_C,sl_GBA,sl_GBC,sl_GCA,stu_cbya,stu_abyb,stu_bbyc,stu_A,stu_B,stu_C,stu_GBA,stu_GBC,stu_GCA,stl_cbya,stl_abyb,stl_bbyc,stl_A,stl_B,stl_C,stl_GBA,stl_GBC,stl_GCA,sbu_cbya,sbu_abyb,sbu_bbyc,sbu_A,sbu_B,sbu_C,sbu_GBA,sbu_GBC,sbu_GCA,sbl_cbya,sbl_abyb,sbl_bbyc,sbl_A,sbl_B,sbl_C,sbl_GBA,sbl_GBC,sbl_GCA,s_Lcbya,s_Labyb,s_Lbbyc,s_LA,s_LB,s_LC,s_LGBA,s_LGBC,s_LGCA,s_Rcbya,s_Rabyb,s_Rbbyc,s_RA,s_RB,s_RC,s_RGBA,s_RGBC,s_RGCA,sLLZ_cbya,sLLZ_abyb,sLLZ_bbyc,sLLZ_A,sLLZ_B,sLLZ_C,sLLZ_GBA,sLLZ_GBC,sLLZ_GCA,sLRZ_cbya,sLRZ_abyb,sLRZ_bbyc,sLRZ_A,sLRZ_B,sLRZ_C,sLRZ_GBA,sLRZ_GBC,sLRZ_GCA,sRLZ_cbya,sRLZ_abyb,sRLZ_bbyc,sRLZ_A,sRLZ_B,sRLZ_C,sRLZ_GBA,sRLZ_GBC,sRLZ_GCA,sRRZ_cbya,sRRZ_abyb,sRRZ_bbyc,sRRZ_A,sRRZ_B,sRRZ_C,sRRZ_GBA,sRRZ_GBC,sRRZ_GCA,sLLUZ_cbya,sLLUZ_abyb,sLLUZ_bbyc,sLLUZ_A,sLLUZ_B,sLLUZ_C,sLLUZ_GBA,sLLUZ_GBC,sLLUZ_GCA,sLLBZ_cbya,sLLBZ_abyb,sLLBZ_bbyc,sLLBZ_A,sLLBZ_B,sLLBZ_C,sLLBZ_GBA,sLLBZ_GBC,sLLBZ_GCA,sLRUZ_cbya,sLRUZ_abyb,sLRUZ_bbyc,sLRUZ_A,sLRUZ_B,sLRUZ_C,sLRUZ_GBA,sLRUZ_GBC,sLRUZ_GCA,sLRBZ_cbya,sLRBZ_abyb,sLRBZ_bbyc,sLRBZ_A,sLRBZ_B,sLRBZ_C,sLRBZ_GBA,sLRBZ_GBC,sLRBZ_GCA,sRLUZ_cbya,sRLUZ_abyb,sRLUZ_bbyc,sRLUZ_A,sRLUZ_B,sRLUZ_C,sRLUZ_GBA,sRLUZ_GBC,sRLUZ_GCA,sRLBZ_cbya,sRLBZ_abyb,sRLBZ_bbyc,sRLBZ_A,sRLBZ_B,sRLBZ_C,sRLBZ_GBA,sRLBZ_GBC,sRLBZ_GCA,sRRUZ_cbya,sRRUZ_abyb,sRRUZ_bbyc,sRRUZ_A,sRRUZ_B,sRRUZ_C,sRRUZ_GBA,sRRUZ_GBC,sRRUZ_GCA,sRRBZ_cbya,sRRBZ_abyb,sRRBZ_bbyc,sRRBZ_A,sRRBZ_B,sRRBZ_C,sRRBZ_GBA,sRRBZ_GBC,sRRBZ_GCA,sPUL_cbya,sPUL_abyb,sPUL_bbyc,sPUL_A,sPUL_B,sPUL_C,sPUL_GBA,sPUL_GBC,sPUL_GCA,sPUR_cbya,sPUR_abyb,sPUR_bbyc,sPUR_A,sPUR_B,sPUR_C,sPUR_GBA,sPUR_GBC,sPUR_GCA,sPLL_cbya,sPLL_abyb,sPLL_bbyc,sPLL_A,sPLL_B,sPLL_C,sPLL_GBA,sPLL_GBC,sPLL_GCA,sPLR_cbya,sPLR_abyb,sPLR_bbyc,sPLR_A,sPLR_B,sPLR_C,sPLR_GBA,sPLR_GBC,sPLR_GCA,sALL_cbya,sALL_abyb,sALL_bbyc,sALL_A,sALL_B,sALL_C,sALL_GBA,sALL_GBC,sALL_GCA,sALR_cbya,sALR_abyb,sALR_bbyc,sALR_A,sALR_B,sALR_C,sALR_GBA,sALR_GBC,sALR_GCA,sARL_cbya,sARL_abyb,sARL_bbyc,sARL_A,sARL_B,sARL_C,sARL_GBA,sARL_GBC,sARL_GCA,sARR_cbya,sARR_abyb,sARR_bbyc,sARR_A,sARR_B,sARR_C,sARR_GBA,sARR_GBC,sARR_GCA,sBLL_cbya,sBLL_abyb,sBLL_bbyc,sBLL_A,sBLL_B,sBLL_C,sBLL_GBA,sBLL_GBC,sBLL_GCA,sBLR_cbya,sBLR_abyb,sBLR_bbyc,sBLR_A,sBLR_B,sBLR_C,sBLR_GBA,sBLR_GBC,sBLR_GCA,sBRL_cbya,sBRL_abyb,sBRL_bbyc,sBRL_A,sBRL_B,sBRL_C,sBRL_GBA,sBRL_GBC,sBRL_GCA,sBRR_cbya,sBRR_abyb,sBRR_bbyc,sBRR_A,sBRR_B,sBRR_C,sBRR_GBA,sBRR_GBC,sBRR_GCA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, mushafId);
                ps.setString(2, NameMarkedRed);
                ps.setString(3, DirectoryMarkedRed);
                writeFeatures(4,ps,beanMarkedRed);

                status = ps.executeUpdate();
                if (status != 0)
                {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next())
                        //System.out.println(rs.getInt(1));
                        if(!rs.isClosed())rs.close();
                }
                if(!ps.isClosed())ps.close();
                if(!conn.isClosed())conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void insertVerse(ArrayList<Bean_Feature> beansCollectionVerse, Integer mushafId) {
        for(Bean_Feature beanVerse : beansCollectionVerse)
        {
            String NameVerse = beanVerse.getFname(); //NamaFail
            String DirectoryVerse = beanVerse.getType(); //Direktori

            String[] parts = DirectoryVerse.split("_");//OverlapLineJava_Majeed_2015_001_1.jpg
            String part = parts[parts.length-1];//1.jpg
            String[] rowNumbers = part.split("\\.");//1.jpg
            int rowNumber = Integer.parseInt(rowNumbers[0]);//1

            int status = 0;
            try {
                Connection conn = MySqlDatabase.doConnection();
                PreparedStatement ps = conn.prepareStatement("INSERT INTO ayat (Mushaf,NomborAyat,NamaFail,Direktori,s_cbya,s_abyb,s_bbyc,s_A,s_B,s_C,s_GBA,s_GBC,s_GCA,su_cbya,su_abyb,su_bbyc,su_A,su_B,su_C,su_GBA,su_GBC,su_GCA,sl_cbya,sl_abyb,sl_bbyc,sl_A,sl_B,sl_C,sl_GBA,sl_GBC,sl_GCA,stu_cbya,stu_abyb,stu_bbyc,stu_A,stu_B,stu_C,stu_GBA,stu_GBC,stu_GCA,stl_cbya,stl_abyb,stl_bbyc,stl_A,stl_B,stl_C,stl_GBA,stl_GBC,stl_GCA,sbu_cbya,sbu_abyb,sbu_bbyc,sbu_A,sbu_B,sbu_C,sbu_GBA,sbu_GBC,sbu_GCA,sbl_cbya,sbl_abyb,sbl_bbyc,sbl_A,sbl_B,sbl_C,sbl_GBA,sbl_GBC,sbl_GCA,s_Lcbya,s_Labyb,s_Lbbyc,s_LA,s_LB,s_LC,s_LGBA,s_LGBC,s_LGCA,s_Rcbya,s_Rabyb,s_Rbbyc,s_RA,s_RB,s_RC,s_RGBA,s_RGBC,s_RGCA,sLLZ_cbya,sLLZ_abyb,sLLZ_bbyc,sLLZ_A,sLLZ_B,sLLZ_C,sLLZ_GBA,sLLZ_GBC,sLLZ_GCA,sLRZ_cbya,sLRZ_abyb,sLRZ_bbyc,sLRZ_A,sLRZ_B,sLRZ_C,sLRZ_GBA,sLRZ_GBC,sLRZ_GCA,sRLZ_cbya,sRLZ_abyb,sRLZ_bbyc,sRLZ_A,sRLZ_B,sRLZ_C,sRLZ_GBA,sRLZ_GBC,sRLZ_GCA,sRRZ_cbya,sRRZ_abyb,sRRZ_bbyc,sRRZ_A,sRRZ_B,sRRZ_C,sRRZ_GBA,sRRZ_GBC,sRRZ_GCA,sLLUZ_cbya,sLLUZ_abyb,sLLUZ_bbyc,sLLUZ_A,sLLUZ_B,sLLUZ_C,sLLUZ_GBA,sLLUZ_GBC,sLLUZ_GCA,sLLBZ_cbya,sLLBZ_abyb,sLLBZ_bbyc,sLLBZ_A,sLLBZ_B,sLLBZ_C,sLLBZ_GBA,sLLBZ_GBC,sLLBZ_GCA,sLRUZ_cbya,sLRUZ_abyb,sLRUZ_bbyc,sLRUZ_A,sLRUZ_B,sLRUZ_C,sLRUZ_GBA,sLRUZ_GBC,sLRUZ_GCA,sLRBZ_cbya,sLRBZ_abyb,sLRBZ_bbyc,sLRBZ_A,sLRBZ_B,sLRBZ_C,sLRBZ_GBA,sLRBZ_GBC,sLRBZ_GCA,sRLUZ_cbya,sRLUZ_abyb,sRLUZ_bbyc,sRLUZ_A,sRLUZ_B,sRLUZ_C,sRLUZ_GBA,sRLUZ_GBC,sRLUZ_GCA,sRLBZ_cbya,sRLBZ_abyb,sRLBZ_bbyc,sRLBZ_A,sRLBZ_B,sRLBZ_C,sRLBZ_GBA,sRLBZ_GBC,sRLBZ_GCA,sRRUZ_cbya,sRRUZ_abyb,sRRUZ_bbyc,sRRUZ_A,sRRUZ_B,sRRUZ_C,sRRUZ_GBA,sRRUZ_GBC,sRRUZ_GCA,sRRBZ_cbya,sRRBZ_abyb,sRRBZ_bbyc,sRRBZ_A,sRRBZ_B,sRRBZ_C,sRRBZ_GBA,sRRBZ_GBC,sRRBZ_GCA,sPUL_cbya,sPUL_abyb,sPUL_bbyc,sPUL_A,sPUL_B,sPUL_C,sPUL_GBA,sPUL_GBC,sPUL_GCA,sPUR_cbya,sPUR_abyb,sPUR_bbyc,sPUR_A,sPUR_B,sPUR_C,sPUR_GBA,sPUR_GBC,sPUR_GCA,sPLL_cbya,sPLL_abyb,sPLL_bbyc,sPLL_A,sPLL_B,sPLL_C,sPLL_GBA,sPLL_GBC,sPLL_GCA,sPLR_cbya,sPLR_abyb,sPLR_bbyc,sPLR_A,sPLR_B,sPLR_C,sPLR_GBA,sPLR_GBC,sPLR_GCA,sALL_cbya,sALL_abyb,sALL_bbyc,sALL_A,sALL_B,sALL_C,sALL_GBA,sALL_GBC,sALL_GCA,sALR_cbya,sALR_abyb,sALR_bbyc,sALR_A,sALR_B,sALR_C,sALR_GBA,sALR_GBC,sALR_GCA,sARL_cbya,sARL_abyb,sARL_bbyc,sARL_A,sARL_B,sARL_C,sARL_GBA,sARL_GBC,sARL_GCA,sARR_cbya,sARR_abyb,sARR_bbyc,sARR_A,sARR_B,sARR_C,sARR_GBA,sARR_GBC,sARR_GCA,sBLL_cbya,sBLL_abyb,sBLL_bbyc,sBLL_A,sBLL_B,sBLL_C,sBLL_GBA,sBLL_GBC,sBLL_GCA,sBLR_cbya,sBLR_abyb,sBLR_bbyc,sBLR_A,sBLR_B,sBLR_C,sBLR_GBA,sBLR_GBC,sBLR_GCA,sBRL_cbya,sBRL_abyb,sBRL_bbyc,sBRL_A,sBRL_B,sBRL_C,sBRL_GBA,sBRL_GBC,sBRL_GCA,sBRR_cbya,sBRR_abyb,sBRR_bbyc,sBRR_A,sBRR_B,sBRR_C,sBRR_GBA,sBRR_GBC,sBRR_GCA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, mushafId);
                ps.setInt(2, rowNumber);
                ps.setString(3, NameVerse);
                ps.setString(4, DirectoryVerse);
                writeFeatures(5,ps,beanVerse);

                status = ps.executeUpdate();
                if (status != 0)
                {
                    ResultSet rs = ps.getGeneratedKeys();
                    if (rs.next())
                        //System.out.println(rs.getInt(1));
                        if(!rs.isClosed())rs.close();
                }
                if(!ps.isClosed())ps.close();
                if(!conn.isClosed())conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Mukasurat_DBModel> selectPage()
    {
        ArrayList<Mukasurat_DBModel> pagesModel = new ArrayList<Mukasurat_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM mukasurat");
            //ps.setInt(1, mushafalquranSearch.getMushafId());
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Mukasurat_DBModel pageModel = new Mukasurat_DBModel();

                    pageModel.setMukaSurat_Id(rs.getInt("MukaSurat_Id"));
                    pageModel.setMushaf(rs.getInt("Mushaf"));

                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    pageModel.setBean_Feature(bean);


                    pagesModel.add(pageModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pagesModel;

    }

    public ArrayList<Mukasurat_DBModel> selectPage(String namaFail)
    {
        ArrayList<Mukasurat_DBModel> pagesModel = new ArrayList<Mukasurat_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM mukasurat WHERE NamaFail = ?");
            ps.setString(1,namaFail);
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Mukasurat_DBModel pageModel = new Mukasurat_DBModel();

                    pageModel.setMukaSurat_Id(rs.getInt("MukaSurat_Id"));
                    pageModel.setMushaf(rs.getInt("Mushaf"));

                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    pageModel.setBean_Feature(bean);


                    pagesModel.add(pageModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return pagesModel;

    }

    public ArrayList<Bingkai_DBModel> selectFrame()
    {
        ArrayList<Bingkai_DBModel> framesModel = new ArrayList<Bingkai_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM bingkai");
            //ps.setInt(1, mushafalquranSearch.getMushafId());
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Bingkai_DBModel frameModel = new Bingkai_DBModel();

                    frameModel.setBingkai_Id(rs.getInt("Bingkai_Id"));
                    frameModel.setMushaf(rs.getInt("Mushaf"));

                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    frameModel.setBean_Feature(bean);


                    framesModel.add(frameModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return framesModel;

    }

    public ArrayList<Bingkai_DBModel> selectFrame(String namaFail)
    {
        ArrayList<Bingkai_DBModel> framesModel = new ArrayList<Bingkai_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM bingkai  WHERE NamaFail = ?");
            ps.setString(1,namaFail);
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Bingkai_DBModel frameModel = new Bingkai_DBModel();

                    frameModel.setBingkai_Id(rs.getInt("Bingkai_Id"));
                    frameModel.setMushaf(rs.getInt("Mushaf"));

                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    frameModel.setBean_Feature(bean);


                    framesModel.add(frameModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return framesModel;

    }

    public ArrayList<Teks_DBModel> selectText()
    {
        ArrayList<Teks_DBModel> textsModel = new ArrayList<Teks_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM teks");
            //ps.setInt(1, mushafalquranSearch.getMushafId());
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Teks_DBModel textModel = new Teks_DBModel();

                    textModel.setTeks_Id(rs.getInt("Teks_Id"));
                    textModel.setMushaf(rs.getInt("Mushaf"));

                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    textModel.setBean_Feature(bean);


                    textsModel.add(textModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return textsModel;

    }

    public ArrayList<Teks_DBModel> selectText(String namaFail)
    {
        ArrayList<Teks_DBModel> textsModel = new ArrayList<Teks_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM teks WHERE NamaFail = ?");
            ps.setString(1,namaFail);
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Teks_DBModel textModel = new Teks_DBModel();

                    textModel.setTeks_Id(rs.getInt("Teks_Id"));
                    textModel.setMushaf(rs.getInt("Mushaf"));

                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    textModel.setBean_Feature(bean);


                    textsModel.add(textModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return textsModel;

    }


    public ArrayList<Baris_DBModel> selectRowsActual()
    {
        ArrayList<Baris_DBModel> rowsActualsModel = new ArrayList<Baris_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM baris");
            //ps.setInt(1, mushafalquranSearch.getMushafId());
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Baris_DBModel rowsActualModel = new Baris_DBModel();

                    rowsActualModel.setBaris_Id(rs.getInt("Baris_Id"));
                    rowsActualModel.setMushaf(rs.getInt("Mushaf"));
                    rowsActualModel.setNomborBaris(rs.getInt("NomborBaris"));
                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    rowsActualModel.setBean_Feature(bean);


                    rowsActualsModel.add(rowsActualModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowsActualsModel;

    }

    public ArrayList<Baris_DBModel> selectRowsActual(String namaFail)
    {
        ArrayList<Baris_DBModel> rowsActualsModel = new ArrayList<Baris_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM baris WHERE NamaFail = ?");
            ps.setString(1,namaFail);
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Baris_DBModel rowsActualModel = new Baris_DBModel();

                    rowsActualModel.setBaris_Id(rs.getInt("Baris_Id"));
                    rowsActualModel.setMushaf(rs.getInt("Mushaf"));
                    rowsActualModel.setNomborBaris(rs.getInt("NomborBaris"));
                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    rowsActualModel.setBean_Feature(bean);


                    rowsActualsModel.add(rowsActualModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rowsActualsModel;

    }


    public ArrayList<WakafPadaBaris_DBModel> selectMarkedRed()
    {
        ArrayList<WakafPadaBaris_DBModel> markedRedsModel = new ArrayList<WakafPadaBaris_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM wakafpadabaris");
            //ps.setInt(1, mushafalquranSearch.getMushafId());
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    WakafPadaBaris_DBModel markedRedModel = new WakafPadaBaris_DBModel();

                    markedRedModel.setWakafPadaBaris_Id(rs.getInt("WakafPadaBaris_Id"));
                    markedRedModel.setMushaf(rs.getInt("Wakaf"));
                    markedRedModel.setMushaf(rs.getInt("Mushaf"));
                    markedRedModel.setMushaf(rs.getInt("Baris"));
                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    markedRedModel.setBean_Feature(bean);


                    markedRedsModel.add(markedRedModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return markedRedsModel;

    }

    public ArrayList<WakafPadaBaris_DBModel> selectMarkedRed(String namaFail)
    {
        ArrayList<WakafPadaBaris_DBModel> markedRedsModel = new ArrayList<WakafPadaBaris_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM wakafpadabaris WHERE NamaFail = ?");
            ps.setString(1,namaFail);
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    WakafPadaBaris_DBModel markedRedModel = new WakafPadaBaris_DBModel();

                    markedRedModel.setWakafPadaBaris_Id(rs.getInt("WakafPadaBaris_Id"));
                    markedRedModel.setMushaf(rs.getInt("Wakaf"));
                    markedRedModel.setMushaf(rs.getInt("Mushaf"));
                    markedRedModel.setMushaf(rs.getInt("Baris"));
                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    markedRedModel.setBean_Feature(bean);


                    markedRedsModel.add(markedRedModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return markedRedsModel;

    }


    public ArrayList<Ayat_DBModel> selectVerse()
    {
        ArrayList<Ayat_DBModel> versesModel = new ArrayList<Ayat_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ayat");
            //ps.setInt(1, mushafalquranSearch.getMushafId());
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Ayat_DBModel verseModel = new Ayat_DBModel();

                    verseModel.setAyat_Id(rs.getInt("Ayat_Id"));
                    verseModel.setMushaf(rs.getInt("Mushaf"));
                    verseModel.setMushaf(rs.getInt("NomborAyat"));
                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    verseModel.setBean_Feature(bean);


                    versesModel.add(verseModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return versesModel;

    }

    public ArrayList<Ayat_DBModel> selectVerse(String namaFail)
    {
        ArrayList<Ayat_DBModel> versesModel = new ArrayList<Ayat_DBModel>();
        try {
            Connection conn = MySqlDatabase.doConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM ayat WHERE NamaFail = ?");
            ps.setString(1,namaFail);
            ResultSet rs = ps.executeQuery();
            if(rs.isBeforeFirst()){
                while(rs.next()){
                    Ayat_DBModel verseModel = new Ayat_DBModel();

                    verseModel.setAyat_Id(rs.getInt("Ayat_Id"));
                    verseModel.setMushaf(rs.getInt("Mushaf"));
                    verseModel.setMushaf(rs.getInt("NomborAyat"));
                    Bean_Feature bean = new Bean_Feature();
                    //NFV2
                    bean.setFname(rs.getString("NamaFail")); bean.setCbya(rs.getFloat("s_cbya")); bean.setAbyb(rs.getFloat("s_abyb")); bean.setBbyc(rs.getFloat("s_bbyc"));bean.setA(rs.getFloat("s_A")); bean.setB(rs.getFloat("s_B")); bean.setC(rs.getFloat("s_C"));
                    bean.setGraBA(rs.getFloat("s_GBA")); bean.setGraBC(rs.getFloat("s_GBC")); bean.setGraCA(rs.getFloat("s_GCA"));

                    bean.setPu_cbya(rs.getFloat("su_cbya")); bean.setPu_abyb(rs.getFloat("su_abyb")); bean.setPu_bbyc(rs.getFloat("su_bbyc"));bean.setPu_A(rs.getFloat("su_A")); bean.setPu_B(rs.getFloat("su_B")); bean.setPu_C(rs.getFloat("su_C"));
                    bean.setPu_GraBA(rs.getFloat("su_GBA")); bean.setPu_GraBC(rs.getFloat("su_GBC")); bean.setPu_GraCA(rs.getFloat("su_GCA"));

                    bean.setPl_cbya(rs.getFloat("sl_cbya")); bean.setPl_abyb(rs.getFloat("sl_abyb")); bean.setPl_bbyc(rs.getFloat("sl_bbyc"));bean.setPl_A(rs.getFloat("sl_A")); bean.setPl_B(rs.getFloat("sl_B")); bean.setPl_C(rs.getFloat("sl_C"));
                    bean.setPl_GraBA(rs.getFloat("sl_GBA")); bean.setPl_GraBC(rs.getFloat("sl_GBC")); bean.setPl_GraCA(rs.getFloat("sl_GCA"));

                    //27 Feb 2012
                    bean.setTu_cbya(rs.getFloat("stu_cbya")); bean.setTu_abyb(rs.getFloat("stu_abyb")); bean.setTu_bbyc(rs.getFloat("stu_bbyc"));bean.setTu_A(rs.getFloat("stu_A")); bean.setTu_B(rs.getFloat("stu_B")); bean.setTu_C(rs.getFloat("stu_C"));
                    bean.setTu_GraBA(rs.getFloat("stu_GBA")); bean.setTu_GraBC(rs.getFloat("stu_GBC")); bean.setTu_GraCA(rs.getFloat("stu_GCA"));

                    bean.setTl_cbya(rs.getFloat("stl_cbya")); bean.setTl_abyb(rs.getFloat("stl_abyb")); bean.setTl_bbyc(rs.getFloat("stl_bbyc"));bean.setTl_A(rs.getFloat("stl_A")); bean.setTl_B(rs.getFloat("stl_B")); bean.setTl_C(rs.getFloat("stl_C"));
                    bean.setTl_GraBA(rs.getFloat("stl_GBA")); bean.setTl_GraBC(rs.getFloat("stl_GBC")); bean.setTl_GraCA(rs.getFloat("stl_GCA"));

                    bean.setBu_cbya(rs.getFloat("sbu_cbya")); bean.setBu_abyb(rs.getFloat("sbu_abyb")); bean.setBu_bbyc(rs.getFloat("sbu_bbyc"));bean.setBu_A(rs.getFloat("sbu_A")); bean.setBu_B(rs.getFloat("sbu_B")); bean.setBu_C(rs.getFloat("sbu_C"));
                    bean.setBu_GraBA(rs.getFloat("sbu_GBA")); bean.setBu_GraBC(rs.getFloat("sbu_GBC")); bean.setBu_GraCA(rs.getFloat("sbu_GCA"));

                    bean.setBl_cbya(rs.getFloat("sbl_cbya")); bean.setBl_abyb(rs.getFloat("sbl_abyb")); bean.setBl_bbyc(rs.getFloat("sbl_bbyc"));bean.setBl_A(rs.getFloat("sbl_A")); bean.setBl_B(rs.getFloat("sbl_B")); bean.setBl_C(rs.getFloat("sbl_C"));
                    bean.setBl_GraBA(rs.getFloat("sbl_GBA")); bean.setBl_GraBC(rs.getFloat("sbl_GBC")); bean.setBl_GraCA(rs.getFloat("sbl_GCA"));

                    //24 Feb 2012
                    bean.setP_Lcbya(rs.getFloat("s_Lcbya")); bean.setP_Labyb(rs.getFloat("s_Labyb")); bean.setP_Lbbyc(rs.getFloat("s_Lbbyc"));bean.setP_LA(rs.getFloat("s_LA")); bean.setP_LB(rs.getFloat("s_LB")); bean.setP_LC(rs.getFloat("s_LC"));
                    bean.setP_LGraBA(rs.getFloat("s_LGBA")); bean.setP_LGraBC(rs.getFloat("s_LGBC")); bean.setP_LGraCA(rs.getFloat("s_LGCA"));

                    bean.setP_Rcbya(rs.getFloat("s_Rcbya")); bean.setP_Rabyb(rs.getFloat("s_Rabyb")); bean.setP_Rbbyc(rs.getFloat("s_Rbbyc"));bean.setP_RA(rs.getFloat("s_RA")); bean.setP_RB(rs.getFloat("s_RB")); bean.setP_RC(rs.getFloat("s_RC"));
                    bean.setP_RGraBA(rs.getFloat("s_RGBA")); bean.setP_RGraBC(rs.getFloat("s_RGBC")); bean.setP_RGraCA(rs.getFloat("s_RGCA"));
                    //28 Feb 2012
                    bean.setsLLZ_cbya(rs.getFloat("sLLZ_cbya"));/*FIXED*/ bean.setsLLZ_abyb(rs.getFloat("sLLZ_abyb")); bean.setsLLZ_bbyc(rs.getFloat("sLLZ_bbyc"));bean.setsLLZ_A(rs.getFloat("sLLZ_A")); bean.setsLLZ_B(rs.getFloat("sLLZ_B")); bean.setsLLZ_C(rs.getFloat("sLLZ_C"));
                    bean.setsLLZ_GraBA(rs.getFloat("sLLZ_GBA")); bean.setsLLZ_GraBC(rs.getFloat("sLLZ_GBC")); bean.setsLLZ_GraCA(rs.getFloat("sLLZ_GCA"));

                    bean.setsLRZ_cbya(rs.getFloat("sLRZ_cbya"));/*FIXED*/ bean.setsLRZ_abyb(rs.getFloat("sLRZ_abyb")); bean.setsLRZ_bbyc(rs.getFloat("sLRZ_bbyc"));bean.setsLRZ_A(rs.getFloat("sLRZ_A")); bean.setsLRZ_B(rs.getFloat("sLRZ_B")); bean.setsLRZ_C(rs.getFloat("sLRZ_C"));
                    bean.setsLRZ_GraBA(rs.getFloat("sLRZ_GBA")); bean.setsLRZ_GraBC(rs.getFloat("sLRZ_GBC")); bean.setsLRZ_GraCA(rs.getFloat("sLRZ_GCA"));

                    bean.setsRLZ_cbya(rs.getFloat("sRLZ_cbya"));/*FIXED*/ bean.setsRLZ_abyb(rs.getFloat("sRLZ_abyb")); bean.setsRLZ_bbyc(rs.getFloat("sRLZ_bbyc"));bean.setsRLZ_A(rs.getFloat("sRLZ_A")); bean.setsRLZ_B(rs.getFloat("sRLZ_B"));/*FIXED*/ bean.setsRLZ_C(rs.getFloat("sRLZ_C"));
                    bean.setsRLZ_GraBA(rs.getFloat("sRLZ_GBA")); bean.setsRLZ_GraBC(rs.getFloat("sRLZ_GBC")); bean.setsRLZ_GraCA(rs.getFloat("sRLZ_GCA"));

                    bean.setsRRZ_cbya(rs.getFloat("sRRZ_cbya"));/*FIXED*/ bean.setsRRZ_abyb(rs.getFloat("sRRZ_abyb")); bean.setsRRZ_bbyc(rs.getFloat("sRRZ_bbyc"));bean.setsRRZ_A(rs.getFloat("sRRZ_A")); bean.setsRRZ_B(rs.getFloat("sRRZ_B")); bean.setsRRZ_C(rs.getFloat("sRRZ_C"));
                    bean.setsRRZ_GraBA(rs.getFloat("sRRZ_GBA")); bean.setsRRZ_GraBC(rs.getFloat("sRRZ_GBC")); bean.setsRRZ_GraCA(rs.getFloat("sRRZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under left UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsLLUZ_cbya(rs.getFloat("sLLUZ_cbya"));/*FIXED*/ bean.setsLLUZ_abyb(rs.getFloat("sLLUZ_abyb")); bean.setsLLUZ_bbyc(rs.getFloat("sLLUZ_bbyc"));bean.setsLLUZ_A(rs.getFloat("sLLUZ_A")); bean.setsLLUZ_B(rs.getFloat("sLLUZ_B")); bean.setsLLUZ_C(rs.getFloat("sLLUZ_C"));
                    bean.setsLLUZ_GraBA(rs.getFloat("sLLUZ_GBA")); bean.setsLLUZ_GraBC(rs.getFloat("sLLUZ_GBC")); bean.setsLLUZ_GraCA(rs.getFloat("sLLUZ_GCA"));

                    bean.setsLLBZ_cbya(rs.getFloat("sLLBZ_cbya"));/*FIXED*/ bean.setsLLBZ_abyb(rs.getFloat("sLLBZ_abyb")); bean.setsLLBZ_bbyc(rs.getFloat("sLLBZ_bbyc"));bean.setsLLBZ_A(rs.getFloat("sLLBZ_A")); bean.setsLLBZ_B(rs.getFloat("sLLBZ_B")); bean.setsLLBZ_C(rs.getFloat("sLLBZ_C"));
                    bean.setsLLBZ_GraBA(rs.getFloat("sLLBZ_GBA")); bean.setsLLBZ_GraBC(rs.getFloat("sLLBZ_GBC")); bean.setsLLBZ_GraCA(rs.getFloat("sLLBZ_GCA"));

                    bean.setsLRUZ_cbya(rs.getFloat("sLRUZ_cbya"));/*FIXED*/ bean.setsLRUZ_abyb(rs.getFloat("sLRUZ_abyb")); bean.setsLRUZ_bbyc(rs.getFloat("sLRUZ_bbyc"));bean.setsLRUZ_A(rs.getFloat("sLRUZ_A")); bean.setsLRUZ_B(rs.getFloat("sLRUZ_B")); bean.setsLRUZ_C(rs.getFloat("sLRUZ_C"));
                    bean.setsLRUZ_GraBA(rs.getFloat("sLRUZ_GBA")); bean.setsLRUZ_GraBC(rs.getFloat("sLRUZ_GBC")); bean.setsLRUZ_GraCA(rs.getFloat("sLRUZ_GCA"));

                    bean.setsLRBZ_cbya(rs.getFloat("sLRBZ_cbya"));/*FIXED*/ bean.setsLRBZ_abyb(rs.getFloat("sLRBZ_abyb")); bean.setsLRBZ_bbyc(rs.getFloat("sLRBZ_bbyc"));bean.setsLRBZ_A(rs.getFloat("sLRBZ_A")); bean.setsLRBZ_B(rs.getFloat("sLRBZ_B")); bean.setsLRBZ_C(rs.getFloat("sLRBZ_C"));
                    bean.setsLRBZ_GraBA(rs.getFloat("sLRBZ_GBA")); bean.setsLRBZ_GraBC(rs.getFloat("sLRBZ_GBC")); bean.setsLRBZ_GraCA(rs.getFloat("sLRBZ_GCA"));

                    /*
                     * ------------------------------------------
                     * features under right UPPER and BOTTOM zone
                     * ------------------------------------------
                     */

                    bean.setsRLUZ_cbya(rs.getFloat("sRLUZ_cbya"));/*FIXED*/ bean.setsRLUZ_abyb(rs.getFloat("sRLUZ_abyb")); bean.setsRLUZ_bbyc(rs.getFloat("sRLUZ_bbyc"));bean.setsRLUZ_A(rs.getFloat("sRLUZ_A")); bean.setsRLUZ_B(rs.getFloat("sRLUZ_B")); bean.setsRLUZ_C(rs.getFloat("sRLUZ_C"));
                    bean.setsRLUZ_GraBA(rs.getFloat("sRLUZ_GBA")); bean.setsRLUZ_GraBC(rs.getFloat("sRLUZ_GBC")); bean.setsRLUZ_GraCA(rs.getFloat("sRLUZ_GCA"));

                    bean.setsRLBZ_cbya(rs.getFloat("sRLBZ_cbya"));/*FIXED*/ bean.setsRLBZ_abyb(rs.getFloat("sRLBZ_abyb")); bean.setsRLBZ_bbyc(rs.getFloat("sRLBZ_bbyc"));bean.setsRLBZ_A(rs.getFloat("sRLBZ_A")); bean.setsRLBZ_B(rs.getFloat("sRLBZ_B")); bean.setsRLBZ_C(rs.getFloat("sRLBZ_C"));
                    bean.setsRLBZ_GraBA(rs.getFloat("sRLBZ_GBA")); bean.setsRLBZ_GraBC(rs.getFloat("sRLBZ_GBC")); bean.setsRLBZ_GraCA(rs.getFloat("sRLBZ_GCA"));

                    bean.setsRRUZ_cbya(rs.getFloat("sRRUZ_cbya"));/*FIXED*/ bean.setsRRUZ_abyb(rs.getFloat("sRRUZ_abyb")); bean.setsRRUZ_bbyc(rs.getFloat("sRRUZ_bbyc"));bean.setsRRUZ_A(rs.getFloat("sRRUZ_A")); bean.setsRRUZ_B(rs.getFloat("sRRUZ_B")); bean.setsRRUZ_C(rs.getFloat("sRRUZ_C"));
                    bean.setsRRUZ_GraBA(rs.getFloat("sRRUZ_GBA")); bean.setsRRUZ_GraBC(rs.getFloat("sRRUZ_GBC")); bean.setsRRUZ_GraCA(rs.getFloat("sRRUZ_GCA"));

                    bean.setsRRBZ_cbya(rs.getFloat("sRRBZ_cbya"));/*FIXED*/ bean.setsRRBZ_abyb(rs.getFloat("sRRBZ_abyb")); bean.setsRRBZ_bbyc(rs.getFloat("sRRBZ_bbyc"));bean.setsRRBZ_A(rs.getFloat("sRRBZ_A")); bean.setsRRBZ_B(rs.getFloat("sRRBZ_B")); bean.setsRRBZ_C(rs.getFloat("sRRBZ_C"));
                    bean.setsRRBZ_GraBA(rs.getFloat("sRRBZ_GBA")); bean.setsRRBZ_GraBC(rs.getFloat("sRRBZ_GBC")); bean.setsRRBZ_GraCA(rs.getFloat("sRRBZ_GCA"));

                    bean.setPul_cbya(rs.getFloat("sPUL_cbya")); bean.setPul_abyb(rs.getFloat("sPUL_abyb")); bean.setPul_bbyc(rs.getFloat("sPUL_bbyc"));bean.setPul_A(rs.getFloat("sPUL_A")); bean.setPul_B(rs.getFloat("sPUL_B")); bean.setPul_C(rs.getFloat("sPUL_C"));
                    bean.setPul_GraBA(rs.getFloat("sPUL_GBA")); bean.setPul_GraBC(rs.getFloat("sPUL_GBC")); bean.setPul_GraCA(rs.getFloat("sPUL_GCA"));

                    bean.setPur_cbya(rs.getFloat("sPUR_cbya")); bean.setPur_abyb(rs.getFloat("sPUR_abyb")); bean.setPur_bbyc(rs.getFloat("sPUR_bbyc"));bean.setPur_A(rs.getFloat("sPUR_A")); bean.setPur_B(rs.getFloat("sPUR_B")); bean.setPur_C(rs.getFloat("sPUR_C"));
                    bean.setPur_GraBA(rs.getFloat("sPUR_GBA")); bean.setPur_GraBC(rs.getFloat("sPUR_GBC")); bean.setPur_GraCA(rs.getFloat("sPUR_GCA"));

                    bean.setPll_cbya(rs.getFloat("sPLL_cbya")); bean.setPll_abyb(rs.getFloat("sPLL_abyb")); bean.setPll_bbyc(rs.getFloat("sPLL_bbyc"));bean.setPll_A(rs.getFloat("sPLL_A")); bean.setPll_B(rs.getFloat("sPLL_B")); bean.setPll_C(rs.getFloat("sPLL_C"));
                    bean.setPll_GraBA(rs.getFloat("sPLL_GBA")); bean.setPll_GraBC(rs.getFloat("sPLL_GBC")); bean.setPll_GraCA(rs.getFloat("sPLL_GCA"));

                    bean.setPlr_cbya(rs.getFloat("sPLR_cbya")); bean.setPlr_abyb(rs.getFloat("sPLR_abyb")); bean.setPlr_bbyc(rs.getFloat("sPLR_bbyc"));bean.setPlr_A(rs.getFloat("sPLR_A")); bean.setPlr_B(rs.getFloat("sPLR_B")); bean.setPlr_C(rs.getFloat("sPLR_C"));
                    bean.setPlr_GraBA(rs.getFloat("sPLR_GBA")); bean.setPlr_GraBC(rs.getFloat("sPLR_GBC")); bean.setPlr_GraCA(rs.getFloat("sPLR_GCA"));

                    //NF45
                    //Bahagian Atas 45 darjah
                    bean.setsALL_cbya(rs.getFloat("sALL_cbya")); bean.setsALL_abyb(rs.getFloat("sALL_abyb")); bean.setsALL_bbyc(rs.getFloat("sALL_bbyc"));bean.setsALL_A(rs.getFloat("sALL_A")); bean.setsALL_B(rs.getFloat("sALL_B")); bean.setsALL_C(rs.getFloat("sALL_C"));
                    bean.setsALL_GraBA(rs.getFloat("sALL_GBA")); bean.setsALL_GraBC(rs.getFloat("sALL_GBC")); bean.setsALL_GraCA(rs.getFloat("sALL_GCA"));

                    bean.setsALR_cbya(rs.getFloat("sALR_cbya")); bean.setsALR_abyb(rs.getFloat("sALR_abyb")); bean.setsALR_bbyc(rs.getFloat("sALR_bbyc"));bean.setsALR_A(rs.getFloat("sALR_A")); bean.setsALR_B(rs.getFloat("sALR_B")); bean.setsALR_C(rs.getFloat("sALR_C"));
                    bean.setsALR_GraBA(rs.getFloat("sALR_GBA")); bean.setsALR_GraBC(rs.getFloat("sALR_GBC")); bean.setsALR_GraCA(rs.getFloat("sALR_GCA"));

                    bean.setsARL_cbya(rs.getFloat("sARL_cbya")); bean.setsARL_abyb(rs.getFloat("sARL_abyb")); bean.setsARL_bbyc(rs.getFloat("sARL_bbyc"));bean.setsARL_A(rs.getFloat("sARL_A")); bean.setsARL_B(rs.getFloat("sARL_B")); bean.setsARL_C(rs.getFloat("sARL_C"));
                    bean.setsARL_GraBA(rs.getFloat("sARL_GBA")); bean.setsARL_GraBC(rs.getFloat("sARL_GBC")); bean.setsARL_GraCA(rs.getFloat("sARL_GCA"));

                    bean.setsARR_cbya(rs.getFloat("sARR_cbya")); bean.setsARR_abyb(rs.getFloat("sARR_abyb")); bean.setsARR_bbyc(rs.getFloat("sARR_bbyc"));bean.setsARR_A(rs.getFloat("sARR_A")); bean.setsARR_B(rs.getFloat("sARR_B")); bean.setsARR_C(rs.getFloat("sARR_C"));
                    bean.setsARR_GraBA(rs.getFloat("sARR_GBA")); bean.setsARR_GraBC(rs.getFloat("sARR_GBC")); bean.setsARR_GraCA(rs.getFloat("sARR_GCA"));


                    //Bahagian Bawah 45 darjah
                    bean.setsBLL_cbya(rs.getFloat("sBLL_cbya")); bean.setsBLL_abyb(rs.getFloat("sBLL_abyb")); bean.setsBLL_bbyc(rs.getFloat("sBLL_bbyc"));bean.setsBLL_A(rs.getFloat("sBLL_A")); bean.setsBLL_B(rs.getFloat("sBLL_B")); bean.setsBLL_C(rs.getFloat("sBLL_C"));
                    bean.setsBLL_GraBA(rs.getFloat("sBLL_GBA")); bean.setsBLL_GraBC(rs.getFloat("sBLL_GBC")); bean.setsBLL_GraCA(rs.getFloat("sBLL_GCA"));

                    bean.setsBLR_cbya(rs.getFloat("sBLR_cbya")); bean.setsBLR_abyb(rs.getFloat("sBLR_abyb")); bean.setsBLR_bbyc(rs.getFloat("sBLR_bbyc"));bean.setsBLR_A(rs.getFloat("sBLR_A")); bean.setsBLR_B(rs.getFloat("sBLR_B")); bean.setsBLR_C(rs.getFloat("sBLR_C"));
                    bean.setsBLR_GraBA(rs.getFloat("sBLR_GBA")); bean.setsBLR_GraBC(rs.getFloat("sBLR_GBC")); bean.setsBLR_GraCA(rs.getFloat("sBLR_GCA"));

                    bean.setsBRL_cbya(rs.getFloat("sBRL_cbya")); bean.setsBRL_abyb(rs.getFloat("sBRL_abyb")); bean.setsBRL_bbyc(rs.getFloat("sBRL_bbyc"));bean.setsBRL_A(rs.getFloat("sBRL_A")); bean.setsBRL_B(rs.getFloat("sBRL_B")); bean.setsBRL_C(rs.getFloat("sBRL_C"));
                    bean.setsBRL_GraBA(rs.getFloat("sBRL_GBA")); bean.setsBRL_GraBC(rs.getFloat("sBRL_GBC")); bean.setsBRL_GraCA(rs.getFloat("sBRL_GCA"));

                    bean.setsBRR_cbya(rs.getFloat("sBRR_cbya")); bean.setsBRR_abyb(rs.getFloat("sBRR_abyb")); bean.setsBRR_bbyc(rs.getFloat("sBRR_bbyc"));bean.setsBRR_A(rs.getFloat("sBRR_A")); bean.setsBRR_B(rs.getFloat("sBRR_B")); bean.setsBRR_C(rs.getFloat("sBRR_C"));
                    bean.setsBRR_GraBA(rs.getFloat("sBRR_GBA")); bean.setsBRR_GraBC(rs.getFloat("sBRR_GBC")); bean.setsBRR_GraCA(rs.getFloat("sBRR_GCA"));

                    bean.setType(rs.getString("Direktori"));

                    verseModel.setBean_Feature(bean);


                    versesModel.add(verseModel);
                }
            }else{
                //System.out.print("No result! ");
            }
            if(!rs.isClosed())rs.close();
            if(!ps.isClosed())ps.close();
            if(!conn.isClosed())conn.close();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return versesModel;

    }

}
