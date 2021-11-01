package structures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BSTTest {

	BST<String, Integer> bst;
	ArrayList <Integer> indices;
	
	public void setup1() {
		bst = new BST<>();
		indices=new ArrayList <Integer>();
	}
	public void setup2() {
		bst = new BST<>();
		bst.add("20", 2);
		bst.add("15", 3);
		bst.add("22", 1);
	}
	public void setup3() {
		setup1();
		bst.add("20", 1);
		bst.add("20", 2);
		bst.add("20", 3);
		bst.add("20", 4);
		bst.add("20", 5);
	}
	public void setup4() {
		setup1();
		bst.add("20", 1);
		bst.add("20", 2);
		bst.add("14", 3);
		bst.add("16", 4);
		bst.add("12", 5);
	}
	public void setup5() {
		bst = new BST<>();
		bst.add("6", 6);
		bst.add("5", 5);
		bst.add("4", 4);
		bst.add("3", 3);
		bst.add("2", 2);
		bst.add("1", 1);
	}	
	
	@Test
	void test1() {
		setup1();
		String key = "20";
		int value = 1;
		bst.add(key, value);
		
		assertNotNull(bst.getRoot(),"It is null");
	}
	
	@Test
	void test2() {
		setup2();
		assertNotNull(bst.getRoot().getLeft(),"It is null");
		assertNotNull(bst.getRoot().getRight(),"It is null");
		
	}

	@Test
	void test3() {
		setup4();
		assertNotNull(bst.getRoot(),"It is null");
	}

}