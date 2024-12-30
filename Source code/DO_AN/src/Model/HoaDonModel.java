/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author 21521
 */
public class HoaDonModel {
    private int MAHD;
    private String MAKH;
    private String MAVE;
    private Date NGAYLAP;
    private int THANHTIEN;

    public HoaDonModel() {
    }

    public HoaDonModel(int MAHD, String MAKH, String MAVE, Date NGAYLAP, int THANHTIEN) {
        this.MAHD = MAHD;
        this.MAKH = MAKH;
        this.MAVE = MAVE;
        this.NGAYLAP = NGAYLAP;
        this.THANHTIEN = THANHTIEN;
    }

    @Override
    public String toString() {
        return "HoaDonModel{" + "MAHD=" + MAHD + ", MAKH=" + MAKH + ", MAVE=" + MAVE + ", NGAYLAP=" + NGAYLAP + ", THANHTIEN=" + THANHTIEN + '}';
    }

    public int getMAHD() {
        return MAHD;
    }

    public void setMAHD(int MAHD) {
        this.MAHD = MAHD;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getMAVE() {
        return MAVE;
    }

    public void setMAVE(String MAVE) {
        this.MAVE = MAVE;
    }

    public Date getNGAYLAP() {
        return NGAYLAP;
    }

    public void setNGAYLAP(Date NGAYLAP) {
        this.NGAYLAP = NGAYLAP;
    }

    public int getTHANHTIEN() {
        return THANHTIEN;
    }

    public void setTHANHTIEN(int THANHTIEN) {
        this.THANHTIEN = THANHTIEN;
    }
    
}
