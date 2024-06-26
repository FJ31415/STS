package lutz.franz.jakob.gamelogic.nations;

public enum Team {
    TEAM_RED,
    TEAM_BLUE;

    private final int spriteShift;

    Team() {
        spriteShift = ordinal() * 40;
    }

    public int getSpriteShift() {
    return spriteShift;
    }
}