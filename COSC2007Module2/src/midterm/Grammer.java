package midterm;

public class Grammer {

	public static boolean isLang(String s) {
		
		// Base Case
		if (s.length() == 0)
			return false;
		
		else if (s.charAt(0) == 'a' && s.charAt(s.length() - 1) == 'b') 
			return isLang(s.substring(1, s.length() - 1));
		
		else if (s.charAt(0) == 'c' && s.length() == 1) 
			return true;
		
		else
			return false;
	}
	
	public static void main(String[] args) {
		
		String s = "aaacbbb";
		System.out.println(isLang(s));
	}

}
