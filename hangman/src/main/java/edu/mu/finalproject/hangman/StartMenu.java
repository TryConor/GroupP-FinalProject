package edu.mu.finalproject.hangman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import edu.mu.Game.Database;

public class StartMenu extends JFrame{
	
	
	void populateLevelComboBox(Database database) {
		levelComboBox.removeAllItems();
		levelComboBox.addItem("Select a level");
		// if categories index is greater than 0, it reads the selected category and
		// looks to see how many levels it has and adds them to the drop down
		if (categoryComboBox.getSelectedIndex() > 0) {
			String selectedCategory = (String) categoryComboBox.getSelectedItem();
			Map<String, List<String>> selectedCategoryMap = database.getCategories().get(selectedCategory);
			List<String> levels = new ArrayList<>(selectedCategoryMap.keySet());
			for (String level : levels) {
				levelComboBox.addItem(level);
			}
		}
	}
	
}