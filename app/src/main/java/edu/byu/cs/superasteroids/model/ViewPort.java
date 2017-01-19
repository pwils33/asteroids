package edu.byu.cs.superasteroids.model;

import android.graphics.PointF;

/**
 * Created by pwils33 on 10/20/16.
 */
public class ViewPort {

    private static PointF topLeft = new PointF();
    private static int width = 0;
    private static int height = 0;

    public static PointF getTopLeft() {
        return topLeft;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        ViewPort.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        ViewPort.height = height;
    }

    public static boolean inView(PointF point) {
        return false;
    }
}
