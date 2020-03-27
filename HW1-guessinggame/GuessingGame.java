    /*
      THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
      CODE WRITTEN BY OTHER STUDENTS. Lydia Feng
    */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	int numGuesses;
	private static Scanner scanner = new Scanner(System.in);
	ArrayList<Integer> possibleGuesses;
	int currentGuess;

	public GuessingGame() {
		numGuesses = 0;
		possibleGuesses = new ArrayList<Integer>();
		Integer i = 1000;
		while (i <= 9999) {
			possibleGuesses.add(i);
			i++;
		}
		currentGuess = 0;
	}

	public int myGuessIs() {
		numGuesses++;
		int myguess = 0;
		if (possibleGuesses.size() == 0) {
			return -1;
		}
		int anyNumber = (int)(Math.random() * (possibleGuesses.size()));
		myguess = possibleGuesses.get(anyNumber);
		currentGuess = myguess;
		return myguess;
	}
	
	public int totalNumGuesses() { 
		return numGuesses;
	}
 
	public void updateMyGuess(int nmatches) {

		int onesPlace = currentGuess % 10;
		currentGuess = currentGuess / 10;

		int tensPlace = currentGuess % 10;
		currentGuess = currentGuess / 10;

		int hundredsPlace = currentGuess % 10;
		currentGuess = currentGuess / 10;

		int thousandsPlace = currentGuess % 10;


		if (nmatches == 0) {
			int i = 0;
			while (i < possibleGuesses.size()) {
				if (possibleGuesses.get(i) % 10 == onesPlace) {
					possibleGuesses.remove(i);
				} else if ((possibleGuesses.get(i) / 10) % 10 == tensPlace) {
					possibleGuesses.remove(i);
				} else if ((possibleGuesses.get(i) / 100) % 10 == hundredsPlace) {
					possibleGuesses.remove(i);
				} else if (possibleGuesses.get(i) / 1000 == thousandsPlace) {
					possibleGuesses.remove(i);
				} else {
					i++;
				}
			}
		} 


		if (nmatches == 1) {
			int i = 0;
			while (i < possibleGuesses.size()) {
				if ((possibleGuesses.get(i) % 10 != onesPlace) && ((possibleGuesses.get(i) / 10) % 10 != tensPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace)) {
					possibleGuesses.remove(i);
				} else if ((possibleGuesses.get(i) % 10 == onesPlace) && ((possibleGuesses.get(i) / 10) % 10 == tensPlace)) {
					possibleGuesses.remove(i);
				} else if ((possibleGuesses.get(i) % 10 == onesPlace) && ((possibleGuesses.get(i) / 100) % 10 == hundredsPlace)) {
					possibleGuesses.remove(i);
				} else if ((possibleGuesses.get(i) % 10 == onesPlace) && ((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace)) {
					possibleGuesses.remove(i);
				} else if (((possibleGuesses.get(i) / 10) % 10 == tensPlace) && ((possibleGuesses.get(i) / 100) % 10 == hundredsPlace)) {
					possibleGuesses.remove(i);
				} else if (((possibleGuesses.get(i) / 10) % 10 == tensPlace) && ((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace)) {
					possibleGuesses.remove(i);
				} else if (((possibleGuesses.get(i) / 100) % 10 == hundredsPlace) && ((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace)) {
					possibleGuesses.remove(i);
				} else {
					i++;
				}	 
			}
		}


		if (nmatches == 2) {
			int i = 0;
			 while (i < possibleGuesses.size()) {
			 	if ((possibleGuesses.get(i) % 10 != onesPlace) && ((possibleGuesses.get(i) / 10) % 10 != tensPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace)) {
					possibleGuesses.remove(i);
				} else if (((possibleGuesses.get(i) % 10 == onesPlace) && ((possibleGuesses.get(i) / 10) % 10 != tensPlace))
					&& ((possibleGuesses.get(i) % 10 == onesPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace))
					&& ((possibleGuesses.get(i) % 10 == onesPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace))) {
					possibleGuesses.remove(i);
				} else if ((((possibleGuesses.get(i) / 10) % 10 == tensPlace) && (possibleGuesses.get(i) % 10 != onesPlace))
					&& (((possibleGuesses.get(i) / 10) % 10 == tensPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace))
    				&& (((possibleGuesses.get(i) / 10) % 10 == tensPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace))) {
					possibleGuesses.remove(i);
				} else if ((((possibleGuesses.get(i) / 100) % 10 == hundredsPlace) && (possibleGuesses.get(i) % 10 != onesPlace))
					&& (((possibleGuesses.get(i) / 100) % 10 == hundredsPlace) && ((possibleGuesses.get(i) / 10) % 10 != tensPlace))
					&& (((possibleGuesses.get(i) / 100) % 10 == hundredsPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace))) {
					possibleGuesses.remove(i);
				} else if ((((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace) && (possibleGuesses.get(i) % 10 != onesPlace))
					&& (((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace) && ((possibleGuesses.get(i) / 10) % 10 != tensPlace))
					&& (((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace))) {
					possibleGuesses.remove(i);
				} else {
					i++;
				}
			 }
		}


		if (nmatches == 3) {
			int i = 0;
			while (i < possibleGuesses.size()) {
				if ((possibleGuesses.get(i) % 10 != onesPlace) && ((possibleGuesses.get(i) / 10) % 10 != tensPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace) && (possibleGuesses.get(i) / 1000 != thousandsPlace)) {
					possibleGuesses.remove(i);
				} else if ((possibleGuesses.get(i) % 10 == onesPlace) 
					&& ((possibleGuesses.get(i) / 10) % 10 != tensPlace)
					&& ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace)
					&& ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace)) {
					possibleGuesses.remove(i);
				} else if (((possibleGuesses.get(i) / 10) % 10 == tensPlace) 
					&& (possibleGuesses.get(i) % 10 != onesPlace)
					&& ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace) 
					&& ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace)) {
					possibleGuesses.remove(i);
				} else if (((possibleGuesses.get(i) / 100) % 10 == hundredsPlace)
					&& (possibleGuesses.get(i) % 10 != onesPlace)
					&& ((possibleGuesses.get(i) / 10) % 10 != tensPlace)
					&& ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace)) {
					possibleGuesses.remove(i);
				} else if (((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace)
					&& (possibleGuesses.get(i) % 10 != onesPlace)
					&& ((possibleGuesses.get(i) / 10) % 10 != tensPlace)
					&& ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace)) {
					possibleGuesses.remove(i);
				} else if ((possibleGuesses.get(i) % 10 == onesPlace) 
					&& ((possibleGuesses.get(i) / 10) % 10 == tensPlace) 
					&& ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace) 
					&& ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace)) {
					possibleGuesses.remove(i);
				} else if ((possibleGuesses.get(i) % 10 == onesPlace)
					&& ((possibleGuesses.get(i) / 100) % 10 == hundredsPlace)
					&& ((possibleGuesses.get(i) / 10) % 10 != tensPlace)
					&& ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace)) {
					possibleGuesses.remove(i);
				} else if ((possibleGuesses.get(i) % 10 == onesPlace)
					&& ((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace)
					&& ((possibleGuesses.get(i) / 10) % 10 != tensPlace)
					&& ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace)) {
					possibleGuesses.remove(i);
				} else if (((possibleGuesses.get(i) / 10) % 10 == tensPlace)
					&& ((possibleGuesses.get(i) / 100) % 10 == hundredsPlace)
					&& (possibleGuesses.get(i) % 10 != onesPlace)
					&& ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace)) {
					possibleGuesses.remove(i);
				} else if (((possibleGuesses.get(i) / 10) % 10 == tensPlace)
					&& ((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace)
					&& (possibleGuesses.get(i) % 10 != onesPlace)
					&& ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace)) {
					possibleGuesses.remove(i);
				} else if (((possibleGuesses.get(i) / 100) % 10 == hundredsPlace)
					&& ((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace)
					&& (possibleGuesses.get(i) % 10 != onesPlace)
					&& ((possibleGuesses.get(i) / 10) % 10 != tensPlace)) {
					possibleGuesses.remove(i);
				} else if ((possibleGuesses.get(i) % 10 == onesPlace) && ((possibleGuesses.get(i) / 10) % 10 == tensPlace) && ((possibleGuesses.get(i) / 100) % 10 == hundredsPlace) && ((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace)) {
					possibleGuesses.remove(i);
				} else {
					i++;
				}
			}
		}
	}
	

	public static void main(String[] args) {

		GuessingGame gamer = new GuessingGame( );
  
		System.out.println("Let's play a game. Think of a number between 1000 and 9999");
        
        System.out.println("Press \"ENTER\" when you are ready");
        
        scanner.nextLine();
        
		int numMatches = 0;
		int myguess = 0;
		
		do {
			myguess = gamer.myGuessIs();
			if (myguess == -1) {
				System.out.println("I don't think your number exists!");
				System.exit(0);
			}
			System.out.println("I guess your number is " + myguess + ". How many digits did I guess correctly?");
			String userInput = scanner.nextLine();
			
			// quit if the user input nothing (such as pressed ESC)
			if (userInput == null)
				System.exit(0);
			// parse user input, pop up a warning message if the input is invalid
			try {
				numMatches = Integer.parseInt(userInput.trim());
			}
			catch(Exception exception) {
				System.out.println("Your input is invalid. Please enter a number between 0 and 4");
				continue;
			}
			// the number of matches must be between 0 and 4
			if (numMatches < 0 || numMatches > 4) {
				System.out.println("Your input is invalid. Please enter a number between 0 and 4");
				continue;
			}
			if (numMatches == 4)
				break;
			// update based on user input
			gamer.updateMyGuess(numMatches);
			
		} while (true);
		
		// the game ends when the user says all 4 digits are correct
		System.out.println("Aha, I got it, your number is " + myguess + ".");
		System.out.println("I did it in " + gamer.totalNumGuesses() + " turns.");
	}
}
