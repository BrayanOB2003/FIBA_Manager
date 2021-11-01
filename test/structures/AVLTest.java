package structures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AVLTest {

	AVLNode<String, Integer> avl;
	AVLTree<String, Integer> avlTree;
	ArrayList <Integer> indices;
	
	public void setup1() {
		avl = new AVLNode<String, Integer>(null, null, null);
	}
	
	public void setup2() {
		avl = new AVLNode<String, Integer>(null, null, null);
		avl.add("9",6);
		avl.add("10",7);
		avl.add("5", 2);
		avl.add("7", 4);
		avl.add("8", 5);
		avl.add("6", 3);
		avl.add("1", 1);
	}
	public void setup3() {
		avl = new AVLNode<String, Integer>(null, null, null);
		avl.add("20", 2);
		avl.add("15", 3);
		avl.add("22", 1);
	}
	@Test
	void test() {
		avlTree = new AVLTree<String, Integer>();
		setup1();
		assertNotNull(avlTree.getRoot()==null,"it's null");
	}
	
	
	void test4() {
		setup3();
		assertNotNull(avlTree.searchNode("15"),"it is null");
		assertNotNull(avlTree.searchNode("22"),"it is null");
		assertEquals(avlTree.searchNode("20"),avlTree.getRoot().getRight().getKey());
	}
}