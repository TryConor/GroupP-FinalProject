package edu.mu.finalproject.hangman;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.swing.JButton;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class HangmanTest {
    @Test
    @Disabled("TODO: Complete this test")
    void testNewHangman() throws IOException {
        // Arrange and Act
        Hangman newman = new Hangman("janedoe", 1, 1);
        assertEquals(newman,new Hangman("janedoe", 1, 1) );

    }    
    @Test
    public void testConstructor() throws IOException {
        String username = "JohnDoe";
        int totalWins = 5;
        int totalLosses = 3;
        Hangman hangman = new Hangman(username, totalWins, totalLosses);
    }
    
    @Test
    public void testButtonClickIncorrectGuess() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
        JButton button = hangman.X;
        button.doClick();
    }
    
    @Test
    public void testGameOverWin() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
    }
    
    @Test
    public void testGameOverLoss() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
    }

@Test
    public void testCorrectGuessActionListener() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
    }

    @Test
    public void testIncorrectGuessActionListener() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
    }

    @Test
    public void testButtonDisablingActionListener() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
        // Simulate clicking the 'A' button
        // Check if 'A' button is disabled after click
        assertFalse(hangman.A.isEnabled());
    }

    @Test
    public void testGameOverWinActionListener() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
    }

    @Test
    public void testGameOverLossActionListener() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
    }

}
