package com.fortuna.ProgettoTimeSheet;

public class Commessa {

    private String C_AZN;
    private String C_COM;
    private String T_COM;

    public Commessa(String c_AZN, String c_COM, String t_COM) {
        C_AZN = c_AZN;
        C_COM = c_COM;
        T_COM = t_COM;
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

    @Override
    public String toString() {
        return "Element [C_AZN=" + C_AZN + ", C_COM=" + C_COM + ", T_COM=" + T_COM + "]";
    }

    
}
