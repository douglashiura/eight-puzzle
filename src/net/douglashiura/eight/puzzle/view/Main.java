package net.douglashiura.eight.puzzle.view;

import net.douglashiura.eight.puzzle.EightPuzzle;
import net.douglashiura.eight.puzzle.simulated.annealing.EightPuzzleWithSimulateAnnealing;

public class Main implements net.douglashiura.eight.puzzle.helper.Listener {

	private EightPuzzle game;

	public Main() throws InterruptedException {

		game = new EightPuzzle();
		System.out.println(game);
		EightPuzzleWithSimulateAnnealing simulateAnnealing = new EightPuzzleWithSimulateAnnealing(game);
		simulateAnnealing.solve(t -> !t, this);
		System.out.println("Solving");
		Thread.sleep(1000);
		simulateAnnealing.untilSolve(this);

	}

	@Override
	public void update() {
		System.out.println(game);

	}
	public static void main(String[] args) throws InterruptedException {
		new Main();
	}

}
