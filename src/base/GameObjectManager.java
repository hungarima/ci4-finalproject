package base;

//import game.enemy.Enemy;
import game.enemy.Enemy;
import game.player.Player;
//import game.square.Square;
import physic.BoxCollider;
import physic.PhysicBody;
import game.roadobjects.Brick;

import java.awt.*;
import java.util.Vector;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager(); //chi co duy nhat mot object gameobjectmanager

    private Vector<GameObject> vector = new Vector<>();
    private Vector<GameObject> temp = new Vector<>();

    //chi dc phep khoi tao object trong class nay, ngoai class thi ko dc
    private GameObjectManager() {
    }

    public void runAll() {
        this.vector
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .forEach(gameObject -> gameObject.run());
        this.vector.addAll(this.temp);
        this.temp.clear();
    }

    public void renderAll(Graphics graphics) {
        this.vector
                .stream()
                .filter(gameObject -> gameObject.isAlive) //loc object dang song
                .forEach(gameObject -> gameObject.render(graphics));
    }

    public Player getPlayer() {
        return (Player) this.vector
                .stream()
                .filter(gameObject -> gameObject instanceof Player) //duyet tat ca phan tu sao cho thoa dien kien truyen (thuc chat true || false) vao thi lay
                .findFirst() //phan tu dau tien
                .orElse(null); // neu ko lay dc tra null
    }
    //Kieu Square
    public <T extends GameObject> T checkCollision(BoxCollider other, Class<T> cls) { //Square
        return (T) this.vector
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .filter(gameObject -> gameObject instanceof PhysicBody)
                .filter(gameObject -> {
                    BoxCollider boxCollider = ((PhysicBody) gameObject).getBoxCollider();//ko null
                    return boxCollider.checkCollider(other);
                })
                .findFirst()
                .orElse(null);
    }

    public <T extends GameObject> T checkCollisionAround(BoxCollider other, Class<T> cls) {
        return (T) this.vector
                .stream()
                .filter(gameObject -> gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .filter(gameObject -> gameObject instanceof Enemy)
                .filter(gameObject -> {
                    BoxCollider boxCollider = ((Enemy) gameObject).getBoxCollider();
                    return boxCollider.checkColliderAround(other, 100);

                })
                .findFirst()
                .orElse(null);
    }


    public <T extends  GameObject> T recycle(Class<T> cls) {
        T t =  (T) this.vector
                .stream()
                .filter(gameObject -> !gameObject.isAlive)
                .filter(gameObject -> cls.isInstance(gameObject))
                .findFirst()
                .orElse(null);

        if (t == null) {
            try {
                t = cls.newInstance();
                this.add(t);
                return t;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        t.isAlive = true;
        return t;


    }


    public void add(GameObject gameObject) {
        this.temp.add(gameObject);
    }
}
