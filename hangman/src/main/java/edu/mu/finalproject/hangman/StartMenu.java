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
	public static JLabel createClockLabel() {
        // Create a label to display the clock
        JLabel clockLabel = new JLabel();

        // Create a formatter to format the time as a string
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

        // Create a Runnable to update the label with the current time
        Runnable clockUpdater = () -> {
            while (true) {
                // Get the current time
                LocalTime time = LocalTime.now();

                // Format the time as a string
                String timeString = time.format(timeFormatter);

                // Update the label with the current time
                clockLabel.setText(timeString);

                // Sleep for 1 second
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Start a new thread to update the clock label
        Thread clockThread = new Thread(clockUpdater);
        clockThread.start();
        
        clockLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 15));

        // Return the clock label
        return clockLabel;
    }
	
}