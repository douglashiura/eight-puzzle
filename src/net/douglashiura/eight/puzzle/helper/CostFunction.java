package net.douglashiura.eight.puzzle.helper;

import java.util.function.Function;

import net.douglashiura.eight.puzzle.EightPuzzle;

public class CostFunction implements Function<EightPuzzle, Integer> {

	@Override
	public Integer apply(EightPuzzle t) {
		return t.cost();
	}

}
