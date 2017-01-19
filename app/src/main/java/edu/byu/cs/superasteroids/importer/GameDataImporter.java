package edu.byu.cs.superasteroids.importer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import edu.byu.cs.superasteroids.model.base.IAsteroidsData;
import edu.byu.cs.superasteroids.model.base.AsteroidsData;
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
public class GameDataImporter implements IGameDataImporter {

	private static String makeString(Reader reader) throws IOException {

		StringBuilder sb = new StringBuilder();
		char[] buf = new char[512];

		int n = 0;
		while ((n = reader.read(buf)) > 0) {
			sb.append(buf, 0, n);
		}

		return sb.toString();
	}

	IAsteroidsData data = AsteroidsData.getInstance();

	@Override
	public boolean importData(InputStreamReader dataInputReader) {
		data.clearData();
		try {
			JSONObject json = new JSONObject(makeString(dataInputReader));
			json = json.getJSONObject("asteroidsGame");
			JSONArray array = json.getJSONArray("backgroundImages");
			parseBackgroundObjects(array);
			array = json.getJSONArray("asteroids");
			parseAsteroidTypes(array);
			array = json.getJSONArray("levels");
			parseLevels(array);
			array = json.getJSONArray("mainBodies");
			parseBodies(array);
			array = json.getJSONArray("cannons");
			parseCannons(array);
			array = json.getJSONArray("leftWings");
			parseLeftWings(array);
			array = json.getJSONArray("engines");
			parseEngines(array);
			array = json.getJSONArray("powerCores");
			parsePowerCores(array);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (JSONException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void parseBackgroundObjects(JSONArray array) throws JSONException {
		for (int i = 0; i < array.length(); i++) {
			data.addBackgroundImage(array.getString(i));
		}
	}

	private void parseAsteroidTypes(JSONArray array) throws JSONException {
		for (int i = 0; i < array.length(); i++) {
			JSONObject json = array.getJSONObject(i);
			data.addAsteroidType(new AsteroidType(json));
		}
	}

	private void parseLevels(JSONArray array) throws JSONException {
		for (int i = 0; i < array.length(); i++) {
			data.addLevel(new Level(array.getJSONObject(i)));
		}
	}

	private void parseBodies(JSONArray array) throws JSONException {
		for (int i = 0; i < array.length(); i++) {
			data.addBody(new MainBody(array.getJSONObject(i)));
		}
	}

	private void parseCannons(JSONArray array) throws JSONException {
		for (int i = 0; i < array.length(); i++) {
			data.addCannon(new Cannon(array.getJSONObject(i)));
		}
	}

	private void parseLeftWings(JSONArray array) throws JSONException {
		for (int i = 0; i < array.length(); i++) {
			data.addLeftWing(new LeftWing(array.getJSONObject(i)));
		}
	}

	private void parseEngines(JSONArray array) throws JSONException {
		for (int i = 0; i < array.length(); i++) {
			data.addEngine(new Engine(array.getJSONObject(i)));
		}
	}

	private void parsePowerCores(JSONArray array) throws JSONException {
		for (int i = 0; i < array.length(); i++) {
			data.addCore(new PowerCore(array.getJSONObject(i)));
		}
	}

}
