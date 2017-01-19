package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;
import android.graphics.Rect;

import edu.byu.cs.superasteroids.content.ContentManager;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.base.VisualObject;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class StaticBackground implements VisualObject {

	private static String image = "images/space.bmp";
	private static float imageDim = 2048f;

	private float widthScale = 1f;
	private float heightScale = 1f;
	private int imageId = -1;


	@Override
	public void loadImage(ContentManager content) {
		imageId = content.loadImage(image);
	}

	@Override
	public void draw() {
		PointF viewPosition = new PointF(ViewPort.getTopLeft().x, ViewPort.getTopLeft().y);
		float viewRight = (ViewPort.getWidth() + viewPosition.x) * widthScale;
		float viewBottom = (ViewPort.getHeight() + viewPosition.y) * heightScale;
		viewPosition.x = viewPosition.x * widthScale;
		viewPosition.y = viewPosition.y * heightScale;
		DrawingHelper.drawImage(imageId,new Rect((int)viewPosition.x, (int)viewPosition.y, (int)viewRight, (int)
				viewBottom),new Rect(0, 0, ViewPort.getWidth(), ViewPort.getHeight()));
	}

	public void setScale(float levelWidth, float levelHeight) {
		widthScale = imageDim/levelWidth;
		heightScale = imageDim/levelHeight;
	}
}
