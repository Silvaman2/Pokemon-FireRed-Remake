package Engine.Utils.Components;

import Engine.Utils.Component;
import Engine.Utils.GameObject;
import Engine.Utils.Vector2;

import java.awt.*;
import java.util.Objects;

public class Camera implements Component {
    private GameObject parentObject;
    private GameObject target;

    private Vector2 followOffset;

    public Camera() {
        followOffset = Vector2.ZERO;
    }

    public void setTarget(GameObject target) {
        this.target = target;
    }

    public Vector2 getFollowOffset() {
        return followOffset;
    }

    public void setFollowOffset(Vector2 followOffset) {
        this.followOffset = followOffset;
    }

    private void followTarget() {
        if(Objects.isNull(this.target)) return;
        parentObject.getTransform().setPosition(this.target.getTransform().getPosition().subtract(this.followOffset));
    }

    @Override
    public void start() {
        followTarget();
    }

    @Override
    public void update() {
        followTarget();
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
        return this.parentObject;
    }
}
