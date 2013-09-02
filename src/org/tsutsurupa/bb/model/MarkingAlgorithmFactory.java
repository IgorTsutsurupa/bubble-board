package org.tsutsurupa.bb.model;

public class MarkingAlgorithmFactory {

	private static DepthFirstSearch dfs;

	public static MarkingAlgorithm getInstance() {
		if (dfs == null) {
			dfs = new DepthFirstSearch();
		}
		return dfs;
	}

}
