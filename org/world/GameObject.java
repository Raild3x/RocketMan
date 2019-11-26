package org.world;

//import java.util.LinkedList;


public abstract class GameObject {
	
	public String name = "";
	public GameObject parent;
	public int zIndex = 0; // order of rendering, lower zIndex's are rendered first
	public boolean render = true;

	//private LinkedList<GameObject> children = new LinkedList<GameObject>();
	
	public float rotation = 0;
	
	public void update() {
		// Implement in subclass?
	}
	
	public void render() {
		// Implement in subclass?
	}

}
