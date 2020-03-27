/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS. Lydia Feng
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HashTableApp {

	// TODO: Build and return a hash table of frequencies from the given input file
	public static HashSeparateChaining getMap(Scanner in){
		HashSeparateChaining table = new HashSeparateChaining();

		int i = 0;
		while (in.hasNext()) {
		 	String s = in.next();
		 	s = s.toLowerCase();

		 	boolean valid = true; //checks if word is valid
		 	for (int c = 0; c < s.length(); c++) { //traverse through word
		 		//uses ASCII table to check if all chars are a number or a letter
		 		if (((s.charAt(c) >= 97) && (s.charAt(c) <= 122)) || ((s.charAt(c) >= 48) && (s.charAt(c) <= 57))) {
		 			valid = valid && true;
		 		} else {
		 			valid = valid && false;
		 		}
		 	}

		 	if (valid == true) {
		 		if (table.get(s) == null) { //if not in table, put with value = 1
		 			table.put(s, 1);
		 		} else {
		 			table.put(s, table.get(s) + 1);
		 		}
		 		i++;
		 	}

		 	}


		System.out.println(table.toString());
		System.out.println(table.tableSize);


		return table;
	}

	public static void main(String[] args) {
		if (args.length < 1){
			System.out.println("Pass the filename to be read as an argument.");
			System.exit(-1);
		}

		File input = new File(args[0]);
		Scanner fileReader = null;

		try{
			fileReader = new Scanner(input);
		} catch (FileNotFoundException e) {
			System.out.println("File was not found.  Check the file name and try again.");
			System.exit(-2);
		}

		HashSeparateChaining map = getMap(fileReader);
		
		//map.toString();
	}
}