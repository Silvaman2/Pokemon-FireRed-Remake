package Assets;
import Assets.Utils.TileMap;
import Engine.Game;
import Engine.Utils.Components.MonoBehaviour;
import Engine.Utils.Vector2;

public class PlayerScript extends MonoBehaviour {

    private double moveSpeed = 0.3;
    private boolean isMoving = false;
    private Vector2 targetCellPosition;
    public TileMap tileMap;
    @Override
    public void start() {
        tileMap = (TileMap) Game.gameInstance.getGameObjectByName("TileMap").getComponent(TileMap.class);
        targetCellPosition = tileMap.worldToCellPosition(gameObject.getTransform().getPosition());
    }

    @Override
    public void update() {

        if(isMoving) {
            gameObject.getTransform().setPosition(gameObject.getTransform().moveTowards(tileMap.cellToWorldPosition(targetCellPosition), moveSpeed));
            if(this.gameObject.getTransform().getPosition().equals(tileMap.cellToWorldPosition(targetCellPosition))) isMoving = false;
            return;
        }

        if(Game.INPUT.getAxis("Horizontal") != 0) {
            isMoving = true;
            System.out.println(targetCellPosition.getX());
            targetCellPosition = Vector2.sum(
                    targetCellPosition,
                    new Vector2(Game.INPUT.getAxis("Horizontal"), 0)
            );
            System.out.println(targetCellPosition.getX());
            return;
        }
        if(Game.INPUT.getAxis("Vertical") != 0) {
            isMoving = true;
            targetCellPosition = Vector2.sum(
                    targetCellPosition,
                    new Vector2(0, Game.INPUT.getAxis("Vertical"))
            );
        }
    }
}
