package edu.mu.finalproject.hangman;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) throws IOException {
    	
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        StartPage start = new StartPage();
                        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        start.setVisible(true);
                       
                        // game loop
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}