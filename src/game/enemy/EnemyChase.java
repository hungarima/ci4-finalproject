package game.enemy;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;

import java.util.Random;

public class EnemyChase extends GameObject implements PhysicBody, HitObject{
    private RunHitObject runHitObject;
    private BoxCollider boxCollider;
    private Vector2D velocity = new Vector2D();
//    public Vector2D position = new Vector2D();

    public EnemyChase(){
//        this.position.set((float)(Math.random()*400),0);
        this.boxCollider = new BoxCollider(45, 60);
        this.runHitObject = new RunHitObject(Player.class);
    }

    public void run() {
        this.boxCollider.position.set(this.position);
//        this.runHitObject.run(this);
        Player player = GameObjectManager.instance.getPlayer();
        if (player != null) {
            Vector2D positionPlayer = player.position;
            Vector2D velocity = positionPlayer.subtract(this.position).normalize().multiply((float)0.5);
            this.velocity.set(velocity);
        } else {
            this.velocity.set(0, 0);
        }
        this.position.addUp(this.velocity);
    }

    @Override
    public void getHit(GameObject gameObject) {

    }

    @Override
    public BoxCollider getBoxCollider() {
        return null;
    }
}


