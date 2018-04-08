package game.background;

import base.GameObject;
import input.MouseInput;
import renderer.ImageRenderer;
import renderer.Renderer;
import scene.GamePlayScene;
import scene.StartScene;

public class ContinueButton extends GameObject {
    private Renderer imageRenderer;

    public ContinueButton() {
        this.imageRenderer = new ImageRenderer("resources/CONTINUE 1.png");
        this.renderer = imageRenderer;
    }

    @Override
    public void run() {
        this.clicked();
    }

    public void clicked() {
        if (MouseInput.instance.state) {
            System.out.println("aw");
            if(MouseInput.instance.mouseReleased) {
                scence.SceneManager.instance.changeScene(new StartScene());
            }
        }
        MouseInput.instance.state = false;
    }
}
