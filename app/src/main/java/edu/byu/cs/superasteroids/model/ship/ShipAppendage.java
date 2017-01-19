package edu.byu.cs.superasteroids.model.ship;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.core.GraphicsUtils;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class ShipAppendage {

	private String attachPoint;
	private String image;
	private int width;
	private int height;
	private PointF center;
	private int imageId = -1;

	public ShipAppendage(String attachPoint, String image, int width, int height) {
		this.attachPoint = attachPoint;
		this.image = image;
		this.width = width;
		this.height = height;
		center = new PointF(width/2f, height/2f);
	}

	public void rotateAbout(PointF shipCenter, double rotation) {
		center = rotateAbout(shipCenter, center, rotation);
	}

	protected PointF rotateAbout(PointF shipCenter, PointF shipPoint, double rotation) {
		PointF rotate = GraphicsUtils.subtract(shipPoint, shipCenter);
		rotate = GraphicsUtils.rotate(rotate, rotation);
		return GraphicsUtils.add(rotate, shipCenter);
	}

	public void setCenter(PointF position) {
		center = position;
	}

	public String getAttachPoint() {
		return attachPoint;
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

	public PointF getCenter() {
		return center;
	}

	public void setImageId() {
		imageId = ContentManager.getInstance().loadImage(image);
	}

	public void draw(double rotation, float scale) {
        DrawingHelper.drawImage(imageId, center.x, center.y, rotation, scale, scale, 255);
    }

}
