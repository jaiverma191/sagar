package com.sagar.datastructure;

import java.util.HashMap;

public class MajorityElement {
	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3, 1, 2, 2, 3, 2 };
		HashMap<Integer, Integer> countMap = new HashMap<>();
		for (Integer integer : arr) {
			Integer count = countMap.get(integer);
			if (count == null) {
				count = 0;
			}
			count++;
			countMap.put(integer, count);
			if (count >= arr.length / 2) {
				System.out.println("Majority element: " + integer);
				return;
			}
		}
		System.out.println("NONE");

	}
}
