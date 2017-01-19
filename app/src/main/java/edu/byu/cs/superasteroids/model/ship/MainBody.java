package edu.byu.cs.superasteroids.model.ship;

import org.json.JSONException;
import org.json.JSONObject;

import edu.byu.cs.superasteroids.content.ContentManager;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class MainBody {

	private String cannonAttach;
	private String leftAttach;
	private String engineAttach;
	private String image;
	private int width;
	private int height;
	private int imageId = -1;

	public MainBody(JSONObject json) throws JSONException {
		cannonAttach = json.getString("cannonAttach");
		leftAttach = json.getString("leftAttach");
		engineAttach = json.getString("engineAttach");
		image = json.getString("image");
		width = json.getInt("imageWidth");
		height = json.getInt("imageHeight");
	}

	public String getCannonAttach() {
		return cannonAttach;
	}

	public String getLeftAttach() {
		return leftAttach;
	}

	public String getEngineAttach() {
		return engineAttach;
	}

	public String getImage() {
		return image;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setImageId() {
		imageId = ContentManager.getInstance().loadImage(image);
	}

	public int getImageId() {
		return imageId;
	}

}
