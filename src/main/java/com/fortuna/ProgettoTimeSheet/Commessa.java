package com.fortuna.ProgettoTimeSheet;

import java.sql.Date;

public class Commessa {

    private String C_AZN;
    private String C_COM;
    private String T_COM;
    private Date D_INS;

    public Commessa(String c_AZN, String c_COM, String t_COM, Date d_INS) {
        this.C_AZN = c_AZN;
        this.C_COM = c_COM;
        this.T_COM = t_COM;
        this.D_INS = d_INS;
    }

    public String getC_AZN() {
        return C_AZN;
    }

    public void setC_AZN(String c_AZN) {
        C_AZN = c_AZN;
    }

    public String getC_COM() {
        return C_COM;
    }

    public void setC_COM(String c_COM) {
        C_COM = c_COM;
    }

    public String getT_COM() {
        return T_COM;
    }

    public void setT_COM(String t_COM) {
        T_COM = t_COM;
    }

    public Date getD_INS() {
        return D_INS;
    }

    public void setD_INS(Date d_INS) {
        D_INS = d_INS;
    }
    
    @Override
    public String toString() {
        return "Element [C_AZN=" + C_AZN + ", C_COM=" + C_COM + ", T_COM=" + T_COM + ", D_INS=" + D_INS + "]";
    }

    
}
