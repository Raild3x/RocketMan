package org.world;

import org.graphics.Graphics;
import org.graphics.Vector2;

public abstract class PhysicsObject extends GameObject {
    public Vector2 position;
    public Vector2 size;
    public boolean anchored = false;
    public boolean canCollide = true;

    public Vector2 getLookVector(){
        double rot = Math.toRadians(rotation);
        return new Vector2(Math.cos(rot), Math.sin(rot));
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