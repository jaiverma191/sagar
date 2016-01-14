package com.sagar.linked.list;

public class Question2 {

	private static int carryForward = 0;

	public static void main(String[] args) {
		Node node = new Node(1);
		Node node1 = new Node(9, node);
		Node node2 = new Node(8, node1);
		Node node3 = new Node(7, node2);
//		Node node4 = new Node(6, node3);
		Node secondNumber = new Node(5, node3);
		Node node5 = new Node(1);
		Node node6 = new Node(9, node5);
		Node node7 = new Node(2, node6);
		Node node8 = new Node(1, node7);
		Node node9 = new Node(8, node8);
		Node node10 = new Node(9, node9);
		Node firstNumber = new Node(9, node10);
		print(firstNumber);
		print(secondNumber);
		int firstNumberSize = size(firstNumber);
		int secondNumberSize = size(secondNumber);
		Node result = null;
		if (firstNumberSize == secondNumberSize) {
			result = add(firstNumber, secondNumber);

		} else {
			Node firstNumberCur = firstNumber;
			Node secodNumberCur = secondNumber;
			if (firstNumberSize > secondNumberSize) {
				int diff = firstNumberSize - secondNumberSize;
				while (diff > 0) {
					diff--;
					firstNumberCur = firstNumberCur.next;
				}
				result = add(firstNumberCur, secodNumberCur);
				Node addCarry = addCarry(firstNumber, firstNumberCur);
				Node temp = addCarry;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = result;
				result = addCarry;
			} else {
				int diff = secondNumberSize - firstNumberSize;
				while (diff > 0) {
					diff--;
					secodNumberCur = secodNumberCur.next;
				}
				result = add(firstNumberCur, secodNumberCur);
				Node addCarry = addCarry(secondNumber, secodNumberCur);
				Node temp = addCarry;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = result;
				result = addCarry;
			}

		}
		if (carryForward > 0) {
			result = new Node(carryForward, result);
		}
		print(result);

	}

	private static Node addCarry(Node firstNumber, Node firstNumberCur) {

		if (firstNumber != firstNumberCur) {
			Node result = addCarry(firstNumber.next, firstNumberCur);
			int value = firstNumber.value + carryForward;
			if (value / 10 > 0) {
				carryForward = value / 10;
			} else {
				carryForward = 0;
			}
			return new Node(value % 10, result);

		}
		return null;

	}

	private static Node add(Node firstNumber, Node secondNumber) {
		if (firstNumber.next == null && secondNumber.next == null) {
			int value = firstNumber.value + secondNumber.value;
			if (value / 10 > 0) {
				carryForward = value / 10;
			}
			return new Node(value % 10);
		}
		Node add = add(firstNumber.next, secondNumber.next);
		int value = firstNumber.value + secondNumber.value + carryForward;
		if (value / 10 > 0) {
			carryForward = value / 10;
		} else {
			carryForward = 0;
		}
		return new Node(value % 10, add);
	}

	private static int size(Node node) {
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}

	private static void print(Node node) {
		while (node != null) {
			System.err.print(node.value);
			node = node.next;
		}
		System.err.print("\n");
	}
}
