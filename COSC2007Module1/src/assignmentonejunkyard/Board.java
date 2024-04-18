package assignmentonejunkyard;

public class Board {
	
	// Initialize the board variables
	private static final char PEG = 'X';
	private static final char EMPTY = 'O';
	private static final char NONE = ' ';
	
	// Initialize the direction variables
	private static final int RIGHT = 0;  // Corresponding to the index of the directions array
	private static final int LEFT = 1;
	private static final int UP = 2;
	private static final int DOWN = 3;
	public int[] direction = {RIGHT, LEFT, UP, DOWN};
	
	// Initialize the board
	char[][] board = { 
			{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
			{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
			{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
			{PEG,    PEG,    PEG,   EMPTY, PEG,   PEG,    PEG},
			{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
			{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
			{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
		};

	// Initialize the board height and length variables
	private int height = board.length;
	private int length = board.length;
	
	
	public int getHeight() {
		return height;
	}
	
	public int getLength() {
		return length;
	}

	public void setPeg(int x, int y) {
		board[x][y] = PEG;
	}
	
	public void setEmpty(int x, int y) {
		board[x][y] = EMPTY;
	}
	
	public boolean isEmpty(int x, int y) {
		return board[x][y] == EMPTY;
	}
	
	public boolean isPeg(int x, int y) {
		return board[x][y] == PEG;
	}
	
	
	/** Method to check if a move is a legal move */
	public boolean checkMove(int x, int y, int direction) {
		
		switch (direction) {
		case RIGHT: 
			if (isPeg(x, y)
				&& x <= 4
				&& x >= 0
				&& isPeg(x + 1, y) 
				&& isEmpty(x + 2, y)) {
				
				return true;
			}
			break;
		
		case LEFT: 
			if (isPeg(x, y)
				&& x >= 2
				&& x <= getLength() - 1 
				&& isPeg(x - 1, y) 
				&& isEmpty(x - 2, y)) {
				
				return true;
			}
			break;
			
		case UP:
			if (isPeg(x, y)
				&& y >= 2
				&& y >= getHeight() - 1
				&& isPeg(x, y - 1) 
				&& isEmpty(x, y - 2)) {
				
				return true;
			}
			break;
		
		case DOWN:
			if (isPeg(x, y)
				&& y <= 4
				&& y >= 0
				&& isPeg(x, y + 1) 
				&& isEmpty(x, y + 2)) {
				
				return true;
			}
			break;
		}		
			
		return false;
                 
	 }
	 
	
	/** Method to change the direction of the X movement */
	public int getNewXDirection(int x, int direction) {
		
		if (direction == 0) {
			x -= 2;
			return x;
		} else {
			x += 2;
			return x;
		}
		
	}
	
	/** Method to change the direction of the Y movement */
	public int getNewYDirection(int y, int direction) {
					
		if (direction == 2) {
			y -= 2;
			return y;
		} else {
			y += 2;
			return y;
		}
				
	}
	
	
	/** Method to make a move on the board */
	public boolean makeMove(int x, int y, int direction) {
		
		switch (direction) {
		case RIGHT: 
			setEmpty(x, y); 
			setEmpty(x + 1, y);
			setPeg(x + 2, y);
			System.out.println("right");
			return true;
		case LEFT:
			setEmpty(x, y); 
			setEmpty(x - 1, y);
			setPeg(x - 2, y);
			System.out.println("left");
			return true;
		case UP:
			setEmpty(x, y); 
			setEmpty(x, y - 1);
			setPeg(x, y - 2);
			System.out.println("up");
			return true;
		case DOWN:
			setEmpty(x, y); 
			setEmpty(x, y + 1);
			setPeg(x, y + 2);
			System.out.println("down");
			return true;
		
		}	
		return false;
	}
	
	
	/** Method to reverse a move on the board */
	public void reverseMove(int x, int y, int direction) {
		
		switch (direction) {
			case RIGHT: 
				setPeg(x, y); 
				setPeg(x + 1, y);
				setEmpty(x + 2, y);
				System.out.println("rightrev");
				break;  
			case LEFT:
				setPeg(x, y); 
				setPeg(x - 1, y);
				setEmpty(x - 2, y);
				System.out.println("leftrev");
				break;
			case UP:
				setPeg(x, y); 
				setPeg(x, y - 1);
				setEmpty(x, y - 2);
				System.out.println("uprev");
				break;
			case DOWN:
				setPeg(x, y); 
				setPeg(x, y + 1);
				setEmpty(x, y + 2);
				System.out.println("downrev");
				break;
		}
	}
	
	
	/** Method to print the board */
	public void print() {
        for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board.length; y++) {
                        System.out.print(board[x][y] + " ");
                }
                System.out.println();
        }
        System.out.println();
	}
	
	
	 public void copyBoard(Board source, Board target) {
         for (int x = 0; x < getLength(); x++) {
        for (int y = 0; y < getHeight(); y++) {
                    target.board[x][y] = source.board[x][y];
            }
         }
 }
	
}
