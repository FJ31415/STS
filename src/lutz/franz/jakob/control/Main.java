package lutz.franz.jakob.control;

import lutz.franz.jakob.gamelogic.GameHandler;
import lutz.franz.jakob.gamelogic.maps.SmallMap;
import lutz.franz.jakob.ui.graphics.gui.GUI;
import lutz.franz.jakob.ui.UI;
import lutz.franz.jakob.ui.states.GameState;
import lutz.franz.jakob.ui.states.PlayingState;

public final class Main {
    private static Main instance;
    private final UI ui;
    private GameState state;

    public static void main(String[] args) {
        instance = new Main();
    }

    private Main() {
        // load
        GameHandler.getInstance().load(new SmallMap());
        ui = GUI.getInstance();
        state = new PlayingState();


        // start render-thread
        UpdatingThread renderThread = new UpdatingThread(2) {
            @Override
            protected void update() {
                ui.updateGraphics();
            }
        };


    }

    // setter

    public void setState(GameState state) {
        this.state = state;
    }


    // getter

    public static Main getInstance() {
        return instance;
    }

    public GameState getState() {
        return state;
    }
}