package queenseight;

public class QueensEight {
	 
	  private static int[] board = new int[8];
	  private static int s = 0;
	 
	  static boolean unsafe(int y) {
	    int x = board[y];
	    for (int i = 1; i <= y; i++) {
	      int t = board[y - i];
	      if (t == x ||
	          t == x - i ||
	          t == x + i) {
	        return true;
	      }
	    }
	 
	    return false;
	  }
	 
	  public static void putboard() {
	    System.out.println("\n\nSolution " + (++s));
	    for (int y = 0; y < 8; y++) {
	      for (int x = 0; x < 8; x++) {
	        System.out.print((board[y] == x) ? "|Q" : "|_");
	      }
	      System.out.println("|");
	    }
	  }
	 
	  public static void main(String[] args) {
	    int y = 0;
	    board[0] = -1;
	    while (y >= 0) {
	      do {
	    	  board[y]++;
	      } while ((board[y] < 8) && unsafe(y));
	      if (board[y] < 8) {
	        if (y < 7) {
	        	board[++y] = -1;
	        } else {
	          putboard();
	        }
	      } else {
	        y--;
	      }
	    }
	  }
	}