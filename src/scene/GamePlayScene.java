package scene;

import base.GameObjectManager;
import game.background.Background1;
import game.background.Background2;
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
    }

    private void setupBackground() {
        Background1 background1 = new Background1();
        Background2 background2 = new Background2();
        background1.position.set(200, 300);
        background2.position.set(200, 300 - 720);
        GameObjectManager.instance.add(background1);
        GameObjectManager.instance.add(background2);
    }
}
