/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanVienModel {
    private String MANV;
    private String TENDN;
    private String TENNV;
    private String DIACHI; 
    private Date NGSINH;
    private String SDT;
    

    public NhanVienModel(String MANV, String TENDN, String TENNV, Date NGSINH, String SDT, String DIACHI) {
        this.MANV = MANV;
        this.TENDN = TENDN;
        this.TENNV = TENNV;
        this.NGSINH = NGSINH;
        this.SDT = SDT;
        this.DIACHI = DIACHI;
    }

    @Override
    public String toString() {
        return "NhanVienModel{" + "MANV=" + MANV + ", TENDN=" + TENDN + ", TENNV=" + TENNV + ", NGSINH=" + NGSINH + ", SDT=" + SDT + ", DIACHI=" + DIACHI + '}';
    }
   
    public NhanVienModel() {
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getTENDN() {
        return TENDN;
    }

    public void setTENDN(String TENDN) {
        this.TENDN = TENDN;
    }

    public String getTENNV() {
        return TENNV;
    }

    public void setTENNV(String TENNV) {
        this.TENNV = TENNV;
    }
    
    public Date getNGSINH() {
        return NGSINH;
    }

    public void setNGSINH(Date NGSINH)  {
        this.NGSINH = NGSINH;
    }
    
    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }



    

    
    
    
}
