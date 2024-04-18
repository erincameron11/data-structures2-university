package midterm;

public class BTNode {

	Node root;
	
	public class Node {
		private int data;
		private BTNode left;
		private BTNode right;
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			left = null;
			right = null;
		}
		
//		public Node(int data) {
//			this.data = data;
//			left = null;
//			right = null;
//		}
	}
	
	
//	public int numChildren(Node root) {
//		
//		if (root == null) 
//			return 0;
//		
//		
//		return numChildren(root.left) + numChildren(root.right) + 1;
//	}
//	
//	
//	public int numTwoChildren(Node root) {
//	    // Base Case for the recursion if the root is null
//		if(root == null) {
//	        return 0;
//	    }
//	    
//	    // If both the left and right children exist and are not null, then add one to right & left
//	    if(root.left != null && root.right != null) {
//	        return numTwoChildren(root.left) + numTwoChildren(root.right) + 1;
//	    } else {
//	    	return numTwoChildren(root.left) + numTwoChildren(root.right);
//	    }
//	}
	
	public static void main(String[] args) {
//		Node tree = new Node();
		
	}
	
}
