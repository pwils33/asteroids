package edu.byu.cs.superasteroids.model.ship;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.model.base.MovingObject;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class Lazer extends MovingObject {

	private static final float LAZER_SCALE = .3f;
	private static final double LAZER_SPEED = 600d;

	public Lazer(PointF position, String image, double direction) {
		super(position, image, direction);
	}

	@Override
	protected double getSpeed() {
		return LAZER_SPEED;
	}

	@Override
	protected float getScale() {
		return LAZER_SCALE;
	}

	@Override
	protected double getDirection() {
		return direction - (Math.PI/2.0);
	}

}
