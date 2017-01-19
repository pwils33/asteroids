package edu.byu.cs.superasteroids.model.ship;

import android.graphics.PointF;

import edu.byu.cs.superasteroids.core.GraphicsUtils;
import edu.byu.cs.superasteroids.drawing.DrawingHelper;
import edu.byu.cs.superasteroids.model.base.MovingObject;
import edu.byu.cs.superasteroids.model.base.PositionedObject;

/**
 * Created by pwils33 on 10/19/2016.
 */
public class Ship extends MovingObject {

	private static final double HALF_PI = (Math.PI/2.0);

	private MainBody body;
	private Cannon cannon;
	private Engine engine;
	private LeftWing leftWing;
	private PowerCore core;

	public Ship() {
		super(new PointF(), null, -HALF_PI);
	}

	@Override
	public void update(double time) {

	}

	@Override
	protected double getSpeed() {
		return 0;
	}

	@Override
	protected float getScale() {
		return .5f;
	}

	@Override
	protected double getDirection() {
		return direction + (Math.PI /2.0);
	}

	@Override
	public void draw() {
		if (body != null) {
			DrawingHelper.drawImage(body.getImageId(), position.x, position.y, direction + HALF_PI , getScale(), getScale(), 255);
			if (cannon != null) {
				cannon.draw(direction + HALF_PI, getScale());
			}
			if (leftWing != null) {
				leftWing.draw(direction + HALF_PI, getScale());
			}
			if (engine != null) {
				engine.draw(direction + HALF_PI, getScale());
			}
		}
	}

	public void setBody(MainBody body) {
		this.body = body;
		if (cannon != null) {
			offsetAppendage(cannon, this.body.getCannonAttach());
		}
		if (engine != null) {
			offsetAppendage(engine, this.body.getEngineAttach());
		}
		if (leftWing != null) {
			offsetAppendage(leftWing, this.body.getLeftAttach());
		}
	}

	public void setCannon(Cannon cannon) {
		this.cannon = cannon;
		offsetAppendage(this.cannon, body.getCannonAttach());
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
		offsetAppendage(this.engine, body.getEngineAttach());
	}

	public void setLeftWing(LeftWing leftWing) {
		this.leftWing = leftWing;
		offsetAppendage(this.leftWing, body.getLeftAttach());
	}

	public void setCore(PowerCore core) {
		this.core = core;
	}

	public void offsetAppendage(ShipAppendage part, String bodyAttach) {
		//finds distance between attach point and center then scales distance
		PointF bodyOffset = PositionedObject.coordinateToPoint(bodyAttach);
		bodyOffset = GraphicsUtils.subtract(bodyOffset, new PointF(body.getWidth() / 2f, body.getHeight() / 2f));
		bodyOffset = GraphicsUtils.scale(bodyOffset, getScale());
		//move it to distance from current position
		bodyOffset = GraphicsUtils.add(position, bodyOffset);
		//find distance between center of part and its attach point
		PointF partOffset = PositionedObject.coordinateToPoint(part.getAttachPoint());
		partOffset = GraphicsUtils.subtract(new PointF(part.getWidth()/2f, part.getHeight()/2f), partOffset);
		partOffset = GraphicsUtils.scale(partOffset, getScale());
		//adds two offsets together to get new
		partOffset = GraphicsUtils.add(partOffset, bodyOffset);
		part.setCenter(partOffset);
	}

	public boolean isComplete() {
		return body != null && cannon != null && leftWing != null && engine != null && core != null;
	}

	public void loadParts() {
		if (body != null) {
			body.setImageId();
			if (cannon != null) {
				cannon.setImageId();
			}
			if (leftWing != null) {
				leftWing.setImageId();
			}
			if (engine != null) {
				engine.setImageId();
			}
		}
	}

}
