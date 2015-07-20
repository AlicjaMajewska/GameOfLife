package com.GameOfLife;

import java.util.ArrayList;
import java.util.List;

public class Coordinates {

	private int x;
	private int y;

	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public List<Coordinates> getNearestCoordiantes() {
		List<Coordinates> NearestCoordinates = new ArrayList<Coordinates>();
		NearestCoordinates.add(new Coordinates(x - 1, y - 1));
		NearestCoordinates.add(new Coordinates(x, y - 1));
		NearestCoordinates.add(new Coordinates(x + 1, y - 1));
		NearestCoordinates.add(new Coordinates(x - 1, y));
		NearestCoordinates.add(new Coordinates(x + 1, y));
		NearestCoordinates.add(new Coordinates(x - 1, y + 1));
		NearestCoordinates.add(new Coordinates(x, y + 1));
		NearestCoordinates.add(new Coordinates(x + 1, y + 1));
		return NearestCoordinates;
	}


}
