package com.satish.test.linkedList;

public class LinkedList
{
	Node first;
	Node last;
	
	int size;
	
	public void addNode(Node addNode)
	{
		if(first==null)
		{
			first = addNode;
			last = addNode;
		}
		else
		{
			last.next = addNode;
			last = addNode;
		}
		size++;
	}
	
	public boolean removeNode(int value)
	{
		Node current = first;
		Node previous = first;
		
		if(first.value==value)
		{
			first = first.next;
			return true;
		}
		
		while(current!=null)
		{
			if(current.value==value)
			{
				previous.next = current.next;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;
	}
	
	public void printLastNthValue(int n)
	{
		System.out.println("");
		Node pointer1 = first;
		Node pointer2 = first;
		int count = 0;
		
		if(first==null)
		{
			System.out.println("no nodes available");
			return ;
		}
		if(size<n)
		{
			System.out.println("size is small :"+size);
			return;
		}
		while(pointer1!=null)
		{
			pointer1 = pointer1.next;
			if(count>=n)
				pointer2 = pointer2.next;
			count++;
		}
		System.out.println(n+"th value is : "+pointer2.value);
	}
	
	public void reverseLinkedList()
	{
		System.out.print("");
		System.out.print("reverse linked list :");
		Node prev = null;
		Node next = null;
		Node current = first;
		
		while(current!=null)
		{
			next = current.next;
			current.next= prev;
			prev = current;
			current = next;
		}
		
		for(Node n = prev ;n!=null;n=n.next)
		{
			System.out.print(n.value+" ");
		}
	}
	
	public  void reverseLinkedListRecursive()
	{
		System.out.println("");
		System.out.print("reverse linked list recursion :");
		Node node  = reverseLinkedList(first);
		for(Node n = node ;n!=null;n=n.next)
		{
			System.out.print(n.value+" ");
		}
	}
	
	 public Node reverseLinkedList(Node current)
	 {
		     if (current == null || current.next==null) return current;
		     Node nextItem = current.next;
		     current.next = null;
		     Node reverseRest = reverseLinkedList(nextItem);
		     nextItem.next = current;
		     return reverseRest;
	 }
	
	public void printMiddleElement()
	{
		System.out.println("");
		
		Node pointer1 = first;
		Node pointer2 = first;
		
		while(pointer1!=null)
		{
			if(pointer1.next!=null)
			{
				pointer1 = pointer1.next.next;
				pointer2 = pointer2.next;
			}
			else
				pointer1 = pointer1.next;
			
		}
		System.out.println("middle value : "+pointer2.value);
	}
	 
	public void printAllNodes()
	{
		System.out.println("");
		if(first==null)
		{
			System.out.println("no nodes available");
			return;
		}
		
		for(Node n = first ;n!=null;n=n.next)
		{
			System.out.print(n.value+" ");
		}
		
	}
	
	
}
