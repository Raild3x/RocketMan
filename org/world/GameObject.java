package org.world;

//import java.util.LinkedList;


public abstract class GameObject {
	
	private String name = "";
	private GameObject parent;
	private int zIndex = 0; // order of rendering, lower zIndex's are rendered first
	private boolean render = true;

	//private LinkedList<GameObject> children = new LinkedList<GameObject>();
	
	public void update() {
		// Implement in subclass?
	}
	
	public void render() {
		// Implement in subclass?
	}

	// linear interpolation of single numbers
	private static float lerp(float x, float y, float alpha) {
		return x*(1-alpha) + y*alpha;
	}

	//---------------GETTERS AND SETTERS--------------------//

	public String getName(){
		return this.name;
	}

	public void setName(String s){
		this.name = s;
	}

	public GameObject getParent(){
		return this.parent;
	}

	public void setParent(GameObject p){
		this.parent = p;
	}

	public int getZIndex(){
		return this.zIndex;
	}

	public void setZIndex(int z){
		this.zIndex = z;
	}

	public boolean getRender(){
		return this.render;
	}

	public void setRender(boolean r){
		this.render = r;
	}

	//public GameObject[] getChildren(){}
}
