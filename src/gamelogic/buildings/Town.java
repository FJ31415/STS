package gamelogic.buildings;

import gamelogic.Building;
import gamelogic.Position;
import gamelogic.Team;

public final class Town extends Building {

    public Town(Team team, Position position) {
        super("Town", team, 3, 1, 1, position);
    }

    @Override
    public void update() {
        super.update();
    }
}