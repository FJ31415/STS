package lutz.franz.jakob.ui.graphics.gui;

import lutz.franz.jakob.ui.UI;
import lutz.franz.jakob.ui.graphics.Sprite;

import javax.swing.*;

public class GUI extends JFrame implements UI {
    private static volatile GUI instance;
    private final Rendering rendering;
    public static final int RESCALE_FACTOR = 4, WIDTH = 10 * Sprite.SIZE, HEIGHT = 10 * Sprite.SIZE;

    private GUI() {
        rendering = new Rendering();
        setContentPane(rendering);

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