package com.satish.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LoopLinkedListImpl {

	Node head = null;
	Node tail = null;
	
	public static void main(String[] args) {
		LoopLinkedListImpl lli = new LoopLinkedListImpl();
		
		lli.addToList(lli.getNewNode("10"));
		lli.addToList(lli.getNewNode("10"));
		lli.addToList(lli.getNewNode("30"));
		lli.addToList(lli.getNewNode("30"));
		lli.addToList(lli.getNewNode("51"));
		lli.addToList(lli.getNewNode("60"));
		lli.addToList(lli.getNewNode("90"));
		lli.addToList(lli.getNewNode("70"));
	    lli.printCircularList(); 
		lli.convertCircularToLinearList();
		
	}
	
	Node getNewNode(String data)
	{
		return new Node(data);
	}

	
	 void addToList(Node newNode)
	{
		 Node current  =head;
		 if(newNode==null)
			 return;
		 else { 
			 newNode.next = null;
			if(current==null)
			{
				head = newNode;
				head.next = newNode;
			}
			else
			{
				
				while(head!=current.next)
				{
					current = current.next;
					
				}
				current.next = newNode;
				newNode.next = head;
			}
		 }
	}
	 
	 void printCircularList()
	 {
		 System.out.println("Print Circular list");
		 Node current  =head;
		 StringBuffer sb = new StringBuffer();
		 if(head!=null)
		 {
			 while(head!=current.next)
			 {
				 System.out.print(current.data+" ");
				 current = current.next;
			 }
			 System.out.println(current.data+" ");
	 	}
	 }
	 
	 void convertCircularToLinearList()
	 {
		 System.out.println("converting circular list to linear list");
		 Node current  =head;
		 StringBuffer sb = new StringBuffer();
		 if(current!=null)
		 {
			 while(head!=current.next)
			 {
			//	 System.out.print(current.data+" ");
				 current = current.next;
			 }
			 current.next = null;
			 //System.out.print(current.data);
	 	}
		 //System.out.println(sb.toString());
		 printList();
	 }
	 
	 void printList()
	 {
		 StringBuffer sb = new StringBuffer();
		 if(head!=null)
		 {
			  for(Node temp = head; temp!=null;temp=temp.next)
			  {
				  sb.append(temp.data+" ");
			  }
		 }
		 System.out.println(sb.toString());
	 }

 

}
