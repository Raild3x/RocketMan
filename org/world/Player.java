package org.world;

import com.jogamp.newt.event.KeyEvent;

import org.engine.GameLoop;
import org.graphics.Vector2;
import org.input.Keyboard;


public class Player extends PhysicsObject{
	
	private int PlayerCount = 1; // check to see if this is being overridden
	public float vel = 0;
	public final float maxVel = 15;

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
			Rot++;
		}
		if (Keyboard.keyDown(KeyEvent.VK_D)){
			Rot--;
		}
		if (Keyboard.keyDown(KeyEvent.VK_W)){
			Thrust++;
		}
		if (Keyboard.keyDown(KeyEvent.VK_S)){
			Thrust--;
		}

		//vel += Thrust == 0 ? (vel != 0 ? (vel > 0 ? -0.2f : 0.2f) : 0) : Thrust/4; // calculate decrease in velocity if not moving
		//vel += Thrust/4;
		//vel = Math.max(-maxVel, Math.min(maxVel, vel)); // clamp velocity
		rotation += Rot;
		velocity.add(this.getLookVector().mult(Thrust)); //Add thrust movement
		for (Planet obj: World.celestialBodies){
			velocity.add(obj.getGravity(this));
		}
		position.add(Vector2.mult(velocity, GameLoop.updateDelta()));

		//position.x += xInput; //;
		//position.y += yInput; //* GameLoop.updateDelta();
	}

}
