package gamelogic;

import gamelogic.entity.GameEntity;
import gamelogic.maps.GameMap;
import gamelogic.nations.Nation;
import gamelogic.nations.Team;

import java.util.ArrayList;
import java.util.List;

import static gamelogic.nations.Team.*;

public final class GameHandler {
    private static volatile GameHandler instance;
    private final ArrayList<Nation> nations;
    private final ArrayList<GameEntity> entities;
    private GameMap map;
    private boolean loaded;

    private GameHandler() {
        nations = new ArrayList<>();
        nations.add(new Nation(TEAM_BLUE));
        nations.add(new Nation(TEAM_RED));
        entities = new ArrayList<>();
        map = null;
        loaded = false;
    }

    public void load(GameMap map) {
        if(loaded)
            return;

        this.map = map;
        entities.addAll(List.of(this.map.getBaseEntities()));

        loaded = true;
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

    public GameEntity getEntityAt(Position destination) {
        for(GameEntity e : entities)
            if(e.getPosition().equals(destination))
                return e;

        return null;
    }
}