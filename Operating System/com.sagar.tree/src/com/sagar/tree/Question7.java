package com.sagar.tree;

public class Question7 {

	public static void main(String[] args) {

		AdvancedTreeNode root = createTree();

		AdvancedTreeNode traversalPointer = root;

		while (traversalPointer != null) {
			AdvancedTreeNode temp = traversalPointer;
			while (temp != null) {
				if (temp.left != null) {
					if (temp.right != null) {
						temp.left.nextRight = temp.right;
					} else {
						temp.left.nextRight = getNextRight(temp);
					}
				}
				if (temp.right != null) {
					temp.right.nextRight = getNextRight(temp);
				}
				temp = temp.nextRight;
			}
			if (traversalPointer.left != null) {
				traversalPointer = traversalPointer.left;
			} else if (traversalPointer.right != null) {
				traversalPointer = traversalPointer.right;
			} else {
				traversalPointer = getNextRight(traversalPointer);
			}
		}
		printLevelOrder(root);
	}

	private static void printLevelOrder(AdvancedTreeNode root) {
		AdvancedTreeNode traversalPointer = root;

		while (traversalPointer != null) {
			AdvancedTreeNode temp = traversalPointer;
			AdvancedTreeNode nextLevel = null;
			while (temp != null) {
				if (nextLevel == null) {
					if (temp.left != null) {
						nextLevel = temp.left;
					} else if (temp.right != null) {
						nextLevel = temp.right;
					}
				}
				System.out.print(temp.value + " ");
				temp = temp.nextRight;
			}
			traversalPointer = nextLevel;
		}
	}

	private static AdvancedTreeNode getNextRight(AdvancedTreeNode root) {
		AdvancedTreeNode temp = root.nextRight;
		while (temp != null) {
			if (temp.left != null) {
				return temp.left;
			}
			if (temp.right != null) {
				return temp.right;
			}
			temp = temp.nextRight;
		}
		return null;
	}

	private static AdvancedTreeNode createTree() {
		AdvancedTreeNode root = new AdvancedTreeNode(1);
		root.left = new AdvancedTreeNode(2);
		// root.left.left = new AdvancedTreeNode(4);
		// root.left.left.left = new AdvancedTreeNode(7);
		// root.left.left.right = new AdvancedTreeNode(8);
		// root.left.right = new AdvancedTreeNode(5);
		root.right = new AdvancedTreeNode(3);
		root.right.right = new AdvancedTreeNode(6);
		root.right.right.left = new AdvancedTreeNode(9);
		root.right.right.right = new AdvancedTreeNode(10);
		return root;
	}

}
