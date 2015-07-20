package com.GameOfLife;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameOfLifeBoard {
	int xSize;
	int ySize;

	private Map<Coordinates, Cell> cellMap;
	
	public GameOfLifeBoard(int x, int y){
		Random random = new Random();
		xSize = x;
		ySize = y;
		cellMap = new HashMap<Coordinates, Cell>(x * y);
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				cellMap.put(new Coordinates(i, j), new Cell(random.nextBoolean()));
			}
		}
		addNeighboursToCell();
	}
		
	

	public GameOfLifeBoard(int x, int y, boolean[][] board) {
		xSize = x;
		ySize = y;
		cellMap = new HashMap<Coordinates, Cell>(x * y);
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				cellMap.put(new Coordinates(i, j), new Cell(board[i][j]));
			}
		}
		addNeighboursToCell();
	}

	private void addNeighboursToCell() {
		for (int i = 0; i < xSize; ++i) {
			for (int j = 0; j < ySize; ++j) {
				Coordinates coordinates = new Coordinates(i, j);
				cellMap.get(coordinates).addNeighbours(
						findCellNeighbours(coordinates));
			}
		}
	}

	private List<Cell> findCellNeighbours(Coordinates coor) {
		List<Cell> cellNeighbours = new ArrayList<Cell>();
		List<Coordinates> nearestCoordiantes = coor.getNearestCoordiantes();
		for (Coordinates coordinates : nearestCoordiantes) {
			cellNeighbours.add(cellMap.get(coordinates));
		}
		return cellNeighbours;
	}

	public void nextGeneration() {
		for (Map.Entry<Coordinates, Cell> entry : cellMap.entrySet()) {
			entry.getValue().setNextState();
		}
		for (Map.Entry<Coordinates, Cell> entry : cellMap.entrySet()) {
			entry.getValue().changeState();
		}
	}

	public void display() {
		for (int i = 0; i < xSize; ++i) {
			for (int j = 0; j < ySize; ++j) {
				Coordinates coordinates = new Coordinates(i, j);
				System.out.print(cellMap.get(coordinates).print() + "|");
				
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public Boolean[][] get2DArray() {
		Boolean [][] lifeArray = new Boolean[xSize][ySize];
		for (int i = 0; i < xSize; ++i) {
			for (int j = 0; j < ySize; ++j) {
				Coordinates coordinates = new Coordinates(i, j);
				lifeArray[i][j] = cellMap.get(coordinates).isAlive();
			}
		}
		return lifeArray;
	}

}
