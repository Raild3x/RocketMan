package org.input;

import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class Keyboard implements KeyListener {

    public static boolean[] keys = new boolean[256];

    public void keyPressed(KeyEvent e) {
        //System.out.println("Pressed: "+e.getKeyChar());
        if( 0 == ( InputEvent.AUTOREPEAT_MASK & e.getModifiers() ) )  { keys[e.getKeyCode()] = true;}
    }

    public void keyReleased(KeyEvent e) {
        //System.out.println("Released: "+e.getKeyChar());
        if( 0 == ( InputEvent.AUTOREPEAT_MASK & e.getModifiers() ) )  { keys[e.getKeyCode()] = false;}
    }

    public static boolean keyDown(int keyCode){
        return keys[keyCode];
    }

}