package scence;

import scene.Scene;

public class SceneManager {

    public static SceneManager instance = new SceneManager();

    private Scene currentScene;
    private Scene nextScene;

    private SceneManager() {

    }

    public void changeScene(Scene scene) {
        this.nextScene = scene;
    }

    public void performSceneIfNeeded() {
        if (this.nextScene != null) {
            if (this.currentScene != null) {
                this.currentScene.deinit();
            }

            this.nextScene.init();
            this.currentScene = this.nextScene;
            this.nextScene = null;
        }
    }
}

