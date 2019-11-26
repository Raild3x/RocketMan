package org.world;

import com.jogamp.newt.event.KeyEvent;

import org.engine.GameLoop;
import org.graphics.Graphics;
import org.graphics.Vector2;
import org.input.Keyboard;
import org.input.Mouse;

public class Player extends PhysicsObject{
	
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
		float Thrust = 0;
		float Rot = 0;

		if (Keyboard.keyDown(KeyEvent.VK_A)){
			Rot--;
		}
		if (Keyboard.keyDown(KeyEvent.VK_D)){
			Rot++;
		}
		if (Keyboard.keyDown(KeyEvent.VK_W)){
			Thrust++;
		}
		if (Keyboard.keyDown(KeyEvent.VK_S)){
			Thrust--;
		}

		rotation += Rot;
		position.add(this.getLookVector().mult(Thrust));

		//position.x += xInput; //* GameLoop.updateDelta();
		//position.y += yInput; //* GameLoop.updateDelta();
	}

}
