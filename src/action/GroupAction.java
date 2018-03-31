package action;

import base.GameObject;

import java.util.List;

public class GroupAction implements Action {
    private List<Action> actions;

    @Override
    public boolean run(GameObject owner) {
        this.actions.removeIf(action -> action.run(owner));
        return this.actions.isEmpty();
    }

    @Override
    public void reset() {

    }
}
