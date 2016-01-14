package com.sagar.tree;

import java.util.Vector;

public class Question5 {
	public static void main(String[] args) {
		TreeNode createTree = createTree();
		if (checkCousins(createTree, createTree.left.left.left, createTree.left.left.right)) {
			System.out.println("Are cousins");
		} else {
			System.err.println("Not Cousins");
		}
	}

	private static boolean checkCousins(TreeNode root, TreeNode left, TreeNode right) {
		if (root == null || left == null || right == null || left == right) {
			return false;
		}
		Vector<TreeNode> queue = new Vector<TreeNode>();
		queue.add(root);
		boolean leftFound = false;
		boolean rightFound = false;
		while (!queue.isEmpty()) {
			int elementCount = queue.size();
			while (elementCount > 0) {
				TreeNode node = queue.remove(0);
				if (node == left)
					leftFound = true;
				if (node == right)
					rightFound = true;
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				elementCount--;
			}
			if (leftFound || rightFound) {
				if (leftFound && rightFound) {
					if (isSibling(root, left, right)) {
						return false;
					} else {
						return true;
					}
				}
				return false;
			}
		}
		return false;
	}

	private static boolean isSibling(TreeNode root, TreeNode a, TreeNode b) {
		if (root == null)
			return false;
		return ((root.left == a && root.right == b) || (root.left == b && root.right == a) || isSibling(root.left, a, b)
				|| isSibling(root.right, a, b));
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
