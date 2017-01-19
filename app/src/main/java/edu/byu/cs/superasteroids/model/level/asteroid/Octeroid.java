package edu.byu.cs.superasteroids.model.level.asteroid;

import java.util.List;

import edu.byu.cs.superasteroids.model.base.MovingObject;
import edu.byu.cs.superasteroids.model.level.AsteroidType;
import edu.byu.cs.superasteroids.model.level.asteroid.Asteroid;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class Octeroid extends Asteroid {

	public Octeroid(AsteroidType info, int levelWidth, int levelHeight) {
		super(getRandomStart(levelWidth, levelHeight), info.getImage(), getRandomDirection());
	}

	@Override
	public List<Asteroid> onCollision(MovingObject other) {
		return null;
	}

	@Override
	protected double getSpeed() {
		return 0;
	}

	@Override
	protected float getScale() {
		return 0;
	}
}
