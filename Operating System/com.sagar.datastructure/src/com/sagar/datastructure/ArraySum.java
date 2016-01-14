package com.sagar.datastructure;

import java.util.HashMap;

public class ArraySum {

	public static void main(String[] args) {
		Integer arr[] = { 5, 10, 2, 3, 7, 9, 11 };
		HashMap<Integer, Boolean> map = new HashMap<>();
		Integer sum = 12;
		for (int i = 0; i < arr.length; i++) {
			Integer temp = sum - arr[i];
			if (temp > 0 && Boolean.TRUE.equals(map.get(temp))) {
				System.out.println(temp + ":" + arr[i]);
			}
			map.put(arr[i], Boolean.TRUE);
		}
		System.out.println();
	}
}
