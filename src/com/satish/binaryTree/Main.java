package com.satish.binaryTree;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		bt.addNode(new Node(10));
		bt.addNode(new Node(40));
		bt.addNode(new Node(15));
		bt.addNode(new Node(60));
		bt.addNode(new Node(45));
		bt.addNode(new Node(65));
		bt.addNode(new Node(44));
		bt.addNode(new Node(5));
		bt.addNode(new Node(2));
		bt.addNode(new Node(1));
		bt.printBinaryTree();
		/*bt.printSum();
		bt.countNumberOfNodes();*/
		System.out.println(bt.findNode(1));
	/*//	bt.printMirrorOfBinaryTree();
		bt.createCopyBinaryTree();
		bt.printMaxDepth();
		bt.printAllPaths();
		bt.printAllLeafs();
		bt.printMaxSum();
		bt.printMaxSumPath();
		bt.printZigZagTree();
		bt.printNthLargestValue();
		//bt.providedInOrderPreOrderConstructBST();
		bt.iterativePreOrderTraversal();
		bt.iterativeInOrderTraversal();*/
		bt.printNthLargestValue();
		//bt.printReverseLevelOrder();
	}

}
