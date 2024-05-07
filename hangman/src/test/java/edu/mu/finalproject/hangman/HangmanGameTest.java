package edu.mu.finalproject.hangman;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JButton;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class HangmanGameTest {
    /**
     * Method under test: {@link Hangman#Hangman(String, int, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testNewHangman() throws IOException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.awt.HeadlessException
        //       at java.desktop/java.awt.GraphicsEnvironment.checkHeadless(GraphicsEnvironment.java:166)
        //       at java.desktop/java.awt.Window.<init>(Window.java:553)
        //       at java.desktop/java.awt.Frame.<init>(Frame.java:428)
        //       at java.desktop/java.awt.Frame.<init>(Frame.java:393)
        //       at java.desktop/javax.swing.JFrame.<init>(JFrame.java:180)
        //       at edu.mu.Game.Hangman.<init>(Hangman.java:48)
        //   See https://diff.blue/R013 to resolve this issue.

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
//        assertEquals(username, hangman.username);
//        assertEquals(totalWins, hangman.wins);
//        assertEquals(totalLosses, hangman.losses);
    }
    
//    @Test
//    public void testButtonClickCorrectGuess() throws IOException {
//        Hangman hangman = new Hangman("JohnDoe", 0, 0);
//        JButton button = hangman.butA;
//        button.doClick();
//        assertTrue(hangman.toBeBlankArray[0] == 'A');
//        assertEquals("A", hangman.wordToGuess.getText());
//    }
//    
    @Test
    public void testButtonClickIncorrectGuess() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
        JButton button = hangman.X;
        button.doClick();
//        assertEquals(2, hangman.incorrectGuess);
//        assertEquals("/ImageAssets/hangman2.png", hangman.whichHangmanPath);
    }
    
    @Test
    public void testGameOverWin() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
//        hangman.currentWord = "TEST";
//        hangman.toBeBlankArray = "TEST".toCharArray();
//        hangman.wordToGuess.setText("TEST");
        
       // hangman.actionPerformed(new ActionEvent(hangman.butT, 0, ""));
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
//        hangman.currentWord = "TEST";
//       hangman.toBeBlankArray = "TEST".toCharArray();
//        hangman.wordToGuess.setText("TEST");
//        
//        hangman.actionPerformed(new ActionEvent(hangman.T, 0, ""));
//        assertEquals(1, hangman.wins);
//       assertEquals("JohnDoe, you won! The word was 'TEST'.", hangman.getGameOverMessage());
    }
    
    @Test
    public void testGameOverLoss() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
//        hangman.currentWord = "TEST";
//        hangman.toBeBlankArray = "TEST".toCharArray();
//        hangman.incorrectGuess = 7;
//        hangman.wordToGuess.setText("TEST");
//       // hangman.actionPerformed(new ActionEvent(hangman.butX, 0, ""));
//        assertEquals(1, hangman.losses);
        //assertEquals("JohnDoe, you lost! The word was 'TEST'.", hangman.getGameOverMessage());
    }

@Test
    public void testCorrectGuessActionListener() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
//        hangman.currentWord = "TEST";
//        hangman.toBeBlankArray = "____".toCharArray(); // To simulate initial blank word
//        hangman.wordToGuess.setText("____"); // To simulate initial display
//
//        // Simulate clicking the 'T' button
//        //hangman.butT.doClick();
//        //hangman.actionPerformed(new ActionEvent(hangman.butT, 0, ""));
//
//        // Check if 'T' has been revealed in the word
//        assertEquals("T___", new String(hangman.toBeBlankArray));
//        assertEquals("T___", hangman.wordToGuess.getText());
    }

    @Test
    public void testIncorrectGuessActionListener() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
//        hangman.currentWord = "TEST";
//        hangman.toBeBlankArray = "____".toCharArray(); // To simulate initial blank word
//        hangman.wordToGuess.setText("____"); // To simulate initial display
//
//        // Simulate clicking the 'X' button (incorrect guess)
//       // hangman.actionPerformed(new ActionEvent(hangman.butX, 0, ""));
//
//        // Check if hangman image path has updated and incorrect guess count incremented
//        assertEquals("/ImageAssets/hangman2.png", hangman.whichHangmanPath);
//        assertEquals(2, hangman.incorrectGuess);
    }

    @Test
    public void testButtonDisablingActionListener() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);

        // Simulate clicking the 'A' button
      //  hangman.actionPerformed(new ActionEvent(hangman.butA, 0, ""));
        //hangman.butA.doClick();

        // Check if 'A' button is disabled after click
        assertFalse(hangman.A.isEnabled());
    }

    @Test
    public void testGameOverWinActionListener() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
//        hangman.currentWord = "TEST";
//        hangman.toBeBlankArray = "TEST".toCharArray(); // Simulate word completely guessed

        // Simulate clicking the 'T' button to reveal the word
        //hangman.actionPerformed(new ActionEvent(hangman.butT, 0, ""));

        // Check if game over message is set correctly for win
       // assertEquals("JohnDoe, you won! The word was 'TEST'.", hangman.getGameOverMessage());
    }

    @Test
    public void testGameOverLossActionListener() throws IOException {
        Hangman hangman = new Hangman("JohnDoe", 0, 0);
//        hangman.incorrectGuess = 7; // Simulate 7 incorrect guesses

        // Simulate clicking the 'X' button (incorrect guess)
        //hangman.actionPerformed(new ActionEvent(hangman.butX, 0, ""));

        // Check if game over message is set correctly for loss
        //assertEquals("JohnDoe, you lost! The word was 'TEST'.", hangman.getGameOverMessage());
    }

}