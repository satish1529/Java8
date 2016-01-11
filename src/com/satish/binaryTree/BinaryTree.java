package com.satish.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;


public class BinaryTree
{
	Node root = null;
	
	static int counter;
	public void addNode(Node addNode)
	{
		if(root==null)
		{
			root = addNode;
			return;
		}
		else
		{
			Node parent = root;
			Node nextNode = parent;
			while(nextNode!=null)
			{
				parent = nextNode;
				if(addNode.value<nextNode.value)
				{
					nextNode = nextNode.left;
				}
				else
				{
					nextNode = nextNode.right;
				}
			}
			
			if(addNode.value<parent.value)
				parent.setLeft(addNode);
			else
				parent.setRight(addNode);
		}
	}
	
	public boolean deleteNode(int deleteValue)
	{
		if(root==null)
			return false; 
		else
		{
			Node parent = root;
			Node nextNode = parent;
			while(nextNode!=null)
			{
				if(deleteValue == nextNode.value)
				{
					if(nextNode.left==null && nextNode.right==null)
					{
						//if only one root element
						if(parent.left == null && parent.right==null)
						{
							parent = null;
							return true;
						}
						//this is for leaf nodes
						if(parent.left!=null)
						{
							if(parent.left.value== deleteValue)
							{ 
								parent.left = null;
							}
						}
						else
							parent.right = null;
						return true;
					}
					else if(nextNode.left!=null && nextNode.right==null)
					{
						parent.right = nextNode.left;
						return true;
					}
					else if(nextNode.right!=null && nextNode.left==null)
					{
						parent.right = nextNode.right;
						return true;
					}
					else //having 2 childs
					{
						//find the smallest element in right subtree
						//replace the deletenode with smallest node
						//remove the smallest node
						int smallest = findSmallestValue(nextNode.right);
						nextNode.value = smallest;
						removeSmallest(nextNode.right);
						return true;
					}
				}
				else if(deleteValue<nextNode.value)
				{
					parent  = nextNode;
					nextNode = nextNode.left;
				}
				else
				{
					parent  = nextNode;
					nextNode = nextNode.right;
				}
			}
			return false;
		}
	}
	
	public boolean findNode(int deleteValue)
	{
		if(root==null)
			return false;
		else
		{
			Node parent = root;
			Node nextNode = parent;
			while(nextNode!=null)
			{
				if(deleteValue == nextNode.value)
				{
					return true;
				}
				else if(deleteValue<nextNode.value)
				{
					parent  = nextNode;
					nextNode = nextNode.left;
				}
				else
				{
					parent  = nextNode;
					nextNode = nextNode.right;
				}
			}
			return false;
		}
	}
    private int findSmallestValue(Node node)
    {
    	int smallest = 0;
    	while(node!=null)
    	{
    		smallest = node.value;
    		node = node.left;
    	}
    	return smallest;	
    }
	
	private void removeSmallest(Node node)
	{
		Node parent = node;
		Node current = parent;
		Node nextNode  = parent;
		while(nextNode!=null)
    	{
			parent = current;
			current = nextNode;
			nextNode = nextNode.left;
    	}
		parent.left=null;
	}
	
	public void printBinaryTree()
	{
		System.out.println("---------inorder----------");
		printInorderTraversal(root);
		System.out.println("---------inorder----------");
		System.out.println("---------preorder----------");
		printPreorderTraversal(root);
		System.out.println("---------preorder----------");
		System.out.println("---------postorder----------");
		printPostorderTraversal(root);
		System.out.println("---------postorder----------");
	}
	
	private void printInorderTraversal(Node node)
	{
		if(node!=null)
		{
			printInorderTraversal(node.left);
			System.out.print(node.value+" ");	
			printInorderTraversal(node.right);
		}
	}
	
	private void printPreorderTraversal(Node node)
	{
		if(node!=null)
		{
			System.out.print(node.value+" ");
			printInorderTraversal(node.left);
			printInorderTraversal(node.right);
		}
	}
	
	private void printPostorderTraversal(Node node)
	{
		if(node!=null)
		{
			printInorderTraversal(node.left);
			printInorderTraversal(node.right);
			System.out.print(node.value+" ");
		}
	}
	
	public void printSum()
	{
		System.out.println("sum : "+sum(root));
	}
	
	private int sum(Node node)
	{
		int sum  =0;
		if(node!=null)
		{
			sum = node.value+sum(node.left)+sum(node.right);
		}
		return sum;
	}
	
	public void countNumberOfNodes()
	{
		System.out.println("count of nodes : "+countNumberOfNodes(root));
	}
	
	private int countNumberOfNodes(Node node)
	{
		int count =0;
		if(node!=null)
		{
			count = 1+countNumberOfNodes(node.left)+countNumberOfNodes(node.right);
		}
		return count;
	}
	
	public void printMirrorOfBinaryTree()
	{
		printMirrorOfBinaryTree(root);
		printBinaryTree();
	}
	
	private Node printMirrorOfBinaryTree(Node node)
	{
		Node reverse = node;
		if(node!=null)
		{
			printMirrorOfBinaryTree(node.right);
			printMirrorOfBinaryTree(node.left);
			Node temp = node.right;
			node.right = node.left;
			node.left  = temp;
		}
		return reverse;
	}
	
	public void createCopyBinaryTree()
	{
		Node copyNode = createCopyBinaryTree(root);
		System.out.println("------printing copy node-----------");
		printInorderTraversal(copyNode);
		System.out.println("------printing copy node-----------");
	}
	
	private Node createCopyBinaryTree(Node node)
	{
		if(node==null)
			return null;
		Node newNode = new Node(node.value);
		newNode.left = createCopyBinaryTree(node.left);
		newNode.right = createCopyBinaryTree(node.right);
		return newNode;	
	}
	
	public void printMaxDepth()
	{
		System.out.println("Max Depth ::::"+printMaxDepth(root));
	}
	
	private int printMaxDepth(Node root)
	{
		int depth = 0;
		if(root!=null)
		{
			int ldepth = printMaxDepth(root.left);
			int rdepth = printMaxDepth(root.right);
			if(ldepth>rdepth)
				return ldepth+1;
			else
				return rdepth+1;
		}
		return depth;
	}
	
	public void printAllPaths()
	{
		int [] paths = new int[5];
		printAllPaths(root,paths,0);
	}
	
	private void printAllPaths(Node root,int [] paths,int length)
	{
		if(root==null)
			return ;
		else
		{
			paths[length] = root.value;
			length++;
			
			if(root.left==null && root.right==null)
			{
				printArray(paths,length);	
			}else
			{
				printAllPaths(root.left,paths,length);
				printAllPaths(root.right,paths,length);
			}
		}
	}
	
	private void printArray(int [] paths,int length)
	{
		System.out.println("------------printing path----------");
		for(int i =0;i<length;i++)
			System.out.println(paths[i]+" ");
	}
	
	public void printAllLeafs()
	{
		System.out.println("printing all leafes");
		printAllLeafs(root);
		System.out.println("");
	}
	
	public void printAllLeafs(Node node)
	{
		if(node==null)
			return;
		if(node.left==null && node.right==null)
			System.out.print(node.value+" ");
		printAllLeafs(node.left);
		printAllLeafs(node.right);
	}
	
	public void printMaxSum()
	{
		System.out.println("max sum :::::"+printMaxSum(root));
	}
	
	public int printMaxSum(Node node)
	{
		int sum = 0;
		if(node==null)
			return 0;
		 sum = node.value;
		 int lsum = sum+printMaxSum(node.left);
		 int rsum = sum+printMaxSum(node.right);
		 if(lsum>rsum)
			 return lsum;
		 else 
			 return rsum;
	}
	
	public void printMaxSumPath()
	{
		System.out.print("printing max sum path:::::");
		int [] paths = new int [5];
		int maxsum = printMaxSum(root);
		printAllPathsMaxSum(root,paths,0,maxsum);
		System.out.println("");
	}
	
	private void printAllPathsMaxSum(Node root,int [] paths,int length,int maxSum)
	{
		if(root==null)
			return ;
		else
		{
			paths[length] = root.value;
			length++;
			
			if(root.left==null && root.right==null)
			{
				printArrayMaxSum(paths,length,maxSum);	
			}else
			{
				printAllPathsMaxSum(root.left,paths,length,maxSum);
				printAllPathsMaxSum(root.right,paths,length,maxSum);
			}
		}
	}
	
	private void printArrayMaxSum(int [] paths,int length,int maxSum)
	{
		int sum = 0;
		for(int i =0;i<length;i++)
		{
			sum = sum+paths[i];
		}
		if(sum==maxSum)
		{
			System.out.print("------------printing max path----------");
			for(int i =0;i<length;i++)
			{
				System.out.print(paths[i]+" ");
			}
		}
	}
	
	
	public void printZigZagTree()
	{
		
		printZigZagTree(root);
	}
	
	private void printZigZagTree(Node node)
	{
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		if(node==null)
			return ;
		stack1.push(node);
		do{
		while(!stack1.isEmpty())
		{
			Node n = stack1.pop();
			System.out.println(n.value);
			if(n.left!=null)
				stack2.push(n.left);
			if(n.right!=null)
				stack2.push(n.right);
		}
		
		while(!stack2.isEmpty())
		{
			Node n = stack2.pop();
			System.out.println(n.value);
			if(n.right!=null)
				stack1.push(n.right);
			if(n.left!=  null)
				stack1.push(n.left);
			
		}
		}while(!stack1.isEmpty() || !stack2.isEmpty());
	}
	
	
	public void printNthLargestValue()
	{
		int n = 3;
		System.out.println(n+"th largest value is : ");
		printNthLargestValue(root,n);
		System.out.println("");
	}
	
	private void printNthLargestValue(Node node,int n)
	{
		if(node==null)
			return ;
		printNthLargestValue(node.right, n);
		counter++;
		if(n==counter)
		{
			System.out.print(node.value);
		}
		printNthLargestValue(node.left, n);
	}
	
	public void providedInOrderPreOrderConstructBST()
	{
		ArrayList preOrder = new ArrayList();
        preOrder.add(new Integer(1));
        preOrder.add(new Integer(2));
        preOrder.add(new Integer(4));
        preOrder.add(new Integer(8));
        preOrder.add(new Integer(9));
        preOrder.add(new Integer(10));
        preOrder.add(new Integer(11));
        preOrder.add(new Integer(5));
        preOrder.add(new Integer(3));
        preOrder.add(new Integer(6));
        preOrder.add(new Integer(7));
 
        ArrayList inOrder = new ArrayList();
        inOrder.add(new Integer(8));
        inOrder.add(new Integer(4));
        inOrder.add(new Integer(10));
        inOrder.add(new Integer(9));
        inOrder.add(new Integer(11));
        inOrder.add(new Integer(2));
        inOrder.add(new Integer(5));
        inOrder.add(new Integer(1));
        inOrder.add(new Integer(6));
        inOrder.add(new Integer(3));
        inOrder.add(new Integer(7));
        
        Node node = constructBST(inOrder, preOrder, 0, 0, inOrder.size());
        
        printInorderTraversal(node);
        
	}
	
	
	
	private Node constructBST(List inOrder,List preOrder , int inOrderIndex,int preOrderIndex,int length)
	{
		System.out.println("lenght :::::"+length);
		System.out.println("inOrderIndex :::::"+inOrderIndex);
		System.out.println("preOrderIndex :::::"+preOrderIndex);
		if(length==0)
			return null;
		Node n = null;
		int rootIndex =0;
		if(inOrder!=null && preOrder!=null)
		{
			n = new Node((Integer)preOrder.get(preOrderIndex));
			rootIndex = inOrder.indexOf((Integer)preOrder.get(preOrderIndex));
			System.out.println("rootIndex :::::"+rootIndex);
			n.left = constructBST(inOrder, preOrder, inOrderIndex, preOrderIndex+1,	rootIndex);
			n.right = constructBST(inOrder, preOrder,inOrderIndex+rootIndex+1 , preOrderIndex+rootIndex+1 , length-(rootIndex+1));
		}
		return n;
	}
	
	public void iterativePreOrderTraversal()
	{
		System.out.print("iterative PreOrder traversal :::::::::");
		iterativePreOrderTraversal(root);
		System.out.println("");
	}
	
	private void iterativePreOrderTraversal(Node node)
	{
		if(node==null)
			return;
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(node);
		while(!nodeStack.isEmpty())
		{
			node = nodeStack.pop();
			System.out.print(node.value+" ");
			if(node.right!=null)
				nodeStack.push(node.right);
			if(node.left!=null)
				nodeStack.push(node.left);
		}
		
	}
	
	
	public void iterativeInOrderTraversal()
	{
		System.out.print("iterative InOrder traversal :::::::::");
		iterativeInOrderTraversal(root);
		System.out.println("");
	}
	
	private void iterativeInOrderTraversal(Node node)
	{
		if(node==null)
			return;
		Stack<Node> nodeStack = new Stack<Node>();
		boolean start=true;
		while(start)
		{
			if(node!=null)
			{
				nodeStack.push(node);
				node = node.left;
			}
			else 
			{
				if(!nodeStack.isEmpty())
				{
					node = nodeStack.pop();
					System.out.print(node.value+" ");
					node = node.right;
				}
				else
					start = false;
			}
		}
	}
	
	public void iterativePostOrderTraversal()
	{

		System.out.print("iterative PostOrder traversal :::::::::");
		iterativePostOrderTraversal(root);
		System.out.println("");
	}
	
	private void iterativePostOrderTraversal(Node node)
	{
		if(node==null)
			return;
		Stack<Node> nodeStack = new Stack<Node>();
		
		
	}
	
	//TODO iterative post order traversal, convert BST to Double linked list, give inorder to prepare BST
	
	public void printReverseLevelOrder()
	{
		Queue<Node> q = new LinkedBlockingQueue<Node>();
		Stack<Node> s = new Stack<Node>();
		Node current = root;
		q.add(root);
		while(!q.isEmpty())
		{
			current = q.poll();
			s.push(current	);
			if(current.right!=null)
				q.add(current.right);
			if(current.left!=null)
				q.add(current.left);
			
		}
		System.out.println("printing reversal level order");
		while(!s.isEmpty())
		{
			
			System.out.print(s.pop().value+" ");
		}
	}
	
	private Node rotateRightChildForBalance(Node n)
	{
		Node temp = n.right;
		n.right = temp.left;
		temp.left = n;
		return temp;
	}
	
	private Node rotateLeftChildForBalance(Node n)
	{
		Node temp = n.left;
		n.left = temp.right;
		temp.right = n;
		return temp;
	}
	
	
		int height(Node root) {
	        return (root==null) ? 0: 1 + Math.max(height(root.left),height(root.right));
	}
	
	boolean isHeightBalanced(Node root) {
	        return (root == null) ||
	                (isHeightBalanced(root.left) &&
	                isHeightBalanced(root.right) &&
	                Math.abs(height(root.left) - height(root.right)) <=1);
	}
}
