package edu.mu.finalproject.hangman;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class StartPage extends JFrame
{
	private JTextField nameField;
	public StartPage(int xLocation, int yLocation) {

	//set title for page and size
	this.setTitle("start");
    this.setPreferredSize(new Dimension(xLocation, yLocation));
//	this.setLocation(xLocation, yLocation);
	
	JComboBox<String> category = new JComboBox<String>(); 
	//create title for the top of the page
	JLabel Title = new JLabel("Hangman Game");
	        Title.setBounds(58, 34, 350, 100);
	        //Font startFont = new Font("Nirmala UI", Font.PLAIN, 40);
	        Title.setFont(new Font("Nirmala UI", Font.PLAIN, 42));
	        this.getContentPane().add(Title, BorderLayout.CENTER);
	        
	        //add the drop down menu for categories
	        
	        category.setEditable(false);
	        category.setBounds(58,204,155,32);
	        this.getContentPane().add(category);
	        this.setSize(497, 422); 
	        this.getContentPane().setLayout(null);
	        
	        //add each category to the drop down menu as options
	        category.addItem("Select category:");
	        category.addItem("Majors");
	        category.addItem("Places");
	        category.addItem("Fictional People");
	        category.addItem("Food");
	        category.addItem("Companies");
	        
	        //default selection/what shows up before clicking category
	        category.setSelectedItem("Select category:");
	        
	        //add the drop down menu for levels
	        JComboBox<String> levels = new JComboBox<String>();
	        levels.setBounds(224, 204, 150, 32);
	        this.getContentPane().add(levels, BorderLayout.CENTER);
	        levels.setEditable(false);
	        this.getContentPane().add(category, BorderLayout.CENTER);
	        this.setSize(497, 422); 
	        this.getContentPane().setLayout(null);
	        
	        //add levels to drop down menu
	        levels.addItem("Select level:"); 
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
	        this.getContentPane().add(nameField, BorderLayout.CENTER);
	        nameField.setColumns(10);
	        
	        //set default value so if user enters no name it defaults to "guest" or similar
	        
	        //label the text box for user to input name
	        JLabel Name = new JLabel("Name:");
	        Name.setBounds(87, 148, 50, 14);
	        this.getContentPane().add(Name, BorderLayout.CENTER);
	        
	        //Create a button for the user to start playing Hangman
	        JButton startButton = new JButton("Press Here to Start");
	        startButton.setBounds(125, 279, 170, 23);
	        this.getContentPane().add(startButton, BorderLayout.CENTER);
	        
	    	startButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	int xLocation = StartPage.super.getX();
	                int yLocation = StartPage.super.getY();
	                new Hangman(xLocation , yLocation );
	                StartPage.super.dispose();
	            }
	        });
	        
	}
}
//	//static OptionsMenu someOptionsMenu;
//	private static final long serialVersionUID = 1L;//suggested code by eclipse. 
//	
//	JButton playGameButton, optionsButton;
//	private JLabel mainLabel;
//	JPanel levelPanel = new JPanel();
//	String[] patternExamples = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5"};
//	JLabel Username = new JLabel("Username: ");
//	JTextField userField = new JTextField(20);
//	JLabel labelLevel = new JLabel("Select a Level:");
//    JComboBox<String> patternList = new JComboBox<>(patternExamples);
//    
//	public StartMenu(int xLocation, int yLocation)
//	{
//		this.setSize(800,700);//doesn't really matter because this.pack, but changes spawn location
//		this.setLocation(xLocation, yLocation);
//		this.setVisible(true);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setTitle("Hangman");
//		this.setResizable(false);
//		
//		playGameButton = new JButton("Start Game");
//		optionsButton = new JButton("Options");
//		mainLabel = new JLabel();
//		
//		
//        
//        levelPanel.setLayout(new GridLayout(4, 1));
//        levelPanel.add(labelLevel);
//        levelPanel.add(patternList);
//        levelPanel.add(Username);
//        levelPanel.add(userField);
//        patternList.setEditable(false);
//       
//		
//		mainLabel.setIcon
//		(
//			new ImageIcon(getClass().getResource("/ImageAssets/hangman8.png"))
//		);
//		
//		JPanel somePanel = new JPanel();
//		somePanel.setLayout(new BorderLayout());
//		somePanel.add(playGameButton, BorderLayout.WEST);
//		somePanel.add(optionsButton, BorderLayout.EAST);
//		somePanel.add(mainLabel, BorderLayout.CENTER);
//		somePanel.add(levelPanel, BorderLayout.SOUTH);
//
//       
//		
//		this.add(somePanel);
//		this.pack();
//		this.validate();//perhaps unnecessary
//		
//		ListenForButton someButtonListener = new ListenForButton();
//		
//		playGameButton.addActionListener(someButtonListener);
//		optionsButton.addActionListener(someButtonListener);
//	}
//	
//	private class ListenForButton implements ActionListener {
//		@Override
//		public void actionPerformed(ActionEvent e) 
//		{
//			if(e.getSource() == playGameButton)
//			{	
//				JTextField userField = (JTextField) levelPanel.getComponent(4);
//				int xLocation = StartMenu.super.getX();
//				int yLocation = StartMenu.super.getY();
//				new Hangman(xLocation, yLocation);
//				StartMenu.super.dispose();
//				
//			}
//			else if(e.getSource() == optionsButton)
//			{
//				int xLocation = StartMenu.super.getX();
//				int yLocation = StartMenu.super.getY();
//				//someOptionsMenu = new OptionsMenu(xLocation - 28, yLocation - 200);
//				StartMenu.super.dispose();
//			}
//		}
//	}
//	
////	public static OptionsMenu getOptionsMenuRef()
////	{
////		return someOptionsMenu;
////	}
//}