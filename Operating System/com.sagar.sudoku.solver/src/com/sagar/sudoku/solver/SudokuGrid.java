package com.sagar.sudoku.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SudokuGrid {

	private Node[][] grid = new Node[9][9];

	public SudokuGrid() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				grid[i][j] = new Node(i + 1, j + 1);
			}
		}
	}

	public Node[] getRow(Integer rowNo) {
		return grid[rowNo - 1];
	}

	public Node[] getColumn(Integer columnNo) {
		Node[] list = new Node[9];
		for (int i = 0; i < 9; i++) {
			list[i] = grid[i][columnNo - 1];
		}
		return list;
	}

	public Node[][] getBlock(Integer blockNumber) {
		Node[][] block = new Node[3][3];
		int startColumn = 3 * ((blockNumber - 1) % 3);
		int startRow = 3 * ((blockNumber - 1) / 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				block[i][j] = grid[startRow + i][startColumn + j];
			}
		}
		return block;
	}

	public void setValue(Integer rowNo, Integer columnNo, Integer value) {
		grid[rowNo - 1][columnNo - 1].value = value;
	}

	private boolean removeValueInColumn(List<Node> nodes, List<Integer> values) {
		List<RowColumnPair> rowColumnPairs = new ArrayList<>();
		int temp = (nodes.get(0).rowNo - 1) / 3;
		boolean allInSameBlock = true;
		for (int i = 0; i < nodes.size(); i++) {
			if (temp != (nodes.get(i).rowNo - 1) / 3) {
				allInSameBlock = false;
			}
			rowColumnPairs.add(new RowColumnPair(nodes.get(i).rowNo, nodes.get(i).columnNo));
		}

		for (int z = 0; z < nodes.size(); z++) {
			Integer rowNo = nodes.get(z).rowNo;
			Integer columnNo = nodes.get(z).columnNo;
			for (int i = 0; i < 9; i++) {
				if (!rowColumnPairs.contains(new RowColumnPair(i + 1, columnNo))) {
					grid[i][columnNo - 1].possibleValues.removeAll(values);
				}
			}

			if (allInSameBlock) {
				int blockRowStart = 3 * ((rowNo - 1) / 3);
				int blockCloumnStart = 3 * ((columnNo - 1) / 3);
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (!rowColumnPairs.contains(new RowColumnPair(i + blockRowStart + 1, j + blockCloumnStart + 1))
								&& grid[i + blockRowStart][j + blockCloumnStart].value == null) {
							grid[i + blockRowStart][j + blockCloumnStart].possibleValues.removeAll(values);
						}
					}
				}
			}
		}
		return rePopulate();
	}

	private boolean rePopulate() {
		boolean valueModified = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j].possibleValues.size() == 1) {
					grid[i][j].value = grid[i][j].possibleValues.get(0);
					grid[i][j].possibleValues.clear();
					ArrayList<Node> nodes = new ArrayList<>();
					nodes.add(grid[i][j]);
					ArrayList<Integer> values = new ArrayList<>();
					values.add(grid[i][j].value);
					removeValueInRow(nodes, values);
					removeValueInColumn(nodes, values);
					removeValueInGrid(nodes, values);
					valueModified = true;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j].value == null) {
					for (int k = 1; k <= 9; k++) {
						row(i, k);
						col(j, k);
					}
				}
			}
		}
		populatePossible();

		return valueModified;
	}

	private boolean row(int r, int k) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < 9; i++) {

			Integer value = grid[r][i].value;
			if (value == null) {
				List<Integer> possibleValues = grid[r][i].possibleValues;
				for (int j = 0; j < possibleValues.size(); j++) {
					if (!map.containsKey(possibleValues.get(j))) {
						map.put(possibleValues.get(j), new ArrayList<>());
					}
					map.get(possibleValues.get(j)).add(i);
				}
			}
		}
		for (int i = 1; i <= 9; i++) {
			List<Integer> list = map.get(i);
			if (list != null && list.size() == 1 && i == k) {
				return true;
			}
		}
		return false;
	}

	private boolean col(int c, int k) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < 9; i++) {

			Integer value = grid[i][c].value;
			if (value == null) {
				List<Integer> possibleValues = grid[i][c].possibleValues;
				for (int j = 0; j < possibleValues.size(); j++) {
					if (!map.containsKey(possibleValues.get(j))) {
						map.put(possibleValues.get(j), new ArrayList<>());
					}
					map.get(possibleValues.get(j)).add(i);
				}
			}
		}
		for (int i = 1; i <= 9; i++) {
			List<Integer> list = map.get(i);
			if (list != null && list.size() == 1 && i == k) {
				grid[list.get(0)][c].value = i;
				grid[list.get(0)][c].possibleValues.clear();
			}
		}

		return true;
	}

	private boolean sqr(int r, int c, int k) {
		int m = 3;
		int o = r / m;
		int l = c / m;

		for (int i = o * m; i < (o * m + m); i++) {
			for (int j = l * m; j < (l * m + m); j++) {
				Integer value = grid[i][j].value;
				if (value != null && k == value)
					return false;
			}
		}
		return true;
	}

	public void printGrid() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Integer value = grid[i][j].value;
				if (value != null) {
					System.out.print(value + " ");
				} else {
					if (grid[i][j].possibleValues.size() == 1) {
						System.err.print(grid[i][j].possibleValues.get(0) + " ");
					} else
						System.out.print("_ ");
				}
				// if (grid[i][j].value==null)
				// System.out.println(i + 1 + " " + (j + 1) + " " +
				// grid[i][j].possibleValues);
			}
			System.out.print("\n");
		}
	}

	public void populatePossible() {
		Map<Integer, List<Integer>> rowRetain = new HashMap<>();
		Map<Integer, List<Integer>> columnRetain = new HashMap<>();
		Map<Integer, List<Integer>> blockRetain = new HashMap<>();
		Integer[] allValues = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 0; i < 9; i++) {
			List<Integer> rowList = new ArrayList<>();
			List<Integer> columnList = new ArrayList<>();
			rowList.addAll(Arrays.asList(allValues));
			columnList.addAll(Arrays.asList(allValues));
			for (int j = 0; j < 9; j++) {
				if (grid[i][j].value != null) {
					rowList.remove(grid[i][j].value);
				}
				if (grid[j][i].value != null) {
					columnList.remove(grid[j][i].value);
				}
			}
			rowRetain.put(i, rowList);
			columnRetain.put(i, columnList);
		}
		for (int i = 0; i < 9; i++) {
			int startColumn = 3 * ((i) % 3);
			int startRow = 3 * ((i) / 3);
			List<Integer> blockList = new ArrayList<>();
			blockList.addAll(Arrays.asList(allValues));
			for (int k = 0; k < 3; k++) {
				for (int j = 0; j < 3; j++) {
					Node node = grid[startRow + k][startColumn + j];
					if (node.value != null) {
						blockList.remove(node.value);
					}
				}
			}
			blockRetain.put(i, blockList);
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j].value == null) {
					List<Integer> row = new ArrayList<>(rowRetain.get(i));
					List<Integer> column = new ArrayList<>(columnRetain.get(j));
					List<Integer> block = new ArrayList<>(blockRetain.get(3 * (i / 3) + j / 3));
					row.retainAll(column);
					row.retainAll(block);
					grid[i][j].possibleValues = row;
				}
			}
		}

	}

	public void getPreemptiveSet() {
		boolean atleastOneRemove = true;
		while (atleastOneRemove) {
			atleastOneRemove = false;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					List<Node> list = new ArrayList<>();
					list.add(grid[i][j]);
					for (int k = 0; k < 9; k++) {
						if (j != k && grid[i][k].value == null) {
							if (grid[i][j].possibleValues.containsAll(grid[i][k].possibleValues)) {
								list.add(grid[i][k]);
							}
						}
					}
					if (list.size() > 2 && list.size() == list.get(0).possibleValues.size()) {
						atleastOneRemove |= removeValueInRow(list, list.get(0).possibleValues);
					}
				}
			}

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					List<Node> list = new ArrayList<>();
					list.add(grid[j][i]);
					for (int k = 0; k < 9; k++) {
						if (j != k && grid[k][i].value == null) {
							if (grid[j][i].possibleValues.containsAll(grid[k][i].possibleValues)) {
								list.add(grid[k][i]);
							}
						}
					}
					if (list.size() > 2 && list.size() == list.get(0).possibleValues.size()) {
						atleastOneRemove |= removeValueInColumn(list, list.get(0).possibleValues);
					}
				}
			}

			for (int i = 0; i < 9; i++) {
				int startColumn = 3 * ((i) % 3);
				int startRow = 3 * ((i) / 3);
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						List<Node> list = new ArrayList<>();
						list.add(grid[j + startRow][startColumn + k]);
						for (int l = 0; l < 3; l++) {
							for (int m = 0; m < 3; m++) {
								if (!(j == l && k == m)
										&& !grid[l + startRow][m + startColumn].possibleValues.isEmpty()) {
									if (grid[j + startRow][startColumn + k].possibleValues
											.containsAll(grid[l + startRow][m + startColumn].possibleValues)) {
										list.add(grid[l + startRow][m + startColumn]);
									}
								}
							}
						}
						if (list.size() > 2 && list.size() == list.get(0).possibleValues.size()) {
							atleastOneRemove |= removeValueInGrid(list, list.get(0).possibleValues);
						}
					}
				}
			}
		}

	}

	private boolean removeValueInGrid(List<Node> nodes, List<Integer> values) {
		Integer rowNo = nodes.get(0).rowNo;
		Integer columnNo = nodes.get(0).columnNo;
		List<RowColumnPair> rowColumnPairs = new ArrayList<>();
		for (int i = 0; i < nodes.size(); i++) {
			rowColumnPairs.add(new RowColumnPair(nodes.get(i).rowNo, nodes.get(i).columnNo));
		}
		int blockRowStart = 3 * ((rowNo - 1) / 3);
		int blockCloumnStart = 3 * ((columnNo - 1) / 3);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!rowColumnPairs.contains(new RowColumnPair(i + blockRowStart + 1, j + blockCloumnStart + 1))
						&& grid[i + blockRowStart][j + blockCloumnStart].value == null) {
					grid[i + blockRowStart][j + blockCloumnStart].possibleValues.removeAll(values);
				}
			}
		}
		return rePopulate();

	}

	private boolean removeValueInRow(List<Node> nodes, List<Integer> values) {
		List<RowColumnPair> rowColumnPairs = new ArrayList<>();
		int temp = (nodes.get(0).columnNo - 1) / 3;
		boolean allInSameBlock = true;
		for (int i = 0; i < nodes.size(); i++) {
			if (temp != (nodes.get(i).columnNo - 1) / 3) {
				allInSameBlock = false;
			}
			rowColumnPairs.add(new RowColumnPair(nodes.get(i).rowNo, nodes.get(i).columnNo));
		}

		for (int z = 0; z < nodes.size(); z++) {
			Integer rowNo = nodes.get(z).rowNo;
			Integer columnNo = nodes.get(z).columnNo;
			for (int i = 0; i < 9; i++) {
				if (!rowColumnPairs.contains(new RowColumnPair(rowNo, i + 1))) {
					grid[rowNo - 1][i].possibleValues.removeAll(values);
				}
			}
			if (allInSameBlock) {
				int blockRowStart = 3 * ((rowNo - 1) / 3);
				int blockCloumnStart = 3 * ((columnNo - 1) / 3);
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (!rowColumnPairs.contains(new RowColumnPair(i + blockRowStart + 1, j + blockCloumnStart + 1))
								&& grid[i + blockRowStart][j + blockCloumnStart].value == null) {
							grid[i + blockRowStart][j + blockCloumnStart].possibleValues.removeAll(values);
						}
					}
				}
			}
		}
		return rePopulate();
	}

}

class RowColumnPair {
	int rowNo;
	int columnNo;

	public RowColumnPair(int rowNo, int columnNo) {
		this.rowNo = rowNo;
		this.columnNo = columnNo;
	}

	@Override
	public boolean equals(Object object) {
		RowColumnPair columnPair = (RowColumnPair) object;
		if (this.rowNo == columnPair.rowNo && this.columnNo == columnPair.columnNo)
			return true;
		return false;
	}
}