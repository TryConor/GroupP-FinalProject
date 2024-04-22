package edu.mu.finalproject.hangman;
import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HangmanGame extends JFrame {
    private HangmanDatabase database;

    private static final int MAX_GUESSES = 6;

    private String word;
    private char[] display;
    private Set<Character> guessedLetters;
    private int incorrectGuesses;
    private int winCount;
    private int lossCount;

    public HangmanGame() {
        this.database = new HangmanDatabase();
        this.word = getRandomWordForLevel(1); // Get a random word from level 1
        this.display = new char[word.length()];
        Arrays.fill(display, '_');
        this.guessedLetters = new HashSet<>();
        this.incorrectGuesses = 0;
        this.winCount = 0;
        this.lossCount = 0;
    }

    public void guessLetter(char guess) {
        if (!guessedLetters.contains(guess)) {
            guessedLetters.add(guess);
            if (word.indexOf(guess) == -1) {
                incorrectGuesses++;

            } else {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        display[i] = guess;
                    }
                }
            }
        }
    }

    public boolean isGameWon() {
        winCount++;
        return new String(display).equals(word);
    }

    public boolean isGameLost() {
        lossCount--;
        return incorrectGuesses == MAX_GUESSES;
    }

    public String getDisplay() {
        return new String(display);
    }

    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    private String getRandomWordForLevel(int level) {
        String[] words = database.getWordsForLevel("college_major", "level" + level);
        return words[(int) (Math.random() * words.length)];
    }
}
