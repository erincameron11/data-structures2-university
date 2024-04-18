// If the jump leads to a space that is an empty char ' ', it is not a valid jump (' ')
// If the peg wanting to jump is next to a space that is an empty char, same as above
// Pegs can only jump into empty spots, and only over one other peg
// After a peg has been jumped over, that peg is removed

package assignmentonejunkyard;

public class Puzzle {

	// Initialize various variables
	private Board board = new Board();
//	private int[] directions = board.getDirection();
	private static final int RIGHT = 0;  // Corresponding to the index of the directions array
	private static final int LEFT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;
	public int[] directions = {RIGHT, LEFT, UP, DOWN};
	
	private Board [] solution = new Board[32];
		
	// Constructor
	 public Puzzle() {
         for (int i = 0; i < solution.length; i++) {
        	 solution[i] = new Board();
         }
	 }
	
	 
	/** Method: Backtracking algorithm to solve the puzzle. Move current # of move - first move is 1 */
	public boolean findSolution(int move) {
			
			for (int x = 0; move <= 31 && x < board.getLength(); x++) {  // Loop the length of the board
			    for (int y = 0; y < board.getHeight(); y++) {  // Loop the height of the board

			    	System.out.println("loop");
			    		for (int element : directions) {  // Loop the directions of the board
			    			if (element == 0) { // RIGHT
			    				// First check if valid move then make a move and copy to solution board
			    				if (board.checkMove(x, y, element)) {
			    					board.makeMove(x, y, element);
			    					solution[move] = board;
			    					
			    				}
			    				
			    			} else if (element == 1) { // LEFT
			    				// First check if valid move then make a move and copy to solution board
			    				if (board.checkMove(x, y, element)) {
			    					board.makeMove(x, y, element);
			    					solution[move] = board;
			    					
			    				}
			    				
			    			} else if (element == 2) {  // UP
			    				// First check if valid move then make a move and copy to solution board
			    				if (board.checkMove(x, y, element)) {
			    					board.makeMove(x, y, element);
			    					solution[move] = board;
			    				}
	
			    			} else if (element == 3) {
			    				// First check if valid move then make a move and copy to solution board
			    				if (board.checkMove(x, y, element)) {
			    					board.makeMove(x, y, element);
			    					solution[move] = board;
			    				}

			    			}	
			    			// Recursion backtracking
			    			if (board.isPeg(3, 3) && move <= 31) {
			    				return true;
			    				
			    			} else {
			    				System.out.println("recurse");
			    				if (findSolution(move + 1))
				    				return true;
				    			else {
				    				board.reverseMove(x, y, element);
				    			}
			    			}
			    			
			    			
			    			}
			    		
			    				
			    		}
			    			
			    		}
			    		
			    	
			return false;
	}
			    	
			    	
			    	
	
	
	/** Main Method for starting the algorithm and printing solution */
	public static void main(String[] args) {
		Puzzle puzzle = new Puzzle();
		
		// If true, display the boards
		if (puzzle.findSolution(1)) {
			for (int i = 0; i < puzzle.solution.length; i++) {
	            puzzle.solution[i].print();
			}
       
		// Else there is no solution
		} else {
            System.out.println("No solution found.");
            for (int i = 0; i < puzzle.solution.length; i++) {
	            puzzle.solution[i].print();
			}
		}
		
	}
			
	
}
