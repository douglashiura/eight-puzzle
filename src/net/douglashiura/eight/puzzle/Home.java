package net.douglashiura.eight.puzzle;

public class Home {

	private Home left;
	private Home top;
	private Home right;
	private Home down;
	private Integer index;
	private Integer piece;

	public Home(Integer index) {
		this.index = index;
		this.piece = index;
	}

	public void setNeighbordhood(Home left, Home top, Home right, Home down) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.down = down;
	}

	public Integer getPiece() {
		return piece;
	}

	public Home moveDown() {
		return moveTo(down);
	}

	private void setPiece(Integer piece) {
		this.piece = piece;
	}

	public Home moveUp() {
		return moveTo(top);
	}

	private Home moveTo(Home here) {
		Integer piece = here.getPiece();
		here.setPiece(getPiece());
		setPiece(piece);
		return here;
	}

	public Home moveRight() {
		return moveTo(right);
	}

	public Home moveLeft() {
		return moveTo(left);
	}

	public Boolean isOk() {
		return index == piece;
	}

	public Integer getIndex() {
		return index;
	}

}
