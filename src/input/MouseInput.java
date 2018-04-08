package input;

import base.Vector2D;
import game.background.StartButton;
import game.player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
    public static MouseInput instance = new MouseInput();

    public Vector2D velocity;
    public boolean state = false;
    public boolean mouseReleased = false;


    private MouseInput() {
        this.velocity = new Vector2D();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point point = e.getPoint();

        Rectangle imageBounds = new Rectangle(100,350,200,120);
        if (imageBounds.contains(point)) {
            this.state = true;
        }
    }

    @Override
    public void mouseReleased (MouseEvent e) {
        this.mouseReleased = true;
//        System.out.println("released");
    }
}

