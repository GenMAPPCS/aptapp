/*******************************************************************************
 * Copyright 2010 Alexander Pico
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package gui;
//
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.FlowLayout;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.JCheckBox;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JPanel;
//import javax.swing.ListCellRenderer;
//
///**
// *
// * @author user
// */
//public class CELListCellRenderer extends JPanel implements ListCellRenderer {
//
//    private JCheckBox checkBox;
//    private String value;
//    private Color bColor,fColor=Color.black;
//    private final Color selectedBackground=new Color(200,180,255);
//
//    public CELListCellRenderer() {
//        checkBox = new JCheckBox();
//        setLayout(new FlowLayout());
//        add(checkBox);
//        add(new JLabel("hehe"));
//        setFocusable(true);
//        addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                checkBox.setSelected(!checkBox.isSelected());
//            }
//
//        });
//    }
//
//    private void addComponents(){
//
//    }
//    public boolean isSelected() {
//        return checkBox.isSelected();
//    }
//
//    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
////        checkBox.setSelected(isSelected);
////        bColor=isSelected?new Color(200,190,250):selectedBackground;
//        this.value=(String)value;
//
////        addComponents();
//        return this;
//    }
//
////    public void paintComponent(Graphics g) {
////        g.setColor(new Color(200, 190, 250));
////        g.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
////    }
//}
