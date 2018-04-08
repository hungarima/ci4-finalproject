package input;

import base.Vector2D;
import utils.Utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput extends KeyAdapter {
    public static KeyboardInput instance = new KeyboardInput();

    public Vector2D position;
    public Vector2D velocity;
    private boolean leftKeyIsPressed = false;
    private boolean rightKeyIsPressed = false;
    private boolean upKeyIsPressed = false;
    private boolean downKeyIsPressed = false;

    public KeyboardInput () {
        this.velocity = new Vector2D();
        this.position = new Vector2D();
    }

//    @Override
//    public void keyTyped(KeyEvent e) {
//        char keyChar = e.getKeyChar();
//        System.out.println("keyTyped");
//        if (keyChar == 'd' || keyChar == 'D') {
//            this.velocity.set(10,0);
//        }
//        if (keyChar == 'a' || keyChar == 'A') {
//            this.velocity.set(-10,0);
//        }
//        if (keyChar == 'w' || keyChar == 'W') {
//            this.velocity.set(0,-10);
//        }
//        if (keyChar == 's' || keyChar == 'S') {
//            this.velocity.set(0,10);
//        }
//
//    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightKeyIsPressed = true;
            this.velocity.set((float)1,0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.velocity.set((float)-1,0);
            leftKeyIsPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
            this.velocity.set(0,(float)-0.7);
            upKeyIsPressed = true;
        }
        else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.velocity.set(0,(float)0.05);
            downKeyIsPressed = true;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            rightKeyIsPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
            leftKeyIsPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
            upKeyIsPressed = false;
        }
        else if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
            downKeyIsPressed = false;
        }
    }

    public void setStraight(){
        if(!rightKeyIsPressed && !leftKeyIsPressed && !upKeyIsPressed && !downKeyIsPressed){
            this.velocity.set(0,0);
        }
    }
}
