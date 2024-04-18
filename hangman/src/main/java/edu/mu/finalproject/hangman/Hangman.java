package edu.mu.finalproject.hangman;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Hangman extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JLabel label;
    private HangmanGame game;


    public Hangman() {
        game = new HangmanGame();
        initComponents();
    }


    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 1, 0, 0));

        label = new JLabel("Guess a letter:");
        panel.add(label);

        textField = new JTextField();
        textField.setColumns(10);
        panel.add(textField);

        JButton btnGuess = new JButton("Guess");
        btnGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (text.length() == 1) {
                    char guess = text.charAt(0);
                    game.guessLetter(guess);
                    textField.setText("");
                    label.setText(game.getDisplay());
                    if (game.isGameWon()) {
                        JOptionPane.showMessageDialog(label, "You won!");
                        dispose();
                    } else if (game.isGameLost()) {
                        JOptionPane.showMessageDialog(label, "You lost!");
                        dispose();
                    }
                    incorrectGuessesLabel.setText("Incorrect guesses: " + game.getIncorrectGuesses());
                } else {
                    label.setText("Please enter one letter.");
                }
            }
        });
        panel.add(btnGuess);

        incorrectGuessesLabel = new JLabel("Incorrect guesses: 0");
        incorrectGuessesLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        contentPane.add(incorrectGuessesLabel, BorderLayout.SOUTH);

        JLabel label3 = new JLabel("Word: " + game.getDisplay());
        label3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        contentPane.add(label3, BorderLayout.NORTH);
    }
    private JLabel incorrectGuessesLabel;

}