package com.sagar.tree;

public class Question14 {

	private static int traversal = 0;

	public static void main(String[] args) {
		char[] preorder = { 'I', 'L', 'I', 'L', 'L' };
		TreeNode root = constructTree(preorder);
		BTreePrinter.printNode(root);
	}

	private static TreeNode constructTree(char[] preorder) {
		if (traversal == preorder.length)
			return null;
		TreeNode node = new TreeNode(preorder[traversal]);
		if (preorder[traversal] == 'L') {
			return node;
		}
		traversal++;
		node.left = constructTree(preorder);
		traversal++;
		node.right = constructTree(preorder);
		return node;
	}
}
