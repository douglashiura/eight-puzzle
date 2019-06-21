package net.douglashiura.eight.puzzle.view;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import net.douglashiura.eight.puzzle.EightPuzzle;
import net.douglashiura.eight.puzzle.Home;

public class EightPuzzleView extends JFrame implements KeyListener {

	private static final long serialVersionUID = 7501477593258854262L;
	private EightPuzzle game;
	private List<HomeView> houses;

	public EightPuzzleView() {
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
		new EightPuzzleView();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
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

	private void updateHouses() {
		houses.forEach(house -> {
			house.setValue();
		});
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
