package org.world;

import org.graphics.Graphics;
import org.graphics.Vector2;
import org.input.Mouse;

public class Player extends GameObject{
	
	private int PlayerCount = 1;

	public Player() {
		name = "Player"+PlayerCount;
		PlayerCount++;
		position = new Vector2();
		size = new Vector2();
	}

	public Player(Vector2 size, Vector2 pos) {
		name = "Player"+PlayerCount;
		PlayerCount++;
		this.position = pos;
		this.size = size;
	}

	public void update() {
		position = Mouse.getPosition();
	}
	
	public void render() {
		Graphics.setColor(1,0.5f,0,1);
		Graphics.setRotation(rotation);
		Graphics.fillRect(position.x,position.y,size.x,size.y);
	}

}
