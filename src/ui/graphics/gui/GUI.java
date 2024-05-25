package ui.graphics.gui;

import ui.UI;

import javax.swing.*;

public class GUI extends JFrame implements UI {
    private static volatile GUI instance;

    private GUI() {
        // TODO implement
    }

    // TODO implement

    @Override
    public void updateGraphics() {
        // TODO implement
    }

    // getter

    public static GUI getInstance() {
        if(instance == null)
            synchronized (GUI.class) {
                if(instance == null)
                    instance = new GUI();
            }

        return instance;
    }
}