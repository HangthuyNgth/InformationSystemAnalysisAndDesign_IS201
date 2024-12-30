/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.NhanVienModel;
import java.sql.Connection;
import java.util.Vector;
import java.sql.*;
import java.util.ArrayList;
import ConnectDatabase.ConnectDB;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class NhanVienDao {

    public ArrayList<NhanVienModel> layThongTin(){
        
        ArrayList<NhanVienModel> arr = new ArrayList<NhanVienModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            System.out.println("asdfcvcv");
            
            String sql = "select NV.MANV, NV.TENDN, NV.TENNV, NV.NGSINH, NV.SDT, NV.DIACHI  from NHANVIEN NV, TAIKHOAN WHERE NV.TENDN = TAIKHOAN.TENDN AND TAIKHOAN.TINHTRANG = 1";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                NhanVienModel nv = new NhanVienModel();
                
                nv.setMANV(rs.getString(1));
                nv.setTENDN(rs.getString(2));
                nv.setTENNV(rs.getString(3));
                nv.setNGSINH(rs.getDate(5));
                nv.setSDT(rs.getString(6));
                nv.setDIACHI(rs.getString(4));                               
                arr.add(nv);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    public ArrayList<NhanVienModel> docDanhMuc(){
        
        ArrayList<NhanVienModel> arr = new ArrayList<NhanVienModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select * from NHANVIEN";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                NhanVienModel nv = new NhanVienModel();
                nv.setMANV(rs.getString(1));
                nv.setTENDN(rs.getString(2));
                nv.setTENNV(rs.getString(3));
                nv.setNGSINH(rs.getDate(5));
                nv.setSDT(rs.getString(6));
                nv.setDIACHI(rs.getString(4));
                
                
                arr.add(nv);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    public ArrayList<NhanVienModel> listMANV(){
        
        ArrayList<NhanVienModel> arr = new ArrayList<NhanVienModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String sql = "select MANV from NHANVIEN GROUP BY MANV";
            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                NhanVienModel nv = new NhanVienModel();
                nv.setMANV(rs.getString(1));
                arr.add(nv);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    public ArrayList<NhanVienModel> Search(String maNV){
        
        ArrayList<NhanVienModel> arr = new ArrayList<NhanVienModel>();
        
        try {
            
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            System.out.println(maNV);
            
            String sql = "select * from NHANVIEN where TENNV like ?";
            PreparedStatement ps = com.prepareStatement(sql);
            ps.setString(1, '%'+maNV+'%');
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                NhanVienModel nv = new NhanVienModel();
                
                nv.setMANV(rs.getString(1));
                nv.setTENDN(rs.getString(2));
                nv.setTENNV(rs.getString(3));
                nv.setNGSINH(rs.getDate(5));
                nv.setSDT(rs.getString(6));
                nv.setDIACHI(rs.getString(4));
                
                arr.add(nv);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return arr;
    }
    public int AddNV(NhanVienModel nv){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy insert into NHANVIEN values(?,?,?,?,?)");
                                          
            ps.setString(1, nv.getTENDN());
            ps.setString(2, nv.getTENNV());                        
            
            DateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            ps.setString(4, dateFormat.format(nv.getNGSINH()));
            ps.setString(5, nv.getSDT());
            ps.setString(3, nv.getDIACHI());
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    public int UpdateNV(NhanVienModel nv){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy Update NHANVIEN set TENDN=?,TENNV=?,DIACHI=?,NGSINH=?,SDT=? where MANV=?");
                                          
            ps.setString(1, nv.getTENDN());
            ps.setString(2, nv.getTENNV());
            ps.setString(3, nv.getDIACHI());
            
            
            // Chuyen doi string sang date
            DateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            ps.setString(4, dateFormat.format(nv.getNGSINH()));
            ps.setString(5, nv.getSDT());
            ps.setString(6, nv.getMANV());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    public boolean DeleteNV(String maNV){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            PreparedStatement ps = com.prepareStatement("Delete NHANVIEN where MANV=?");
                                          
 
            ps.setString(1, maNV);
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
    }
    // Update thong tin trong form customer
    public int UpdateTTNV(NhanVienModel nv){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("set dateformat dmy Update NHANVIEN set TENNV=?,DIACHI=?,NGSINH=?,SDT=? where MANV=?");
                                          

            ps.setString(1, nv.getTENNV());
            ps.setString(2, nv.getDIACHI());
            
            // Chuyen doi string sang date
            DateFormat dateFormat = null;
            dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            ps.setString(3, dateFormat.format(nv.getNGSINH()));
            ps.setString(4, nv.getSDT());            
            ps.setString(5, nv.getMANV());
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return -1;
    }
    public String layTenDN(String MANV){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            PreparedStatement ps = com.prepareStatement("Select NHANVIEN.TENDN FROM TAIKHOAN, NHANVIEN where MANV=? AND TAIKHOAN.TENDN = NHANVIEN.TENDN");
            ps.setString(1, MANV);                        

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
