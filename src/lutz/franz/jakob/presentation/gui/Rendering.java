package lutz.franz.jakob.presentation.gui;

import lutz.franz.jakob.presentation.graphics.Sprite;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;

public final class Rendering extends JPanel {
    private final SpriteSet sprites;

    public Rendering() {
        setPanelSize();
        sprites = new SpriteSet("res/STS_atlas.png", Sprite.values().length);
    }


    private void setPanelSize() {
        Dimension size = new Dimension(GUI.WIDTH, GUI.HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    @Override
    public void paintComponents(Graphics g) {
        System.out.println("rendering (Rendering.paintComponents())"); // TODO remove debug
        GUI.getInstance().getGUIState().render(g, sprites);
    }

    @Override
    public void update(Graphics g) {
        System.out.println("rendering (Rendering)"); // TODO remove debug
        GUI.getInstance().getGUIState().render(g, sprites);
    }
}