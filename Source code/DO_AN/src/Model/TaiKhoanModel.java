
package Model;


public class TaiKhoanModel {
    private String TENDN;
    private String MATKHAU;
    private String ROLE;
    private Integer TINHTRANG;

    public TaiKhoanModel(String TENDN, String MATKHAU, String ROLE, Integer TINHTRANG) {
        this.TENDN = TENDN;
        this.MATKHAU = MATKHAU;
        this.ROLE = ROLE;
        this.TINHTRANG = TINHTRANG;
    }

    public Integer getTINHTRANG() {
        return TINHTRANG;
    }

    public void setTINHTRANG(Integer TINHTRANG) {
        this.TINHTRANG = TINHTRANG;
    }

    public TaiKhoanModel() {
    }

    @Override
    public String toString() {
        return "TaiKhoanModel{" + "TENDN=" + TENDN + ", MATKHAU=" + MATKHAU + ", ROLE=" + ROLE + '}';
    }

    public String getTENDN() {
        return TENDN;
    }

    public void setTENDN(String TENDN) {
        this.TENDN = TENDN;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public String getROLE() {
        return ROLE;
    }

    public void setROLE(String ROLE) {
        this.ROLE = ROLE;
    }
    
    
    
}
