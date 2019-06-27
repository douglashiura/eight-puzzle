package net.douglashiura.eight.puzzle.view;

import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import net.douglashiura.eight.puzzle.EightPuzzle;
import net.douglashiura.eight.puzzle.Home;
import net.douglashiura.eight.puzzle.helper.Listener;
import net.douglashiura.eight.puzzle.simulated.annealing.EightPuzzleWithSimulateAnnealing;
import net.douglashiura.eight.puzzle.simulated.annealing.EightPuzzleWithSimulateAnnealingWithStep;

public class EightPuzzleView extends JFrame implements KeyListener {

	private static final long serialVersionUID = 7501477593258854262L;
	private EightPuzzle game;
	private List<HomeView> houses;
	private Listener listener;

	public EightPuzzleView() {
		listener = new UpdateView();
		setTitle("Eight puzzle");
		game = new EightPuzzle();
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 3));
		houses = new ArrayList<HomeView>(9);
		for (Home home : game.getHouses()) {
			HomeView homeView = new HomeView(home, this);
			houses.add(homeView);
			add(homeView);
		}
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		addKeyListener(this);
		setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new EightPuzzleView();
			}
		});

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_F1:
			new EightPuzzleWithSimulateAnnealingWithStep(game).untilSolve(listener);
			break;
		case KeyEvent.VK_F2:
			new EightPuzzleWithSimulateAnnealing(game).solve(solve -> !solve, listener);
			break;
		case KeyEvent.VK_LEFT:
			game.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			game.moveRight();
			break;
		case KeyEvent.VK_UP:
			game.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			game.moveDown();
			break;
		default:
			break;
		}
		updateHouses();

	}

	class UpdateView implements Listener {
		@Override
		public void update() {
			updateHouses();
			try {
				Robot robot = new Robot();
				BufferedImage image = robot.createScreenCapture(getBounds());
				ImageIO.write(image, "png", new File(System.currentTimeMillis() + "(" + game.cost() + ")" + ".png"));
			} catch (Exception e) {
			}
		}
	}

	private void updateHouses() {
		houses.forEach(house -> {
			house.setValue();
		});
		setTitle(String.format("Eight puzzle (%s)", game.cost()));
		update(getGraphics());
		try {
			Thread.sleep(0, 1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
