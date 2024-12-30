
package JPanel_Admin;

import ConnectDatabase.ConnectDB;
import Dao.ChuyenTauDao;
import Model.ChuyenTauModel;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

public class ChuyenTauJPanel_Admin extends javax.swing.JPanel {

    DefaultTableModel jTableChuyenTauModel = new DefaultTableModel();
    ArrayList<ChuyenTauModel> arr;
    String maChuyen;
    
    public ChuyenTauJPanel_Admin() {
        initComponents();
        loadData();
        txtMaChuyen.setEditable(false);
    }

    public void loadData(){
        
        jTableChuyenTauModel = (DefaultTableModel)jTableChuyenTau.getModel();
        jTableChuyenTauModel.setRowCount(0);
        ChuyenTauDao ctDao = new ChuyenTauDao();
        arr = ctDao.docDanhMuc();
        
        String tieude[] = {"Mã chuyến", "Mã tuyến", "Mã tàu", "Ngày khởi hành", "Giờ khởi hành"};
        jTableChuyenTauModel.setColumnIdentifiers(tieude);
        
        for(int i = 0; i < arr.size(); i++){
            
            Vector<Object> vec = new Vector<>();
            
            vec.add(arr.get(i).getMaChuyen());
            vec.add(arr.get(i).getMaTuyen());
            vec.add(arr.get(i).getMaTau());
            vec.add(arr.get(i).getNgayKhoiHanh()) ;
            vec.add(arr.get(i).getGioKhoiHanh()) ;
            
            jTableChuyenTauModel.addRow(vec);
        }
    }  
    private void xoaTrang(){
        txtMaChuyen.setText("");
        txtMaTuyen.setText("");
        txtMaTau.setText("");
        txtNgayKhoiHanh.setText("");
        txtGioKhoiHanh.setText("");
    }
    public void loadData_1(String MaChuyen){
        if(txtTimKiemVe.getText().equals("")){
            return;
        }
        else{
            MaChuyen = txtTimKiemVe.getText();
            
            jTableChuyenTauModel = (DefaultTableModel)jTableChuyenTau.getModel();
            jTableChuyenTauModel.setRowCount(0);
            ChuyenTauDao ctDao = new ChuyenTauDao();
            arr = ctDao.Search(MaChuyen);

            String tieude[] = {"Mã chuyến", "Mã tuyến", "Mã tàu", "Ngày khởi hành", "Giờ khởi hành"};
            jTableChuyenTauModel.setColumnIdentifiers(tieude);
            
            if(arr.size() > 0){
                for(int i = 0; i < arr.size(); i++){

                    Vector<Object> vec = new Vector<>();

                    vec.add(arr.get(i).getMaChuyen());
                    vec.add(arr.get(i).getMaTuyen());
                    vec.add(arr.get(i).getMaTau());
                    vec.add(arr.get(i).getNgayKhoiHanh()) ;
                    vec.add(arr.get(i).getGioKhoiHanh()) ;

                    jTableChuyenTauModel.addRow(vec);
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

        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableChuyenTau = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThemVe = new javax.swing.JButton();
        btnXoaVe = new javax.swing.JButton();
        btnSuaVe = new javax.swing.JButton();
        btnTimKiemVe = new javax.swing.JButton();
        txtTimKiemVe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaChuyen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaTuyen = new javax.swing.JTextField();
        txtTrangThaiVe = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMaTau = new javax.swing.JTextField();
        Refresh = new javax.swing.JButton();
        txtGioKhoiHanh = new javax.swing.JTextField();
        txtNgayKhoiHanh = new javax.swing.JTextField();
        jlbTT = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(766, 588));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(766, 0));

        jTableChuyenTau.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableChuyenTau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã chuyến", "Mã tuyến", "Mã tàu", "Ngày khởi hành", "Giờ khởi hành"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableChuyenTau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableChuyenTauMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableChuyenTau);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 194, 106));
        jLabel1.setText("CHUYẾN TÀU");
        jLabel1.setMaximumSize(new java.awt.Dimension(135, 29));
        jLabel1.setMinimumSize(new java.awt.Dimension(135, 29));
        jLabel1.setPreferredSize(new java.awt.Dimension(180, 29));

        jSeparator1.setBackground(new java.awt.Color(11, 194, 106));
        jSeparator1.setForeground(new java.awt.Color(11, 194, 106));

        btnThemVe.setBackground(new java.awt.Color(11, 194, 106));
        btnThemVe.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnThemVe.setForeground(new java.awt.Color(255, 255, 255));
        btnThemVe.setText("Thêm");
        btnThemVe.setToolTipText("");
        btnThemVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVeActionPerformed(evt);
            }
        });

        btnXoaVe.setBackground(new java.awt.Color(11, 194, 106));
        btnXoaVe.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnXoaVe.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaVe.setText("Xóa");
        btnXoaVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaVeActionPerformed(evt);
            }
        });

        btnSuaVe.setBackground(new java.awt.Color(11, 194, 106));
        btnSuaVe.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnSuaVe.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaVe.setText("Sửa");
        btnSuaVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaVeActionPerformed(evt);
            }
        });

        btnTimKiemVe.setBackground(new java.awt.Color(11, 194, 106));
        btnTimKiemVe.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnTimKiemVe.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemVe.setText("Tìm kiếm");
        btnTimKiemVe.setToolTipText("");
        btnTimKiemVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemVeActionPerformed(evt);
            }
        });

        txtTimKiemVe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTimKiemVe.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimKiemVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemVeMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã chuyến:");

        txtMaChuyen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaChuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaChuyenMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Ngày khởi hành:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Mã tuyến:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Giờ khởi hành:");

        txtMaTuyen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaTuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaTuyenMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtMaTuyenMouseEntered(evt);
            }
        });

        txtTrangThaiVe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTrangThaiVe.setText("Trạng thái:");
        txtTrangThaiVe.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtTrangThaiVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrangThaiVeActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Mã tàu:");

        txtMaTau.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaTau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaTauMouseClicked(evt);
            }
        });

        Refresh.setBackground(new java.awt.Color(11, 194, 106));
        Refresh.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        Refresh.setForeground(new java.awt.Color(255, 255, 255));
        Refresh.setText("Làm mới");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        txtGioKhoiHanh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtGioKhoiHanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGioKhoiHanhMouseClicked(evt);
            }
        });

        txtNgayKhoiHanh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgayKhoiHanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayKhoiHanhMouseClicked(evt);
            }
        });

        jlbTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(118, 118, 118)
                                        .addComponent(txtMaChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGioKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnXoaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnThemVe, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTrangThaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(214, 214, 214)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Refresh)))
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTimKiemVe, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTimKiemVe, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtMaTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(118, 118, 118)
                                    .addComponent(txtMaTau, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiemVe, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemVe, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(btnSuaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGioKhoiHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayKhoiHanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaTau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrangThaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(Refresh)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        xoaTrang();
        loadData();
        txtTimKiemVe.setText("");
        jlbTT.setText("");
    }//GEN-LAST:event_RefreshActionPerformed

    private void txtTrangThaiVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrangThaiVeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrangThaiVeActionPerformed

    private void btnTimKiemVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemVeActionPerformed
        xoaTrang();
        if(txtTimKiemVe.getText().equals("")){
            jlbTT.setText("Không thành công");
            jlbTT.setForeground(Color.red);
            loadData();
        }
        else{
            jlbTT.setText("Thành Công");
            jlbTT.setForeground(new Color(11,194,106));
            loadData_1(txtTimKiemVe.getText());
        }

    }//GEN-LAST:event_btnTimKiemVeActionPerformed

    private void btnSuaVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaVeActionPerformed
        ChuyenTauModel ct = new ChuyenTauModel();
        if(txtMaTuyen.getText().equals("") || txtMaTau.getText().equals("") || txtNgayKhoiHanh.getText().equals("") || txtGioKhoiHanh.getText().equals("") ){
            jlbTT.setText("Bạn cần nhập đủ dữ liệu");
            jlbTT.setForeground(Color.red);
            return;
        }
        else{
            ct.setMaChuyen(txtMaChuyen.getText());
            ct.setMaTuyen(txtMaTuyen.getText());
            ct.setMaTau(txtMaTau.getText());
            ct.setNgayKhoiHanh(Date.valueOf(txtNgayKhoiHanh.getText()));
            ct.setGioKhoiHanh(txtGioKhoiHanh.getText());

            ChuyenTauDao ctdao = new ChuyenTauDao();

            // Ktra chuyen trung lap
            try {
                ConnectDB a = new ConnectDB();
                Connection com = a.getConnection();

            
                String sql = "Select * from CHUYENTAU ";

                Statement st = com.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while(rs.next()){
                    String maTuyen = rs.getString(2);
                    String maTau = rs.getString(3);
                    String ngayKH = rs.getString(4);
                    String gioKH = rs.getString(5);
                    
                    if(txtMaTuyen.getText().equals(maTuyen) && txtMaTau.getText().equals(maTau)){
                        if(txtNgayKhoiHanh.getText().equals(ngayKH) && txtGioKhoiHanh.getText().equals(gioKH)){
                            jlbTT.setText("Dữ liệu đã có");
                            jlbTT.setForeground(Color.red);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                e.toString(); 
            }

            if(ctdao.UpdateCT(ct) > 0){
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                jTableChuyenTauModel.setRowCount(0);

                if(txtTimKiemVe.getText().equals("")){
                    loadData();
                }
                else{
                    loadData_1(txtTimKiemVe.getText());
                }
            }
            else{
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);

                return;
            }
        }
    }//GEN-LAST:event_btnSuaVeActionPerformed

    private void btnXoaVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaVeActionPerformed
        int index = jTableChuyenTau.getSelectedRow();
        if (index == -1) {
            jlbTT.setText("Vui lòng chọn 1 Chuyến Tàu trong bảng để xóa");
            jlbTT.setForeground(Color.red);
            return;
        }
        ChuyenTauDao ctdao = new ChuyenTauDao();

        int tk = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không","Xác nhận" ,JOptionPane.YES_NO_OPTION);
        if (tk==JOptionPane.YES_OPTION)
        {
            if (ctdao.DeleteCT(jTableChuyenTau.getValueAt(index,0).toString()))
            {
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                jTableChuyenTauModel.setRowCount(0);
                loadData();
            } else {
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
            }
        }
    }//GEN-LAST:event_btnXoaVeActionPerformed

    private void btnThemVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVeActionPerformed
        ChuyenTauModel ct = new ChuyenTauModel();

        if(txtMaTuyen.getText().equals("") || txtMaTau.getText().equals("") || txtNgayKhoiHanh.getText().equals("") || txtGioKhoiHanh.getText().equals("") ){
            jlbTT.setText("Bạn cần nhập đủ dữ liệu");
            jlbTT.setForeground(Color.red);
            return;
        }
        else{
            
            // Ktra chuyen trung lap
            try {
                ConnectDB a = new ConnectDB();
                Connection com = a.getConnection();

            
                String sql = "Select * from CHUYENTAU ";

                Statement st = com.createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                while(rs.next()){
                    String maTuyen = rs.getString(2);
                    String maTau = rs.getString(3);
                    String ngayKH = rs.getString(4);
                    String gioKH = rs.getString(5);
                    
                    if(txtMaTuyen.getText().equals(maTuyen) && txtMaTau.getText().equals(maTau)){
                        if(txtNgayKhoiHanh.getText().equals(ngayKH) && txtGioKhoiHanh.getText().equals(gioKH)){
                            jlbTT.setText("Dữ liệu đã có");
                            jlbTT.setForeground(Color.red);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                e.toString(); 
            }
            
            ct.setMaChuyen(txtMaChuyen.getText());
            ct.setMaTuyen(txtMaTuyen.getText());
            ct.setMaTau(txtMaTau.getText());
            ct.setNgayKhoiHanh(Date.valueOf(txtNgayKhoiHanh.getText()));
            ct.setGioKhoiHanh(txtGioKhoiHanh.getText());

            ChuyenTauDao ctdao = new ChuyenTauDao();
            
           
            if(ctdao.AddCT(ct) > 0){
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                jTableChuyenTauModel.setRowCount(0);
                loadData();
            }
            else{
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
            }
        }
    }//GEN-LAST:event_btnThemVeActionPerformed

    private void jTableChuyenTauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableChuyenTauMouseClicked
        if(jTableChuyenTau.getSelectedRow() >= 0){
            maChuyen = jTableChuyenTau.getValueAt(jTableChuyenTau.getSelectedRow(), 0) + "";
            txtMaChuyen.setText(jTableChuyenTau.getValueAt(jTableChuyenTau.getSelectedRow(), 0) + "");
            txtMaTuyen.setText(jTableChuyenTau.getValueAt(jTableChuyenTau.getSelectedRow(), 1) + "");
            txtMaTau.setText(jTableChuyenTau.getValueAt(jTableChuyenTau.getSelectedRow(), 2) + "");
            txtNgayKhoiHanh.setText(jTableChuyenTau.getValueAt(jTableChuyenTau.getSelectedRow(), 3) + "");
            txtGioKhoiHanh.setText(jTableChuyenTau.getValueAt(jTableChuyenTau.getSelectedRow(), 4) + "");
        }
        jlbTT.setText("");
    }//GEN-LAST:event_jTableChuyenTauMouseClicked

    private void txtTimKiemVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemVeMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtTimKiemVeMouseClicked

    private void txtMaChuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaChuyenMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMaChuyenMouseClicked

    private void txtGioKhoiHanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGioKhoiHanhMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtGioKhoiHanhMouseClicked

    private void txtMaTuyenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaTuyenMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTuyenMouseEntered

    private void txtMaTuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaTuyenMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMaTuyenMouseClicked

    private void txtNgayKhoiHanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayKhoiHanhMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNgayKhoiHanhMouseClicked

    private void txtMaTauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaTauMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMaTauMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JButton btnSuaVe;
    private javax.swing.JButton btnThemVe;
    private javax.swing.JButton btnTimKiemVe;
    private javax.swing.JButton btnXoaVe;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableChuyenTau;
    private javax.swing.JLabel jlbTT;
    private javax.swing.JTextField txtGioKhoiHanh;
    private javax.swing.JTextField txtMaChuyen;
    private javax.swing.JTextField txtMaTau;
    private javax.swing.JTextField txtMaTuyen;
    private javax.swing.JTextField txtNgayKhoiHanh;
    private javax.swing.JTextField txtTimKiemVe;
    private javax.swing.JTextField txtTrangThaiVe;
    // End of variables declaration//GEN-END:variables
}
