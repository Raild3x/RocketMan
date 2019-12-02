package org.engine;

import java.util.ArrayList;

import org.graphics.*;
import org.input.*;
import org.util.*;
import org.world.*;
import org.util.*; 

public class Main {

	public static void main(String[] args) {
		Renderer.init();
		GameLoop.start();

		//QUAD TREE TEST
		float width = Renderer.unitsWide;
        float height = Renderer.unitsTall;

        
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

      
		Frame obj = new Frame(new UDim2(0, 0, 0, 0), new UDim2(.5f, 1, .5f, 1));
		World.addObject(obj);

		GameLoop.Heartbeat.Connect(timePassed -> {
			obj.setPosition(UDim2.add(obj.getPosition(), new UDim2(.01f,0,0,0)));
		});

        for (int i = 0; i < 300; i++){
            //Point p = qt.new Point((float) Math.random()*width-width/2, (float) Math.random()*height-height/2);
			//qt.insert(p);
			try{
				Thread.sleep(20);
				//System.out.println("NEWPOINT");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}

		
		
		
		/*

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
		*/
	}

}
