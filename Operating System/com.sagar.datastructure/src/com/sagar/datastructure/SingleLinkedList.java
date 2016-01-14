package com.sagar.datastructure;

public class SingleLinkedList {
	private int value;
	private SingleLinkedList next;

	public SingleLinkedList(int value) {
		this.value = value;
		this.next = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public SingleLinkedList getNext() {
		return next;
	}

	public void setNext(SingleLinkedList next) {
		this.next = next;
	}

	public void printList(SingleLinkedList s) {
		while (s != null) {
			System.out.println(s.getValue());
			s = s.getNext();
		}
	}

	public SingleLinkedList insertAtSort(SingleLinkedList s, int v) {
		SingleLinkedList head = s;
		SingleLinkedList prev = null;
		if (head == null || head.getValue() > v) {
			head = new SingleLinkedList(v);
			if (s.getValue() > v) {
				head.setNext(s);
			}
			return head;
		}
		while (s.getNext() != null && s.getValue() < v) {
			prev = s;
			s = s.getNext();
		}
		if (s.getNext() == null && s.getValue() < v) {
			s.setNext(new SingleLinkedList(v));
		} else {
			// SingleLinkedList temp = prev;
			prev.setNext(new SingleLinkedList(v));
			prev = prev.getNext();
			prev.setNext(s);
		}
		return head;
	}

	public SingleLinkedList reverseLinkedList(SingleLinkedList s) {
		SingleLinkedList temp = s;
		SingleLinkedList prev = null;
		if (s == null || s.getNext() == null) {
			return s;
		}
		while (s.getNext() != null) {
			temp = s.getNext();
			s.setNext(prev);
			prev = s;
			s = temp;
		}
		s.setNext(prev);
		return s;
	}

	public SingleLinkedList recursiveReverseList(SingleLinkedList s) {
		SingleLinkedList temp = s.getNext();
		if (s == null || s.getNext() == null) {
			return s;
		}
		s.setNext(null);
		SingleLinkedList recursiveHead = recursiveReverseList(temp);
		temp.setNext(s);
		return recursiveHead;
	}

	public static void main(String[] args) {
		SingleLinkedList sList = new SingleLinkedList(1);
		SingleLinkedList temp = sList;
		for (int i = 10; i < 15; i++) {
			temp.setNext(new SingleLinkedList(i));
			temp = temp.getNext();
		}
		sList.printList(sList);
		sList = sList.insertAtSort(sList, 6);
		System.out.println("new List");
		sList.printList(sList);
		sList = sList.reverseLinkedList(sList);
		System.out.println("reversed List");
		sList.printList(sList);
		sList = sList.recursiveReverseList(sList);
		System.out.println("Recursively reversed List");
		sList.printList(sList);
	}
}
