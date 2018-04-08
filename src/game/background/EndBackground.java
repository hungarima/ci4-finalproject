package game.background;

import base.GameObject;
import renderer.ImageRenderer;


public class EndBackground extends GameObject {
    public EndBackground() {
        this.renderer = new ImageRenderer("resources/END.png");
    }
}
