package edu.byu.cs.superasteroids.model.level;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.model.base.IAsteroidsData;
import edu.byu.cs.superasteroids.model.level.asteroid.Asteroid;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class Level {

	private int number;
	private String title;
	private String hint;
	private int width;
	private int height;
	private String music;
	private List<LevelAsteroid> asteroidInfo;
	private List<LevelObject> levelObjects;
	private List<Asteroid> asteroids;

	public Level(JSONObject json) throws JSONException {
		number = json.getInt("number");
		title = json.getString("title");
		hint = json.getString("hint");
		width = json.getInt("width");
		height = json.getInt("height");
		music = json.getString("music");
		JSONArray array = json.getJSONArray("levelAsteroids");
		asteroidInfo = new ArrayList<>(array.length());
		for (int i = 0; i < array.length(); i++) {
			asteroidInfo.add(new LevelAsteroid(array.getJSONObject(i)));
		}
		array = json.getJSONArray("levelObjects");
		levelObjects = new ArrayList<>(array.length());
		for (int i = 0; i < array.length(); i++) {
			levelObjects.add(new LevelObject(array.getJSONObject(i)));
		}
	}

	public void onLevelStart(IAsteroidsData data) {
		asteroids = new ArrayList<>();
		for (int i = 0; i < asteroidInfo.size(); i++) {
			LevelAsteroid temp = asteroidInfo.get(i);
			for (int j = 0; j < temp.getNumber(); j++) {
				switch(data.getAsteroidType(temp.getAsteroidId()).getType()) {
					case "regular":

				}
			}
		}
	}

	public int getNumber() {
		return number;
	}

	public String getTitle() {
		return title;
	}

	public String getHint() {
		return hint;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getMusic() {
		return music;
	}



	public void loadLevel(ContentManager content) {

	}

}