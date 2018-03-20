package game.enemyhard.bullet;

import base.GameObjectManager;
import base.Vector2D;
import game.player.Player;

public class BulletEnemyHardMove {

    private Vector2D velocity = new Vector2D();

    public void run(BulletEnemyHard bulletEnemyHard) {
        Player player = GameObjectManager.instance.getPlayer();
        if (player != null) {
            Vector2D positionPlayer = player.position;
            Vector2D velocity = positionPlayer.subtract(bulletEnemyHard.position).normalize().multiply(2);
            this.velocity.set(velocity);
        } else {
            this.velocity.set(0, 0);
        }

        bulletEnemyHard.position.addUp(this.velocity);
    }
}
