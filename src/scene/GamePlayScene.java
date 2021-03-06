package scene;


import base.GameObjectManager;
import game.background.Background1;
import game.background.Background2;


import game.player.Player;
import game.enemy.EnemySpawner;
import game.roadobjects.Brick;
//import game.score.Score;
import utils.AudioUtils;

import javax.sound.sampled.Clip;

public class GamePlayScene implements Scene {

    private Clip clip;


    @Override
    public void init() {
        this.clip = AudioUtils.instance.loadSound("resources/sound/dcbm.wav");
        this.clip.loop(-1);
        this.setupBackground();
        this.setupPlayer();
        this.setupEnemy();
//        Score score = GameObjectManager.instance.recycle(Score.class);
//        Score.instance = score;
//        Score.instance
//        this.setupBrick();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        this.clip.stop();
    }

    private void setupPlayer() {
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(200, 300);
//        GameObjectManager.instance.add(player);
    }

    private void setupBrick() {
        Brick brick = GameObjectManager.instance.recycle(Brick.class);
        brick.position.set((float)((Math.random()*200) + 100), (float)((Math.random()*600)));
        GameObjectManager.instance.add(brick);
    }

    private void setupBackground() {
        Background1 background1 = new Background1();
        Background2 background2 = new Background2();
        background1.position.set(200, 300);
        background2.position.set(200, 300 - 720);
        GameObjectManager.instance.add(background1);
        GameObjectManager.instance.add(background2);
    }

    private void setupEnemy() {
        EnemySpawner enemySpawner = GameObjectManager.instance.recycle(EnemySpawner.class);
        enemySpawner.create();
//        GameObjectManager.instance.add(new EnemySpawner());
    }
}
