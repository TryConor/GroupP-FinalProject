package edu.mu.finalproject.hangman;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
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


        
	        // Create and populate statistics panel
	        JPanel statsPanel = new JPanel();
	        gameWins = gameWins + wins;
			JLabel winsLabel = new JLabel("Wins: " + gameWins + "  ");
			gameLosses = gameLosses + losses;
			JLabel lossesLabel = new JLabel("Losses: " + gameLosses + "  ");
	        JLabel attemptsLabel = new JLabel("Total Attempts: " + totalAttempts + " ");
	        JLabel time = new JLabel("Time Elapsed: " + finalTime);
	        
	        // format the wins, losses, attempts
	        winsLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 30));
	        lossesLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 30));
	        attemptsLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 30));
	        time.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 30));
	
	        // Add labels to statistics panel
	        statsPanel.add(winsLabel);
	        statsPanel.add(lossesLabel);
	        statsPanel.add(attemptsLabel);
	        statsPanel.add(time);
	        
	        // Add game over and statistics panels to tabbed pane
	        tabbedPane.addTab("Game Over", gameOverPanel);
	        tabbedPane.addTab("Statistics", statsPanel);
	    
	        // Add tabbed pane to frame
	        this.add(tabbedPane);
    
}



	// ActionListener implementation for the buttons in the game over screen.
	private class ListenForButton implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        try {
	        	new Hangman(username, gameWins, gameLosses);
			} catch (IOException e1) {
				e1.printStackTrace();
			}//+75, -100
	        GameOver.super.dispose();
	    }
	}
}
    
    
    

