/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class KhachHangModel {
    private String MAKH;
    private String TENDN;
    private String TENKH;
    private Integer VI;
    private String DIACHI;
    private String GIOITINH;
    private String SDT;
    private Date NGSINH;

    public KhachHangModel(String MAKH, String TENDN, String TENKH, Integer VI, String DIACHI, String GIOITINH, String SDT, Date NGSINH) {
        this.MAKH = MAKH;
        this.TENDN = TENDN;
        this.TENKH = TENKH;
        this.VI = VI;
        this.DIACHI = DIACHI;
        this.GIOITINH = GIOITINH;
        this.SDT = SDT;
        this.NGSINH = NGSINH;
    }

    @Override
    public String toString() {
        return "KhachHangModel{" + "MAKH=" + MAKH + ", TENDN=" + TENDN + ", TENKH=" + TENKH + ", VI=" + VI + ", DIACHI=" + DIACHI + ", GIOITINH=" + GIOITINH + ", SDT=" + SDT + ", NGSINH=" + NGSINH + '}';
    }

    
    
    
    
    public KhachHangModel() {
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getTENDN() {
        return TENDN;
    }

    public void setTENDN(String TENDN) {
        this.TENDN = TENDN;
    }

    public String getTENKH() {
        return TENKH;
    }

    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }

    public Integer getVI() {
        return VI;
    }

    public void setVI(Integer VI) {
        this.VI = VI;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(String GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNGSINH() {
        return NGSINH;
    }

    public void setNGSINH(Date NGSINH)  {
        this.NGSINH = NGSINH;
    }
    
    
}
