package gamelogic;

import gamelogic.maps.GameMap;
import gamelogic.nations.Nation;
import gamelogic.nations.Team;

public final class GameHandler {
    private static volatile GameHandler instance;

    private GameHandler() {
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
        // TODO implement
    }

    public GameMap getMap() {
        // TODO implement
    }
}