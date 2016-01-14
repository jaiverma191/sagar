package com.sagar.tree;

import java.util.Vector;

public class Question2 {

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(addAndMultiply(root));
	}

	private static int addAndMultiply(TreeNode root) {

		if (root == null)
			return 0;
		int multiply = 1;

		Vector<TreeNode> queue = new Vector<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int nodeAtLevel = queue.size();
			boolean leafFound = false;
			int sumAtLevel = 0;
			while (nodeAtLevel > 0) {
				TreeNode treeNode = queue.remove(0);
				if (treeNode.left == null && treeNode.right == null) {
					sumAtLevel += treeNode.value;
					leafFound = true;
				}
				if (treeNode.left != null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.add(treeNode.right);
				}
				nodeAtLevel--;
			}
			if (leafFound) {
				multiply *= sumAtLevel;
			}
		}
		return multiply;
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
