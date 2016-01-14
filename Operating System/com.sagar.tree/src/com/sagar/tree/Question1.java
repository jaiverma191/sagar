package com.sagar.tree;

public class Question1 {

	private static TreeNode head = null;
	private static TreeNode linkList = null;

	public static void main(String[] args) {
		TreeNode root = createTree();
		modifyTree(root);
		print(head);
	}

	private static void print(TreeNode dll) {
		while (dll != null) {
			System.out.print(dll.value+" ");
			dll = dll.right;
		}
	}

	private static TreeNode modifyTree(TreeNode child) {
		if (child.left == null & child.right == null) {
			if (head == null) {
				head = child;
				linkList = child;
			} else {
				linkList.right = child;
				child.left = linkList;
				linkList = child;
			}
			return null;
		}
		if (child.left != null) {
			child.left = modifyTree(child.left);
		}
		if (child.right != null) {
			child.right = modifyTree(child.right);
		}
		return child;
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
