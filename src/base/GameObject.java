package base;

import action.Action;
import renderer.Renderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObject {
    public Renderer renderer;
    public Vector2D position;
    public boolean isAlive;
    private List<Action> actions;

    public GameObject() {
        this.position = new Vector2D();
        this.isAlive = true;
        this.actions = new ArrayList<>();
    }


    public void run() {
        this.actions.removeIf(action -> action.run(this));
    }

    public void add(Action action) {
        this.actions.add(action);
    }

    public void render(Graphics graphics) {
        if (this.renderer != null) {
            this.renderer.render(graphics, this.position);
        }
    }


}
