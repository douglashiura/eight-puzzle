package net.douglashiura.eight.puzzle.view;

import java.awt.Font;

import javax.swing.JButton;

import net.douglashiura.eight.puzzle.Home;

public class HomeView extends JButton {

	private static final long serialVersionUID = 1L;
	private Home home;

	public HomeView(Home home, EightPuzzleView eightPuzzleView) {
		this.home = home;
		setValue();
		addKeyListener(eightPuzzleView);
		setFont( new Font("Arial", Font.PLAIN, 40));
	}

	public void setValue() {
		setText(home.getPiece().equals(new Integer(9)) ? "" : home.getPiece().toString());
		update(getGraphics());
	}

}
