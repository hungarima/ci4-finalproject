package scene;

import base.GameObjectManager;
import game.background.Background;
import game.player.Player;

import javax.sound.sampled.Clip;

public class GamePlayScene implements Scene {

    private Clip clip;


    @Override
    public void init() {
//        this.clip = AudioUtils.instance.loadSound("resources/sound/bgm/bgmwav.wav");
//        this.clip.loop(-1);
        this.setupBackground();
        this.setupPlayer();
    }

    @Override
    public void deinit() {

    }

    private void setupPlayer() {
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(200, 300);
        GameObjectManager.instance.add(player);
    }

    private void setupBackground() {
        Background background = new Background();
        background.position.set(200, 300);
        GameObjectManager.instance.add(background);
    }
}
