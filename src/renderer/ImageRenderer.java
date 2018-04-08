package renderer;

import base.GameObjectManager;
import base.Vector2D;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageRenderer implements Renderer {

    private BufferedImage image;

    public ImageRenderer(String path) {
        this.image = Utils.loadImage(path);
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        if (this.image != null) {
            graphics.drawImage(this.image, (int)position.x - this.image.getWidth() / 2, (int)position.y - this.image.getHeight() / 2, null);
//            graphics.drawString("Score: " + String.valueOf(GameObjectManager.instance.getPlayer().score), 10, 10);
        }
    }
}
