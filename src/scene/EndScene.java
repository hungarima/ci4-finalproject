package scene;

import base.GameObjectManager;
import game.background.EndBackground;

public class EndScene implements Scene {
    @Override
    public void init() {
        setupBackground();
    }

    @Override
    public void deinit() {

    }

    private void setupBackground() {
        EndBackground endBackground = new EndBackground();
        endBackground.position.set(200,300);
        GameObjectManager.instance.add(endBackground);
    }
}
