package game.player.bullet;

import base.GameObject;
import base.Vector2D;
import game.enemy.Enemy;
import game.enemy.bullet.BulletEnemy;
import game.square.Square;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import utils.Utils;

public class Bullet extends GameObject implements PhysicBody, HitObject {

    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public Bullet() {
        this.image = Utils.loadImage("resources/player/player_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10, 10);
        this.runHitObject = new RunHitObject(
                Square.class
        );
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position); //cho box di chuyen theo
        this.runHitObject.run(this);
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof Square) {
            System.out.println("Square");
        }
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
