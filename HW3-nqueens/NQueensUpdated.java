/* 
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS. LYDIA FENG
*/

import java.util.Stack;

public class NQueens {
 

  static Stack<Integer> s = new Stack<Integer>();
  static int startingPosition = 0; //which column you start at


  public static int solve(int n) {
    int numSolutions = 0;
    while (s.size() <= n) {
    	int valid = -1;

    	for (int i = startingPosition; i < n; i ++) { //i is column index
      		if (validColDiag(s, i) != -1) {
        		valid = i; //sets valid equal to the valid colum index
        		break; 
      		} else {
        		valid = -1;
      		}
    	}

    	if (valid != -1) {
      	s.push(valid); //push the valid column position onto the stack
      	startingPosition = 0; //reset column to next line
    	} else {
      		startingPosition = s.pop() + 1; //if no valid position, pop last item in stack and start at next position
    	}


    	if ((startingPosition > n - 1) && (s.size() != 0)) {
      		startingPosition = s.pop() + 1; //if at end of row
    	}


    	if (s.size() == n) {
      		printSolution(s);
      		numSolutions++;
    		startingPosition = s.pop() + 1; //to find more solutions
      		if (startingPosition == n) {
			if (n != 1) {
        		startingPosition = s.pop() + 1; //pop from stack and reset starting position
			}
      		}
    	}


    	if (startingPosition == n) { //end of solutions
      		break;
    	}
	}

    return numSolutions;
  }



  public static int validColDiag(Stack<Integer> s, int q) { //s is the stack, q is the column currently being checked
    int validCol = -1;
    int j = 0;
    for (int i = 0; i < s.size(); i++) { //goes through stack
      if (q == s.get(i)) { //if there is that column index already in the stack, return -1
        return -1;
      }
      for (int k = 1; k <= s.size(); k++) { //checks diags
        if ((q == s.get(s.size() - k) + k) || (q == s.get(s.size() - k) - k)) { //get element from k up and k forward/backward to check against current column q
          return -1;
        }
      }
    }
    validCol = q; //if no conflicts, return validCol = column number
    return validCol;
  }

  
  //this method prints out a solution from the current stack
  //(you should not need to modify this method)
  private static void printSolution(Stack<Integer> s) {
    for (int i = 0; i < s.size(); i ++) {
      for (int j = 0; j < s.size(); j ++) {
        if (j == s.get(i))
          System.out.print("Q ");
        else
          System.out.print("* ");
      }//for
      System.out.println();
    }//for
    System.out.println();  
  }//printSolution()
  
  // ----- the main method -----
  // (you shouldn't need to change this method)
  public static void main(String[] args) {
  
  int n = 8;
  
  // pass in parameter n from command line
  if (args.length == 1) {
    n = Integer.parseInt(args[0].trim());
    if (n < 1) {
      System.out.println("Incorrect parameter");
      System.exit(-1);
    }//if   
  }//if
  
  int number = solve(n);
  System.out.println("There are " + number + " solutions to the " + n + "-queens problem.");
 }//main()
  
}
