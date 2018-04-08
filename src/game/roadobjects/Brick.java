package game.roadobjects;

import base.GameObject;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

import java.util.Random;

public class Brick extends GameObject implements PhysicBody,HitObject{
    private RunHitObject runHitObject;
    private BoxCollider boxCollider;

    public Brick() {
        this.renderer = new ImageRenderer("resources/roadObjects/brick.png");
        this.boxCollider = new BoxCollider(40,40);
        this.runHitObject = new RunHitObject(Player.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.set(this.position);
        this.boxCollider.position.set(this.position);
        this.runHitObject.run(this);
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

