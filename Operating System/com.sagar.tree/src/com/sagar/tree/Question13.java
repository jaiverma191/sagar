package com.sagar.tree;

public class Question13 {
	private static int preIndex = 0;

	public static void main(String[] args) {
		int[] inorder = { 4, 2, 5, 1, 6, 3 };
		int[] preorder = { 1, 2, 4, 5, 3, 6 };
		TreeNode root = createTree(inorder, preorder, 0, inorder.length - 1);
		BTreePrinter.printNode(root);
	}

	private static TreeNode createTree(int[] inorder, int[] preorder, int inStart, int inEnd) {
		if (inStart > inEnd)
			return null;
		TreeNode node = new TreeNode(preorder[preIndex]);
		preIndex++;
		if (inStart == inEnd)
			return node;
		int index = findIndex(inorder, node.value);
		node.left = createTree(inorder, preorder, inStart, index - 1);
		node.right = createTree(inorder, preorder, index + 1, inEnd);

		return node;
	}

	private static int findIndex(int[] inorder, int value) {
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == value)
				return i;
		}
		return 0;
	}
}
