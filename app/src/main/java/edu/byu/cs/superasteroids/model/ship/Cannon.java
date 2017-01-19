package edu.byu.cs.superasteroids.model.ship;

import android.graphics.PointF;

import org.json.JSONException;
import org.json.JSONObject;

import edu.byu.cs.superasteroids.core.GraphicsUtils;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class Cannon extends ShipAppendage {

	private PointF emitPoint;
	private String attackImage;
	private int attackImageWidth;
	private int attackImageHeight;
	private String attackSound;


	public Cannon(JSONObject json) throws JSONException {
		super(json.getString("attachPoint"), json.getString("image"),
				json.getInt("imageWidth"), json.getInt("imageHeight"));
		String[] points = json.getString("emitPoint").split(",");
		emitPoint = new PointF(Float.parseFloat(points[0]), Float.parseFloat(points[1]));
		attackImage = json.getString("attackImage");
		attackImageWidth = json.getInt("attackImageWidth");
		attackImageHeight = json.getInt("attackImageHeight");
		attackSound = json.getString("attackSound");
	}

	@Override
	public void rotateAbout(PointF shipCenter, double rotation) {
		super.rotateAbout(shipCenter, rotation);
		emitPoint = rotateAbout(shipCenter, emitPoint, rotation);
	}

	@Override
	public void setCenter(PointF offset) {
		super.setCenter(offset);
		emitPoint = GraphicsUtils.add(offset, emitPoint);
	}

}
