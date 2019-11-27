package org.world;

import org.graphics.Graphics;
import org.graphics.Vector2;

public abstract class PhysicsObject extends GameObject {

    public Vector2 velocity = new Vector2();
    public Vector2 position;
    public Vector2 size;
    public boolean anchored = false;
    public boolean canCollide = true;

    // Gives the look vector of the PO
    public Vector2 getLookVector(){
        double rot = Math.toRadians(rotation);
        return new Vector2(Math.cos(rot), Math.sin(rot));
    }

    public Vector2 getVectorFromAngle(float rota){
        double rot = Math.toRadians(rota);
        return new Vector2(Math.cos(rot), Math.sin(rot));
    }

    // lets you pass a vector position and it will return the rotation needed to face that point
    public float getRotationFromVector(Vector2 other){
        return (float) Math.atan2(other.x-position.x,other.y-position.y);
    }

    public float getMass(){
        return 1000;
    }
    
    public void update() {
		// Implement in subclass?
	}
	
	public void render() {
		Graphics.setColor(1,0.5f,0,1);
		Graphics.setRotation(rotation);
		Graphics.fillRect(position.x,position.y,size.x,size.y);
	}
}