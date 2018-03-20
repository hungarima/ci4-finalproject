package game.square;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import utils.Utils;

public class Square extends GameObject implements PhysicBody, HitObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public Square() {
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20, 20);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
