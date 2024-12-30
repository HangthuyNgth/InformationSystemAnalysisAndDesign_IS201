package Model;

import java.util.Date;

public class ChuyenTauModel {
    private String MaChuyen;
    private String MaTuyen;
    private String MaTau;
    private Date NgayKhoiHanh;
    private String GioKhoiHanh;
    //getter&setter
    public String getMaChuyen() {
        return MaChuyen;
    }
    public String getMaTuyen() {
        return MaTuyen;
    }
    public String getMaTau() {
        return MaTau;
    }
    public Date getNgayKhoiHanh() {
        return NgayKhoiHanh;
    }
    public String getGioKhoiHanh() {
        return GioKhoiHanh;
    }
    public void setMaChuyen(String MaChuyen) {
        this.MaChuyen = MaChuyen;
    }
    public void setMaTuyen(String MaTuyen) {
        this.MaTuyen = MaTuyen;
    }
    public void setMaTau(String MaTau) {
        this.MaTau = MaTau;
    }
    public void setNgayKhoiHanh(Date NgayKhoiHanh) {
        this.NgayKhoiHanh = NgayKhoiHanh;
    }
    public void setGioKhoiHanh(String GioKhoiHanh) {
        this.GioKhoiHanh = GioKhoiHanh;
    }
    //constructor
    public ChuyenTauModel(String MaChuyen, String MaTuyen, String MaTau, Date NgayKhoiHanh, String GioKhoiHanh) {
        this.MaChuyen = MaChuyen;
        this.MaTuyen = MaTuyen;
        this.MaTau = MaTau;
        this.NgayKhoiHanh = NgayKhoiHanh;
        this.GioKhoiHanh = GioKhoiHanh;
    }
    public ChuyenTauModel() {
    }
    //print
    @Override
    public String toString() {
        return "ChuyenTauModel{" + "MaChuyen=" + MaChuyen + ", MaTuyen=" + MaTuyen + ", MaTau=" + MaTau + ", NgayKhoiHanh=" + NgayKhoiHanh + ", GioKhoiHanh=" + GioKhoiHanh + '}';
    }
    //
}
