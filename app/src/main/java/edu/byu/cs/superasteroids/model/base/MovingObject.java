package edu.byu.cs.superasteroids.model.base;

import android.graphics.PointF;
import android.graphics.RectF;

import edu.byu.cs.superasteroids.core.GraphicsUtils;
import edu.byu.cs.superasteroids.model.base.PositionedObject;

/**
 * Created by pwils33 on 10/19/2016.
 */
public abstract class MovingObject extends PositionedObject {

	protected double direction;
	protected RectF boundary;

	public MovingObject(PointF position, String image, double direction) {
		super(position, image);
		this.direction = direction;
	}

	public void update(double time) {
		GraphicsUtils.MoveObjectResult move = GraphicsUtils.moveObject(position, boundary, getSpeed(), direction, time);
	}

	protected abstract double getSpeed();

	public void setPosition(PointF position) {
        this.position = position;
    }

}
