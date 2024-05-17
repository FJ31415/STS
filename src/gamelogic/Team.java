package gamelogic;

public enum Team {
    TEAM_RED,
    TEAM_BLUE;

    private final int spriteShift;
    private int food, material;

    Team() {
        spriteShift = ordinal() * 20;
        food = 0;
        material = 0;
    }

    public void addFood(int i) {
        food += i;
    }

    public void addMaterial(int i) {
        material += i;
    }

    public int getSpriteShift() {
    return spriteShift;
    }
}