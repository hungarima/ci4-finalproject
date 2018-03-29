package game.background;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;
import utils.Utils;

public class Background1 extends GameObject {

    Vector2D velocity;

    public Background1() {
        this.renderer = new ImageRenderer("resources/background/background1.png");
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.y += 1;
        if (this.position.y >= 720) {
            this.position.y = -720;
        }
        System.out.println(this.position.y);
    }
}
