package ui;

import structures.AVLNode;
import structures.AVLTree;

public class MainTest {
			
	public static void main(String[] args) {
		AVLTree<Integer, String> t = new AVLTree<Integer,String>();
		t.add(1, "p");
		t.add(2, "e");
		
		System.out.println(t.getRoot().getValue());
	}
}
