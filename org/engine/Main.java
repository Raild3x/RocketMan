package org.engine;

import org.graphics.*;
import org.world.*;

public class Main {

	public static void main(String[] args) {
		Renderer.init();
		GameLoop.start();

		//TESTCODE
		Player p1 = new Player();
		p1.size = new Vector2(15,30);
		World.addObject(p1);
	}

}
