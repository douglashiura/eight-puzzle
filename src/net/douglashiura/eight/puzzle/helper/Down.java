package net.douglashiura.eight.puzzle.helper;

import net.douglashiura.eight.puzzle.Game;


public class Down implements Direction {

	@Override
	public void move(Game game) {
		game.moveDown();
	}

}
