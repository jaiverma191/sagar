package com.sagar.tree;

public class Question4 {

	public static void main(String[] args) {
		TreeNode root = createTree();
		printBoundaryLeft(root);
		printLeaves(root.left);
		printLeaves(root.right);
		printBoundaryRight(root);
	}

	private static void printBoundaryLeft(TreeNode root) {
		if (root != null) {
			if (root.left != null) {
				System.out.print(root.value+" ");
				printBoundaryLeft(root.left);
			} else if (root.right != null) {
				System.out.print(root.value+" ");
				printBoundaryLeft(root.right);
			}
		}
	}

	private static boolean isLeaf(TreeNode node) {
		if (node.left == null && node.right == null) {
			return true;
		}

		return false;
	}

	private static void printLeaves(TreeNode root) {
		if (root == null) {
			return;
		}
		printLeaves(root.left);
		if (isLeaf(root)) {
			System.out.print(root.value+" ");
		}
		printLeaves(root.right);

	}

	private static void printBoundaryRight(TreeNode root) {
		if (root != null) {
			if (root.right != null) {
				printBoundaryRight(root.right);
				System.out.print(root.value+" ");
			} else if (root.left != null) {
				printBoundaryRight(root.left);
				System.out.print(root.value+" ");
			}
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
