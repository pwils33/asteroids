package edu.byu.cs.superasteroids.game;

import edu.byu.cs.superasteroids.model.base.GameModel;

/**
 * Created by pwils33 on 10/24/2016.
 */
public enum GameState {

	TRANSITION {
		@Override
		public void draw() {
			GameModel.getInstance().transitionDraw();
		}

		@Override
		public GameState update(double elapsedTime) {
			time -= elapsedTime;
			if (time <= 0.0) {
				time = 5.0;
				return PLAYING;
			}
			return this;
		}
	},

	PLAYING {
		@Override
		public void draw() {

		}

		@Override
		public GameState update(double elapsedTime) {
			return this;
		}
	},

	GAME_END {
		@Override
		public void draw() {

		}

		@Override
		public GameState update(double elapsedTime) {
			return this;
		}
	};

	public abstract void draw();

	public abstract GameState update(double elapsedTime);

	private static double time = 5.0;
}
