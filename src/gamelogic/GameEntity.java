package gamelogic;

public abstract class GameEntity {

    private final String name;
    protected final Team team;
    private final int baseHealth;
    private int health;
    protected final Position position;
    // TODO add EntityGraphic
    // TODO add Cost

    public GameEntity(String name, Team team, int baseHealth, Position position) {
        this.name = name;
        this.team = team;
        this.baseHealth = baseHealth;
        this.health = this.baseHealth;
        this.position = position;
    }

    public abstract void update();

    public final void subtractHealth(int damage) {
        health -= damage;

        if (health < 0)
            health = 0;
    }

    // getter

    public final String getName() {
        return name;
    }

    public final Team getTeam() {
        return team;
    }

    public final int getBaseHealth() {
        return baseHealth;
    }

    public final int getHealth() {
        return health;
    }

    public final boolean isAlive() {
        return health != 0;
    }

    public final Position getPosition() {
        return position;
    }
}