package org.engine;

import org.graphics.Renderer;
import org.world.World;

public class GameLoop {
	
	private static boolean running = false;
	private static Thread thread;
	
	private static int updates = 0;
	private static final int MAX_UPDATES = 5;
	
	private static long lastUpdateTime = 0;
	
	private static int targetFPS = 144;
	private static int targetTime = 1000000000/targetFPS;
	
	
	public static void start() {
		thread = new Thread() {
			public void run() {
				System.out.println("StartThread");
				boolean render = false;
				int fps = 0;
				long lastFPSCheck = System.nanoTime();
				
				running = true;
				lastUpdateTime = System.nanoTime();
				
				while(running) {
					render = false;
					
					long currentTime = System.nanoTime();
					
					// UPDATE INTERNALS
					while(currentTime - lastUpdateTime > targetTime) {
						World.update();
						lastUpdateTime += targetTime;
						updates++;
						render = true;
						if (updates > MAX_UPDATES)
							break;
					}
					
					// RENDER GAME
					if (render) {
						Renderer.render();
						fps++;
						/*
						// FPS COUNTER
						if (System.nanoTime()>=lastFPSCheck + 1000000000) {
							System.out.println("FPS: "+fps);
							fps = 0;
							lastFPSCheck = System.nanoTime();
						}*/
					}
					
					// SLEEP UNTIL NEEDED FOR NEXT FRAME
					long timeTaken = System.nanoTime() - currentTime;
					if(timeTaken < targetTime) {
						try {
							Thread.sleep((targetTime-timeTaken)/1000000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		thread.setName("GameLoop");
		thread.start();
	}
	
	
	//Called on window dispose
	public static void stop() {
		try {
			running = false;
			//thread.join();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static float updateDelta(){
		System.out.println(1.0f / 1000000000 * targetTime);
		return 1.0f / 1000000000 * targetTime;
	}
}
