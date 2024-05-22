package gamelogic;

import gamelogic.buildings.Building;
import gamelogic.maps.GameMap;
import gamelogic.nations.Nation;
import gamelogic.nations.Team;
import gamelogic.units.Unit;

import java.util.ArrayList;
import java.util.List;

import static gamelogic.nations.Team.*;

public final class GameHandler {
    private static volatile GameHandler instance;
    private final ArrayList<Nation> nations;
    private final ArrayList<Building> buildings;
    private final ArrayList<Unit> units;
    private GameMap map;
    private boolean loaded;

    private GameHandler() {
        nations = new ArrayList<>();
        nations.add(new Nation(TEAM_BLUE));
        nations.add(new Nation(TEAM_RED));
        buildings = new ArrayList<>();
        units = new ArrayList<>();
        map = null;
        loaded = false;
    }

    public void load(GameMap map) {
        if(loaded)
            return;

        this.map = map;
        buildings.addAll(List.of(this.map.getStartingBuildings()));
        units.addAll(List.of(this.map.getStartingUnits()));
        loaded = true;
    }

    public void endTurn() {
        for(Building b : buildings)
            b.update();

        for(Unit u : units)
            u.update();
    }

    // TODO  implement

    // getter

    public static GameHandler getInstance() {
        if(instance == null)
            synchronized (GameHandler.class) {
                if(instance == null)
                    instance = new GameHandler();
            }

        return instance;
    }

    public Nation getNation(Team team) {
        for(Nation n : nations)
            if(n.getTeam().equals(team))
                return n;

        return null;
    }

    public GameMap getMap() {
        return map;
    }

    public boolean isEntityAt(Position destination) {
        for(Building b : buildings)
            if(b.getPosition().equals(destination))
                return true;

        for(Unit u : units)
            if(u.getPosition().equals(destination))
                return true;

        return false;
    }
}