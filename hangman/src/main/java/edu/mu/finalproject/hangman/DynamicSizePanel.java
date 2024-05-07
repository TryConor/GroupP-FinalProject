package edu.mu.finalproject.hangman;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

public class DynamicSizePanel extends JPanel {
	public DynamicSizePanel() {
		
    }
	@Override
    public Dimension getPreferredSize() {
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth());
        int height = (int) (screenSize.getHeight());
        return new Dimension(width, height);
    }
}
