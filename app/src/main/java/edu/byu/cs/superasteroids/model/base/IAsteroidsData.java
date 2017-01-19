package edu.byu.cs.superasteroids.model.base;

import java.util.List;

import edu.byu.cs.superasteroids.model.level.AsteroidType;
import edu.byu.cs.superasteroids.model.level.Level;
import edu.byu.cs.superasteroids.model.ship.Cannon;
import edu.byu.cs.superasteroids.model.ship.Engine;
import edu.byu.cs.superasteroids.model.ship.LeftWing;
import edu.byu.cs.superasteroids.model.ship.MainBody;
import edu.byu.cs.superasteroids.model.ship.PowerCore;

/**
 * Created by pwils33 on 10/20/2016.
 */
public interface IAsteroidsData {

	void clearData();

	String getBackgroundImage(int objectId);

	void addBackgroundImage(String image);

	AsteroidType getAsteroidType(int asteroidId);

	void addAsteroidType(AsteroidType asteroid);

	Level getLevel(int levelNum);

	void addLevel(Level level);

	List<MainBody> getBodies();

	MainBody getBody(int index);

	void addBody(MainBody body);

	List<Cannon> getCannons();

	Cannon getCannon(int index);

	void addCannon(Cannon cannon);

	List<LeftWing> getLeftWings();

	LeftWing getLeftWing(int index);

	void addLeftWing(LeftWing wing);

	List<Engine> getEngines();

	Engine getEngine(int index);

	void addEngine(Engine engine);

	List<PowerCore> getCores();

	PowerCore getCore(int index);

	void addCore(PowerCore core);
	
}
