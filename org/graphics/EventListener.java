package org.graphics;

import org.engine.GameLoop;
import org.world.Camera;
import org.world.World;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener{
	
	public static GL2 gl = null;

	public void display(GLAutoDrawable drawable) {
		//System.out.println("Rendering");
		gl = drawable.getGL().getGL2();
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		Camera.update();
		gl.glTranslatef(-Camera.getPosition().getX(), -Camera.getPosition().getY(),0);
		World.render();
		gl.glTranslatef(Camera.getPosition().getX(), Camera.getPosition().getY(),0);
	}


	public void dispose(GLAutoDrawable drawable) {
		System.out.println("Disposing");
		GameLoop.stop();
	}


	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(0,0,0,1);
		
		gl.glEnable(GL2.GL_TEXTURE_2D);
	}

	//called when you resize the window
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();
		System.out.println(x+" / "+y+" / "+width+" / "+height);
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity(); // sets everything to zero
		
		Renderer.unitsTall = Renderer.getWindowHeight() / (Renderer.getWindowWidth() / Renderer.unitsWide);
		// Define the coordinate system
		gl.glOrtho(-Renderer.unitsWide/2, Renderer.unitsWide/2, -Renderer.unitsTall/2, Renderer.unitsTall/2, -1, 1);
		//gl.glOrtho(0, width, height, 0, -1, 1);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}

}
