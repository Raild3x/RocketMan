package org.input;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

import org.graphics.Vector2;

public class Mouse implements MouseListener{

	private static int mouseX = 0;
	private static int mouseY = 0;

	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX()+" / "+e.getY());
	}

	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		//System.out.println("Dragged");
	}

	public void mouseEntered(MouseEvent e) {
		System.out.println("Entered");
	}

	public void mouseExited(MouseEvent e) {
		System.out.println("Exited");
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		//System.out.println("Moved");
	}

	public void mousePressed(MouseEvent e) {
		System.out.println("Pressed");
	}

	public void mouseReleased(MouseEvent e) {
		System.out.println("Released");
	}

	public void mouseWheelMoved(MouseEvent e) {
		System.out.println("Scrolled");
	}
	
	public static int getX() {
		return mouseX;
	}
	
	public static int getY() {
		return mouseY;
	}

	public static Vector2 getPosition(){
		return new Vector2(mouseX,mouseY);
	}
	
}