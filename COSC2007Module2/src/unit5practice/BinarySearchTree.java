package unit5practice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

//this will be used for an activity for students to use as a starting point
//as well as directing students what the need to implement
public class BinarySearchTree {

  //private inner class implementation of a node
  //this is a useful implementation as only the BinarySearchTree
  //will be able to use it
  private class Node {

      //since the class is private the data members do not need to be
      int item;
      Node left;
      Node right;

      //constructor
      public Node(int item, Node left, Node right){
          this.item = item;
          this.left = left;
          this.right = right;
      }

      //secondary constructor for making leaf nodes
      public Node(int item){
          this.item = item;
          this.left = null;
          this.right = null;
      }

      //setters and getters are not needed as the tree can see the nodes
      //data members
  }

  //start of the tree implementation

  private Node root;

  //constructor
  public BinarySearchTree(int item){
      this.root = new Node(item);
  }

  //constructor
  public BinarySearchTree(){
      root = null;
  }


  //insert
  public void insert(int item){
      if(this.root == null){
          root = new Node(item);
          return;
      }

      //calls method that handles the insertion
      insertCore(new Node(item), this.root);
  }

  private void insertCore(Node node, Node current){

      //needs to be done recursively
      //checks for general cases first then base case

      //item is less than or equal to current nodes item
      if(current.item >= node.item){
          //general case
          if(current.left != null){
              insertCore(node, current.left);
          }
          //base case
          else{
              current.left = node;
          }
      }
      //item is greater than too current nodes item
      else{
          //general case
          if(current.right != null){
              insertCore(node, current.right);
          }
          //base case
          else{
              current.right = node;
          }
      }
  }


  //post-order traversal
  public void postOrder(){
      post(this.root);
  }

  private void post(Node node){
      if(node != null) {
          System.out.println(node.item);
          post(node.left);
          post(node.right);
      }
  }


  //####################################################
  //this is where students need to begin implementation
  //####################################################

  //pre-order traversal
  //implementation should print out contents of nodes similar to the post-order shown
  public void preOrder(Node root){
	// Recursively call the root, then left, then right
	if (root != null) {  // If the tree isn't empty
		System.out.print(root.item + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
  }

  //in-order travesal
  //implementation should print out contents of nodes similar to the post-order shown
  public void inOrder(Node root){
	// Recursively call left and right with root data in the middle
	if (root != null) {  // If the tree isn't empty
		inOrder(root.left);
		System.out.print(root.item + " ");
		inOrder(root.right);
	}
  }

  //save BST to a file
  // Save in preorder format (root first)
  public void saveBST(String fileName, PrintWriter pw) throws FileNotFoundException{
	  if (root != null) {  // If the tree isn't empty
		  
		  pw.write(root.item + " ");
		  preOrder(root.left);
		  preOrder(root.right);
	  }
  }

  //restore BST from a file
  //should restore as a balanced BST preferably
  public BinarySearchTree restoreBST(String fileName){
	return null;

  }
  
  public static void main(String[] args) throws FileNotFoundException {
	 
	  BinarySearchTree tree = new BinarySearchTree();
	  
//	  File file = new File("test.txt");

	  PrintWriter pw = new PrintWriter(new File("test.txt"));
	  
//	  pw.write(tree.saveBST("test.txt", pw) + "");
	  tree.saveBST("test.txt", pw);
	  
	  pw.flush();
	  
	  pw.close();
	  
//	  tree.saveBST("test.txt", pw);
	  
  }
}