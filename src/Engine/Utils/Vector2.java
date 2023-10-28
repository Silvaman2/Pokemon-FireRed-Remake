package Engine.Utils;

public class Vector2 {
    public static final Vector2 ZERO = new Vector2();
    private final int positionX;
    private final int positionY;

    private Vector2() {
        this.positionX = 0;
        this.positionY = 0;
    }

    public Vector2(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public int getX() {
        return positionX;
    }

    public int getY() {
        return positionY;
    }
}
