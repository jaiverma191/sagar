package com.sagar.binary.tree;

import com.sagar.tree.TreeNode;

public class BinarySearchTreeUtil {

	public static TreeNode createBST(int[] arr) {
		TreeNode root = new TreeNode(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			addNodeToTree(root, arr[i]);
		}
		return root;
	}

	public static void deleteNode(TreeNode root, int value) {
		TreeNode node = root;
		TreeNode parentNode = null;
		while (true && node != null) {
			if (value < node.value) {
				parentNode = node;
				node = node.left;
			} else if (value > node.value) {
				parentNode = node;
				node = node.right;
			} else {
				if (node.right == null && node.left == null) {
					if (parentNode.left == node)
						parentNode.left = null;
					if (parentNode.right == node)
						parentNode.right = null;
					return;
				} else if (node.left == null) {
					if (parentNode.left == node)
						parentNode.left = node.right;
					if (parentNode.right == node)
						parentNode.right = node.right;
					return;
				} else if (node.right == null) {
					if (parentNode.left == node)
						parentNode.left = node.left;
					if (parentNode.right == node)
						parentNode.right = node.left;
					return;
				} else {
					TreeNode maxNode = node.left;
					TreeNode maxPareNode = node;
					while (maxNode.right != null) {
						maxPareNode = maxNode;
						maxNode = maxNode.right;
					}
					node.value = maxNode.value;
					value = maxNode.value;
					node = maxNode;
					parentNode = maxPareNode;

				}
			}
		}
	}

	private static void addNodeToTree(TreeNode root, int value) {
		TreeNode node = root;
		while (true) {
			if (value < node.value) {
				if (node.left == null) {
					TreeNode newNode = new TreeNode(value);
					node.left = newNode;
					return;
				}
				node = node.left;
			} else if (value > node.value) {
				if (node.right == null) {
					TreeNode newNode = new TreeNode(value);
					node.right = newNode;
					return;
				}
				node = node.right;
			} else {
				return;
			}
		}
	}

}
