package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anurag Sharma, the user
 */
public class RoundPanel extends JPanel {

    private JPanel insidePanel;

    public RoundPanel() {
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public RoundPanel(JPanel insidePanel) {
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setInsidePanel(insidePanel);
    }

    public void setInsidePanel(JPanel p) {
        insidePanel = p;
        this.add(p, BorderLayout.CENTER);
    }

    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        g.setColor(new Color(200, 190, 250));
        g.fillRoundRect(0, 0, width, height, 40, 40);

    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        RoundPanel panel = new RoundPanel();

        f.add(panel);
        f.setVisible(true);
    }
}
