package Engine.Utils.Components;

import Engine.Utils.Component;
import Engine.Utils.GameObject;
import Engine.Utils.Vector2;

import java.awt.*;

public class Transform implements Component {
    private Vector2 position;
    private GameObject parentObject;

    public Transform() {
        this.position = Vector2.ZERO;
    }

    public Vector2 getPosition() {
        return this.position;
    }

    public void setPosition(Vector2 newPosition) {
        this.position = newPosition;
    }

    public Vector2 moveTowards(Vector2 newPosition, double moveSpeed) {
        Vector2 positionDiff = newPosition.subtract(this.position);
        Vector2 positionAbs = positionDiff.abs();
        Vector2 positionDiffSign = positionDiff.sign();

        Vector2 resultPosition = Vector2.sum(
                this.position,
                new Vector2(
                        Math.min(positionAbs.getX(), moveSpeed) * positionDiffSign.getX(),
                        Math.min(positionAbs.getY(), moveSpeed) * positionDiffSign.getY()
                )
        );
        return resultPosition;
    }

    @Override
    public void start() {}

    @Override
    public void update() {}

    @Override
    public void drawUpdate(Graphics2D graphics) {}

    @Override
    public void setParentObject(GameObject parent) {
        this.parentObject = parent;
    }

    @Override
    public GameObject getParentObject() {
        return parentObject;
    }
}
