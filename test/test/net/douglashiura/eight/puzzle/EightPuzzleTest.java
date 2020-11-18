package test.net.douglashiura.eight.puzzle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.douglashiura.eight.puzzle.EightPuzzle;

public class EightPuzzleTest {

	private EightPuzzle game;

	@BeforeEach
	void setUp() {
		game = new EightPuzzle();
	}

	@Test
	void game() throws Exception {
		assertEquals(Integer.valueOf(9), game.getHouses().get(8).getPiece());
		assertEquals(Integer.valueOf(8), game.getHouses().get(7).getPiece());
		assertEquals(Integer.valueOf(7), game.getHouses().get(6).getPiece());
		assertEquals(Integer.valueOf(6), game.getHouses().get(5).getPiece());
		assertEquals(Integer.valueOf(5), game.getHouses().get(4).getPiece());
		assertEquals(Integer.valueOf(4), game.getHouses().get(3).getPiece());
		assertEquals(Integer.valueOf(3), game.getHouses().get(2).getPiece());
		assertEquals(Integer.valueOf(2), game.getHouses().get(1).getPiece());
		assertEquals(Integer.valueOf(1), game.getHouses().get(0).getPiece());
		assertTrue(game.isOk());
		assertEquals(Integer.valueOf(0), game.cost());
	}

	@Test
	void moveUp() throws Exception {
		game.moveUp();
		assertEquals(Integer.valueOf(6), game.getHouses().get(8).getPiece());
		assertEquals(Integer.valueOf(8), game.getHouses().get(7).getPiece());
		assertEquals(Integer.valueOf(7), game.getHouses().get(6).getPiece());
		assertEquals(Integer.valueOf(9), game.getHouses().get(5).getPiece());
		assertEquals(Integer.valueOf(5), game.getHouses().get(4).getPiece());
		assertEquals(Integer.valueOf(4), game.getHouses().get(3).getPiece());
		assertEquals(Integer.valueOf(3), game.getHouses().get(2).getPiece());
		assertEquals(Integer.valueOf(2), game.getHouses().get(1).getPiece());
		assertEquals(Integer.valueOf(1), game.getHouses().get(0).getPiece());
		assertFalse(game.isOk());
		assertEquals(Integer.valueOf(6), game.cost());
	}

	@Test
	void moveUp_Left() throws Exception {
		game.moveUp();
		game.moveLeft();
		assertEquals(Integer.valueOf(6), game.getHouses().get(8).getPiece());
		assertEquals(Integer.valueOf(8), game.getHouses().get(7).getPiece());
		assertEquals(Integer.valueOf(7), game.getHouses().get(6).getPiece());
		assertEquals(Integer.valueOf(5), game.getHouses().get(5).getPiece());
		assertEquals(Integer.valueOf(9), game.getHouses().get(4).getPiece());
		assertEquals(Integer.valueOf(4), game.getHouses().get(3).getPiece());
		assertEquals(Integer.valueOf(3), game.getHouses().get(2).getPiece());
		assertEquals(Integer.valueOf(2), game.getHouses().get(1).getPiece());
		assertEquals(Integer.valueOf(1), game.getHouses().get(0).getPiece());
		assertFalse(game.isOk());
		assertEquals(Integer.valueOf(8), game.cost());
	}

	@Test
	void moveUp_Left_Down() throws Exception {
		game.moveUp();
		game.moveLeft();
		game.moveDown();
		assertEquals(Integer.valueOf(6), game.getHouses().get(8).getPiece());
		assertEquals(Integer.valueOf(9), game.getHouses().get(7).getPiece());
		assertEquals(Integer.valueOf(7), game.getHouses().get(6).getPiece());
		assertEquals(Integer.valueOf(5), game.getHouses().get(5).getPiece());
		assertEquals(Integer.valueOf(8), game.getHouses().get(4).getPiece());
		assertEquals(Integer.valueOf(4), game.getHouses().get(3).getPiece());
		assertEquals(Integer.valueOf(3), game.getHouses().get(2).getPiece());
		assertEquals(Integer.valueOf(2), game.getHouses().get(1).getPiece());
		assertEquals(Integer.valueOf(1), game.getHouses().get(0).getPiece());
		assertFalse(game.isOk());
		assertEquals(Integer.valueOf(8), game.cost());
	}

	@Test
	void moveUp_Left_Down_Rigth() throws Exception {
		game.moveUp();
		game.moveLeft();
		game.moveDown();
		game.moveRight();
		assertEquals(Integer.valueOf(9), game.getHouses().get(8).getPiece());
		assertEquals(Integer.valueOf(6), game.getHouses().get(7).getPiece());
		assertEquals(Integer.valueOf(7), game.getHouses().get(6).getPiece());
		assertEquals(Integer.valueOf(5), game.getHouses().get(5).getPiece());
		assertEquals(Integer.valueOf(8), game.getHouses().get(4).getPiece());
		assertEquals(Integer.valueOf(4), game.getHouses().get(3).getPiece());
		assertEquals(Integer.valueOf(3), game.getHouses().get(2).getPiece());
		assertEquals(Integer.valueOf(2), game.getHouses().get(1).getPiece());
		assertEquals(Integer.valueOf(1), game.getHouses().get(0).getPiece());
		assertFalse(game.isOk());
		assertEquals(Integer.valueOf(6), game.cost());
	}

	@Test
	void _clone() throws Exception {
		game.moveUp();
		game.moveLeft();
		game.moveDown();
		EightPuzzle clone = game._clone();
		assertEquals(Integer.valueOf(6), clone.getHouses().get(8).getPiece());
		assertEquals(Integer.valueOf(9), clone.getHouses().get(7).getPiece());
		assertEquals(Integer.valueOf(7), clone.getHouses().get(6).getPiece());
		assertEquals(Integer.valueOf(5), clone.getHouses().get(5).getPiece());
		assertEquals(Integer.valueOf(8), clone.getHouses().get(4).getPiece());
		assertEquals(Integer.valueOf(4), clone.getHouses().get(3).getPiece());
		assertEquals(Integer.valueOf(3), clone.getHouses().get(2).getPiece());
		assertEquals(Integer.valueOf(2), clone.getHouses().get(1).getPiece());
		assertEquals(Integer.valueOf(1), clone.getHouses().get(0).getPiece());
		assertFalse(clone.isOk());
		assertEquals(Integer.valueOf(8), clone.cost());
		assertEquals(game.getEmpty().getIndex(), clone.getEmpty().getIndex());
	}

}
