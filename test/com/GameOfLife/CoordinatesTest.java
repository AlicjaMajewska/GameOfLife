package com.GameOfLife;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CoordinatesTest {
	Coordinates coordin = new Coordinates(5, 7);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void shoudBeEqualWith5_7() {
		Coordinates newCoordinates= new Coordinates(5, 7);
	assertTrue(coordin.equals(newCoordinates));
	}
	@Test
	public void shoudBeEqualWith5_7ForHashCode() {
		Coordinates newCoordinates= new Coordinates(5, 7);
		assertEquals(coordin.hashCode(), newCoordinates.hashCode());
	}
	@Test
	public void shoudBeEqualWith7_7() {
		Coordinates newCoordinates= new Coordinates(7, 7);
		assertFalse(coordin.equals(newCoordinates));
	}
	@Test
	public void shoudNotBeEqualWith7_7ForHashCode() {
		Coordinates newCoordinates= new Coordinates(7, 7);
		assertNotEquals(coordin.hashCode(), newCoordinates.hashCode());
	}

	@Test
	public void shoudReturnGroupOf8Neighbours() {
		List<Coordinates> neighbourList = new ArrayList<Coordinates>();
		neighbourList.add(new Coordinates(4, 6));
		neighbourList.add(new Coordinates(5, 6));
		neighbourList.add(new Coordinates(6, 6));
		neighbourList.add(new Coordinates(4, 7));
		neighbourList.add(new Coordinates(6, 7));
		neighbourList.add(new Coordinates(4, 8));
		neighbourList.add(new Coordinates(5, 8));
		neighbourList.add(new Coordinates(6, 8));
		assertEquals(coordin.getNearestCoordiantes(), neighbourList);
	}
}
