package com.sagar.sudoku.solver;

public class SudokuSolverHelper {

	public static SudokuGrid provideSudoku() {
		SudokuGrid grid = new SudokuGrid();
		grid.setValue(1, 2, 3);
		grid.setValue(1, 3, 9);
		grid.setValue(1, 4, 5);

		grid.setValue(2, 3, 1);
		grid.setValue(2, 4, 8);
		grid.setValue(2, 6, 9);
		grid.setValue(2, 8, 7);

		grid.setValue(3, 5, 1);
		grid.setValue(3, 7, 9);
		grid.setValue(3, 9, 4);

		grid.setValue(4, 1, 1);
		grid.setValue(4, 4, 4);
		grid.setValue(4, 9, 3);

		// grid.setValue(5, 4, 5);
		// grid.setValue(5, 6, 4);

		grid.setValue(6, 3, 7);
		grid.setValue(6, 7, 8);
		grid.setValue(6, 8, 6);

		grid.setValue(7, 3, 6);
		grid.setValue(7, 4, 7);
		grid.setValue(7, 6, 8);
		grid.setValue(7, 7, 2);

		grid.setValue(8, 2, 1);
		grid.setValue(8, 5, 9);
		grid.setValue(8, 9, 5);

		grid.setValue(9, 6, 1);
		grid.setValue(9, 9, 8);

		return grid;
	}

}
