package PhilosophyOfJava;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
	
	Node root;
	public boolean containsNode(int value) {
	    return containsNodeRecursive(root, value);
	}
	
	public void traverseLevelOrder() {
	    if (root == null) {
	        return;
	    }
	 
	    Queue<Node> nodes = new LinkedList<>();
	    nodes.add(root);
	 
	    while (!nodes.isEmpty()) {
	 
	        Node node = nodes.remove();
	 
	        System.out.print(" " + node.value);
	 
	        if (node.left != null) {
	            nodes.add(node.left);
	        }
	 
	        if (node.right!= null) {
	            nodes.add(node.right);
	        }
	    }
	}
	
	
	public void traversePostOrder(Node node) {
	    if (node != null) {
	        traversePostOrder(node.left);
	        traversePostOrder(node.right);
	        System.out.print(" " + node.value);
	    }
	}
	public void delete(int value) {
	    root = deleteRecursive(root, value);
	}
	private int findSmallestValue(Node root) {
	    return root.left == null ? root.value : findSmallestValue(root.left);
	}	
	
	
	private Node deleteRecursive(Node current, int value) {
		if(current == null) {
			return null;
		}
		if(value ==current.value) {
			if (current.left == null && current.right == null) {
			    return null;
			}
			if (current.right == null) {
			    return current.left;
			}
			 
			if (current.left == null) {
			    return current.right;
			}
			int smallestValue = findSmallestValue(current.right);
			current.value = smallestValue;
			current.right = deleteRecursive(current.right, smallestValue);
			return current;
			
		}
		if(value< current.value) {
			deleteRecursive(current.left,value);
			return current;
		}
		 current.right = deleteRecursive(current.right, value);
	        return current;
	}
	

	private boolean containsNodeRecursive(Node current, int value) {
		if(current == null) {
			return false;
		}
		if(value == current.value) {
			return true;
		}
		if(value < current.value) {
			return containsNodeRecursive(current.left,value);
			
		} 
		if(value > current.value) {
			return containsNodeRecursive(current.right, value) ;
		}
		return false;
	}


	public void add(int value) {
	    root = addRecursive(root, value);
	}
	
	private Node addRecursive(Node current, int value) {
	    if (current == null) {
	        return new Node(value);
	    }
	 
	    if (value < current.value) {
	        current.left = addRecursive(current.left, value);
	    } else if (value > current.value) {
	        current.right = addRecursive(current.right, value);
	    } else {
	        // value already exists
	        return current;
	    }
	 
	    return current;
	}
	
	
	
	class Node{
		int value;
		Node left;
		Node right;
		
		Node(int value){
			this.value= value;
			right = null;
			left = null;
			
		}
		
	}

}
