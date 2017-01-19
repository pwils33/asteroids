package edu.byu.cs.superasteroids.ship_builder;

import edu.byu.cs.superasteroids.base.IView;
import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.ViewPort;
import edu.byu.cs.superasteroids.model.base.GameModel;

/**
 * Created by pwils33 on 10/20/2016.
 */
public class ShipBuildingController implements IShipBuildingController {

	ShipBuildingActivity activity;
	ShipBuildingState currentView = ShipBuildingState.MAIN_BODY;


	public ShipBuildingController(ShipBuildingActivity activity) {
		this.activity = activity;
	}

	@Override
	public void onViewLoaded(ShipBuildingState partView) {
		activity.setStartGameButton(GameModel.getInstance().isShipComplete());
		activity.setArrow(currentView, ViewDirection.UP, true, currentView.getText(ViewDirection.UP));
		activity.setArrow(currentView, ViewDirection.DOWN, true, currentView.getText(ViewDirection.DOWN));
		activity.setArrow(currentView, ViewDirection.LEFT, true, currentView.getText(ViewDirection.LEFT));
		activity.setArrow(currentView, ViewDirection.RIGHT, true, currentView.getText(ViewDirection.RIGHT));
	}

	@Override
	public void update(double elapsedTime) {

	}

	@Override
	public void loadContent(ContentManager content) {
		currentView.loadContent(activity, content);
	}

	@Override
	public void unloadContent(ContentManager content) {
		currentView.unloadContent(content);
	}

	@Override
	public void draw() {
		if (DrawingHelper.getGameViewWidth() != ViewPort.getWidth()) {
			ViewPort.setHeight(DrawingHelper.getGameViewHeight());
            ViewPort.setWidth(DrawingHelper.getGameViewWidth());
		}
		GameModel.getInstance().drawShip();
	}

	@Override
	public void onSlideView(ViewDirection direction) {
		unloadContent(ContentManager.getInstance());
		ViewDirection opposite = direction.getOpposite();
		currentView = currentView.getNextView(opposite);
		GameModel.getInstance().loadShip();
		activity.animateToView(currentView, opposite);
	}

	@Override
	public void onPartSelected(int index) {
		currentView.selectPart(index);
		GameModel.getInstance().loadShip();
		activity.setStartGameButton(GameModel.getInstance().isShipComplete());
	}

	@Override
	public void onStartGamePressed() {
		activity.startGame();
		unloadContent(ContentManager.getInstance());
	}

	@Override
	public void onResume() {

	}

	@Override
	public IView getView() {
		return null;
	}

	@Override
	public void setView(IView view) {

	}
}
