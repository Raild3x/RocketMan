package org.engine;

import org.graphics.*;
import org.world.*;

public class Main {

	public static void main(String[] args) {
		Renderer.init();
		GameLoop.start();

		//World.addObject(new Planet(new Vector2(10,8), 5.5f, 1, 0));
		World.addCelestialBody(new Planet(new Vector2(-25,24), 12, 2.5f, 0));
		World.addCelestialBody(new Planet(new Vector2(15,-45), 25, 2, 0));

		//TESTCODE
		Player p1 = new Player();
		p1.setSize(new Vector2(3,2));
		Camera.setFocus(p1);

		// TEST UDIM2
		UDim2 t1 = new UDim2(5.f, 1, 0.5f, 0);
		UDim2 t2 = new UDim2(6.f, 0, 0.7F, 1);
		UDim2 t3 = UDim2.add(t1, t2); 
		System.out.println(t3);

		World.addObject(p1);
	}

}
