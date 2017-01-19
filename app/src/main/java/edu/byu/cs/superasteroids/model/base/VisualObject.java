package edu.byu.cs.superasteroids.model.base;

import edu.byu.cs.superasteroids.content.ContentManager;

/**
 * Created by pwils33 on 10/19/2016.
 */
public interface VisualObject {

	void loadImage(ContentManager content);

	void draw();

}
