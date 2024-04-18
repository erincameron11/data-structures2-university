package assignmentonejunkyard;

import java.util.Arrays;

public class BoardState {
        
        private static final char PEG = 'X';
        private static final char EMPTY = 'O';
        private static final char NONE = ' ';

        private static final int RIGHT = 0;
        private static final int TOP = 1;
        private static final int LEFT = 2;
        private static final int BOTTOM = 3;
        
        private static int [] directions = {RIGHT, TOP, LEFT, BOTTOM};
        
        public int [] [] board = {
        		{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
    			{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
    			{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
    			{PEG,    PEG,    PEG,   EMPTY, PEG,   PEG,    PEG},
    			{PEG,    PEG,    PEG,   PEG,   PEG,   PEG,    PEG},
    			{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
    			{NONE,   NONE,   PEG,   PEG,   PEG,   NONE,   NONE},
//                        {0, 0, 1, 1, 1, 0, 0},
//                        {0, 0, 1, 1, 1, 0, 0},
//                        {1, 1, 1, 1, 1, 1, 1},
//                        {1, 1, 1, 2, 1, 1, 1},
//                        {1, 1, 1, 1, 1, 1, 1},
//                        {0, 0, 1, 1, 1, 0, 0},
//                        {0, 0, 1, 1, 1, 0, 0}
        };

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
        
        
        public void print() {
        	for (int x = 0; x < board.length; x++) {
        		for (int y = 0; y < board.length; y++) {
        			System.out.print((char)board[x][y] + " ");
        		}
        		System.out.println();
        	}
        	System.out.println();
        }
        
        public boolean isPeg(int x, int y) {
                return board[x][y] == PEG;
        }

}
