package org.tsutsurupa.bb.model;

public class BubbleBoard {

	public static final int DEFAULT_HEIGHT = 15;
	public static final int DEFAULT_WIDTH = 15;

	private Bubble[][] _board;

	public BubbleBoard() {
		this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
	}

	public BubbleBoard(int height, int length) {
		_board = new Bubble[height][length];
		fill();
	}

	public void setBubble(int i, int j, Bubble bubble) {
		_board[i][j] = bubble;
	}

	public Bubble getBubble(int i, int j) {
		return _board[i][j];
	}

	public int getHeight() {
		return _board.length;
	}

	public int getWidth() {
		return _board[0].length;
	}

	public void fill() {
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				setBubble(i, j, new Bubble(Color.getRandomColor()));
			}
		}
	}

	public int markAt(int i, int j) {
		return MarkingAlgorithmFactory.getInstance().markAll(_board, i, j);
	}

}
