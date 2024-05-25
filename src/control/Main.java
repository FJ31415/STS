package control;

import gamelogic.GameHandler;
import gamelogic.maps.SmallMap;
import ui.graphics.gui.GUI;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        // load
        GameHandler.getInstance().load(new SmallMap());
        UI ui = GUI.getInstance();

        // start render-thread
        UpdatingThread renderThread = new UpdatingThread(2) {
            @Override
            protected void update() {
                ui.updateGraphics();
            }
        };
    }
}