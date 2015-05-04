package com.mportal.DFS;

import java.util.List;
import java.util.Stack;

import com.mportal.DFS.Node;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		
		a.addVertices(b);
		a.addVertices(c);
		
		b.addVertices(d);
		c.addVertices(e);
		traverse(a);
	}
	
	private static void traverse(Node root)
	{
		Stack<Node> s = new Stack<Node>();
		
		s.add(root);
	    root.visited = true; 
		
		while(!s.isEmpty())
		{
			Node current = s.peek();
			
			List<Node> listOfAdjacents = current.getVertexes(); 
			
			if(listOfAdjacents.isEmpty())
			{
				System.out.println();
				for(int i = 0;i<s.size();i++)
					System.out.print(s.get(i).getValue()+ " -> ");
				Node pop = s.pop();
				//System.out.println(pop.value);
				continue;
			}
			
			boolean allVisited = true;
			for(Node adjacent : listOfAdjacents)
			{
				if(!adjacent.visited)
				{
					s.add(adjacent);
					adjacent.visited = true;
					allVisited = false;
					break;
				}
			}
			if(allVisited){
				Node pop = s.pop();
				System.out.println(pop.value);
			}
		}
	}

	
}
