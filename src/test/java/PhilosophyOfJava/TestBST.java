package PhilosophyOfJava;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBST {

	@Test
	public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
	   BST bt = createBinaryTree();
	   Assert.assertEquals(bt.containsNode(9), true, "bst contains 9 but failed to search");
	   bt.delete(9);
	   Assert.assertEquals(bt.containsNode(9), false, "bst contains 9 but it is removed");
	   bt.traversePostOrder(bt.root);
	   bt.traverseLevelOrder();
	}
	    
	private BST createBinaryTree() {
	    BST bt = new BST();
	 
	    bt.add(6);
	    bt.add(4);
	    bt.add(8);
	    bt.add(3);
	    bt.add(5);
	    bt.add(7);
	    bt.add(9);
	 
	    return bt;
	}

}
