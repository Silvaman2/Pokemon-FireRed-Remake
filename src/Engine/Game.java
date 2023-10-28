package Engine;

import Engine.Utils.Components.SpriteRenderer;
import Engine.Utils.GameObject;

import java.util.ArrayList;
import java.util.List;

public class Game implements Runnable {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int FPS = 30;
    public static final int UPS = 300;

    public static Game gameInstance;

    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final List<GameObject> gameObjects = new ArrayList<>();

    public static void main(String[] args) {
        gameInstance = new Game();
    }

    public Game() {
        this.gameFrame = new GameFrame();
        this.gamePanel = new GamePanel();
        this.gameFrame.add(gamePanel);
        this.gameThread = new Thread(this);
        this.gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS;
        double timePerUpdate = 1000000000.0 / UPS;

        long lastFrameTime = System.nanoTime();
        long lastUpdateTime = System.nanoTime();

        int fpsCounter = 0;
        int upsCounter = 0;

        long counterLastCheck = System.currentTimeMillis();

        this.start();

        while(true) {
            if(System.nanoTime() - lastFrameTime > timePerFrame) {
                this.gamePanel.updateGraphics();
                this.gamePanel.repaint();
                lastFrameTime = System.nanoTime();
                fpsCounter++;
            }
            if(System.nanoTime() - lastUpdateTime > timePerUpdate) {
                this.update();
                lastUpdateTime = System.nanoTime();
                upsCounter++;
            }


            if(System.currentTimeMillis() - counterLastCheck >= 1000) {
                System.out.println("FPS: " + fpsCounter);
                System.out.println("UPS: " + upsCounter);
                counterLastCheck = System.currentTimeMillis();
                fpsCounter = 0;
                upsCounter = 0;
            }
        }
    }

    private void start() {
        GameObject player = new GameObject();
        player.addComponent(new SpriteRenderer());
        SpriteRenderer playerRenderer = (SpriteRenderer) player.getComponent(SpriteRenderer.class);
        playerRenderer.setSprite(GamePanel.getImage("Resources/playerSprites.png"));

        this.gameObjects.forEach(GameObject::start);
    }

    private void update() {
        this.gameObjects.forEach(GameObject::update);
    }

    public List<GameObject> getGameObjects() {
        return this.gameObjects;
    }
}