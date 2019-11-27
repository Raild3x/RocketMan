package org.graphics;

import org.input.Keyboard;
import org.input.Mouse;

import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;

public class Renderer {
	private static GLWindow window = null;
	
	public static int WIDTH = 800;
	public static int HEIGHT = 550;
	public static float unitsWide = 100;
	public static float unitsTall = 10;
	
	public static void init() {
		GLProfile.initSingleton();
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);
		
		window = GLWindow.create(caps);
		window.setSize(WIDTH,  HEIGHT);
		window.setResizable(true);
		window.requestFocus();
		window.addGLEventListener(new EventListener());
		window.addMouseListener(new Mouse());
		window.addKeyListener(new Keyboard());
		//window. //uncap fps?
		
		//FPSAnimator animator = new FPSAnimator(window, 60); // takes window and target fps
		//animator.start(); // runs in new thread
		
		//window.setFullscreen(true);
		window.setVisible(true);	
	}
	
	public static int getWindowWidth() {
		return window.getWidth();
	}
	public static int getWindowHeight() {
		return window.getHeight();
	}
	
	public static void render() {
		if(window==null)
			return;
		window.display();
	}
}
