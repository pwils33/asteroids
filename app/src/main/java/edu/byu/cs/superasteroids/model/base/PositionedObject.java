package edu.byu.cs.superasteroids.model.base;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;

/**
 * Created by pwils33 on 10/19/2016.
 */
public abstract class PositionedObject implements VisualObject {

	protected PointF position;
	private String image;
	private int imageId;

	public PositionedObject(String position, String image) {
		this.position = coordinateToPoint(position);
		this.image = image;
	}

	public PositionedObject(PointF position, String image) {
		this.position = position;
		this.image = image;
	}

	public static PointF coordinateToPoint(String coordinate) {
		String[] points = coordinate.split(",");
		return new PointF(Float.parseFloat(points[0]), Float.parseFloat(points[1]));
	}

	public void loadImage(ContentManager content) {
		setImageId(content.loadImage(image));
	}

	protected void setImageId(int id) {
		imageId = id;
	}

	protected abstract float getScale();

	protected abstract double getDirection();

	@Override
	public void draw() {
		DrawingHelper.drawImage(imageId, position.x, position.y, getDirection(), getScale(), getScale(), 255);
	}

}
