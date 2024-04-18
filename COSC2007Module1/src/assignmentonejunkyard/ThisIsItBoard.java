package assignmentonejunkyard;

public class ThisIsItBoard {

	private static final int PEG = 1;  // X
	private static final int EMPTY = 0;  // O
	private static final int NONE = 9;  // blank
	
	public int[][] board = { 
				{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
				{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
				{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
				{PEG,    PEG,    PEG,   EMPTY, PEG,   PEG,    PEG},
				{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
				{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
				{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
			};
	
	public int length = board.length;
	
	public boolean isPeg(int x, int y) {
		return board[x][y] == PEG;
	}
	
	public boolean isEmpty(int x, int y) {
		return board[x][y] == EMPTY;
	}
	
	public void setEmpty(int x, int y) {
		board[x][y] = EMPTY;
	}
	
	public void setPeg(int x, int y) {
		board[x][y] = PEG;
	}
	
	public void makeMove(int x, int y, int direction) {
		System.out.println("make");
		switch (direction) {
			case 0: 
				setEmpty(x, y); 
				setEmpty(x + 1, y);
				setPeg(x + 2, y);
				System.out.println("right");
				break;
			case 1:
				setEmpty(x, y); 
				setEmpty(x - 1, y);
				setPeg(x - 2, y);
				System.out.println("left");
				break;
			case 2:
				setEmpty(x, y); 
				setEmpty(x, y - 1);
				setPeg(x, y - 2);
				System.out.println("up");
				break;
			case 3:
				setEmpty(x, y); 
				setEmpty(x, y + 1);
				setPeg(x, y + 2);
				System.out.println("down");
				break;
		}
	}
	
	
	public void reverseMove(int x, int y, int direction) {
		System.out.println("reverse");
//		switch (direction) {
//			case 0: 
//				setPeg(x, y); 
//				setPeg(x + 1, y);
//				setEmpty(x + 2, y);
//				System.out.println("rightrev");
//				break;
//			case 1:
//				setPeg(x, y);
//				setPeg(x - 1, y);
//				setEmpty(x - 2, y);
//				System.out.println("left");
//				break;
//			case 2:
//				setPeg(x, y); 
//				setPeg(x, y - 1);
//				setEmpty(x, y - 2);
//				System.out.println("up");
//				break;
//			case 3:
//				setPeg(x, y); 
//				setPeg(x, y + 1);
//				setEmpty(x, y + 2);
//				System.out.println("down");
//				break;
//		}
	}
	
	public void print() {
      for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board.length; y++) {
				if (board[x][y] == 1) {
          		System.out.print('X' + " ");
          	} else if (board[x][y] == 0) {
          		System.out.print('O' + " ");
          	} else if (board[x][y] == 9) {
          		System.out.print(' ' + " ");
          	}
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
