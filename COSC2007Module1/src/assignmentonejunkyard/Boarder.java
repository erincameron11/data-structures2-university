//	char[][] board = { 
//			{' ', ' ', 'X', 'X', 'X', ' ', ' '},
//			{' ', ' ', 'X', 'X', 'X', ' ', ' '},
//			{'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//			{'X', 'X', 'X', 'O', 'X', 'X', 'X'},
//			{'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//			{' ', ' ', 'X', 'X', 'X', ' ', ' '},
//			{' ', ' ', 'X', 'X', 'X', ' ', ' '},
//		};
	
//	char[][] board = { 
//	{' ', ' ', 'X', 'X', 'X', ' ', ' '},
//	{' ', ' ', 'X', 'X', 'X', ' ', ' '},
//	{'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//	{'X', 'X', 'X', 'O', 'X', 'X', 'X'},
//	{'X', 'X', 'X', 'X', 'X', 'X', 'X'},
//	{' ', ' ', 'X', 'X', 'X', ' ', ' '},
//	{' ', ' ', 'X', 'X', 'X', ' ', ' '},
//};


//int[][] board = {   {-1, -1, PEG, PEG, PEG, -1, -1},
//{-1, -1, PEG, PEG, PEG, -1, -1},
//{PEG, PEG, PEG, PEG, PEG, PEG, PEG},
//{PEG, PEG, PEG, EMPTY, PEG, PEG, PEG},
//{PEG, PEG, PEG, PEG, PEG, PEG, PEG},
//{-1, -1, PEG, PEG, PEG, -1, -1},
//{-1, -1, PEG, PEG, PEG, -1, -1} };

package assignmentonejunkyard;

public class Boarder {
	
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
	
	// Initialize the board
	char[][] board = { 
			{NULL,   NULL,   PEG,   PEG,   PEG,   NULL,   NULL},
			{NULL,   NULL,   PEG,   PEG,   PEG,   NULL,   NULL},
			{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
			{PEG,    PEG,    PEG,   EMPTY, PEG,   PEG,    PEG},
			{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
			{NULL,   NULL,   PEG,   PEG,   PEG,   NULL,   NULL},
			{NULL,   NULL,   PEG,   PEG,   PEG,   NULL,   NULL},
		};

	// Initialize the board height and length variables
	private int height = board.length;
	private int length = board.length;
	
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int[] getDirection() {
		return direction;
	}

	public void setDirection(int[] direction) {
		this.direction = direction;
	}
	
}
