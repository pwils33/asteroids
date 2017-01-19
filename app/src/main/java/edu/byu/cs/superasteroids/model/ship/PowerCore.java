package edu.byu.cs.superasteroids.model.ship;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class PowerCore {

	private int cannonBoost;
	private int engineBoost;
	private String image;

	public PowerCore(JSONObject json) throws JSONException {
		cannonBoost = json.getInt("cannonBoost");
		engineBoost = json.getInt("engineBoost");
		image = json.getString("image");
	}

	public int getCannonBoost() {
		return cannonBoost;
	}

	public int getEngineBoost() {
		return engineBoost;
	}

	public String getImage() {
		return image;
	}
}
