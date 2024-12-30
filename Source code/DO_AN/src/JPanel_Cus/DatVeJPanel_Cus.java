
package JPanel_Cus;

import ConnectDatabase.ConnectDB;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class DatVeJPanel_Cus extends javax.swing.JPanel {
    
    DefaultTableModel tblDV = new DefaultTableModel();
    String maVe="";

    int number;

    public DatVeJPanel_Cus() {
        initComponents();
        loadData();
        loadCombobox();
        loadTien();
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
    
    public void loadCombobox(){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();

            Vector row;
            String sql = "Select TENGADI, TENGADEN from TUYENTAU";

            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                cbxGaDi.addItem(rs.getString(1));
                cbxGaDen.addItem(rs.getString(2));
            }
        } catch (Exception e) {
            e.toString();
        }
    }
    
    private void loadTien(){
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();

            Vector row;
            String sql = "Select VI from KHACHHANG KH, TAIKHOAN TK where KH.TENDN = TK.TENDN AND TK.TINHTRANG=1";

            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if(rs.next()){
                txtTien.setText(rs.getString(1));
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());    
        }
        
        
    }
    
    private void loadData(){
        try {
            txtMC.setEditable(false);
            txtGioKH.setEditable(false);
            txtGiaVe.setEditable(false);
            txtLoaiGhe.setEditable(false);

            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();

            Vector row;
            String sql = "Select V.MAVE, CT.MACHUYEN, TENGADI, TENGADEN, NGAYKHOIHANH, GIOKHOIHANH, LOAIGHE, TIENVE, SOLUONG  FROM TUYENTAU TT, CHUYENTAU CT, VE V "
                            + "where   TT.MATUYEN = CT.MATUYEN AND CT.MACHUYEN = V.MACHUYEN";

            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tblDV.setRowCount(0);
            
            
            ResultSetMetaData metaData = rs.getMetaData();
            number = metaData.getColumnCount();
            
            String tieude[] = {"Mã vé", "Mã chuyến", "Ga đi", "Ga đến", "Ngày KH", "Giờ KH", "Loại Ghế", "Giá vé", "Số lượng"};
            tblDV.setColumnIdentifiers(tieude);
            
            while(rs.next()){
                row = new Vector();
                for(int i = 1; i<=number; i++){
                    row.addElement(rs.getString(i));
                }
                tblDV.addRow(row);
                tblDatVe.setModel(tblDV);
            }
            tblDatVe.setAutoCreateRowSorter(true);
            
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
        private void loadData_1(){
        try {
            txtMC.setEditable(false);
            txtGioKH.setEditable(false);
            txtGiaVe.setEditable(false);
            txtLoaiGhe.setEditable(false);
            
            tblDV.setRowCount(0);

            
            String GaDi = cbxGaDi.getSelectedItem().toString();
            String GaDen = cbxGaDen.getSelectedItem().toString();
            

            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();

            Vector row;
            
            String sql = "set dateformat dmy \n" +
                        "Select V.MAVE, CT.MACHUYEN, TENGADI, TENGADEN, NGAYKHOIHANH, GIOKHOIHANH, LOAIGHE, TIENVE, SOLUONG\n" +
                        "FROM TUYENTAU TT, CHUYENTAU CT, VE V\n" +
                        "where TT.TENGADI=N'"+GaDi+"' AND TT.TENGADEN=N'"+GaDen+"' AND NGAYKHOIHANH='"+txtNgayKH.getText()+"' AND TT.MATUYEN = CT.MATUYEN AND CT.MACHUYEN = V.MACHUYEN      ";

            Statement st = com.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            
            
            ResultSetMetaData metaData = rs.getMetaData();
            number = metaData.getColumnCount();
            
            String tieude[] = {"Mã vé", "Mã chuyến", "Ga đi", "Ga đến", "Ngày KH", "Giờ KH", "Loại Ghế", "Giá vé", "Số lượng"};
            tblDV.setColumnIdentifiers(tieude);
            
            boolean chk = false;
            
            while(rs.next()){
                System.out.println("ádfxcv");
                chk = true;
                row = new Vector();
                for(int i = 1; i<=number; i++){
                    row.addElement(rs.getString(i));
                }
                tblDV.addRow(row);
                tblDatVe.setModel(tblDV);
            }
            
            if(chk == false){
                jlbTT.setText("Không tìm thấy");
                jlbTT.setForeground(Color.red);
                loadData();
            }
            else{
                jlbTT.setText("Thành công");
                jlbTT.setForeground(new Color(11,194,106));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNgayKH = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        cbxGaDi = new javax.swing.JComboBox<>();
        cbxGaDen = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMC = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtGioKH = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        txtGiaVe = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtLoaiGhe = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        TimKiem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatVe = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        DatVe = new javax.swing.JButton();
        jlbTT = new javax.swing.JLabel();
        Refresh = new javax.swing.JButton();
        txtTien = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setBackground(new java.awt.Color(11, 194, 106));
        jSeparator1.setForeground(new java.awt.Color(11, 194, 106));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 194, 106));
        jLabel1.setText("ĐẶT VÉ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Ga đi:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Ga đến:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Ngày khởi hành:");

        txtNgayKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgayKH.setBorder(null);
        txtNgayKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgayKHMouseClicked(evt);
            }
        });

        cbxGaDi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cbxGaDen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayKH)
                    .addComponent(jSeparator4)
                    .addComponent(cbxGaDi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxGaDen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addComponent(cbxGaDi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxGaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(165, 232, 200));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Mã chuyến:");

        txtMC.setBackground(new java.awt.Color(165, 232, 200));
        txtMC.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMC.setBorder(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Giờ khởi hành:");

        txtGioKH.setBackground(new java.awt.Color(165, 232, 200));
        txtGioKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtGioKH.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Giá vé:");

        txtGiaVe.setBackground(new java.awt.Color(165, 232, 200));
        txtGiaVe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtGiaVe.setBorder(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Loại ghế:");

        txtLoaiGhe.setBackground(new java.awt.Color(165, 232, 200));
        txtLoaiGhe.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtLoaiGhe.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(txtGiaVe)
                    .addComponent(jSeparator7)
                    .addComponent(jSeparator5)
                    .addComponent(txtMC))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator6)
                        .addComponent(txtGioKH)
                        .addComponent(jLabel8)
                        .addComponent(txtLoaiGhe))
                    .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGioKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLoaiGhe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TimKiem.setBackground(new java.awt.Color(11, 194, 106));
        TimKiem.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        TimKiem.setForeground(new java.awt.Color(255, 255, 255));
        TimKiem.setText("Tìm kiếm");
        TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemActionPerformed(evt);
            }
        });

        tblDatVe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDatVe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã vé", "Ga đi", "Ga đến", "Ngày đi", "Giờ khởi hành", "Loại ghế", "Giá vé"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDatVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatVeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatVe);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Trạng thái:");

        DatVe.setBackground(new java.awt.Color(11, 194, 106));
        DatVe.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        DatVe.setForeground(new java.awt.Color(255, 255, 255));
        DatVe.setText("Đặt vé");
        DatVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatVeActionPerformed(evt);
            }
        });

        jlbTT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Refresh.setBackground(new java.awt.Color(11, 194, 106));
        Refresh.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        Refresh.setForeground(new java.awt.Color(255, 255, 255));
        Refresh.setText("Làm mới");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        txtTien.setFont(new java.awt.Font("Tahoma", 3, 22)); // NOI18N
        txtTien.setForeground(new java.awt.Color(11, 194, 106));
        txtTien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTien.setText("jLabel10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(DatVe, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Refresh))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel1)
                        .addGap(193, 193, 193)
                        .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TimKiem)
                    .addComponent(DatVe)
                    .addComponent(Refresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(82, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DatVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatVeActionPerformed
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            // Xac nhann
            int tk = JOptionPane.showConfirmDialog(this, "Bạn có muốn thanh toán không?","Xác nhận" ,JOptionPane.YES_NO_OPTION);
            if(tk == JOptionPane.NO_OPTION)
                return;
            
            // Tinh tien
            String sql = "Select KH.MAKH, VI from KHACHHANG KH, TAIKHOAN TK where KH.TENDN = TK.TENDN AND TK.TINHTRANG=1 ";

            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            String maKH ="";
            int ViTien = 0;
            while(rs.next()){
                maKH = rs.getString(1);
                ViTien = rs.getInt(2);
            }
            int TienVe = Integer.parseInt(txtGiaVe.getText());
            

            
            int TienConLai = ViTien - TienVe;
            
            if(TienConLai >= 0){
                
                // Update Vi Tien
                String sql_1 = "Update KHACHHANG set VI=? where MAKH =?";
                
                PreparedStatement ps = com.prepareStatement(sql_1);
                ps.setString(1, TienConLai + "");
                ps.setString(2, maKH);
                
                int rs_1 = ps.executeUpdate();
                
                // Tao hoa don
                String sql_2 = "set dateformat dmy INSERT INTO HOADON(MAKH, MAVE, NGAYLAP) VALUES (?,?,?)";
                    
                PreparedStatement ps_1 = com.prepareStatement(sql_2);

                ps_1.setString(1, maKH);
                ps_1.setString(2, maVe);

                
                System.out.println(java.time.LocalDate.now());

                ps_1.setString(3, java.time.LocalDate.now() + "");

                System.out.println(maKH);                        

                int rs_2 = ps_1.executeUpdate();
                if(rs_2 > 0){
                    jlbTT.setText("Thành công");
                    jlbTT.setForeground(new Color(11,194,106));
                    loadData();
                    loadTien();
                }
                else{
                    jlbTT.setText("Thất bại");
                    jlbTT.setForeground(Color.red);
                }
            }
            else{
                jlbTT.setText("Số dư không đủ");
                jlbTT.setForeground(Color.red);
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_DatVeActionPerformed

    private void tblDatVeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatVeMouseClicked
        if(tblDatVe.getSelectedRow() >= 0){
            maVe = tblDatVe.getValueAt(tblDatVe.getSelectedRow(), 0) + "";
            txtMC.setText(tblDatVe.getValueAt(tblDatVe.getSelectedRow(), 1) + "");

            cbxGaDi.setSelectedItem(tblDatVe.getValueAt(tblDatVe.getSelectedRow(), 2) + "");
            cbxGaDen.setSelectedItem(tblDatVe.getValueAt(tblDatVe.getSelectedRow(), 3) + "");
            txtNgayKH.setText(tblDatVe.getValueAt(tblDatVe.getSelectedRow(), 4) + "");
            txtGioKH.setText(tblDatVe.getValueAt(tblDatVe.getSelectedRow(), 5) + "");
            txtLoaiGhe.setText(tblDatVe.getValueAt(tblDatVe.getSelectedRow(),6) + "");

            txtGiaVe.setText(tblDatVe.getValueAt(tblDatVe.getSelectedRow(), 7) + "");
        }
        jlbTT.setText("");
    }//GEN-LAST:event_tblDatVeMouseClicked

    private void TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemActionPerformed
        if(cbxGaDi.getSelectedItem().equals("") || cbxGaDen.getSelectedItem().equals("") || txtNgayKH.getText().equals("")){
            jlbTT.setText("Không thành công");
            jlbTT.setForeground(Color.red);
            loadData();
        }
        else{
            loadData_1();
        }
    }//GEN-LAST:event_TimKiemActionPerformed

    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        txtMC.setText("");

        cbxGaDi.setSelectedIndex(1);
        cbxGaDen.setSelectedIndex(1);
        txtNgayKH.setText("");
        txtGioKH.setText("");
        txtLoaiGhe.setText("");

        txtGiaVe.setText("");
        
        loadData();
        jlbTT.setText("");
    }//GEN-LAST:event_RefreshActionPerformed

    private void txtNgayKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgayKHMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNgayKHMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DatVe;
    private javax.swing.JButton Refresh;
    private javax.swing.JButton TimKiem;
    private javax.swing.JComboBox<String> cbxGaDen;
    private javax.swing.JComboBox<String> cbxGaDi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel jlbTT;
    private javax.swing.JTable tblDatVe;
    private javax.swing.JTextField txtGiaVe;
    private javax.swing.JTextField txtGioKH;
    private javax.swing.JTextField txtLoaiGhe;
    private javax.swing.JTextField txtMC;
    private javax.swing.JTextField txtNgayKH;
    private javax.swing.JLabel txtTien;
    // End of variables declaration//GEN-END:variables
}
