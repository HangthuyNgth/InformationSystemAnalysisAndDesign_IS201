package Dao;

import Model.VeModel;
import java.sql.Connection;
import java.util.Vector;
import java.sql.*;
import java.util.ArrayList;
import ConnectDatabase.ConnectDB;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class VeDao {
    public ArrayList<VeModel> layThongTin(){
        
        ArrayList<VeModel> arr = new ArrayList<VeModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            System.out.println("asdfcvcv");
            
            String sql = "select MAVE,MACHUYEN,TIENVE,LOAIGHE from VE";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                VeModel ve = new VeModel();
                
                ve.setMaVe(rs.getString(1));
                ve.setMaChuyen(rs.getString(2));
                ve.setTienVe(rs.getInt(3));
                ve.setLoaiGhe(rs.getString(4));
                ve.setSoLuong(rs.getInt(5));
                arr.add(ve);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<VeModel> docDanhMuc(){
        
        ArrayList<VeModel> arr = new ArrayList<VeModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select * from VE";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                VeModel ve = new VeModel();
                
                ve.setMaVe(rs.getString(1));
                ve.setMaChuyen(rs.getString(2));
                ve.setTienVe(rs.getInt(3));
                ve.setLoaiGhe(rs.getString(4));
                ve.setSoLuong(rs.getInt(5));
                arr.add(ve);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<VeModel> loadComboBox(){
        
        ArrayList<VeModel> arr = new ArrayList<VeModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select LOAIGHE from VE GROUP BY LOAIGHE";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                VeModel ve = new VeModel();
                ve.setLoaiGhe(rs.getString(1));
                arr.add(ve);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<VeModel> listMaVe(){
        
        ArrayList<VeModel> arr = new ArrayList<VeModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select MAVE from VE GROUP BY MAVE";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                VeModel ve = new VeModel();
                ve.setMaVe(rs.getString(1));
                arr.add(ve);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<VeModel> Search(String MaVe){
        
        ArrayList<VeModel> arr = new ArrayList<VeModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            System.out.println(MaVe);
            
            String sql = "select * from VE where MAVE=?";
            PreparedStatement ps = com.prepareStatement(sql);
            ps.setString(1, MaVe);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
               VeModel ve = new VeModel();
                
                ve.setMaVe(rs.getString(1));
                ve.setMaChuyen(rs.getString(2));
                ve.setTienVe(rs.getInt(3));
                ve.setLoaiGhe(rs.getString(4));
                ve.setSoLuong(rs.getInt(5));
                arr.add(ve);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public int AddVe(VeModel ve){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy insert into VE values(?,?,?,?)");
                                          
            ps.setString(1, ve.getMaChuyen());
            ps.setInt(2, ve.getTienVe());
            ps.setString(3, ve.getLoaiGhe().toString());
            ps.setInt(4, ve.getSoLuong());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public int UpdateVe(VeModel ve){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy Update VE set MACHUYEN=?,TIENVE=?,LOAIGHE=?, SOLUONG=? where MAVE=?");
                                          
            ps.setString(1, ve.getMaChuyen());
            ps.setInt(2, ve.getTienVe());
            ps.setString(3, ve.getLoaiGhe().toString());
            ps.setString(5, ve.getMaVe());
            ps.setInt(4, ve.getSoLuong());
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public boolean DeleteVe(String MaVe){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("Delete VE where MAVE=?");
                                          
 
            ps.setString(1, MaVe);
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
}