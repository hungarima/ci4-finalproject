package game.background;

import base.GameObject;
import renderer.ImageRenderer;
import renderer.Renderer;

public class SoundButton extends GameObject {
    private Renderer imageRenderer;

    public SoundButton() {
        this.imageRenderer = new ImageRenderer("resources/sound.png");
        this.renderer = imageRenderer;
    }

    @Override
    public void run() {

    }
}