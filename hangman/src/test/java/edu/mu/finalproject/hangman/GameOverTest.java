package edu.mu.finalproject.hangman;

import static org.junit.Assert.assertEquals;


import javax.swing.JButton;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


import javax.swing.JFrame;


import org.junit.jupiter.api.Test;

class GameOverTest {
	// Test for Tabbed Pane

    @Test
    public void testTabbedPane() {
        // Create a new GameOver instance with sample data
        String gameOverStatement = "Game Over";
        int wins = 3;
        int losses = 2;
        int totalAttempts = 20;
        String username = "JohnDoe";
        String whichHangmanPath = "/hangmanImages/hangman1.png";
        String time = "00:04";
        GameOver gameOver = new GameOver(gameOverStatement, wins, losses, totalAttempts, username, whichHangmanPath,time);
        
        // Access the tabbed pane from the frame
        JTabbedPane tabbedPane = (JTabbedPane) gameOver.getContentPane().getComponent(0); // Assuming tabbedPane is the first component
        
        // Verify that there are two tabs in the tabbed pane
        assertEquals(2, tabbedPane.getTabCount());
        
        tabbedPane.getComponentAt(0);
        assertEquals("Game Over", tabbedPane.getTitleAt(0)); // Assuming the title of the first tab is "Game Over"
        // Additional assertions for the game over panel can be added here
        
        tabbedPane.getComponentAt(1);
        assertEquals("Statistics", tabbedPane.getTitleAt(1)); // Assuming the title of the second tab is "Statistics"
        // Additional assertions for the statistics panel can be added here
    }
    
 // Test for Statistics Display
    @Test
    public void testStatisticsDisplay() {
        // Create a new GameOver instance with sample statistics
        String gameOverStatement = "Game Over";
        int wins = 3;
        int losses = 2;
        int totalAttempts = 20;
        String username = "JohnDoe";
        String whichHangmanPath = "/hangmanImages/hangman1.png";
        String time = "00:04";
        GameOver gameOver = new GameOver(gameOverStatement, wins, losses, totalAttempts, username, whichHangmanPath, time);
        
        // Access the statistics panel from the tabbed pane
        JTabbedPane tabbedPane = (JTabbedPane) gameOver.getContentPane().getComponent(0); // Assuming tabbedPane is the first component
        JPanel statsPanel = (JPanel) tabbedPane.getComponentAt(1); // Assuming statistics panel is the second tab
        
        // Access the labels containing statistics information
        JLabel winsLabel = (JLabel) statsPanel.getComponent(0);
        JLabel lossesLabel = (JLabel) statsPanel.getComponent(1);
        JLabel attemptsLabel = (JLabel) statsPanel.getComponent(2);
        
        // Verify that the labels display the correct statistics
        assertEquals("Wins: " + wins, winsLabel.getText());
        assertEquals("Losses: " + losses, lossesLabel.getText());
        assertEquals("Total Attempts: " + totalAttempts, attemptsLabel.getText());
    }
    
 // Test for Username Display
    @Test
    public void testUsernameDisplay() {
        // Create a new GameOver instance with sample data
        String gameOverStatement = "Game Over";
        int wins = 3;
        int losses = 2;
        int totalAttempts = 20;
        String username = "JohnDoe";
        String whichHangmanPath = "/hangmanImages/hangman1.png";
        String time = "00:04";
        GameOver gameOver = new GameOver(gameOverStatement, wins, losses, totalAttempts, username, whichHangmanPath,time);
        
        // Access the title of the frame
        JFrame frame = gameOver;
        String title = frame.getTitle();
        
        // Verify that the title contains the username
        assertEquals("Hangman: JohnDoe", title); // Assuming the title format is "Hangman: {username}"
    }
    
 // Test for Button Labels
    @Test
    public void testButtonLabels() {
        // Create a new GameOver instance with sample data
        String gameOverStatement = "Game Over";
        int wins = 3;
        int losses = 2;
        int totalAttempts = 20;
        String username = "JohnDoe";
        String whichHangmanPath = "/hangmanImages/hangman1.png";
        String time = "00:04";
        GameOver gameOver = new GameOver(gameOverStatement, wins, losses, totalAttempts, username, whichHangmanPath, time );
        
        // Access the buttons from the GameOver instance
        JButton gameOverButton = gameOver.gameOverButton;
        JButton endGameButton = gameOver.endGameButton;
        
        // Verify that the labels of the buttons are set correctly
        assertEquals("Play Again", gameOverButton.getText());
        assertEquals("End Game", endGameButton.getText());
    }
}