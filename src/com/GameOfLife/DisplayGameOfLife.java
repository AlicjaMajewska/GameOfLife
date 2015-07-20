package com.GameOfLife;

public class DisplayGameOfLife {

	public static void displayGameOfLife(GameOfLifeBoard game) {
		Boolean[][] game2dArray = game.get2DArray();
		for (Boolean[] booleans : game2dArray) {
			for (Boolean boolean1 : booleans) {
				if (boolean1) {
					System.out.print("# ");
				}
				if (!boolean1) {
					System.out.print("_ ");
				}
			}
			System.out.println("");
		}
	}
}
