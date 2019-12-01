package org.world;

import org.graphics.Graphics;
import org.graphics.Vector2;

public abstract class PhysicsObject extends GameObject {

    private Vector2 velocity = new Vector2();
    private Vector2 position;
    private Vector2 size;

    private float rotation;
    private float mass = 1;

    private boolean anchored = false;
    private boolean canCollide = true;

    //-------------------------------------CORE METHODS-------------------------------//

    public void update() {
		// Implement in subclass?
	}
	
	public void render() {
		Graphics.setColor(1,0.5f,0,1);
		Graphics.setRotation(this.rotation);
		Graphics.fillRect(position.x,position.y,size.x,size.y);
    }

    public String toString(){
        return "PhysicsObject: "+position.toString();
    }

    //-------------------------------------UTILITY METHODS-------------------------------//

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
    
    
    
    //------------------------------------GETTERS AND SETTERS-----------------------------//
    public Vector2 getVelocity() {
        return this.velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getSize() {
        return this.size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }

    public float getRotation() {
        return this.rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getMass() {
        return this.mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public boolean getAnchored() {
        return this.anchored;
    }

    public void setAnchored(boolean anchored) {
        this.anchored = anchored;
    }

    public boolean getCanCollide() {
        return this.canCollide;
    }

    public void setCanCollide(boolean canCollide) {
        this.canCollide = canCollide;
    }
}