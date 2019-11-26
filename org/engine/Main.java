package org.engine;

import org.graphics.*;
import org.world.*;

public class Main {

	public static void main(String[] args) {
		Renderer.init();
		GameLoop.start();

		World.addObject(new Planet(new Vector2(10,5), 5, 1, 0));
		World.addObject(new Planet(new Vector2(-15,11), 7, 1, 0));

		//TESTCODE
		Player p1 = new Player();
		p1.size = new Vector2(3,2);
		Camera.focus = p1;
		//p1.position = new Vector2(100,100);
		World.addObject(p1);
	}

}
