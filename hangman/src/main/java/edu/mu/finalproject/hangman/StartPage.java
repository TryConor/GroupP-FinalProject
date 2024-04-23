package edu.mu.finalproject.hangman;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StartPage extends JFrame{
	private JTextField textField;
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
        category.setEditable(true);
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
        levels.setEditable(true);
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
        levels.setSelectedItem("Select level:");
        this.setVisible(true);
	}
}
