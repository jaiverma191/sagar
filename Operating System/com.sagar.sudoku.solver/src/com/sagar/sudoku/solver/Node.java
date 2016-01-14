package com.sagar.sudoku.solver;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public Integer value;
	public Integer rowNo;
	public Integer columnNo;
	public List<Integer> possibleValues;

	public Node(Integer row, Integer column) {
		this.columnNo = column;
		this.rowNo = row;
		this.possibleValues = new ArrayList<Integer>();
	}
}
