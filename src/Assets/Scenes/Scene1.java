package Assets.Scenes;

import Assets.PlayerScript;
import Engine.GamePanel;
import Engine.Utils.Components.SpriteRenderer;
import Engine.Utils.GameObject;

public class Scene1 {
    public Scene1() {
        player();
    }

    public GameObject player() {
        GameObject playerObject = new GameObject();
        SpriteRenderer playerRenderer = new SpriteRenderer();
        playerObject.addComponent(playerRenderer);
        playerRenderer.setSprite(GamePanel.getImage("Resources/playerFrontIdle.png"));
        playerObject.addComponent(new PlayerScript());
        return playerObject;
    }
}
