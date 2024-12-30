
package Dao;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import ConnectDatabase.ConnectDB;
import Model.ChuyenTauModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ChuyenTauDao {
    public ArrayList<ChuyenTauModel> layThongTin(){
        
        ArrayList<ChuyenTauModel> arr = new ArrayList<ChuyenTauModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            System.out.println("asdfcvcv");
            
            String sql = "select * from CHUYENTAU ";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                ChuyenTauModel ct = new ChuyenTauModel();
                
                ct.setMaChuyen(rs.getString(1));
                ct.setMaTuyen(rs.getString(2));
                ct.setMaTau(rs.getString(3));
                ct.setNgayKhoiHanh(rs.getDate(4));
                ct.setGioKhoiHanh(rs.getString(5));
                
                arr.add(ct);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<ChuyenTauModel> docDanhMuc(){
        
        ArrayList<ChuyenTauModel> arr = new ArrayList<ChuyenTauModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select * from chuyentau";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                ChuyenTauModel ct = new ChuyenTauModel();
                
                ct.setMaChuyen(rs.getString(1));
                ct.setMaTuyen(rs.getString(2));
                ct.setMaTau(rs.getString(3));
                ct.setNgayKhoiHanh(rs.getDate(4));
                ct.setGioKhoiHanh(rs.getString(5));
                
                arr.add(ct);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<ChuyenTauModel> listMaChuyen(){
        
        ArrayList<ChuyenTauModel> arr = new ArrayList<ChuyenTauModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select MaChuyen from ChuyenTau GROUP BY MaChuyen";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                ChuyenTauModel ct = new ChuyenTauModel();
                ct.setMaChuyen(rs.getString(1));
                arr.add(ct);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<ChuyenTauModel> Search(String MaChuyen){
        
        ArrayList<ChuyenTauModel> arr = new ArrayList<ChuyenTauModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            System.out.println(MaChuyen);
            
            String sql = "select * from chuyentau where MaChuyen=?";
            PreparedStatement ps = com.prepareStatement(sql);
            ps.setString(1, MaChuyen);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                ChuyenTauModel ct = new ChuyenTauModel();
                
                ct.setMaChuyen(rs.getString(1));
                ct.setMaTuyen(rs.getString(2));
                ct.setMaTau(rs.getString(3));
                ct.setNgayKhoiHanh(rs.getDate(4));
                ct.setGioKhoiHanh(rs.getString(5));
                
                arr.add(ct);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public int AddCT(ChuyenTauModel ct){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy insert into chuyentau values(?,?,?,?)");
                                          
            ps.setString(1, ct.getMaTuyen());
            ps.setString(2, ct.getMaTau());
            DateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            ps.setString(3, dateFormat.format(ct.getNgayKhoiHanh()));
            ps.setString(4, ct.getGioKhoiHanh());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public int UpdateCT(ChuyenTauModel ct){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy Update CHUYENTAU set MATUYEN=?,MATAU=?,NGAYKHOIHANH=?,GIOKHOIHANH=? where MACHUYEN=?");
                                          
            ps.setString(5, ct.getMaChuyen());
            ps.setString(1, ct.getMaTuyen());
            ps.setString(2, ct.getMaTau());
            DateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            ps.setString(3, dateFormat.format(ct.getNgayKhoiHanh()));
            ps.setString(4, ct.getGioKhoiHanh());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public boolean DeleteCT(String MaChuyen){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("Delete chuyentau where MaChuyen=?");
                                          
 
            ps.setString(1, MaChuyen);
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    //
    
}
