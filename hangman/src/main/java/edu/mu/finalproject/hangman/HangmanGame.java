package edu.mu.finalproject.hangman;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;

import edu.mu.Game.Database;
import edu.mu.Game.StartMenu;

public class HangmanGame extends JFrame {
		
	// Checks if an array contains at least one true value.
		public static boolean doesArrayContainATrue(boolean[] someBoolArray) {
			for (boolean x : someBoolArray) {
				if (x == true) {
					return true;
				}
			}
			return false;
		}
		
	// Checks if an array contains underscores
		public static boolean doesArrayContainUnderscores(char[] someCharArray) {
			for (char x : someCharArray) {
				if (x == '_') {
					return true;
				}
			}
			return false;
		}
		
	// Retrieves a random word from the database based on the selected category and level.
		public static String getRandomWord() throws IOException {
			Database database = objectMapper.readValue(new File(DATABASE_FILE), Database.class);
			String category = (String) StartMenu.categoryComboBox.getSelectedItem();
			String level = (String) StartMenu.levelComboBox.getSelectedItem();

			if (category != null && !category.equals("Select a category") && level != null
					&& !level.equals("Select a level")) {
				Map<String, List<String>> selectedCategory = database.getCategories().get(category);
				List<String> words = selectedCategory.get(level);
				return words.get(new Random().nextInt(words.size()));
			}

			return getRandomWord();
		}
		
	// Checks if a given character matches any characters in the array.
		public static boolean[] checkArrayForMatches(char[] array, char letter) {
			boolean[] result = new boolean[array.length];
			for (int i = 0; i < array.length; i++) {
				if (array[i] == letter) {
					result[i] = true;
				}
			}
			return result;
		}
		
}
