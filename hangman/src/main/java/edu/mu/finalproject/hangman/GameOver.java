package edu.mu.finalproject.hangman;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

//Represents the Game Over Screen in Hangman

public class GameOver extends JFrame{
	
	JButton gameOverButton;
    JButton endGameButton;
    GridBagConstraints gbc = new GridBagConstraints();
    JTabbedPane tabbedPane;
    int gameWins;
    int gameLosses;
    int totalAttemptsPlaying;
    private String username;
    
    /*
    Constructs a GameOver frame with the specified game over statement, wins, losses,
    total attempts, and username.
    */

    public GameOver(String gameOverStatement, int wins, int losses, int totalAttempts, String username, String whichHangmanPath, String finalTime) {
    	
        // Set frame size to full screen
    	int width, height;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) (screenSize.getWidth() );
        height = (int) (screenSize.getHeight() );
        
        this.username = username;
        this.setSize(width, height);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hangman: " + username);
        this.validate();
        
        
        // Initialize components
        JPanel gameOverPanel = new JPanel();
        JLabel messageToSay = new JLabel();
        gameOverButton = new JButton("Play Again");
        endGameButton = new JButton("End Game");

        //Font for message
        Font gameOverFont = new Font("Helvetica", Font.PLAIN, 30);

        // Create tabbed pane for game over and statistics
        tabbedPane = new JTabbedPane();
        gameOverPanel.setLayout(new GridBagLayout());
        messageToSay.setText(gameOverStatement);
        messageToSay.setFont(gameOverFont);
        
        // Add action listeners for buttons
        ListenForButton someButtonListener = new ListenForButton();
        gameOverButton.addActionListener(someButtonListener);
        endGameButton.addActionListener(e -> {
            	try {
            		new StartMenu();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                GameOver.super.dispose();
        });
        
        JLabel hangmanHolder;
		hangmanHolder = new JLabel();
		
		// draws the next image in the set if wrong and stays that same if right 
		ImageIcon icon = new ImageIcon(getClass().getResource(whichHangmanPath));
		Image image = icon.getImage(); // transform it
		Image newimg = image.getScaledInstance((int) (screenSize.getWidth() * .25),(int) (screenSize.getHeight() * .5), java.awt.Image.SCALE_SMOOTH);  // scale it the smooth way  
		icon = new ImageIcon(newimg);  // transform it back
		hangmanHolder.setIcon(icon);
        
        // Add components to game over panel
		gbc.gridx = 0;
        gbc.gridy = 0;
        gameOverPanel.add(hangmanHolder, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gameOverPanel.add(messageToSay, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gameOverPanel.add(gameOverButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gameOverPanel.add(endGameButton, gbc);
}

