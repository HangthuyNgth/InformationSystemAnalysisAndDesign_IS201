
package JPanel_Admin;

import Dao.HoaDonDao;
import Model.HoaDonModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class HoaDonJPanel_Admin extends javax.swing.JPanel {


    DefaultTableModel tblHDModel = new DefaultTableModel();
    ArrayList<HoaDonModel> arr;
    int row;
    String maHD;
    
    public HoaDonJPanel_Admin() {
        initComponents();
        txtMaHoaDon.setEditable(false);
        loadData();
        txtThanhTien.setEditable(false);
        txtMAKH.setEditable(false);
        txtMave.setEditable(false);
        txtNgayLap.setEditable(false);
        
    }
    private boolean ktrKiTuDacBiet(String s){
 
        
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
    
    public void loadData(){
        txtMaHoaDon.setEditable(false);
        tblHDModel = (DefaultTableModel)tblHD.getModel();
        tblHDModel.setRowCount(0);
        HoaDonDao hdDao = new HoaDonDao();
        arr = hdDao.docDanhMuc();
        
        String tieude[] = {"MAHD", "MAKH", "MAVE","Ngày lập","Thành tiền"};
        tblHDModel.setColumnIdentifiers(tieude);
        
        for(int i = 0; i < arr.size(); i++){
            
            Vector<Object> vec = new Vector<>();
            
            vec.add(arr.get(i).getMAHD());
            vec.add(arr.get(i).getMAKH());
            vec.add(arr.get(i).getMAVE()) ;
            vec.add(arr.get(i).getNGAYLAP()) ;
            vec.add(arr.get(i).getTHANHTIEN()) ;
            
            tblHDModel.addRow(vec);
        }
    }  
    
    private void xoaTrang(){
        txtMaHoaDon.setText("");
        txtMAKH.setText("");
        txtMave.setText("");
        txtNgayLap.setText("");
        txtThanhTien.setText("");
    }
    public void loadData_1(int maHD){
        if(txtTimHoaDon.getText().equals("")){
            return;
        }
        else{
            maHD = Integer.parseInt(txtTimHoaDon.getText());
            
            tblHDModel = (DefaultTableModel)tblHD.getModel();
            tblHDModel.setRowCount(0);
            HoaDonDao khDao = new HoaDonDao();
            arr = khDao.Search(maHD);

            String tieude[] = {"MAHD", "MAKH", "MAVE","Ngày lập","Thành tiền"};
            tblHDModel.setColumnIdentifiers(tieude);
            
            if(arr.size() > 0){
                for(int i = 0; i < arr.size(); i++){

                    Vector<Object> vec = new Vector<>();
                    
                    vec.add(arr.get(i).getMAHD());
                    vec.add(arr.get(i).getMAKH());
                    vec.add(arr.get(i).getMAVE());
                    vec.add(arr.get(i).getNGAYLAP());
                    vec.add(arr.get(i).getTHANHTIEN());


                    tblHDModel.addRow(vec);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtMave = new javax.swing.JTextField();
        btnTimHoaDon = new javax.swing.JButton();
        txtThanhTien = new javax.swing.JTextField();
        txtTimHoaDon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtMaHoaDon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHD = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtMAKH = new javax.swing.JTextField();
        txtNgayLap = new javax.swing.JTextField();
        jlbTT = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(766, 588));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(693, 667));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Trạng thái:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Ngày lập:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 194, 106));
        jLabel1.setText("HÓA ĐƠN");
        jLabel1.setMaximumSize(new java.awt.Dimension(135, 29));
        jLabel1.setMinimumSize(new java.awt.Dimension(135, 29));
        jLabel1.setPreferredSize(new java.awt.Dimension(180, 29));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Mã vé:");

        jSeparator1.setBackground(new java.awt.Color(11, 194, 106));
        jSeparator1.setForeground(new java.awt.Color(11, 194, 106));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Thành tiền:");

        txtMave.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaveMouseClicked(evt);
            }
        });

        btnTimHoaDon.setBackground(new java.awt.Color(11, 194, 106));
        btnTimHoaDon.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnTimHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTimHoaDon.setText("Tìm kiếm");
        btnTimHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimHoaDonActionPerformed(evt);
            }
        });

        txtThanhTien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtTimHoaDon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTimHoaDon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTimHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimHoaDonMouseClicked(evt);
            }
        });
        txtTimHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimHoaDonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Mã hóa đơn:");

        txtMaHoaDon.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaHoaDonMouseClicked(evt);
            }
        });

        tblHD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "MAHD", "MAKH", "MAVE", "Ngày lập", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        tblHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHD);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Mã khách hàng:");

        txtMAKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMAKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMAKHMouseClicked(evt);
            }
        });
        txtMAKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMAKHActionPerformed(evt);
            }
        });

        txtNgayLap.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgayLap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayLapMouseClicked(evt);
            }
        });

        jlbTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnRefresh.setBackground(new java.awt.Color(11, 194, 106));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Làm mới");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtTimHoaDon)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimHoaDon))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(196, 196, 196)
                                .addComponent(btnRefresh))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                        .addComponent(txtNgayLap)))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(txtMAKH, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(29, 29, 29))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbTT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
    private void txtMAKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMAKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMAKHActionPerformed

    private void btnTimHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimHoaDonActionPerformed
        xoaTrang();
        if(txtTimHoaDon.getText().equals("")){
            jlbTT.setText("Không thành công");
            jlbTT.setForeground(Color.red);
            loadData();
        }
        else if(ktrKiTuDacBiet(txtTimHoaDon.getText()) == false){
            jlbTT.setText("Không thành công");
            jlbTT.setForeground(Color.red);
            return;
        }
        else{
            jlbTT.setText("Thành Công");
            jlbTT.setForeground(new Color(11,194,106));
            loadData_1( Integer.parseInt(txtTimHoaDon.getText()));
        }
    }//GEN-LAST:event_btnTimHoaDonActionPerformed

    private void txtTimHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimHoaDonActionPerformed

    private void tblHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHDMouseClicked
        if(tblHD.getSelectedRow() >= 0){
            maHD = tblHD.getValueAt(tblHD.getSelectedRow(), 0) + "";
            txtMaHoaDon.setText(tblHD.getValueAt(tblHD.getSelectedRow(), 0) + "");
            txtMAKH.setText(tblHD.getValueAt(tblHD.getSelectedRow(), 1) + "");
            txtMave.setText(tblHD.getValueAt(tblHD.getSelectedRow(), 2) + "");
            txtNgayLap.setText(tblHD.getValueAt(tblHD.getSelectedRow(), 3) + "");
            txtThanhTien.setText(tblHD.getValueAt(tblHD.getSelectedRow(), 4) + "");
        }
        jlbTT.setText("");
    }//GEN-LAST:event_tblHDMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        xoaTrang();
        loadData();
        txtTimHoaDon.setText("");
        jlbTT.setText("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtTimHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimHoaDonMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtTimHoaDonMouseClicked

    private void txtMaHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaHoaDonMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMaHoaDonMouseClicked

    private void txtMAKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMAKHMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMAKHMouseClicked

    private void txtNgayLapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayLapMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNgayLapMouseClicked

    private void txtMaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaveMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMaveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTimHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbTT;
    private javax.swing.JTable tblHD;
    private javax.swing.JTextField txtMAKH;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtMave;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimHoaDon;
    // End of variables declaration//GEN-END:variables
}
