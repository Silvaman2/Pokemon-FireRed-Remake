package Engine.Utils.Components;

import Engine.Game;
import Engine.Utils.Component;
import Engine.Utils.GameObject;
import Engine.Utils.Vector2;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpriteRenderer implements Component {
    private BufferedImage sprite;
    private Vector2 pivot;
    private GameObject parentObject;

    public SpriteRenderer() {
        sprite = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        pivot = Vector2.ZERO;
    }
    public void setSprite(BufferedImage newSprite) {
        this.sprite = newSprite;
    }

    public Vector2 getPivot() {
        return pivot;
    }

    public void setPivot(Vector2 pivot) {
        this.pivot = pivot;
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
        Vector2 cameraPosition = Game.gameInstance.getGameObjectByName("Camera").getTransform().getPosition();

        graphics.drawImage(this.sprite, (int)((position.getX() - this.pivot.getX()) - cameraPosition.getX()),
                (int)((position.getY() - this.pivot.getY()) - cameraPosition.getY()),
                null);
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
