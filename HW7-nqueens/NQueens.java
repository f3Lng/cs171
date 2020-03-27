import java.util.Stack;

public class NQueens {

	static Stack<Integer> s = new Stack<Integer>();
	static int startingPosition = 0;
	static int numSolutions = 0;
 
  public static int solve(int n) {
	return isValid(s, n, 0, 0);
  }

 
  

  public static int validColDiag(Stack<Integer> s, int q) { //q is column index
    int validCol = -1;
    int j = 0;
    for (int i = 0; i < s.size(); i++) { //checks to see if col is used
      if (q == s.get(i)) {
        return -1;
      }
      for (int k = 1; k <= s.size(); k++) { //checks diags
        if ((q == s.get(s.size() - k) + k) || (q == s.get(s.size() - k) - k)) {
          return -1;
        }
      }
    }
    validCol = q;
    return validCol;
  }

public static int isValid(Stack<Integer> s, int n, int row, int col) {

	if ((row == 0) && (col == n)) {
		return numSolutions;
	}

	if (row == n) { //if tries to check row n
		printSolution(s);
		numSolutions++;
		int pop2 = s.pop();
		if (pop2 != n-1) {
			col = pop2 + 1;
			row = row - 1;
		} else {
			row = row - 2;
			col = s.pop() + 1;
		}
	}

	if (validColDiag(s, col) != -1) {
		s.push(col);
		return isValid(s, n, row+1, 0); //if valid, call method on next row at col = 0
	} else {
		if (col != n-1) { //if not valid call method on next col
			return isValid(s, n, row, col+1);
		} else {
			int pop = s.pop();
			if (pop != n-1) {
				return isValid(s, n, row-1, pop + 1);
			} 
			else {
				if ((row == 1) && (s.size() == 0)) {
					return isValid(s, n, row-1, col+1);
				}
				return isValid(s, n, row-2,s.pop() +1);
			}
		}
	}
// java -Xss258m NQueens

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
