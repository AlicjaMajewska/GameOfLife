package com.GameOfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class CellTest {
	Cell cell = new Cell(true);
	List<Cell> cellsList;
	Cell lonelyCell = new Cell(true);
	List<Cell> lonelyCellsList;

	@Before
	public void setUp() {
		cellsList = new ArrayList<Cell>();
		for (int i = 0; i < 5; ++i) {
			cellsList.add(new Cell(i % 2 == 0));
		}
		cell.addNeighbours(cellsList);
		lonelyCellsList = new ArrayList<Cell>();
		for (int i = 0; i < 4; ++i) {
			lonelyCellsList.add(new Cell(false));
		}
	}

	@Test
	public void shouldBeTrueForCellIsAlive() {
		Assert.assertTrue(cell.isAlive());
	}

	@Test
	public void shouldDisplayAliveCell() {
		Assert.assertTrue(cell.isAlive());
	}

	@Test
	public void shouldDisplayDeadCell() {
		lonelyCell.setNextState();
		lonelyCell.changeState();
		Assert.assertFalse(lonelyCell.isAlive());
	}

	@Test
	public void shouldBeTrueForCellNextState() {
		cell.setNextState();
		cell.changeState();
		Assert.assertTrue(cell.isAlive());
	}

	@Test
	public void shouldBeFalseForCellNextState() {
		List<Cell> newCellsList = new ArrayList<Cell>();
		newCellsList.add(new Cell(true));
		cell.addNeighbours(newCellsList);
		cell.setNextState();
		cell.changeState();
		Assert.assertFalse(cell.isAlive());
	}

	@Test
	public void shouldBeFalseForNextGenWhenNeighboursAreAdded() {
		List<Cell> newCellsList = new ArrayList<Cell>();
		newCellsList.add(new Cell(true));
		newCellsList.add(new Cell(true));
		cell.addNeighbours(newCellsList);
		cell.setNextState();
		cell.changeState();
		Assert.assertFalse(cell.isAlive());
	}

	@Test
	public void shouldBeDead() {
		List<Cell> newCellsList = new ArrayList<Cell>();
		newCellsList.add(new Cell(true));
		cell.addNeighbours(newCellsList);
		cell.setNextState();
		cell.changeState();
		Assert.assertFalse(cell.isAlive());
	}

	@Test
	public void lonelyCellshouldBeDeadInNextGeneration() {
		lonelyCell.setNextState();
		lonelyCell.changeState();
		Assert.assertFalse(lonelyCell.isAlive());
	}

	@Test
	public void lonelyCellShouldLiveInTwoGenerationsWhenNeighboursAreAdded() {
		lonelyCell.setNextState();
		lonelyCell.changeState();
		List<Cell> newCellsList = new ArrayList<Cell>();
		newCellsList.add(new Cell(true));
		newCellsList.add(new Cell(true));
		newCellsList.add(new Cell(true));
		lonelyCell.addNeighbours(newCellsList);
		lonelyCell.setNextState();
		lonelyCell.changeState();
		Assert.assertTrue(lonelyCell.isAlive());
	}

	@Test
	public void lonelyCellShouldStayAliveWhenTwoNeighboursAreAdded() {
		List<Cell> newCellsList = new ArrayList<Cell>();
		newCellsList.add(new Cell(true));
		newCellsList.add(new Cell(true));
		lonelyCell.addNeighbours(newCellsList);
		lonelyCell.setNextState();
		lonelyCell.changeState();
		Assert.assertTrue(lonelyCell.isAlive());
	}

}
