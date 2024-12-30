/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.TauModel;
import java.sql.Connection;
import java.util.Vector;
import java.sql.*;
import java.util.ArrayList;
import ConnectDatabase.ConnectDB;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class TauDao {
    public ArrayList<TauModel> layThongTin(){
        
        ArrayList<TauModel> arr = new ArrayList<TauModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            System.out.println("asdfcvcv");
            
            String sql = "select MATAU, TENTAU, HANGSX, SOGHEL1, SOGHEL2, TONGSOGHE, TINHTRANG from TAU";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                TauModel tau = new TauModel();
                
                tau.setMATAU(rs.getString(1));
                tau.setTENTAU(rs.getString(2));
                tau.setHANGSX(rs.getString(3));
                tau.setSOGHEL1(rs.getInt(4));
                tau.setSOGHEL2(rs.getInt(5));
                tau.setTONGSOGHE(rs.getInt(6));
                tau.setTINHTRANG(rs.getInt(7));
               
                arr.add(tau);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<TauModel> docDanhMuc(){
        
        ArrayList<TauModel> arr = new ArrayList<TauModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select * from TAU";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                TauModel tau = new TauModel();
                
                tau.setMATAU(rs.getString(1));
                tau.setTENTAU(rs.getString(2));
                tau.setHANGSX(rs.getString(3));
                tau.setSOGHEL1(rs.getInt(4));
                tau.setSOGHEL2(rs.getInt(5));
                tau.setTONGSOGHE(rs.getInt(6));
                tau.setTINHTRANG(rs.getInt(7));
                
                
                arr.add(tau);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<TauModel> loadComboBox(){
        
        ArrayList<TauModel> arr = new ArrayList<TauModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select HANGSX from TAU GROUP BY HANGSX";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                TauModel tau = new TauModel();
                tau.setHANGSX(rs.getString(1));
                arr.add(tau);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<TauModel> listMATAU(){
        
        ArrayList<TauModel> arr = new ArrayList<TauModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select MATAU from TAU GROUP BY MATAU";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                TauModel tau = new TauModel();
                tau.setMATAU(rs.getString(1));
                arr.add(tau);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public ArrayList<TauModel> Search(String maTAU){
        
        ArrayList<TauModel> arr = new ArrayList<TauModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            System.out.println(maTAU);
            
            String sql = "select * from TAU where TENTAU like ?";
            PreparedStatement ps = com.prepareStatement(sql);
            ps.setString(1, '%'+maTAU+'%');
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                TauModel tau = new TauModel();
                
                tau.setMATAU(rs.getString(1));
                tau.setTENTAU(rs.getString(2));
                tau.setHANGSX(rs.getString(3));
                tau.setSOGHEL1(rs.getInt(4));
                tau.setSOGHEL2(rs.getInt(5));
                tau.setTONGSOGHE(rs.getInt(6));
                tau.setTINHTRANG(rs.getInt(7));              
                
                arr.add(tau);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    
    public int AddTau(TauModel tau){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy insert into TAU values(?,?,?,?,?,?)");

            ps.setString(1, tau.getTENTAU());
            ps.setString(2, tau.getHANGSX());
            ps.setInt(3, tau.getSOGHEL1());
            ps.setInt(4, tau.getSOGHEL2());
            ps.setInt(5, tau.getTONGSOGHE());
            ps.setInt(6, tau.getTINHTRANG());
            
            
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public int UpdateTau(TauModel tau){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy Update TAU set TENTAU=?,HANGSX=?,SOGHEL1=?,SOGHEL2=?,TONGSOGHE=?,TINHTRANG=? where MATAU=?");
                                          
            
            ps.setString(1, tau.getTENTAU());
            ps.setString(2, tau.getHANGSX());
            ps.setInt(3, tau.getSOGHEL1());
            ps.setInt(4, tau.getSOGHEL2());
            ps.setInt(5, tau.getTONGSOGHE());
            ps.setInt(6, tau.getTINHTRANG());
            ps.setString(7, tau.getMATAU());
            
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    public boolean DeleteTau(String maTAU){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("Delete TAU where MATAU=?");
                                          
 
            ps.setString(1, maTAU);
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    
    // Update thong tin trong form customer
    public int UpdateTTTau(TauModel tau){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy Update TAU set TENTAU=?,HANGSX=?,SOGHEL1=?,SOGHEL2=?,TONGSOGHE=?,TINHTRANG=? where MATAU=?");
                                          

            ps.setString(1, tau.getTENTAU());
            ps.setString(2, tau.getHANGSX());
            ps.setInt(3, tau.getSOGHEL1());
            ps.setInt(4, tau.getSOGHEL2());
            ps.setInt(5, tau.getTONGSOGHE());
            ps.setInt(6, tau.getTINHTRANG());
            ps.setString(7, tau.getMATAU());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    
    /*public String layTenDN(String MAKH){
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
    }*/
}
