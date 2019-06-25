package net.douglashiura.eight.puzzle;

public class Border extends Home {

	public Border() {
		super(null);
	}

	@Override
	public Integer getPiece() {
		throw new BorderException();
	}

}
