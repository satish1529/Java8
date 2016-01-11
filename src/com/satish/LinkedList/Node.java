package com.satish.LinkedList;

public class Node 
{
	String data;
	Node next;
	
	Node()
	{
		
	}
	
	Node(String data)
	{
		this.data=data;
		this.next = null;
	}
	
	Node(String data,Node next)
	{
		this.data=data;
		this.next = next;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		
		if(data!=null)
			sb.append(data);
		while(next!=null)
		{
			String data = next.data;
			next = next.next;
			sb.append("\n");
			sb.append(data);
		}
		return sb.toString();
	}
}
