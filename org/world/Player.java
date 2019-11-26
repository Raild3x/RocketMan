package org.world;

import org.graphics.Graphics;
import org.input.Mouse;

public class Player extends GameObject{
	
	public Player() {
		
	}
	
	public void update() {
		position.x += 0.1f;
	}
	
	public void render() {
		Graphics.setColor(1,0.5f,0,1);
		Graphics.setRotation(rotation);
		Graphics.fillRect(position.x,position.y,size.x,size.y);
	}

}
