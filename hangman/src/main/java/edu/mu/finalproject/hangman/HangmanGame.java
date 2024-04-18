package edu.mu.finalproject.hangman;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;

//import javax.swing.JFrame;

public class HangmanGame extends JFrame {
	
	private static final String[] WORDS = {"apple", "banana", "cherry", "date", "fig", "grape"};
    private static final int MAX_GUESSES = 6;

    private String word;
    private char[] display;
    private Set<Character> guessedLetters;
    private int incorrectGuesses;
    private int winCount;

    public HangmanGame() {
        this.word = getRandomWord();
        this.display = new char[word.length()];
        Arrays.fill(display, '_');
        this.guessedLetters = new HashSet<>();
        this.incorrectGuesses = 0;
        this.winCount =0;
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
        return incorrectGuesses == MAX_GUESSES;
    }

    public String getDisplay() {
        return new String(display);
    }

    public int getIncorrectGuesses() {
        return incorrectGuesses;
    }

    private String getRandomWord() {
        return WORDS[(int) (Math.random() * WORDS.length)];
    }
}