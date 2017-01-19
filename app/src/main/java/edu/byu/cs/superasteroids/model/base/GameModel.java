package edu.byu.cs.superasteroids.model.base;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.ViewPort;
import edu.byu.cs.superasteroids.model.level.Level;
import edu.byu.cs.superasteroids.model.ship.Ship;
import edu.byu.cs.superasteroids.ship_builder.IShipBuildingView;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class GameModel {

	private static GameModel instance;

	public static GameModel getInstance() {
		if (instance == null) {
			instance = new GameModel();
		}
		return instance;
	}

	private GameModel() {
	}

	private IAsteroidsData data = AsteroidsData.getInstance();

	private Ship spaceShip = new Ship();
	private Level currentLevel;
	private int levelNum = 0;

	public boolean isShipComplete() {
		return spaceShip.isComplete();
	}

	public void onGameStart(ContentManager content) {
		getNextLevel();
	}

	public boolean getNextLevel() {
		currentLevel = data.getLevel(levelNum);
		levelNum++;
		return currentLevel != null;
	}

	public void addMainBody(int index) {
		spaceShip.setBody(data.getBody(index));
		spaceShip.setPosition(new PointF(ViewPort.getWidth()/2, (ViewPort.getHeight()/2) - 80));
	}

	public void addCannon(int index) {
		spaceShip.setCannon(data.getCannon(index));
	}

	public void addLeftWing(int index) {
		spaceShip.setLeftWing(data.getLeftWing(index));
	}

	public void addEngine(int index) {
		spaceShip.setEngine(data.getEngine(index));
	}

	public void addPowerCore(int index) {
		spaceShip.setCore(data.getCore(index));
	}

	public void loadShip() {
		spaceShip.loadParts();
	}

	public void drawShip() {
		spaceShip.draw();
	}

	public void draw() {
		drawShip();
	}

	public void update(double time) throws LevelFinishedException {

	}

	public void transitionDraw() {
		drawMessage(currentLevel.getHint());
	}

	public void drawMessage(String message) {
		DrawingHelper.drawCenteredText(message, 10, 10);
	}

}
