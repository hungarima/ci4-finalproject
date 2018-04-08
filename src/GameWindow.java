

import input.KeyboardInput;
import input.MouseInput;

import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    private long lastTime = 0;
    public String name;

    public GameWindow() {
        this.setup();
        this.setupCanvas();
        this.listener();
        this.setVisible(true);
    }

    private void setup() {
        this.setSize(400, 600);
    }

    private void setupCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void listener() {
        this.keyboardListener();
        this.windowListener();
        this.mouseListener();
    }

    private void keyboardListener() {
        this.addKeyListener(KeyboardInput.instance);
    }

    private void mouseListener() {
        this.addMouseListener(MouseInput.instance);
    }

    private void windowListener() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}
