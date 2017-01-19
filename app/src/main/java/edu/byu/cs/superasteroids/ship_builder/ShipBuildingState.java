package edu.byu.cs.superasteroids.ship_builder;

import java.util.ArrayList;
import java.util.List;

import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.model.base.AsteroidsData;
import edu.byu.cs.superasteroids.model.base.GameModel;
import edu.byu.cs.superasteroids.model.ship.Cannon;
import edu.byu.cs.superasteroids.model.ship.Engine;
import edu.byu.cs.superasteroids.model.ship.LeftWing;
import edu.byu.cs.superasteroids.model.ship.MainBody;
import edu.byu.cs.superasteroids.model.ship.PowerCore;

/**
 * Created by pwils33 on 10/24/2016.
 */
enum ShipBuildingState {

	MAIN_BODY{
		@Override
		public String getText(ViewDirection direction) {
			switch (direction) {
				case UP:
					return "Power Core";
				case DOWN:
					return "Engine";
				case LEFT:
					return "Left Wing";
				case RIGHT:
					return "Cannon";
			}
			return null;
		}

		@Override
		public ShipBuildingState getNextView(ViewDirection direction) {
			switch (direction) {
				case UP:
					return POWER_CORE;
				case DOWN:
					return ENGINE;
				case LEFT:
					return LEFT_WING;
				case RIGHT:
					return CANNON;
			}
			return null;
		}

		@Override
		public void loadContent(ShipBuildingActivity activity, ContentManager content) {
			List<Integer> ids = new ArrayList<>();
			for (MainBody body : AsteroidsData.getInstance().getBodies()) {
				ids.add(content.loadImage(body.getImage()));
			}
			activity.setPartViewImageList(this, ids);
		}

		@Override
		public void unloadContent(ContentManager content) {
			for (MainBody body: AsteroidsData.getInstance().getBodies()) {
				content.unloadImage(content.getImageId(body.getImage()));
			}
		}

		@Override
		public void selectPart(int index) {
			GameModel.getInstance().addMainBody(index);
		}
	},

	LEFT_WING{
		@Override
		public String getText(ViewDirection direction) {
			switch (direction) {
				case UP:
					return "Power Core";
				case DOWN:
					return "Engine";
				case LEFT:
					return "Cannon";
				case RIGHT:
					return "Main Body";
			}
			return null;
		}

		@Override
		public ShipBuildingState getNextView(ViewDirection direction) {
			switch (direction) {
				case UP:
					return POWER_CORE;
				case DOWN:
					return ENGINE;
				case LEFT:
					return CANNON;
				case RIGHT:
					return MAIN_BODY;
			}
			return null;
		}

		@Override
		public void loadContent(ShipBuildingActivity activity, ContentManager content) {
			List<Integer> ids = new ArrayList<>();
			for (LeftWing wing: AsteroidsData.getInstance().getLeftWings()) {
				ids.add(content.loadImage(wing.getImage()));
			}
			activity.setPartViewImageList(this, ids);
		}

		@Override
		public void unloadContent(ContentManager content) {
			for (LeftWing wing: AsteroidsData.getInstance().getLeftWings()) {
				content.unloadImage(content.getImageId(wing.getImage()));
			}
		}

		@Override
		public void selectPart(int index) {
			GameModel.getInstance().addLeftWing(index);
		}
	},

	CANNON {
		@Override
		public String getText(ViewDirection direction) {
			switch (direction) {
				case UP:
					return "Power Core";
				case DOWN:
					return "Engine";
				case LEFT:
					return "Main Body";
				case RIGHT:
					return "Left Wing";
			}
			return null;
		}

		@Override
		public ShipBuildingState getNextView(ViewDirection direction) {
			switch (direction) {
				case UP:
					return POWER_CORE;
				case DOWN:
					return ENGINE;
				case LEFT:
					return MAIN_BODY;
				case RIGHT:
					return LEFT_WING;
			}
			return null;
		}

		@Override
		public void loadContent(ShipBuildingActivity activity, ContentManager content) {
			List<Integer> ids = new ArrayList<>();
			for (Cannon cannon : AsteroidsData.getInstance().getCannons()) {
				ids.add(content.loadImage(cannon.getImage()));
			}
			activity.setPartViewImageList(this, ids);
		}

		@Override
		public void unloadContent(ContentManager content) {
			for (Cannon cannon: AsteroidsData.getInstance().getCannons()) {
				content.unloadImage(content.getImageId(cannon.getImage()));
			}
		}

		@Override
		public void selectPart(int index) {
			GameModel.getInstance().addCannon(index);
		}
	},

	ENGINE {
		@Override
		public String getText(ViewDirection direction) {
			switch (direction) {
				case UP:
					return "Main Body";
				case DOWN:
					return "Power Core";
				case LEFT:
					return "Left Wing";
				case RIGHT:
					return "Cannon";
			}
			return null;
		}

		@Override
		public ShipBuildingState getNextView(ViewDirection direction) {
			switch (direction) {
				case UP:
					return MAIN_BODY;
				case DOWN:
					return POWER_CORE;
				case LEFT:
					return LEFT_WING;
				case RIGHT:
					return CANNON;
			}
			return null;
		}

		@Override
		public void loadContent(ShipBuildingActivity activity, ContentManager content) {
			List<Integer> ids = new ArrayList<>();
			for (Engine engine: AsteroidsData.getInstance().getEngines()) {
				ids.add(content.loadImage(engine.getImage()));
			}
			activity.setPartViewImageList(this, ids);
		}

		@Override
		public void unloadContent(ContentManager content) {
			for (Engine engine: AsteroidsData.getInstance().getEngines()) {
				content.unloadImage(content.getImageId(engine.getImage()));
			}
		}

		@Override
		public void selectPart(int index) {
			GameModel.getInstance().addEngine(index);
		}
	},

	POWER_CORE {
		@Override
		public String getText(ViewDirection direction) {
			switch (direction) {
				case UP:
					return "Engine";
				case DOWN:
					return "Main Body";
				case LEFT:
					return "Left Wing";
				case RIGHT:
					return "Cannon";
			}
			return null;
		}

		@Override
		public ShipBuildingState getNextView(ViewDirection direction) {
			switch (direction) {
				case UP:
					return ENGINE;
				case DOWN:
					return MAIN_BODY;
				case LEFT:
					return LEFT_WING;
				case RIGHT:
					return CANNON;
			}
			return null;
		}

		@Override
		public void loadContent(ShipBuildingActivity activity, ContentManager content) {
			List<Integer> ids = new ArrayList<>();
			for (PowerCore core: AsteroidsData.getInstance().getCores()) {
				ids.add(content.loadImage(core.getImage()));
			}
			activity.setPartViewImageList(this, ids);
		}

		@Override
		public void unloadContent(ContentManager content) {
			for (PowerCore core: AsteroidsData.getInstance().getCores()) {
				content.unloadImage(content.getImageId(core.getImage()));
			}
		}

		@Override
		public void selectPart(int index) {
			GameModel.getInstance().addPowerCore(index);
		}
	};

	public abstract String getText(ViewDirection direction);

	public abstract ShipBuildingState getNextView(ViewDirection direction);

	public abstract void loadContent(ShipBuildingActivity activity, ContentManager content);

	public abstract void unloadContent(ContentManager content);

	public abstract void selectPart(int index);

}
