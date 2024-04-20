package gamelogic;

public abstract class Building extends GameEntity {
    // TODO add resource-generation

    public Building(String name, Team team, int baseHealth, Position position) {
        super(name, team, baseHealth, position);
    }
}
