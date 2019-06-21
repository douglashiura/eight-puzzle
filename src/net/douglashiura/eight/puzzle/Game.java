package net.douglashiura.eight.puzzle;

import java.util.List;

public abstract class Game {

	private Home empty;

	public abstract List<Home> getHouses();

	protected void setControl(Home home) {
		empty = home;
	}

	public void moveUp() {
		empty = empty.moveUp();
	}

	public void moveLeft() {
		empty = empty.moveLeft();
	}

	public void moveDown() {
		empty = empty.moveDown();
	}

	public void moveRight() {
		empty = empty.moveRight();
	}

	public Integer cost() {
		return getHouses().stream().mapToInt(home -> {
			return Math.abs(home.getPiece() - home.getIndex());
		}).sum();
	}

}
