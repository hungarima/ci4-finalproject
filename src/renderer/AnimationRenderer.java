package renderer;

import base.FrameCounter;
import base.Vector2D;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AnimationRenderer implements Renderer {

    private List<BufferedImage> images;
    private boolean isRepeat;
    private FrameCounter frameCounter;
    private int currentIndex;
    private boolean disable = false;


    public AnimationRenderer(boolean isRepeat, int max, String... paths) {
        this.isRepeat = isRepeat;
        this.frameCounter = new FrameCounter(max);
        this.images = new ArrayList<>();
        Arrays.asList(paths).forEach(path -> images.add(Utils.loadImage(path)));
        currentIndex = 0;
    }

    public AnimationRenderer(int max, String... paths) {
        this(true, max, paths);
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
            if (this.disable) return;
            BufferedImage bufferedImage = this.images.get(this.currentIndex);
            if (bufferedImage != null) {
                graphics.drawImage(bufferedImage, (int)position.x - bufferedImage.getWidth() / 2, (int)position.y - bufferedImage.getHeight() / 2, null);
            }
            if (this.currentIndex == this.images.size() - 1 && !this.isRepeat) {
                this.disable = true;
            } else {
                if (this.frameCounter.run()) {
                    if (this.currentIndex >= this.images.size() - 1) {
                        this.currentIndex = 0;
                    } else {
                        this.currentIndex += 1;
                    }
                    this.frameCounter.reset();
                }
            }

    }
}
