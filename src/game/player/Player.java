package game.player;

import base.FrameCounter;
import base.GameObject;
//import game.player.bullet.PlayerShoot;
//import input.MouseMotionInput;
import input.KeyboardInput;
import physic.BoxCollider;
import physic.HitObject;
import physic.PhysicBody;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import renderer.Renderer;
import utils.Utils;

import java.awt.event.KeyEvent;
import java.security.Key;

public class Player extends GameObject implements PhysicBody, HitObject {



    private Renderer imageRenderer;
    private Renderer animationRenderer;
    private BoxCollider boxCollider = new BoxCollider(45, 50);
    private FrameCounter frameCounter;
    private boolean isAnimation;
    public int score;


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

    private void direction(){

    }

    @Override
    public void run() {
        this.score ++;
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
        this.direction();
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




//        this.playerShoot.run(this);
//        this.position.set(MouseMotionInput.instance.position); //chinh lai dieu kien de ngan player ra ngoai window
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

}

