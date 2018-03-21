package game.background;

import base.GameObject;
import utils.Utils;

public class Background extends GameObject {

    public Background() {
        this.image = Utils.loadImage("resources/background/background2.png");
    }

    @Override
    public void run() {
        super.run();
        this.position.y += 1;
        if (this.position.y >=  683) this.position.y = this.position.y - 683 * 2;
        System.out.println("x: " + this.position.x + " " + "y: " + this.position.y);
    }
}
