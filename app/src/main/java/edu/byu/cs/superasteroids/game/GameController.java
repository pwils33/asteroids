package edu.byu.cs.superasteroids.game;

import android.util.Log;

import edu.byu.cs.superasteroids.base.IGameDelegate;
import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.StaticBackground;
import edu.byu.cs.superasteroids.model.ViewPort;
import edu.byu.cs.superasteroids.model.base.GameModel;

/**
 * Created by pwils33 on 10/24/2016.
 */
public class GameController implements IGameDelegate {

	private StaticBackground background = new StaticBackground();
	private GameModel model = GameModel.getInstance();
	private GameState state = GameState.TRANSITION;

	@Override
	public void update(double elapsedTime) {
		state = state.update(elapsedTime);
	}

	@Override
	public void loadContent(ContentManager content) {
		background.loadImage(content);
		model.onGameStart(content);
	}

	@Override
	public void unloadContent(ContentManager content) {
		Log.d("TAG", "test");
	}

	@Override
	public void draw() {
		if (DrawingHelper.getGameViewWidth() != ViewPort.getWidth()) {
			ViewPort.setHeight(DrawingHelper.getGameViewHeight());
			ViewPort.setWidth(DrawingHelper.getGameViewWidth());
		}
		background.draw();
	}
}
