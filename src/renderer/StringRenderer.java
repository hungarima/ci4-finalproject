package renderer;

import base.GameObjectManager;
import base.Vector2D;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StringRenderer implements Renderer{

    public BufferedImage image;

    public StringRenderer() {
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.drawString("Score: " + String.valueOf(GameObjectManager.instance.getPlayer().score), 10, 10);
    }
}
