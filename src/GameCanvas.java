import base.GameObjectManager;
import game.background.Background;
//import game.block.BlockSpawner;
//import game.enemy.EnemySqawner;
//import game.enemyhard.EnemyHard;
import game.player.Player;
import scence.SceneManager;
import scene.GamePlayScene;
//import game.square.circle.CircleSquare;
//import game.square.matrix.MatrixSquare;
//import game.square.SquareSpawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//Co rat nhieu thang su dung den chuot

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;

    public GameCanvas() {
        this.setup();
        this.setupBackBuffered();
        SceneManager.instance.changeScene(new GamePlayScene());
    }

    private void setup() {
        this.setSize(400, 600);
        this.setVisible(true);
    }


    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
        SceneManager.instance.performSceneIfNeeded();
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }
}
