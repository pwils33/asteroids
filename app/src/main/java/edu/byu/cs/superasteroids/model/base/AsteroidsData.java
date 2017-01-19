package edu.byu.cs.superasteroids.model.base;

import java.util.ArrayList;
import java.util.List;

import edu.byu.cs.superasteroids.model.level.AsteroidType;
import edu.byu.cs.superasteroids.model.level.Level;
import edu.byu.cs.superasteroids.model.ship.Cannon;
import edu.byu.cs.superasteroids.model.ship.Engine;
import edu.byu.cs.superasteroids.model.ship.LeftWing;
import edu.byu.cs.superasteroids.model.ship.MainBody;
import edu.byu.cs.superasteroids.model.ship.PowerCore;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class AsteroidsData implements IAsteroidsData {

	List<String> backgroundImages;
	List<AsteroidType> asteroids;
	List<Level> levels;
	List<MainBody> bodies;
	List<Cannon> cannons;
	List<LeftWing> leftWings;
	List<Engine> engines;
	List<PowerCore> cores;

	private AsteroidsData() {
		backgroundImages = new ArrayList<>();
		asteroids = new ArrayList<>();
		levels = new ArrayList<>();
		bodies = new ArrayList<>();
		cannons = new ArrayList<>();
		leftWings = new ArrayList<>();
		engines = new ArrayList<>();
		cores = new ArrayList<>();
	}

	private static AsteroidsData instance;

	public static AsteroidsData getInstance()  {
		if (instance == null) {
			instance = new AsteroidsData();
		}
		return instance;
	}

	public void clearData() {
		backgroundImages.clear();
		asteroids.clear();
		levels.clear();
		bodies.clear();
		cannons.clear();
		leftWings.clear();
		engines.clear();
		cores.clear();
	}

	public String getBackgroundImage(int objectId) {
		return backgroundImages.get(objectId - 1);
	}

	public void addBackgroundImage(String image) {
		backgroundImages.add(image);
	}

	public AsteroidType getAsteroidType(int asteroidId) {
		return asteroids.get(asteroidId - 1);
	}

	public void addAsteroidType(AsteroidType asteroid) {
		asteroids.add(asteroid);
	}

	public Level getLevel(int levelNum) {
		if (levelNum >= levels.size()) {
			return null;
		}
		return levels.get(levelNum);
	}

	public void addLevel(Level level) {
		levels.add(level);
	}

	public List<MainBody> getBodies() {
		return bodies;
	}

	public MainBody getBody(int index) {
		return bodies.get(index);
	}

	public void addBody(MainBody body) {
		bodies.add(body);
	}

	public List<Cannon> getCannons() {
		return cannons;
	}

	public Cannon getCannon(int index) {
		return cannons.get(index);
	}

	public void addCannon(Cannon cannon) {
		cannons.add(cannon);
	}

	public List<LeftWing> getLeftWings() {
		return leftWings;
	}

	public LeftWing getLeftWing(int index) {
		return leftWings.get(index);
	}

	public void addLeftWing(LeftWing wing) {
		leftWings.add(wing);
	}

	public List<Engine> getEngines() {
		return engines;
	}

	public Engine getEngine(int index) {
		return engines.get(index);
	}

	public void addEngine(Engine engine) {
		engines.add(engine);
	}

	public List<PowerCore> getCores() {
		return cores;
	}

	public PowerCore getCore(int index) {
		return cores.get(index);
	}

	public void addCore(PowerCore core) {
		cores.add(core);
	}

}
