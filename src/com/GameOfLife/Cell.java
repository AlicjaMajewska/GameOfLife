package com.GameOfLife;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private List<Cell> neighbours = new ArrayList<Cell>();
	Boolean alive;
	Boolean nextState;

	Cell(Boolean alive) {
		this.alive = alive;
	}

	public void addNeighbours(List<Cell> cells) {
		for (Cell cell : cells) {
			if (cell != null) {
				neighbours.add(cell);
			}
		}
	}

	
	public Boolean isAlive() {
		return alive;
	}

	public char print() {
		if (alive) {
			return '*';
		} else
			return ' ';
	}

	public void changeState() {
		alive = nextState;
	}

	public void setNextState() {
		nextState = alive;
		int aliveNeighbours = countAliveNeighbours();
		if (aliveNeighbours < 2 || aliveNeighbours > 3) {
			nextState = false;
		}
		if ((alive && aliveNeighbours == 2) || aliveNeighbours == 3) {
			nextState = true;
		}

	}

	private int countAliveNeighbours() {
		int aliveNeighbour = 0;
		for (Cell cell : neighbours) {
			if (cell.isAlive()) {
				++aliveNeighbour;
			}
		}
		return aliveNeighbour;
	}

}
