package com.GameOfLife;

public class Main {

	public static void main(String[] args) {
		GameOfLifeBoard game = new GameOfLifeBoard(10, 10);
		for (int i = 0; i < 10; ++i) {
			DisplayGameOfLife.displayGameOfLife(game);
			game.nextGeneration();
		}

	}
}
