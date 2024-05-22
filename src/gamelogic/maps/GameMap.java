package gamelogic.maps;
import gamelogic.Position;
import gamelogic.buildings.Building;
import gamelogic.units.Unit;

public abstract class GameMap {
    private final Building[] startingBuildings;
    private final Unit[] startingUnits;
    private final Terrain[][] map;

    public GameMap(Building[] startingBuildings, Unit[] startingUnits, Terrain[][] map) {
        this.startingBuildings = startingBuildings;
        this.startingUnits = startingUnits;
        this.map = map;
    }

    // getter

    public final Building[] getStartingBuildings() {
        return startingBuildings;
    }

    public final Unit[] getStartingUnits() {
        return startingUnits;
    }

    public final Terrain getTerrain(Position position) {
        return getTerrain(position.getX(), position.getY());
    }

    public final Terrain getTerrain(int x, int y) {
        return map[x][y];
    }

    public final boolean isOutOfBounds(Position position) {
        return position.getX() < 0 || position.getX() >= map.length
                || position.getY() < 0 || position.getY() >= map[0].length;
    }

    public final boolean isOutOfBounds(int x, int y) {
        return x < 0 || x >= map.length || y < 0 || y >= map[0].length;
    }
}