package JPanel_Admin;

import ConnectDatabase.ConnectDB;
import Dao.KhachHangDao;
import Model.KhachHangModel;
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


public class KhachHangJPanel_Admin1 extends javax.swing.JPanel {
    
    DefaultTableModel tblKHModel = new DefaultTableModel();
    ArrayList<KhachHangModel> arr;
    int row;
    String maKH;
   
    public KhachHangJPanel_Admin1() {
        initComponents();
        loadData(); // lOAD TABLE
        loadCombobox();
        txtMAKH.setEditable(false);
    }
    
    public void loadCombobox(){
        KhachHangDao khDao = new KhachHangDao();
        arr = khDao.loadComboBox();
        
       
        for(int i = 0; i < arr.size(); i++){
            cbGT.addItem(arr.get(i).getGIOITINH());
        }
    }
    
    // Hien thi du lieu len table
    public void loadData(){
        tblKHModel = (DefaultTableModel)tblKH.getModel();
        tblKHModel.setRowCount(0);
        
        KhachHangDao khDao = new KhachHangDao();
        
        arr = khDao.docDanhMuc();
        
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
    }  
    
    public void loadData_1(String maKH){
        if(txtNhapMAKH.getText().equals("")){
            return;
        }
        else{
            maKH = txtNhapMAKH.getText();
            
            tblKHModel = (DefaultTableModel)tblKH.getModel();
            tblKHModel.setRowCount(0);
            KhachHangDao khDao = new KhachHangDao();
            arr = khDao.Search(maKH);

            String tieude[] = {"MAKH", "Tên ĐN", "Họ tên", "Ví", "Địa chỉ", "Giới tính", "Số điện thoại", "Ngày sinh"};
            tblKHModel.setColumnIdentifiers(tieude);
            
            if(arr.size() > 0){
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKH = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnThemKhachHang = new javax.swing.JButton();
        btnXoaKhachHang = new javax.swing.JButton();
        btnSuaKhachHang = new javax.swing.JButton();
        btnTimKhachHang = new javax.swing.JButton();
        txtNhapMAKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNhapHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNhapSDT = new javax.swing.JTextField();
        cbGT = new javax.swing.JComboBox<>();
        txtNhapDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtVi = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMAKH = new javax.swing.JTextField();
        jlbTT = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(766, 0));

        tblKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MAKH", "Username", "Họ và tên", "Giới tính", "Ngày sinh", "Số điện thoại", "Địa chỉ", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKH);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 194, 106));
        jLabel1.setText("KHÁCH HÀNG");
        jLabel1.setMaximumSize(new java.awt.Dimension(135, 29));
        jLabel1.setMinimumSize(new java.awt.Dimension(135, 29));
        jLabel1.setPreferredSize(new java.awt.Dimension(180, 29));

        jSeparator1.setBackground(new java.awt.Color(11, 194, 106));
        jSeparator1.setForeground(new java.awt.Color(11, 194, 106));

        btnThemKhachHang.setBackground(new java.awt.Color(11, 194, 106));
        btnThemKhachHang.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnThemKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnThemKhachHang.setText("Thêm");
        btnThemKhachHang.setToolTipText("");
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
            }
        });

        btnXoaKhachHang.setBackground(new java.awt.Color(11, 194, 106));
        btnXoaKhachHang.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnXoaKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaKhachHang.setText("Xóa");
        btnXoaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhachHangActionPerformed(evt);
            }
        });

        btnSuaKhachHang.setBackground(new java.awt.Color(11, 194, 106));
        btnSuaKhachHang.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnSuaKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaKhachHang.setText("Sửa");
        btnSuaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaKhachHangActionPerformed(evt);
            }
        });

        btnTimKhachHang.setBackground(new java.awt.Color(11, 194, 106));
        btnTimKhachHang.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnTimKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKhachHang.setText("Tìm kiếm");
        btnTimKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKhachHangActionPerformed(evt);
            }
        });

        txtNhapMAKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNhapMAKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNhapMAKHMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Họ và tên:");

        txtNhapHoTen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNhapHoTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNhapHoTenMouseClicked(evt);
            }
        });
        txtNhapHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhapHoTenActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Giới tính:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Ngày sinh:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        txtNhapSDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNhapSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNhapSDTMouseClicked(evt);
            }
        });

        cbGT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbGT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGTActionPerformed(evt);
            }
        });

        txtNhapDiaChi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNhapDiaChi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNhapDiaChiMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Số tiền:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Tên đăng nhập:");

        txtTenDangNhap.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTenDangNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenDangNhapMouseClicked(evt);
            }
        });
        txtTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDangNhapActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Trạng thái:");

        txtVi.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtVi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtViMouseClicked(evt);
            }
        });

        txtNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNgaySinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgaySinhMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("MAKH:");

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh))
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNhapMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(btnTimKhachHang))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(40, 40, 40)
                        .addComponent(txtNhapDiaChi))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtVi)
                                    .addComponent(txtNgaySinh)
                                    .addComponent(txtNhapHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnXoaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnThemKhachHang)
                                .addGap(18, 18, 18)
                                .addComponent(btnSuaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDangNhap)
                            .addComponent(cbGT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNhapSDT)
                            .addComponent(txtMAKH))))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(btnTimKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txtNhapMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSuaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThemKhachHang)
                            .addComponent(btnXoaKhachHang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNhapHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbGT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNhapSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNhapDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jlbTT, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
        );

        btnXoaKhachHang.getAccessibleContext().setAccessibleName("XÓA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void xoaTrang(){
        txtMAKH.setText("");
        txtTenDangNhap.setText("");
        txtNhapHoTen.setText("");
        txtVi.setText("");
        txtNhapDiaChi.setText("");
        cbGT.setSelectedItem("NAM");
        txtNhapSDT.setText("");
        txtNgaySinh.setText("");
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
    
    
    
    
    
    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
        KhachHangModel kh = new KhachHangModel();
        
        // XET DU LIEU CO RONG ?
        if( txtTenDangNhap.getText().equals("") || txtNhapHoTen.getText().equals("") || txtVi.getText().equals("") || txtNhapDiaChi.getText().equals("") || cbGT.getSelectedItem().toString().equals("") || txtNhapSDT.getText().equals("") || txtNgaySinh.getText().equals("")){
            jlbTT.setText("Bạn cần nhập đủ dữ liệu");
            jlbTT.setForeground(Color.red);
            return;
        }
        
        // ktr sdt
        try {
            if(ktrSDT(txtNhapSDT.getText()) == false){
                jlbTT.setText("SĐT không hợp lệ");
                jlbTT.setForeground(Color.red);
                return;
            }
        } catch (PhoneException ex) {
            System.out.println(ex.getMessage());
        }
        
        //ktr ki tu dac biet trong Vi // ngay sinh
        if(ktrKiTuDacBiet(txtVi.getText()) == false || Integer.parseInt(txtVi.getText()) < 0){
            jlbTT.setText("Số tiền không hợp lệ");
            jlbTT.setForeground(Color.red);
            return;
        }
        else if(ktrKiTuDacBiet(txtNgaySinh.getText())){
            jlbTT.setText("Ngày sinh không hợp lệ");
            jlbTT.setForeground(Color.red);
            return;
        }
        else{
            kh.setTENDN(txtTenDangNhap.getText());
            kh.setTENKH(txtNhapHoTen.getText());
            kh.setVI(Integer.parseInt(txtVi.getText()));
            kh.setDIACHI(txtNhapDiaChi.getText());
            kh.setGIOITINH(cbGT.getSelectedItem().toString());
            kh.setSDT(txtNhapSDT.getText());
            
            kh.setNGSINH(Date.valueOf(txtNgaySinh.getText()));
            

            KhachHangDao khdao = new KhachHangDao();
            if(khdao.AddKH(kh) > 0){
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                tblKHModel.setRowCount(0);
                loadData();
            }
            else{
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
            }
        }
        
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    private void btnXoaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhachHangActionPerformed
        int index = tblKH.getSelectedRow();
        if (index == -1) {
            jlbTT.setText("Vui lòng chọn 1 Khách Hàng trong bảng để xóa");
            jlbTT.setForeground(Color.red);
            return;
        }
        KhachHangDao khdao = new KhachHangDao();
        
        int tk = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không","Xác nhận" ,JOptionPane.YES_NO_OPTION);
        if (tk==JOptionPane.YES_OPTION)  
        {
            if (khdao.DeleteKH(tblKH.getValueAt(index,0).toString()))
            {
                jlbTT.setText("Thành Công");
                jlbTT.setForeground(new Color(11,194,106));
                xoaTrang();
                tblKHModel.setRowCount(0);
                loadData();
            } else {
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
            }
        }
    }//GEN-LAST:event_btnXoaKhachHangActionPerformed

    private void btnSuaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaKhachHangActionPerformed
        KhachHangModel kh = new KhachHangModel();
        
        if(txtTenDangNhap.getText().equals("") || txtNhapHoTen.getText().equals("") || txtVi.getText().equals("") || txtNhapDiaChi.getText().equals("") || cbGT.getSelectedItem().toString().equals("") || txtNhapSDT.getText().equals("") || txtNgaySinh.getText().equals("")){
            jlbTT.setText("Bạn cần nhập đủ dữ liệu");
            jlbTT.setForeground(Color.red);
            return;
        }
        
        // ktr sdt
        try {
            if(ktrSDT(txtNhapSDT.getText()) == false){
                jlbTT.setText("SĐT không hợp lệ");
                jlbTT.setForeground(Color.red);
                return;
            }
        } catch (PhoneException ex) {
            System.out.println(ex.getMessage());
        }
        
        //ktr ki tu dac biet trong Vi
        if(ktrKiTuDacBiet(txtVi.getText()) == false){
            jlbTT.setText("Số tiền không hợp lệ");
            jlbTT.setForeground(Color.red);
            return;
        }
        else{
            kh.setMAKH(txtMAKH.getText());
            kh.setTENDN(txtTenDangNhap.getText());
            kh.setTENKH(txtNhapHoTen.getText());
            kh.setVI(Integer.parseInt(txtVi.getText()));
            kh.setDIACHI(txtNhapDiaChi.getText());
            kh.setGIOITINH(cbGT.getSelectedItem().toString());
            kh.setSDT(txtNhapSDT.getText());
            
            kh.setNGSINH(Date.valueOf(txtNgaySinh.getText()));

            
            KhachHangDao khdao = new KhachHangDao();
            
            // Ktr MAKH
            boolean chk = false;
            if(kh.getMAKH().equals(maKH)){
                chk = true;
            }
            
            System.out.println(kh.getMAKH());
            System.out.println(maKH);
                   
            
            
            if(chk == true && khdao.UpdateKH(kh) > 0){
                    jlbTT.setText("Thành Công");
                    jlbTT.setForeground(new Color(11,194,106));
                    xoaTrang();
                    tblKHModel.setRowCount(0);

                    if(txtNhapMAKH.getText().equals("")){
                        loadData();
                    }
                    else{
                        loadData_1(txtNhapMAKH.getText());
                    }
            }
            else{
                jlbTT.setText("Không thành công");
                jlbTT.setForeground(Color.red);
                
                return;
            }
        }
    }//GEN-LAST:event_btnSuaKhachHangActionPerformed

    private void cbGTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGTActionPerformed

    private void txtTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhapActionPerformed

    private void txtNhapHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhapHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhapHoTenActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        xoaTrang();
        loadData();
        txtNhapMAKH.setText("");
        jlbTT.setText("");
        
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKHMouseClicked
        if(tblKH.getSelectedRow() >= 0){
            maKH = tblKH.getValueAt(tblKH.getSelectedRow(), 0) + "";
            txtMAKH.setText(tblKH.getValueAt(tblKH.getSelectedRow(), 0) + "");
            txtTenDangNhap.setText(tblKH.getValueAt(tblKH.getSelectedRow(), 1) + "");
            txtNhapHoTen.setText(tblKH.getValueAt(tblKH.getSelectedRow(), 2) + "");
            txtVi.setText(tblKH.getValueAt(tblKH.getSelectedRow(), 3) + "");
            txtNhapDiaChi.setText(tblKH.getValueAt(tblKH.getSelectedRow(), 4) + "");
            cbGT.setSelectedItem(tblKH.getModel().getValueAt(tblKH.getSelectedRow(), 5) + "");
            txtNhapSDT.setText(tblKH.getValueAt(tblKH.getSelectedRow(), 6) + "");
            txtNgaySinh.setText(tblKH.getValueAt(tblKH.getSelectedRow(), 7) + "");
        }
        jlbTT.setText("");
    }//GEN-LAST:event_tblKHMouseClicked

    private void btnTimKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKhachHangActionPerformed
        xoaTrang();
        if(txtNhapMAKH.getText().equals("")){
            jlbTT.setText("Không thành công");
            jlbTT.setForeground(Color.red);
            loadData();
        }
        else{
            jlbTT.setText("Thành Công");
            jlbTT.setForeground(new Color(11,194,106));
            loadData_1(txtNhapMAKH.getText());
        }
        
    }//GEN-LAST:event_btnTimKhachHangActionPerformed

    private void txtNhapMAKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapMAKHMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNhapMAKHMouseClicked

    private void txtMAKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMAKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMAKHActionPerformed

    private void txtMAKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMAKHMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtMAKHMouseClicked

    private void txtNhapHoTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapHoTenMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNhapHoTenMouseClicked

    private void txtNgaySinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgaySinhMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNgaySinhMouseClicked

    private void txtViMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtViMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtViMouseClicked

    private void txtNhapDiaChiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapDiaChiMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNhapDiaChiMouseClicked

    private void txtNhapSDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNhapSDTMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtNhapSDTMouseClicked

    private void txtTenDangNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenDangNhapMouseClicked
        jlbTT.setText("");
    }//GEN-LAST:event_txtTenDangNhapMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSuaKhachHang;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnTimKhachHang;
    private javax.swing.JButton btnXoaKhachHang;
    private javax.swing.JComboBox<String> cbGT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbTT;
    private javax.swing.JTable tblKH;
    private javax.swing.JTextField txtMAKH;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtNhapDiaChi;
    private javax.swing.JTextField txtNhapHoTen;
    private javax.swing.JTextField txtNhapMAKH;
    private javax.swing.JTextField txtNhapSDT;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtVi;
    // End of variables declaration//GEN-END:variables

    private static class PhoneException extends Exception {

        public PhoneException(String str) {
            super(str);
        }
    }
    
}
