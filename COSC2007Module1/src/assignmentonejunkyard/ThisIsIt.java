package assignmentonejunkyard;

public class ThisIsIt {

	// Initialize the board variables
	private static final int BOARD_SIZE = 32;
	private static ThisIsItBoard board = new ThisIsItBoard();
	public static ThisIsItBoard[] answers = new ThisIsItBoard[BOARD_SIZE];  // Create an array to hold each board state
	public int[] direction = {0, 1, 2, 3};  // RIGHT, LEFT, UP, DOWN

	// Constructor to initialize the answers array with the beginning state
	ThisIsIt() {
		for (int i = 0; i < answers.length; i++) {
			answers[i] = new ThisIsItBoard();
		}
	}
	
	
	public int getLength() {
		return board.length;
	}
	
	
	public boolean findSolution(int move) {
		
		// Loop through the rows
		for (int row = 0; move < (BOARD_SIZE - 1) && row < board.length; row++) {
			// Loop through the cols
			for (int col = 0; col < board.length; col++) {
				// Loop through each direction possible
				for (int e : direction) {
					// Check if it's a valid move for each direction
					if (e == 0) {  // RIGHT
						if (row >= 0
							&& row < board.length
							&& (row + 2) < board.length
							&& board.isEmpty(row + 2, col)
							&& board.isPeg(row + 1, col)
							&& board.isPeg(row, col))
							
							// Make the move if it is valid
							board.makeMove(row, col, e);
					}
					
					if (e == 1) {  // LEFT
						if (row < board.length
//							&& row >= 2
							&& (row - 2) >= 0
							&& board.isEmpty(row - 2, col)
							&& board.isPeg(row - 1, col)
							&& board.isPeg(row, col))
								
							// Make the move if it is valid
							board.makeMove(row, col, e);
					}
					
					if (e == 2) {  // UP
						if (col >= 0
							&& col < board.length
							&& (col - 2) >= 0
							&& board.isEmpty(row, col - 2)
							&& board.isPeg(row, col - 1)
							&& board.isPeg(row, col))
							
							// Make the move if it is valid
							board.makeMove(row, col, e);
					}
						
					if (e == 3) {  // DOWN
						if (col < board.length
							&& col >= 0
							&& (col + 2) < board.length
							&& board.isEmpty(row, col + 2)
							&& board.isPeg(row, col + 1)
							&& board.isPeg(row, col))
							
							// Make the move if it is valid
							board.makeMove(row, col, e);
					}
					
					// Add move to solution board
					answers[move] = board;
					
					// If not at the end of the moves, and the middle spot is not a peg, Recurse
					if (! (move <= BOARD_SIZE - 1 && board.isPeg(3, 3))) { 
                        if (findSolution(move + 1)) {  // RECURSE
                        	return true;
                        } else {  // IF WE DON'T FIND SOLUTION, BACKTRACK
                        	board.reverseMove(row, col, e);
                        }
					} else {
                        return true;
					}
						// if future moves are all not valid, backtrack
					
//					System.out.println(checkMove(row, col, direction[e]));
					
				}
				
				
			}
		}
		
		return false;
	}
	
	
	/** Method to check if the move is a valid one 
	 * PASS: direction index as direction int */
	public boolean checkMove(int x, int y, int direction) {
		int x2 = x;
		int y2 = y;
		
		if (direction == 0) {  // RIGHT
			x2 += 2;
			return x > 0
				   && x <= 4
				   && board.isPeg(x, y)
				   && board.isPeg((x + x2) / 2, y)
				   && board.isEmpty(x2, y);
		}
		
		if (direction == 1) {  // LEFT
			x2 -= 2;
			return x <= 6
				   && x >= 2
				   && board.isPeg(x, y)
			       && board.isPeg((x - x2) / 2, y)
				   && board.isEmpty(x2, y);
		}
		
		if (direction == 2) {  // UP
			y2 += 2;
			return y <= 6
				   && y >= 2
				   && board.isPeg(x, y)
				   && board.isPeg(x, (y + y2) / 2)
				   && board.isEmpty(x, y2);
		}
		
		if (direction == 3) {  // DOWN
			y2 -= 2;
			return y >= 0
				   && y <= 4
				   && board.isPeg(x, y)
				   && board.isPeg(x, (y - y2) / 2)
				   && board.isEmpty(x, y2);
		}
		return false;
	}
	
	
	/** Method to print the board */
	public void printBoard() {
		for (int i = 0; i < answers.length; i++) {
			answers[i].print();
		}
	}
	
	
	/** Main Method */
	public static void main(String[] args) {
		ThisIsIt puzzle = new ThisIsIt();
		
		// For each board stored in the answers array, print out the board
		puzzle.printBoard();
		puzzle.findSolution(1);
		
	}

}
