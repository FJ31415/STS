package lutz.franz.jakob.gamelogic.maps;

import lutz.franz.jakob.gamelogic.Position;
import lutz.franz.jakob.gamelogic.buildings.Building;
import lutz.franz.jakob.gamelogic.buildings.Capital;
import lutz.franz.jakob.gamelogic.buildings.Farm;
import lutz.franz.jakob.gamelogic.buildings.Mine;
import lutz.franz.jakob.gamelogic.units.Unit;

import static lutz.franz.jakob.gamelogic.nations.Team.*;
import static lutz.franz.jakob.gamelogic.maps.Terrain.*;

public final class SmallMap extends GameMap {
    public SmallMap() {
        super(new Building[] {
                new Capital(TEAM_BLUE, new Position(0, 0)),
                new Farm(TEAM_BLUE, new Position(1, 0)),
                new Mine(TEAM_BLUE, new Position(0, 1)),
                new Capital(TEAM_RED, new Position(5, 5)),
                new Farm(TEAM_BLUE, new Position(4, 5)),
                new Mine(TEAM_RED, new Position(5, 4))
            }, new Unit[] {}, new Terrain[][]{
                { MEADOW, MEADOW, MEADOW, MEADOW, FOREST, FOREST },
                { MEADOW, MEADOW, MEADOW, MEADOW, MEADOW, FOREST },
                { MEADOW, MEADOW, FOREST, MEADOW, MEADOW, MEADOW },
                { MEADOW, MEADOW, MEADOW, FOREST, MEADOW, MEADOW },
                { FOREST, MEADOW, MEADOW, MEADOW, MEADOW, MEADOW },
                { FOREST, FOREST, MEADOW, MEADOW, MEADOW, MEADOW },
            });
    }
}