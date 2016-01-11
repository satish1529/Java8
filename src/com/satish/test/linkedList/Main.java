package com.satish.test.linkedList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(new Node(1));
		linkedList.addNode(new Node(4));
		linkedList.addNode(new Node(5));
		linkedList.addNode(new Node(2));
		linkedList.addNode(new Node(3));
		linkedList.addNode(new Node(4));
		linkedList.printAllNodes();
		//linkedList.removeNode(1);
		linkedList.printAllNodes();
		linkedList.printLastNthValue(6);
	//	linkedList.reverseLinkedList();
		linkedList.reverseLinkedListRecursive();
		linkedList.printMiddleElement();
	}

}
