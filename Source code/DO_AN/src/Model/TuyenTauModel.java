package Model;

public class TuyenTauModel {
    private String MaTuyen;
    private String TenGaDi;
    private String TenGaDen;
    //getter & setter
    public String getMaTuyen() {
        return MaTuyen;
    }
    public String getTenGaDi() {
        return TenGaDi;
    }
    public String getTenGaDen() {
        return TenGaDen;
    }
    public void setMaTuyen(String MaTuyen) {
        this.MaTuyen = MaTuyen;
    }
    public void setTenGaDi(String TenGaDi) {
        this.TenGaDi = TenGaDi;
    }
    public void setTenGaDen(String TenGaDen) {
        this.TenGaDen = TenGaDen;
    }
    //contructor
    public TuyenTauModel(String MaTuyen, String TenGaDi, String TenGaDen) {
        this.MaTuyen = MaTuyen;
        this.TenGaDi = TenGaDi;
        this.TenGaDen = TenGaDen;
    }
    public TuyenTauModel() {
        this.MaTuyen = "";
        this.TenGaDi = "";
        this.TenGaDen = "";
    }
    //print
    @Override
    public String toString() {
        return "TuyenTauModel{" + "MaTuyen=" + MaTuyen + ", TenGaDi=" + TenGaDi + ", TenGaDen=" + TenGaDen + '}';
    }
    
    
}
