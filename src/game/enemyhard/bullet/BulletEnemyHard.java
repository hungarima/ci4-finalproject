package game.enemyhard.bullet;

import base.GameObject;
import utils.Utils;

public class BulletEnemyHard extends GameObject {

    private BulletEnemyHardMove bulletEnemyHardMove;

    public BulletEnemyHard() {
        this.image = Utils.loadImage("resources/square/square_deadly_bullet.png");
        this.bulletEnemyHardMove = new BulletEnemyHardMove();
    }

    @Override
    public void run() {
        super.run();
        this.bulletEnemyHardMove.run(this);
    }
}
