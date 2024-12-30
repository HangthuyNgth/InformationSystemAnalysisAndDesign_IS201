
package JPanel_Admin;

import ConnectDatabase.ConnectDB;
import Dao.NhanVienDao;
import Model.NhanVienModel;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class NhanVienJPanel_Admin1 extends javax.swing.JPanel {
    DefaultTableModel tblNVModel = new DefaultTableModel();
    ArrayList<NhanVienModel> arr;
    int row;
    String maNV ="";
   
    public NhanVienJPanel_Admin1() {
        initComponents();
        loadData();
        txtMANV.setEditable(false);
        
    }
    
   
    // Hien thi du lieu len table
    public void loadData(){
        tblNVModel = (DefaultTableModel)jTable1.getModel();
        tblNVModel.setRowCount(0);
        NhanVienDao nvDao = new NhanVienDao();
        arr = nvDao.docDanhMuc();
        
        String tieude[] = {"MANV", "Tên ĐN", "Họ tên", "Ngày sinh", "Số điện thoại", "Địa chỉ"};
        tblNVModel.setColumnIdentifiers(tieude);
        
        for(int i = 0; i < arr.size(); i++){
            
            Vector<Object> vec = new Vector<>();
            
            vec.add(arr.get(i).getMANV());
            vec.add(arr.get(i).getTENDN());
            vec.add(arr.get(i).getTENNV()) ;
            vec.add(arr.get(i).getNGSINH()) ;
            vec.add(arr.get(i).getSDT()) ;
            vec.add(arr.get(i).getDIACHI()) ;
            
            tblNVModel.addRow(vec);
        }
    }  
    
    public void loadData_1(String maNV){
        if(txtNhapMANV.getText().equals("")){
            return;
        }
        else{
            maNV = txtNhapMANV.getText();
            tblNVModel = (DefaultTableModel)jTable1.getModel();
            tblNVModel.setRowCount(0);
            NhanVienDao nvDao = new NhanVienDao();
            arr = nvDao.Search(maNV);

            String tieude[] = {"MANV", "Tên ĐN", "Họ tên", "Ngày sinh", "Số điện thoại", "Địa chỉ"};
            tblNVModel.setColumnIdentifiers(tieude);
            
            if(arr.size() > 0){
                for(int i = 0; i < arr.size(); i++){

                    Vector<Object> vec = new Vector<>();

                    vec.add(arr.get(i).getMANV());
                    vec.add(arr.get(i).getTENDN());
                    vec.add(arr.get(i).getTENNV()) ;
                    vec.add(arr.get(i).getNGSINH()) ;
                    vec.add(arr.get(i).getSDT()) ;
                    vec.add(arr.get(i).getDIACHI()) ;
                                                         
                    tblNVModel.addRow(vec);
                }
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                
            }
            else{
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
                loadData();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnTimNhanVien = new javax.swing.JButton();
        txtNhapDiaChiNhanVien = new javax.swing.JTextField();
        txtNhapMANV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNhapHoTenNhanVien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        btnThemNhanVien = new javax.swing.JButton();
        btnXoaNhanVien = new javax.swing.JButton();
        txtNhapSDTNhanVien = new javax.swing.JTextField();
        btnSuaNhanVien = new javax.swing.JButton();
        txtTenDangNhapNhanVien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtMANV = new javax.swing.JTextField();
        btnRefreshNV = new javax.swing.JButton();
        jlbTT = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(766, 0));

        btnTimNhanVien.setBackground(new java.awt.Color(11, 194, 106));
        btnTimNhanVien.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnTimNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnTimNhanVien.setText("Tìm kiếm");
        btnTimNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimNhanVienActionPerformed(evt);
            }
        });

        txtNhapDiaChiNhanVien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNhapDiaChiNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNhapDiaChiNhanVienMouseClicked(evt);
            }
        });

        txtNhapMANV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Họ và tên:");

        txtNhapHoTenNhanVien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNhapHoTenNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNhapHoTenNhanVienMouseClicked(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MANV", "Tên đăng nhập", "Họ và tên", "Ngày sinh", "Số điện thoại", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Tên đăng nhập:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Ngày sinh:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 194, 106));
        jLabel1.setText("NHÂN VIÊN");
        jLabel1.setMaximumSize(new java.awt.Dimension(135, 29));
        jLabel1.setMinimumSize(new java.awt.Dimension(135, 29));
        jLabel1.setPreferredSize(new java.awt.Dimension(180, 29));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        jSeparator1.setBackground(new java.awt.Color(11, 194, 106));
        jSeparator1.setForeground(new java.awt.Color(11, 194, 106));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        btnThemNhanVien.setBackground(new java.awt.Color(11, 194, 106));
        btnThemNhanVien.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnThemNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnThemNhanVien.setText("Thêm");
        btnThemNhanVien.setToolTipText("");
        btnThemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanVienActionPerformed(evt);
            }
        });

        btnXoaNhanVien.setBackground(new java.awt.Color(11, 194, 106));
        btnXoaNhanVien.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnXoaNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaNhanVien.setText("Xóa");
        btnXoaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNhanVienActionPerformed(evt);
            }
        });

        txtNhapSDTNhanVien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNhapSDTNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNhapSDTNhanVienMouseClicked(evt);
            }
        });

        btnSuaNhanVien.setBackground(new java.awt.Color(11, 194, 106));
        btnSuaNhanVien.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnSuaNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaNhanVien.setText("Sửa");
        btnSuaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaNhanVienActionPerformed(evt);
            }
        });

        txtTenDangNhapNhanVien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTenDangNhapNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenDangNhapNhanVienMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Trạng thái:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Mã nhân viên:");

        txtMANV.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMANV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMANVMouseClicked(evt);
            }
        });

        btnRefreshNV.setBackground(new java.awt.Color(11, 194, 106));
        btnRefreshNV.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnRefreshNV.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshNV.setText("Làm mới");
        btnRefreshNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshNVActionPerformed(evt);
            }
        });

        jlbTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefreshNV, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNhapMANV, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(btnTimNhanVien))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnXoaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnThemNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNhapHoTenNhanVien)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addComponent(jLabel5)
                                    .addGap(14, 14, 14))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel3)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMANV, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtTenDangNhapNhanVien)
                            .addComponent(txtNhapSDTNhanVien)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(34, 34, 34)
                        .addComponent(txtNhapDiaChiNhanVien)))
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNhapMANV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMANV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNhapHoTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenDangNhapNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtNhapSDTNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNhapDiaChiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRefreshNV)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, 795, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void xoaTrang(){
        txtMANV.setText("");
        txtTenDangNhapNhanVien.setText("");
        txtNhapHoTenNhanVien.setText("");
        txtNhapDiaChiNhanVien.setText("");
        txtNhapSDTNhanVien.setText("");
        jTextField1.setText("");
    }
    
    private boolean ktrSDT(String s) throws PhoneException{
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        boolean kt = s.matches(reg);
        
        if(kt == true && s.length() == 10)
            return true;
        return false;
    }
    private boolean ktrKiTuDacBiet(String s){
        //  ktr ki tu dac biet
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(s);
        
        // ktr so
        
        
//        Pattern pattern = Pattern.compile("\\d*");
//        Matcher matcher = pattern.matcher(s);  
        
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return false;
            }
            if (i + 1 == s.length()) {
                return true && m.find() == false;
            }
        } 
        
        return  false;
    }
    private void btnThemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanVienActionPerformed
        // TODO add your handling code here:
        NhanVienModel nv = new NhanVienModel();
        
        if(txtTenDangNhapNhanVien.getText().equals("") || txtNhapHoTenNhanVien.getText().equals("") || txtNhapDiaChiNhanVien.getText().equals("") || txtNhapSDTNhanVien.getText().equals("") || jTextField1.getText().equals("")){
            jlbTT.setText("Bạn cần nhập đủ dữ liệu");
            jlbTT.setForeground(Color.red);
            return;
        }
        
        // ktr sdt
        try {
            if(ktrSDT(txtNhapSDTNhanVien.getText()) == false){
                jlbTT.setText("SĐT không hợp lệ");
                jlbTT.setForeground(Color.red);
                return;
            }
        } catch (PhoneException ex) {
            System.out.println(ex.getMessage());
        }
        
            nv.setTENDN(txtTenDangNhapNhanVien.getText());
            nv.setTENNV(txtNhapHoTenNhanVien.getText());
            nv.setDIACHI(txtNhapDiaChiNhanVien.getText());
            nv.setSDT(txtNhapSDTNhanVien.getText());
            
            nv.setNGSINH(Date.valueOf(jTextField1.getText()));
            

            NhanVienDao khdao = new NhanVienDao();
            if(khdao.AddNV(nv) > 0){
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                tblNVModel.setRowCount(0);
                loadData();
            }
            else{
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
            }
                
        
    }//GEN-LAST:event_btnThemNhanVienActionPerformed

    private void btnXoaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNhanVienActionPerformed
        // TODO add your handling code here:
        int index = jTable1.getSelectedRow();
        if (index == -1) {
            jlbTT.setText("Vui lòng chọn 1 Nhân Viên trong bảng để xóa");
            jlbTT.setForeground(Color.red);
            return;
        }
        NhanVienDao khdao = new NhanVienDao();
        
        int tk = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không","Xác nhận" ,JOptionPane.YES_NO_OPTION);
        if (tk==JOptionPane.YES_OPTION)  
        {
            if (khdao.DeleteNV(jTable1.getValueAt(index,0).toString()))
            {
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                tblNVModel.setRowCount(0);
                loadData();
            } else {
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
            }
        }
    }//GEN-LAST:event_btnXoaNhanVienActionPerformed

    private void btnSuaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaNhanVienActionPerformed
        // TODO add your handling code here:
        NhanVienModel nv = new NhanVienModel();
        if(txtTenDangNhapNhanVien.getText().equals("") || txtNhapHoTenNhanVien.getText().equals("") ||  txtNhapDiaChiNhanVien.getText().equals("") || txtNhapSDTNhanVien.getText().equals("") || jTextField1.getText().equals("")){
            jlbTT.setText("Bạn cần nhập đủ dữ liệu");
            jlbTT.setForeground(Color.red);
            return;
        }
        
        // ktr sdt
        try {
            if(ktrSDT(txtNhapSDTNhanVien.getText()) == false){
                jlbTT.setText("SĐT không hợp lệ");
                jlbTT.setForeground(Color.red);
                return;
            }
        } catch (PhoneException ex) {
            System.out.println(ex.getMessage());
        }      
            nv.setMANV(txtMANV.getText());
            nv.setTENDN(txtTenDangNhapNhanVien.getText());
            nv.setTENNV(txtNhapHoTenNhanVien.getText());
            nv.setDIACHI(txtNhapDiaChiNhanVien.getText());
            nv.setNGSINH(Date.valueOf(jTextField1.getText()));
            nv.setSDT(txtNhapSDTNhanVien.getText());
            
            NhanVienDao khdao = new NhanVienDao();
            
//            // Ktr MANV
//            boolean chk = false;
//            if(nv.getMANV().equals(maNV)){
//                chk = true;
//            }
            
            
            if(khdao.UpdateNV(nv) > 0){
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                tblNVModel.setRowCount(0);

                if(txtNhapMANV.getText().equals("")){
                    loadData();
                }
                else{
                    loadData_1(txtNhapMANV.getText());
                }
                
            }
            else{
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
                
                return;
            }
    }//GEN-LAST:event_btnSuaNhanVienActionPerformed

    private void txtNhapTenDangNhapNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhapTenDangNhapNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhapTenDangNhapNhanVienActionPerformed

    private void btnRefreshNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshNVActionPerformed
        // TODO add your handling code here:
        xoaTrang();
        loadData();
        txtNhapMANV.setText("");
        jlbTT.setText("");
    }//GEN-LAST:event_btnRefreshNVActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if(jTable1.getSelectedRow() >= 0){
            maNV = jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "";
            txtMANV.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0) + "");
            txtTenDangNhapNhanVien.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1) + "");
            txtNhapHoTenNhanVien.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2) + "");           
            jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3) + "");
            txtNhapSDTNhanVien.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4) + "");
            txtNhapDiaChiNhanVien.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5) + "");
            
        }
        jlbTT.setText("");
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnTimNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimNhanVienActionPerformed
        // TODO add your handling code here:
        xoaTrang();
        if(txtNhapMANV.getText().equals("")){
            jlbTT.setText("Không thành công");
            jlbTT.setForeground(Color.red);
            loadData();
        }
        else{
            jlbTT.setText("Thành Công");
            jlbTT.setForeground(new Color(11,194,106));
            loadData_1(txtNhapMANV.getText());
        }
    }//GEN-LAST:event_btnTimNhanVienActionPerformed

    private void txtMANVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMANVMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMANVMouseClicked

    private void txtNhapHoTenNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapHoTenNhanVienMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNhapHoTenNhanVienMouseClicked

    private void txtTenDangNhapNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenDangNhapNhanVienMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtTenDangNhapNhanVienMouseClicked

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void txtNhapSDTNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapSDTNhanVienMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNhapSDTNhanVienMouseClicked

    private void txtNhapDiaChiNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapDiaChiNhanVienMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNhapDiaChiNhanVienMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefreshNV;
    private javax.swing.JButton btnSuaNhanVien;
    private javax.swing.JButton btnThemNhanVien;
    private javax.swing.JButton btnTimNhanVien;
    private javax.swing.JButton btnXoaNhanVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlbTT;
    private javax.swing.JTextField txtMANV;
    private javax.swing.JTextField txtNhapDiaChiNhanVien;
    private javax.swing.JTextField txtNhapHoTenNhanVien;
    private javax.swing.JTextField txtNhapMANV;
    private javax.swing.JTextField txtNhapSDTNhanVien;
    private javax.swing.JTextField txtTenDangNhapNhanVien;
    // End of variables declaration//GEN-END:variables
    private static class PhoneException extends Exception {

        public PhoneException(String str) {
            super(str);
        }
    }
}
