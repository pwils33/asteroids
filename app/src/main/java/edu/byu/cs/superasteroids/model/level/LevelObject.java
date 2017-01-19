package edu.byu.cs.superasteroids.model.level;

import org.json.JSONException;
import org.json.JSONObject;

import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.model.base.AsteroidsData;
import edu.byu.cs.superasteroids.model.base.PositionedObject;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class LevelObject extends PositionedObject {

	private int objectId;
	private float scale;

	public LevelObject(JSONObject json) throws JSONException {
		super(json.getString("position"), null);
		objectId = json.getInt("objectId");
		scale = (float)json.getDouble("scale");
	}

	@Override
	public void loadImage(ContentManager content) {
		setImageId(content.loadImage(AsteroidsData.getInstance().getBackgroundImage(objectId)));
	}

	@Override
	protected float getScale() {
		return scale;
	}

	@Override
	protected double getDirection() {
		return 0.0;
	}

	@Override
	public void draw() {

	}
}
