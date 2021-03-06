package structures;

import java.util.LinkedList;

public class BSTNode<K extends Comparable<K>,V> {

	private BSTNode<K,V> parent,left,right;
	private K key;
	private V value;
	private int BalanceFactor;
	private AVLTree<K,V> owner;

	
	public BSTNode(K k, V v) {
		value = v;
		key = k;
		BalanceFactor = 0;
	
	}
	
	public BSTNode(K k, V v,boolean a) {
		value = v;
		key = k;
		BalanceFactor = 0;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean add(K k ,V v)
	{
			if (key.compareTo(k) < 0)
			{
				if (right == null) 
				{
					 right = new BSTNode<K,V>(k,v);
					
					right.setParent(this);
					
					return true;
				}else
				{
					boolean status =  right.add(k, v);
					
					return status;
				}
			}else
			{
				if (left == null)
				{
					
					left = new BSTNode<K,V>(k,v);
					left.setParent(this);
					
					return true;
				}else
				{
					boolean status = left.add(k, v);
					
					return status;
				}
			}
		
	}
	
	
	public boolean remove(K k)
	{
		if (key.compareTo(k) > 0)
		{
			if (left != null)
			{
				if (left.key.equals(k))
				{
					boolean status = removeLeft();
					
					return status;
				}
				else
				{
					boolean status = left.remove(k);
					
					return status;
						
				}
			}else
			{
				return false;
			}
		}else if (key.compareTo(k)< 0)
		{
			
			if (right != null)
			{
				if (right.key.equals(k))
				{
					boolean status = removeRight();
					
					return status;
				}
				else
				{
					boolean status = right.remove(k);
					
					return status;
				}
			}else
			{
				return false;
			}
		}
		return false;
	}
	
	
	
	private boolean removeLeft()
	{
		if (left.right == null && left.left == null)
		{
			left = null;
		}else
		{
			BSTNode<K,V> aux = left.getSuccesor();
			if (aux.parent.left == aux) parent.left = null;
			else aux.parent.right = null;
			
			aux.left = left.left;
			if (left.left != null)left.left.parent = aux;
			
			aux.right = left.right;
			if (left.right != null) left.right.parent = aux;
			
			aux.parent = this;
			left = aux;
		}
		
		return true;
		
	}
	
	public boolean removeRight()
	{
		if (right.right == null && right.left == null)
		{
			right = null;
		}else
		{
			BSTNode<K,V> aux = right.getSuccesor();
			if (aux.parent.left == aux) parent.left = null;
			else aux.parent.right = null;
			
			aux.left = right.left;
			if (right.left != null) right.left.parent = aux;
			
			aux.right = right.right;
			if (right.right != null) right.right.parent = aux;
			
			aux.parent = this;
			right = aux;
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	public BSTNode<K,V> getSuccesor()
	{
		if (right != null)
		{
			return right.getMinChild();
		}else
		{
			return left;
		}
	}
	
	public BSTNode<K,V> getMinChild()
	{
		if (left == null) return this;
		else return left.getMinChild();
	}
	
	public BSTNode<K,V> search(K k)
	{
		if (key.equals(k))
		{
			return this;
			
		}else
		{
			if (key.compareTo(k)<0)
			{
				if (right == null)
				{
					return null;
				}else
				{
					return right.search(k);
				}
			}else
			{
				if (left == null)
				{
					return null;
				}else
				{
					return left.search(k);
				}
			}
		}
	}
	
	public LinkedList<V> searchByRange(K kStart, K kEnd)
	{
		LinkedList<V> temp = new LinkedList<>();
		
		if(kStart.compareTo(key)<0)
		{
			if (left != null)
			{
				temp.addAll(left.searchByRange(kStart,kEnd));
			}
		}
		
		if(kStart.compareTo(key)<=0&&kEnd.compareTo(key)>=0)
		{
			temp.add(value);
		}
		
		if (kEnd.compareTo(key)>0)
		{
			if (right != null)
			{
				temp.addAll(right.searchByRange(kStart,kEnd));
			}
		}
		
		return temp;
	}
	
	public BSTNode<K, V> getParent() {
		return parent;
	}

	public void setParent(BSTNode<K, V> parent) {
		this.parent = parent;
	}

	public BSTNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<K, V> left) {
		this.left = left;
	}

	public BSTNode<K, V> getRight() {
		return right;
	}

	public void setRight(BSTNode<K, V> right) {
		this.right = right;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}


	public K getKey() {
		return key;
	}
	

	public void setKey(K key) {
		this.key = key;
	}


	public int getBalanceFactor() {
		return BalanceFactor;
	}


	public void setBalanceFactor(int balanceFactor) {
		BalanceFactor = balanceFactor;
	}



	public AVLTree<K, V> getOwner() {
		return owner;
	}



	public void setOwner(AVLTree<K, V> owner) {
		this.owner = owner;
	}
}
