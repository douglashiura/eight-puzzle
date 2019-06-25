package net.douglashiura.eight.puzzle.helper;

import net.douglashiura.eight.puzzle.Game;


public class Up implements Direction {

	@Override
	public void move(Game game) {
		game.moveUp();
	}

}
