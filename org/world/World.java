package org.world;

import java.util.ArrayList;

import org.graphics.Graphics;
import org.input.Mouse;

public class World {
	
	private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	
	public static void update() {
		
		// Go through all objects and update them
		for (GameObject obj: gameObjects) {
			obj.update();
		}
	}

	public static void render() {

		// Go through all objects and render them
		for (GameObject obj: gameObjects) {
			obj.render();
		}
	}
	
	
}
