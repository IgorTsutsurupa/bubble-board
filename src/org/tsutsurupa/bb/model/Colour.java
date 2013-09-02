package org.tsutsurupa.bb.model;

import java.util.Random;

public enum Colour {

	RED, BLUE, GREEN, YELLOW;
	
	private static final Random RANDOM = new Random();

	public static Colour getRandomColour() {
		Colour[] colors = values();
		return colors[RANDOM.nextInt(colors.length)];
	}

}