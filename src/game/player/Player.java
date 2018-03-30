package game.player;

import base.FrameCounter;
import base.GameObject;
//import game.player.bullet.PlayerShoot;
//import input.MouseMotionInput;
import input.KeyboardInput;
import physic.BoxCollider;
import renderer.ImageRenderer;
import renderer.Renderer;
import utils.Utils;

import java.awt.event.KeyEvent;
import java.security.Key;

public class Player extends GameObject {

//    private PlayerShoot playerShoot;

    private Renderer imageRenderer;
//    private BoxCollider boxCollider = new BoxCollider(40, 40);
    private FrameCounter frameCounter;


    public Player() {

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
        if (this.position.getY() >= 520){
            this.position.y = 520;
        }
    }

    private void direction(){

    }

    @Override
    public void run() {
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

        System.out.println(KeyboardInput.instance.velocity.getX());
//        this.playerShoot.run(this);
//        this.position.set(MouseMotionInput.instance.position); //chinh lai dieu kien de ngan player ra ngoai window
    }
}
