package edu.mu.finalproject.hangman;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StartPage extends JFrame{
	private JTextField nameField;
	public StartPage() {
	
		//set title for page and size
		this.setTitle("Start");
		this.setSize(800,800);
		
		//create title for the top of the page
		JLabel Title = new JLabel("Hangman Game");
        Title.setBounds(58, 34, 311, 100);
        Font startFont = new Font("Nirmala UI", Font.PLAIN, 40);
        Title.setFont(new Font("Nirmala UI", Font.PLAIN, 42));
        this.getContentPane().add(Title);
        
        //add the drop down menu for categories
        JComboBox category = new JComboBox(); 
        category.setEditable(false);
        category.setBounds(58,204,145,32);
        this.getContentPane().add(category);
        this.setSize(497, 422); 
        this.getContentPane().setLayout(null);
        
        //add each category to the drop down menu as options
        category.addItem("Majors");
        category.addItem("Places");
        category.addItem("Fictional People");
        category.addItem("Food");
        category.addItem("Companies");
        
        //default selection/what shows up before clicking category
        category.setSelectedItem("Select category:");
        
        //add the drop down menu for levels
        JComboBox levels = new JComboBox();
        levels.setBounds(224, 204, 145, 32);
        this.getContentPane().add(levels);
        levels.setEditable(false);
        this.getContentPane().add(category);
        this.setSize(497, 422); 
        this.getContentPane().setLayout(null);
        
        //add levels to drop down menu
        levels.addItem("1");
        levels.addItem("2");
        levels.addItem("3");
        levels.addItem("4");
        levels.addItem("5");
        
        //default selection/what shows up before clicking level
        //add error checking later to make sure user selected level, otherwise assign random?
        levels.setSelectedItem("Select level:");
        this.setVisible(true);
        

        
        //create text field so user can enter their name
        //will add functionality later so this can be used for user stats info
        nameField = new JTextField();
        nameField.setBounds(125, 145, 170, 20);
        this.getContentPane().add(nameField);
        nameField.setColumns(10);
        
        //set default value so if user enters no name it defaults to "guest" or similar
        
        //label the text box for user to input name
        JLabel Name = new JLabel("Name:");
        Name.setBounds(87, 148, 39, 14);
        this.getContentPane().add(Name);
        
        //Create a button for the user to start playing Hangman
        JButton startButton = new JButton("Press Here to Start");
        startButton.setBounds(125, 279, 170, 23);
        this.getContentPane().add(startButton);
        
        
        startButton.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		//make mouse listener so that when button is clicked the hangman game is started
                Hangman hangman = new Hangman();
            	hangman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	hangman.setVisible(true);
            	StartPage.super.dispose();
				
			}
        });
	}
}
