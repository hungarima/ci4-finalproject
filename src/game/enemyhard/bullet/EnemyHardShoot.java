package game.enemyhard.bullet;

import base.FrameCounter;
import base.GameObjectManager;
import game.enemyhard.EnemyHard;

public class EnemyHardShoot {

    private FrameCounter frameCounter = new FrameCounter(10);

    public void run(EnemyHard enemy) {
        if (this.frameCounter.run()) {
            BulletEnemyHard bulletEnemy = new BulletEnemyHard();
            bulletEnemy.position.set(enemy.position);
            GameObjectManager.instance.add(bulletEnemy);
        }
    }
}
