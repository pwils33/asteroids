package edu.byu.cs.superasteroids.model.ship;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class Engine extends ShipAppendage {

	private int baseSpeed;
	private int baseTurnRate;

	public Engine(JSONObject json) throws JSONException {
		super(json.getString("attachPoint"), json.getString("image"),
				json.getInt("imageWidth"), json.getInt("imageHeight"));
		baseSpeed = json.getInt("baseSpeed");
		baseTurnRate = json.getInt("baseTurnRate");
	}

}
