package com.satish.BFS;

import java.util.ArrayList;
import java.util.List;

public class Node {

	boolean visited;
	List<Node> vertices = new ArrayList<>();
	String value ;
	
	Node(String vvalue)
	{
		this.value = vvalue;
	}
	public void addVertices(Node vertex)
	{
		vertices.add(vertex);
	}
	
	public String getValue()
	{
		return this.value;
	}
	
	public List<Node> getVertexes()
	{
		return this.vertices;
	}
}
