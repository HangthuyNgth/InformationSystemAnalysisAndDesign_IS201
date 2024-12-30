
package JPanel_Cus;

import Dao.KhachHangDao;
import JPanel_Cus.ThongTinJPanel_Cus;
import Model.KhachHangModel;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class ThongTinJPanel_Cus extends javax.swing.JPanel {
    DefaultTableModel tblKHModel = new DefaultTableModel();
    ArrayList<KhachHangModel> arr;
    String maKH= "";

    public ThongTinJPanel_Cus() {
        initComponents();
        loadData();
//        loadCombobox();
    }
    
    private boolean ktrSDT(String s) throws PhoneException{
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        boolean kt = s.matches(reg);
        
        if(kt == true && s.length() == 10)
            return true;
        return false;
    }
    
    private boolean ktrKiTuDacBiet(String s){
//        //  ktr ki tu dac biet
//        Pattern p = Pattern.compile("[^A-Za-z0-9]");
//        Matcher m = p.matcher(s);
        
        // ktr so
        
        
//        Pattern pattern = Pattern.compile("\\d*");
//        Matcher matcher = pattern.matcher(s);  
        
        System.out.println("ádfcv");
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return false;
            }
            if (i + 1 == s.length()) {
                return true;
            }
        } 
        
        return  false;
    }
    
//    public void loadCombobox(){
//        KhachHangDao khDao = new KhachHangDao();
//        arr = khDao.loadComboBox();
//        
//       
//        for(int i = 0; i < arr.size(); i++){
//            cbxGioiTinh.addItem(arr.get(i).getGIOITINH());
//        }
//    }
    
    private void loadData(){
        tblKHModel.setRowCount(0);
        KhachHangDao khDao = new KhachHangDao();
        arr = khDao.layThongTin();
        
        String tieude[] = {"MAKH", "Tên ĐN", "Họ tên", "Ví", "Địa chỉ", "Giới tính", "Số điện thoại", "Ngày sinh"};
        tblKHModel.setColumnIdentifiers(tieude);
        
        for(int i = 0; i < arr.size(); i++){
            
            Vector<Object> vec = new Vector<>();
            
            vec.add(arr.get(i).getMAKH());
            vec.add(arr.get(i).getTENDN());
            vec.add(arr.get(i).getTENKH()) ;
            vec.add(arr.get(i).getVI()) ;
            vec.add(arr.get(i).getDIACHI()) ;
            vec.add(arr.get(i).getGIOITINH()) ;
            vec.add(arr.get(i).getSDT()) ;
            vec.add(arr.get(i).getNGSINH()) ;
            
            tblKHModel.addRow(vec);
        }
        
        if(tblKHModel.getRowCount()>= 0){
            maKH = tblKHModel.getValueAt(0, 0) + "";
            txtMAKH.setText( "#KH" + tblKHModel.getValueAt(0, 0) + "" );
            
            txtHoTen.setText(tblKHModel.getValueAt(0, 2) + "");
            txtViTien.setText(tblKHModel.getValueAt(0, 3) + "");
            txtDiaChi.setText(tblKHModel.getValueAt(0, 4) + "");
            
            if((tblKHModel.getValueAt(0, 5)+"").equals("Nam")){
                cbxGioiTinh.setSelectedIndex(0);
            }
            else
            {
                cbxGioiTinh.setSelectedIndex(1);
            }
            
            txtSDT.setText(tblKHModel.getValueAt(0, 6) + "");
            txtNgaySinh.setText(tblKHModel.getValueAt(0, 7) + "");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxGioiTinh = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        CapNhat = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtMAKH = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jlbTT = new javax.swing.JTextField();
        txtViTien = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(439, 0));

        jSeparator1.setBackground(new java.awt.Color(11, 194, 106));
        jSeparator1.setForeground(new java.awt.Color(11, 194, 106));
        jSeparator1.setAlignmentY(1.0F);
        jSeparator1.setDoubleBuffered(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 194, 106));
        jLabel1.setText("THÔNG TIN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Họ và tên:");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtHoTen.setBorder(null);
        txtHoTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHoTenMouseClicked(evt);
            }
        });
        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Số điện thoại:");

        txtSDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSDT.setBorder(null);
        txtSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSDTMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Ngày sinh:");

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgaySinh.setBorder(null);
        txtNgaySinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinhMouseClicked(evt);
            }
        });
        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtDiaChi.setBorder(null);
        txtDiaChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDiaChiMouseClicked(evt);
            }
        });
        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Giới tính:");

        cbxGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cbxGioiTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxGioiTinhMouseClicked(evt);
            }
        });

        CapNhat.setBackground(new java.awt.Color(11, 194, 106));
        CapNhat.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        CapNhat.setForeground(new java.awt.Color(255, 255, 255));
        CapNhat.setText("Cập nhật");
        CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Trạng thái:");

        txtMAKH.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        txtMAKH.setForeground(new java.awt.Color(11, 194, 106));
        txtMAKH.setText("MAKH");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Ví tiền:");

        jlbTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTT.setBorder(null);

        txtViTien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtViTien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtViTienMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jlbTT))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(CapNhat))
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(txtHoTen)
                    .addComponent(jSeparator2)
                    .addComponent(txtDiaChi)
                    .addComponent(jSeparator5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
                            .addComponent(jLabel3)
                            .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jSeparator3)
                            .addComponent(jLabel9)
                            .addComponent(jSeparator6)
                            .addComponent(txtViTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMAKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtViTien, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatActionPerformed

        KhachHangModel kh = new KhachHangModel();
        
        
        // ktr sdt
        try {
            if(ktrSDT(txtSDT.getText()) == false){
                jlbTT.setText("SĐT không hợp lệ");
                jlbTT.setForeground(Color.red);
                return;
            }
        } catch (PhoneException ex) {
            System.out.println(ex.getMessage());
        }
        
        if(txtMAKH.getText().equals("") || txtHoTen.getText().equals("") || txtViTien.getText().equals("") || txtDiaChi.getText().equals("") || cbxGioiTinh.getSelectedItem().toString().equals("") || txtSDT.getText().equals("") || txtNgaySinh.getText().equals("")){
            jlbTT.setText("Bạn cần nhập đủ dữ liệu");
            jlbTT.setForeground(Color.red);
            return;
        }
        else{
            KhachHangDao khdao = new KhachHangDao();
            kh.setMAKH(maKH);
            
            // lay ten dn
            String s = khdao.layTenDN(txtMAKH.getText());
            
            kh.setTENDN(s);
            kh.setTENKH(txtHoTen.getText());
            kh.setVI(Integer.parseInt(txtViTien.getText()));
            kh.setDIACHI(txtDiaChi.getText());
            kh.setGIOITINH(cbxGioiTinh.getSelectedItem().toString());
            kh.setSDT(txtSDT.getText());
            
            kh.setNGSINH(java.sql.Date.valueOf(txtNgaySinh.getText()));
            
            System.out.println(maKH);

            if(khdao.UpdateTTKH(kh) > 0){
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                loadData();
                
            }
            else{
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);           
            }
        }
    }//GEN-LAST:event_CapNhatActionPerformed

    private void txtHoTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHoTenMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtHoTenMouseClicked

    private void cbxGioiTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxGioiTinhMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_cbxGioiTinhMouseClicked

    private void txtNgaySinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinhMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNgaySinhMouseClicked

    private void txtSDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSDTMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtSDTMouseClicked

    private void txtViTienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtViTienMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtViTienMouseClicked

    private void txtDiaChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDiaChiMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtDiaChiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CapNhat;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jlbTT;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JLabel txtMAKH;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JLabel txtViTien;
    // End of variables declaration//GEN-END:variables
    
    private static class PhoneException extends Exception {

        public PhoneException(String str) {
            super(str);
        }
    }
}
