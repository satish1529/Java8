package com.satish.redblack.tree;



public class RedBlackTree {
	
	Node root ;
	boolean red = true;
	boolean black = false;
	
	public static void main(String[] args) {
		
	}

	private void insertNode(int key)  {
		Node addNode = new Node();
		addNode.setI(key);
		addNode.setColor(red);
		if(root==null) {
			addNode.setColor(black);
			return;
		} else {
			Node parent = root;
			Node nextNode = parent;
			while(nextNode!=null)
			{
				parent = nextNode;
				if(key<nextNode.getI())
				{
					nextNode = nextNode.left;
				}
				else
				{
					nextNode = nextNode.right;
				}
			}
			
			if(key<parent.getI())
				parent.setLeft(addNode);
			else
				parent.setRight(addNode);
			
			addNode.setParent(parent);
		}
		balanceTree(addNode);
	}
	
	private void balanceTree(Node addNode){
		Node parent = addNode.parent;
		Node grandParent = parent.parent;
		Node uncle = null;
		if(grandParent!= null) {
			uncle = grandParent.left;
		}
		if(uncle!= null) {
			if(uncle.color == red) { // if color of uncle is red , just recolor parent , grandparent and uncle
				uncle.setColor(black);
				parent.setColor(black);
				grandParent.setColor(red);
			} else {
				if(uncle == grandParent.left) {
					//do right rotation of parent
					if(parent.left == addNode) { //triangle scenario - rotate parent in opp direction of addNode
						addNode.right = parent;
						grandParent.right = addNode;
					} else { //line scenario
						
					}
				} else {
					// do left rotation of parent
					
				}
			}
		}
	}
	
}
