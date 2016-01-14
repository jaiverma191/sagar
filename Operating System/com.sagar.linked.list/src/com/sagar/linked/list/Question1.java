package com.sagar.linked.list;

public class Question1 {

	public static void main(String[] args) {
		int k = 7;
		Node node = new Node(10);
		Node node1 = new Node(9, node);
		Node node2 = new Node(8, node1);
		Node node3 = new Node(7, node2);
		Node node4 = new Node(6, node3);
		Node node5 = new Node(5, node4);
		print(node5);
		node5 = reverseK(node5, k);
		print(node5);
	}

	private static void print(Node node) {
		while (node != null) {
			System.err.print(node.value+" ");
			node = node.next;
		}
		System.err.print("\n");
	}

	private static Node reverseK(Node root, int k) {
		if (root == null)
			return null;
		if (root.next == null)
			return root;
		Node first = root, temp;
		Node second = root.next;
		first.next = null;
		for (int i = 0; i < k - 1 && second != null; i++) {
			temp = second.next;
			second.next = first;
			first = second;
			second = temp;
		}
		root.next = reverseK(second, k);
		return first;
	}

}
