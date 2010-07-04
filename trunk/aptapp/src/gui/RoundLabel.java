package gui;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

class RoundLabel extends JLabel {

    public RoundLabel(String name) {
        super(name);
        setOpaque(false);
//        setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        setBackground(Color.gray);
        setForeground(Color.blue);
    }

    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        // Paint a rounded rectangle in the background.
        g.setColor(getBackground());
        g.fillRoundRect(2, 2, 40, height, height, height);
        g.fillRect(20, 2, width - 20, height);

        // Now call the superclass behavior to paint the foreground.
        super.paintComponent(g);
    }
}
