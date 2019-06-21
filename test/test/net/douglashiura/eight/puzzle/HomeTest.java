package test.net.douglashiura.eight.puzzle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.douglashiura.eight.puzzle.Home;

public class HomeTest {

	private Home home;
	private Home left;
	private Home top;
	private Home right;
	private Home down;

	@BeforeEach
	void setUp() {
		home = new Home(5);
		left = new Home(4);
		top = new Home(2);
		right = new Home(6);
		down = new Home(8);
		home.setNeighbordhood(left, top, right, down);
	}

	@Test
	void is() throws Exception {
		assertEquals(new Integer(5), home.getPiece());
		assertTrue(home.isOk());
	}

	@Test
	void moveDown() throws Exception {
		assertEquals(down, home.moveDown());
		assertEquals(new Integer(8), home.getPiece());
		assertFalse(home.isOk());
	}

	@Test
	void moveUp() throws Exception {
		assertEquals(top, home.moveUp());
		assertEquals(new Integer(2), home.getPiece());
		assertFalse(home.isOk());
	}

	@Test
	void moveRight() throws Exception {
		assertEquals(right, home.moveRight());
		assertEquals(new Integer(6), home.getPiece());
		assertFalse(home.isOk());
	}

	@Test
	void moveLeft() throws Exception {
		assertEquals(left, home.moveLeft());
		assertEquals(new Integer(4), home.getPiece());
		assertFalse(home.isOk());
	}

}
