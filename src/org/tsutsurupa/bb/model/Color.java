package org.tsutsurupa.bb.model;

import java.util.Random;

public enum Color {

	RED, BLUE, GREEN, YELLOW;

	public static Color getRandomColor() {
		Color[] colors = values();
		Random r = new Random();
		return colors[r.nextInt(colors.length)];
	}

}