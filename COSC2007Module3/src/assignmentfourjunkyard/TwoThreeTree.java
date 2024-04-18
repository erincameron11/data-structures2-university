package assignmentfourjunkyard;
// This is a part of the code for insertion. You could refer to it. You should not copy it to your submission (even you did, it would not work for you). Otherwise, you would get 0 mark.


//public class TwoThreeTree {
//	
//	public Node root;
//	public boolean inserted = false;
//
//
//	public void insert(Node currentNode, KeyedItem keyedItem) {
//		
//		if (currentNode == null) {
//			// reached leaf node: go back and process
//		} else {
//			// No large item means only 0 or 2 children
//			if(currentNode.getLargeItem() == null) {
//				if(currentNode.getSmallItem().getKey() > keyedItem.getKey()) {
//					insert(currentNode.getLeftChild(), keyedItem);
//				} else if (currentNode.getSmallItem().getKey() < keyedItem.getKey()) {
//					insert(currentNode.getMidChild(), keyedItem);
//				}
//			}
//			// There is a large item means 3 children
//			else
//			{
//				if(currentNode.getSmallItem().getKey() > keyedItem.getKey())
//				{
//					insert(currentNode.getLeftChild(), keyedItem);
//				}else if (currentNode.getSmallItem().getKey() < keyedItem.getKey() && currentNode.getLargeItem().getKey() > keyedItem.getKey())
//				{
//					insert(currentNode.getMidChild(), keyedItem);
//				}else
//				{
//					insert(currentNode.getRightChild(), keyedItem);
//				}
//			}
//
//			if(!inserted) {
//				// Found leaf node: currentNode
//				// Large Item doesn't exist
//				if (currentNode.getLargeItem() == null) {
//					if(currentNode.getSmallItem().getKey() > keyedItem.getKey()) {
//						currentNode.setLargeItem(currentNode.getSmallItem());
//						currentNode.setSmallItem(keyedItem);
//					} else if(currentNode.getSmallItem().getKey() < keyedItem.getKey()) {
//						currentNode.setLargeItem(keyedItem);
//					}
//				} // both small and large nodes exist: so 3 items in node: split
//				else {
//					split(currentNode, keyedItem);
//				}
//				inserted = true;
//			}
//		}
//	}
//
//	private void split(Node currentNode, KeyedItem keyedItem)
//	{
//		// if current is root
//		if(currentNode.getParentNode() == null) {
//			
//			if(currentNode.getSmallItem().getKey() > keyedItem.getKey()) {
//				Node left = new Node();
//				left.setParentNode(currentNode);
//				left.setSmallItem(keyedItem);
//				
//				if(currentNode.getLeftChild() != null)
//					currentNode.getLeftChild().setParentNode(left);
//				
//				left.setLeftChild(currentNode.getLeftChild());
//				
//				if(currentNode.getMidChild() != null)
//					currentNode.getMidChild().setParentNode(left);
//				
//				left.setMidChild(currentNode.getMidChild());
//				currentNode.setLeftChild(left);
//				Node right = new Node();
//				right.setParentNode(currentNode);
//				right.setSmallItem(currentNode.getLargeItem());
//				
//				if(currentNode.getRightChild() != null)
//					currentNode.getRightChild().setParentNode(right);
//				
//				right.setLeftChild(currentNode.getRightChild());
//				
//				if(currentNode.getTempChild() != null)
//					currentNode.getTempChild().setParentNode(right);
//				right.setMidChild(currentNode.getTempChild());
//				currentNode.setTempChild(null);
//				currentNode.setMidChild(right);
//
//				currentNode.setLargeItem(null);
//				currentNode.setRightChild(null);
//			
//			} else if(currentNode.getSmallItem().getKey() < keyedItem.getKey() && currentNode.getLargeItem().getKey() > keyedItem.getKey()) {
//				Node left = new Node();
//				left.setParentNode(currentNode);
//				left.setSmallItem(currentNode.getSmallItem());
//				if(currentNode.getLeftChild() != null)
//					currentNode.getLeftChild().setParentNode(left);
//				left.setLeftChild(currentNode.getLeftChild());
//				if(currentNode.getMidChild() != null)
//					currentNode.getMidChild().setParentNode(left);
//				left.setMidChild(currentNode.getMidChild());
//				currentNode.setLeftChild(left);
//
//				currentNode.setSmallItem(keyedItem);
//
//
//				Node right = new Node();
//				right.setParentNode(currentNode);
//				right.setSmallItem(currentNode.getLargeItem());
//				if(currentNode.getRightChild() != null)
//					currentNode.getRightChild().setParentNode(right);
//				right.setLeftChild(currentNode.getRightChild());
//				if(currentNode.getTempChild() != null)
//					currentNode.getTempChild().setParentNode(right);
//				right.setMidChild(currentNode.getTempChild());
//				currentNode.setTempChild(null);
//				currentNode.setMidChild(right);
//
//				currentNode.setLargeItem(null);
//				currentNode.setRightChild(null);
//			
//			} else if(currentNode.getLargeItem().getKey() < keyedItem.getKey()) {
//				Node left = new Node();
//				left.setParentNode(currentNode);
//				left.setSmallItem(currentNode.getSmallItem());
//				if(currentNode.getLeftChild() != null)
//					currentNode.getLeftChild().setParentNode(left);
//				left.setLeftChild(currentNode.getLeftChild());
//				if(currentNode.getMidChild() != null)
//					currentNode.getMidChild().setParentNode(left);
//				left.setMidChild(currentNode.getMidChild());
//				currentNode.setLeftChild(left);
//
//				currentNode.setSmallItem(currentNode.getLargeItem());
//				currentNode.setLargeItem(null);
//
//
//				Node right = new Node();
//				right.setParentNode(currentNode);
//				right.setSmallItem(keyedItem);
//				if(currentNode.getRightChild() != null)
//					currentNode.getRightChild().setParentNode(right);
//				right.setLeftChild(currentNode.getRightChild());
//				if(currentNode.getTempChild() != null)
//					currentNode.getTempChild().setParentNode(right);
//				right.setMidChild(currentNode.getTempChild());
//				currentNode.setTempChild(null);
//				currentNode.setMidChild(right);
//
//				currentNode.setRightChild(null);
//
//			}
//
//		// current is non root node and its parent has no large item
//		} else if(currentNode.getParentNode().getLargeItem() == null) {
//			if(currentNode.getSmallItem().getKey() > keyedItem.getKey()) {
//				Node rightmost = new Node();
//				rightmost.setParentNode(currentNode.getParentNode());
//				rightmost.setSmallItem(currentNode.getLargeItem());
//				rightmost.setLeftChild(currentNode.getRightChild());
//				currentNode.setRightChild(null);
//				rightmost.setMidChild(currentNode.getTempChild());
//				currentNode.setTempChild(null);
//				currentNode.getParentNode().setRightChild(rightmost);
//
//				currentNode.setLargeItem(null);
//				currentNode.getParentNode().setLargeItem(currentNode.getSmallItem());
//				currentNode.setSmallItem(keyedItem);
//
//			} else if(currentNode.getSmallItem().getKey() < keyedItem.getKey() && currentNode.getLargeItem().getKey() > keyedItem.getKey()) {
//				Node rightmost = new Node();
//				rightmost.setParentNode(currentNode.getParentNode());
//				rightmost.setSmallItem(currentNode.getLargeItem());
//				rightmost.setLeftChild(currentNode.getRightChild());
//				currentNode.setRightChild(null);
//				rightmost.setMidChild(currentNode.getTempChild());
//				currentNode.setTempChild(null);
//				currentNode.getParentNode().setRightChild(rightmost);
//
//				currentNode.setLargeItem(null);
//				currentNode.getParentNode().setLargeItem(keyedItem);
//
//			} else if(currentNode.getLargeItem().getKey() < keyedItem.getKey()) {
//				Node rightmost = new Node();
//				rightmost.setParentNode(currentNode.getParentNode());
//				rightmost.setSmallItem(keyedItem);
//				rightmost.setLeftChild(currentNode.getRightChild());
//				currentNode.setRightChild(null);
//				rightmost.setMidChild(currentNode.getTempChild());
//				currentNode.setTempChild(null);
//				currentNode.getParentNode().setRightChild(rightmost);
//
//				currentNode.getParentNode().setLargeItem(currentNode.getLargeItem());
//				currentNode.setLargeItem(null);
//			}
//		// the parent node has both small and large items
//		} else {
//			KeyedItem newKey = null;
//			if(currentNode.getSmallItem().getKey() > keyedItem.getKey()) {
//				Node temp = new Node();
//				temp.setParentNode(currentNode.getParentNode());
//				temp.setSmallItem(currentNode.getLargeItem());
//				temp.setLeftChild(currentNode.getRightChild());
//				currentNode.setRightChild(null);
//				temp.setMidChild(currentNode.getTempChild());
//				currentNode.setTempChild(null);
//				currentNode.getParentNode().setTempChild(temp);
//
//				currentNode.setLargeItem(null);
//
//				newKey = currentNode.getSmallItem();
//				currentNode.setSmallItem(keyedItem);
//
//			}
//			else if(currentNode.getSmallItem().getKey() < keyedItem.getKey() && currentNode.getLargeItem().getKey() > keyedItem.getKey()) {
//				Node temp = new Node();
//				temp.setParentNode(currentNode.getParentNode());
//				temp.setSmallItem(currentNode.getLargeItem());
//				temp.setLeftChild(currentNode.getRightChild());
//				currentNode.setRightChild(null);
//				temp.setMidChild(currentNode.getTempChild());
//				currentNode.setTempChild(null);
//				currentNode.getParentNode().setTempChild(temp);
//
//				currentNode.setLargeItem(null);
//
//				newKey = keyedItem;
//
//			}
//			else if(currentNode.getLargeItem().getKey() < keyedItem.getKey()) {
//				Node temp = new Node();
//				temp.setParentNode(currentNode.getParentNode());
//				temp.setSmallItem(keyedItem);
//				temp.setLeftChild(currentNode.getRightChild());
//				currentNode.setRightChild(null);
//				temp.setMidChild(currentNode.getTempChild());
//				currentNode.setTempChild(null);
//				currentNode.getParentNode().setTempChild(temp);
//
//
//				newKey = currentNode.getLargeItem();
//				currentNode.setLargeItem(null);
//			}
//			//recursive call
//			split(currentNode.getParentNode(), newKey);
//		}
//	}
//
//}