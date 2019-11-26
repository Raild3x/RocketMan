package org.graphics;

import com.jogamp.opengl.GL2;

public class Graphics {
	
	private static float red = 1;
	private static float blue = 1;
	private static float green = 1;
	private static float alpha = 1;
	
	private static float rotation = 45;
	
	public static void fillRect(float x, float y, float width, float height) {
		GL2 gl = EventListener.gl;
		float w = width/2, h = height/2;
		
		gl.glTranslatef(x, y, 0); //set rotation data
		gl.glRotatef(-rotation, 0, 0, 1);
		
		gl.glColor4f(red, green, blue, alpha); //drawRect
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex2f(-w, -h);
			gl.glVertex2f(w, -h);
			gl.glVertex2f(w, h);
			gl.glVertex2f(-w, h);
		gl.glEnd();
		
		gl.glRotatef(rotation, 0, 0, 1); //reset
		gl.glTranslatef(-x, -y, 0);
	}
	
	public static void setColor(float r, float g, float b, float a) {
		red = Math.max(0, Math.min(1, r));
		green = Math.max(0, Math.min(1, g));
		blue = Math.max(0, Math.min(1, b));
		alpha = Math.max(0, Math.min(1, a));
	}
	
	public static void setRotation(float rot) {
		rotation = rot;
	}

}
