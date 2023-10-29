package Engine;

import Engine.Utils.Config;
import Engine.Utils.MathUtils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Input implements KeyListener {
    public static final int PRESSED = 0;
    public static final int HELD = 1;
    public static final int RELEASED = 2;

    private Map<Integer, Boolean> keyPressedMap = new TreeMap<>();
    private Map<Integer, Boolean> keyHeldMap = new TreeMap<>();
    private Set<Integer> keyReleasedSet = new TreeSet<>();

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        this.keyPressedMap.putIfAbsent(e.getKeyCode(), true);
        this.keyHeldMap.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(!this.keyReleasedSet.contains(e.getKeyCode())) {
            this.keyReleasedSet.add(e.getKeyCode());
        }
        this.keyHeldMap.put(e.getKeyCode(), false);
        this.keyPressedMap.remove(e.getKeyCode());
    }

    public boolean getKeyPressed(int keyCode) {
        if(!this.keyPressedMap.containsKey(keyCode)) return false;
        return this.keyPressedMap.get(keyCode);
    }

    public boolean getKeyHeld(int keyCode) {
        this.keyHeldMap.putIfAbsent(keyCode, false);
        return this.keyHeldMap.get(keyCode);
    }

    public boolean getKeyReleased(int keyCode) {
        return this.keyReleasedSet.contains(keyCode);
    }

    public double getAxis(String axisName) {
        double resultAxis = 0;
        switch(axisName) {
            case "Horizontal":
                resultAxis -= (double) MathUtils.booleanToInt(this.getKeyHeld(Config.Input.MovementAxis.Horizontal.NEGATIVE_KEY));
                resultAxis += (double) MathUtils.booleanToInt(this.getKeyHeld(Config.Input.MovementAxis.Horizontal.POSITIVE_KEY));
                break;
            case "Vertical":
                resultAxis -= (double) MathUtils.booleanToInt(this.getKeyHeld(Config.Input.MovementAxis.Vertical.NEGATIVE_KEY));
                resultAxis += (double) MathUtils.booleanToInt(this.getKeyHeld(Config.Input.MovementAxis.Vertical.POSITIVE_KEY));
                break;
            default:
                throw new RuntimeException("Axis doesn't exist");
        }
        return resultAxis;
    }



    public void clearStates() {
        for (Integer currentKeyCode : keyPressedMap.keySet()) {
            keyPressedMap.put(currentKeyCode, false);
        }

        this.keyReleasedSet = new TreeSet<>();
    }
}
