package org.input;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

import org.engine.Signal;
import org.graphics.Renderer;
import org.util.Vector2;
import org.world.Camera;

public class Mouse implements MouseListener{

	private static int mouseX = 0;
	private static int mouseY = 0;

	public static final Signal<MouseEvent> Moved = new Signal<>();

	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX()+" / "+e.getY());
	}

	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		//System.out.println("Dragged");
	}

	public void mouseEntered(MouseEvent e) {
		//System.out.println("Entered");
	}

	public void mouseExited(MouseEvent e) {
		//System.out.println("Exited");
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		Moved.Fire(e);
		//System.out.println("Moved");
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("X: "+e.getX()+"\tY: "+e.getY());
		//System.out.println("Pressed");
	}

	public void mouseReleased(MouseEvent e) {
		//System.out.println("Released");
	}

	public void mouseWheelMoved(MouseEvent e) {
		//System.out.println("Scrolled");
	}


	// MOUSE POSITION METHODS
	public static int getX() {
		return mouseX;
	}
	
	public static int getY() {
		return mouseY;
	}

	public static Vector2 getPosition(){
		return new Vector2(mouseX,mouseY);
	}

	public static float getWorldX(){
		return (Renderer.unitsWide / Renderer.getWindowWidth() * mouseX - Renderer.unitsWide / 2) + Camera.getPosition().getX();
	}

	public static float getWorldY(){
		return (Renderer.unitsTall / Renderer.getWindowHeight() * mouseY - Renderer.unitsTall / 2) + Camera.getPosition().getY();
	}

	public static Vector2 getWorldPosition(){
		return new Vector2(getWorldX(), getWorldY());
	}
	
}
