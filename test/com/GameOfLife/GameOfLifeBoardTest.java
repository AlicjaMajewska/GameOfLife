package com.GameOfLife;

import  org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeBoardTest {
	GameOfLifeBoard game;
	@Before
	public void setUp() {
		int sizeX = 5;
		int sizeY = 5;
		boolean [][] board = new boolean[][] {
			{false,true,false,true,false},
			{false,true,false,false,false},
			{false,true,true,true,false},
			{false,false,false,true,false},
			{false,true,false,true,false}
		};
		game = new GameOfLifeBoard(sizeX, sizeY, board);
	}

	@Test
	public void shouldDisplayStartingGame() {
		
		boolean [][] board = new boolean[][] {
				{false,true,false,true,false},
				{false,true,false,false,false},
				{false,true,true,true,false},
				{false,false,false,true,false},
				{false,true,false,true,false}
			};
		
		Assert.assertArrayEquals(board, game.get2DArray());
	}
	@Test
	public void shouldDisplaySecondBoard() {
		game.nextGeneration();
		boolean [][] board = new boolean[][] {
				{false,false,true,false,false},
				{true,true,false,true,false},
				{false,true,false,true,false},
				{false,true,false,true,true},
				{false,false,true,false,false}
			};
		Assert.assertArrayEquals(board, game.get2DArray());
	}
	@Test
	public void shouldDisplayThirdBoard() {
		game.nextGeneration();
		game.nextGeneration();
		boolean [][] board = new boolean[][] {
				{false,true,true,false,false},
				{true,true,false,true,false},
				{false,true,false,true,false},
				{false,true,false,true,true},
				{false,false,true,true,false}
			};
		Assert.assertArrayEquals(board, game.get2DArray());
	}

}
