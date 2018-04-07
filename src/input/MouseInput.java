package input;

import base.Vector2D;
import game.background.StartButton;
import game.player.Player;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
    public static MouseInput instance = new MouseInput();

    public Vector2D velocity;
    public boolean state;

    StartButton startButton = new StartButton();

    private MouseInput() {
        this.velocity = new Vector2D();
    }

    @Override
    public void mouseClicked (MouseEvent e) {
        Point point = e.getPoint();

        Rectangle imageBounds = new Rectangle(100,400,200,106);
        if (imageBounds.contains(point)) {


        }
    }

    @Override
    public void mouseReleased (MouseEvent e) {
    }


}

