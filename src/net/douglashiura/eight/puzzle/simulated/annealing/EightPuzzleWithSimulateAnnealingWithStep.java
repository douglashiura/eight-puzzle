package net.douglashiura.eight.puzzle.simulated.annealing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import net.douglashiura.eight.puzzle.EightPuzzle;
import net.douglashiura.eight.puzzle.helper.CostFunction;
import net.douglashiura.eight.puzzle.helper.Direction;
import net.douglashiura.eight.puzzle.helper.Directions;
import net.douglashiura.eight.puzzle.helper.Listener;

public class EightPuzzleWithSimulateAnnealingWithStep {

	private EightPuzzle eightPuzzle;
	private List<Direction> domain;
	private Function<EightPuzzle, Integer> cost;
	private Float temperature;
	private Float cooling;
	private Integer step;

	public EightPuzzleWithSimulateAnnealingWithStep(EightPuzzle eightPuzzle) {
		this(eightPuzzle, Directions.get(), new CostFunction());
	}

	public EightPuzzleWithSimulateAnnealingWithStep(EightPuzzle eightPuzzle, List<Direction> domain, Function<EightPuzzle, Integer> cost) {
		this.eightPuzzle = eightPuzzle;
		this.domain = domain;
		this.cost = cost;
		setDefaults();
	}

	public void setDefaults() {
		this.temperature = 100000.0f;
		this.cooling = 0.95f;
		this.step = 3;
	}

	public void solve(Listener listener) {
		while (temperature > 0.1) {
			List<Direction> steps = generateSteps();
			EightPuzzle temporary = eightPuzzle._clone();
			steps.forEach(step -> step.move(temporary));
			Integer currentCost = cost.apply(eightPuzzle);
			Integer temporaryCost = cost.apply(temporary);
			double probability = Math.pow(Math.E, (-temporaryCost - currentCost) / temperature);
			if (temporaryCost < currentCost || Math.random() < probability) {
				steps.forEach(step -> {
					step.move(eightPuzzle);
					listener.update();
				});
			}
			temperature = temperature * cooling;
		}
	}

	private List<Direction> generateSteps() {
		List<Direction> steps = new ArrayList<>(step);
		for (int i = 0; i < step; i++) {
			Collections.shuffle(domain);
			steps.add(domain.stream().findFirst().get());
		}
		return steps;
	}

	public void untilSolve(Listener updateView) {

		Integer iteraction = 0;
		while (!eightPuzzle.isOk()) {
			setDefaults();
			System.out.println("Try " + (iteraction++));
			solve(updateView);
		}
		System.out.println("Solved");
	}

}
