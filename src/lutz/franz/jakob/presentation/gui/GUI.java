package lutz.franz.jakob.presentation.gui;

import lutz.franz.jakob.gamelogic.Position;
import lutz.franz.jakob.presentation.UI;
import lutz.franz.jakob.presentation.graphics.Sprite;
import lutz.franz.jakob.presentation.gui.inputs.KeyboardInputListener;
import lutz.franz.jakob.presentation.gui.inputs.MouseInputListener;
import lutz.franz.jakob.presentation.gui.states.GUIState;
import lutz.franz.jakob.presentation.gui.states.PlayingState;

import javax.swing.JFrame;

public final class GUI extends JFrame implements UI {
    private static volatile GUI instance;
    private final Rendering rendering;
    private final KeyboardInputListener keyBoardListener;
    private final MouseInputListener mouseListener;

    private final Position camera;
    private GUIState state;
    public static final int RESCALE_FACTOR = 4,  MAP_RADIUS = 4, MAP_SIZE = 1 + 2 * MAP_RADIUS,
            WIDTH = (MAP_SIZE + 2) * Sprite.R_SIZE, HEIGHT = MAP_SIZE * Sprite.R_SIZE;

    private GUI() {
        camera = new Position(0,0);
        state = new PlayingState();

        rendering = new Rendering();
        add(rendering);
        pack();
        setTitle("STS");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // setIconImage(); TODO
        repaint();
        setVisible(true);

        keyBoardListener = new KeyboardInputListener();
        mouseListener = new MouseInputListener();
        addKeyListener(keyBoardListener);
        addMouseListener(mouseListener);
        requestFocus();
    }

    // TODO add inputListener

    @Override
    public void updateGraphics() {
        System.out.println("rendering (GUI)"); // TODO remove debug

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