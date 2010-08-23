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


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JLabel;

/**
 * Custom JLabel with rounded corners
 * @author Anurag Sharma
 */
class RoundLabel extends JLabel {

    public RoundLabel(String name) {
        super(name);
        setOpaque(false);
//        setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        setBackground(Color.gray);
        setForeground(Color.blue);
    }

    @Override
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
