
package View;

import ConnectDatabase.ConnectDB;
import bean.DanhMucBean;
import controller.ChuyenManHinhController_Admin;
import controller.ChuyenManHinhController_Cus;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AdminForm extends javax.swing.JFrame {


    public AdminForm() {
        initComponents();
        setTitle("Hệ thống quản lý vé tàu điện");
        
        ChuyenManHinhController_Admin controller = new ChuyenManHinhController_Admin(jpnView);
        controller.setView(jpnKhachHang, jlbKhachHang);
        
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("KhachHang", jpnKhachHang, jlbKhachHang));
        listItem.add(new DanhMucBean("NhanVien", jpnNhanVien , jlbNhanVien));
        listItem.add(new DanhMucBean("Tau", jpnTau, jlbTau));
        listItem.add(new DanhMucBean("TuyenTau", jpnTuyenTau, jlbTuyenTau));
        listItem.add(new DanhMucBean("ChuyenTau", jpnChuyenTau, jlbChuyenTau));
        listItem.add(new DanhMucBean("Ve", jpnVe, jlbVe));
        listItem.add(new DanhMucBean("HoaDon", jpnHoaDon, jlbHoaDon));
        listItem.add(new DanhMucBean("TaiKhoan", jpnTaiKhoan, jlbTaiKhoan));
        listItem.add(new DanhMucBean("ThongKe", jpnThongKe, jlbThongKe));
        controller.setEvent(listItem);
        
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jpnKhachHang = new javax.swing.JPanel();
        jlbKhachHang = new javax.swing.JLabel();
        jpnNhanVien = new javax.swing.JPanel();
        jlbNhanVien = new javax.swing.JLabel();
        jpnTau = new javax.swing.JPanel();
        jlbTau = new javax.swing.JLabel();
        jpnTuyenTau = new javax.swing.JPanel();
        jlbTuyenTau = new javax.swing.JLabel();
        jpnChuyenTau = new javax.swing.JPanel();
        jlbChuyenTau = new javax.swing.JLabel();
        jpnVe = new javax.swing.JPanel();
        jlbVe = new javax.swing.JLabel();
        jpnHoaDon = new javax.swing.JPanel();
        jlbHoaDon = new javax.swing.JLabel();
        jpnTaiKhoan = new javax.swing.JPanel();
        jlbTaiKhoan = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        DangXuat = new javax.swing.JButton();
        jpnThongKe = new javax.swing.JPanel();
        jlbThongKe = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jpnMenu.setBackground(new java.awt.Color(11, 194, 106));

        jPanel3.setBackground(new java.awt.Color(11, 194, 106));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/7115810 (1) (1).png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BLOCKS");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MAGIC");

        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE))
        );

        jpnKhachHang.setBackground(new java.awt.Color(11, 194, 106));

        jlbKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/KhachHangIcon.png"))); // NOI18N
        jlbKhachHang.setText("  Khách hàng");
        jlbKhachHang.setMaximumSize(new java.awt.Dimension(93, 29));
        jlbKhachHang.setMinimumSize(new java.awt.Dimension(93, 29));
        jlbKhachHang.setPreferredSize(new java.awt.Dimension(93, 29));

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnKhachHangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnNhanVien.setBackground(new java.awt.Color(11, 194, 106));
        jpnNhanVien.setMinimumSize(new java.awt.Dimension(93, 29));
        jpnNhanVien.setPreferredSize(new java.awt.Dimension(93, 29));

        jlbNhanVien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/NhanVienIcon.png"))); // NOI18N
        jlbNhanVien.setText("  Nhân viên");
        jlbNhanVien.setToolTipText("");
        jlbNhanVien.setMaximumSize(new java.awt.Dimension(93, 29));
        jlbNhanVien.setMinimumSize(new java.awt.Dimension(93, 29));
        jlbNhanVien.setPreferredSize(new java.awt.Dimension(93, 29));

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNhanVienLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnTau.setBackground(new java.awt.Color(11, 194, 106));
        jpnTau.setMaximumSize(new java.awt.Dimension(93, 29));
        jpnTau.setMinimumSize(new java.awt.Dimension(93, 29));
        jpnTau.setPreferredSize(new java.awt.Dimension(93, 29));

        jlbTau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbTau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/TauIcon.png"))); // NOI18N
        jlbTau.setText("  Tàu");
        jlbTau.setMaximumSize(new java.awt.Dimension(93, 29));
        jlbTau.setMinimumSize(new java.awt.Dimension(93, 29));
        jlbTau.setPreferredSize(new java.awt.Dimension(93, 29));

        javax.swing.GroupLayout jpnTauLayout = new javax.swing.GroupLayout(jpnTau);
        jpnTau.setLayout(jpnTauLayout);
        jpnTauLayout.setHorizontalGroup(
            jpnTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTauLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbTau, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnTauLayout.setVerticalGroup(
            jpnTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTauLayout.createSequentialGroup()
                .addComponent(jlbTau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnTuyenTau.setBackground(new java.awt.Color(11, 194, 106));
        jpnTuyenTau.setMaximumSize(new java.awt.Dimension(93, 29));
        jpnTuyenTau.setMinimumSize(new java.awt.Dimension(93, 29));
        jpnTuyenTau.setPreferredSize(new java.awt.Dimension(93, 29));

        jlbTuyenTau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbTuyenTau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTuyenTau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/TuyenTauIcon.png"))); // NOI18N
        jlbTuyenTau.setText("  Tuyến tàu");
        jlbTuyenTau.setMaximumSize(new java.awt.Dimension(93, 29));
        jlbTuyenTau.setMinimumSize(new java.awt.Dimension(93, 29));
        jlbTuyenTau.setPreferredSize(new java.awt.Dimension(93, 29));

        javax.swing.GroupLayout jpnTuyenTauLayout = new javax.swing.GroupLayout(jpnTuyenTau);
        jpnTuyenTau.setLayout(jpnTuyenTauLayout);
        jpnTuyenTauLayout.setHorizontalGroup(
            jpnTuyenTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTuyenTauLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jlbTuyenTau, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnTuyenTauLayout.setVerticalGroup(
            jpnTuyenTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTuyenTauLayout.createSequentialGroup()
                .addComponent(jlbTuyenTau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnChuyenTau.setBackground(new java.awt.Color(11, 194, 106));
        jpnChuyenTau.setMaximumSize(new java.awt.Dimension(93, 29));
        jpnChuyenTau.setMinimumSize(new java.awt.Dimension(93, 29));
        jpnChuyenTau.setPreferredSize(new java.awt.Dimension(93, 29));

        jlbChuyenTau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbChuyenTau.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbChuyenTau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ChuyenTauIcon.png"))); // NOI18N
        jlbChuyenTau.setText("  Chuyến tàu");
        jlbChuyenTau.setMaximumSize(new java.awt.Dimension(93, 29));
        jlbChuyenTau.setMinimumSize(new java.awt.Dimension(93, 29));
        jlbChuyenTau.setPreferredSize(new java.awt.Dimension(93, 29));

        javax.swing.GroupLayout jpnChuyenTauLayout = new javax.swing.GroupLayout(jpnChuyenTau);
        jpnChuyenTau.setLayout(jpnChuyenTauLayout);
        jpnChuyenTauLayout.setHorizontalGroup(
            jpnChuyenTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnChuyenTauLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbChuyenTau, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnChuyenTauLayout.setVerticalGroup(
            jpnChuyenTauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnChuyenTauLayout.createSequentialGroup()
                .addComponent(jlbChuyenTau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnVe.setBackground(new java.awt.Color(11, 194, 106));
        jpnVe.setMaximumSize(new java.awt.Dimension(93, 29));
        jpnVe.setMinimumSize(new java.awt.Dimension(93, 29));
        jpnVe.setPreferredSize(new java.awt.Dimension(93, 29));

        jlbVe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbVe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/VeIcon.png"))); // NOI18N
        jlbVe.setText("  Vé");
        jlbVe.setMaximumSize(new java.awt.Dimension(93, 29));
        jlbVe.setMinimumSize(new java.awt.Dimension(93, 29));
        jlbVe.setPreferredSize(new java.awt.Dimension(93, 29));

        javax.swing.GroupLayout jpnVeLayout = new javax.swing.GroupLayout(jpnVe);
        jpnVe.setLayout(jpnVeLayout);
        jpnVeLayout.setHorizontalGroup(
            jpnVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnVeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbVe, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnVeLayout.setVerticalGroup(
            jpnVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnVeLayout.createSequentialGroup()
                .addComponent(jlbVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnHoaDon.setBackground(new java.awt.Color(11, 194, 106));
        jpnHoaDon.setMaximumSize(new java.awt.Dimension(93, 29));
        jpnHoaDon.setMinimumSize(new java.awt.Dimension(93, 29));
        jpnHoaDon.setPreferredSize(new java.awt.Dimension(93, 29));

        jlbHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/HoaDonIcon.png"))); // NOI18N
        jlbHoaDon.setText("  Hóa đơn");
        jlbHoaDon.setMaximumSize(new java.awt.Dimension(93, 29));
        jlbHoaDon.setMinimumSize(new java.awt.Dimension(93, 29));
        jlbHoaDon.setPreferredSize(new java.awt.Dimension(93, 29));

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnHoaDonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addComponent(jlbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnTaiKhoan.setBackground(new java.awt.Color(11, 194, 106));
        jpnTaiKhoan.setMaximumSize(new java.awt.Dimension(93, 29));
        jpnTaiKhoan.setMinimumSize(new java.awt.Dimension(93, 29));
        jpnTaiKhoan.setPreferredSize(new java.awt.Dimension(93, 29));

        jlbTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/TaiKhoanIcon.png"))); // NOI18N
        jlbTaiKhoan.setText("  Tài khoản");
        jlbTaiKhoan.setMaximumSize(new java.awt.Dimension(93, 29));
        jlbTaiKhoan.setMinimumSize(new java.awt.Dimension(93, 29));
        jlbTaiKhoan.setPreferredSize(new java.awt.Dimension(93, 29));

        javax.swing.GroupLayout jpnTaiKhoanLayout = new javax.swing.GroupLayout(jpnTaiKhoan);
        jpnTaiKhoan.setLayout(jpnTaiKhoanLayout);
        jpnTaiKhoanLayout.setHorizontalGroup(
            jpnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnTaiKhoanLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnTaiKhoanLayout.setVerticalGroup(
            jpnTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnTaiKhoanLayout.createSequentialGroup()
                .addComponent(jlbTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(11, 194, 106));

        DangXuat.setBackground(new java.awt.Color(11, 194, 106));
        DangXuat.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        DangXuat.setForeground(new java.awt.Color(255, 255, 255));
        DangXuat.setText("  Đăng xuất");
        DangXuat.setBorderPainted(false);
        DangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(DangXuat)
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(DangXuat)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jpnThongKe.setBackground(new java.awt.Color(11, 194, 106));
        jpnThongKe.setMaximumSize(new java.awt.Dimension(93, 29));
        jpnThongKe.setMinimumSize(new java.awt.Dimension(93, 29));
        jpnThongKe.setPreferredSize(new java.awt.Dimension(93, 29));

        jlbThongKe.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ThongKeIcon.png"))); // NOI18N
        jlbThongKe.setText("  Thống Kê");

        javax.swing.GroupLayout jpnThongKeLayout = new javax.swing.GroupLayout(jpnThongKe);
        jpnThongKe.setLayout(jpnThongKeLayout);
        jpnThongKeLayout.setHorizontalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnThongKeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnThongKeLayout.setVerticalGroup(
            jpnThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jpnTaiKhoan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addComponent(jpnHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addComponent(jpnVe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addComponent(jpnChuyenTau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addComponent(jpnTuyenTau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addComponent(jpnTau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addComponent(jpnNhanVien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                        .addComponent(jpnKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jpnThongKe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTuyenTau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnChuyenTau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnVe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jpnView.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangXuatActionPerformed
        try {
            ConnectDB a = new ConnectDB();
            Connection com = a.getConnection();
            
            
            String sql = "Update TAIKHOAN set TINHTRANG=0 where TINHTRANG=1";
                                      
            Statement st = com.createStatement();
            int rs = st.executeUpdate(sql);
            
            this.setVisible(false);
            new LoginForm();
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_DangXuatActionPerformed


//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DangXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlbChuyenTau;
    private javax.swing.JLabel jlbHoaDon;
    private javax.swing.JLabel jlbKhachHang;
    private javax.swing.JLabel jlbNhanVien;
    private javax.swing.JLabel jlbTaiKhoan;
    private javax.swing.JLabel jlbTau;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JLabel jlbTuyenTau;
    private javax.swing.JLabel jlbVe;
    private javax.swing.JPanel jpnChuyenTau;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnTaiKhoan;
    private javax.swing.JPanel jpnTau;
    private javax.swing.JPanel jpnThongKe;
    private javax.swing.JPanel jpnTuyenTau;
    private javax.swing.JPanel jpnVe;
    private javax.swing.JPanel jpnView;
    // End of variables declaration//GEN-END:variables
}
