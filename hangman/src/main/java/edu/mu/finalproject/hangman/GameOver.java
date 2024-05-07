package edu.mu.finalproject.hangman;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class GameOver extends JFrame
{
    JButton gameOverButton;
    JButton endGameButton;
    GridBagConstraints gbc = new GridBagConstraints();
    JTabbedPane tabbedPane;
    int gameWins;
    int gameLosses;

    public GameOver(int xLocation, int yLocation, String gameOverStatement, int wins, int losses, int totalAttempts) {
        this.setSize(800, 300);
//    	this.setPreferredSize(new Dimension(xLocation, yLocation));
        this.setResizable(false);
        this.setVisible(true);
        this.setLocation(xLocation -150, yLocation +200); //-150,+200
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hangman");
        this.validate();

        JPanel gameOverPanel = new JPanel();
        JLabel messageToSay = new JLabel();
        gameOverButton = new JButton("Play Again");
        endGameButton = new JButton("End Game");

        Font gameOverFont = new Font("Helvetica", Font.PLAIN, 30);

        tabbedPane = new JTabbedPane();
        gameOverPanel.setLayout(new GridBagLayout());//will make pretty later when I work on options menu: gridbag
        messageToSay.setText(gameOverStatement);
        messageToSay.setFont(gameOverFont);

        ListenForButton someButtonListener = new ListenForButton();
        gameOverButton.addActionListener(someButtonListener);
        endGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	int xLocation = GameOver.super.getX();
                int yLocation = GameOver.super.getY();
                new StartPage(xLocation +75, yLocation -100);//+75,-100
                GameOver.super.dispose();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gameOverPanel.add(messageToSay, gbc);//populating panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gameOverPanel.add(gameOverButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gameOverPanel.add(endGameButton, gbc);

        JPanel statsPanel = new JPanel();

        //JLabel User = new JLabel(username);
        gameWins = gameWins + wins;
		JLabel winsLabel = new JLabel("Wins: " + gameWins);
		gameLosses = gameLosses + losses;
		JLabel lossesLabel = new JLabel("Losses: " + gameLosses);
        JLabel attemptsLabel = new JLabel("Total Attempts: " + totalAttempts);
        
        //statsPanel.add(User);
        statsPanel.add(winsLabel);
        statsPanel.add(lossesLabel);
        statsPanel.add(attemptsLabel);

        tabbedPane.addTab("Game Over", gameOverPanel);
        tabbedPane.addTab("Statistics", statsPanel);

        this.add(tabbedPane);
    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int xLocation = GameOver.super.getX();
            int yLocation = GameOver.super.getY();
            new Hangman(xLocation +75, yLocation -100);//+75, -100
            GameOver.super.dispose();
        }
    }
}