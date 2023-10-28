package Engine.Utils.Components;

import Engine.Utils.Component;
import Engine.Utils.GameObject;
import Engine.Utils.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteRenderer implements Component {
    private BufferedImage sprite;
    private GameObject parentObject;

    public SpriteRenderer() {
        sprite = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }
    public void setSprite(BufferedImage newSprite) {
        this.sprite = newSprite;
    }

    @Override
    public void start() {

    }

    @Override
    public void update() {

    }

    @Override
    public void drawUpdate(Graphics2D graphics) {
        Vector2 position = this.parentObject.getTransform().getPosition();
        graphics.drawImage(this.sprite, position.getX(), position.getY(), null);
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
