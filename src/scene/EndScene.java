package scene;

import base.GameObjectManager;
import game.background.ContinueButton;
import game.background.EndBackground;

public class EndScene implements Scene {
    @Override
    public void init() {
        setupBackground();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }

    private void setupBackground() {
        EndBackground endBackground = new EndBackground();
        endBackground.position.set(200,300);
        GameObjectManager.instance.add(endBackground);

        ContinueButton continueButton = new ContinueButton();
        continueButton.position.set(190, 450);
        GameObjectManager.instance.add(continueButton);
    }
}
