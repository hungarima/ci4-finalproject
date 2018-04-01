package game.enemy;

import base.GameObject;
import base.Vector2D;
import game.player.Player;
import physic.*;
import renderer.ImageRenderer;

import java.util.Random;

public class Enemy extends GameObject implements PhysicBody, HitObject {
    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject;
    private Random random;

    public Enemy() {
        this.random = new Random();
//        if (random.nextInt(2) == 1) {
//            this.renderer = new ImageRenderer("resources/enemyBike/car.png");
//        } else {
//            this.renderer = new ImageRenderer("resources/enemyBike/lninjja.png");
//        }

        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(45, 60);
        this.runHitObject = new RunHitObject(Player.class);

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.runHitObject.run(this);
        if (this.position.y < 0) {
            this.isAlive = false;
        }
    }

    @Override
    public void getHit(GameObject gameObject) {
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
