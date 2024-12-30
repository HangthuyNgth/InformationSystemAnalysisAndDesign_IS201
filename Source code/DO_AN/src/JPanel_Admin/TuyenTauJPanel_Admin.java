
package JPanel_Admin;

import Dao.TuyenTauDao;
import Model.TuyenTauModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TuyenTauJPanel_Admin extends javax.swing.JPanel {

    DefaultTableModel jTableTuyenTauModel = new DefaultTableModel();
    ArrayList<TuyenTauModel> arr;
    String maTuyen = "";
    
    public TuyenTauJPanel_Admin() {
        initComponents();
        loadData();
        txtMaTuyen.setEditable(false);
        
    }

    public void loadData(){
        jTableTuyenTauModel = (DefaultTableModel)jTableTuyenTau.getModel();
        jTableTuyenTauModel.setRowCount(0);
        TuyenTauDao ttDao = new TuyenTauDao();
        arr = ttDao.docDanhMuc();
        
        String tieude[] = {"Mã Tuyến", "Tên Ga Đi", "Tên Ga Đến"};
        jTableTuyenTauModel.setColumnIdentifiers(tieude);
        
        for(int i = 0; i < arr.size(); i++){
            
            Vector<Object> vec = new Vector<>();
            
            vec.add(arr.get(i).getMaTuyen());
            vec.add(arr.get(i).getTenGaDi());
            vec.add(arr.get(i).getTenGaDen()) ;
            
            jTableTuyenTauModel.addRow(vec);
        }
    }  
    private void xoaTrang(){
        txtMaTuyen.setText("");
        txtTenGaDi.setText("");
        txtTenGaDen.setText("");
    }
    public void loadData_1(String MaTuyen){
        if(txtNhapTuyen.getText().equals("")){
            return;
        }
        else{
            MaTuyen = txtNhapTuyen.getText();
            
            jTableTuyenTauModel = (DefaultTableModel)jTableTuyenTau.getModel();
            jTableTuyenTauModel.setRowCount(0);
            TuyenTauDao ttDao = new TuyenTauDao();
            arr = ttDao.Search(MaTuyen);
            String tieude[] = {"Mã Tuyến", "Tên Ga Đi", "Tên Ga Đến"};
            jTableTuyenTauModel.setColumnIdentifiers(tieude);
            
            if(arr.size() > 0){
                for(int i = 0; i < arr.size(); i++){

                    Vector<Object> vec = new Vector<>();

                    vec.add(arr.get(i).getMaTuyen());
                    vec.add(arr.get(i).getTenGaDi());
                    vec.add(arr.get(i).getTenGaDen()) ;

                    jTableTuyenTauModel.addRow(vec);
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
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNhapTuyen = new javax.swing.JTextField();
        btnTimTuyen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTuyenTau = new javax.swing.JTable();
        btnThemTuyen = new javax.swing.JButton();
        btnXoaTuyen = new javax.swing.JButton();
        btnSuaTuyen = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaTuyen = new javax.swing.JTextField();
        txtTenGaDi = new javax.swing.JTextField();
        txtTenGaDen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jlbTT = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(766, 588));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(766, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 194, 106));
        jLabel1.setText("TUYẾN TÀU");
        jLabel1.setMaximumSize(new java.awt.Dimension(135, 29));
        jLabel1.setMinimumSize(new java.awt.Dimension(135, 29));
        jLabel1.setPreferredSize(new java.awt.Dimension(180, 29));

        jSeparator1.setBackground(new java.awt.Color(11, 194, 106));
        jSeparator1.setForeground(new java.awt.Color(11, 194, 106));

        txtNhapTuyen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNhapTuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNhapTuyenMouseClicked(evt);
            }
        });

        btnTimTuyen.setBackground(new java.awt.Color(11, 194, 106));
        btnTimTuyen.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnTimTuyen.setForeground(new java.awt.Color(255, 255, 255));
        btnTimTuyen.setText("Tìm kiếm");
        btnTimTuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimTuyenActionPerformed(evt);
            }
        });

        jTableTuyenTau.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableTuyenTau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã tuyến", "Tên ga đi", "Tên ga đến", "Thời gian dự kiến tàu đến"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTuyenTau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTuyenTauMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTuyenTau);
        if (jTableTuyenTau.getColumnModel().getColumnCount() > 0) {
            jTableTuyenTau.getColumnModel().getColumn(0).setResizable(false);
            jTableTuyenTau.getColumnModel().getColumn(1).setResizable(false);
            jTableTuyenTau.getColumnModel().getColumn(3).setResizable(false);
        }

        btnThemTuyen.setBackground(new java.awt.Color(11, 194, 106));
        btnThemTuyen.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnThemTuyen.setForeground(new java.awt.Color(255, 255, 255));
        btnThemTuyen.setText("Thêm");
        btnThemTuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTuyenActionPerformed(evt);
            }
        });

        btnXoaTuyen.setBackground(new java.awt.Color(11, 194, 106));
        btnXoaTuyen.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnXoaTuyen.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaTuyen.setText("Xóa");
        btnXoaTuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTuyenActionPerformed(evt);
            }
        });

        btnSuaTuyen.setBackground(new java.awt.Color(11, 194, 106));
        btnSuaTuyen.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnSuaTuyen.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaTuyen.setText("Sửa");
        btnSuaTuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaTuyenActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Mã tuyến:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Tên ga đi:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Tên ga đến:");

        txtMaTuyen.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtMaTuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaTuyenMouseClicked(evt);
            }
        });
        txtMaTuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaTuyenActionPerformed(evt);
            }
        });

        txtTenGaDi.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtTenGaDi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenGaDiMouseClicked(evt);
            }
        });
        txtTenGaDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenGaDiActionPerformed(evt);
            }
        });

        txtTenGaDen.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtTenGaDen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenGaDenMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Trạng thái");

        jlbTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        refresh.setBackground(new java.awt.Color(11, 194, 106));
        refresh.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setText("Làm mới");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNhapTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnTimTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2))
                                .addGap(38, 38, 38)
                                .addComponent(txtTenGaDen))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnXoaTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnThemTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(btnSuaTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtMaTuyen)
                                    .addComponent(txtTenGaDi))))))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNhapTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimTuyen))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemTuyen)
                    .addComponent(btnXoaTuyen)
                    .addComponent(btnSuaTuyen))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenGaDi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenGaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbTT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(refresh)))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemTuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTuyenActionPerformed
        TuyenTauModel tt = new TuyenTauModel();
        
        if(txtTenGaDi.getText().equals("") || txtTenGaDen.getText().equals("") ){
            jlbTT.setText("Bạn cần nhập đủ dữ liệu");
            jlbTT.setForeground(Color.red);
            return;
        }
        else{
            tt.setTenGaDi(txtTenGaDi.getText());
            tt.setTenGaDen(txtTenGaDen.getText());
            
            TuyenTauDao ttdao = new TuyenTauDao();
            if(ttdao.AddTT(tt) > 0){
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                jTableTuyenTauModel.setRowCount(0);
                loadData();
            }
            else{
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
            }
        }
    }//GEN-LAST:event_btnThemTuyenActionPerformed

    private void btnXoaTuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTuyenActionPerformed
        int index = jTableTuyenTau.getSelectedRow();
        if (index == -1) {
            jlbTT.setText("Vui lòng chọn 1 Tuyến Tàu trong bảng để xóa");
            jlbTT.setForeground(Color.red);
            return;
        }
        TuyenTauDao ttdao = new TuyenTauDao();
        
        int tk = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không","Xác nhận" ,JOptionPane.YES_NO_OPTION);
        if (tk==JOptionPane.YES_OPTION)  
        {
            if (ttdao.DeleteTT(jTableTuyenTau.getValueAt(index,0).toString()))
            {
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                jTableTuyenTauModel.setRowCount(0);
                loadData();
            } else {
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
            }
        }
    }//GEN-LAST:event_btnXoaTuyenActionPerformed

    private void txtMaTuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaTuyenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaTuyenActionPerformed

    private void txtTenGaDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenGaDiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenGaDiActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        xoaTrang();
        loadData();
        txtNhapTuyen.setText("");
        jlbTT.setText("");
    }//GEN-LAST:event_refreshActionPerformed

    private void btnSuaTuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaTuyenActionPerformed
        TuyenTauModel tt = new TuyenTauModel();
        if(txtTenGaDi.getText().equals("") || txtTenGaDen.getText().equals("")){
            jlbTT.setText("Bạn cần nhập đủ dữ liệu");
            jlbTT.setForeground(Color.red);
            return;
        }
        else{
            tt.setMaTuyen(txtMaTuyen.getText());
            tt.setTenGaDi(txtTenGaDi.getText());
            tt.setTenGaDen(txtTenGaDen.getText());
            
            TuyenTauDao ttdao = new TuyenTauDao();
            
//            // Ktr MAKH
//            boolean chk = false;
//            if(tt.getMaTuyen().equals(maTuyen)){
//                chk = true;
//            }
            
            if(ttdao.UpdateTT(tt) > 0){
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                jTableTuyenTauModel.setRowCount(0);
                if(txtNhapTuyen.getText().equals("")){
                        loadData();
                    }
                    else{
                        loadData_1(txtNhapTuyen.getText());
                    }
            }
            else{
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
                
                return;
            }
        }
    }//GEN-LAST:event_btnSuaTuyenActionPerformed

    private void jTableTuyenTauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTuyenTauMouseClicked
        if(jTableTuyenTau.getSelectedRow() >= 0){
            maTuyen = jTableTuyenTau.getValueAt(jTableTuyenTau.getSelectedRow(), 0) + "";
            txtMaTuyen.setText(jTableTuyenTau.getValueAt(jTableTuyenTau.getSelectedRow(), 0) + "");
            txtTenGaDi.setText(jTableTuyenTau.getValueAt(jTableTuyenTau.getSelectedRow(), 1) + "");
            txtTenGaDen.setText(jTableTuyenTau.getValueAt(jTableTuyenTau.getSelectedRow(), 2) + "");
        }
        jlbTT.setText("");
    }//GEN-LAST:event_jTableTuyenTauMouseClicked

    private void btnTimTuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimTuyenActionPerformed
        xoaTrang();
        if(txtNhapTuyen.getText().equals("")){
            jlbTT.setText("Không thành công");
            jlbTT.setForeground(Color.red);
            loadData();
        }
        else{
            jlbTT.setText("Thành Công");
            jlbTT.setForeground(new Color(11,194,106));
            loadData_1(txtNhapTuyen.getText());
        }
    }//GEN-LAST:event_btnTimTuyenActionPerformed

    private void txtNhapTuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapTuyenMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNhapTuyenMouseClicked

    private void txtMaTuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaTuyenMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMaTuyenMouseClicked

    private void txtTenGaDiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenGaDiMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtTenGaDiMouseClicked

    private void txtTenGaDenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenGaDenMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtTenGaDenMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSuaTuyen;
    private javax.swing.JButton btnThemTuyen;
    private javax.swing.JButton btnTimTuyen;
    private javax.swing.JButton btnXoaTuyen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableTuyenTau;
    private javax.swing.JLabel jlbTT;
    private javax.swing.JButton refresh;
    private javax.swing.JTextField txtMaTuyen;
    private javax.swing.JTextField txtNhapTuyen;
    private javax.swing.JTextField txtTenGaDen;
    private javax.swing.JTextField txtTenGaDi;
    // End of variables declaration//GEN-END:variables
}
