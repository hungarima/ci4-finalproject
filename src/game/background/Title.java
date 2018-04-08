package game.background;

import base.GameObject;
import renderer.ImageRenderer;
import renderer.Renderer;

public class Title extends GameObject {
    private Renderer imageRenderer;

    public Title() {
        this.imageRenderer = new ImageRenderer("resources/title.png");
        this.renderer = imageRenderer;
    }

    @Override
    public void run() {

    }
}