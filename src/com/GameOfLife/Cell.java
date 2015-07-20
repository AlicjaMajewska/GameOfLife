package com.GameOfLife;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private List<Cell> neighbours = new ArrayList<Cell>();
	private STATE actualState;
	private STATE nextState;
	public enum STATE {DEAD, ALIVE};
	Cell(Boolean alive) {
		this.actualState = STATE.DEAD;
		if(alive){
			this.actualState = STATE.ALIVE;
		}
	}

	public void addNeighbours(List<Cell> cells) {
		for (Cell cell : cells) {
			if (cell != null) {
				neighbours.add(cell);
			}
		}
	}

	public Boolean isAlive() {
		return STATE.ALIVE.equals(actualState);
	}

	public void changeState() {
		actualState = nextState;
	}

	public void setNextState() {
		nextState = actualState;
		int aliveNeighbours = countAliveNeighbours();
		if (aliveNeighbours < 2 || aliveNeighbours > 3) {
			nextState = STATE.DEAD;
		}
		if ((STATE.ALIVE.equals(actualState) && aliveNeighbours == 2) || aliveNeighbours == 3) {
			nextState = STATE.ALIVE;
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
