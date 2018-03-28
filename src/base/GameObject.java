package base;

import renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    public Renderer renderer;
    public Vector2D position;
    public boolean isAlive;

    public GameObject() {
        this.position = new Vector2D();
        this.isAlive = true;
    }


    public void run() {

    }

    public void render(Graphics graphics) {
        if (this.renderer != null) {
            this.renderer.render(graphics, this.position);
        }
    }


}
