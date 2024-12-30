
package Dao;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import ConnectDatabase.ConnectDB;
import Model.TuyenTauModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TuyenTauDao {
    
    public ArrayList<TuyenTauModel> docDanhMuc(){
        
        ArrayList<TuyenTauModel> arr = new ArrayList<TuyenTauModel>();
         
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select * from TUYENTAU";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                TuyenTauModel tt = new TuyenTauModel();
                
                tt.setMaTuyen(rs.getString(1));
                tt.setTenGaDi(rs.getString(2));
                tt.setTenGaDen(rs.getString(3));
                
                arr.add(tt);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<TuyenTauModel> Search(String MaTuyen){
        
        ArrayList<TuyenTauModel> arr = new ArrayList<TuyenTauModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            System.out.println(MaTuyen);
            
            String sql = "select * from TUYENTAU where MaTuyen=?";
            PreparedStatement ps = com.prepareStatement(sql);
            ps.setString(1, MaTuyen);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               TuyenTauModel tt = new TuyenTauModel();
                tt.setMaTuyen(rs.getString(1));
                tt.setTenGaDi(rs.getString(2));
                tt.setTenGaDen(rs.getString(3));
                arr.add(tt);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public int AddTT(TuyenTauModel tt){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy insert into TUYENTAU values(?,?)");
                                          
            ps.setString(1, tt.getTenGaDi());
            ps.setString(2, tt.getTenGaDen());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public int UpdateTT(TuyenTauModel tt){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy Update TUYENTAU set TENGADI=?,TENGADEN=? where MATUYEN=?");
                                          
            ps.setString(3, tt.getMaTuyen());
            ps.setString(1, tt.getTenGaDi());
            ps.setString(2, tt.getTenGaDen());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public boolean DeleteTT(String MaTuyen){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("Delete TUYENTAU where MaTuyen=?");
                                          
 
            ps.setString(1, MaTuyen);
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    
    public ArrayList<TuyenTauModel> listMaTuyen(){
        
        ArrayList<TuyenTauModel> arr = new ArrayList<TuyenTauModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select MATUYEN from TUYENTAU GROUP BY MATUYEN";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                TuyenTauModel tt = new TuyenTauModel();
                tt.setMaTuyen(rs.getString(1));
                arr.add(tt);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
}
