
package controller;

import JPanel_Cus.LichSuJPanel_Cus;

import JPanel_Admin.ChuyenTauJPanel_Admin;
import JPanel_Admin.HoaDonJPanel_Admin;
import JPanel_Admin.KhachHangJPanel_Admin1;
import JPanel_Admin.NhanVienJPanel_Admin1;
import JPanel_Admin.TaiKhoanJPanel_Admin;
import JPanel_Admin.TauJPanel_Admin1;
import JPanel_Admin.ThongKeJPanel_Admin;
import JPanel_Admin.TuyenTauJPanel_Admin;
import JPanel_Admin.VeJPanel_Admin;
import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChuyenManHinhController_Admin {
    private JPanel root;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;
    
    public ChuyenManHinhController_Admin(JPanel jpnRoot){
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "KhachHang";
        
        jpnItem.setBackground(new Color(255, 255, 255));
        jlbItem.setBackground(new Color(255, 255, 255));
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new KhachHangJPanel_Admin1());
        root.validate();
        root.repaint();
        
    }
    
    public void setEvent(List<DanhMucBean> listItem){
        this.listItem = listItem;
        
        for (DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener{
        
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "KhachHang":
                    node = new KhachHangJPanel_Admin1();
                    break;
                case "NhanVien":
                    node = new NhanVienJPanel_Admin1();
                    break;
                case "Tau":
                    node = new TauJPanel_Admin1();
                    break;
                case "TuyenTau":
                    node = new TuyenTauJPanel_Admin();
                    break;
                case "ChuyenTau":
                    node = new ChuyenTauJPanel_Admin();
                    break;
                case "Ve":
                    node = new VeJPanel_Admin();
                    break;
                case "HoaDon":
                    node = new HoaDonJPanel_Admin();
                    break;
                case "TaiKhoan":
                    node = new TaiKhoanJPanel_Admin();
                    break;
                case "ThongKe":
                    node = new ThongKeJPanel_Admin();
                    break;
                default:
                    node = new KhachHangJPanel_Admin1();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(255, 255, 255));
            jlbItem.setBackground(new Color(255, 255, 255));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(255, 255, 255));
            jlbItem.setBackground(new Color(255, 255, 255));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
                jpnItem.setBackground(new Color(11, 194, 106));
                jlbItem.setBackground(new Color(11, 194, 106));
            }
        }
        
        private void setChangeBackground(String kind){
            for (DanhMucBean item : listItem) {
                if(item.getKind().equalsIgnoreCase(kind)){
                    item.getJlb().setBackground(new Color(255, 255, 255));
                    item.getJpn().setBackground(new Color(255, 255, 255));
                } else{
                    item.getJlb().setBackground(new Color(11, 194, 106));
                    item.getJpn().setBackground(new Color(11, 194, 106));
                }
            }
        }
        
    }
}
