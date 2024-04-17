package edu.mu.finalproject.hangman;

import java.awt.EventQueue;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    	
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Hangman frame = new Hangman();
                        frame.setVisible(true);
                       
                        // game loop
                        
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
    }
}