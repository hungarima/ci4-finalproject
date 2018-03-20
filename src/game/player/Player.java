package game.player;

import base.GameObject;
//import game.player.bullet.PlayerShoot;
//import input.MouseMotionInput;
import input.KeyboardInput;
import utils.Utils;

public class Player extends GameObject {

//    private PlayerShoot playerShoot;

    public Player() {
        this.image = Utils.loadImage("resources/grabmodel2.png");
//        this.playerShoot = new PlayerShoot();
//        MouseMotionInput mouseMotionInput = new MouseMotionInput(); //ko the nao khai bao nhu nay, ko listen dc
         KeyboardInput keyboardInput = new KeyboardInput();
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

    @Override
    public void run() {
        super.run();
        this.position.addUp(KeyboardInput.instance.velocity);
//        this.position.set(KeyboardInput.instance.position);
        this.block();
//        this.playerShoot.run(this);
//        this.position.set(MouseMotionInput.instance.position); //chinh lai dieu kien de ngan player ra ngoai window
    }
}
