package com.sagar.datastructure;

public class TowerOfHanoi {
	public static void towerOfHanoi(int n, char start, char aux, char end) {
		if (n == 0) {
			return;
		}
		towerOfHanoi(n - 1, start, end, aux);
		System.out.println(start + "->" + end);
		towerOfHanoi(n - 1, aux, start, end);
	}

	public static void main(String[] args) {
		int n = 3;
		towerOfHanoi(n, 'A', 'B', 'C');
	}
}
