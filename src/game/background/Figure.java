package game.background;

import base.GameObject;
import renderer.ImageRenderer;
import renderer.Renderer;

public class Figure extends GameObject {
    private Renderer imageRenderer;

    public Figure() {
        this.imageRenderer = new ImageRenderer("resources/nền.png");
        this.renderer = imageRenderer;
    }

    @Override
    public void run() {

    }
}