package edu.byu.cs.superasteroids.model.base;

/**
 * Created by pwils33 on 10/25/2016.
 */
public class LevelFinishedException extends Exception {

	private boolean gameFinished;

	public LevelFinishedException(boolean gameFinished) {
		this.gameFinished = gameFinished;
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

}
