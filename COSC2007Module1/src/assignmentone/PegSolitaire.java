package assignmentone;

public class PegSolitaire {
	// Initialize the peg board
	public static int[][] board = {
			{2, 2, 1, 1, 1, 2, 2},
			{2, 2, 1, 1, 1, 2, 2},
			{1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 0, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1},
			{2, 2, 1, 1, 1, 2, 2},
			{2, 2, 1, 1, 1, 2, 2}
			
	};
	// Initialize the rest of the class-wide variables
	private static final int PEG = 1;
	private static final int EMPTY = 0;
	private static final int UP = 0;
	private static final int RIGHT = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	private static int[] directions = {UP, RIGHT, DOWN, LEFT};  // UP, RIGHT, DOWN, LEFT
	public static String str = "";
	public static String[] answers = new String[32];
	
	
	/** Method to convert each peg board to a string to store in the answers array */
	public static String matrixToString(int[][] board, String str) {
		
		for (int i = 0; i < board.length; i++) {
			str += ".";
			
			for (int j = 0; j < board.length; j++) {
				str += board[i][j];
			}
		}
		return str;
	}
	
	
	/** Method to print an answer index in matrix form */
	public static void printAnswer(String[] answers, int index) {
	
		for (int i = 0; i < 56; i++) {
			
			if (answers[index].charAt(i) == '0') {
				System.out.print("O ");
			
			} else if (answers[index].charAt(i) == '1'){
				System.out.print("X ");
			
			} else if (answers[index].charAt(i) == '2'){
				System.out.print("  ");
			
			} else {
				System.out.println();
			
			}
		}
		System.out.println();
		System.out.println();
	}
	
	
	/** Method to calculate the new coordinates of the three pegs for each move */
	public static int[][] calNewCoords(int x, int y, int direction) {
		
		int newX1 = 0;
		int newY1 = 0;
		int newX2 = 0;
		int newY2 = 0;
		
		switch (direction) {
			case UP: 
				newX1 = x;
				newY1 = y - 1;
				newX2 = x;
				newY2 = y - 2;
				break;
			case RIGHT: 
				newX1 = x + 1;
				newY1 = y;
				newX2 = x + 2;
				newY2 = y;
				break;
			case DOWN:
				newX1 = x;
				newY1 = y + 1;
				newX2 = x;
				newY2 = y + 2;
				break;
			case LEFT:
				newX1 = x - 1;
				newY1 = y;
				newX2 = x - 2;
				newY2 = y;
		}
		
		int[][] coords = { {newX1, newY1},
		   		   		   {newX2, newY2} };
		
		return coords;
	}
	

	/** Method to verify if a move is valid or not - returns true or false */
	public static boolean checkMove(int[][] board, int[][] coords) {

		return coords[0][0] >= 0  // newX1 checking if pegs are outside of the board
				&& coords[0][0] < board.length  // newX1 checking if pegs are outside of the board
				&& coords[1][0] >= 0  // newX2
				&& coords[1][0] < board.length  // newX2 checking if pegs are outside of the board
				&& coords[0][1] >= 0  // newY1
				&& coords[0][1] < board.length  // newY1 checking if pegs are outside of the board
				&& coords[1][1] >= 0  // newY2
				&& coords[1][1] < board.length  // newY2 checking if pegs are outside of the board
				&& board[coords[0][0]][coords[0][1]] == PEG  // middle peg (newX1, newY1) is a peg
				&& board[coords[1][0]][coords[1][1]] == EMPTY;  // outer peg (newX2, newY2) is a whole		
	}
	
	
	/** Method to make a move in a specified direction */
	public static void makeMove(int[][] board, int[][] coords, int x, int y) {
		
		board[x][y] = EMPTY;  // make original hole a peg
		board[coords[0][0]][coords[0][1]] = EMPTY;  // make middle peg a hole (newX1, newY1)
		board[coords[1][0]][coords[1][1]] = PEG;  // make outer peg a hole (newX2, newY2)
	}
	
	
	/** Method to reverse a move */
	public static void reverseMove(int[][] board, int[][] coords, int x, int y) {
		
		board[x][y] = PEG;  // make original hole back to a hole
		board[coords[0][0]][coords[0][1]] = PEG;  // make middle peg back to a peg (newX1, newY1)
		board[coords[1][0]][coords[1][1]] = EMPTY;  // make outer peg back to a peg (newX2, newY2)
	}
	
	
	/** Method to run the recursion with backtracking */
	public static boolean findSolution(int[][] board, int move) {
		
		// Base Case
		if (board[3][3] == PEG && move >= 31) {
			return true;
			
		} else {
			for (int x = 0; x < board.length; x++) {  // Loop through the rows
				for (int y = 0; y < board.length; y++) {  // Loop through the columns
					if (board[x][y] == PEG) {  // When a peg is located
						
						for (int d = 0; d < directions.length; d++) {  // Loop through all 4 directions
							
							int[][] coords = calNewCoords(x, y, d);
							
							// First, check the move is valid, if so, make the move and store the board to the answer array
							if (checkMove(board, coords)) {
								makeMove(board, coords, x, y);
								answers[move] = matrixToString(board, str);  // copy board as a string to answers
							
								if (findSolution(board, move + 1)) {  // Recursion step
				            		return true;
								}
				            	
				            	reverseMove(board, coords, x, y);  // Backtrack step
								
							}							
						}
					}
				}
			}
		}
		
		return false;
	}
	
	
	/** Main Method to run the program and print out answers, if any */
	public static void main(String[] args) {
		
		for (int i = 0; i < answers.length; i++) {
			answers[i] = matrixToString(board, str);
		}
		
		if (findSolution(board, 1)) {
			System.out.println("Solution found");
			
			for (int i = 0; i < 32; i++) {
				printAnswer(answers, i);
			}
			
		} else {
			System.out.println("No solution found.");
		}
	}
}

