package scene;

import base.GameObject;
import base.GameObjectManager;
import game.background.*;

public class StartScene implements Scene {
    @Override
    public void init() {
        setupBackground();
        setupElements();
    }

    @Override
    public void deinit() {

    }

    private void setupBackground() {
        StartBackground1 background1 = new StartBackground1();
        StartBackground2 background2 = new StartBackground2();

        background1.position.set(-10, 00);
        background2.position.set(-10, 00 - 700);
        GameObjectManager.instance.add(background1);
        GameObjectManager.instance.add(background2);
    }

    private void setupElements() {
        StartButton startButton = new StartButton();
        SoundButton soundButton = new SoundButton();
        Figure figure = new Figure();
        startButton.position.set(190, 400);
        soundButton.position.set(330,50);
        figure.position.set(190, 300);
        GameObjectManager.instance.add(startButton);
        GameObjectManager.instance.add(soundButton);
//        GameObjectManager.instance.add(figure);
    }
}
