package edu.mu.finalproject.hangman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				// Create and display the StartMenu
				StartMenu startmenu = new StartMenu();
				startmenu.setResizable(false);
				startmenu.setVisible(true);
				startmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});

}