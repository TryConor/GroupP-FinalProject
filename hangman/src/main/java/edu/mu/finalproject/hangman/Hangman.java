package edu.mu.finalproject.hangman;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.mu.Game.GameOver;
import edu.mu.Game.Hangman;
import edu.mu.Game.HangmanGame;
import edu.mu.Game.Hangman.ListenForKeyboard;

public class Hangman extends JFrame {
	
	//Start Timer
    private void startTimer() {
        gameTimer.start();
    }
	//Stop Timer
    private void stopTimer() {
        gameTimer.stop();
    }
	
	private void initializeGameBoard() throws IOException {
        // Initialize the game board
        currentWord = HangmanGame.getRandomWord();
        currentWordArray = currentWord.toCharArray();

        // Define JPanels
        entireGameBoard = new JPanel(); // field so I can call it on listener action
        JPanel keyboardHolder = new JPanel();
        JPanel gridForRows = new JPanel();
        JPanel topMostRow = new JPanel();
        JPanel firstRow = new JPanel();
        JPanel topRow = new JPanel();
        JPanel medRow = new JPanel();
        JPanel bottomRow = new JPanel();

        // Define JLabels
        hangmanHolder = new JLabel();
        wordToGuess = new JLabel();
        
        gameTimer = new javax.swing.Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime(); // Update elapsed time
            }
        });
        
        startTimer();

        elapsedTimeInSeconds = 0;

        timerLabel = new JLabel("Time: " + elapsedTimeInSeconds + " seconds");
        
        // Initialize buttons
        A = new JButton("A");
        A.setName("A"); // Set the name of the button

        B = new JButton("B");
        B.setName("B"); // Set the name of the button

        C = new JButton("C");
        C.setName("C"); // Set the name of the button

        D = new JButton("D");
        D.setName("D"); // Set the name of the button

        E = new JButton("E");
        E.setName("E"); // Set the name of the button

        F = new JButton("F");
        F.setName("F"); // Set the name of the button

        G = new JButton("G");
        G.setName("G"); // Set the name of the button

        H = new JButton("H");
        H.setName("H"); // Set the name of the button

        I = new JButton("I");
        I.setName("I"); // Set the name of the button

        J = new JButton("J");
        J.setName("J"); // Set the name of the button

        K = new JButton("K");
        K.setName("K"); // Set the name of the button

        L = new JButton("L");
        L.setName("L"); // Set the name of the button

        M = new JButton("M");
        M.setName("M"); // Set the name of the button

        N = new JButton("N");
        N.setName("N"); // Set the name of the button

        O = new JButton("O");
        O.setName("O"); // Set the name of the button

        P = new JButton("P");
        P.setName("P"); // Set the name of the button

        Q = new JButton("Q");
        Q.setName("Q"); // Set the name of the button

        R = new JButton("R");
        R.setName("R"); // Set the name of the button

        S = new JButton("S");
        S.setName("S"); // Set the name of the button

        T = new JButton("T");
        T.setName("T"); // Set the name of the button

        U = new JButton("U");
        U.setName("U"); // Set the name of the button

        V = new JButton("V");
        V.setName("V"); // Set the name of the button

        W = new JButton("W");
        W.setName("W"); // Set the name of the button

        X = new JButton("X");
        X.setName("X"); // Set the name of the button

        Y = new JButton("Y");
        Y.setName("Y"); // Set the name of the button

        Z = new JButton("Z");
        Z.setName("Z"); // Set the name of the button
        
        //Put the buttons in an array
        buttons = new JButton[] {A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z};

        // Set up hangman image
        whichHangmanPath = "/ImageAssets/hangman" + incorrectGuess + ".png";
        hangmanHolder.setIcon(new ImageIcon(getClass().getResource(whichHangmanPath)));
        
        
        // Set up layouts
        gridForRows.setLayout(new GridLayout(5, 0, 3, 3)); // (rows, cols(0 means auto), xpadding, ypadding)
        topMostRow.setLayout(new FlowLayout());
        firstRow.setLayout(new FlowLayout());
        topRow.setLayout(new FlowLayout());
        medRow.setLayout(new FlowLayout());
        bottomRow.setLayout(new FlowLayout());
        entireGameBoard.setLayout(new FlowLayout());

        // Make an array that contains blanks the length of the currentWord
        toBeBlankArray = currentWord.toCharArray();
		for (int x = 0; x < toBeBlankArray.length; x++) {
			if (toBeBlankArray[x] != ' ')// ensures that spaces don't become underscores
			{
				toBeBlankArray[x] = '_';
			}
		}

		String wordToDisplay = new String(toBeBlankArray);
        
		// Set up and format word to guess, category display, and level display
		wordToGuess.setText(wordToDisplay);
        wordToGuess.setFont(new Font("Algerian", Font.PLAIN, 30));
        categoryDisplays.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 30));
        levelDisplays.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 30));
        timerLabel.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 30));
        timerLabel.setForeground(Color.blue);
        
        topMostRow.add(timerLabel);
        
        // Add components to the first row
        firstRow.add(categoryDisplays);
        firstRow.add(space);
        firstRow.add(levelDisplays);
        
        topRow.add(Q);
		topRow.add(W);
		topRow.add(E);
		topRow.add(R);
		topRow.add(T);
		topRow.add(Y);
		topRow.add(U);
		topRow.add(I);
		topRow.add(O);
		topRow.add(P);

		medRow.add(A);
		medRow.add(S);
		medRow.add(D);
		medRow.add(F);
		medRow.add(G);
		medRow.add(H);
		medRow.add(J);
		medRow.add(K);
		medRow.add(L);

		bottomRow.add(Z);
		bottomRow.add(X);
		bottomRow.add(C);
		bottomRow.add(V);
		bottomRow.add(B);
		bottomRow.add(N);
		bottomRow.add(M);

		
		// Add a new JButton for the help button
		JButton helpButton = new JButton("Help");

		// Add an ActionListener for the help button
		helpButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Display a hint for the current word
		        String hint = HangmanGame.getHint(currentWord);
		        JOptionPane.showMessageDialog(Hangman.this, hint, "Hint", JOptionPane.PLAIN_MESSAGE);
		    }
		});

		// Add the help button to the game board
		
        // Add components to the game board
        entireGameBoard.add(hangmanHolder);
        entireGameBoard.add(wordToGuess);
        entireGameBoard.add(keyboardHolder);
        entireGameBoard.add(helpButton);
        
        // Add layouts together
        gridForRows.add(topMostRow);
        gridForRows.add(firstRow);
        gridForRows.add(topRow);
        gridForRows.add(medRow);
        gridForRows.add(bottomRow);
        keyboardHolder.add(gridForRows);
        
        // Add action listeners to the buttons
		ListenForKeyboard keyboardListener = new ListenForKeyboard();
		A.addActionListener(keyboardListener);
		B.addActionListener(keyboardListener);
		C.addActionListener(keyboardListener);
		D.addActionListener(keyboardListener);
		E.addActionListener(keyboardListener);
		F.addActionListener(keyboardListener);
		G.addActionListener(keyboardListener);
		H.addActionListener(keyboardListener);
		I.addActionListener(keyboardListener);
		J.addActionListener(keyboardListener);
		K.addActionListener(keyboardListener);
		L.addActionListener(keyboardListener);
		M.addActionListener(keyboardListener);
		N.addActionListener(keyboardListener);
		O.addActionListener(keyboardListener);
		P.addActionListener(keyboardListener);
		Q.addActionListener(keyboardListener);
		R.addActionListener(keyboardListener);
		S.addActionListener(keyboardListener);
		T.addActionListener(keyboardListener);
		U.addActionListener(keyboardListener);
		V.addActionListener(keyboardListener);
		W.addActionListener(keyboardListener);
		X.addActionListener(keyboardListener);
		Y.addActionListener(keyboardListener);
		Z.addActionListener(keyboardListener);
    }
	
	private void setUpWindow() {
        // Set up the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();

        this.setSize(width, height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("Hangman: " + username);

        // Add the game board to the content pane
        getContentPane().add(entireGameBoard);
    }
	
	private void disableButton(String buttonName) {
    	for (JButton button : buttons) {
            if (button.getName().equals(buttonName)) {
                button.setEnabled(false);
                break;
            }
        }
    }
	
	private void checkWinLoss(boolean[] isArrayRight) {
	    // Check if the user has won or lost
		if ((HangmanGame.doesArrayContainATrue(isArrayRight)) == true)// if user guesses correctly
			{
				if ((HangmanGame.doesArrayContainUnderscores(toBeBlankArray)) == false)// user has won
				{
					stopTimer();
					String finalTime = formatTime(elapsedTimeInSeconds);
					wins += 1;// total game wins
					String winPhrase = username + ", you won in " + finalTime + "! The word was '" + currentWord + "'.";
					new GameOver(winPhrase, wins, losses, totalAttempts, username, whichHangmanPath, finalTime);
					Hangman.super.dispose();
				}
			} else// fires if they guessed wrong
			{
				incorrectGuess++;
				whichHangmanPath = "/ImageAssets/hangman" + incorrectGuess + ".png";
				if (incorrectGuess == 7)// player loses
				{
					stopTimer();
					String finalTime = formatTime(elapsedTimeInSeconds);
					losses++;// total game losses
					String losePhrase = username + ", you lost in " + finalTime + ". The word was '" + currentWord + "'.";
					new GameOver(losePhrase, wins, losses, totalAttempts, username, whichHangmanPath, finalTime);
					Hangman.super.dispose();
				}

				hangmanHolder.setIcon// updates image to add body part
				(new ImageIcon(getClass().getResource(whichHangmanPath)));
			}
	}
}
