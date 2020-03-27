import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame2{
	
	private static Scanner scanner = new Scanner(System.in);
	ArrayList<Integer> possibleGuesses;

	public GuessingGame2() { //has to have same name as class
		possibleGuesses = new ArrayList<Integer>();
		Integer i = 1000;
		while (i <= 9999) {
			possibleGuesses.add(i);
			i++;
		}
	}

	public int myGuessIs() {
		int random = (int)(Math.random() * (possibleGuesses.size()));
		int myGuess = possibleGuesses.get(random);
		return myGuess;
	}

	public int totalNumGuesses() {
		int totalNumGuesses = 0;
		return totalNumGuesses;
	}

	public void updateMyGuess(int nmatches) {
		int myGuess = myGuessIs();

		int onesPlace = myGuess % 10;
		myGuess = myGuess / 10;
		int tensPlace = myGuess % 10;
		myGuess = myGuess / 10;
		int hundredsPlace = myGuess % 10;
		myGuess = myGuess / 10;
		int thousandsPlace = myGuess % 10;

		if (nmatches == 0) {
			// int size = possibleGuesses.size();
			int i = 0;
			while (i < possibleGuesses.size()) {
			// for (int i = 0; i < size; i++) {
				if ((possibleGuesses.get(i) % 10 == onesPlace) || ((possibleGuesses.get(i) / 10) % 10 == tensPlace) || ((possibleGuesses.get(i) / 100) % 10 == hundredsPlace) || ((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace)) {
					possibleGuesses.remove(i);
				} else {
					i++;
				}
			}
		} 
		if (nmatches == 1) {
			// int size2 = possibleGuesses.size();
			// for (int j = 0; j < size2; j++) {
			int i = 0;
			while (i < possibleGuesses.size()) {
				if (
					((possibleGuesses.get(i) % 10 == onesPlace) && ((possibleGuesses.get(i) / 10) % 10 == tensPlace))
					||
					((possibleGuesses.get(i) % 10 == onesPlace) && ((possibleGuesses.get(i) / 100) % 10 == hundredsPlace))
					||
					((possibleGuesses.get(i) % 10 == onesPlace) && ((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace))
					||
					(((possibleGuesses.get(i) / 10) % 10 == tensPlace) && ((possibleGuesses.get(i) / 100) % 10 == hundredsPlace))
					||
					(((possibleGuesses.get(i) / 10) % 10 == tensPlace) && ((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace))
					||
					(((possibleGuesses.get(i) / 100) % 10 == hundredsPlace) && ((possibleGuesses.get(i) / 1000) % 10 == thousandsPlace))
					||
					((possibleGuesses.get(i) != onesPlace) && ((possibleGuesses.get(i) / 10) % 10 != tensPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace))
					) {
					possibleGuesses.remove(i);
				} else {
					i++;
				}
			}
		}
		if (nmatches == 2) {
			int i = 0;
			 while (i < possibleGuesses.size()) {
			 	if (
			 		((possibleGuesses.get(i) % 10 != onesPlace) && ((possibleGuesses.get(i) / 10) % 10 != tensPlace)) || ((possibleGuesses.get(i) % 10 != onesPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace)) || ((possibleGuesses.get(i) % 10 != onesPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace))
			 		||
			 		(((possibleGuesses.get(i) / 10) % 10 != tensPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace)) || (((possibleGuesses.get(i) / 10) % 10 != tensPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace))
			 		||
			 		(((possibleGuesses.get(i) / 100) % 10 != hundredsPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace))
			 		) {
			 		possibleGuesses.remove(i);
			 	} else {
			 		i++;
			 	}
			 }
		}
		if (nmatches == 3) {
			int i = 0;
			while (i < possibleGuesses.size()) {
				if (
					((possibleGuesses.get(i) % 10 != onesPlace) && ((possibleGuesses.get(i) / 10) % 10 != tensPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace))
					||
					((possibleGuesses.get(i) % 10 != onesPlace) && ((possibleGuesses.get(i) / 10) % 10 != tensPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace))
					||
					((possibleGuesses.get(i) % 10 != onesPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace))
					||
					(((possibleGuesses.get(i) / 10) % 10 != tensPlace) && ((possibleGuesses.get(i) / 100) % 10 != hundredsPlace) && ((possibleGuesses.get(i) / 1000) % 10 != thousandsPlace))
					) {
					possibleGuesses.remove(i);
				} else {
					i++;
				}
			}
		}
	}


	public static void main(String[] args) {
		GuessingGame2 gamer = new GuessingGame2();
		System.out.println("Think of a number between 1000 and 9999 (including), and I'll guess what it is. I guess your number is " + gamer.myGuessIs() + ". How many digits did I guess correctly?");
		scanner.nextLine();

		int numMatches = 0;
		int myGuess = 0;

		do {
			myGuess = gamer.myGuessIs();
			if (myGuess == -1) {
				System.out.println("I don't think your number exists!");
				System.exit(0);
			}
			System.out.println("I guess your number is " + myGuess + ". How many digits did I guess correctly?");
			String userInput = scanner.nextLine();

			if (userInput == null) 
				System.exit(0);
			try {
				numMatches = Integer.parseInt(userInput.trim());
			}
			catch(Exception exception) {
				System.out.println("Your input is invalid. Please enter a number between 0 and 4");
				continue;
			}
			if (numMatches == 4)
				break;
			gamer.updateMyGuess(numMatches);
		}
		while(true);

	}

}