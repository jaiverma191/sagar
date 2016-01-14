package com.sagar.linked.list;

public class Question4 {

	public static void main(String[] args) {
		LinkNode linkNode1 = new LinkNode(1);
		LinkNode linkNode2 = new LinkNode(2);
		LinkNode linkNode3 = new LinkNode(3);
		LinkNode linkNode4 = new LinkNode(4);
		LinkNode linkNode5 = new LinkNode(5);
		linkNode1.next = linkNode2;
		linkNode2.next = linkNode3;
		linkNode3.next = linkNode4;
		linkNode4.next = linkNode5;
		linkNode1.random = linkNode3;
		linkNode2.random = linkNode1;
		linkNode3.random = linkNode5;
		linkNode4.random = linkNode3;
		linkNode5.random = linkNode2;

		LinkNode head1 = linkNode1;
		System.out.println("List");
		printList(head1);
		System.out.println("Clone");
		LinkNode head2 = cloneList(head1);
		printList(head2);

	}

	private static LinkNode cloneList(LinkNode head1) {
		LinkNode temp = head1;
		while (temp != null) {
			LinkNode node = new LinkNode(temp.value);
			node.next = temp.next;
			temp.next = node;
			temp = node.next;
		}
		temp = head1;
		while (temp != null) {
			temp.next.random = temp.random.next;
			temp = temp.next.next;
		}
		temp = head1;
		LinkNode temp2, copy = temp2 = temp.next;
		while (temp != null) {
			temp.next = temp.next.next;
			if (temp2.next != null) {
				temp2.next = temp2.next.next;
			}
			temp2 = temp2.next;
			temp = temp.next;
		}
		return copy;
	}

	private static void printList(LinkNode head1) {
		LinkNode temp = head1;
		while (temp != null) {
			LinkNode random = temp.random;
			LinkNode next = temp.next;
			System.out.print("Value = " + temp.value);
			if (next != null) {
				System.out.print(" Next = " + next.value);
			}
			if (random != null) {
				System.out.println(" Random = " + random.value);
			}
			temp = temp.next;
		}
	}
}
