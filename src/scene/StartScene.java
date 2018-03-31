package scene;

import base.GameObjectManager;
import game.background.Background1;
import game.background.Background2;
import game.background.StartBackground1;
import game.background.StartBackground2;

public class StartScene implements Scene {
    @Override
    public void init() {
        setupBackground();
    }

    @Override
    public void deinit() {

    }

    private void setupBackground() {
        StartBackground1 background1 = new StartBackground1();
        StartBackground2 background2 = new StartBackground2();

        background1.position.set(200, 300);
        background2.position.set(200, 300 - 720);
        GameObjectManager.instance.add(background1);
        GameObjectManager.instance.add(background2);
    }
}
