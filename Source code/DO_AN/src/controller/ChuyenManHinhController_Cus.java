/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import JPanel_Cus.DatVeJPanel_Cus;
import JPanel_Cus.LichSuJPanel_Cus;
import JPanel_Cus.ThongTinJPanel_Cus;
import JPanel_Cus.TraCuuVeJPanel_Cus;
import bean.DanhMucBean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Nhat Minh
 */
public class ChuyenManHinhController_Cus {
    private JPanel root;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;
    
    public ChuyenManHinhController_Cus(JPanel jpnRoot){
        this.root = jpnRoot;
    }
    
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "ThongTin";
        
        jpnItem.setBackground(new Color(255, 255, 255));
        jlbItem.setBackground(new Color(255, 255, 255));
        
        root.removeAll(); //remove all component tren panel
        root.setLayout(new BorderLayout());
        root.add(new ThongTinJPanel_Cus());
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
                case "ThongTin":
                    node = new ThongTinJPanel_Cus();
                    break;
                case "TraCuu":
                    node = new TraCuuVeJPanel_Cus();
                    break;
                case "DatVe":
                    node = new DatVeJPanel_Cus();
                    break;
                case "LichSu":
                    node = new LichSuJPanel_Cus();
                    break;
                case "DangXuat":
                    node = new ThongTinJPanel_Cus();
                    break;
                default:
                    node = new LichSuJPanel_Cus();
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
