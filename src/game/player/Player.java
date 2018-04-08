package game.player;

import base.FrameCounter;
import base.GameObject;
//import game.player.bullet.PlayerShoot;
//import input.MouseMotionInput;
import game.roadobjects.Brick;
import input.KeyboardInput;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import renderer.Renderer;
//import renderer.ScoreRenderer;
import utils.Utils;

import java.awt.event.KeyEvent;
import java.security.Key;

public class Player extends GameObject implements PhysicBody, HitObject {
//    private Renderer scoreRenderer;
    private Renderer imageRenderer;
    private Renderer animationRenderer;
    private BoxCollider boxCollider = new BoxCollider(45, 50);
    private FrameCounter frameCounter;
    private boolean isAnimation;
    public int score;
    private int count;
    private RunHitObject runHitObject;


    public Player() {
        this.frameCounter = new FrameCounter(50);
        this.animationRenderer = new AnimationRenderer(
                5,
                "resources/player/NVAT.png",
                "resources/player/blah.png",
                "resources/player/NVAT.png",
                "resources/player/blah.png",
                "resources/player/NVAT.png"
        );
        this.score = score;
        this.count = count;
        this.runHitObject = new RunHitObject(Brick.class);
    }

    private void block(){
        if(this.position.getX() >= 320){
            this.position.x = 320;
        }
        if (this.position.getX() <= 70){
            this.position.x = 70;
        }
        if (this.position.getY() <= 0){
            this.position.y = 0;
        }
        if (this.position.getY() >= 600){
            this.position.y = 600;
        }
    }

    private void addScore(){
        if(this.count % 100 == 0){
            this.score+=10;
        }
    }

//    public void collectBrick(){
//        if(this.position.equals())
//    }

    @Override
    public void run() {
        this.count++;
        this.addScore();
        this.position.addUp(0,(float)0.12);
        KeyboardInput.instance.setStraight();
        if(KeyboardInput.instance.velocity.getX() > 0){
            this.imageRenderer = new ImageRenderer("resources/player/NVAT phải.png");
        }
        else if(KeyboardInput.instance.velocity.getX() < 0){
            this.imageRenderer = new ImageRenderer("resources/player/NVAT trái.png");
        }
        else{
            this.imageRenderer = new ImageRenderer("resources/player/NVAT.png");
        }
        this.renderer = this.imageRenderer;
        super.run();
        this.position.addUp(KeyboardInput.instance.velocity);
        this.block();
        this.boxCollider.position.set(this.position);
        if (this.isAnimation) {
            if (this.frameCounter.run()) {
                this.isAnimation = false;
                this.renderer = this.imageRenderer;
                this.frameCounter.reset();
            }
        }
//        this.runHitObject.run(this);
//        this.displayScore();
    }

        @Override
        public void getHit(GameObject gameObject) {
            this.renderer = this.animationRenderer;
            this.isAnimation = true;
//            System.out.println("Ouch!");
        }

        @Override
        public BoxCollider getBoxCollider() {
            return this.boxCollider;
        }

//        public void displayScore(){
//            this.scoreRenderer = new ScoreRenderer();
//            System.out.println(this.scoreRenderer);
//        }
}

