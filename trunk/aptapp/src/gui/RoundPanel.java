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
package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Custom JPanel with rounded corners
 * @author Anurag Sharma, the user
 */
public class RoundPanel extends JPanel {

    private JPanel insidePanel;

    /**
     * creates new object
     */
    public RoundPanel() {
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    /**
     *
     * @param insidePanel sets insidePanel within the current rounded panel
     */
    public RoundPanel(JPanel insidePanel) {
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setInsidePanel(insidePanel);
    }

    /**
     *
     * @param p the panel to put within this rounded panel
     */
    public void setInsidePanel(JPanel p) {
        insidePanel = p;
        this.add(p, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        g.setColor(new Color(200, 190, 250));
        g.fillRoundRect(0, 0, width, height, 40, 40);

    }

    /**
     * independently tests the class
     * @param args
     */
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        RoundPanel panel = new RoundPanel();

        f.add(panel);
        f.setVisible(true);
    }
}
