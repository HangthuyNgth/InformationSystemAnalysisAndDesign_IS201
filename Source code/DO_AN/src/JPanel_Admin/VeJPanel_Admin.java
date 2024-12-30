
package JPanel_Admin;

import Dao.VeDao;
import Model.VeModel;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class VeJPanel_Admin extends javax.swing.JPanel {

    DefaultTableModel jTableVeModel = new DefaultTableModel();
    ArrayList<VeModel> arr;
    String maVe = "";
    
    public VeJPanel_Admin() {
        initComponents();
        loadData();
//        loadCombobox();
        txtMaVe.setEditable(false);
    }
    public void loadCombobox(){
        VeDao veDao = new VeDao();
        arr = veDao.loadComboBox();
        for(int i = 0; i < arr.size(); i++){
            cbxLoaiGhe.addItem(arr.get(i).getLoaiGhe());
        }
    }
    public void loadData(){
        jTableVeModel = (DefaultTableModel)jTableVe.getModel();
        jTableVeModel.setRowCount(0);
        VeDao veDao = new VeDao();
        arr = veDao.docDanhMuc();
        
        String tieude[] = {"Mã vé", "Mã chuyến", "Tiền vé", "Loại ghế", "Số lượng"};
        jTableVeModel.setColumnIdentifiers(tieude);
        
        for(int i = 0; i < arr.size(); i++){
            
            Vector<Object> vec = new Vector<>();
            
            vec.add(arr.get(i).getMaVe());
            vec.add(arr.get(i).getMaChuyen());
            
            vec.add(arr.get(i).getTienVe()) ;
            vec.add(arr.get(i).getLoaiGhe()) ;
            vec.add(arr.get(i).getSoLuong());
            
            jTableVeModel.addRow(vec);
        }
    }  
    private void xoaTrang(){
        txtMaVe.setText("");
        txtMaChuyen.setText("");
        txtTienVe.setText("");
        cbxLoaiGhe.setSelectedItem("L1");
        txtSoLuong.setText("");
        
    }
    public void loadData_1(String MaVe){
        if(txtTimKiemVe.getText().equals("")){
            return;
        }
        else{
            MaVe = txtTimKiemVe.getText();
            
            jTableVeModel = (DefaultTableModel)jTableVe.getModel();
            jTableVeModel.setRowCount(0);
            VeDao veDao = new VeDao();
            arr = veDao.Search(MaVe);

            String tieude[] = {"Mã vé", "Mã chuyến", "Tiền vé", "Loại ghế", "Số lượng"};
            jTableVeModel.setColumnIdentifiers(tieude);
            
            if(arr.size() > 0){
                for(int i = 0; i < arr.size(); i++){

                    Vector<Object> vec = new Vector<>();

                    vec.add(arr.get(i).getMaVe());
                    vec.add(arr.get(i).getMaChuyen());
                    
                    vec.add(arr.get(i).getTienVe()) ;
                    vec.add(arr.get(i).getLoaiGhe()) ;
                    vec.add(arr.get(i).getSoLuong()) ;
                    jTableVeModel.addRow(vec);
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
    private boolean ktrKiTuDacBiet(String s){
        //  ktr ki tu dac biet
        Pattern p = Pattern.compile("[^A-Za-z0-9]");
        Matcher m = p.matcher(s);
        
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVe = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThemVe = new javax.swing.JButton();
        btnXoaVe = new javax.swing.JButton();
        btnSuaVe = new javax.swing.JButton();
        btnTimKiemVe = new javax.swing.JButton();
        txtTimKiemVe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaVe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaChuyen = new javax.swing.JTextField();
        txtTrangThaiVe = new javax.swing.JTextField();
        txtTienVe = new javax.swing.JTextField();
        Refresh = new javax.swing.JButton();
        jlbTT = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        cbxLoaiGhe = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(766, 588));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(766, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(693, 667));

        jTableVe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTableVe.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã vé", "Mã chuyến", "Loại ghế", "Title 4", "Tiền vé"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
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
        jTableVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVe);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 194, 106));
        jLabel1.setText("VÉ");
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
        jLabel2.setText("Mã vé:");

        txtMaVe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaVeMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Loại ghế:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Mã chuyến:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Tiền vé:");

        txtMaChuyen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaChuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaChuyenMouseClicked(evt);
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

        txtTienVe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTienVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTienVeMouseClicked(evt);
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

        jlbTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Số lượng");

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cbxLoaiGhe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbxLoaiGhe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L1", "L2" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTimKiemVe, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(btnTimKiemVe))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnXoaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnThemVe)
                                        .addGap(29, 29, 29)
                                        .addComponent(btnSuaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(107, 107, 107))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMaChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(txtTrangThaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(txtMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txtSoLuong)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTienVe, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                            .addComponent(cbxLoaiGhe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(Refresh)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
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
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(btnSuaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaVe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbxLoaiGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTienVe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtMaChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrangThaiVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        txtTienVe.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        xoaTrang();
        loadData();
        txtTimKiemVe.setText("");
        jlbTT.setText("");
    }//GEN-LAST:event_RefreshActionPerformed

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
        VeModel ve = new VeModel();
        if(txtMaChuyen.getText().equals("") || cbxLoaiGhe.getSelectedItem().toString().equals("") || txtTienVe.getText().equals("") ){
            jlbTT.setText("Bạn cần nhập đủ dữ liệu");
            jlbTT.setForeground(Color.red);
            return;
        }
        if(ktrKiTuDacBiet(txtTienVe.getText()) == false || ktrKiTuDacBiet(txtSoLuong.getText()) == false ){
            if(ktrKiTuDacBiet(txtTienVe.getText()) == false){
                jlbTT.setText("Số tiền không hợp lệ");
                jlbTT.setForeground(Color.red);
                return;
            }
            jlbTT.setText("Số lượng không hợp lệ");
            jlbTT.setForeground(Color.red);
            return;
        }
        else if(Integer.parseInt(txtTienVe.getText()) < 0 || Integer.parseInt(txtSoLuong.getText()) < 0 ){
            if(Integer.parseInt(txtTienVe.getText()) < 0){
                jlbTT.setText("Số tiền không hợp lệ");
                jlbTT.setForeground(Color.red);
                return;
            }
            jlbTT.setText("Số lượng không hợp lệ");
            jlbTT.setForeground(Color.red);
            return;
        } 
        else{
            ve.setMaVe(txtMaVe.getText());
            ve.setMaChuyen(txtMaChuyen.getText());

            ve.setTienVe(Integer.parseInt(txtTienVe.getText()));
            ve.setLoaiGhe(cbxLoaiGhe.getSelectedItem().toString());
            ve.setSoLuong(Integer.parseInt(txtSoLuong.getText()));

            VeDao vedao = new VeDao();

//            // Ktr MAKH
//            boolean chk = false;
//            if( ve.getMaVe().equals(maVe)){
//                chk = true;
//            }

            if(vedao.UpdateVe(ve) > 0){
                    jlbTT.setText("Thành Công");
                    jlbTT.setForeground(new Color(11,194,106));
                    xoaTrang();
                    jTableVeModel.setRowCount(0);

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
        int index = jTableVe.getSelectedRow();
        if (index == -1) {
            jlbTT.setText("Vui lòng chọn 1 Vé trong bảng để xóa");
            jlbTT.setForeground(Color.red);
            return;
        }
        VeDao vedao = new VeDao();

        int tk = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không","Xác nhận" ,JOptionPane.YES_NO_OPTION);
        if (tk==JOptionPane.YES_OPTION)
        {
            if (vedao.DeleteVe(jTableVe.getValueAt(index,0).toString()))
            {
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                jTableVeModel.setRowCount(0);
                loadData();
            } else {
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
            }
        }
    }//GEN-LAST:event_btnXoaVeActionPerformed

    private void txtTrangThaiVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrangThaiVeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrangThaiVeActionPerformed

    private void btnThemVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVeActionPerformed
        VeModel ve = new VeModel();

        if( txtMaChuyen.getText().equals("") ||txtTienVe.getText().equals("")|| cbxLoaiGhe.getSelectedItem().toString().equals("")){
            jlbTT.setText("Bạn cần nhập đủ dữ liệu");
            jlbTT.setForeground(Color.red);
            return;
        }
        
        if(ktrKiTuDacBiet(txtTienVe.getText()) == false || ktrKiTuDacBiet(txtSoLuong.getText()) == false ){
            if(ktrKiTuDacBiet(txtTienVe.getText()) == false){
                jlbTT.setText("Số tiền không hợp lệ");
                jlbTT.setForeground(Color.red);
                return;
            }
            jlbTT.setText("Số lượng không hợp lệ");
            jlbTT.setForeground(Color.red);
            return;
        }
        else if(Integer.parseInt(txtTienVe.getText()) < 0 || Integer.parseInt(txtSoLuong.getText()) < 0 ){
            if(Integer.parseInt(txtTienVe.getText()) < 0){
                jlbTT.setText("Số tiền không hợp lệ");
                jlbTT.setForeground(Color.red);
                return;
            }
            jlbTT.setText("Số lượng không hợp lệ");
            jlbTT.setForeground(Color.red);
            return;
        } 
        else{
            ve.setMaChuyen(txtMaChuyen.getText());

            ve.setTienVe(Integer.parseInt(txtTienVe.getText()));
            ve.setLoaiGhe(cbxLoaiGhe.getSelectedItem().toString());
            ve.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
            VeDao vedao = new VeDao();
            
            if(vedao.AddVe(ve) > 0){
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                jTableVeModel.setRowCount(0);
                loadData();
            }
            else{
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
                System.out.println("asdfcxv");
            }
        }
    }//GEN-LAST:event_btnThemVeActionPerformed

    private void jTableVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVeMouseClicked
        maVe = jTableVe.getValueAt(jTableVe.getSelectedRow(), 0) + "";
        txtMaVe.setText(jTableVe.getValueAt(jTableVe.getSelectedRow(), 0) + "");
        txtMaChuyen.setText(jTableVe.getValueAt(jTableVe.getSelectedRow(), 1) + "");
        txtTienVe.setText(jTableVe.getValueAt(jTableVe.getSelectedRow(), 2) + "");
        
        cbxLoaiGhe.setSelectedItem(jTableVe.getModel().getValueAt(jTableVe.getSelectedRow(), 3) + "");
        txtSoLuong.setText(jTableVe.getValueAt(jTableVe.getSelectedRow(), 4) + "");

    }//GEN-LAST:event_jTableVeMouseClicked

    private void txtTimKiemVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemVeMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtTimKiemVeMouseClicked

    private void txtMaVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaVeMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMaVeMouseClicked

    private void txtMaChuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaChuyenMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMaChuyenMouseClicked

    private void txtTienVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienVeMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtTienVeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JButton btnSuaVe;
    private javax.swing.JButton btnThemVe;
    private javax.swing.JButton btnTimKiemVe;
    private javax.swing.JButton btnXoaVe;
    private javax.swing.JComboBox<String> cbxLoaiGhe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableVe;
    private javax.swing.JLabel jlbTT;
    private javax.swing.JTextField txtMaChuyen;
    private javax.swing.JTextField txtMaVe;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTienVe;
    private javax.swing.JTextField txtTimKiemVe;
    private javax.swing.JTextField txtTrangThaiVe;
    // End of variables declaration//GEN-END:variables
}
