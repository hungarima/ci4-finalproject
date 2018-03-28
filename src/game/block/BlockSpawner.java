package game.block;

import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class BlockSpawner extends GameObject {
    private int count = 0;
    private Random random;

    public BlockSpawner() {
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();
        if (this.count >= 160) {
            Block block = new Block();
            block.position.set(random.nextInt(400), 0);
            block.velocity.set(0, (float) 0.5);
            GameObjectManager.instance.add(block);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}
