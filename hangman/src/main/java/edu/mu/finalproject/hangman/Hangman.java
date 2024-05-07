package edu.mu.finalproject.hangman;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hangman extends JFrame {
	
	public static String getHint(String word) {
        // Generate a hint for the given word
        // This implementation returns a random letter from the word

        // Create a list of all the letters in the word
        List<Character> letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(c);
        }

        // Choose a random letter from the list
        Random random = new Random();
        int index = random.nextInt(letters.size());
        char hint = letters.get(index);

        // Return the hint as a string
        return String.valueOf(hint);
 }
}
