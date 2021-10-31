package structures;

import java.util.LinkedList;

public class BST<K extends Comparable<K>,V> implements BSTInterface<K, V> {
	
	private BSTNode<K,V> root;
	private int size;
	
	public BST() {
		size = 0;
		
	}

	@Override
	public boolean add(K k, V v) {
		if (root == null)
		{
			root = new BSTNode<>(k,v);
			size++;
			return true;
		}else
		{
			boolean status = root.add(k, v);
			if (status)
			{
				size++;
				return true;
			}else
			{
				return false;
			}
		 
		}
	}

	@Override
	public boolean remove(K k) {
		if (root == null)
		{
			return false;
		}else
		{
			if (root.getKey().equals(k))
			{
				if (root.getRight() == null && root.getLeft() == null)
				{
					root = null;
					size--;
					return true;
				}else
				{
					if (root.getRight() == null)
					{
						root = root.getLeft();
						size--;
						return true;
					}else
					{
						BSTNode<K,V> aux = root.getSuccesor();
						if (aux.getParent().getLeft() == aux) aux.getParent().setLeft(null);
						else aux.getParent().setRight(null);
						
						
						aux.setLeft(root.getLeft());
						aux.setRight(root.getRight());
						aux.getRight().setParent(aux);
						aux.getLeft().setParent(aux);
						
						root = aux;
						size--;
						return true;
					}
				}
			}else
			{
				boolean status = root.remove(k);
				if (status) size--;
				
				return status;
			}
		}
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) return true;
		return false;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean keyExists(K k) {
		if (search(k) == null) return false;
		return true;
	}

	@Override
	public BSTNode<K, V> searchNode(K k) {
		if (root == null) return null;
		else return root.search(k);	
	}
	
	public LinkedList<V> searchByRange(K kStart, K kEnd)
	{
		if (root == null) return null;
		else return root.searchByRange(kStart,kEnd);
	}

	@Override
	public V search(K k) {
		BSTNode<K,V> aux = searchNode(k);
		
		if (aux != null)
		{
			return aux.getValue();
		}
		return null;
	}

	public BSTNode<K, V> getRoot() {
		return root;
	}

	public void setRoot(BSTNode<K, V> root) {
		this.root = root;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
}
