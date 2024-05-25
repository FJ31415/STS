package lutz.franz.jakob.control;

import lutz.franz.jakob.gamelogic.GameHandler;
import lutz.franz.jakob.gamelogic.maps.SmallMap;
import lutz.franz.jakob.presentation.gui.GUI;
import lutz.franz.jakob.presentation.UI;

public final class Main {
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