package game.enemy;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;
import utils.Utils;

public class Enemy extends GameObject {
    public Vector2D velocity;


    public Enemy() {
        this.renderer = new ImageRenderer("resources/enemyBike/square_deadly_bullet.png");
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
}
