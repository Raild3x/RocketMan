package org.input;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class Keyboard implements KeyListener {

    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {

    }

}