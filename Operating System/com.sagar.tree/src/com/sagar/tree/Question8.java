package com.sagar.tree;

public class Question8 {

	public static void main(String[] args) {

		TreeNode root = createTree();
		BTreePrinter.printNode(root);
		sum(root);
		BTreePrinter.printNode(root);
	}

	private static int sum(TreeNode root) {
		TreeNode leftChild = root.left;
		TreeNode rightChild = root.right;
		if (leftChild == null && rightChild == null) {
			int value = root.value;
			root.value = 0;
			return value;
		} else {
			int l = 0;
			int r = 0;
			if (leftChild != null) {
				l = sum(leftChild);
			}
			if (rightChild != null) {
				r = sum(rightChild);
			}
			int value = root.value;
			root.value = l + r;
			return value + l + r;
		}
	}

	private static TreeNode createTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(8);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(9);
		root.right.right.right = new TreeNode(10);
		return root;
	}
}