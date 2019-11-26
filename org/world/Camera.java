package org.world;

import org.graphics.Vector2;

public class Camera {
    public static Vector2 position = new Vector2();
    public static PhysicsObject focus;

    public static void update(){
        if (focus != null){
            position = focus.position;
        }
    }
}