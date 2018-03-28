package game.block;

import base.GameObject;
import base.Vector2D;
import utils.Utils;

public class Block extends GameObject {
    public Vector2D velocity;


    public Block() {
        this.image = Utils.loadImage("resources/block/block.png");
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
}
