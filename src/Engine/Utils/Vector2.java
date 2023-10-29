package Engine.Utils;

import java.util.Objects;

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

    public Vector2 sum(Vector2 otherVector) {
        return new Vector2(
                this.positionX + otherVector.positionX,
                this.positionY + otherVector.positionY
        );
    }

    public Vector2 subtract(Vector2 otherVector) {
        return new Vector2(
                this.positionX - otherVector.positionX,
                this.positionY - otherVector.positionY
        );
    }

    public Vector2 sign() {
        return new Vector2(
                Math.signum(this.positionX),
                Math.signum(this.positionY));
    }
    public Vector2 abs() {
        return new Vector2(Math.abs(this.positionX), Math.abs(this.positionY));
    }

    public static Vector2 sum(Vector2 firstVector, Vector2 secondVector) {
        return new Vector2(
                firstVector.positionX + secondVector.positionX,
                firstVector.positionY + secondVector.positionY
        );
    }

    public static Vector2 subtract(Vector2 firstVector, Vector2 secondVector) {
        return new Vector2(
                firstVector.positionX - secondVector.positionX,
                firstVector.positionY - secondVector.positionY
        );
    }

    public static Vector2 sign(Vector2 vector) {
        return new Vector2(Math.signum(vector.positionX), Math.signum(vector.positionY));
    }

    public static Vector2 abs(Vector2 vector) {
        return new Vector2(Math.abs(vector.positionX), Math.abs(vector.positionY));
    }

    @Override
    public String toString() {
        return String.format("%2f, %2f", this.positionX, this.positionY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return (this.positionX == vector2.positionX) && (this.positionY == vector2.positionY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY);
    }
}
