package game.background;

import base.FrameCounter;
import base.GameObject;
import input.MouseInput;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import renderer.Renderer;
import scence.SceneManager;
import scene.GamePlayScene;

public class StartButton extends GameObject {
    private Renderer imageRenderer;
    public Renderer animationRenderer;
    private FrameCounter frameCounter;
    public boolean isAnimation;


    public StartButton() {

        this.imageRenderer = new ImageRenderer("resources/start 1.png");
        this.animationRenderer = new AnimationRenderer(
                3,
                "resources/start 1.png",
                "resources/start 2.png",
                "resources/start 1.png"
        );
        this.frameCounter = new FrameCounter(10);
        this.renderer = imageRenderer;

    }

    @Override
    public void run() {
        if (this.isAnimation) {
            if (this.frameCounter.run()) {
                this.isAnimation = false;
                this.renderer = this.imageRenderer;
                this.frameCounter.reset();
            }
        }

        this.clicked();

    }

    public void clicked() {
        if (MouseInput.instance.state) {
            System.out.println("clicked!");
            this.renderer = this.animationRenderer;
            this.isAnimation = true;
            if(MouseInput.instance.mouseReleased) {
                SceneManager.instance.changeScene(new GamePlayScene());

            }

        }
        MouseInput.instance.state = false;
    }

}
