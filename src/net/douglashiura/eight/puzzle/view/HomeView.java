package net.douglashiura.eight.puzzle.view;

import java.awt.Font;

import javax.swing.JLabel;

import net.douglashiura.eight.puzzle.Home;

public class HomeView extends JLabel {

	private static final long serialVersionUID = 1L;
	private Home home;

	public HomeView(Home home, EightPuzzleView eightPuzzleView) {
		this.home = home;
		setValue();
		addKeyListener(eightPuzzleView);
		setFont(new Font("Arial", Font.PLAIN, 10));
	}

	public void setValue() {
		setText(home.getPiece().equals(Integer.valueOf(9)) ? "" : home.getPiece().toString());
		update(getGraphics());
	}

}
