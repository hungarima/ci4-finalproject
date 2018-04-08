package game.enemy;

import action.*;
import base.GameObject;
import base.GameObjectManager;
import renderer.ImageRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemySpawner extends GameObject {

    //    private FrameCounter frameCounter;
    private Random random = new Random();


    public EnemySpawner() {
//        this.frameCounter = new FrameCounter(60);
    }

    public void create() {
        List<EnemyChase> enemiesChase = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();
        Action create = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                // Tao ra square
                EnemyChase enemyChase = GameObjectManager.instance.recycle(EnemyChase.class);
                Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                if (random.nextInt(2) == 1) {
                    enemy.renderer = new ImageRenderer("resources/enemyBike/car.png");
                } else {
                    enemy.renderer = new ImageRenderer("resources/enemyBike/lninjja.png");
                }
                if(random.nextInt(3)==1){
                    enemyChase.renderer = new ImageRenderer("resources/enemyBike/xott.png");
                }
                enemyChase.position.set((float)(Math.random()*400),600);
                enemy.position.set(random.nextInt(320 - 70) + 70, 720);
                enemy.velocity.set(0, (random.nextFloat() + 1) * -1);
                enemiesChase.add(enemyChase);
                enemies.add(enemy);
                System.out.println(enemy.position.x + " " + enemy.position.y);
                System.out.println(enemy.velocity.y);
                return true;

            }

            @Override
            public void reset() {

            }
        };




        this.add(
                new ActionAdapter() {
                    Action sequenceAction = new SequenceAction(
                            create,
                            new WaitAction(100)

                    );
                    @Override
                    public boolean run(GameObject owner) {
                        enemies.removeIf(enemy -> !enemy.isAlive);

                        if (enemies.size() != 3) {
                            if (sequenceAction.run(owner))  {
                                sequenceAction.reset();
                            }

                        }
                        return false;
                    }

                    @Override
                    public void reset() {

                    }
                }
        );
    }

//    @Override
//    public void run() {
//        super.run();
//        if (this.frameCounter.run()) {
//            Square square = new Square();
//            square.position.set(random.nextInt(400), 0);
//            square.velocity.set(0, random.nextInt(3) + 2);
//            GameObjectManager.instance.add(square);
//            this.frameCounter.reset();
//        }
//    }
}
