package edu.mu.finalproject.hangman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;



public class HangmanGame extends JFrame {
    private static final List<String> WORDS = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");
    private static final Random RANDOM = new Random();
	

	
	public static boolean[] checkArrayForMatches(String currentWord, char charToTest)//generates a boolean array in response to the user's guess against the current word
	{
		String upperCaseCurretWord = currentWord.toUpperCase();
		char[] currentWordArray = upperCaseCurretWord.toCharArray();
		boolean[] returnArray = new boolean[currentWordArray.length];
		
		for(int x = 0; x < returnArray.length; x++)
		{
			char characterInArray = currentWordArray[x];
			if(characterInArray == charToTest)
			{
				returnArray[x] = true;
			}
			else 
			{
				returnArray[x] = false;
			}		
		}
 		return returnArray;
	}
	
	public static boolean doesArrayContainATrue(boolean[] someBoolArray)
	{
		for (boolean x : someBoolArray)
		{
			if(x == true) 
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean doesArrayContainUnderscores(char[] someCharArray)
	{
		for(char x : someCharArray)
		{
			if(x == '_')
			{
				return true;
			}	
		}
		return false;
	}
    public static String getRandomWord() {
        return WORDS.get(RANDOM.nextInt(WORDS.size()));
    }

    public static boolean[] checkArrayForMatches(char[] array, char letter) {
        boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == letter) {
                result[i] = true;
            }
        }
        return result;
    }
//    private String word;
//    private char[] display;
//    private Set<Character> guessedLetters;
//    private int incorrectGuesses;
//    private int winCount;
//    private int lossCount;

//    public HangmanGame() {
//        this.database = new HangmanDatabase();
//        this.word = getRandomWordForLevel(1); // Get a random word from level 1
//        this.display = new char[word.length()];
//        Arrays.fill(display, '_');
//        this.guessedLetters = new HashSet<>();
//        this.incorrectGuesses = 0;
//        this.winCount = 0;
//        this.lossCount = 0;
//    }

//    public void guessLetter(char guess) {
//        if (!guessedLetters.contains(guess)) {
//            guessedLetters.add(guess);
//            if (word.indexOf(guess) == -1) {
//                incorrectGuesses++;
//
//            } else {
//                for (int i = 0; i < word.length(); i++) {
//                    if (word.charAt(i) == guess) {
//                        display[i] = guess;
//                    }
//                }
//            }
//        }
//    }
    
//    public boolean isGameWon() {
//        winCount++;
//        return new String(display).equals(word);
//    }
//
//    public boolean isGameLost() {
//        lossCount--;
//        return incorrectGuesses == MAX_GUESSES;
//    }
//
//    public String getDisplay() {
//        return new String(display);
//    }
//
//    public int getIncorrectGuesses() {
//        return incorrectGuesses;
//    }

//    private String getRandomWordForLevel(int level) {
//        String[] words = database.getWordsForLevel("college_major", "level" + level);
//        return words[(int) (Math.random() * words.length)];
//    }
}
