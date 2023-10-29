package Engine.Utils;

public class Vector2 {
    public static final Vector2 ZERO = new Vector2();
    private final double positionX;
    private final double positionY;

    private Vector2() {
        this.positionX = 0;
        this.positionY = 0;
    }

    public Vector2(double x, double y) {
        this.positionX = x;
        this.positionY = y;
    }

    public double getX() {
        return positionX;
    }

    public double getY() {
        return positionY;
    }
}
