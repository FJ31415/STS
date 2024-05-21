package gamelogic;

public class Position {

    private int x, y;

    public Position(int x, int y) {
        set(x, y);
    }

    public Position(Position position) {
        set(position);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Position
                && ((Position) obj).getX() == x
                && ((Position) obj).getY() == y;
    }

    public final boolean equals(int x, int y) {
        return this.x == x && this.y == y;
    }

    // setter

    public final void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public final void set(Position position) {
        x = position.getX();
        y = position.getY();
    }

    public final void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    // getter

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }
}