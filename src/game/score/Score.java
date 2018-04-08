//package game.score;
//
//import base.GameObject;
//import base.GameObjectManager;
//import renderer.StringRenderer;
//
//public class Score extends GameObject {
//
//    public int score;
//
//    public static Score instance;
//
//    private StringRenderer stringRenderer;
//
//    public Score() {
//        this.stringRenderer = new StringRenderer(String.valueOf(score));
//        this.position.set(10,10);
//    }
//
//    @Override
//    public void run() {
//        super.run();
//        stringRenderer.scoreText = String.valueOf(score);
//    }
//}
