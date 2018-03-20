package input;

import base.Vector2D;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput extends KeyAdapter {
    public static KeyboardInput instance = new KeyboardInput();

    public Vector2D position;
    public Vector2D velocity;

    private  KeyboardInput () {
        this.position = new Vector2D();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        if (keyChar == 'd') {
            System.out.println("right");
        }
        if (keyChar == 'a') {
            System.out.println("left");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
