/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import ConnectDatabase.ConnectDB;
import Model.HoaDonModel;
import java.util.ArrayList;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



/**
 *
 * @author 21521
 */
public class HoaDonDao {
     public ArrayList<HoaDonModel> layThongTin(){
        ArrayList<HoaDonModel> arr = new ArrayList<HoaDonModel>();
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            System.out.println("asdfcvcv");
            
            String sql = "select MAHD, MAKH, HD.MAVE, NGAYLAP, TIENVE FROM HOADON HD, VE WHERE HD.MAVE = VE.MAVE";
            
            Statement st =com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                HoaDonModel hd = new HoaDonModel();
                hd.setMAHD(rs.getInt(1));
                hd.setMAKH(rs.getString(2)); 
                hd.setMAVE(rs.getString(3));
                hd.setNGAYLAP(rs.getDate(4));
                hd.setTHANHTIEN(rs.getInt(5));
                arr.add(hd);
            }
           
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return arr;
    }
            
    public ArrayList<HoaDonModel> docDanhMuc(){
        
        ArrayList<HoaDonModel> arr = new ArrayList<HoaDonModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select MAHD, MAKH, HD.MAVE, NGAYLAP, TIENVE FROM HOADON HD, VE WHERE HD.MAVE = VE.MAVE";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                HoaDonModel hd = new HoaDonModel();
                
                hd.setMAHD(rs.getInt(1));
                hd.setMAKH(rs.getString(2));
                hd.setMAVE( rs.getString(3));
                hd.setNGAYLAP( rs.getDate(4));
                hd.setTHANHTIEN(rs.getInt(5));
                
                arr.add(hd);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    public int AddHD(HoaDonModel hd){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy insert into HOADON values(?,?,?)");
                                          
            ps.setString(1, hd.getMAKH());
            ps.setString(2, hd.getMAVE());
            
            DateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          
            ps.setString(3, dateFormat.format(hd.getNGAYLAP()));
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
     public boolean DeleteHD(int MaHD){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("Delete HOADON where MAHD=?");
                                          
 
            ps.setInt(1, MaHD);
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
     
        public ArrayList<HoaDonModel> listMAHD(){
        
        ArrayList<HoaDonModel> arr = new ArrayList<HoaDonModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select MAHD from HOADON GROUP BY MAHD";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                HoaDonModel hd = new HoaDonModel();
                hd.setMAHD(rs.getInt(1));
                arr.add(hd);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    public int UpdateHD(HoaDonModel hd){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy Update HOADON set MAKH=?,MAVE=?,NGAYLAP = ? where MAHD=?");
                                          
            ps.setString(1, hd.getMAKH());
            ps.setString(2, hd.getMAVE());
            
            // Chuyen doi string sang date
            DateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            ps.setString(3, dateFormat.format(hd.getNGAYLAP()));
            
            ps.setInt(4, hd.getMAHD());            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
     public ArrayList<HoaDonModel> Search(int maHD){
        
        ArrayList<HoaDonModel> arr = new ArrayList<HoaDonModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            System.out.println(maHD);
            
            //String sql = "select * from HOADON where MAHD=?";
            String sql ="select MAHD, MAKH, HD.MAVE, NGAYLAP, TIENVE FROM HOADON HD, VE WHERE HD.MAVE = VE.MAVE AND MAHD =?";
            PreparedStatement ps = com.prepareStatement(sql);
            ps.setInt(1, maHD);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                HoaDonModel hd = new HoaDonModel();
                
                hd.setMAHD(rs.getInt(1));
                hd.setMAKH(rs.getString(2));
                hd.setMAVE(rs.getString(3));
                hd.setNGAYLAP(rs.getDate(4));
                hd.setTHANHTIEN(rs.getInt(5));
                
                arr.add(hd);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
}
