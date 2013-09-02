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
				setBubble(i, j, new Bubble(Colour.getRandomColour()));
			}
		}
	}

	public int markAt(int i, int j) {
		return MarkingAlgorithmFactory.getInstance().markAll(_board, i, j);
	}
	
//	public static void dropping(int score) {
//		if (score >= 3) {
//			for (int i = 0; i < HEIGHT; i++) {
//				for (int j = 0; j < WIDTH; j++) {
//					if (markedBoard[i][j]) {
//						board[i][j].color = Color.WHITE;
//					}
//				}
//			}
//			for (int i = 0; i < WIDTH; i++) {
//				for (int j = HEIGHT - 1; j >= 0 ; j--) {
//					if(markedBoard[j][i]) {
//						for(int t = j - 1, k = 0; t >= 0; t--) {
//							if(!markedBoard[t][i]) {
//								board[j - k][i].getValues(board[t][i]);
//								board[t][i].color = Color.WHITE;
//								k++;
//							}
//						}
//						columns[i] = j;
//						break;
//					}
//				}
//			}
//		}
//	}

	public static void main(String[] args) {
		System.out.println("ttt");
		new BubbleBoard();
	}
}
