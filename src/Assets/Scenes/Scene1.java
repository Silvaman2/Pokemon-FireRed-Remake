package Assets.Scenes;

import Assets.PlayerScript;
import Assets.Utils.TileMap;
import Engine.Game;
import Engine.GamePanel;
import Engine.Utils.Components.Camera;
import Engine.Utils.Components.SpriteRenderer;
import Engine.Utils.GameObject;
import Engine.Utils.Vector2;

public class Scene1 {
    public Scene1() {
        GameObject tileMap = tileMap();
        GameObject map = map();
        GameObject player = player();
        GameObject camera = camera(player);
    }

    public GameObject tileMap() {
        GameObject tileMapObject = new GameObject("TileMap");
        tileMapObject.addComponent(new TileMap(new Vector2(16, 16)));
        return tileMapObject;
    }

    public GameObject map() {
        GameObject map = new GameObject("Map");
        SpriteRenderer mapRenderer = new SpriteRenderer();
        mapRenderer.setSprite(GamePanel.getImage("Resources/palletTown.png"));
        map.addComponent(mapRenderer);

        return map;
    }

    public GameObject player() {
        GameObject playerObject = new GameObject("Player");
        SpriteRenderer playerRenderer = new SpriteRenderer();
        playerRenderer.setPivot(new Vector2(0, 16));
        playerObject.addComponent(playerRenderer);
        playerRenderer.setSprite(GamePanel.getImage("Resources/playerFrontIdle.png"));
        PlayerScript playerScript = new PlayerScript();
        playerObject.addComponent(new PlayerScript());
        return playerObject;
    }

    public GameObject camera(GameObject target) {
        GameObject cameraObject = new GameObject("Camera");
        Camera cameraComponent = new Camera();
        cameraComponent.setTarget(target);
        cameraComponent.setFollowOffset(new Vector2((double) Game.WIDTH / 2, (double) Game.HEIGHT / 2));
        cameraObject.addComponent(cameraComponent);
        return cameraObject;
    }
}
