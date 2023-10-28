package Engine.Utils;

import java.awt.*;

public interface Component {
    public void start();
    public void update();
    public void drawUpdate(Graphics2D graphics);
    public void setParentObject(GameObject parent);
    public GameObject getParentObject();
}
