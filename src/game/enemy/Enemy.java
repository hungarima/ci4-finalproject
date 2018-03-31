package game.enemy;

import base.GameObject;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

public class Enemy extends GameObject implements PhysicBody, HitObject{
    public Vector2D velocity;
    private BoxCollider boxCollider;
    private RunHitObject runHitObject;

    public Enemy() {
        this.renderer = new ImageRenderer("resources/enemyBike/square_deadly_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(40, 40);
        this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.runHitObject.run(this);
    }

    @Override
    public void getHit(GameObject gameObject) {
        System.out.println("Aw!");
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
