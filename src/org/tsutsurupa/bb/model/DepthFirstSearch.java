package org.tsutsurupa.bb.model;

public class DepthFirstSearch implements MarkingAlgorithm {

	@Override
	public int markAll(Markable[][] markables, int i, int j) {
		if (!shouldMark(markables, i, j)) {
			return 0;
		}
		markables[i][j].mark();
		return 1 + markNeigbour(markables, i, j);
	}

	private int markNeigbour(Markable[][] markables, int i, int j) {
		int result = 0;
		result += markAll(markables, i, j + 1);
		result += markAll(markables, i, j - 1);
		result += markAll(markables, i + 1, j);
		result += markAll(markables, i - 1, j);
		return result;
	}

	private boolean shouldMark(Markable[][] markables, int i, int j) {
		if ((i < 0 || i >= markables.length)
				|| (j < 0 || j >= markables[0].length)) {
			return false;
		}
		return !markables[i][j].marked();
	}

}
