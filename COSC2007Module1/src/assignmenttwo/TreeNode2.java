package assignmenttwo;

public class TreeNode2 {

	private char key;
	private int count;
	private TreeNode2 left, right;
	
	// 1-arg Constructor
	TreeNode2(char ch) {
		// Make sure the character is in lowercase format
		key = java.lang.Character.toLowerCase(ch);
		count = 1;
		left = null;
		right = null;
	}

	public char getKey() {
		return key;
	}

	public void setKey(char ch) {
		key = ch;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public TreeNode2 getLeft() {
		return left;
	}

	public void setLeft(TreeNode2 left) {
		this.left = left;
	}

	public TreeNode2 getRight() {
		return right;
	}

	public void setRight(TreeNode2 right) {
		this.right = right;
	}
	
}
