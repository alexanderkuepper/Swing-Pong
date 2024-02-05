package helper;

public class Vector2D {
    public int X, Y;

    public Vector2D(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public void mul(Vector2D vector) {
        X *= vector.X;
        Y *= vector.Y;
    }

    public void mul(int value) {
        X *= value;
        Y *= value;
    }

    public void add(Vector2D vector) {
        X += vector.X;
        Y += vector.Y;
    }
}
