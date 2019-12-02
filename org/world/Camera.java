package org.world;

import org.util.Vector2;

public class Camera {
    private static Vector2 position = new Vector2();
    private static PhysicsObject focus;

    public static Vector2 getPosition() {
		return position;
	}

    public static void setPosition(Vector2 pos) {
		position = pos;
	}

    public static PhysicsObject getFocus() {
		return focus;
	}

    public static void setFocus(PhysicsObject po) {
		focus = po;
	}

    public static void update(){
        if (focus != null){
            position = focus.getPosition();
        }
    }

}