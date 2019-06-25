package net.douglashiura.eight.puzzle.helper;

import java.util.Arrays;
import java.util.List;

public class Directions {

	public static List<Direction> get() {
		return Arrays.asList(new Left(), new Down(), new Up(), new Right());
	}

}
