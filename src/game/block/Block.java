package game.block;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;
import utils.Utils;

public class Block extends GameObject {
    public Vector2D velocity;


    public Block() {
        this.renderer = new ImageRenderer("resources/block/block.png");
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
    }
}
