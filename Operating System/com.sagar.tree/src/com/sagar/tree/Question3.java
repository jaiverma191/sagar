package com.sagar.tree;

import java.util.Vector;

public class Question3 {

	public static void main(String[] args) {
		TreeNode root = createTree();
		if (checkAllLeafAtSameLevel(root))
			System.out.println("leaf at same level");
		else
			System.out.println("leaf at different level");
	}

	private static boolean checkAllLeafAtSameLevel(TreeNode root) {

		if (root == null)
			return false;

		Vector<TreeNode> queue = new Vector<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int nodeAtLevel = queue.size();
			boolean leafFound = false;
			while (nodeAtLevel > 0) {
				TreeNode treeNode = queue.remove(0);
				if (treeNode.left == null && treeNode.right == null) {
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
			if (leafFound && !queue.isEmpty()) {
				return false;
			}
		}
		return true;
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
