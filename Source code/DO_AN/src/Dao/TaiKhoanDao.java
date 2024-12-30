
package Dao;

import Model.TaiKhoanModel;
import java.sql.*;
import ConnectDatabase.ConnectDB;
import Model.KhachHangModel;
import java.util.ArrayList;


public class TaiKhoanDao {
    public TaiKhoanModel dangnhap(String username, String password){
        TaiKhoanModel tk = null;
        
        
        try {
            String sql = "Select * from TAIKHOAN where convert(varbinary, TENDN) = convert(varbinary, ?) and convert(varbinary, MATKHAU) = convert(varbinary, ?) ";
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement pre = com.prepareStatement(sql);
            pre.setString(1, username);
            pre.setString(2, password);

            ResultSet rs = pre.executeQuery();
            
            if(rs.next()){
                tk = new TaiKhoanModel();
                tk.setTENDN(rs.getString(1));
                tk.setMATKHAU(rs.getString(2));
                tk.setROLE(rs.getString(3));
                tk.setTINHTRANG(1);
            }
        } catch (Exception e) {

            System.out.println(e.toString());
        }
        
        return tk;
    }
    
    // cap nhat tinh trang dang su dung khi vua login
    public Integer CapNhatTinhTrang(String TENDN){
        TaiKhoanModel tk = null;
        
        
        try {
            String sql = "Update TAIKHOAN set TINHTRANG=1 where TENDN=? ";
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement pre = com.prepareStatement(sql);       
            pre.setString(1, TENDN);

            return pre.executeUpdate();
        } catch (Exception e) {

            System.out.println(e.toString());
        }
        
        return -1;
    }
    
    // cap nhat tinh trang khong su dung khi nhan dang xuat
    public Integer CapNhatTinhTrangOut(){
        TaiKhoanModel tk = null;
        
        
        try {
            String sql = "Update TAIKHOAN set TINHTRANG=0 where TINHTRANG=1 ";
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement pre = com.prepareStatement(sql);       
//            pre.setString(1, TENDN);

            return pre.executeUpdate();
        } catch (Exception e) {

            System.out.println(e.toString());
        }
        
        return -1;
    }
    public ArrayList<TaiKhoanModel> layThongTin(){
        ArrayList<TaiKhoanModel> arr = new ArrayList<TaiKhoanModel>();
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            System.out.println("asdfcvcv");
            
            String sql = "select TENDN, MATKHAU, ROLE, TINHTRANG FROM TAIKHOAN";
            Statement st =com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                TaiKhoanModel tk = new TaiKhoanModel();
                tk.setTENDN(rs.getString(1));
                tk.setMATKHAU(rs.getString(2));
                tk.setROLE( rs.getString(3));
                tk.setTINHTRANG(rs.getInt(4));
             
                arr.add(tk);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arr;
    }
    
    public ArrayList<TaiKhoanModel> docDanhMuc(){
    ArrayList<TaiKhoanModel> arr = new ArrayList<TaiKhoanModel>();
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            System.out.println("asdfcvcv");
            
            String sql = "select TENDN, MATKHAU, ROLE FROM TAIKHOAN";
            Statement st =com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                TaiKhoanModel tk = new TaiKhoanModel();
                tk.setTENDN(rs.getString(1));
                tk.setMATKHAU(rs.getString(2));
                tk.setROLE( rs.getString(3));
                //tk.setTINHTRANG(rs.getInt(4));
             
                arr.add(tk);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arr;
}
    public ArrayList<TaiKhoanModel> loadComboBox(){
        ArrayList<TaiKhoanModel> arr = new ArrayList<TaiKhoanModel>();
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select ROLE from TAIKHOAN GROUP BY ROLE";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                TaiKhoanModel tk = new TaiKhoanModel();
                tk.setROLE(rs.getString(1));
                arr.add(tk);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arr;
    }
    
    public ArrayList<TaiKhoanModel> Search(String TenDN){
        ArrayList<TaiKhoanModel> arr = new ArrayList<TaiKhoanModel>();
         try {
           
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            System.out.println(TenDN);
            
            String sql = "select * from TAIKHOAN where TENDN=?";
            PreparedStatement ps = com.prepareStatement(sql);
            ps.setString(1, TenDN);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                TaiKhoanModel tk = new TaiKhoanModel();
                
                tk.setTENDN(rs.getString(1));
                tk.setMATKHAU(rs.getString(2));
                tk.setROLE(rs.getString(3));
                
                arr.add(tk);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public int AddTK(TaiKhoanModel tk){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement(" insert into TAIKHOAN values(?,?,?,?)");
                                          
            ps.setString(1, tk.getTENDN());
            ps.setString(2, tk.getMATKHAU());
            ps.setString(3, tk.getROLE());
            ps.setString(4,"1");
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public boolean DeleteTK(String TenDN){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("Delete TaiKhoan where TENDN=?");
            
            ps.setString(1,TenDN);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    public ArrayList<TaiKhoanModel> listTenDN(){
        ArrayList<TaiKhoanModel> arr = new ArrayList<TaiKhoanModel>();
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select TENDN from TAIKHOAN GROUP BY TENDN";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                TaiKhoanModel tk = new TaiKhoanModel();
                tk.setTENDN(rs.getString(1));
                arr.add(tk);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public int UpdateTK(TaiKhoanModel tk){
         try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("Update TAIKHOAN set TENDN=?,MATKHAU=?,ROLE=?,TINHTRANG=? where TENDN=?");
                                          
            ps.setString(1, tk.getTENDN());
            ps.setString(2, tk.getMATKHAU());
            ps.setString(3, tk.getROLE());
            ps.setString(4, "0");
            
            ps.setString(5, tk.getTENDN());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
}
