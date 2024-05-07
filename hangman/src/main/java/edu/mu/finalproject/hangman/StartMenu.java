package edu.mu.finalproject.hangman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.fasterxml.jackson.databind.ObjectMapper;


public class StartMenu extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;
	public static JComboBox<String> categoryComboBox;
	public static JComboBox<String> levelComboBox;

	private static final String DATABASE_FILE = "words.json";
	private static final ObjectMapper objectMapper = new ObjectMapper();

	private int totalWins = 0;
	private int totalLosses = 0;
	
	
	public StartMenu() throws IOException {

		// set title for page and dynamic size for any computer
		this.setTitle("Start");
		int width, height;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) (screenSize.getWidth());
		height = (int) (screenSize.getHeight());
		this.setSize(width, height);
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create title for the top of the page
		JLabel Title = new JLabel("Hangman Game");
		Title.setFont(new Font("Nirmala UI", Font.PLAIN, 62));

		JLabel hangmanHolder;
		hangmanHolder = new JLabel();
		
		// draws the first image in the set
		ImageIcon icon = new ImageIcon(getClass().getResource("/ImageAssets/hangman8.png"));
		Image image = icon.getImage(); // transform it
		Image newimg = image.getScaledInstance((int) (screenSize.getWidth() * .25),(int) (screenSize.getHeight() * .5), java.awt.Image.SCALE_SMOOTH);  // scale it the smooth way  
		icon = new ImageIcon(newimg);  // transform it back
		hangmanHolder.setIcon(icon);

		// add the drop down menu for categories and levels
		categoryComboBox = new JComboBox<>();
		levelComboBox = new JComboBox<>();

		// Populate categoryComboBox only once
		Database database = objectMapper.readValue(new File(DATABASE_FILE), Database.class);
		database.addObserver(this);	
		Map<String, Map<String, List<String>>> categories = database.getCategories();
		database.setCategories(categories);
		categoryComboBox.addItem("Select a category");
	
		// add category to the drop down
		for (String category : categories.keySet()) {
			categoryComboBox.addItem(category);
			update(database);
	    }

		categoryComboBox.addActionListener(e -> {
			update(database);
		});
		categoryComboBox.setEditable(false);
		
		// add levels to drop down menu
		levelComboBox.setEditable(false);

		// create text field so user can enter their name
		// will add functionality later so this can be used for user stats info
		// label the text box for user to input name
		JLabel Name = new JLabel("Name:");
		JTextField nameInput = new JTextField(10);
		
		// Create a button for the user to start playing Hangman
		JButton startButton = new JButton("Press Here to Start");

		// create constraints for GridBagLayout
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.fill = GridBagConstraints.NONE;

		// add some padding around components
		constraints.insets = new Insets(6, 6, 5, 5);

		// set the layout for the content pane
		this.getContentPane().setLayout(layout);
		
		JLabel currentDayLabel = new JLabel(getCurrentDay());
		currentDayLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 15));

		// add the title to the content pane
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;	
		this.getContentPane().add(currentDayLabel, constraints);
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		this.getContentPane().add(createClockLabel(), constraints);
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		this.getContentPane().add(Title, constraints);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		this.getContentPane().add(hangmanHolder, constraints);
		
		// add the name label and text field to the content pane
		GridBagConstraints nameInputConstraints = new GridBagConstraints();
		nameInputConstraints.insets = new Insets(0, 0, 5, 5);
		nameInputConstraints.gridx = 0;
		nameInputConstraints.gridy = 4;
		this.getContentPane().add(Name, nameInputConstraints);
		nameInputConstraints.gridx = 1;
		nameInputConstraints.gridy = 4;
		nameInputConstraints.fill = GridBagConstraints.BOTH;
		this.getContentPane().add(nameInput, nameInputConstraints);

		// add the category and level combo boxes to the content pane
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 1;
		this.getContentPane().add(categoryComboBox, constraints);
		constraints.gridx = 1;
		this.getContentPane().add(levelComboBox, constraints);

		// add start button to center of content pane
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 2;
		this.getContentPane().add(startButton, constraints);

		// center JFrame on screen
		this.setLocationRelativeTo(null);

		// make JFrame visible
		this.setVisible(true);

		startButton.addActionListener(e -> {
				try {
					// set default value so if user enters no name it defaults to "guest" or similar
					if(nameInput.getText() == null || nameInput.getText().isEmpty()) {
						nameInput.setText("Guest");
					}
					String name = nameInput.getText();
					
					new Hangman(name, totalWins, totalLosses);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				StartMenu.super.dispose();
		});
	}
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
	public static String getCurrentDay() {
        // Get the current time and day
        LocalDate date = LocalDate.now();
        String stringDate = "Date: ";
        
        // Format the time and day as a string
        String currentDay = stringDate + date;

        // Return the formatted string
        return currentDay;
    }
	
	@Override
	public void update(Database database) {
		// TODO Auto-generated method stub
		populateLevelComboBox(database);
	}
	
}