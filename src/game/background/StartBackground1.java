package game.background;

import base.GameObject;

import base.Vector2D;
import renderer.BlurRenderer;


public class StartBackground1 extends GameObject {
    Vector2D velocity;

    public StartBackground1() {
        this.renderer = new BlurRenderer("resources/background/background1.png");
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.y += 1;
        if (this.position.y >= 1000) {
            this.position.y = 300 -720;
        }
        System.out.println(this.position.y);
    }
}
