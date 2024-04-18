package labone;

public class Queen {
	// Initialize class-wide variables
	public static final int N = 4;
	public static int numberSol = 1;
	public static int board[][] = { { 0, 0, 0, 0 },
					                { 0, 0, 0, 0 },
					                { 0, 0, 0, 0 },
					                { 0, 0, 0, 0 } };
	
	/** TESTING that 0 boards will print, and "solution does not exist" will show board is 3x3
	// (since there are no solutions) - remember to also set N = 3 before running */
//	public static int board[][] = { { 0, 0, 0},
//									{ 0, 0, 0},
//									{ 0, 0, 0},
//									{ 0, 0, 0} 
//								  };

	/** TESTING that 92 solution boards will print if 8x8 matrix (remember to also set N = 8 before running) */
//	public static int board[][] = { {0, 0, 0, 0, 0, 0, 0, 0},
//									{0, 0, 0, 0, 0, 0, 0, 0},
//									{0, 0, 0, 0, 0, 0, 0, 0},
//									{0, 0, 0, 0, 0, 0, 0, 0},
//									{0, 0, 0, 0, 0, 0, 0, 0},
//									{0, 0, 0, 0, 0, 0, 0, 0},
//									{0, 0, 0, 0, 0, 0, 0, 0},
//									{0, 0, 0, 0, 0, 0, 0, 0}
//								   };
	
 	
 	/** Method to check the row if a queen is already placed here - return a boolean */
 	public static boolean checkRow(int[][] board, int row, int col) {
 	     for (int i = 0; i < col; i++)
 	         if (board[row][i] == 1)
 	             return false;
 	     return true;
 	}
 
 	
 	/** Method to check the upward diagonal if a queen is already placed here - return a boolean */
 	public static boolean checkDiagUp(int[][] board, int row, int col) {
 		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
 	         if (board[i][j] == 1)
 	             return false;
 		
 		return true;
 	}
 	
 	
 	/** Method to check the downward diagonal if a queen is already placed here - return a boolean */
 	public static boolean checkDiagDown(int[][] board, int row, int col) {
 		for (int i = row, j = col; j >= 0 && i < N; i++, j--)
 	         if (board[i][j] == 1)
 	             return false;
 		return true;
 	}
 	
 	
 	/** Method to locate all possible solutions to the problem */
 	public static boolean findSolution(int board[][], int col){

 		// Base case: if N has surpassed the column number successfully
 		if (col >= N) {
 			print(board);
 			return true;
 		}

 		boolean result = false;
 		
 		for (int i = 0; i < N; i++) {
 			// IF it is a safe move to make:
 			if (checkRow(board, i, col) 
 				&& checkDiagUp(board, i, col) 
 				&& checkDiagDown(board, i, col)) {
 				
 				// Move the queen to this place
 				board[i][col] = 1;

 				// Recursion step
 				result = findSolution(board, col + 1) || result;

 				// Backtrack step if a step is found to not lead to a completed solution
 				board[i][col] = 0;
 			}
 		}
     return result;
 	}

 	
	/** Method to print the solution boards - as many as there are */
	public static void print(int board[][]) {
		// Print out the solution number
		System.out.println("Solution #" + numberSol++);
		
		// Print out each board spot - 0 or 1's
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + board[i][j] + " ");
		
			// Linebreak after each row 
			System.out.println();
		}
		
		// Print a line between solution boards
		System.out.println("\n");
	}
	
	
 	/** Main Method to begin the program - call the findSolution method starting at 0 */
 	public static void main(String args[]) {
 		
 		// If there are not solutions, print it out that none exist
 		if (!findSolution(board, 0)) {
 			System.out.print("Solution does not exist");
 	 	}
 		
 	}
}



