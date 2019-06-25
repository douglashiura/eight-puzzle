package net.douglashiura.eight.puzzle.simulated.annealing;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import net.douglashiura.eight.puzzle.EightPuzzle;
import net.douglashiura.eight.puzzle.helper.CostFunction;
import net.douglashiura.eight.puzzle.helper.Direction;
import net.douglashiura.eight.puzzle.helper.Directions;
import net.douglashiura.eight.puzzle.helper.Listener;

public class EightPuzzleWithSimulateAnnealing {

	private EightPuzzle eightPuzzle;
	private List<Direction> domain;
	private Function<EightPuzzle, Integer> cost;
	private Float temperature;
	private Float cooling;

	public EightPuzzleWithSimulateAnnealing(EightPuzzle eightPuzzle) {
		this(eightPuzzle, Directions.get(), new CostFunction());
	}

	public EightPuzzleWithSimulateAnnealing(EightPuzzle eightPuzzle, List<Direction> domain, Function<EightPuzzle, Integer> cost) {
		this.eightPuzzle = eightPuzzle;
		this.domain = domain;
		this.cost = cost;
		setDefaults();
	}

	public void setDefaults() {
		this.temperature = 100000.0f;
		this.cooling = 0.95f;
	}

	public void solve(Predicate<Boolean> solve, Listener listener) {
		while (temperature > 0.1) {
			Collections.shuffle(domain);
			Direction direction = domain.stream().findFirst().get();
			EightPuzzle temporary = eightPuzzle._clone();
			direction.move(temporary); // step erver 1
			Integer currentCost = cost.apply(eightPuzzle);
			Integer temporaryCost = cost.apply(temporary);
			double probability = Math.pow(Math.E, (-temporaryCost - currentCost) / temperature);
			if (solve.test(temporaryCost < currentCost) || Math.random() < probability) {
				direction.move(eightPuzzle);
				listener.update();
			}
			temperature = temperature * cooling;
		}
	}

	public void untilSolve(Listener updateView) {

		Integer iteraction = 0;
		while (!eightPuzzle.isOk()) {
			setDefaults();
			System.out.println("Try " + (iteraction++));
			solve(solver -> solver, updateView);
		}
		System.out.println("Solved");
	}

}
