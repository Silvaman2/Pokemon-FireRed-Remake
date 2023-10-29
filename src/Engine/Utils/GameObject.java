package Engine.Utils;
import Engine.Game;
import Engine.Utils.Components.Transform;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameObject {

    private final Map<Class<? extends Component>, Component> componentMap = new HashMap<>();
    private Transform transform;
    private String objectName;

    public GameObject() {
        Game.gameInstance.getGameObjects().add(this);
        this.transform = new Transform();
        this.addComponent(this.transform);
        this.objectName = "GameObject";
    }

    public GameObject(String objectName) {
        this();
        this.objectName = objectName;
    }

    public Transform getTransform() {
        return this.transform;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public Set<Component> getComponents() {
        return new HashSet<Component>(this.componentMap.values());
    }

    public <T extends Component> Component getComponent(Class<T> componentClass) {
        return this.componentMap.get(componentClass);
    }

    public <T extends Component> void addComponent(T component) {
        this.componentMap.put(component.getClass(), component);
        component.setParentObject(this);
    }

    public void start() {
        for (Component currentComponent : componentMap.values()) {
            currentComponent.start();
        }
    }

    public void update() {
        for (Component currentComponent : componentMap.values()) {
            currentComponent.update();
        }
    }

}
