package Assets.Utils;

import Engine.Utils.Components.MonoBehaviour;
import Engine.Utils.Vector2;

public class TileMap extends MonoBehaviour {
    private Vector2 cellSize;

    public TileMap(Vector2 cellSize) {
        this.cellSize = cellSize;
    }

    public TileMap(double cellSizeX, double cellSizeY) {
        this.cellSize = new Vector2(cellSizeX, cellSizeY);
    }

    public Vector2 worldToCellPosition(Vector2 worldPosition) {
        return new Vector2(
                Math.round(worldPosition.getX() / this.cellSize.getX()),
                Math.round(worldPosition.getY() / this.cellSize.getY())
        );
    }

    public Vector2 cellToWorldPosition(Vector2 cellPosition) {
        return new Vector2(
                cellPosition.getX() * this.cellSize.getX(),
                cellPosition.getY() * this.cellSize.getY()
        );
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }
}
