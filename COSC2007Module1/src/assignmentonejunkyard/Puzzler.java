// If the jump leads to a space that is an empty char ' ', it is not a valid jump (' ')
// If the peg wanting to jump is next to a space that is an empty char, same as above
// Pegs can only jump into empty spots, and only over one other peg
// After a peg has been jumped over, that peg is removed

package assignmentonejunkyard;

public class Puzzler {
	
	// Initialize the board variables
	private static final char PEG = 'X';
	private static final char EMPTY = 'O';
	private static final char NULL = ' ';
		
	// Initialize the direction variables
	private static final int RIGHT = 0;  // Corresponding to the index of the directions array
	private static final int LEFT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;
	private int[] direction = {RIGHT, LEFT, UP, DOWN};

	// Initialize various variables
	private int height;
	private int length;
	private static final int BOARD_SIZE = 7;
	private int pegs = 32;
	private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
	private int count = 1;
	private char start = board[3][3];
	
	
	 private Boarder b = new Boarder();
	 private Boarder [] solution = new Boarder[32];
	 
	 public Puzzler() {
         for (int i = 0; i < solution.length; i++) {
                 solution[i] = new Boarder();
         }
	 }

	
	// No-arg constructor that creates a square board with initial start position of pegs
//	public Puzzle() {
//		char[][] board = { 
//				{NULL,   NULL,   PEG,   PEG,   PEG,   NULL,   NULL},
//				{NULL,   NULL,   PEG,   PEG,   PEG,   NULL,   NULL},
//				{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
//				{PEG,    PEG,    PEG,   EMPTY, PEG,   PEG,    PEG},
//				{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
//				{NULL,   NULL,   PEG,   PEG,   PEG,   NULL,   NULL},
//				{NULL,   NULL,   PEG,   PEG,   PEG,   NULL,   NULL},
//			};
//		
//		height = board.length;
//		length = board.length;
//	}
	
	
	/** Method: Backtracking algorithm to solve the puzzle. Move current # of move - first move is 1 */
	public boolean findSolution(int move) {
		
		
		
		// Base Case - when there is one peg left and it is in the middle of the board
		if (start == 'X' && pegs == 1) {
			print();  // Print the board
			return true;
		
		// Else, recursively call the method until the base case is reached, using backtracking
		} else {
			
			for (int i = 0; i < board[board.length - 1].length; i++) {  // Loop the length of the board
			    for (int j = 0; j < board.length; j++) {  // Loop the height of the board
			        for (int k = 0; k < direction.length; k++) {  // Loop each direction possible to make a move
			        	
			        	
			        	
			        	// Backtracking?????? maybe
			        	if (findSolution(move + 1)) {
			        		return true;
			        	}
			        	
			        }
				}
			}    
			
//			findSolution(move + 1);
			
		}
		
		return false;
	}
	

	/** Method for printing the current situation of the board */
	public void print() {
		System.out.println("\nAnswer #" + count++);
	    for (int i = 0; i < BOARD_SIZE; i++) {
	      for (int j = 0; j < BOARD_SIZE; j++) {
	    	  
	        System.out.print((board[i][j] == j) ? 'X' : 'O');  // Used to be PEG : EMPTY);
	      }
	      System.out.println("|");
	    }
	}
	
	
	/** Main Method for starting the algorithm and printing solution */
	public static void main(String[] args) {
		Puzzler puzzle = new Puzzler();
		
		if (puzzle.findSolution(1)) {
			puzzle.print();
       
		} else {
            System.out.println("No solution found.");
		}

	}
			
	
}
