package org.world;

import com.jogamp.newt.event.KeyEvent;

import org.engine.GameLoop;
import org.util.Vector2;
import org.input.Keyboard;


public class Player extends PhysicsObject{
	
	private int PlayerCount = 1; // check to see if this is being overridden
	public float vel = 0;
	public final float maxVel = 15;

	public Player() {
		super();
		this.setName("Player"+PlayerCount);
		PlayerCount++;
	}

	public Player(Vector2 size, Vector2 pos) {
		super(pos,size);
		this.setName("Player"+PlayerCount);
		PlayerCount++;
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
		this.setRotation(this.getRotation() + Rot);
		this.setVelocity(this.getVelocity().add(this.getLookVector().mult(Thrust))); //Add thrust movement
		for (Planet obj: World.celestialBodies){
			this.setVelocity(this.getVelocity().add(obj.getGravity(this)));
		}
		this.setPosition(this.getPosition().add(Vector2.mult(this.getVelocity(), GameLoop.updateDelta())));

		//position.x += xInput; //;
		//position.y += yInput; //* GameLoop.updateDelta();
	}

}
