package edu.byu.cs.superasteroids.model.level;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class AsteroidType {

	private String type;
	private String image;
	private int imageWidth;
	private int imageHeight;

//	public AsteroidType(String type, String image, int imageWidth, int imageHeight) {
//		this.type = type;
//		this.image = image;
//		this.imageWidth = imageWidth;
//		this.imageHeight = imageHeight;
//	}

	public AsteroidType(JSONObject json) throws JSONException {
		type = json.getString("type");
		image = json.getString("image");
		imageWidth = json.getInt("imageWidth");
		imageHeight = json.getInt("imageHeight");
	}

	public String getType() {
		return type;
	}

	public String getImage() {
		return image;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}
}
