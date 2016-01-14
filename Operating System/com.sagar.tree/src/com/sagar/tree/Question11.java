package com.sagar.tree;

import java.util.Vector;

public class Question11 {

	public static void main(String[] args) {
		TreeNode root = createTree();
		BTreePrinter.printNode(root);
		findCousin(root, root.right.right);
	}

	private static void findCousin(TreeNode root, TreeNode target) {
		if (root == null || target == null || root == target)
			return;
		Vector<TreeNode> queue = new Vector<>();
		queue.add(root);
		boolean targetFound = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (targetFound == true) {
				for (int i = 0; i < size; i++) {
					System.out.print(queue.get(i).value + " ");
				}
				return;
			}
			while (size > 0) {
				size--;
				TreeNode node = queue.remove(0);
				if (node.left == target || node.right == target) {
					targetFound = true;
					continue;
				}
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
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