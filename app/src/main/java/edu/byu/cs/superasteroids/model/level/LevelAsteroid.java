package edu.byu.cs.superasteroids.model.level;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class LevelAsteroid {

	private int number;
	private int asteroidId;

	public LevelAsteroid(JSONObject json) throws JSONException {
		number = json.getInt("number");
		asteroidId = json.getInt("asteroidId");
	}

	public int getNumber() {
		return number;
	}

	public int getAsteroidId() {
		return asteroidId;
	}

}
