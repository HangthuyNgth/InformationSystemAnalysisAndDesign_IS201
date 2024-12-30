package Model;

public class VeModel {
    private String MaVe;
    private String MaChuyen;
    private Integer TienVe;
    private String LoaiGhe;
    private Integer SoLuong;
  //private bit TinhTrang;
    //getter&setter

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    public String getMaVe() {
        return MaVe;
    }
    public String getMaChuyen() {
        return MaChuyen;
    }
    public Integer getTienVe() {
        return TienVe;
    }
    public String getLoaiGhe() {
        return LoaiGhe;
    }
    public void setMaVe(String MaVe) {
        this.MaVe = MaVe;
    }
    public void setMaChuyen(String MaChuyen) {
        this.MaChuyen = MaChuyen;
    }
    public void setTienVe(Integer TienVe) {
        this.TienVe = TienVe;
    }
    public void setLoaiGhe(String LoaiGhe) {
        this.LoaiGhe = LoaiGhe;
    }
    //constructor

    public VeModel(String MaVe, String MaChuyen, Integer TienVe, String LoaiGhe, Integer SoLuong) {
        this.MaVe = MaVe;
        this.MaChuyen = MaChuyen;
        this.TienVe = TienVe;
        this.LoaiGhe = LoaiGhe;
        this.SoLuong = SoLuong;
    }

    public VeModel() {
    }
    
    @Override
    public String toString() {
        return "VeModel{" + "MaVe=" + MaVe + ", MaChuyen=" + MaChuyen + ", TienVe=" + TienVe + ", LoaiGhe=" + LoaiGhe + ", SoLuong=" + SoLuong + '}';
    }
    
    
    
    
    
    
}