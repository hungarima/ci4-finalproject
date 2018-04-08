package game.background;

import base.FrameCounter;
import base.GameObject;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import renderer.Renderer;

public class StartButton extends GameObject {
    private Renderer imageRenderer;
    public Renderer animationRenderer;
    private FrameCounter frameCounter;
    public boolean isAnimation;


    public StartButton() {
        this.frameCounter = new FrameCounter(100);
        this.imageRenderer = new ImageRenderer("resources/start 1.png");
        this.animationRenderer = new AnimationRenderer(
                3,
                "resources/start 1.png",
                "resources/start 2.png",
                "resources/start 1.png"
        );
        this.renderer = imageRenderer;
        if (this.isAnimation) {
            if (this.frameCounter.run()) {
                this.isAnimation = false;
                this.renderer = this.imageRenderer;
                this.frameCounter.reset();
            }
        }
    }

    @Override
    public void run() {

    }
}
