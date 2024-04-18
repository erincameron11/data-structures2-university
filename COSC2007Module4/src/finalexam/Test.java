package finalexam;

public class Test {
	
    public static int f(int n) {
	    if (n < 2)
	       return n;
	    
	    return f(n - 1) + (2 * f(n - 2));
    }
    
	public static void main(String[] args) {
		System.out.println(f(9));

	}

}
