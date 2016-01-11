package com.satish.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class LinkedListImpl {

	Node head = null;
	Node tail = null;
	
	public static void main(String[] args) {
		LinkedListImpl lli = new LinkedListImpl();
		
		/*lli.addToList(lli.getNewNode("10"));
		lli.addToList(lli.getNewNode("10"));
		lli.addToList(lli.getNewNode("30"));
		lli.addToList(lli.getNewNode("30"));
		lli.addToList(lli.getNewNode("50"));
		lli.addToList(lli.getNewNode("60"));
		lli.addToList(lli.getNewNode("90"));
		lli.addToList(lli.getNewNode("91"));
		lli.addFirstToList(lli.getNewNode("40"));
		lli.addFirstToList(lli.getNewNode("43"));
		lli.printList();
		lli.removeDuplicates();
		//lli.printMiddleElement();
		lli.printList(lli.reverseListByKNodes(lli.head, 3));
		lli.reverseList();
		lli.mergeTwoListWithAlternates();
		lli.deleteAlternateNodes();*/
		lli.swapNodes();
		
		
	}
	
	Node getNewNode(String data)
	{
		return new Node(data);
	}
	
	public Node Reverse(Node list)
	{
	    if (list == null) return null; // first question

	    if (list.next == null) return list; // second question

	    // third question - in Lisp this is easy, but we don't have cons
	    // so we grab the second element (which will be the last after we reverse it)

	    Node secondElem = list.next;

	    // bug fix - need to unlink list from the rest or you will get a cycle
	    list.next = null;

	    // then we reverse everything from the second element on
	    Node reverseRest = Reverse(secondElem);

	    // then we join the two lists
	    secondElem.next = list;

	    return reverseRest;
	}
	
	void removeDuplicates()
	{
		System.out.println("remove duplicates");
		Node removeDuplicates = head;
		if(removeDuplicates==null)
			return;
		while(removeDuplicates.next!=null)
		{
			System.out.println(removeDuplicates.data);
			if(removeDuplicates.data.equals(removeDuplicates.next.data))
			{
				removeDuplicates.next = removeDuplicates.next.next;
				if(removeDuplicates.next==null)
					break;
				removeDuplicates = removeDuplicates.next;
			}
			else
			{
				removeDuplicates = removeDuplicates.next;
			}
		}
		printList();
	}
	
	 Node reverseListByKNodes(Node node , int knodes)
	 {
		 Node currNode = node;
		 Node nexNode  = null;
		 Node prevNode = null;
		 
		 int count = 0;
		 while(currNode!=null && count<knodes)
		 {
			 nexNode = currNode.next;
			 currNode.next = prevNode;
			 prevNode = currNode;
			 currNode = nexNode;
			 count++;
		 }
		 
		  if(currNode!=null)
			  node.next = reverseListByKNodes(currNode,knodes);
					  
		 return prevNode;
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
			}
			else
			{
				while(current.next!=null)
				{
					current = current.next;
				}
				current.next = newNode;
			}
		 }
	}
	 

 
	 void addFirstToList(Node newNode)
	 {
		    if(newNode== null)
		    return;
		 
			if(head==null)
			{
				head = newNode;
			}
			else
			{
				newNode.next = head;
				head=newNode;
			}
	 }
	 
	 Node reverseList()
	 {
		 Node currNode = head;
		 Node nexNode  = null;
		 Node prevNode = null;
		 
		 while(currNode!=null)
		 {
			 nexNode = currNode.next;
			 currNode.next = prevNode;
			 prevNode = currNode;
			 currNode = nexNode;
		 }
		 System.out.println("Printing reverse list ");
		 printList(prevNode);
		 return prevNode;
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
	 
	 void printList(Node node)
	 {
		 StringBuffer sb = new StringBuffer();
		 if(node!=null)
		 {
			  for(Node temp = node; temp!=null;temp=temp.next)
			  {
				  sb.append(temp.data+" ");
			  }
		 }
		 System.out.println(sb.toString());
	 }
	 
	 void printMiddleElement()
	 {
		 System.out.println("Printing middle element ");
		 Node pointer1 = head;
		 Node pointer2 = head;
		 int i =0;
		 if(pointer1!=null)
		 {
			 while(pointer1.next!=null)
			 {
				 i++;
				 if(i%2==0)
				 {
					 while(pointer2.next!=null)
					 {
						 pointer2 = pointer2.next;
						 break;
					 }
				 }
				 pointer1 = pointer1.next;
			 }
		 }
		 System.out.println(pointer2.data);
	 }
	 
	 void mergeTwoListWithAlternates()
	 {
		 System.out.println("merging Two Lists : ");
		 LinkedListImpl lli = new LinkedListImpl();
			
			lli.addToList(lli.getNewNode("1"));
			lli.addToList(lli.getNewNode("3"));
			lli.addToList(lli.getNewNode("5"));
			lli.addToList(lli.getNewNode("7"));
			
			
			LinkedListImpl lli1 = new LinkedListImpl();
			
			lli1.addToList(lli.getNewNode("2"));
			lli1.addToList(lli.getNewNode("4"));
			lli1.addToList(lli.getNewNode("6"));
			lli1.addToList(lli.getNewNode("8"));
			
			Node one = lli.head;
			Node two = lli1.head;
			
			while(one!=null && two!=null)
			{
				Node tempOne = one.next;
				Node tempTwo = two.next;
				
				two.next = one.next;
				one.next = two;
				
				one = tempOne;
				two = tempTwo;
			}
			printList(lli.head);
	 }
	 
	 void swapNodes()
	 {
		 System.out.println("swapping nodes : ");
		 LinkedListImpl lli = new LinkedListImpl();
			
			lli.addToList(lli.getNewNode("1"));
			lli.addToList(lli.getNewNode("2"));
			lli.addToList(lli.getNewNode("3"));
			lli.addToList(lli.getNewNode("4"));
			lli.addToList(lli.getNewNode("5"));
			//lli.addToList(lli.getNewNode("6"));
			
			Node one = lli.head;
			Node newroot = null;
			Node temp =  null;
			Node prev = null;
			if(one!=null)
			{
				while(one!=null && one.next!=null)
				{
					temp = one.next;
					if(prev!=null)
						prev.next = temp;
					one.next = one.next.next;
					temp.next = one;
					if(newroot==null)
						newroot = temp;
					prev = one;
					one = one.next;
				}
			}
			printList(newroot);
			//printList(one);
	 }
	 
	 void deleteAlternateNodes()
	 {
		 
		 System.out.println("delete alternate nodes : ");
		 LinkedListImpl lli = new LinkedListImpl();
			
			lli.addToList(lli.getNewNode("1"));
			lli.addToList(lli.getNewNode("3"));
			lli.addToList(lli.getNewNode("5"));
			lli.addToList(lli.getNewNode("7"));
			lli.addToList(lli.getNewNode("8"));
			lli.addToList(lli.getNewNode("9"));
			lli.addToList(lli.getNewNode("10"));
			
			Node one = lli.head;
			
			while(one.next!=null)
			{
				one.next = one.next.next;
				one = one.next;
			}
			printList(lli.head);
	 }
}
