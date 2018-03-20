package physic;

import base.GameObject;
import base.GameObjectManager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by huynq on 3/17/18.
 */
public class RunHitObject<O extends GameObject & PhysicBody & HitObject> {

    private List<Class<O>> objects;

    public RunHitObject(Class<O>... objects) {
        this.objects = Arrays.asList(objects);
    }

    public <T extends GameObject & PhysicBody & HitObject> void run(T gameObject) { //object di va cham
        BoxCollider boxCollider = gameObject.getBoxCollider();
        this.objects.forEach(oClass -> {
            O object = GameObjectManager.instance.checkCollision(boxCollider, oClass);
            if (object != null) {
                object.getHit(gameObject);
                gameObject.getHit(object);
            }
        });
    }
}
