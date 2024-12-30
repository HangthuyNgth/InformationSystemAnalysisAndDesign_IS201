
package JPanel_Cus;

import ConnectDatabase.ConnectDB;
import java.awt.Color;
import java.sql.Connection;
import java.util.Vector;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;


public class LichSuJPanel_Cus extends javax.swing.JPanel {

    DefaultTableModel tblLSModel = new DefaultTableModel();

    int number;
    public LichSuJPanel_Cus() {
        initComponents();
        loadData();
        loadTongDong();
    }
    
    
    
    private void loadTongDong(){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();

            String sql_3 = "select count(V.MAVE)\n" +
                            "AS 'SODONG'\n" +
                            "from TUYENTAU TT, CHUYENTAU CT, VE V, HOADON HD, KHACHHANG KH, TAIKHOAN TK\n" +
                            "where TK.TINHTRANG = 1 AND KH.MAKH = HD.MAKH AND KH.TENDN = TK.TENDN AND  TT.MATUYEN = CT.MATUYEN AND CT.MACHUYEN = V.MACHUYEN AND V.MAVE = HD.MAVE";
            
            System.out.println("las");
            
            Statement st_1 = com.createStatement();
            ResultSet rs_2 = st_1.executeQuery(sql_3);
            
            System.out.println("asdfasdfasdf");
            while(rs_2.next()){
                System.out.println("asdfxcv");
                txtSL.setText(rs_2.getString(1));
            }
            
        } catch (Exception e) {
            e.toString();
        }
        
    }
    
    private void loadTongDong_1(){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            String s = txtMaVe.getText();
            
            String sql = "select count(V.MAVE)\n" +
                            "AS 'SODONG'\n" +
                            "from TUYENTAU TT, CHUYENTAU CT, VE V, HOADON HD, KHACHHANG KH, TAIKHOAN TK\n" +
                            "where V.MAVE=? AND TK.TINHTRANG = 1 AND KH.MAKH = HD.MAKH AND KH.TENDN = TK.TENDN AND  TT.MATUYEN = CT.MATUYEN AND CT.MACHUYEN = V.MACHUYEN AND V.MAVE = HD.MAVE";
            
            System.out.println("las");
            
            PreparedStatement ps = com.prepareStatement(sql);
            ps.setString(1, s);
            
            
            ResultSet rs = ps.executeQuery();
            
            System.out.println("asdfasdfasdf");
            while(rs.next()){
                System.out.println("asdfxcv");
                txtSL.setText(rs.getString(1));
            }
            
        } catch (Exception e) {
            e.toString();
        }
        
    }
    
    private void loadData(){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();

            Vector row;
            String sql = "Select V.MAVE, CT.MACHUYEN, TENGADI, TENGADEN, NGAYKHOIHANH, GIOKHOIHANH, NGAYLAP, LOAIGHE, TIENVE  FROM TUYENTAU TT, CHUYENTAU CT, VE V, HOADON HD, KHACHHANG KH, TAIKHOAN TK "
                            + "where TK.TINHTRANG = 1 AND KH.MAKH = HD.MAKH AND KH.TENDN = TK.TENDN AND  TT.MATUYEN = CT.MATUYEN AND CT.MACHUYEN = V.MACHUYEN AND V.MAVE = HD.MAVE";

            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            tblLSModel.setRowCount(0);
            
            ResultSetMetaData metaData = rs.getMetaData();
            number = metaData.getColumnCount();
            
            String tieude[] = {"Mã vé", "Mã chuyến", "Ga đi", "Ga đến", "Ngày KH", "Giờ KH", "Ngày đặt", "Loại Ghế", "Giá vé"};
            tblLSModel.setColumnIdentifiers(tieude);
            
            
            while(rs.next()){
                row = new Vector();
                for(int i = 1; i<=number; i++){
                    row.addElement(rs.getString(i));
                }
                tblLSModel.addRow(row);
                tblLichSu.setModel(tblLSModel);
            }
            
            tblLichSu.setAutoCreateRowSorter(true);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private void loadData_1(){
        try {
            boolean chk = false;
            String s = txtMaVe.getText();
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            tblLSModel.setRowCount(0);
            Vector row;
            String sql = "Select V.MAVE, CT.MACHUYEN, TENGADI, TENGADEN, NGAYKHOIHANH, GIOKHOIHANH, LOAIGHE, TIENVE  FROM TUYENTAU TT, CHUYENTAU CT, VE V, HOADON HD, KHACHHANG KH, TAIKHOAN TK "
                            + "where TK.TINHTRANG = 1 AND V.MAVE=? AND KH.MAKH = HD.MAKH AND KH.TENDN = TK.TENDN AND  TT.MATUYEN = CT.MATUYEN AND CT.MACHUYEN = V.MACHUYEN AND V.MAVE = HD.MAVE";
            
            PreparedStatement ps = com.prepareStatement(sql);
            ps.setString(1, s);
            
            
            ResultSet rs = ps.executeQuery();
            
            ResultSetMetaData metaData = rs.getMetaData();
            number = metaData.getColumnCount();
            
            String tieude[] = {"Mã vé", "Mã chuyến", "Ga đi", "Ga đến", "Ngày KH", "Giờ KH", "Loại Ghế", "Giá vé"};
            tblLSModel.setColumnIdentifiers(tieude);
            tblLichSu.setAutoCreateRowSorter(true);
            
            while(rs.next()){
                chk=true;
                row = new Vector();
                for(int i = 1; i<=number; i++){
                    row.addElement(rs.getString(i));
                }
                tblLSModel.addRow(row);
                tblLichSu.setModel(tblLSModel);
            }

            
            
            if(chk == false){
                txtTT.setText("Không tìm thấy");
                txtTT.setForeground(Color.red);
                loadData();
                loadTongDong();

            }
            else{
                txtTT.setText("Thành công");
                txtTT.setForeground(new Color(11,194,106));
                loadTongDong_1();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbLichSu = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtMaVe = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLichSu = new javax.swing.JTable();
        txtSL = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTT = new javax.swing.JLabel();
        Refresh = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jlbLichSu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlbLichSu.setForeground(new java.awt.Color(11, 194, 106));
        jlbLichSu.setText("LỊCH SỬ");
        jlbLichSu.setMaximumSize(new java.awt.Dimension(88, 29));
        jlbLichSu.setMinimumSize(new java.awt.Dimension(88, 29));

        jSeparator1.setBackground(new java.awt.Color(11, 194, 106));
        jSeparator1.setForeground(new java.awt.Color(11, 194, 106));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Số vé:");

        txtMaVe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaVe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        txtMaVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaVeMouseClicked(evt);
            }
        });
        txtMaVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaVeActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(11, 194, 106));
        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblLichSu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblLichSu);

        txtSL.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Trạng thái:");

        txtTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Refresh.setBackground(new java.awt.Color(11, 194, 106));
        Refresh.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        Refresh.setForeground(new java.awt.Color(255, 255, 255));
        Refresh.setText("Làm mới");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jlbLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaVe, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiem))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTT, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jlbLichSu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTimKiem)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMaVe, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTT)
                    .addComponent(Refresh))
                .addContainerGap(170, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaVeActionPerformed
        
        
    }//GEN-LAST:event_txtMaVeActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if(txtMaVe.getText().equals("")){
            txtTT.setText("Không thành công");
            txtTT.setForeground(Color.red);
            loadData();
            loadTongDong();
        }
        else{
            loadData_1();
        }
        
            
            
            
        
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        txtMaVe.setText("");
        txtTT.setText("");
        loadData();
        loadTongDong();
    }//GEN-LAST:event_RefreshActionPerformed

    private void txtMaVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaVeMouseClicked
        txtTT.setText("");
    }//GEN-LAST:event_txtMaVeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbLichSu;
    private javax.swing.JTable tblLichSu;
    private javax.swing.JTextField txtMaVe;
    private javax.swing.JLabel txtSL;
    private javax.swing.JLabel txtTT;
    // End of variables declaration//GEN-END:variables
}
