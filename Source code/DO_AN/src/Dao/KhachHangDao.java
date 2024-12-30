
package Dao;

import Model.KhachHangModel;
import java.sql.Connection;
import java.util.Vector;
import java.sql.*;
import java.util.ArrayList;
import ConnectDatabase.ConnectDB;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class KhachHangDao {
    
    public ArrayList<KhachHangModel> layThongTin(){
        
        ArrayList<KhachHangModel> arr = new ArrayList<KhachHangModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select KH.MAKH, KH.TENDN, KH.TENKH, KH.VI, KH.DIACHI, KH.GIOITINH, KH.SDT, KH.NGSINH from KHACHHANG KH, TAIKHOAN WHERE KH.TENDN = TAIKHOAN.TENDN AND TAIKHOAN.TINHTRANG = 1";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                KhachHangModel kh = new KhachHangModel();
                
                kh.setMAKH(rs.getString(1));
                kh.setTENDN(rs.getString(2));
                kh.setTENKH(rs.getString(3));
                kh.setVI(rs.getInt(4));
                kh.setDIACHI(rs.getString(5));
                
                kh.setGIOITINH(rs.getString(6));
                kh.setSDT(rs.getString(7));
                kh.setNGSINH(rs.getDate(8));
                
                arr.add(kh);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<KhachHangModel> docDanhMuc(){
        
        ArrayList<KhachHangModel> arr = new ArrayList<KhachHangModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select * from KHACHHANG";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                KhachHangModel kh = new KhachHangModel();
                
                kh.setMAKH(rs.getString(1));
                kh.setTENDN(rs.getString(2));
                kh.setTENKH(rs.getString(3));
                kh.setVI(rs.getInt(4));
                kh.setDIACHI(rs.getString(5));
                kh.setGIOITINH(rs.getString(6));
                kh.setSDT(rs.getString(7));
                kh.setNGSINH(rs.getDate(8));
                
                arr.add(kh);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<KhachHangModel> loadComboBox(){
        
        ArrayList<KhachHangModel> arr = new ArrayList<KhachHangModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select GIOITINH from KHACHHANG GROUP BY GIOITINH";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                KhachHangModel kh = new KhachHangModel();
                kh.setGIOITINH(rs.getString(1));
                arr.add(kh);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<KhachHangModel> listMAKH(){
        
        ArrayList<KhachHangModel> arr = new ArrayList<KhachHangModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select MAKH from KHACHHANG GROUP BY MAKH";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                KhachHangModel kh = new KhachHangModel();
                kh.setMAKH(rs.getString(1));
                arr.add(kh);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<KhachHangModel> Search(String maKH){
        
        ArrayList<KhachHangModel> arr = new ArrayList<KhachHangModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            System.out.println(maKH);
            
            String sql = "select * from KHACHHANG where TENKH like ? ";
            PreparedStatement ps = com.prepareStatement(sql);
            ps.setString(1, '%'+maKH+'%');
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                KhachHangModel kh = new KhachHangModel();
                
                kh.setMAKH(rs.getString(1));
                kh.setTENDN(rs.getString(2));
                kh.setTENKH(rs.getString(3));
                kh.setVI(rs.getInt(4));
                kh.setDIACHI(rs.getString(5));
                kh.setGIOITINH(rs.getString(6));
                kh.setSDT(rs.getString(7));
                kh.setNGSINH(rs.getDate(8));
                
                arr.add(kh);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public int AddKH(KhachHangModel kh){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy insert into KHACHHANG values(?,?,?,?,?,?,?)");
                                          
            ps.setString(1, kh.getTENDN());
            ps.setString(2, kh.getTENKH());
            ps.setInt(3, kh.getVI());
            ps.setString(4, kh.getDIACHI());
            ps.setString(5, kh.getGIOITINH().toString());
            ps.setString(6, kh.getSDT());
            
            DateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            ps.setString(7, dateFormat.format(kh.getNGSINH()));
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public int UpdateKH(KhachHangModel kh){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy Update KHACHHANG set TENDN=?,TENKH=?,VI=?,DIACHI=?,GIOITINH=?,SDT=?,NGSINH=? where MAKH=?");
                                          
            ps.setString(1, kh.getTENDN());
            ps.setString(2, kh.getTENKH());
            ps.setInt(3, kh.getVI());
            ps.setString(4, kh.getDIACHI());
            ps.setString(5, kh.getGIOITINH().toString());
            ps.setString(6, kh.getSDT());
            
            // Chuyen doi string sang date
            DateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            ps.setString(7, dateFormat.format(kh.getNGSINH()));
            
            ps.setString(8, kh.getMAKH());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("ádfasdfasdfasdf");
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public boolean DeleteKH(String maKH){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("Delete KHACHHANG where MAKH=?");
                                          
 
            ps.setString(1, maKH);
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    
    // Update thong tin trong form customer
    public int UpdateTTKH(KhachHangModel kh){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy Update KHACHHANG set TENKH=?,VI=?,DIACHI=?,GIOITINH=?,SDT=?,NGSINH=? where MAKH=?");
                                          

            ps.setString(1, kh.getTENKH());
            ps.setInt(2, kh.getVI());
            ps.setString(3, kh.getDIACHI());
            ps.setString(4, kh.getGIOITINH().toString());
            ps.setString(5, kh.getSDT());
            
            // Chuyen doi string sang date
            DateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            ps.setString(6, dateFormat.format(kh.getNGSINH()));
            
            ps.setString(7, kh.getMAKH());
            
            System.out.println(kh.getMAKH());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public String layTenDN(String MAKH){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("Select KHACHHANG.TENDN FROM TAIKHOAN, KHACHHANG where MAKH=? AND TAIKHOAN.TENDN = KHACHHANG.TENDN");
            ps.setString(1, MAKH);                        

            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "";
    }
}
