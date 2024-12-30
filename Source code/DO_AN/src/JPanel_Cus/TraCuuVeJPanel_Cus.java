
package JPanel_Cus;

import ConnectDatabase.ConnectDB;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;

public class TraCuuVeJPanel_Cus extends javax.swing.JPanel {


    public TraCuuVeJPanel_Cus() {
        initComponents();
    }
    
//    private Date ChuyenDinhDangStringSangDate(String s) throws ParseException{
//        DateFormat dateFormat = null;
//        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        
//        return dateFormat.parse(s);
//    }
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaVe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGaDi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGaDen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNgayDi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMAKH = new javax.swing.JTextField();
        cbxLoaiGhe = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        KTraVe = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jlbTT = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(11, 194, 106));
        jSeparator1.setForeground(new java.awt.Color(11, 194, 106));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 194, 106));
        jLabel1.setText("KIỂM TRA VÉ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã vé:");

        txtMaVe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaVe.setBorder(null);
        txtMaVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaVeMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Ga đi:");

        txtGaDi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtGaDi.setBorder(null);
        txtGaDi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGaDiMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Ga đến:");

        txtGaDen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtGaDen.setBorder(null);
        txtGaDen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtGaDenMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Loại ghế:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Ngày đi:");

        txtNgayDi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgayDi.setBorder(null);
        txtNgayDi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayDiMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("MAKH:");

        txtMAKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMAKH.setBorder(null);
        txtMAKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMAKHMouseClicked(evt);
            }
        });

        cbxLoaiGhe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbxLoaiGhe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "L1", "L2" }));
        cbxLoaiGhe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxLoaiGheMouseClicked(evt);
            }
        });

        KTraVe.setBackground(new java.awt.Color(11, 194, 106));
        KTraVe.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        KTraVe.setForeground(new java.awt.Color(255, 255, 255));
        KTraVe.setText("Kiểm tra vé");
        KTraVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KTraVeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Trạng thái:");

        jlbTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(KTraVe))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNgayDi, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGaDi, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaVe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7)
                                        .addComponent(txtMAKH)
                                        .addComponent(jLabel4)
                                        .addComponent(jSeparator5)
                                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtGaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbxLoaiGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxLoaiGhe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGaDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNgayDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGaDen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(7, 7, 7)
                        .addComponent(txtMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(26, 26, 26)
                .addComponent(KTraVe, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void KTraVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KTraVeActionPerformed
        SimpleDateFormat date_format = new SimpleDateFormat("dd/mm/yyyy");
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            if(txtMaVe.getText().equals("")|| cbxLoaiGhe.getSelectedItem().equals("") || txtGaDi.getText().equals("") || txtGaDen.getText().equals("") || txtNgayDi.getText().equals("") || txtMAKH.getText().equals("")){
                jlbTT.setText("Bạn cần nhập đủ dữ liệu");
                jlbTT.setForeground(Color.red);
            }else{
                PreparedStatement ps = com.prepareStatement("Set dateformat dmy\n"+
                                                            "Select * FROM TUYENTAU TT, CHUYENTAU CT, VE V, HOADON HD \n"+
                                                            "where V.MAVE=? AND LOAIGHE=? AND TENGADI=? AND TENGADEN=? AND NGAYKHOIHANH='"+txtNgayDi.getText()+"' AND HD.MAKH=? \n"+
                                                            "AND TT.MATUYEN = CT.MATUYEN AND CT.MACHUYEN = V.MACHUYEN AND V.MAVE = HD.MAVE");
                ps.setString(1, txtMaVe.getText());
                ps.setString(2, cbxLoaiGhe.getSelectedItem().toString());
                ps.setString(3, txtGaDi.getText());
                ps.setString(4, txtGaDen.getText());
                
                
          

//                ps.setDate(5, date_format.parse(txtNgayDi.getText()));

                ps.setString(5, txtMAKH.getText());
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    jlbTT.setText("Vé trùng khớp");
                    jlbTT.setForeground(new Color(11,194,106));
                    
                }else{
                    jlbTT.setText("Không tìm thấy");
                    jlbTT.setForeground(Color.red);
                }
                
                
            }
                    
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_KTraVeActionPerformed

    private void txtMaVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaVeMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMaVeMouseClicked

    private void cbxLoaiGheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxLoaiGheMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_cbxLoaiGheMouseClicked

    private void txtGaDiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGaDiMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtGaDiMouseClicked

    private void txtGaDenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtGaDenMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtGaDenMouseClicked

    private void txtNgayDiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayDiMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNgayDiMouseClicked

    private void txtMAKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMAKHMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMAKHMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton KTraVe;
    private javax.swing.JComboBox<String> cbxLoaiGhe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel jlbTT;
    private javax.swing.JTextField txtGaDen;
    private javax.swing.JTextField txtGaDi;
    private javax.swing.JTextField txtMAKH;
    private javax.swing.JTextField txtMaVe;
    private javax.swing.JTextField txtNgayDi;
    // End of variables declaration//GEN-END:variables
}
