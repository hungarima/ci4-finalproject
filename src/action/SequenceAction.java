package action;

import base.GameObject;

import java.util.Arrays;
import java.util.List;

public class SequenceAction implements Action {

    private List<Action> actions;
    private int index = 0;

    public SequenceAction(Action... actions) {
        this.actions = Arrays.asList(actions);
    }

    @Override
    public boolean run(GameObject owner) {
        Action action = this. actions.get(this.index);
        if (action.run(owner)) {
            if (this.index == this.actions.size() - 1) {
                return true;
            } else {
                this.index += 1;
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public void reset() {
        this.index = 0;
        this.actions.forEach(action -> action.reset());
    }
}
