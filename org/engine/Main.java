package org.engine;

import java.util.ArrayList;

import org.graphics.*;
import org.input.*;
import org.util.*;
import org.world.*;
import org.util.*;
import org.custom.*; 

public class Main {

	public static long wait(float t){
		long startTime = System.nanoTime();
		try {
			Thread.sleep((long) (t * 1000));
		} catch (Exception e){
			e.printStackTrace();
		}
		return System.nanoTime() - startTime;
	}

	public static void main(String[] args) {
		Renderer.init();
		GameLoop.start();

		//QUAD TREE TEST
		float width = Renderer.unitsWide;
		float height = Renderer.unitsTall;
		 

        /*
		//QuadTree qt = new QuadTree(0,0,width/2,height/2 , 4);
		Rectangle boundary = new Rectangle(0,0, width/2,height/2);
		QuadTree qt = new QuadTree(boundary, 16);
			
		for (int i = 0; i < 10000; i++){
			Vector2 p = new Vector2((float) Math.random()*width-width/2, (float) Math.random()*height-height/2);
			qt.insert(p);
		}

		GameLoop.PostRenderstep.Connect(nil -> {
			long st = System.nanoTime();
			
			//qt.render();

			Rectangle search = new Rectangle(Mouse.getWorldX(),-Mouse.getWorldY(), 12,6);
			Graphics.setColor(0,0,0,0);
			Graphics.setBorderColor(0,1,0,1);
			search.draw();
			
			ArrayList<Vector2> points = qt.queryBox(search);
			System.out.println((System.nanoTime()-st));
			for (int i = 0; i < points.size(); i++){
				Vector2 p = points.get(i);
				Graphics.setColor(0,1,0,1);
				Graphics.setPointSize(2);
				Graphics.drawPoint(p.getX(), p.getY());
			}
		});
		*/
      
		/*Frame obj1 = new Frame(new UDim2(0.25f, 0, 0.5f, 0), new UDim2(0, 10, 0 , 10));
		World.addObject(obj1);
		wait(1f);
		Frame obj2 = new Frame(new UDim2(0.75f, 0, 0.5f, 0), new UDim2(0, 10, 0, 10));
		World.addObject(obj2);
		GameLoop.Heartbeat.Connect(timePassed -> {
			obj1.setSize(obj1.getSize().add(new UDim2(0,1,0,1)));
			obj2.setSize(obj2.getSize().add(new UDim2(.001f,0,0.001f,0)));
			//obj.setPosition(UDim2.add(obj.getPosition(), new UDim2(.001f,0,0.001f,0)));
			//System.out.println(obj.getPosition());
		});
		*/
		
		//World.addObject(new Planet(new Vector2(10,8), 5.5f, 1, 0));
		World.addCelestialBody(new Planet(new Vector2(-25,24), 12, 2.5f, 0));
		World.addCelestialBody(new Planet(new Vector2(15,-45), 25, 2, 0));

		//TESTCODE
		Player p1 = new Player();
		p1.setSize(new Vector2(3,2));
		Camera.setFocus(p1);

		World.addObject(p1);
		
	}

}
