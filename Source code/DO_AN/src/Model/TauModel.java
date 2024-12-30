/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TauModel {
    private String MATAU;
    private String TENTAU;
    private String HANGSX;
    private Integer SOGHEL1;
    private Integer SOGHEL2;
    private Integer TONGSOGHE;
    private Integer TINHTRANG;
    

    public TauModel(String MATAU, String TENTAU, String HANGSX, Integer SOGHEL1, Integer SOGHEL2, Integer TONGSOGHE, Integer TINHTRANG) {
        this.MATAU = MATAU;
        this.TENTAU = TENTAU;
        this.HANGSX = HANGSX;
        this.SOGHEL1 = SOGHEL1;
        this.SOGHEL2 = SOGHEL2;
        this.TONGSOGHE = TONGSOGHE;
        this.TINHTRANG = TINHTRANG;
    }

    @Override
    public String toString() {
        return "TauModel{" + "MATAU=" + MATAU + ", TENTAU=" + TENTAU + ", HANGSX=" + HANGSX + ", SOGHEL1=" + SOGHEL1 + ", SOGHEL2=" + SOGHEL2 + ", TONGSOGHE=" + TONGSOGHE + ", TINHTRANG=" + TINHTRANG + '}';
    }

    
    
    
    
    public TauModel() {
    }

    public String getMATAU() {
        return MATAU;
    }

    public void setMATAU(String MATAU) {
        this.MATAU = MATAU;
    }

    public String getTENTAU() {
        return TENTAU;
    }

    public void setTENTAU(String TENTAU) {
        this.TENTAU = TENTAU;
    }

    public String getHANGSX() {
        return HANGSX;
    }

    public void setHANGSX(String HANGSX) {
        this.HANGSX = HANGSX;
    }

    public Integer getSOGHEL1() {
        return SOGHEL1;
    }

    public void setSOGHEL1(Integer SOGHEL1) {
        this.SOGHEL1 = SOGHEL1;
    }
    
    public Integer getSOGHEL2() {
        return SOGHEL2;
    }

    public void setSOGHEL2(Integer SOGHEL2) {
        this.SOGHEL2 = SOGHEL2;
    }
    
    public Integer getTONGSOGHE() {
        return TONGSOGHE;
    }

    public void setTONGSOGHE(Integer TONGSOGHE) {
        this.TONGSOGHE = TONGSOGHE;
    }
    public Integer getTINHTRANG() {
        return TINHTRANG;
    }

    public void setTINHTRANG(Integer TINHTRANG) {
        this.TINHTRANG = TINHTRANG;
    }
}
