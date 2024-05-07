package edu.mu.finalproject.hangman;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

	public class Hangman extends JFrame {
	
	    char[] currentWordArray;
	    char[] toBeBlankArray;
	    int incorrectGuess = 1;
	    private int wins = 0;
	    private int losses = 0;
	    int gamesWon;
	    int totalAttempts;
	    
	    String currentWord = HangmanGame.getRandomWord();
		String whichHangmanPath = "/ImageAssets/hangman" + incorrectGuess + ".png";
	
	    JPanel entireGameBoard;
	    JLabel wordToGuess;
	    JLabel hangmanHolder;
	    JButton butA, butB, butC, butD, butE, butF, butG, butH, butI, butJ,
	            butK, butL, butM, butN, butO, butP, butQ, butR, butS, butT, butU, butV,
	            butW, butX, butY, butZ;
	    
	    public Hangman(int xLocation, int yLocation) {
	        // Initialize components and set up the game board
	    		
	    		butA = new JButton("A");
	    		butB = new JButton("B");
	    		butC = new JButton("C");
	    		butD = new JButton("D");
	    		butE = new JButton("E");
	    		butF = new JButton("F");
	    		butG = new JButton("G");
	    		butH = new JButton("H");
	    		butI = new JButton("I");
	    		butJ = new JButton("J");
	    		butK = new JButton("K");
	    		butL = new JButton("L");
	    		butM = new JButton("M");
	    		butN = new JButton("N");
	    		butO = new JButton("O");
	    		butP = new JButton("P");
	    		butQ = new JButton("Q");
	    		butR = new JButton("R");
	    		butS = new JButton("S");
	    		butT = new JButton("T");
	    		butU = new JButton("U");
	    		butV = new JButton("V");
	    		butW = new JButton("W");
	    		butX = new JButton("X");
	    		butY = new JButton("Y");
	    		butZ = new JButton("Z");
	    		
	    		this.setVisible(true);//setting up the window
	    		this.setSize(800,900);
	//    		this.setPreferredSize(new Dimension(xLocation, yLocation));
	    		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    		this.setLocation(xLocation +75, yLocation -100); // +75, -100
	    		this.setResizable(true);
	    		this.setTitle("Hangman");
	    		
	    		Font fontForGuess = new Font("Algerian", Font.PLAIN, 30);
	    		String currentWord = this.currentWord;
	    		String upperCaseCurretWord = currentWord.toUpperCase();
	            currentWordArray = upperCaseCurretWord.toCharArray();
	    		
	    		//defining new JPanels
	    		entireGameBoard = new JPanel(); //field so I can call it on listener action
	    		JPanel keyboardHolder = new JPanel();
	    		JPanel gridForRows = new JPanel();
	    		JPanel topRow  = new JPanel();
	    		JPanel medRow = new JPanel();
	    		JPanel bottomRow = new JPanel();
	    		
	    		//JLabels
	    		hangmanHolder = new JLabel();
	    		wordToGuess = new JLabel();
	    		
	    		hangmanHolder.setIcon//draws the first image in the set
	    		(
	    			new ImageIcon(getClass().getResource("/ImageAssets/hangman1.png"))
	    		);
	    			
	    		//sets up layouts for JPanels
	    		gridForRows.setLayout(new GridLayout(3, 0, 3, 3)); //(rows, cols(0 means auto), xpadding, ypadding)
	    		topRow.setLayout(new FlowLayout());
	    		medRow.setLayout(new FlowLayout());
	    		bottomRow.setLayout(new FlowLayout());
	    		entireGameBoard.setLayout(new FlowLayout());
	    				
	    		//make an array that contains blanks the length of the currentWord
	    		//perhaps move this to GameLogic 
	    		toBeBlankArray = currentWord.toCharArray();
	    		for(int x = 0; x < toBeBlankArray.length; x++)
	    		{
	    			if(toBeBlankArray[x] != ' ')//ensures that spaces don't become underscores
	    			{
	    				toBeBlankArray[x] = '_';
	    			}
	    		}
	    		
	    		String wordToDisplay = new String(toBeBlankArray);//toBeBlankArray.toString(); wasn't working, so String Constructor
	    		
	    		wordToGuess.setText(wordToDisplay);
	    		wordToGuess.setFont(fontForGuess);                             
	    		
	    		//sets up keyboard
	    		topRow.add(butQ);
	    		topRow.add(butW);
	    		topRow.add(butE);
	    		topRow.add(butR);
	    		topRow.add(butT);
	    		topRow.add(butY);
	    		topRow.add(butU);
	    		topRow.add(butI);
	    		topRow.add(butO);
	    		topRow.add(butP);
	
	    		medRow.add(butA);
	    		medRow.add(butS);
	    		medRow.add(butD);
	    		medRow.add(butF);
	    		medRow.add(butG);
	    		medRow.add(butH);
	    		medRow.add(butJ);
	    		medRow.add(butK);
	    		medRow.add(butL);
	    		
	    		bottomRow.add(butZ);
	    		bottomRow.add(butX);
	    		bottomRow.add(butC);
	    		bottomRow.add(butV);
	    		bottomRow.add(butB);
	    		bottomRow.add(butN);
	    		bottomRow.add(butM);
	    		
	    		//adding all my layouts together
	    		gridForRows.add(topRow);
	    		gridForRows.add(medRow);
	    		gridForRows.add(bottomRow);
	    		keyboardHolder.add(gridForRows);
	    		entireGameBoard.add(hangmanHolder);
	    		entireGameBoard.add(wordToGuess);
	    		entireGameBoard.add(keyboardHolder);
	    		
	    		this.add(entireGameBoard);//adding everything to current obj
	
	        // Add action listeners to the buttons
	        ListenForKeyboard keyboardListener = new ListenForKeyboard();
	        butA.addActionListener(keyboardListener);
	        butB.addActionListener(keyboardListener);
	        butC.addActionListener(keyboardListener);
	        butD.addActionListener(keyboardListener);
	        butE.addActionListener(keyboardListener);
	        butF.addActionListener(keyboardListener);
	        butG.addActionListener(keyboardListener);
	        butH.addActionListener(keyboardListener);
	        butI.addActionListener(keyboardListener);
	        butJ.addActionListener(keyboardListener);
	        butK.addActionListener(keyboardListener);
	        butL.addActionListener(keyboardListener);
	        butM.addActionListener(keyboardListener);
	        butN.addActionListener(keyboardListener);
	        butO.addActionListener(keyboardListener);
	        butP.addActionListener(keyboardListener);
	        butQ.addActionListener(keyboardListener);
	        butR.addActionListener(keyboardListener);
	        butS.addActionListener(keyboardListener);
	        butT.addActionListener(keyboardListener);
	        butU.addActionListener(keyboardListener);
	        butV.addActionListener(keyboardListener);
	        butW.addActionListener(keyboardListener);
	        butX.addActionListener(keyboardListener);
	        butY.addActionListener(keyboardListener);
	        butZ.addActionListener(keyboardListener);
	    }

    private class ListenForKeyboard implements ActionListener {
    	@Override
		public void actionPerformed(ActionEvent e) //every time a Letter is tried, this is fired
		{	
			String stringToConvert = ((JButton) e.getSource()).getText();
			char charToSend = stringToConvert.charAt(0);

			//consider containing this logic inside method?
			boolean[] isArrayRight = HangmanGame.checkArrayForMatches(currentWordArray, charToSend);
			
			String upperCaseCurretWord = currentWord.toUpperCase();//could def make this more efficient|I'm repeating myself: 							
			currentWordArray = upperCaseCurretWord.toCharArray();//see GameLogic for almost exact same logic|will do later
			
			//takes the blanks and fills in the letter if guess was correct
			for(int x = 0; x < isArrayRight.length; x++)
			{
				if(isArrayRight[x] == true)
				{
					toBeBlankArray[x] = currentWordArray[x];
				}
			}
			
			String wordToShow = new String(toBeBlankArray);//assigns result of prev loop to wordToShow
			wordToGuess.setText(wordToShow); //refreshes the JPanel holding the word to guess
			if((HangmanGame.doesArrayContainATrue(isArrayRight)) == true)//if user guesses correctly
			{	
				
	            totalAttempts++;
				if((HangmanGame.doesArrayContainUnderscores(toBeBlankArray)) == false)//user has won
				{	
					wins+=1;//total game wins
					String winPhrase = "You Won! The word was \'" + currentWord + "\'.";
					int xLocation = Hangman.super.getX();
					int yLocation = Hangman.super.getY();
					
					new GameOver(xLocation, yLocation, winPhrase, wins, losses, totalAttempts);
					Hangman.super.dispose();
				}
			}
			else//fires if they guessed wrong
			{	
				totalAttempts++;
				incorrectGuess++;
				whichHangmanPath = "/ImageAssets/hangman" + incorrectGuess + ".png";
				if(incorrectGuess == 8)//player loses
				{	
					losses++;//total game losses
					String losePhrase = "You Lost! The word was \'" + currentWord + "\'.";
					int xLocation = Hangman.super.getX();
					int yLocation = Hangman.super.getY();
					
					new GameOver(xLocation, yLocation, losePhrase, wins, losses, totalAttempts);
					Hangman.super.dispose();
				}
				
				hangmanHolder.setIcon//updates image to add body part
				(
					new ImageIcon(getClass().getResource(whichHangmanPath))
				);
			}
			
			String holderForButton = ((JButton) e.getSource()).getText();//is holder redundant? I think I made stringToConvert this way
			String buttonCalled = "but" + holderForButton;//reconstruct into a button's name.
			switch(buttonCalled)//printed all this using button printer
			{//this make buttons gray out once they are clicked
			case "butA":
				butA.setEnabled(false);
				break;
			case "butB":
				butB.setEnabled(false);
				break;
			case "butC":
				butC.setEnabled(false);
				break;
			case "butD":
				butD.setEnabled(false);
				break;
			case "butE":
				butE.setEnabled(false);
				break;
			case "butF":
				butF.setEnabled(false);
				break;
			case "butG":
				butG.setEnabled(false);
				break;
			case "butH":
				butH.setEnabled(false);
				break;
			case "butI":
				butI.setEnabled(false);
				break;
			case "butJ":
				butJ.setEnabled(false);
				break;
			case "butK":
				butK.setEnabled(false);
				break;
			case "butL":
				butL.setEnabled(false);
				break;
			case "butM":
				butM.setEnabled(false);
				break;
			case "butN":
				butN.setEnabled(false);
				break;
			case "butO":
				butO.setEnabled(false);
				break;
			case "butP":
				butP.setEnabled(false);
				break;
			case "butQ":
				butQ.setEnabled(false);
				break;
			case "butR":
				butR.setEnabled(false);
				break;
			case "butS":
				butS.setEnabled(false);
				break;
			case "butT":
				butT.setEnabled(false);
				break;
			case "butU":
				butU.setEnabled(false);
				break;
			case "butV":
				butV.setEnabled(false);
				break;
			case "butW":
				butW.setEnabled(false);
				break;
			case "butX":
				butX.setEnabled(false);
				break;
			case "butY":
				butY.setEnabled(false);
				break;
			case "butZ":
				butZ.setEnabled(false);
				break;
			}
		}
	}
    
}