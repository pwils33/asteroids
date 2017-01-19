package edu.byu.cs.superasteroids.model.level.asteroid;

import java.util.List;

import edu.byu.cs.superasteroids.model.base.MovingObject;
import edu.byu.cs.superasteroids.model.level.AsteroidType;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class GrowingAsteroid extends Asteroid {

	public GrowingAsteroid(AsteroidType info, int levelWidth, int levelHeight) {
		super(getRandomStart(levelWidth, levelHeight), info.getImage(), getRandomDirection());
	}

	@Override
	public void update(double time) {
		super.update(time);
		// TODO: 10/19/2016 make it grow
	}

	@Override
	protected double getSpeed() {
		return 0;
	}

	@Override
	public List<Asteroid> onCollision(MovingObject other) {
		return null;
	}

	@Override
	protected float getScale() {
		return 0;
	}
}
