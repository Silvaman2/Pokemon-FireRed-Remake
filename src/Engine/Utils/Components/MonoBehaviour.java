package Engine.Utils.Components;

import Engine.Utils.Component;
import Engine.Utils.GameObject;

import java.awt.*;

public abstract class MonoBehaviour implements Component {
    protected GameObject gameObject;

    @Override
    public void drawUpdate(Graphics2D graphics) {

    }

    @Override
    public void setParentObject(GameObject parent) {
        this.gameObject = parent;
    }

    @Override
    public GameObject getParentObject() {
        return gameObject;
    }
}
