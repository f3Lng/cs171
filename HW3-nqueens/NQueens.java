import java.util.Stack;

public class NQueens {
 

  static Stack<Integer> s = new Stack<Integer>();
  static int startingPosition = 0;


  public static int solve(int n) {
    int numSolutions = 0;
    while (s.size() <= n) {
    	int valid = -1;

    	for (int i = startingPosition; i < n; i ++) { //i is column index
      		if (validColDiag(s, i) != -1) {
        		valid = i;
        		break;
      		} else {
        		valid = -1;
      		}
    	}

    	if (valid != -1) {
      	s.push(valid);
      	startingPosition = 0; //reset column to next line
    	} else {
      		startingPosition = s.pop() + 1;
    	}


    	if ((startingPosition > n - 1) && (s.size() != 0)) {
      		startingPosition = s.pop() + 1; //if at end of row
    	}


    	if (s.size() == n) {
      		printSolution(s);
      		numSolutions++;
    		startingPosition = s.pop() + 1; //to find more solutions
      		if (startingPosition == n) {
        		startingPosition = s.pop() + 1;
      		}
    	}


    	if (startingPosition == n) { //end of solutions
      		break;
    	}
	}

    return numSolutions;
  }



  public static int validColDiag(Stack<Integer> s, int q) {
    int validCol = -1;
    int j = 0;
    for (int i = 0; i < s.size(); i++) {
      if (q == s.get(i)) {
        return -1;
      }
      for (int k = 1; k <= s.size(); k++) {
        if ((q == s.get(s.size() - k) + k) || (q == s.get(s.size() - k) - k)) {
          return -1;
        }
      }
    }
    validCol = q;
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
  
  int n = 12;
  
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
