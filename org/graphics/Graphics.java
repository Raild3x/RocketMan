package org.graphics;

import com.jogamp.opengl.GL2;

import  org.util.Vector2;

public class Graphics {
	
	private static float red = 1;
	private static float blue = 1;
	private static float green = 1;
	private static float alpha = 1;

	private static float borderRed = 1;
	private static float borderGreen = 1;
	private static float borderBlue = 1;
	private static float borderAlpha = 1;

	private static float pointSize = 1;
	
	private static float rotation = 0;
	
	public static void fillRect(float x, float y, float width, float height) {
		GL2 gl = EventListener.gl;
		float w = width/2, h = height/2;
		gl.glTranslatef(x, y, 0); //set rotation data
		gl.glRotatef(rotation, 0, 0, 1);
		
		gl.glColor4f(red, green, blue, alpha); //drawRect
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex2f(-w, -h);
			gl.glVertex2f(w, -h);
			gl.glVertex2f(w, h);
			gl.glVertex2f(-w, h);
		gl.glEnd();
		
		gl.glRotatef(-rotation, 0, 0, 1); //reset
		gl.glTranslatef(-x, -y, 0);
	}

	public static void fillRectWithBorders(float x, float y, float width, float height) {
		GL2 gl = EventListener.gl;
		float w = width/2, h = height/2;
		gl.glTranslatef(x, y, 0); //set rotation data
		gl.glRotatef(rotation, 0, 0, 1);
		
		gl.glColor4f(red, green, blue, alpha); //drawRect
		gl.glBegin(GL2.GL_QUADS);
			gl.glVertex2f(-w, -h);
			gl.glVertex2f(w, -h);
			gl.glVertex2f(w, h);
			gl.glVertex2f(-w, h);
		gl.glEnd();

		gl.glColor4f(borderRed, borderGreen, borderBlue, borderAlpha); //drawRect
		//Draw Border
		gl.glBegin(GL2.GL_LINE_LOOP);
			gl.glVertex2f(-w, -h);
			gl.glVertex2f(-w, h);
			gl.glVertex2f(w, h);
			gl.glVertex2f(w, -h);
		gl.glEnd();
		
		gl.glRotatef(-rotation, 0, 0, 1); //reset
		gl.glTranslatef(-x, -y, 0);
	}

	public static void drawPoint(float x, float y){
		GL2 gl = EventListener.gl;
		gl.glColor4f(red, green, blue, alpha);
		gl.glPointSize(pointSize);
		gl.glBegin(GL2.GL_POINTS);
			gl.glVertex2f(x, y);  
		gl.glEnd();
	}

	public static void drawPolygon(Vector2 center, Vector2[] points){
		GL2 gl = EventListener.gl;
		gl.glTranslatef(center.getX(), center.getY(), 0); //set rotation data
		gl.glRotatef(rotation, 0, 0, 1);
		gl.glColor4f(red, green, blue, alpha);

		gl.glBegin(GL2.GL_TRIANGLE_STRIP);
		for (int i = 0; i < points.length; i++){
			Vector2 p = points[i];
			gl.glVertex2f(p.getX(), p.getY());
			gl.glVertex2f(0,0);
		}
		gl.glVertex2f(points[0].getX(), points[0].getY());
		gl.glEnd();

		gl.glRotatef(-rotation, 0, 0, 1); //reset
		gl.glTranslatef(-center.getX(), -center.getY(), 0);
	}

	public static void drawCircle(float x, float y, float r, int num_segments){
	/*	GL2 gl = EventListener.gl;
		gl.glBegin(GL2.GL_LINE_LOOP);
		for(int ii = 0; ii < num_segments; ii++)
		{
			float theta = 2.0f * 3.1415926f * float(ii) / float(num_segments);//get the current angle
	
			float x = r * cosf(theta);//calculate the x component
			float y = r * sinf(theta);//calculate the y component
	
			glVertex2f(x + cx, y + cy);//output vertex
	
		}
		gl.glEnd();*/
	}
	
	public static void setColor(float r, float g, float b, float a) {
		red = Math.max(0, Math.min(1, r));
		green = Math.max(0, Math.min(1, g));
		blue = Math.max(0, Math.min(1, b));
		alpha = Math.max(0, Math.min(1, a));
	}

	public static void setBorderColor(float r, float g, float b, float a) {
		borderRed = Math.max(0, Math.min(1, r));
		borderGreen = Math.max(0, Math.min(1, g));
		borderBlue = Math.max(0, Math.min(1, b));
		borderAlpha = Math.max(0, Math.min(1, a));
	}
	
	public static void setRotation(float rot) {
		rotation = rot;
	}

	public static void setPointSize(float s){
		pointSize = s;
	}

}
