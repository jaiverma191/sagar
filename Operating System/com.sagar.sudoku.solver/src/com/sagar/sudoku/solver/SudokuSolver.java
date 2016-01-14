package com.sagar.sudoku.solver;

public class SudokuSolver {

	public static void main(String[] args) {
		SudokuGrid sudoku = SudokuSolverHelper.provideSudoku();
		sudoku.populatePossible();
		sudoku.printGrid();
		sudoku.getPreemptiveSet();
		System.out.println("jai");
		sudoku.printGrid();
	}
}
