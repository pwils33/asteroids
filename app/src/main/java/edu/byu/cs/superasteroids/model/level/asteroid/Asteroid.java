package edu.byu.cs.superasteroids.model.level.asteroid;

import android.graphics.PointF;

import java.util.List;
import java.util.Random;

import edu.byu.cs.superasteroids.model.ViewPort;
import edu.byu.cs.superasteroids.model.base.MovingObject;

/**
 * Created by pwils33 on 10/19/2016.
 */
public abstract class Asteroid extends MovingObject {

	private static Random rand = new Random();

	public Asteroid(PointF position, String image, double direction) {

		super(position, image, direction);
	}

	@Override
	public void draw() {

	}

	@Override
	public void update(double time) {

	}

	public abstract List<Asteroid> onCollision(MovingObject other);

	@Override
	protected double getDirection() {
		return 0;
	}

	protected static PointF getRandomStart(int levelWidth, int levelHeight) {
		PointF start = new PointF(ViewPort.getTopLeft().x, ViewPort.getTopLeft().y);
		while (ViewPort.inView(start)) {
			start.x = rand.nextFloat() * (float) levelWidth;
			start.y = rand.nextFloat() * (float) levelHeight;
		}
		return start;
	}

	protected static double getRandomDirection() {
		return rand.nextDouble() * (2*Math.PI);
	}

}
