package renderer;

import base.Vector2D;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class BlurRenderer implements Renderer {

    private BufferedImage image;

    public BlurRenderer(String path) {
        this.image = Utils.loadImage(path);
        BufferedImage filteredImage = new BufferedImage(image.getWidth(null), image
                .getHeight(null), BufferedImage.TYPE_BYTE_GRAY);

        Graphics g1 = filteredImage.getGraphics();
        g1.drawImage(image, 400, 720, null);

        float[] blurKernel = new float[400];
        for (int i = 0; i < 400; i++)
            blurKernel[i] = 1.0f/400.0f;

        BufferedImageOp blur = new ConvolveOp( new Kernel(20, 20, blurKernel), ConvolveOp.EDGE_ZERO_FILL, null );

        image = blur.filter(image, null);
        g1.dispose();
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.drawImage(image, null,(int)position.x,(int)position.y);
    }
}
