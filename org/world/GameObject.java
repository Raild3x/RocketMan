package org.world;

import java.util.LinkedList;

import org.graphics.Vector2;

public class GameObject {
	
	public String name = "";
	public GameObject parent;
	private LinkedList<GameObject> children = new LinkedList<GameObject>();
	
	public Vector2 position;
	public Vector2 size;
	
	public float rotation = 0;
	
	public GameObject() {
		
	}
	
	public void update() {
		// Implement in subclass?
	}
	
	public void render() {
		// Implement in subclass?
	}

}
