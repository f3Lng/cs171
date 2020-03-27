/**
 * Starter code for the Maze path finder problem.
 */

/*
THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS. Lydia Feng
*/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

/*
 * Recursive class to represent a position in a path
 */
class Position{
	public int i;     //row
	public int j;     //column
	public char val;  //1, 0, or 'X'
	
	// reference to the previous position (parent) that leads to this position on a path
	Position parent;
	
	Position(int x, int y, char v){
		i=x; j = y; val=v;
	}
	
	Position(int x, int y, char v, Position p){
		i=x; j = y; val=v;
		parent=p;
	}
	
}


public class PathFinder {
	
	public static void main(String[] args) throws IOException {
		if(args.length<1){
			System.err.println("***Usage: java PathFinder maze_file");
			System.exit(-1);
		}
		
		char [][] maze;
		maze = readMaze(args[0]);
		printMaze(maze);
		Position [] path = stackSearch(maze);
		System.out.println("stackSearch Solution:");
		printPath(path);
		printMaze(maze);
		
		char [][] maze2 = readMaze(args[0]);
		path = queueSearch(maze2);
		System.out.println("queueSearch Solution:");
		printPath(path);
		printMaze(maze2);
	}
	
	
	public static Position[] stackSearch(char [] [] maze){
		// todo: your path finding algorithm here using the stack to manage search list
		// your algorithm should mark the path in the maze, and return array of Position 
		// objects coressponding to path, or null if no path found

		Position current = new Position(0, 0, '0', null); //maze entrance position is the current
		Deque<Position> s = new ArrayDeque<Position>();
		s.addLast(current);

		current.val = 'X'; //mark position as checked
		int n = maze.length;
		
		while (((current.i != n-1) || (current.j != n-1)) && (s.size() != 0)) { //while not at exit position or s is not empty
		int row = current.i;
		int col = current.j;

		if ((row == 0) && col == 0) { //top left corner
			if (maze[row+1][col] == '0') {
				Position down1 = new Position(row+1, col, '0', current);
				s.addLast(down1);
				maze[row+1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right1 = new Position(row, col+1, '0', current);
				s.addLast(right1);
				maze[row][col+1] = 'X';
			}
		} else if ((col == 0) && (row == n-1)) { //bottom left corner
			if (maze[row-1][col] == '0') {
				Position up2 = new Position(row-1, col, '0', current);
				s.addLast(up2);
				maze[row-1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right2 = new Position(row, col+1, '0', current);
				s.addLast(right2);
				maze[row][col+1] = 'X';
			}
		} else if ((col == n-1) && (row == 0)) { //top right corner
			if (maze[row+1][col] == '0') {
				Position down3 = new Position(row+1, col, '0', current);
				s.addLast(down3);
				maze[row+1][col] = 'X';
			}
			if (maze[row][col-1] == '0') {
				Position left3 = new Position(row, col-1, '0', current);
				s.addLast(left3);
				maze[row][col-1] = 'X';
			}
		} else if ((row == 0) && (col != n-1)) { //top border  
			if (maze[row+1][col] == '0') {
				Position down4 = new Position(row+1, col, '0', current); 
				s.addLast(down4);
				maze[row+1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right4 = new Position(row, col+1, '0', current);
				s.addLast(right4);
				maze[row][col+1] = 'X';
			}
			if (maze[row][col-1] == '0') {
				Position left4 = new Position(row, col-1, '0', current);
				s.addLast(left4);
				maze[row][col-1] = 'X';
			}
		} else if ((col == 0) && (row != n-1)) { //left border
			if (maze[row+1][col] == '0') {
				Position down5 = new Position(row+1, col, '0', current);
				s.addLast(down5);
				maze[row+1][col] = 'X';
			}
			if (maze[row-1][col] == '0') {
				Position up5 = new Position(row-1, col, '0', current);
				s.addLast(up5);
				maze[row-1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right5 = new Position(row, col+1, '0', current);
				s.addLast(right5);
				maze[row][col+1] = 'X';
			}
		} else if ((col == n-1) && (row != n-1)) { //right border
			if (maze[row+1][col] == '0') {
				Position down6 = new Position(row+1, col, '0', current);
				s.addLast(down6);
				maze[row+1][col] = 'X';
			}
			if (maze[row-1][col] == '0') {
				Position up6 = new Position(row-1, col, '0', current);
				s.addLast(up6);
				maze[row-1][col] = 'X';
			}
			if (maze[row][col-1] == '0') {
				Position left6 = new Position(row, col-1, '0', current);
				s.addLast(left6);
				maze[row][col-1] = 'X';
			}
		} else if ((row == n-1) && (col != n-1)) { //bottom border
			if (maze[row-1][col] == '0') {
				Position up7 = new Position(row-1, col, '0', current);
				s.addLast(up7);
				maze[row-1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right7 = new Position(row, col+1, '0', current);
				s.addLast(right7);
				maze[row][col+1] = 'X';
			}
			if (maze[row][col-1] == '0') {
				Position left7 = new Position(row, col-1, '0', current);
				s.addLast(left7);
				maze[row][col-1] = 'X';
			}
		} else if ((row != n-1) || (col != n-1)) { //middle
			if (maze[row+1][col] == '0') {
				Position down8 = new Position(row+1, col, '0', current);
				s.addLast(down8);
				maze[row+1][col] = 'X';
			}
			if (maze[row-1][col] == '0') {
				Position up8 = new Position(row-1, col, '0', current);
				s.addLast(up8);
				maze[row-1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right8 = new Position(row, col+1, '0', current);
				s.addLast(right8);
				maze[row][col+1] = 'X';
			}
			if (maze[row][col-1] == '0') {
				Position left8 = new Position(row, col-1, '0', current);
				s.addLast(left8);
				maze[row][col-1] = 'X';
			}
		} 
		current = s.removeLast();
	}

	//reset maze, change all the X's back to 0's (because X's checked if the position was visited, but visited positions may not be in the final path)
	for (int i = 0; i < maze.length; i++) {
		for (int j = 0; j < maze[0].length; j++) {
			if (maze[i][j] == 'X') {
				maze[i][j] = '0';
			}
		}
	}



	if (s.size() != 0) {
	//push path onto a stack
	Stack<Position> stack = new Stack<Position>();
	while (current != null) {
		//trace path with X
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[0].length; col++) {
				if ((current.i == row) && (current.j == col)) {
					maze[row][col] = 'X';
				}
			}
		}
		stack.push(current);
		current = current.parent; //update current
	}

	int count = stack.size();
	
	//pop stack of positions into an array of positions
	Position[] path = new Position[count];
	for (int i = 0; i < count; i++) {
		Position temp = new Position(0, 0, '0', null);
		temp = stack.pop();
		path[i] = temp;
	}
	return path;
	} else { //if stack is empty
		System.out.println("There is no path through this maze");
		return null;
	}
}

	
	public static Position [] queueSearch(char [] [] maze){ 

		// todo: your path finding algorithm here using the queue to manage search list
		// your algorithm should mark the path in the maze, and return array of Position 
		// objects coressponding to path, or null if no path found


		Position current = new Position(0, 0, '0', null); //maze entrance position is current
		Deque<Position> s = new ArrayDeque<Position>();
		s.addLast(current);

		current.val = 'X'; //mark as checked
		current = s.removeFirst();
		int n = maze.length;

		Position empty = new Position(0, 0, 'E', null); //special Position to check for emptiness
		
		while (((current.i != n-1) || (current.j != n-1)) && (s.peekLast() != empty)) { //while not at exit position and while s does not contain the special empty position
		int row = current.i;
		int col = current.j;

		if ((row == 0) && col == 0) { //top left corner
			if (maze[row+1][col] == '0') {
				Position down1 = new Position(row+1, col, '0', current);
				s.addLast(down1);
				maze[row+1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right1 = new Position(row, col+1, '0', current);
				s.addLast(right1);
				maze[row][col+1] = 'X';
			}
		} else if ((col == 0) && (row == n-1)) { //bottom left corner
			if (maze[row-1][col] == '0') {
				Position up2 = new Position(row-1, col, '0', current);
				s.addLast(up2);
				maze[row-1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right2 = new Position(row, col+1, '0', current);
				s.addLast(right2);
				maze[row][col+1] = 'X';
			}
		} else if ((col == n-1) && (row == 0)) { //top right corner
			if (maze[row+1][col] == '0') {
				Position down3 = new Position(row+1, col, '0', current);
				s.addLast(down3);
				maze[row+1][col] = 'X';
			}
			if (maze[row][col-1] == '0') {
				Position left3 = new Position(row, col-1, '0', current);
				s.addLast(left3);
				maze[row][col-1] = 'X';
			}
		} else if ((row == 0) && (col != n-1)) { //top border  
			if (maze[row+1][col] == '0') {
				Position down4 = new Position(row+1, col, '0', current);
				s.addLast(down4);
				maze[row+1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right4 = new Position(row, col+1, '0', current);
				s.addLast(right4);
				maze[row][col+1] = 'X';
			}
			if (maze[row][col-1] == '0') {
				Position left4 = new Position(row, col-1, '0', current);
				s.addLast(left4);
				maze[row][col-1] = 'X';
			}
		} else if ((col == 0) && (row != n-1)) { //left border
			if (maze[row+1][col] == '0') {
				Position down5 = new Position(row+1, col, '0', current);
				s.addLast(down5);
				maze[row+1][col] = 'X';
			}
			if (maze[row-1][col] == '0') {
				Position up5 = new Position(row-1, col, '0', current);
				s.addLast(up5);
				maze[row-1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right5 = new Position(row, col+1, '0', current);
				s.addLast(right5);
				maze[row][col+1] = 'X';
			}
		} else if ((col == n-1) && (row != n-1)) { //right border
			if (maze[row+1][col] == '0') {
				Position down6 = new Position(row+1, col, '0', current);
				s.addLast(down6);
				maze[row+1][col] = 'X';
			}
			if (maze[row-1][col] == '0') {
				Position up6 = new Position(row-1, col, '0', current);
				s.addLast(up6);
				maze[row-1][col] = 'X';
			}
			if (maze[row][col-1] == '0') {
				Position left6 = new Position(row, col-1, '0', current);
				s.addLast(left6);
				maze[row][col-1] = 'X';
			}
		} else if ((row == n-1) && (col != n-1)) { //bottom border
			if (maze[row-1][col] == '0') {
				Position up7 = new Position(row-1, col, '0', current);
				s.addLast(up7);
				maze[row-1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right7 = new Position(row, col+1, '0', current);
				s.addLast(right7);
				maze[row][col+1] = 'X';
			}
			if (maze[row][col-1] == '0') {
				Position left7 = new Position(row, col-1, '0', current);
				s.addLast(left7);
				maze[row][col-1] = 'X';
			}
		} else if ((row != n-1) || (col != n-1)) { //middle
			if (maze[row+1][col] == '0') {
				Position down8 = new Position(row+1, col, '0', current);
				s.addLast(down8);
				maze[row+1][col] = 'X';
			}
			if (maze[row-1][col] == '0') {
				Position up8 = new Position(row-1, col, '0', current);
				s.addLast(up8);
				maze[row-1][col] = 'X';
			}
			if (maze[row][col+1] == '0') {
				Position right8 = new Position(row, col+1, '0', current);
				s.addLast(right8);
				maze[row][col+1] = 'X';
			}
			if (maze[row][col-1] == '0') {
				Position left8 = new Position(row, col-1, '0', current);
				s.addLast(left8);
				maze[row][col-1] = 'X';
			}
		} 
		if (s.size() != 0) {
			current = s.removeFirst();
		 } else {
		 	s.addLast(empty); //add special empty position if s is empty
		 }
	}


	//reset maze and change all the X's back to 0's (because X's checked if the position was visited, but visited positions may not be in the final path)
	for (int i = 0; i < maze.length; i++) {
		for (int j = 0; j < maze[0].length; j++) {
			if (maze[i][j] == 'X') {
				maze[i][j] = '0';
			}
		}
	}

	if (s.peekLast() != empty) { //if does not have special empty position, there exists a solution

	//push path onto a stack
	Stack<Position> stack = new Stack<Position>();
	while (current != null) {
		//trace path with X
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[0].length; col++) {
				if ((current.i == row) && (current.j == col)) {
					maze[row][col] = 'X';
				}
			}
		}
		stack.push(current);
		current = current.parent;
	}

	int count = stack.size();
	
	//pop positions from stack into array of positions
	Position[] path = new Position[count];
	for (int i = 0; i < count; i++) {
		Position temp = new Position(0, 0, '0', null);
		temp = stack.pop();
		path[i] = temp;
	}
	return path;
	} else { //if has special empty position
		System.out.println("There is no path through this maze");
		return null;
		}
		
	}
	
	public static void printPath(Position [] path){
		// todo: print the path to the stdout
		if (path != null) { //if there is a solution to the maze
		System.out.println("I found a path through the maze!");
		System.out.print("(");

		for (int num = 0; num < path.length - 1; num++) {
			System.out.print("[" + path[num].i + "][" + path[num].j + "], ");
		}
		//edge case, don't print final comma and space
		System.out.println("[" + path[path.length-1].i + "][" + path[path.length-1].j + "])");
	} 
	}
	
	/**
	 * Reads maze file in format:
	 * N  -- size of maze
	 * 0 1 0 1 0 1 -- space-separated 
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static char [][] readMaze(String filename) throws IOException{
		char [][] maze;
		Scanner scanner;
		try{
			scanner = new Scanner(new FileInputStream(filename));
		}
		catch(IOException ex){
			System.err.println("*** Invalid filename: " + filename);
			return null;
		}
		
		int N = scanner.nextInt();
		scanner.nextLine();
		maze = new char[N][N];
		int i=0;
		while(i < N && scanner.hasNext()){
			String line =  scanner.nextLine();
			String [] tokens = line.split("\\s+");
			int j = 0;
			for (; j< tokens.length; j++){
				maze[i][j] = tokens[j].charAt(0);
			}
			if(j!=N){
				System.err.println("*** Invalid line: " + i + " has wrong # columns: " + j);
				return null;
			}
			i++;
		}
		if(i!=N){
			System.err.println("*** Invalid file: has wrong number of rows: " + i);
			return null;
		}
		return maze;
	}
	
	public static void printMaze(char[][] maze){
		
		if(maze==null || maze[0] == null){
			System.err.println("*** Invalid maze array");
			return;
		}
		
		for(int i=0; i< maze.length; i++){
			for(int j = 0; j< maze[0].length; j++){
				System.out.print(maze[i][j] + " ");	
			}
			System.out.println();
		}
		
		System.out.println();
	}

}
