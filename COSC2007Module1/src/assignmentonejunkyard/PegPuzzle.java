package assignmentonejunkyard;

public class PegPuzzle {
 
//	private BoardState board = new BoardState();
	private BoardState[] answers = new BoardState[32];
    private static final char PEG = 'X';
    private static final char EMPTY = 'O';
    private static final char NONE = ' ';
    private static final int RIGHT = 0;
    private static final int TOP = 1;
    private static final int LEFT = 2;
    private static final int BOTTOM = 3;
	private int[] directions = {RIGHT, TOP, LEFT, BOTTOM};
	private static final int BOARD_SIZE = 7;
	private static final char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
	
	// Constructor - to pre-populate the solution boards as the initialized state (to be overwritten), and to initialize the board
	public PegPuzzle() {
		char[][] board = {	{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
			    			{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
			    			{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
			    			{PEG,    PEG,    PEG,   EMPTY, PEG,   PEG,    PEG},
			    			{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
			    			{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
			    			{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE} 
			    		};
		
		for (int i = 0; i < answers.length; i++) {
			answers[i] = new BoardState();
		}
	}
    
	
//	public boolean findSolution(int move) {
//		for (int x = 0; move <= 31 && x < board.length; x++) {
//			for (int y = 0; y < board.length; y++) {
//                            	
//				for (int direction : directions) {
//					if (board.jump(x, y, direction)) {
//						board.copyBoard(board, answers[move]);
//						
//						if (! (move == 31 && board.isPeg(3, 3))) {  // If it is not done
//							if (findSolution(move + 1)) {
//								return true;
//							} else {
//								board.jumpBack(x, y, direction);
//							}
//						} else {
//							return true;
//						}
//					}
//				}
//			}                       
//		}
//                    
//		return false;
//	}
    
            
	public void print() {
		
		for (int x = 0; x < board.length; x++) {
    		for (int y = 0; y < board.length; y++) {
    			System.out.print((char)board[x][y] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
		
		for (int i = 0; i < answers.length; i++) {
			answers[i].print();
		}
	}

//	
//	/** Main Method */
//	public static void main(String[] args) {
//		PegPuzzle puzzle = new PegPuzzle();
//		
//		// Move starts with 1
//		boolean found = puzzle.findSolution(1);
//    
//		// If found, print out the answer boards
//		if (found) {
//			System.out.println("Solution found.");
//			puzzle.print();
//			
//		// Else, if no solution is found
//		} else {
//			System.out.println("No solution was found.");
//		}
//	}
//	
//	
	
	
	
	
	
	
	public int getWidth() {
        return board.length;
	}

	public int getHeight() {
        return board.length;
	}

	public void clearField(int x, int y) {
        board[x][y] = EMPTY;
	}

	public void setPeg(int x, int y) {
        board[x][y] = PEG;
	}


	public void copyBoard(BoardState source, BoardState target) {
        for (int x = 0; x < getWidth(); x++) {
       for (int y = 0; y < getHeight(); y++) {
                   target.board[x][y] = source.board[x][y];
           }
        }
	}

	private boolean isValidMove(int x, int y, int newX, int newY) {
        return 0 <= x && x < board.length 
                && 0 <= y && y < board[x].length
                && 0 <= newX && newX < board.length 
                && 0 <= newY && newY < board[newX].length
                && board[newX][newY] == EMPTY
                && board[(x + newX) / 2][(y + newY) / 2] == PEG
                && board[x][y] == PEG;
	}

	public boolean jump(int x, int y, int direction) {
        int newX = getNewX(x, direction);
        int newY = getNewY(y, direction);

        if ( isValidMove(x, y, newX, newY)) {
                setPeg(newX, newY);
                clearField(x, y);
                clearField((x + newX) / 2, (y + newY) / 2);
                
                return true;
        }
        
        return false;
	}


	public void jumpBack(int x, int y, int direction) {
        int newX = getNewX(x, direction);
        int newY = getNewY(y, direction);
        
        clearField(newX, newY);
        setPeg(x, y);
        setPeg((x + newX) / 2, (y + newY) / 2);
	}

	private int getNewX(int x, int direction) {
        int newX = x;
        switch (direction) {
            case RIGHT: newX += 2;
                        break;
            case LEFT: newX -= 2;
        }
        return newX;
	}

	private int getNewY(int y, int direction) {
        int newY = y;
        
        switch (direction) {
        case TOP: newY -= 2;
                        break;
        case BOTTOM: newY += 2;
        }
        
        return newY;
	}

}