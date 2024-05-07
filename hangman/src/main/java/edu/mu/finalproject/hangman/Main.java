package edu.mu.finalproject.hangman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws IOException {
//		EventQueue.invokeLater(new Runnable() {
//		    public void run() {
//		    	try {	
//			    	
//                    StartMenu startmenu = new StartMenu(width, height);
//                    startmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                    startmenu.setResizable(true);
//                    startmenu.pack();
//                    startmenu.setLocationRelativeTo(startmenu);
//                    startmenu.setVisible(true);
//		    	} catch (Exception e) {
//		    		// TODO Auto-generated catch block
//		    		e.printStackTrace();
//		    	}
//		    }
//		});
//			
//    }
//}
    	int width, height;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) (screenSize.getWidth() );
        height = (int) (screenSize.getHeight() );

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StartPage startmenu = new StartPage(width, height);
                    startmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    startmenu.setResizable(true);
                    startmenu.add(new DynamicSizePanel(), BorderLayout.CENTER);
                    startmenu.pack();
                    startmenu.setLocationRelativeTo(startmenu);
                    startmenu.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}