package com.satish.test.linkedList;

public class Node {

	int value;
	
	Node next;
	
	Node(int value)
	{
		this.value = value;
	}

	Node(int value,Node next)
	{
		this.value = value;
		this.next = next;
	}

	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
