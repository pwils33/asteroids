package edu.byu.cs.superasteroids.model.ship;

import org.json.JSONException;
import org.json.JSONObject;

import edu.byu.cs.superasteroids.model.level.Level;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class LeftWing extends ShipAppendage {

	public LeftWing(JSONObject json) throws JSONException {
		super(json.getString("attachPoint"), json.getString("image"),
				json.getInt("imageWidth"), json.getInt("imageHeight"));
	}

}
