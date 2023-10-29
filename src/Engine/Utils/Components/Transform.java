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

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }

    @Override
    public void drawUpdate(Graphics2D graphics) {

    }

    @Override
    public void setParentObject(GameObject parent) {
        this.parentObject = parent;
    }

    @Override
    public GameObject getParentObject() {
        return parentObject;
    }
}
