package com.satish.BFS;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node a = new Node("A");
		Node b = new Node("E");
		Node c = new Node("M");
		Node d = new Node("E");
		Node e = new Node("D");
		
		a.addVertices(b);
		a.addVertices(c);
		
		b.addVertices(d);
		c.addVertices(e);
		traverse(a);
	}
	
	private static void traverse(Node root)
	{
		Queue<Node> q = new LinkedBlockingDeque<Node>();
		
		q.add(root);
	
		
		while(!q.isEmpty())
		{
			Node current = q.remove();
			current.visited=true;
			System.out.println(current.value);
			List<Node> listOfAdjacents = current.getVertexes(); 
			
			for(Node adjacent : listOfAdjacents)
			{
				if(!adjacent.visited)
					q.add(adjacent);
			}
		}
	}

	
}
