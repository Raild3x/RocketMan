package org.world;

import java.util.ArrayList;

import org.engine.Signal;

public class World {
	
	private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	public static ArrayList<Planet> celestialBodies = new ArrayList<Planet>();
	
	public static void update(long lastUpdate) {
		
		// Go through all objects and update them
		for (GameObject obj: gameObjects) {
			obj.update();
		}
	}

	public static void render() {

		//Renderstep.Fire();

		// Go through all objects and render them
		for (GameObject obj: gameObjects) {
			obj.render();
		}
	}

	public static void addObject(GameObject obj){
		gameObjects.add(obj);
	}

	public static void addCelestialBody(Planet obj){
		celestialBodies.add(obj);
		addObject(obj);
	}
	
	
}
