package gamelogic.entity;

import gamelogic.Position;
import gamelogic.nations.Team;

public abstract class GameEntity {
    protected final String name;
    protected final Team team;
    protected final int baseHealth;
    protected int health;
    protected final int costFood, costMaterial;
    protected final Position position;
    protected final EntityGraphic graphic;

    public GameEntity(String name, Team team, int baseHealth, int costFood, int costMaterial, Position position, EntityGraphic graphic) {
        this.name = name;
        this.team = team;
        this.baseHealth = baseHealth;
        this.health = this.baseHealth;
        this.costFood = costFood;
        this.costMaterial = costMaterial;
        this.graphic = graphic;
        this.position = position;

        graphic.setHost(this);
    }

    public abstract void update();

    public void addHealth(int i) {
        health += i;

        if (health < 0)
            health = 0;
        else if(health > baseHealth)
            health = baseHealth;
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

    public final int getCostFood() {
        return costFood;
    }

    public final int getCostMaterial() {
        return costMaterial;
    }

    public final Position getPosition() {
        return position;
    }

    public final EntityGraphic getGraphic() {
        return graphic;
    }
}