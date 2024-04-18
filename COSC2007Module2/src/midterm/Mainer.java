package midterm;

import java.util.Stack;

public class Mainer {
    public static boolean isOperator(char ch){
        if(ch=='+' || ch=='-'|| ch=='*' || ch=='/' || ch=='^'){
            return true;
        }
        return false;
    }
    public static Node expressionTree(String postfix){
        Stack<Node> st = new Stack<Node>();
        Node t1,t2,temp;
 
        for(int i=0;i<postfix.length();i++){
            if(!isOperator(postfix.charAt(i))){
                temp = new Node(postfix.charAt(i));
                st.push(temp);
            }
            else{
                temp = new Node(postfix.charAt(i));
 
                t1 = st.pop();
                t2 = st.pop();
 
                temp.left = t1;
                temp.right = t2;
 
                st.push(temp);
            }
 
        }
        temp = st.pop();
        return temp;
    }
    
    
    public static void inorder(Node root){
        if(root==null) return;
 
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    
    /** Method to print the data out in pre-order format (ROOT - LEFT - RIGHT) */
	public static void preorder(Node root) {
		
		// Recursively call the root, then left, then right
		if (root != null) {  // If the tree isn't empty
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
		
	}
    
	private static final int COUNT = 5;
	public static void print2DUtil(Node root, int space)
	{
	    // Base case
	    if (root == null)
	        return;
	 
	    // Increase distance between levels
	    space += COUNT;
	 
	    // Process right child first
	    print2DUtil(root.right, space);
	 
	    // Print current node after space
	    // count
	    System.out.print("\n");
	    for (int i = COUNT; i < space; i++)
	        System.out.print(" ");
	    System.out.print(root.data + "\n");
	 
	    // Process left child
	    print2DUtil(root.left, space);
	}
	 
	// Wrapper over print2DUtil()
	static void print2D(Node root)
	{
	    // Pass initial space count as 0
	    print2DUtil(root, 0);
	}
    
    public static void main(String[] args) {
        String postfix = "FGHJK/-*+";
 
        Node r = expressionTree(postfix);
//        inorder(r);
        
        preorder(r);
        
        print2D(r);
    }   
}