package game.background;

import base.GameObject;
import renderer.ImageRenderer;
import utils.Utils;

public class Background extends GameObject {

    public Background() {
            this.renderer = new ImageRenderer("resources/background/background2.png");
    }

    @Override
    public void run() {
        super.run();

    }
}
