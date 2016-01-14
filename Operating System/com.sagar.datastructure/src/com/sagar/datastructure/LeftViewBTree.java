package com.sagar.datastructure;

public class LeftViewBTree {
	private int max = 0;

	private class Tree {
		private int data;
		private Tree left;
		private Tree right;

		public Tree(int data) {
			super();
			this.data = data;
		}
	};

	public void insert(Tree root, int data) {
		if (root == null) {
			root = new Tree(data);
		}
		Tree temp = root;
		while (temp != null) {
			if (temp.data > data) {
				if (temp.left == null) {
					temp.left = new Tree(data);
					break;
				} else {
					temp = temp.left;
				}
			} else if (temp.data < data) {
				if (temp.right == null) {
					temp.right = new Tree(data);
					break;
				} else {
					temp = temp.right;
				}
			} else {
				System.out.println(" data existed");
				break;
			}
		}
	}

	public void printLeftView(Tree root, int level) {
		if (root == null) {
			return;
		}
		if (max < level) {
			System.out.println(root.data);
			max = level;
		}
		printLeftView(root.left, level + 1);
		printLeftView(root.right, level + 1);
	}

	public static void main(String[] args) {
		LeftViewBTree lt = new LeftViewBTree();
		Tree root = lt.new Tree(50);
		lt.insert(root, 45);
		lt.insert(root, 55);
		lt.insert(root, 40);
		lt.insert(root, 48);
		lt.insert(root, 53);
		lt.insert(root, 60);
		lt.insert(root, 58);
		lt.printLeftView(root, 1);
	}

}
