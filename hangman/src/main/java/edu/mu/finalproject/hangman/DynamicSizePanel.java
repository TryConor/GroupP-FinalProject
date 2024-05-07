package edu.mu.finalproject.hangman;


import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

//A JPanel that dynamically adjusts its preferred size to fill the entire screen.

public class DynamicSizePanel extends JPanel {

 DynamicSizePanel() {
	 super(new BorderLayout());
    }
 
 /* 
 Overrides the getPreferredSize method to return the dimensions of the screen.
 The preferred size of the panel, equal to the screen dimensions.
  */
 
	@Override
    public Dimension getPreferredSize() {
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth());
        int height = (int) (screenSize.getHeight());
        return new Dimension(width, height);
    }
}
