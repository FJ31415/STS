package gamelogic;

public final class Position {

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

    // setter

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public  void set(Position position) {
        x = position.getX();
        y = position.getY();
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }

    // getter

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}