package lutz.franz.jakob.presentation.gui;

import lutz.franz.jakob.gamelogic.Position;
import lutz.franz.jakob.presentation.UI;
import lutz.franz.jakob.presentation.graphics.Sprite;
import lutz.franz.jakob.presentation.gui.states.GUIState;
import lutz.franz.jakob.presentation.gui.states.PlayingState;

import javax.swing.JFrame;

public final class GUI extends JFrame implements UI {
    private static volatile GUI instance;
    private final Rendering rendering;
    private final Position camera;
    private GUIState state;
    public static final int RESCALE_FACTOR = 4, WIDTH = 11 * Sprite.SIZE, HEIGHT = 9 * Sprite.SIZE;

    private GUI() {
        camera = new Position(0,0);
        state = new PlayingState();
        rendering = new Rendering();

        setTitle("STS");
        setContentPane(rendering);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setIconImage(); TODO

        setVisible(true);
    }

    // TODO implement

    @Override
    public void updateGraphics() {
        repaint();
    }

    // setter

    public void setGUIState(GUIState state) {
        this.state = state;
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

    public Position getCamera() {
        return camera;
    }

    public GUIState getGUIState() {
        return state;
    }
}