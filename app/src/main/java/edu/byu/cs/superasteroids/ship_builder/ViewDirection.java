package edu.byu.cs.superasteroids.ship_builder;

/**
 * Created by pwils33 on 10/24/2016.
 */
enum ViewDirection {
	LEFT, RIGHT, UP, DOWN;

	private ViewDirection opposite;

	static {
		LEFT.opposite = RIGHT;
		RIGHT.opposite = LEFT;
		UP.opposite = DOWN;
		DOWN.opposite = UP;
	}

	public ViewDirection getOpposite() {
		return opposite;
	}
}