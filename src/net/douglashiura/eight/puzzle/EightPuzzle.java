package net.douglashiura.eight.puzzle;

import java.util.ArrayList;
import java.util.List;

public class EightPuzzle extends Game {

	private List<Home> houses;

	public EightPuzzle() {
		Home home1 = new Home(1);
		Home home2 = new Home(2);
		Home home3 = new Home(3);
		Home home4 = new Home(4);
		Home home5 = new Home(5);
		Home home6 = new Home(6);
		Home home7 = new Home(7);
		Home home8 = new Home(8);
		Home home9 = new Home(9);
		Home border = new Border();
		home1.setNeighbordhood(border, border, home2, home4);
		home2.setNeighbordhood(home1, border, home3, home5);
		home3.setNeighbordhood(home2, border, border, home6);
		home4.setNeighbordhood(border, home1, home5, home7);
		home5.setNeighbordhood(home4, home2, home6, home8);
		home6.setNeighbordhood(home5, home3, border, home9);
		home7.setNeighbordhood(border, home4, home8, border);
		home8.setNeighbordhood(home7, home5, home9, border);
		home9.setNeighbordhood(home8, home6, border, border);

		houses = new ArrayList<>(9);
		houses.add(home1);
		houses.add(home2);
		houses.add(home3);
		houses.add(home4);
		houses.add(home5);
		houses.add(home6);
		houses.add(home7);
		houses.add(home8);
		houses.add(home9);
		super.setControl(home9);
	}

	@Override
	public List<Home> getHouses() {
		return houses;
	}

	public Boolean isOk() {
		return Integer.valueOf((int) houses.stream().filter(home -> home.isOk()).count()).equals(houses.size());
	}

	public EightPuzzle _clone() {
		EightPuzzle clone = new EightPuzzle();
		for (int i = 0; i < houses.size(); i++) {
			try {
				clone.getHouses().get(i).setPiece(houses.get(i).getPiece());
			} catch (BorderException e) {
				e.printStackTrace();
			}
		}
		clone.setEmpty(clone.houses.get(houses.indexOf(getEmpty())));

		return clone;
	}

	@Override
	public String toString() {
		return String.format("%s	%s	%s\n%s	%s	%s\n%s	%s	%s\n ", houses.get(0).getPiece()
				,houses.get(1).getPiece()
				,houses.get(2).getPiece()
				,houses.get(3).getPiece()
				,houses.get(4).getPiece()
				,houses.get(5).getPiece()
				,houses.get(6).getPiece()
				,houses.get(7).getPiece()
				,houses.get(8).getPiece());
	}

}
